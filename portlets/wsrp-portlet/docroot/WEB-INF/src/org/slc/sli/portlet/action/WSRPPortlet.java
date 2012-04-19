package org.slc.sli.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.ProcessEvent;

import org.slc.sli.util.RuntimePortletEmbedUtil;

import com.liferay.wsrp.util.WSRPConsumerManager;
import com.liferay.wsrp.util.WSRPConsumerManagerFactory;

import com.liferay.portal.theme.ThemeDisplay;

import com.liferay.wsrp.NoSuchConsumerException;
import com.liferay.wsrp.NoSuchConsumerPortletException;
import com.liferay.wsrp.WSRPConsumerPortletHandleException;
import com.liferay.wsrp.WSRPConsumerPortletNameException;
import com.liferay.wsrp.WSRPConsumerWSDLException;
import com.liferay.wsrp.service.WSRPConsumerPortletLocalServiceUtil;
import com.liferay.wsrp.model.WSRPConsumerPortlet;
import com.liferay.wsrp.service.WSRPConsumerLocalServiceUtil;
import com.liferay.wsrp.model.WSRPConsumer;
import com.liferay.portal.service.PortletLocalServiceUtil;

import com.liferay.wsrp.model.WSRPConsumer;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

import oasis.names.tc.wsrp.v2.types.PortletDescription;
import oasis.names.tc.wsrp.v2.types.ServiceDescription;

/**
 * @author
 */

public class WSRPPortlet extends GenericPortlet {

	public void init(PortletConfig portletConfig) throws PortletException {
		super.init(portletConfig);

		if (_log.isInfoEnabled()) {
			_log.info("Initializing portlet");
		}
	}

	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletContext portletContext = getPortletContext();

		// if the wsrp page is directly invoked catch that and report the error
		// wsrpurl will not be empty check if this url is a valid wsrp url
		// register the wsrp portlet in lifeay prosibble exception no the url is
		// not a valid url, exception occurs from liferay while registering the
		// wsrp portlet in liferay

		// get the wsrp url from session
		String portletId = (String) renderRequest.getPortletSession()
				.getAttribute("portletId");

		String portletHtml = "";
		if (Validator.isNotNull(portletId)) {
			try {
				portletHtml = RuntimePortletEmbedUtil.renderPortlet(
						renderRequest, renderResponse, portletId, "");
				renderRequest.setAttribute("portletHtml", portletHtml);
			} catch (Exception e) {

			}
		}

		PortletRequestDispatcher portletRequestDispatcher = portletContext
				.getRequestDispatcher("/html/wsrp/view.jsp");

