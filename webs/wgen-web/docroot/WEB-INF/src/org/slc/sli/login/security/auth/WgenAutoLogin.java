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
import com.liferay.portal.security.auth.AutoLogin;
import com.liferay.portal.security.auth.AutoLoginException;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slc.sli.login.servlet.filter.sso.wgensso.WgenSSOUtil;

import org.slc.sli.login.json.bean.UserData;
import org.slc.sli.util.PropsKeys;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * WgenAutoLogin.java Purpose: Login to Liferay portal automatically, creates
 * user if the logged in user doesnot exisit in liferay
 * 
 * @author
 * @version 1.0
 */

public class WgenAutoLogin implements AutoLogin {

	public String[] login(HttpServletRequest request,
			HttpServletResponse response) {

		String[] credentials = null;
		boolean isauthenticated = false;

		boolean filterEnabled = GetterUtil.getBoolean(PropsUtil.get(PropsKeys.WGEN_SSO_FILTER));

		//String serverURL = GetterUtil.getString(PropsUtil.get(PropsKeys.API_SERVER_URL));

		try {
			long companyId = PortalUtil.getCompanyId(request);

			// return if filter not enabled
			if (!filterEnabled) {
				return credentials;
			}

			isauthenticated = WgenSSOUtil.isAuthenticated(request);

			// return if authentication is false
			if (!isauthenticated) {
				return credentials;
			}

			User user = null;

			UserData userData = WgenSSOUtil.getUserDetails(request);

			try {
				if (Validator.isNull(userData.getUser_id())) {
					throw new AutoLoginException("Screen name is null");
				}
				user = UserLocalServiceUtil.getUserByScreenName(companyId,
						WgenSSOUtil.convertScreenName(userData.getUser_id()));

				if (_log.isDebugEnabled()) {
					_log.debug("User already exist " + userData.getUser_id());
				}
			} catch (NoSuchUserException nsue) {
			}

			if (user == null) {
				ThemeDisplay themeDisplay = (ThemeDisplay) request
						.getAttribute(WebKeys.THEME_DISPLAY);

				Locale locale = LocaleUtil.getDefault();

				if (themeDisplay != null) {
					locale = themeDisplay.getLocale();
				}

				if (_log.isDebugEnabled()) {
					_log.debug("Adding user " + userData.getUser_id());
				}

				user = addUser(companyId, userData.getFull_name(),
						WgenSSOUtil.convertScreenName(userData.getUser_id()),
						locale);

				String redirect = ParamUtil.getString(request, "redirect");

				if (Validator.isNotNull(redirect)) {
					request.setAttribute(AutoLogin.AUTO_LOGIN_REDIRECT,
							redirect);
				}
			}
			credentials = new String[3];
			credentials[0] = String.valueOf(user.getUserId());
			credentials[1] = user.getPassword();
			credentials[2] = Boolean.TRUE.toString();
		} catch (Exception e) {
			_log.error(e, e);
		}
		return credentials;
	}

	/**
	 * Add user
	 * 
	 * @param companyId
	 * 
	 * @return User
	 * @throws Exception
	 */
	protected User addUser(long companyId, String firstName, String screenName,
			Locale locale) throws Exception {

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

		String emailAddress = StringPool.BLANK;
		String lastName = StringPool.BLANK;

		ServiceContext serviceContext = new ServiceContext();

		return UserLocalServiceUtil.addUser(creatorUserId, companyId,
				autoPassword, password1, password2, autoScreenName, screenName,
				emailAddress, facebookId, openId, locale, firstName,
				middleName, lastName, prefixId, suffixId, male, birthdayMonth,
				birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
				roleIds, userGroupIds, sendEmail, serviceContext);
	}

	private static Log _log = LogFactoryUtil.getLog(WgenAutoLogin.class);

}