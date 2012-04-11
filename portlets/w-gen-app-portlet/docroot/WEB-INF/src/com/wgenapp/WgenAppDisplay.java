package com.wgenapp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ProcessAction;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;
import com.wgenapp.util.PortletPropsValues;
/**
 * Portlet implementation class WgenAppDisplay
 */
public class WgenAppDisplay extends GenericPortlet {

	public void init(PortletConfig portletConfig) throws PortletException {
		super.init(portletConfig);

		if (_log.isInfoEnabled()) {
			_log.info("Initializing portlet");
		}
	}

	@ProcessAction(name="openwsrppage")
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {
		
		String url = actionRequest.getParameter("url");
		actionResponse.setEvent(new QName("http:wgen.com/events", "wsrpurl"), url);
		
		String wsrp_url = PortletPropsValues.WSRP_PAGE;
		System.out.println("wsrp_url is ..."+wsrp_url);
		actionResponse.sendRedirect(wsrp_url);
	}

	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletContext portletContext = getPortletContext();

		PortletRequestDispatcher portletRequestDispatcher =
			portletContext.getRequestDispatcher("/html/wgenappdisplay/view.jsp");

		
		if (portletRequestDispatcher == null) {
			_log.error("/html/wgenappdisplay/view.jsp is not a valid include");
		}
		else {
			try {
				portletRequestDispatcher.include(renderRequest, renderResponse);
			}
			catch (Exception e) {
				_log.error(e, e);

				portletRequestDispatcher = portletContext.getRequestDispatcher(
					"/error.jsp");

				if (portletRequestDispatcher == null) {
					_log.error("/error.jsp is not a valid include");
				}
				else {
					portletRequestDispatcher.include(
						renderRequest, renderResponse);
				}
			}
		}
	}

	public void destroy() {
		if (_log.isInfoEnabled()) {
			_log.info("Destroying portlet");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(WgenAppDisplay.class);

}