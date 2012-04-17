package org.slc.sli.util;

import com.liferay.portal.kernel.util.Validator;
import java.util.List;
import org.slc.sli.login.json.bean.UserData;
import org.slc.sli.util.WgenPropsValues;

/**
 * WgenUtil.java
 * 
 * Purpose: Utility methods used in the project.
 * 
 * @author
 * @version 1.0
 */

public class WgenUtil {

	/**
	 * this method is used to check if the user is a sli admin user
	 */
	public static boolean isAdmin(UserData userdata) {
		boolean isAdmin = false;
		if (Validator.isNotNull(userdata)) {
			String[] granted_authorities = userdata.getGranted_authorities();
			for (String role : granted_authorities) {
				if (role.equalsIgnoreCase(WgenPropsValues.ROLE_IT_ADMINISTRATOR)
						|| role.equalsIgnoreCase(WgenPropsValues.ROLE_SLI_ADMINISTRATOR)) {
					isAdmin = true;
					break;
				}
			}
		}
		return isAdmin;
	}
}