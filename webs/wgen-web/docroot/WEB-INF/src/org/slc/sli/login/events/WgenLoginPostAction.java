package org.slc.sli.login.events;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slc.sli.login.json.bean.UserData;
import org.slc.sli.util.WgenUtil;
import org.slc.sli.util.Constants;
import org.slc.sli.util.WgenPropsValues;

/**
 * WgenLoginPostAction.java
 * 
 * Purpose: This class is called automatically every time when a user logged in
 * to liferay. Responsible for mapping the SLI roles with Liferay roles
 * 
 * @author
 * @version 1.0
 */

public class WgenLoginPostAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) {

		try {
			HttpSession session = request.getSession();

			User user = (User) session.getAttribute(WebKeys.USER);

			UserData userData = (UserData) session
					.getAttribute(Constants.USER_DATA);

			boolean isAdmin = WgenUtil.isAdmin(userData);

			long companyId = PortalUtil.getCompanyId(request);

			Role sliAdminRole = RoleLocalServiceUtil.getRole(companyId,
					WgenPropsValues.ROLE_SLI_ADMINISTRATOR);

			Role sliEducatorRole = RoleLocalServiceUtil.getRole(companyId,
					WgenPropsValues.ROLE_EDUCATOR);

			long[] adminRoleIds = { sliAdminRole.getRoleId() };

			long[] educatorRoleIds = { sliEducatorRole.getRoleId() };

			if (isAdmin) {
				if (!RoleLocalServiceUtil.hasUserRole(user.getUserId(),
						sliAdminRole.getRoleId())) {
					RoleLocalServiceUtil.addUserRoles(user.getUserId(),
							adminRoleIds);
					if (_log.isDebugEnabled()) {
						_log.debug("Adding SLI Admin role ");
					}
				}
			} else {
				if (!RoleLocalServiceUtil.hasUserRole(user.getUserId(),
						sliEducatorRole.getRoleId())) {
					RoleLocalServiceUtil.addUserRoles(user.getUserId(),
							educatorRoleIds);
					if (_log.isDebugEnabled()) {
						_log.debug("Adding Educator role ");
					}
				}
			}

		} catch (Exception e) {
			_log.error(e, e);
		}

	}

	private static Log _log = LogFactoryUtil.getLog(WgenLoginPostAction.class);

}