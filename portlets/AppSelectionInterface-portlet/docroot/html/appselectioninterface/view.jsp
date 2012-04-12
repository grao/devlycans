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

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>


<%@page import="java.util.List"%>
<%@page import="org.slc.sli.json.bean.AppsData"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />




<%
	List<AppsData> appList = (List<AppsData>)renderRequest.getAttribute("appList");
	
%>


<table border="1">
<tr><th>Name</th>
<th>Description</th>
<th>Behaviour</th>
<th>Image URL</th>
<th>Application URL</th>
</tr>

<c:forEach items="${appList}" var="app">
<tr>
<td><c:out value="${app.name}"></c:out></td>
<td><c:out value="${app.description}"></c:out></td>
<td><c:out value="${app.behaviour }"></c:out></td>
<td><c:out value="${app.image_url}"></c:out></td>
<td>


<c:choose>
	<c:when test='${app.behaviour eq "Wsrp App" }'>
		<a onClick="callWsrp('<c:out value="${app.application_url}"></c:out>')"  href='#'>
			<c:out value="${app.application_url}"></c:out>
		</a>
	</c:when>
	<c:when test='${app.behaviour eq "Iframe App" }'>
		<a onClick="callIframe('<c:out value="${app.application_url}"></c:out>')" href='#'>
			<c:out value="${app.application_url}"></c:out>
		</a>
	</c:when>
	<c:when test='${app.behaviour eq "Full Window App" }'>
		<a target="_blank" href='<c:out value="${app.application_url}"></c:out>'>
			<c:out value="${app.application_url}"></c:out>
		</a>
	</c:when>		
</c:choose>

</td>
</tr>
</c:forEach>

</table>

<aui:form method="post" name="fm">
	<aui:input name="url" type="hidden" />
</aui:form>

<script>
function callIframe(arg1){
	document.<portlet:namespace />fm.action='<portlet:actionURL><portlet:param name="javax.portlet.action" value="openiframepage" /></portlet:actionURL>';
	document.<portlet:namespace />fm.<portlet:namespace />url.value = arg1;
	submitForm(document.<portlet:namespace />fm);
}

function callWsrp(arg1){
	document.<portlet:namespace />fm.action='<portlet:actionURL><portlet:param name="javax.portlet.action" value="openwsrppage" /></portlet:actionURL>';
	document.<portlet:namespace />fm.<portlet:namespace />url.value = arg1;
	submitForm(document.<portlet:namespace />fm);
}
</script>
