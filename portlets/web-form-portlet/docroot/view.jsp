<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
%>

<div id="messageText" class="innerModalPopupDiv">
<%@ include file="/init.jsp" %>

<%
String title = LocalizationUtil.getPreferencesValue(preferences, "title", themeDisplay.getLanguageId());
String description = LocalizationUtil.getPreferencesValue(preferences, "description", themeDisplay.getLanguageId());
boolean requireCaptcha = GetterUtil.getBoolean(preferences.getValue("requireCaptcha", StringPool.BLANK));
preferences.setValue("successURL", "/web/guest/admin");
String successURL = preferences.getValue("successURL", StringPool.BLANK);
Calendar calendar =  Calendar.getInstance();
String refererUrl = request.getHeader("Referer");
System.out.println("Success URL:->"+successURL);

%>

<portlet:actionURL var="saveDataURL">
	<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="saveData" />
</portlet:actionURL>
<portlet:resourceURL var="saveDataResURL">
	<portlet:param name="<%= Constants.CMD %>" value="saveData" />
</portlet:resourceURL>

<aui:form action="<%= saveDataResURL %>" method="post" name="fm">
<aui:input type="hidden" name="referUrl" value="<%= refererUrl%>" />
<aui:input type="hidden" name="usrName" value="<%= themeDisplay.getUser().getFirstName()%>" />
<aui:input type="hidden" name="screenName" value="<%= themeDisplay.getUser().getScreenName()%>" />
<aui:input type="hidden" name="dateStamp" value="<%= calendar.getTime()%>" />
<aui:input type="hidden" name="successURL" value="<%= successURL %>" />
 
	<c:if test="<%= Validator.isNull(successURL) %>">
	<%
