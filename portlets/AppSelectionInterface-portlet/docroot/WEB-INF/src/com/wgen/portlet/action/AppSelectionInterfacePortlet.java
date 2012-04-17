package com.wgen.portlet.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;

import org.slc.sli.json.bean.AppsData;
import org.slc.sli.util.AppsUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.wgen.util.PortletPropsValues;

/**
 * Portlet implementation class AppSelectionInterfacePortlet
 */
public class AppSelectionInterfacePortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		HttpSession session = PortalUtil.getHttpServletRequest(renderRequest)
				.getSession(false);

		String tokenFromReq = (String) session.getAttribute("OAUTH_TOKEN");

		_log.info(tokenFromReq);
		// String token = "e88cb6d1-771d-46ac-a207-2e58d7f12196";

		List<AppsData> appsData = AppsUtil.getUserApps(tokenFromReq);

		renderRequest.setAttribute("appList", appsData);

		super.render(renderRequest, renderResponse);
	}

	/**
	 * <b> This method process wsrl action and opens wsrp page with appropriate wsrp portlet</b>
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	
	@ProcessAction(name = "openwsrppage")
	public void processWsrpAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		String url = actionRequest.getParameter("url");
		actionResponse.setEvent(new QName("http:wgen.com/events", "wsrpurl"),
				url);

		String wsrpPage = PortletPropsValues.WSRP_PAGE;
		//Hide default success Message
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		actionResponse.sendRedirect(wsrpPage);
	}

	/**
	 * <b> This method process Iframe action and opens Iframe page with proper url</b>
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	@ProcessAction(name = "openiframepage")
	public void processIframeAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		String url = actionRequest.getParameter("url");

		actionResponse.setEvent(new QName("http:wgen.com/events", "iframeurl"),
				url);

		String iframePage = PortletPropsValues.IFRAME_PAGE;
		
		//Hide default success message
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		actionResponse.sendRedirect(iframePage + "#" + url);
	}

	private static Log _log = LogFactoryUtil
			.getLog(AppSelectionInterfacePortlet.class);
}
