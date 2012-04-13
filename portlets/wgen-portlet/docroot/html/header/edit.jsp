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

<%@include file="/html/init.jsp"%>

<%
HeaderFooter header = HeaderFooterLocalServiceUtil.getCurrentHeader();
String data = BeanParamUtil.getString(header, request, "data");
%>


<portlet:actionURL name="addHeaderPrefs" var="addHeaderURL">
</portlet:actionURL>


<aui:model-context bean="<%= header %>" model="<%= HeaderFooter.class %>" />


<aui:form name="fm" action="<%=addHeaderURL%>" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "updateData();" %>'>

	<aui:input name="data" type="hidden"></aui:input>
	<aui:input name="id" type="hidden"></aui:input>

	<liferay-ui:input-editor width="100%" />
	<aui:button type="submit" name="save"></aui:button>

</aui:form>


<aui:script>
	function <portlet:namespace />initEditor() {
		return "<%= UnicodeFormatter.toString(data) %>";
	}

	function <portlet:namespace />updateData() {
		document.<portlet:namespace />fm.<portlet:namespace />data.value = window.<portlet:namespace />editor.getHTML();
		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>
