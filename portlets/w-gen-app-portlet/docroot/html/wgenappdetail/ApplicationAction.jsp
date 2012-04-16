<%@ include file="/../../jsp/init.jsp" %>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	WgenApp infoDetail=(WgenApp)row.getObject();	
	String primaryKey=String.valueOf(infoDetail.getPrimaryKey());
%>
<lifery-ui:icon-menu>	
	<portlet:renderURL var="renderEditjsp">
		<portlet:param name="jspPage" value=""/>
		<portlet:param name="resourcePrimaryKey" value="<%= primaryKey%>"/>
	</portlet:renderURL>	
	
	<portlet:actionURL name="deleteApplication" var="deleteInfoDetailURL">
		<portlet:param name="resourcePrimaryKey" value="<%= primaryKey%>"/>		
	</portlet:actionURL>	
	
	<liferay-ui:icon image="edit" message="Edit" url="<%=renderEditjsp.toString()%>"/>
	<liferay-ui:icon-delete url="<%=deleteInfoDetailURL.toString()%>"/>
	
</lifery-ui:icon-menu>