System.out.println("Success URL:->"+successURL+".....>>>>>"+currentURL);
	%>
		<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	</c:if>
 
	<aui:fieldset label="Report a Problem">
		<em class="description"><%= HtmlUtil.escape(description) %></em>

		<!--<liferay-ui:success key="success" message="the-form-information-was-sent-successfully" />-->

		<liferay-ui:error exception="<%= CaptchaMaxChallengesException.class %>" message="maximum-number-of-captcha-attempts-exceeded" />
		<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
		<liferay-ui:error key="error" message="an-error-occurred-while-sending-the-form-information" />

		<c:if test='<%= WebFormUtil.VALIDATION_SCRIPT_ENABLED && SessionErrors.contains(renderRequest, "validation-script-error") %>'>
			<liferay-util:include page="/script_error.jsp" />
		</c:if>

		<%
		int i = 1;

		String fieldName = "field" + i;
		String fieldLabel = LocalizationUtil.getPreferencesValue(preferences, "fieldLabel" + i, themeDisplay.getLanguageId());
		boolean fieldOptional = PrefsParamUtil.getBoolean(preferences, request, "fieldOptional" + i, false);
		String fieldValue = ParamUtil.getString(request, fieldName);
		String[] options = null;

		while ((i == 1) || Validator.isNotNull(fieldLabel)) {
			String fieldType = preferences.getValue("fieldType" + i, "text");
			String fieldOptions = LocalizationUtil.getPreferencesValue(preferences, "fieldOptions" + i, themeDisplay.getLanguageId());
			String fieldValidationScript = preferences.getValue("fieldValidationScript" + i, StringPool.BLANK);
			String fieldValidationErrorMessage = preferences.getValue("fieldValidationErrorMessage" + i, StringPool.BLANK);
		%>

			<liferay-ui:error key='<%= "error" + fieldLabel %>' message="<%= fieldValidationErrorMessage %>" />

			<c:if test='<%= Validator.isNotNull(fieldValidationScript) %>'>
				<div class="aui-helper-hidden" id="<portlet:namespace/>validationError<%= fieldLabel %>">
					<span class="portlet-msg-error"><%= fieldValidationErrorMessage %></span>
				</div>
			</c:if>

			<c:if test="<%= !fieldOptional %>">
				<div class="aui-helper-hidden" id="<portlet:namespace/>fieldOptionalError<%= fieldLabel %>">
					<span class="portlet-msg-error"><liferay-ui:message key="this-field-is-mandatory" /></span>
				</div>
			</c:if>
 
			<c:choose>
				<c:when test='<%= fieldType.equals("paragraph") %>'>
					<p class="lfr-webform" id="<portlet:namespace /><%= fieldName %>"><%= fieldOptions %></p>
				</c:when>
				<c:when test='<%= fieldType.equals("text") %>'>
					<aui:input cssClass='<%= fieldOptional ? "optional" : StringPool.BLANK %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>"  value="<%= HtmlUtil.escape(fieldValue) %>" />
				</c:when>
				
				<c:when test='<%= fieldType.equals("textarea") %>'>
					<div style="margin-left:151px;margin-top:10px;">
						Please describe your problem in as much detail as possible in the space below.  We already have logged the time and page location of this problem.<strong>  Do not include private student data or passwords in this field.</strong>
					</div>
					<aui:input cssClass='<%= fieldOptional ? "optional" : StringPool.BLANK %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>" type="textarea" value="<%= HtmlUtil.escape(fieldValue) %>" wrap="soft" />
				</c:when>
				<c:when test='<%= fieldType.equals("checkbox") %>'>
					<aui:input cssClass='<%= fieldOptional ? "optional" : StringPool.BLANK %>' inlineLabel="left" label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>" type="checkbox" value="<%= GetterUtil.getBoolean(fieldValue) %>" />
				</c:when>
				<c:when test='<%= fieldType.equals("radio") %>'>
					<aui:field-wrapper cssClass='<%= fieldOptional ? "optional" : StringPool.BLANK %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>">

						 <%
						options = WebFormUtil.split(fieldOptions);

						for (int j = 0; j < options.length; j++) {
							String optionValue = options[j];
						%>

							<aui:input checked="<%= fieldValue.equals(optionValue) %>" inlineLabel="left" label="<%= HtmlUtil.escape(optionValue) %>" name="<%= fieldName %>" type="radio" value="<%= HtmlUtil.escape(optionValue) %>" />

						<%
						}
						%>

					</aui:field-wrapper>
				</c:when>
				<c:when test='<%= fieldType.equals("options") %>'>

					<%
					options = WebFormUtil.split(fieldOptions);
					%>

					 
					<aui:select cssClass='<%= fieldOptional ? "optional" : StringPool.BLANK %>' label="<%= HtmlUtil.escape(fieldLabel) %>" name="<%= fieldName %>">
							<aui:option selected="true" value="">Choose One...</aui:option>
						<%
						for (int j = 0; j < options.length; j++) {
							String optionValue = options[j];
						%>

							<aui:option selected="<%= fieldValue.equals(optionValue) %>" value="<%= HtmlUtil.escape(optionValue) %>"><%= HtmlUtil.escape(optionValue) %></aui:option>

						<%
						}
						%>

					</aui:select>
				</c:when>
			</c:choose>
			

		<%
			i++;

			fieldName = "field" + i;
			fieldLabel = LocalizationUtil.getPreferencesValue(preferences, "fieldLabel" + i, themeDisplay.getLanguageId());
			fieldOptional = PrefsParamUtil.getBoolean(preferences, request, "fieldOptional" + i, false);
			fieldValue = ParamUtil.getString(request, fieldName);
		}
		%>

		<c:if test="<%= requireCaptcha %>">
			<portlet:resourceURL var="captchaURL">
				<portlet:param name="<%= Constants.CMD %>" value="captcha" />
			</portlet:resourceURL>

			<liferay-ui:captcha url="<%= captchaURL %>" />
		</c:if>

		<div class="pop_btn_pnl">
		<aui:button type="submit" value="Report a Problem" />
		<aui:button type="button" onClick="parent.closePop()" value="Cancel" />
        </div>
	</aui:fieldset>
</aui:form>

