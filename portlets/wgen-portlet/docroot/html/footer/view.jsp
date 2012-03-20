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

<%@include file="/html/init.jsp" %>

<%@ page import="com.google.gson.JsonArray"%>

<%@ page import="com.google.gson.JsonObject"%>
<%@ page import="com.google.gson.JsonParser"%>

<%@ page import="org.slf4j.Logger"%>
<%@ page import="org.slf4j.LoggerFactory"%>
<%@ page import="org.springframework.http.HttpEntity"%>
<%@ page import="org.springframework.http.HttpHeaders"%>
<%@ page import="org.springframework.http.HttpMethod"%>
<%@ page import="org.springframework.stereotype.Component"%>
<%@ page import="org.springframework.web.client.RestTemplate"%>

<%@ page import="org.slc.sli.util.URLBuilder"%>
<%@ page import="org.slc.sli.util.Constants"%>
<%@ page import="com.google.gson.JsonElement" %>

<%
	HttpSession httpSession = (HttpSession)request.getSession(false);
	String token = (String)httpSession.getAttribute("OAUTH_TOKEN");
%>

<%
	String footer =""; 
	if(token!=null){
		footer = HeaderFooterLocalServiceUtil.getFooter(token);	
	}
%>

<%=footer!=null ? footer : ""%>


<%
	String jsonText="";
/*try{
	        RestTemplate template = new RestTemplate();
	        URLBuilder url = new URLBuilder("http://svankina.devapp1.slidev.org:8080");
	        url.addPath("wgen-portlet/api/jsonws/headerfooter/get-header");    
	        url.addQueryParam("token", "AQIC5wM2LY4SfczZeuafpR2EQWs6jYK4WlTuJmX4clVoD8k.*AAJTSQACMDE.*");
	        jsonText = template.getForObject(url.toString(), String.class);
	        JsonParser parser = new JsonParser();
	       	jsonText =  parser.parse(jsonText).getAsString();
	}catch(Exception e){

	}*/
%>
