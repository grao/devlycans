<%@page import="org.omg.CORBA.Request"%>
<%@ include file="/../../jsp/init.jsp" %>
<%
	List<WgenApp> WgenAppDetailList=WgenAppLocalServiceUtil.getAllWgenApps();	%>

<div class="" id="app_list_box">
  <h2 class="menu_title" ></h2>
  <ul class="right_menu">
    <%
		int i=1;
			
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
		
		if (i>5)i=1;
		
      %>
    <li class="item<%=i%>">
    <a href="<%=WgenAppURL %>" >
   	<span class="r_menu_title"> <%=WgenAppTitle %></span>
    <div class="clr"></div>
    <span class="r_menu_dis"><%=WgenAppDescription %></span>
    </a>
    </li>

	<%  i++;}%>
    
  </ul>
  <br />
  <br />
</div>


<form	method="post" 
		action="<portlet:actionURL>
					<portlet:param name="javax.portlet.action" value="openwsrppage" />
				</portlet:actionURL>">
	<fieldset>
		<table>
			<tbody>
			<tr>
				<th><label>WSRP url:</label></th>
				<td><input name="url" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Open Wsrp Portlet" /></td>
			</tr>
			</tbody>
		</table>
	</fieldset>
</form>


