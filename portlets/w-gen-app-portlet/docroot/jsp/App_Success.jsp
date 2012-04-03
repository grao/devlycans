<%@ include file="/jsp/init.jsp" %>

<center>
	<div style="font-size:14px" >
		<A href="<portlet:renderURL><portlet:param name="jspPage" value="/jsp/app.jsp" /></portlet:renderURL>"> Add More Banner</A>
	</div>
</center>
  <!-- end intro -->
  <!-- end sidebar_right -->
<liferay-ui:search-container delta="10" emptyResultsMessage="no-Application_Image-found">
		<liferay-ui:search-container-results results="<%=ApplicationLocalServiceUtil.getAllApplicationDetail() %>" total="<%=ApplicationLocalServiceUtil.getCountAllApplication()%>"/>	
		<liferay-ui:search-container-row className="com.Application.model.Application" keyProperty="appId" modelVar="Application">
			<%		
				String imgURL="<img src='"+Application.getAppImage()+"'  height='70px' />";			 
			%>
				<liferay-ui:search-container-column-text
					name="App"
					value="<%=imgURL%>" 
				/>	 
				<liferay-ui:search-container-column-text
					name="App Title"
					value="<%=Application.getAppTitle()%>" 
				/>	
				<liferay-ui:search-container-column-text
					name="App Sub Title"
					value="<%=Application.getAppSubTitle()%>" 
				/>	
				<liferay-ui:search-container-column-text
					name="App Description"
					value="<%=Application.getAppDescription() %>" 
				/>
				<liferay-ui:search-container-column-text
					name="App URL"
					value="<%=Application.getAppURL() %>" 
				/>	
				<liferay-ui:search-container-column-jsp path="/jsp/ApplicationAction.jsp" align="rigth"/>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator/>	
		</liferay-ui:search-container>
