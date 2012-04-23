

<body>
<%
	String serverPath= "https://"+request.getServerName();
	String jsonText=(String)request.getAttribute("jsonText");
	String jsonText2=(String)request.getAttribute("jsonText2");
%>


<%=jsonText%>
<%=jsonText2 %>
</body>
</html>