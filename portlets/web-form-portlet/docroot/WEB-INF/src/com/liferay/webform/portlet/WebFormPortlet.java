/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.webform.portlet;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.expando.model.ExpandoRow;
import com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.webform.util.WebFormUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.InternetAddress;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * @author Daniel Weisser
 * @author Jorge Ferrer
 * @author Alberto Montero
 * @author Julio Camarero
 * @author Brian Wing Shun Chan
 */
public class WebFormPortlet extends MVCPortlet {

	public void deleteData(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
 

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);

		String databaseTableName = preferences.getValue(
			"databaseTableName", StringPool.BLANK);

		if (Validator.isNotNull(databaseTableName)) {
			ExpandoTableLocalServiceUtil.deleteTable(
				themeDisplay.getCompanyId(), WebFormUtil.class.getName(),
				databaseTableName);
		}
	}

	public void saveData(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {
		
	 

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletId = (String)resourceRequest.getAttribute(
			WebKeys.PORTLET_ID);
			
		String tempURL = ParamUtil.getString(resourceRequest, "referUrl");
	 	String tempUsrName = ParamUtil.getString(resourceRequest, "usrName");
		String tempScreenName = ParamUtil.getString(resourceRequest, "screenName");
		String tempUsrDateStamp = ParamUtil.getString(resourceRequest, "dateStamp");
		String tempSuccess = ParamUtil.getString(resourceRequest, "successURL");
			System.out.println(">>>>>>>>>>>>>>>>>"+tempSuccess);
	 

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(
				resourceRequest, portletId);
	 
		preferences.setValue("tempURL", tempURL);
		preferences.setValue("tempUsrName",tempUsrName);
		preferences.setValue("tempUsrDateStamp", tempUsrDateStamp);
		preferences.setValue("tempScreenName", tempScreenName);
		preferences.setValue("successURL", tempSuccess); 
		
		boolean requireCaptcha = GetterUtil.getBoolean(
			preferences.getValue("requireCaptcha", StringPool.BLANK));
		String successURL = GetterUtil.getString(
			preferences.getValue("successURL", StringPool.BLANK));
			System.out.println(">>>>>>>>>>>>>>>>>"+successURL);
		boolean sendAsEmail = GetterUtil.getBoolean(
			preferences.getValue("sendAsEmail", StringPool.BLANK));
		boolean saveToDatabase = GetterUtil.getBoolean(
			preferences.getValue("saveToDatabase", StringPool.BLANK));
		String databaseTableName = GetterUtil.getString(
			preferences.getValue("databaseTableName", StringPool.BLANK));
		boolean saveToFile = GetterUtil.getBoolean(
			preferences.getValue("saveToFile", StringPool.BLANK));
		String fileName = GetterUtil.getString(
			preferences.getValue("fileName", StringPool.BLANK));
		 
		 	

		if (requireCaptcha) {
			try {
				CaptchaUtil.check(resourceRequest);
			}
			catch (CaptchaTextException cte) {
				SessionErrors.add(
					resourceRequest, CaptchaTextException.class.getName());

				return;
			}
		}

		Map<String,String> fieldsMap = new LinkedHashMap<String,String>();

		for (int i = 1; true; i++) {
			String fieldLabel = preferences.getValue(
				"fieldLabel" + i, StringPool.BLANK);

			if (Validator.isNull(fieldLabel)) {
				break;
			}

			fieldsMap.put(fieldLabel, resourceRequest.getParameter("field" + i));
		}

		Set<String> validationErrors = null;

		try {
			validationErrors = validate(fieldsMap, preferences);
		}
		catch (Exception e) {
			SessionErrors.add(
				resourceRequest, "validation-script-error",
				e.getMessage().trim());

			return;
		}

		if (validationErrors.isEmpty()) {
			boolean emailSuccess = true;
			boolean databaseSuccess = true;
			boolean fileSuccess = true;

			if (sendAsEmail) {
				emailSuccess = sendEmail(fieldsMap, preferences);
			}

			if (saveToDatabase) {
				if (Validator.isNull(databaseTableName)) {
					databaseTableName = WebFormUtil.getNewDatabaseTableName(
						portletId);

					preferences.setValue(
						"databaseTableName", databaseTableName);

					preferences.store();
				}

				databaseSuccess = saveDatabase(
					themeDisplay.getCompanyId(), fieldsMap, preferences,
					databaseTableName);
			}

			if (saveToFile) {
				fileSuccess = saveFile(fieldsMap, fileName);
			}

			if (emailSuccess && databaseSuccess && fileSuccess) {
				SessionMessages.add(resourceRequest, "success");
			}
			else {
				SessionErrors.add(resourceRequest, "error");
			}
		}
		else {
			for (String badField : validationErrors) {
				SessionErrors.add(resourceRequest, "error" + badField);
			}
		}

		if (SessionErrors.isEmpty(resourceRequest) &&
			Validator.isNotNull(successURL)) {
			System.out.println(">>>>>>>>>>>>>>>>>!!!update d"+successURL);
			getPortletContext().getRequestDispatcher(resourceResponse.encodeURL("/success.jsp")).include(resourceRequest, resourceResponse);
		}
	}

	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
 
		String cmd = ParamUtil.getString(resourceRequest, Constants.CMD);

		try {
			if (cmd.equals("captcha")) {
				serveCaptcha(resourceRequest, resourceResponse);
			}
			else if (cmd.equals("export")) {
				exportData(resourceRequest, resourceResponse);
			}else if (cmd.equals("saveData")) {
				saveData(resourceRequest, resourceResponse);
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	protected void exportData(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {
 
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletPreferences preferences =
			PortletPreferencesFactoryUtil.getPortletSetup(resourceRequest);

		String databaseTableName = preferences.getValue(
			"databaseTableName", StringPool.BLANK);
		String title = preferences.getValue("title", "no-title");

		StringBuilder sb = new StringBuilder();

		List<String> fieldLabels = new ArrayList<String>();

		for (int i = 1; true; i++) {
			String fieldLabel = preferences.getValue(
				"fieldLabel" + i, StringPool.BLANK);

			String localizedfieldLabel = LocalizationUtil.getPreferencesValue(
				preferences, "fieldLabel" + i, themeDisplay.getLanguageId());

			if (Validator.isNull(fieldLabel)) {
				break;
			}

			fieldLabels.add(fieldLabel);

			sb.append("\"");
			sb.append(localizedfieldLabel.replaceAll("\"", "\\\""));
			sb.append("\";");
		}

		sb.deleteCharAt(sb.length() - 1);
		sb.append("\n");

		if (Validator.isNotNull(databaseTableName)) {
			List<ExpandoRow> rows = ExpandoRowLocalServiceUtil.getRows(
				themeDisplay.getCompanyId(), WebFormUtil.class.getName(),
				databaseTableName, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (ExpandoRow row : rows) {
				for (String fieldName : fieldLabels) {
					String data = ExpandoValueLocalServiceUtil.getData(
						themeDisplay.getCompanyId(),
						WebFormUtil.class.getName(), databaseTableName,
						fieldName, row.getClassPK(), StringPool.BLANK);

					data = data.replaceAll("\"", "\\\"");

					sb.append("\"");
					sb.append(data);
					sb.append("\";");
				}

				sb.deleteCharAt(sb.length() - 1);
				sb.append("\n");
			}
		}

		String fileName = title + ".csv";
		byte[] bytes = sb.toString().getBytes();
		String contentType = ContentTypes.APPLICATION_TEXT;

		PortletResponseUtil.sendFile(
			resourceResponse, fileName, bytes, contentType);
	}

	protected String getMailBody(Map<String,String> fieldsMap) {
	 
		StringBuilder sb = new StringBuilder();

		for (String fieldLabel : fieldsMap.keySet()) {
			String fieldValue = fieldsMap.get(fieldLabel);

			sb.append(fieldLabel);
			sb.append(" : ");
			sb.append(fieldValue);
			sb.append("\n");
		}

		return sb.toString();
	}

	protected boolean saveDatabase(
			long companyId, Map<String,String> fieldsMap,
			PortletPreferences preferences, String databaseTableName)
		throws Exception {
 
		WebFormUtil.checkTable(companyId, databaseTableName, preferences);

		long classPK = CounterLocalServiceUtil.increment(
			WebFormUtil.class.getName());

		try {
			for (String fieldLabel : fieldsMap.keySet()) {
				String fieldValue = fieldsMap.get(fieldLabel);

				ExpandoValueLocalServiceUtil.addValue(
					companyId, WebFormUtil.class.getName(), databaseTableName,
					fieldLabel, classPK, fieldValue);
			}

			return true;
		}
		catch (Exception e) {
			_log.error(
				"The web form data could not be saved to the database", e);

			return false;
		}
	}

	protected boolean saveFile(Map<String,String> fieldsMap, String fileName) {
 
		// Save the file as a standard Excel CSV format. Use ; as a delimiter,
		// quote each entry with double quotes, and escape double quotes in
		// values a two double quotes.

		StringBuilder sb = new StringBuilder();

		for (String fieldLabel : fieldsMap.keySet()) {
			String fieldValue = fieldsMap.get(fieldLabel);

			sb.append("\"");
			sb.append(StringUtil.replace(fieldValue, "\"", "\"\""));
			sb.append("\";");
		}

		String s = sb.substring(0, sb.length() - 1) + "\n";

		try {
			FileUtil.write(fileName, s, false, true);

			return true;
		}
		catch (Exception e) {
			_log.error("The web form data could not be saved to a file", e);

			return false;
		}
	}

	protected boolean sendEmail(
		Map<String,String> fieldsMap, PortletPreferences preferences) {
 
		try {
			String subject = preferences.getValue("subject", StringPool.BLANK);
			String emailAddress = preferences.getValue(
				"emailAddress", StringPool.BLANK);

			if (Validator.isNull(emailAddress)) {
				_log.error(
					"The web form email cannot be sent because no email " +
						"address is configured");

				return false;
			}

			
		String body="Dear Administrator: \n"+"\nA user in your school(s) or district has reported the following problem:\n\nUser Name : "+preferences.getValue("tempUsrName" ,StringPool.BLANK)+"\nScreen Name : "+preferences.getValue("tempScreenName",StringPool.BLANK);
body+="\n"+getMailBody(fieldsMap);
body+="URL : "+preferences.getValue("tempURL",StringPool.BLANK)+"\nDate : "+preferences.getValue("tempUsrDateStamp",StringPool.BLANK)+"\nThis email has been automatically generated by the SLC.PLEASE DO NOT RESPOND TO THIS EMAIL.\n\nYours,\nSLC Operations TeamURL";
 
			 
			InternetAddress fromAddress = null;

			try {
				String smtpUser = PropsUtil.get(
					PropsKeys.MAIL_SESSION_MAIL_SMTP_USER);

				if (Validator.isNotNull(smtpUser)) {
					fromAddress = new InternetAddress(smtpUser);
				}
			}
			catch (Exception e) {
				_log.error(e, e);
			}

			if (fromAddress == null) {
				fromAddress = new InternetAddress(emailAddress);
			}

			InternetAddress toAddress = new InternetAddress(emailAddress);

			MailMessage mailMessage = new MailMessage(
				fromAddress, toAddress, subject, body, false);

			MailServiceUtil.sendEmail(mailMessage);

			return true;
		}
		catch (Exception e) {
			_log.error("The web form email could not be sent", e);

			return false;
		}
	}

	protected void serveCaptcha(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		CaptchaUtil.serveImage(resourceRequest, resourceResponse);
	}

	protected Set<String> validate(
			Map<String,String> fieldsMap, PortletPreferences preferences)
		throws Exception {
 
		Set<String> validationErrors = new HashSet<String>();

		for (int i = 0; i < fieldsMap.size(); i++) {
			String fieldType = preferences.getValue(
				"fieldType" + (i + 1), StringPool.BLANK);
			String fieldLabel = preferences.getValue(
				"fieldLabel" + (i + 1), StringPool.BLANK);
			String fieldValue = fieldsMap.get(fieldLabel);

			boolean fieldOptional = GetterUtil.getBoolean(
				preferences.getValue(
					"fieldOptional" + (i + 1), StringPool.BLANK));

			if (Validator.equals(fieldType, "paragraph")) {
				continue;
			}

			if (!fieldOptional && Validator.isNotNull(fieldLabel) &&
				Validator.isNull(fieldValue)) {

				validationErrors.add(fieldLabel);

				continue;
			}

			String validationScript = GetterUtil.getString(
				preferences.getValue(
					"fieldValidationScript" + (i + 1), StringPool.BLANK));

			if (Validator.isNotNull(validationScript) &&
				!WebFormUtil.validate(
					fieldValue, fieldsMap, validationScript)) {

				validationErrors.add(fieldLabel);

				continue;
			}
		}

		return validationErrors;
	}

	private static Log _log = LogFactoryUtil.getLog(WebFormPortlet.class);

}