/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
/* $Id: HelloWorldExample.java 500674 2007-01-27 23:15:00Z markt $
 *
 */

package com.test;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.google.gson.JsonElement;

import com.google.gson.JsonArray;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.commons.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * The simplest possible servlet.
 *
 * @author James Duncan Davidson
 */

public class MyServlet extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {

        response.setContentType("text/html");
        //PrintWriter out = response.getWriter();




	
		String token=(String)request.getSession().getAttribute("OAUTH_TOKEN");
		String jsonText="";
		String jsonText2="";

		String serverPath= "https://"+request.getServerName();

		System.out.println("token is..."+token);

		 HttpEntity<String> responseent = null;

	try{
				RestTemplate template = new RestTemplate();
				URLBuilder url = new URLBuilder(serverPath);
				url.addPath("wgen-portlet/api/secure/jsonws/headerfooter/get-header");    
				url.addQueryParam("isAdmin", "true");
				url.addQueryParam("fullName", "Test");
				jsonText = template.getForObject(url.toString(), String.class);
				JsonParser parser = new JsonParser();
				jsonText =  parser.parse(jsonText).getAsString();

				//System.out.println("url is ..............."+url.toString()+"----------------"+request.getSession().getId());

				/*Map<String, String> vars = new HashMap<String, String>();
				vars.put("type", "header");

				HttpEntity<String> entity = prepareGet(MediaType.APPLICATION_JSON);*/



				/*HttpHeaders requestHeaders = new HttpHeaders();
				requestHeaders.add("Cookie", "JSESSIONID="+request.getSession().getId());
				HttpEntity requestEntity = new HttpEntity(null, requestHeaders);*/

				/*HttpHeaders requestHeaders = new HttpHeaders();
				requestHeaders.set( "Authorization", "..." );
				HttpEntity requestEntity = new HttpEntity(null, requestHeaders);

				responseent = template.exchange(url.toString(),HttpMethod.GET,requestEntity,String.class);*/

				
				RestTemplate template2 = new RestTemplate();
				URLBuilder url2 = new URLBuilder(serverPath);
				url2.addPath("wgen-portlet/api/secure/jsonws/headerfooter/get-footer");    
				url2.addQueryParam("isAdmin", "true");
				url2.addQueryParam("fullName", "Test");
				jsonText2 = template2.getForObject(url2.toString(), String.class);
				JsonParser parser2 = new JsonParser();
				jsonText2 =  parser2.parse(jsonText2).getAsString();
				
		}catch(Exception e){
		e.printStackTrace();
		}


	// note that all links are created to be relative. this
	// ensures that we can move the web application that this
	// servlet belongs to to a different place in the url
	// tree and not have any harmful side effects.

        // XXX
        // making these absolute till we work out the
        // addition of a PathInfo issue

	    //out.println(jsonText);
        //out.println(jsonText2);
		request.setAttribute ("servletName", "MyServlet");
		request.setAttribute ("jsonText", jsonText);
		request.setAttribute ("jsonText2", jsonText2);
		getServletConfig().getServletContext().getRequestDispatcher("/html/wsClient.jsp").forward(request, response);

    }

	private static HttpEntity<String> prepareGet(MediaType type) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(type);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}

}



