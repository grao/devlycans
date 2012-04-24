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

/**
 * The simplest possible servlet.
 *
 * @author 
 */

public class MyServlet extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {

        response.setContentType("text/html");
        //PrintWriter out = response.getWriter();
	
		String jsonText="";
		String jsonText2="";

		String serverPath= "https://"+request.getServerName();

	try{
				RestTemplate template = new RestTemplate();
				URLBuilder url = new URLBuilder(serverPath);
				url.addPath("wgen-portlet/api/secure/jsonws/headerfooter/get-header");    
				url.addQueryParam("isAdmin", "true");
				jsonText = template.getForObject(url.toString(), String.class);
				JsonParser parser = new JsonParser();
				jsonText =  parser.parse(jsonText).getAsString();
				
				RestTemplate template2 = new RestTemplate();
				URLBuilder url2 = new URLBuilder(serverPath);
				url2.addPath("wgen-portlet/api/secure/jsonws/headerfooter/get-footer");    
				url2.addQueryParam("isAdmin", "true");
				jsonText2 = template2.getForObject(url2.toString(), String.class);
				JsonParser parser2 = new JsonParser();
				jsonText2 =  parser2.parse(jsonText2).getAsString();
				
		}catch(Exception e){
		e.printStackTrace();
		}


		request.setAttribute ("servletName", "MyServlet");
		request.setAttribute ("jsonText", jsonText);
		request.setAttribute ("jsonText2", jsonText2);
		getServletConfig().getServletContext().getRequestDispatcher("/html/wsClient.jsp").forward(request, response);

    }
}



