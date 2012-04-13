/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package org.slc.sli.login.security.auth;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.util.ParamUtil;

import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.PwdGenerator;


import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.security.auth.AutoLogin;
import com.liferay.portal.security.auth.AutoLoginException;

import  org.slc.sli.login.servlet.filters.sso.wgensso.WgenSSOUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import org.slc.sli.login.util.WgenPropsKeys;
import org.slc.sli.json.bean.UserData;


/**
 * @author 
 */

public class WgenAutoLogin implements AutoLogin {

	public String[] login(
		HttpServletRequest request, HttpServletResponse response) {

		String[] credentials = null;
		boolean isauthenticated= false;

		boolean filterEnabled = GetterUtil.getBoolean(PropsUtil.get(WgenPropsKeys.WGEN_SSO_FILTER));
		
		String serverURL = GetterUtil.getString(PropsUtil.get(WgenPropsKeys.API_SERVER_URI));
		
		try{
			long companyId = PortalUtil.getCompanyId(request);

			//return if filter not enabled
			if (!filterEnabled && !Validator.isNotNull(serverURL)) {
				return credentials;
			}

			isauthenticated = WgenSSOUtil.isAuthenticated(request);

			//return if authentication is false
			if (!isauthenticated) {
				return credentials;
			}

			User user = null;

			UserData userData = WgenSSOUtil.getUserDetails(request);

			try {
				if (Validator.isNull(userData.getUser_id())) {
					throw new AutoLoginException("Screen name is null");
				}
				user = UserLocalServiceUtil.getUserByScreenName(
					companyId, WgenSSOUtil.convertScreenName(userData.getUser_id()));
			}
			catch (NoSuchUserException nsue) {
			}

			if (user == null) {
				ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
					WebKeys.THEME_DISPLAY);

				Locale locale = LocaleUtil.getDefault();

				if (themeDisplay != null) {
					locale = themeDisplay.getLocale();
				}

				if (_log.isDebugEnabled()) {
					_log.debug("Adding user "+userData.getUser_id());
				}

				user = addUser(
					companyId, userData.getFull_name(),WgenSSOUtil.convertScreenName(userData.getUser_id()),locale);

				String redirect = ParamUtil.getString(request, "redirect");
				
				if (Validator.isNotNull(redirect)) {
					request.setAttribute(AutoLogin.AUTO_LOGIN_REDIRECT, redirect);
				}
			}
				credentials = new String[3];
				credentials[0] = String.valueOf(user.getUserId());
				credentials[1] = user.getPassword();
				credentials[2] = Boolean.TRUE.toString();
		}catch(Exception e){
			_log.error(e, e);
		}
		return credentials;
	}

	protected User addUser(
			long companyId, String firstName,
			String screenName, Locale locale)
		throws Exception {

		long creatorUserId = 0;
		boolean autoPassword = true;
		String password1 = PwdGenerator.getPassword();
		String password2 = password1;
		boolean autoScreenName = false;
		long facebookId = 0;
		String openId = StringPool.BLANK;
		String middleName = StringPool.BLANK;
		int prefixId = 0;
		int suffixId = 0;
		boolean male = true;
		int birthdayMonth = Calendar.JANUARY;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = StringPool.BLANK;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = false;

		String emailAddress=StringPool.BLANK;
		String lastName=StringPool.BLANK;

		ServiceContext serviceContext = new ServiceContext();

		return UserLocalServiceUtil.addUser(
			creatorUserId, companyId, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
	}

	private static Log _log = LogFactoryUtil.getLog(WgenAutoLogin.class);

}