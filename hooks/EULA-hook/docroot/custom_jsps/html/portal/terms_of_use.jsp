<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/html/portal/init.jsp" %>

<%
String currentURL = PortalUtil.getCurrentURL(request);

String referer = ParamUtil.getString(request, WebKeys.REFERER, currentURL);

if (referer.equals(themeDisplay.getPathMain() + "/portal/update_terms_of_use")) {
	referer = themeDisplay.getPathMain() + "?doAsUserId=" + themeDisplay.getDoAsUserId();
}
%>
     <div id="banner">
         <div id="heading">
              <div class="portlet-layout">
                   <div class="portlet-column portlet-column-only" id="column-1">
                         <div class="logo_main"> <a href="<%= themeDisplay.getURLHome() %>"> <img class="company-logo" src="<%= themeDisplay.getCompanyLogo() %>" width="<%= themeDisplay.getCompanyLogoWidth() %>" height="<%= themeDisplay.getCompanyLogoHeight() %>"/> </a> 
 <a href="<%= themeDisplay.getURLHome() %>"><span>SLI Portal</span></a>
</div>
                   </div>
              </div>
        </div>
        
    </div>
    <div id="content_main">
    <div class="home_title">HOME</div>
	</div>
    
<div class="d_popup">
<span class="aui-legend" style="font-weight:bold;font-size: 18px; color:#333333; width:700px;">License Agreement</span>
<br /><br /><br /><br />
<aui:form action='<%= themeDisplay.getPathMain() + "/portal/update_terms_of_use" %>' name="fm">
	<aui:input name="doAsUserId" type="hidden" value="<%= themeDisplay.getDoAsUserId() %>" />
	<aui:input name="<%= WebKeys.REFERER %>" type="hidden" value="<%= referer %>" />
    	
        <div id="scroll" style="overflow: hidden;">
        <div id="scrollcontent">
	<c:choose>
		<c:when test="<%= (PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_GROUP_ID > 0) && Validator.isNotNull(PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_ID) %>">
			<liferay-ui:journal-article groupId="<%= PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_GROUP_ID %>" articleId="<%= PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_ID %>" />
		</c:when>

		<c:otherwise>
			 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tristique mi viverra elit interdum non ornare nisi congue. Cras ultrices interdum velit, ac egestas nunc pellentesque et. Praesent ornare eleifend rhoncus. Duis quis mi et lectus pellentesque mollis et sit amet enim. Quisque scelerisque semper aliquam. Maecenas ac lorem a purus tempor cursus. Aenean tristique ullamcorper fringilla. Curabitur elementum elementum enim. Nullam facilisis purus in neque laoreet mattis. Proin tristique sollicitudin libero, in malesuada erat consequat at. Morbi mi sapien, dictum id euismod vitae, rutrum nec nisi.
			<br /><br />

Morbi lacinia, lacus eu porttitor pellentesque, tortor lectus tincidunt dolor, vel posuere dolor mauris non enim. Etiam fringilla molestie ipsum, accumsan tempus lacus semper eget. Nullam tempus auctor mi et suscipit. Integer tellus lacus, congue ut eleifend a, fermentum ac massa. Aenean tortor nisl, fermentum in congue vel, aliquam non felis. Sed non ante quam, nec luctus felis. Duis sit amet dignissim lorem. Quisque suscipit, erat ac pulvinar tempor, odio libero cursus nibh, quis molestie dolor orci gravida lectus. Vivamus nibh turpis, imperdiet vitae tempor sit amet, semper eu leo. Vestibulum eget scelerisque dui. Nam et quam urna, sed auctor leo. Integer vestibulum luctus quam sed scelerisque. Duis vitae ante at quam posuere aliquet a vitae nisi. Aenean interdum ultrices tristique. Phasellus gravida, dui a varius elementum, sapien neque dictum ipsum, vitae tristique mauris justo in velit. Duis quam tortor, laoreet ut ultricies id, consequat at tortor.
			<br /><br />

Ut varius rutrum nisi, eu pellentesque turpis egestas et. Pellentesque lacus augue, vehicula eget facilisis at, fringilla sit amet lectus. Morbi lacus nibh, accumsan non luctus id, vehicula a quam. Mauris arcu dui, hendrerit nec auctor nec, tincidunt nec risus. Praesent est sem, pharetra interdum rutrum tincidunt, scelerisque ut elit. Pellentesque elit augue, consequat ut aliquet in, vehicula sit amet risus. Donec a libero ornare velit lobortis vestibulum at ac ipsum. Vestibulum tempus luctus urna, at tempus velit pretium et. Aliquam malesuada, augue sit amet rutrum sollicitudin, mi nunc vulputate dolor, eu imperdiet dolor erat a erat. Integer consectetur semper cursus. Nullam rutrum condimentum elit, non condimentum nisl vestibulum id. Integer adipiscing congue leo, eget euismod purus luctus eu. Morbi libero purus, consequat a hendrerit ac, viverra quis ante. Vivamus pretium porttitor fringilla. Suspendisse ac enim vel augue accumsan aliquam eget ut odio.
			<br /><br />

