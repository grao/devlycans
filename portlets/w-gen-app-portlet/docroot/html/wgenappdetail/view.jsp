<%@ include file="/../../jsp/init.jsp" %>
<%
System.out.println("Application Id:->"+request.getParameter("appId")+" "+ themeDisplay.getURLCurrent());
if (themeDisplay.isShowPageSettingsIcon() )
			{
			%>
<portlet:actionURL name="WgenAppDetailAdd" var="addWgenAppURL"/>
<form action="<%= addWgenAppURL.toString()%>" method="post">
    <table class="taglib-search-iterator" cellpadding="3" cellspacing="5">
      <tr class="results-row">
        <td>Title</td>
        <td><input type="text" name="WgenAppTitle" value=""/></td>
      </tr>

      <tr class="results-row">
        <td>Description </td>
        <td><textarea name="WgenAppDescription" value="" rows="4" cols="17"></textarea>
        </td>
      </tr>

      <tr class="results-row">
        <td>URL</td>
        <td><input type="text" name="WgenAppURL" value=""/></td>
      </tr>

      <tr class="results-row">
        <td></td>
        <td><input type="submit" value="Save" /></td>
      </tr>
    
    </table>
</form>

	<%	
	List<WgenApp> WgenAppDetailList=WgenAppLocalServiceUtil.getAllWgenApps();	%>
<br /><br />
<div class="">
<table class="taglib-search-iterator">
						<%
							for(WgenApp WgenAppDetail: WgenAppDetailList)
							{	
								String WgenAppId="";
								String WgenAppTitle="";
								String WgenAppDescription="";
								String WgenAppURL="";	
								
								WgenAppId=String.valueOf(WgenAppDetail.getWgenAppId());
								WgenAppTitle=WgenAppDetail.getWgenAppTitle();
								WgenAppDescription=WgenAppDetail.getWgenAppDescription();
								WgenAppURL=WgenAppDetail.getWgenAppURL();
						%>	


	<tr class="results-row">
    	<td><%=WgenAppTitle %></td>
    	<td><%=WgenAppURL %></td>
        <td>
       <portlet:actionURL name="WgenAppDetailDelete" var="deleteWgenAppURL"/>           
        <form action="<%=deleteWgenAppURL.toString()%>" method="post">
        	<input type="hidden" value="<%=WgenAppId %>" name="deleteAppId">
        	<input type="submit" value="delete" /> 
        </form>
        </td>
        
    </tr>


							<%}%>
</table>
		<br /><br />
			</div>

	<%}
	%>	