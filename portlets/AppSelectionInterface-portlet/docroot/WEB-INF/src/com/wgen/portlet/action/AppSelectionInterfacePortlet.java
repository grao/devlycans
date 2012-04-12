package com.wgen.portlet.action;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletSessionUtil;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.portlet.ProcessAction;
import javax.xml.namespace.QName;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import java.io.IOException;

import org.slc.sli.json.bean.AppsData;
import org.slc.sli.util.AppsUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletRequestUtil;
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

		// to be removed start

		AppsData fullwind = new AppsData();
		fullwind.setApplication_url("https://devdash1.slidev.org/dashboard");
		fullwind.setImage_url("https://devdash1.slidev.org/dashboard");
		fullwind.setBehaviour("Full Window App");
		fullwind.setDescription("Dash board");
		fullwind.setName("Dash board");

		AppsData iframe = new AppsData();
		iframe.setApplication_url("https://devdash1.slidev.org/dashboard");
		iframe.setImage_url("https://devdash1.slidev.org/dashboard");
		iframe.setBehaviour("Iframe App");
		iframe.setDescription("Dash board");
		iframe.setName("Dash board");

		AppsData iframe1 = new AppsData();
		iframe1.setApplication_url("https://mail.wgen.net");
		iframe1.setImage_url("https://mail.wgen.net");
		iframe1.setBehaviour("Iframe App");
		iframe1.setDescription("Wgen Mail");
		iframe1.setName("Wgen Mail");

		AppsData wsrp = new AppsData();
		wsrp.setApplication_url("http://devlycans.slidev.org:8088/producer/wsrp/wsdl/showtime");
		wsrp.setImage_url("http://devlycans.slidev.org:8088/producer/wsrp/wsdl/showtime");
		wsrp.setBehaviour("Wsrp App");
		wsrp.setDescription("Show time");
		wsrp.setName("Show time");

		AppsData wsrp1 = new AppsData();
		wsrp1.setApplication_url("http://devlycans.slidev.org:8088/producer/wsrp/wsdl/bookmark");
		wsrp1.setImage_url("http://devlycans.slidev.org:8088/producer/wsrp/wsdl/bookmark");
		wsrp1.setBehaviour("Wsrp App");
		wsrp1.setDescription("Book mark");
		wsrp1.setName("Book mark");
		// to be removed end

		List<AppsData> appsData = AppsUtil.getUserApps(tokenFromReq);

		// to be removed start
		appsData.add(fullwind);
		appsData.add(iframe);
		appsData.add(iframe1);
		appsData.add(wsrp);
		appsData.add(wsrp1);
		// to be removed end

		renderRequest.setAttribute("appList", appsData);

		super.render(renderRequest, renderResponse);
	}

	@ProcessAction(name = "openwsrppage")
	public void processWsrpAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		String url = actionRequest.getParameter("url");
		actionResponse.setEvent(new QName("http:wgen.com/events", "wsrpurl"),
				url);

		String wsrpPage = PortletPropsValues.WSRP_PAGE;
		actionResponse.sendRedirect(wsrpPage);
	}

	@ProcessAction(name = "openiframepage")
	public void processIframeAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		String url = actionRequest.getParameter("url");

		actionResponse.setEvent(new QName("http:wgen.com/events", "iframeurl"),
				url);

		String iframePage = PortletPropsValues.IFRAME_PAGE;
		actionResponse.sendRedirect(iframePage + "#" + url);
	}

	private static Log _log = LogFactoryUtil
			.getLog(AppSelectionInterfacePortlet.class);
}