Vestibulum tempus erat purus. Vestibulum mattis condimentum magna vitae elementum. Pellentesque molestie eros arcu. Morbi venenatis, metus non imperdiet semper, mauris turpis sollicitudin sapien, non aliquam tellus velit quis felis. Vestibulum ultricies mi eu quam vehicula sit amet ultricies purus iaculis. Maecenas eu massa leo, id molestie enim. Nulla tincidunt tortor tortor, vel fringilla leo. Cras turpis enim, dignissim eu malesuada id, elementum eget augue.
			<br /><br />

Pellentesque viverra sagittis ipsum, nec molestie metus vestibulum a. Vivamus tincidunt dolor eget leo fringilla eget rhoncus nibh adipiscing. Nam aliquam, arcu vitae accumsan euismod, felis nisl dignissim elit, ultricies facilisis sem massa vel dolor. Nulla malesuada lorem non enim posuere a facilisis leo volutpat. In consectetur odio eu sapien pharetra consequat. Vivamus metus elit, egestas ac sollicitudin ac, porta et velit. Nam sapien augue, tincidunt eget vulputate nec, convallis in felis. Ut sed turpis odio, id vestibulum libero. Curabitur feugiat laoreet libero non tincidunt. In elit tellus, rutrum et lobortis pretium, sollicitudin sed diam. Integer eros elit, fringilla ut sagittis nec, egestas vitae sapien. Integer quis risus quam, et malesuada justo. Donec velit tellus, varius a ultricies vel, sollicitudin vitae eros. Mauris libero dolor, egestas vitae tristique eu, gravida ac mi. In nunc quam, lacinia eget ornare et, suscipit eu nisi.
			<br /><br />

Ut nec metus eget dui sagittis dapibus. Praesent magna nisi, dictum et scelerisque quis, eleifend sit amet turpis. Donec facilisis lectus id augue bibendum at pellentesque ligula consectetur. Aliquam non justo sed nisi fringilla semper eu non arcu. Aliquam volutpat ligula quis urna euismod blandit. Sed non turpis ac massa lacinia pharetra. Curabitur varius erat a ipsum vulputate vitae pulvinar eros consequat. Vivamus in pulvinar magna. Nulla at diam vehicula ipsum vestibulum dignissim ut et libero. Donec tincidunt pulvinar sollicitudin. Curabitur sit amet quam justo. Sed et nulla quis risus ullamcorper auctor vitae ut ante. Vivamus lectus neque, faucibus a vehicula ut, luctus a metus. Morbi commodo blandit sapien vitae fermentum. Aenean pharetra, velit vitae dictum auctor, elit nisi auctor ipsum, ut gravida velit neque et enim. Donec nec purus lorem, at tincidunt velit.
			<br /><br />

Quisque luctus, magna in aliquam fermentum, nibh augue pretium turpis, sed consequat sapien libero in leo. Etiam nisl quam, mollis ac mattis sit amet, tincidunt eget enim. Etiam nec tortor tortor. Pellentesque faucibus justo non lacus lobortis interdum. Suspendisse in massa sed velit placerat accumsan. Fusce quis nunc eu nunc pellentesque faucibus id a orci. Pellentesque a erat turpis. Nullam ornare tristique nunc feugiat porta. In vel laoreet urna. Aenean porttitor risus id augue tincidunt vel porta urna blandit. Quisque quis nibh ante, non consectetur justo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Sed commodo, urna ut commodo tempus, eros mauris mollis ipsum, vitae vulputate elit est eu lectus.


			<br /><br />


		</c:otherwise>

	</c:choose>
        </div>
          <div id="scrollbar" style="display: block; top: 0pt;">
            <div class="scroller" id="scroller" style="height: 134.128px; top: 0pt;">&nbsp;</div>
          </div>
        </div>
        
	<c:if test="<%= !user.isAgreedToTermsOfUse() %>">
		<aui:button-row>
			
            <aui:button type="submit" value="i-agree" />
			<%
			String taglibOnClick = " ";
			%>
<a href="/portal/c/portal/logout" >
			<aui:button onClick="<%= taglibOnClick %>" type="cancel" value="i-disagree" />
            </a>            
            
		</aui:button-row>
	</c:if>
</aui:form>
</div>
<br /><br /><br /><br /><br /><br />
 
    <footer id="footer">
      <div class="footer_wrap">
        <p>Proprietary information © 2012 SLC, LLC</p>
      </div>
    </footer>
 
<style type="text/css">
.d_popup{
	width:700px;
	height:450px;
	padding:20px;
	margin:0 auto;
	border:solid 1px #B2B2B2;
	-moz-box-shadow: 0 0 20px #888;
	-webkit-box-shadow: 0 0 20px#888;
	box-shadow: 0 0 20px #888;
}

#portlet_terms-of-use .portlet-topper{
	display:none;
}
#portlet_terms-of-use .portlet-content{
	padding:0;
}

.d_popup .aui-button-holder{
	border-top:#E5E5E5 solid 1px;
	padding-top:20px;
	margin-top:30px;
}

.d_popup .aui-button-holder .aui-button{
	float:right;
	margin-left:10px;
}
</style>