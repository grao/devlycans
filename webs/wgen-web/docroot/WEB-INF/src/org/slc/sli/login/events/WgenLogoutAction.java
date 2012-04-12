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

package org.slc.sli.login.events;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  org.slc.sli.login.util.WgenConstants;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import org.slc.sli.login.util.WgenPropsKeys;
/**
 * @author 
 */
public class WgenLogoutAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) {
		try {
			boolean filterEnabled = GetterUtil.getBoolean(PropsUtil.get(WgenPropsKeys.WGEN_SSO_FILTER));

			if (!filterEnabled) {
				return;
			}
			Cookie openAmCookie = new Cookie(WgenConstants.OPENAM_COOKIE_NAME, "");
			openAmCookie.setDomain(GetterUtil.getString(PropsUtil.get(WgenPropsKeys.SLI_COOKIE_DOMAIN)));
			openAmCookie.setMaxAge(0);
			openAmCookie.setValue("");  
			openAmCookie.setPath(StringPool.SLASH);
			response.addCookie(openAmCookie);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		WgenLogoutAction.class);

}