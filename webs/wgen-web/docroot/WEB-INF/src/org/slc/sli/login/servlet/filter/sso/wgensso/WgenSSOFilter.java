package org.slc.sli.login.servlet.filter.sso.wgensso;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slc.sli.login.servlet.filter.BasePortalFilter;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.slc.sli.security.SliApi;
import org.slc.sli.util.PortletPropsValues;
import org.slc.sli.util.WgenPropsValues;

/**
 * WgenSSOFilter.java Purpose: This filter is invoked when the user logs in to
 * liferay portal.
 * 
 * @author
 * @version 1.0
 */

public class WgenSSOFilter extends BasePortalFilter {

	private static final String OAUTH_TOKEN = "OAUTH_TOKEN";
	private static final String ENTRY_URL = "ENTRY_URL";

	/**
	 * Checks if the liferay has to use sli login authentication to log in to
	 * liferay
	 * 
	 */
	@Override
	public boolean isFilterEnabled(HttpServletRequest request,
			HttpServletResponse response) {

		// check for wgenfilter property enabled
		// check if the session check url is not null
		// check if the session check rest api is accesseble - can be removed
		// not needed in prod

		try {
			if (WgenPropsValues.WGEN_SSO_FILTER
					&& Validator.isNotNull(PortletPropsValues.API_SERVER_URL)) {
				return true;
			}
		} catch (Exception e) {
			_log.error(e, e);
		}

		return false;
	}

	/**
	 * Invokes the idp url for selection of realm and after logged in with open
	 * am redirects back to liferay
	 * 
	 */
	@Override
	protected void processFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws Exception {

		String loginUrl = "";

		boolean authenticated = false;

		try {
			authenticated = WgenSSOUtil.isAuthenticated(request);
		} catch (Exception e) {
			_log.error(e, e);
			processFilter(WgenSSOFilter.class, request, response, filterChain);
			return;
		}

		if (authenticated) {
			processFilter(WgenSSOFilter.class, request, response, filterChain);
			return;
		}

		// if not authenticated flow comes here redirects to idp url

		HttpSession session = request.getSession();
		SliApi.setBaseUrl(WgenSSOUtil.getApiUrl());
		OAuthService service = new ServiceBuilder().provider(SliApi.class)
				.apiKey(WgenSSOUtil.getClientId())
				.apiSecret(WgenSSOUtil.getClientSecret())
				.callback(WgenSSOUtil.getCallbackUrl()).build();

		Object token = session.getAttribute(OAUTH_TOKEN);

		if (session.getAttribute(OAUTH_TOKEN) == null
				&& request.getParameter("code") != null) {
			Verifier verifier = new Verifier(request.getParameter("code"));
			Token accessToken = service.getAccessToken(null, verifier);
			_log.info("token is ......" + accessToken);
			session.setAttribute(OAUTH_TOKEN, accessToken.getToken());
			Object entryUrl = session.getAttribute(ENTRY_URL);
			if (entryUrl != null) {
				response.sendRedirect(session.getAttribute(ENTRY_URL)
						.toString());
			} else {
				response.sendRedirect(request.getRequestURI());
			}
		} else if (session.getAttribute(OAUTH_TOKEN) == null) {
			session.setAttribute(ENTRY_URL, request.getRequestURL());
			// The request token doesn't matter for OAuth 2.0 which is why it's
			// null
			String authUrl = service.getAuthorizationUrl(null);
			response.sendRedirect(authUrl);
		} else {
			// LOG.debug("Using access token " + token);
			// addAuthentication((String) token);
			response.sendRedirect(request.getRequestURI());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(WgenSSOFilter.class);

}