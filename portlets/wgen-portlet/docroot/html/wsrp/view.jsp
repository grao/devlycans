<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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
--%>


<%@include file="/html/init.jsp" %>

<%@page import="com.liferay.portal.theme.ThemeDisplay"%>

<%@page import="org.slc.sli.util.RuntimePortletEmbedUtil"%>

<%@page import="com.liferay.wsrp.service.WSRPConsumerPortletLocalServiceUtil"%>

<%@page import="com.liferay.wsrp.model.WSRPConsumerPortlet"%>
<%@page import="com.liferay.wsrp.service.WSRPConsumerLocalServiceUtil"%>
<%@page import="com.liferay.wsrp.model.WSRPConsumer"%>
<%@page import="com.liferay.portal.service.PortletLocalServiceUtil" %>

<portlet:defineObjects />

<%
 String portletId = "";
	try{
		WSRPConsumer wconsumer=WSRPConsumerLocalServiceUtil.getWSRPConsumerByURL("http://localhost:8080/producer/wsrp/wsdl/guessnumberprod");
		System.out.println(wconsumer);
		WSRPConsumerPortlet wscp= WSRPConsumerPortletLocalServiceUtil.getWSRPConsumerPortletByConsumerId(wconsumer.getWsrpConsumerId());
		System.out.println(wscp);
		portletId = PortletLocalServiceUtil.getPortlet(wscp.getWsrpConsumerPortletId()+1).getPortletId();
		System.out.println(portletId);
	}catch(Exception e){
		e.printStackTrace();
	}

	

String portletHtml="";
//final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
// get the preferences
//final PortletPreferences prefs = PortletPreferencesUtilityLocalServiceUtil.getWrappedPortletPreferences(themeDisplay, portletId);
// set a preference
//prefs.setValue("successURL", "some url");
// dont forget to store the preferences
//formPrefs.store();
// get the HTML from the portlet
portletHtml = RuntimePortletEmbedUtil.renderPortlet(renderRequest, renderResponse, portletId, "");

%>

<%=portletHtml %>
