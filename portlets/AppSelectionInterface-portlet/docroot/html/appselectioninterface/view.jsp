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

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>


<%@page import="java.util.List"%>
<%@page import="org.slc.sli.json.bean.AppsData"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />




<%
	List<AppsData> appList = (List<AppsData>)renderRequest.getAttribute("appList");
	
%>



<table border ="0" cellpadding="10">
 <c:forEach items="${appList}" var="app">
<tr>
<td><img src="${app.image_url }" alt="app_logo" width="46" height="45"></img><br><br></td>
<td>&nbsp;&nbsp;&nbsp;</td>
<td style="vertical-align:top;"> 

<c:choose>
	<c:when test='${app.behaviour eq "Wsrp App" }'>
		<a  style="text-decoration: none" onClick="callWsrp('<c:out value="${app.application_url}"></c:out>')"  href='#'>
	</c:when>
	<c:when test='${app.behaviour eq "Iframe App" }'>
		<a style="text-decoration: none" onClick="callIframe('<c:out value="${app.application_url}"></c:out>')" href='#'>
	</c:when>
	<c:when test='${app.behaviour eq "Full Window App" }'>
		<a target="_blank" style="text-decoration: none" href='<c:out value="${app.application_url}"></c:out>'>
	</c:when>		
</c:choose>
    <div style="font-weight: bold;font-size: 14px;color: black"> <c:out value="${app.name}"></c:out></div>
    <div class="clr"></div>
    <div class="r_menu_dis" style="color:black"><c:out value="${app.description}"></c:out></div>
	</a>
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
