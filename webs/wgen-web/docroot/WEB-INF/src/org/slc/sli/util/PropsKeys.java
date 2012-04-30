package org.slc.sli.util;

/**
 * PropsKeys.java
 * 
 * Purpose: Portal property keys defined in portal.properties.
 * 
 * @author
 * @version 1.0
 */
public interface PropsKeys {

	public static final String WGEN_SSO_FILTER = "org.slc.sli.login.servlet.filter.sso.wgensso.WgenSSOFilter";

	public static final String WGEN_SSO_LOGOUT_ON_SESSION_EXPIRATION = "wgen.sso.logout.on.session.expiration";

	public static final String ROLE_IT_ADMINISTRATOR = "wgen.role.itadmin";

	public static final String ROLE_SLI_ADMINISTRATOR = "wgen.role.sliadmin";

	public static final String ROLE_EDUCATOR = "wgen.role.educator";
	
	public static final String API_SERVER_URL = "api.server.url";

	public static final String SECURITY_SERVER_URL = "security.server.url";

	public static final String OAUTH_CLIENT_ID = "oauth.client.id";

	public static final String OAUTH_CLIENT_SECRET = "oauth.client.secret";

	public static final String OAUTH_REDIRECT = "oauth.redirect";	

}