		if (portletRequestDispatcher == null) {
			_log.error("/html/wsrp/view.jsp is not a valid include");
		} else {
			try {
				portletRequestDispatcher.include(renderRequest, renderResponse);
			} catch (Exception e) {
				_log.error(e, e);

				portletRequestDispatcher = portletContext
						.getRequestDispatcher("/error.jsp");

				if (portletRequestDispatcher == null) {
					_log.error("/error.jsp is not a valid include");
				} else {
					portletRequestDispatcher.include(renderRequest,
							renderResponse);
				}
			}
		}
	}

	/**
	 * This method processes received events with the following QName
	 */
	@ProcessEvent(qname = "{http:wgen.com/events}wsrpurl")
	public void processEvent1(EventRequest request, EventResponse response)
			throws PortletException, IOException, Exception {

		// Let's store the event value into the portlet's session (we assume it
		// is never null)
		String wsrpurl = (String) request.getEvent().getValue();

		WSRPConsumer wsrpConsumer = null;
		String portletId = StringPool.BLANK;

		try {
			// check if the consumer already exist in liferay, if doesnt exist
			// create the consumer, register, add portlet
			wsrpConsumer = WSRPConsumerLocalServiceUtil
					.getWSRPConsumerByURL(wsrpurl);

			WSRPConsumerPortlet wscp = WSRPConsumerPortletLocalServiceUtil
					.getWSRPConsumerPortletByConsumerId(wsrpConsumer
							.getWsrpConsumerId());
			portletId = PortletLocalServiceUtil.getPortlet(
					wscp.getWsrpConsumerPortletId() + 1).getPortletId();

		} catch (NoSuchConsumerException nsce) {
			try {
				if (Validator.isNull(wsrpurl)) {
					throw new WSRPURLException();
				}
				// create consumer throws WSRPConsumerWSDLException exception if
				// any problem with wsdl
				wsrpConsumer = createConsumer("sample consumer", wsrpurl, "",
						request);

				// check if registration required for this consumer
				String userToken = WSRPConsumerManager.getUserToken(request);

				WSRPConsumerManager wsrpConsumerManager = WSRPConsumerManagerFactory
						.getWSRPConsumerManager(wsrpConsumer, userToken);
				ServiceDescription serviceDescription = wsrpConsumerManager
						.getServiceDescription();

				if (Validator.isNotNull(serviceDescription)
						&& serviceDescription.isRequiresRegistration()) {
					// register consumer and manage portlet
					registerConsumer(wsrpConsumer.getWsrpConsumerId(), request,
							response);
				}

				// call manage portlet
				managePortlet(wsrpConsumer, userToken, request);

				WSRPConsumerPortlet wscp = WSRPConsumerPortletLocalServiceUtil
						.getWSRPConsumerPortletByConsumerId(wsrpConsumer
								.getWsrpConsumerId());
				portletId = PortletLocalServiceUtil.getPortlet(
						wscp.getWsrpConsumerPortletId() + 1).getPortletId();

			} catch (Exception e) {
				if (e instanceof WSRPConsumerWSDLException
						|| e instanceof WSRPURLException
						|| e instanceof NoSuchConsumerPortletException
						|| e instanceof WSRPConsumerPortletHandleException
						|| e instanceof WSRPConsumerPortletNameException) {
					SessionErrors.add(request, e.getClass().getName());
				} else {
					throw e;
				}
			}
		}

		// fetch the actual portlet

		request.getPortletSession().setAttribute("portletId", portletId);
	}

	protected WSRPConsumer createConsumer(String consumerName,
			String producerURL, String consumerForwardCookies,
			EventRequest request) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		String adminPortletId = "1";
		String name = consumerName;
		String url = producerURL;
		String forwardCookies = consumerForwardCookies;

		String userToken = WSRPConsumerManager.getUserToken(request);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				WSRPConsumer.class.getName(), request);

		WSRPConsumer wsrpConsumer = WSRPConsumerLocalServiceUtil
				.addWSRPConsumer(themeDisplay.getCompanyId(), adminPortletId,
						name, url, forwardCookies, userToken, serviceContext);

		if (_log.isDebugEnabled()) {
			_log.debug("Created Consumer");
		}

		return wsrpConsumer;
	}

	protected void registerConsumer(long wsrpConsumerId, EventRequest request,
			EventResponse response) throws Exception {

		long consumerId = wsrpConsumerId;

		String adminPortletId = "1";

		boolean inbandRegistration = true;

		UnicodeProperties registrationProperties = new UnicodeProperties();

		String registrationHandle = StringPool.BLANK;

		String userToken = WSRPConsumerManager.getUserToken(request);

		WSRPConsumerLocalServiceUtil.registerWSRPConsumer(consumerId,
				adminPortletId, registrationProperties, registrationHandle,
				userToken);

		if (_log.isDebugEnabled()) {
			_log.debug("Registered Consumer");
		}
	}

	protected void managePortlet(WSRPConsumer wsrpConsumer, String userToken,
			EventRequest request) throws Exception {

		WSRPConsumerManager wsrpConsumerManager = WSRPConsumerManagerFactory
				.getWSRPConsumerManager(wsrpConsumer, userToken);
		ServiceDescription serviceDescription = wsrpConsumerManager
				.getServiceDescription();
		PortletDescription[] portletDescriptions = serviceDescription
				.getOfferedPortlets();

		if (Validator.isNotNull(portletDescriptions)) {
			PortletDescription portletDescription = portletDescriptions[0];
			// WSRPConsumerPortletLocalServiceUtil.getWSRPConsumerPortlet(wsrpConsumer.getWsrpConsumerId(),
			// portletDescription.getPortletHandle());

			long wsrpConsumerId = wsrpConsumer.getWsrpConsumerId();
			String name = "test";
			String portletHandle = portletDescription.getPortletHandle();

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					WSRPConsumerPortlet.class.getName(), request);

			WSRPConsumerPortletLocalServiceUtil.addWSRPConsumerPortlet(
					wsrpConsumerId, name, portletHandle, userToken,
					serviceContext);

			if (_log.isDebugEnabled()) {
				_log.debug("Manage Portlet");
			}
		}
	}

	public void destroy() {
		if (_log.isInfoEnabled()) {
			_log.info("Destroying portlet");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(WSRPPortlet.class);

}