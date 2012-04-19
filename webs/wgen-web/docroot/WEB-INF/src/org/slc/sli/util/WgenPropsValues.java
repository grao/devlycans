package org.slc.sli.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import org.slc.sli.util.WgenPropsKeys;

/**
 * WgenPropsValues.java
 * 
 * Purpose: Portal property values defined in portal.properties.
 * 
 * @author
 * @version 1.0
 */

public class WgenPropsValues {

	public static final String GET_ROLES_URL = GetterUtil.getString(PropsUtil
			.get(WgenPropsKeys.GET_ROLES_URL));

	public static final boolean WGEN_SSO_FILTER = GetterUtil
			.getBoolean(PropsUtil.get(WgenPropsKeys.WGEN_SSO_FILTER));

	public static final boolean WGEN_SSO_LOGOUT_ON_SESSION_EXPIRATION = GetterUtil
			.getBoolean(PropsUtil
					.get(WgenPropsKeys.WGEN_SSO_LOGOUT_ON_SESSION_EXPIRATION));

	public static final String ROLE_IT_ADMINISTRATOR = GetterUtil
			.getString(PropsUtil.get(WgenPropsKeys.ROLE_IT_ADMINISTRATOR));

	public static final String ROLE_SLI_ADMINISTRATOR = GetterUtil
			.getString(PropsUtil.get(WgenPropsKeys.ROLE_SLI_ADMINISTRATOR));

	public static final String ROLE_EDUCATOR = GetterUtil.getString(PropsUtil
			.get(WgenPropsKeys.ROLE_EDUCATOR));

}
