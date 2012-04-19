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



<portlet:defineObjects />

<%
	String portletHtml=(String)request.getAttribute("portletHtml");
%>


<liferay-ui:error exception="<%= WSRPConsumerWSDLException.class %>" message="url-does-not-point-to-a-valid-wsrp-producer" />
<liferay-ui:error exception="<%= WSRPURLException.class %>" message="URL cannot be empty" />

<liferay-ui:error exception="<%= WSRPConsumerPortletNameException.class %>" message="please-enter-a-valid-name" />

<liferay-ui:error exception="<%= NoSuchConsumerPortletException.class %>" message="the-wsrp-consumer-is-not-available" />
<liferay-ui:error exception="<%= WSRPConsumerPortletHandleException.class %>" message="please-enter-a-valid-remote-portlet" />



<%=Validator.isNotNull(portletHtml) ? portletHtml :""%>

