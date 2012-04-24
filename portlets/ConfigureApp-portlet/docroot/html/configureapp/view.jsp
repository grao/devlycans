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

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>


<portlet:defineObjects />

<!-- <style>
td a {
	color: #000000;
	text-decoration: none;
}

td a:hover {
	color: #000000;
	text-decoration: underline;
}
</style> -->






<table border="0">

	<tr>

		<td><img src="<%=request.getContextPath()%>/images/cogwheel.png"
			alt="settings_logo" style="height: 10px; width: 10px" /></td>
		<td>&nbsp;</td>
		<td><a href='#' style="color: #000000;text-decoration: none;font-size: 14px;">Dashboards</a></td>
	</tr>

	<tr>
		<td><img src="<%=request.getContextPath()%>/images/cogwheel.png"
			alt="settings_logo" style="height: 10px; width: 10px" /></td>
		<td>&nbsp;</td>
		<td><a href='#' style="color: #000000;text-decoration: none;font-size: 14px;">App Title</a></td>
	</tr>

	<tr>

		<td><img src="<%=request.getContextPath()%>/images/cogwheel.png"
			alt="settings_logo" style="height: 10px; width: 10px" /></td>
		<td>&nbsp;</td>
		<td><a href='#' style="color: #000000;text-decoration: none;font-size: 14px;">App Title</a></td>
	</tr>


</table>




<aui:form method="post" name="fm">
	<aui:input name="url" type="hidden" />
</aui:form>

<script>
	function callIframe(arg1) {
		document.<portlet:namespace />fm.action = '<portlet:actionURL><portlet:param name="javax.portlet.action" value="openiframepage" /></portlet:actionURL>';
		document.<portlet:namespace />fm.<portlet:namespace />url.value = arg1;
		submitForm(document.<portlet:namespace />fm);
	}

	function callWsrp(arg1) {
		document.<portlet:namespace />fm.action = '<portlet:actionURL><portlet:param name="javax.portlet.action" value="openwsrppage" /></portlet:actionURL>';
		document.<portlet:namespace />fm.<portlet:namespace />url.value = arg1;
		submitForm(document.<portlet:namespace />fm);
	}
</script>
