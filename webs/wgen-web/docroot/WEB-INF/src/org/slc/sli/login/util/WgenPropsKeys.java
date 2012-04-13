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

package org.slc.sli.login.util;


public interface WgenPropsKeys {

	public static final String API_SERVER_URI = "sli.api.serveruri";

	public static final String SESSION_CHECK_URL = "sli.sessioncheck.url";
	
	public static final String GET_ROLES_URL = "sli.roles.url";
	
	public static final String SLI_COOKIE_DOMAIN = "sli.cookie.domain";
	
	public static final String WGEN_SSO_FILTER = "org.slc.sli.login.servlet.filters.sso.wgensso.WgenSSOFilter";
	
	public static final String WGEN_SSO_LOGOUT_ON_SESSION_EXPIRATION = "wgen.sso.logout.on.session.expiration";

	public static final String ROLE_IT_ADMINISTRATOR = "wgen.role.itadmin";
	
	public static final String ROLE_SLI_ADMINISTRATOR = "wgen.role.sliadmin";

	public static final String ROLE_EDUCATOR = "wgen.role.educator";
	
	public static final String OAUTH_CLIENT = "oauth.client.secret";
	
	
}