package org.slc.sli.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import org.slc.sli.util.PropsKeys;

/**
 * PropsValues.java
 * 
 * Purpose: Portal property values defined in portal.properties.
 * 
 * @author
 * @version 1.0
 */

public class PropsValues {

	public static final boolean WGEN_SSO_FILTER = GetterUtil
			.getBoolean(PropsUtil.get(PropsKeys.WGEN_SSO_FILTER));

	public static final boolean WGEN_SSO_LOGOUT_ON_SESSION_EXPIRATION = GetterUtil
			.getBoolean(PropsUtil
					.get(PropsKeys.WGEN_SSO_LOGOUT_ON_SESSION_EXPIRATION));

	public static final String ROLE_IT_ADMINISTRATOR = GetterUtil
			.getString(PropsUtil.get(PropsKeys.ROLE_IT_ADMINISTRATOR));

	public static final String ROLE_SLI_ADMINISTRATOR = GetterUtil
			.getString(PropsUtil.get(PropsKeys.ROLE_SLI_ADMINISTRATOR));

	public static final String ROLE_EDUCATOR = GetterUtil.getString(PropsUtil
			.get(PropsKeys.ROLE_EDUCATOR));

	public static final String API_SERVER_URL = GetterUtil.getString(PropsUtil
			.get(PropsKeys.API_SERVER_URL));

	public static final String SECURITY_SERVER_URL = GetterUtil
			.getString(PropsUtil.get(PropsKeys.SECURITY_SERVER_URL));

	public static final String OAUTH_CLIENT_ID = GetterUtil.getString(PropsUtil
			.get(PropsKeys.OAUTH_CLIENT_ID));

	public static final String OAUTH_CLIENT_SECRET = GetterUtil
			.getString(PropsUtil.get(PropsKeys.OAUTH_CLIENT_SECRET));

	public static final String OAUTH_REDIRECT = GetterUtil.getString(PropsUtil
			.get(PropsKeys.OAUTH_REDIRECT));

}
