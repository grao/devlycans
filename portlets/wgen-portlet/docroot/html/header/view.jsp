
<%@include file="/html/init.jsp" %>


<%
	HttpSession httpSession = (HttpSession)request.getSession(false);
	String token = (String)httpSession.getAttribute("OAUTH_TOKEN");
%>

<%
	String header =""; 
	if(token!=null){
		header = HeaderFooterLocalServiceUtil.getHeader(token);
	}
%>

<%=header!=null ? header : ""%>