<aui:script use="aui-base,selector-css3,aui-dialog">
	var form = A.one('#<portlet:namespace />fm');

	if (form) {
		form.on(
			'submit',
			function(event) {
				var keys = [];
				var fieldLabels = {};
				var fieldOptional = {};
				var fieldValidationErrorMessages = {};
				var fieldValidationFunctions = {};
				var fieldsMap = {};

				<%
				int fieldIndex = 1;
				String fieldLabel = preferences.getValue("fieldLabel" + fieldIndex, StringPool.BLANK);

				while ((fieldIndex == 1) || Validator.isNotNull(fieldLabel)) {
					boolean fieldOptional = PrefsParamUtil.getBoolean(preferences, request, "fieldOptional" + fieldIndex, false);
					String fieldType = preferences.getValue("fieldType" + fieldIndex, "text");
					String fieldValidationScript = preferences.getValue("fieldValidationScript" + fieldIndex, StringPool.BLANK);
					String fieldValidationErrorMessage = preferences.getValue("fieldValidationErrorMessage" + fieldIndex, StringPool.BLANK);
				%>

					var key = "<%= HtmlUtil.escape(fieldLabel) %>";

					keys[<%= fieldIndex %>] = key;

					fieldLabels[key] = "<%= HtmlUtil.escape(fieldLabel) %>";
					fieldValidationErrorMessages[key] = "<%= fieldValidationErrorMessage %>";

					function fieldValidationFunction<%= fieldIndex %>(currentFieldValue, fieldsMap) {
						<c:choose>
							<c:when test='<%= Validator.isNotNull(fieldValidationScript) %>'>
								<%= fieldValidationScript %>
							</c:when>
							<c:otherwise>
								return true;
							</c:otherwise>
						</c:choose>
					};

					fieldOptional[key] = <%= fieldOptional %>;
					fieldValidationFunctions[key] = fieldValidationFunction<%= fieldIndex %>;

					<c:choose>
						<c:when test='<%= fieldType.equals("radio") %>'>
							var radioButton = A.one('input[name=<portlet:namespace />field<%= fieldIndex %>]:checked');

							fieldsMap[key] = '';

							if (radioButton) {
								fieldsMap[key] = radioButton.val();
							}
						</c:when>
						<c:otherwise>
							var inputField = A.one('#<portlet:namespace />field<%= fieldIndex %>');

							fieldsMap[key] = (inputField && inputField.val()) || '';
						</c:otherwise>
					</c:choose>

				<%
					fieldIndex++;
					fieldLabel = preferences.getValue("fieldLabel" + fieldIndex, "");
				}
				%>

				var validationErrors = false;

				for (var i = 1; i < keys.length; i++) {
					var key = keys [i];

					var currentFieldValue = fieldsMap[key];

					var optionalFieldError = A.one('#<portlet:namespace />fieldOptionalError' + fieldLabels[key]);
					var validationError = A.one('#<portlet:namespace />validationError' + fieldLabels[key]);

					if (!fieldOptional[key] && currentFieldValue.match(/^\s*$/)) {
						validationErrors = true;

						A.all('.portlet-msg-success').hide();

						if (optionalFieldError) {
							optionalFieldError.show();
						}
					}
					else if (!fieldValidationFunctions[key](currentFieldValue, fieldsMap)) {
						validationErrors = true;

						A.all('.portlet-msg-success').hide();

						if (optionalFieldError) {
							optionalFieldError.hide();
						}

						if (validationError) {
							validationError.show();
						}
					}
					else {
						if (optionalFieldError) {
							optionalFieldError.hide();
						}

						if (validationError) {
							validationError.hide();
						}
					}
				}

				if (validationErrors) {
					event.halt();
					event.stopImmediatePropagation();
				}
			}
			
		);
	}
</aui:script>
 <aui:script use="aui-io-request,aui-parse-content">

	var form = A.one('#<portlet:namespace />fm');

	form.on(
		'submit',
		function(event) {
			var uri = form.getAttribute('action');

			A.io.request(
				uri,
				{
					form: {
						id: form
					},
					on: {
						success: function(event, id, obj) {
							var responseData = this.get('responseData');
							var messageText = document.getElementById("messageText");
							messageText.innerHTML = responseData;

						}
					}
				}
			);

			event.halt();
		}
	);
</aui:script>
</div>

<style type="text/css">
.dockbar{
	display:none;
}
</style>
 