package org.slc.sli.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * PortletPropsValues.java
 * 
 * Purpose: portlet property values.
 * 
 * @author
 * @version 1.0
 */

public class PortletPropsValues {

	public static final String API_SERVER_URL = PortletProps
			.get(PortletPropsKeys.API_SERVER_URL);

	public static final String SECURITY_SERVER_URL = PortletProps
			.get(PortletPropsKeys.SECURITY_SERVER_URL);

	public static final String OAUTH_CLIENT_ID = PortletProps
			.get(PortletPropsKeys.OAUTH_CLIENT_ID);

	public static final String OAUTH_CLIENT_SECRET = PortletProps
			.get(PortletPropsKeys.OAUTH_CLIENT_SECRET);

	public static final String OAUTH_REDIRECT = PortletProps
			.get(PortletPropsKeys.OAUTH_REDIRECT);

}