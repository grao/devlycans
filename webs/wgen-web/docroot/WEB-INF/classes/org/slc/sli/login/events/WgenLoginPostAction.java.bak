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
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.util.PortalUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import org.slc.sli.json.bean.UserData;
import org.slc.sli.login.util.WgenUtil;
import org.slc.sli.login.util.WgenPropsKeys;
import org.slc.sli.login.util.WgenConstants;

import com.liferay.portal.service.RoleLocalServiceUtil;

/**
 * @author 
 */

public class WgenLoginPostAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) {

		try {
			HttpSession session = request.getSession();

			User user = (User)session.getAttribute(WebKeys.USER);

			UserData userData = (UserData) session.getAttribute(WgenConstants.USER_DATA);

			boolean isAdmin = WgenUtil.isAdmin(userData);
			
			long companyId = PortalUtil.getCompanyId(request);
			
			Role sliAdminRole = RoleLocalServiceUtil.getRole(companyId,GetterUtil.getString(PropsUtil.get(WgenPropsKeys.ROLE_SLI_ADMINISTRATOR)));

			Role sliEducatorRole = RoleLocalServiceUtil.getRole(companyId,GetterUtil.getString(PropsUtil.get(WgenPropsKeys.ROLE_EDUCATOR)));

			long[] adminRoleIds={sliAdminRole.getRoleId()};

			long[] educatorRoleIds={sliEducatorRole.getRoleId()};
			
			if(isAdmin){
				if(!RoleLocalServiceUtil.hasUserRole(user.getUserId(),sliAdminRole.getRoleId())){
					RoleLocalServiceUtil.addUserRoles(user.getUserId(),adminRoleIds);
				}
			}
			else{
				if(!RoleLocalServiceUtil.hasUserRole(user.getUserId(),sliEducatorRole.getRoleId())){
					RoleLocalServiceUtil.addUserRoles(user.getUserId(),educatorRoleIds);
				}
			}
			
		}
		catch (Exception e) {
			_log.error(e, e);
		}

	}


	private static Log _log = LogFactoryUtil.getLog(WgenLoginPostAction.class);

}