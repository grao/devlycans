<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

<%@ include file="/html/portal/init.jsp" %>

<%
String currentURL = PortalUtil.getCurrentURL(request);

String referer = ParamUtil.getString(request, WebKeys.REFERER, currentURL);

if (referer.equals(themeDisplay.getPathMain() + "/portal/update_terms_of_use")) {
	referer = themeDisplay.getPathMain() + "?doAsUserId=" + themeDisplay.getDoAsUserId();
}
%>

<script type="text/javascript">
var ModalPopupsDefaults = {
	    shadow: true,
	    shadowSize: 5,
	    shadowColor: "#FFFFFF",
	    backgroundColor: "none",
	    borderColor: "#999999",
	    titleBackColor: "#FFFFFF",
	    titleFontColor: "#15428B",
	    popupBackColor: "#FFFFFF",
	    popupFontColor: "black",
	    footerBackColor: "#FFFFFF",
	    footerFontColor: "#15428B",
	    okButtonText: "OK",
	    yesButtonText: "Yes",
	    noButtonText: "No",
	    cancelButtonText: "Cancel",
	    fontFamily: "Arial, Helvetica, sans-serif",
	    fontSize: "13px"
	}

	var ModalPopups = {
	    Init: function() {
	        //No init required, yet
	    },
	    
	    SetDefaults: function(parameters) {
	        parameters = parameters || {};
	        ModalPopupsDefaults.shadow = parameters.shadow != null ? parameters.shadow : ModalPopupsDefaults.shadow;
	        ModalPopupsDefaults.shadowSize = parameters.shadowSize != null ? parameters.shadowSize : ModalPopupsDefaults.shadowSize;
	        ModalPopupsDefaults.shadowColor = parameters.shadowColor != null ? parameters.shadowColor : ModalPopupsDefaults.shadowColor;
	        ModalPopupsDefaults.backgroundColor = parameters.backgroundColor != null ? parameters.backgroundColor : ModalPopupsDefaults.backgroundColor;
	        ModalPopupsDefaults.borderColor = parameters.borderColor != null ? parameters.borderColor : ModalPopupsDefaults.borderColor;
	        ModalPopupsDefaults.okButtonText = parameters.okButtonText != null ? parameters.okButtonText : ModalPopupsDefaults.okButtonText;
	        ModalPopupsDefaults.yesButtonText = parameters.yesButtonText != null ? parameters.yesButtonText : ModalPopupsDefaults.yesButtonText;
	        ModalPopupsDefaults.noButtonText = parameters.noButtonText != null ? parameters.noButtonText : ModalPopupsDefaults.noButtonText;
	        ModalPopupsDefaults.cancelButtonText = parameters.cancelButtonText != null ? parameters.cancelButtonText : ModalPopupsDefaults.cancelButtonText;
	        ModalPopupsDefaults.titleBackColor = parameters.titleBackColor != null ? parameters.titleBackColor : ModalPopupsDefaults.titleBackColor;
	        ModalPopupsDefaults.titleFontColor = parameters.titleFontColor != null ? parameters.titleFontColor : ModalPopupsDefaults.titleFontColor;
	        ModalPopupsDefaults.popupBackColor = parameters.popupBackColor != null ? parameters.popupBackColor : ModalPopupsDefaults.popupBackColor;
	        ModalPopupsDefaults.popupFontColor = parameters.popupFontColor != null ? parameters.popupFontColor : ModalPopupsDefaults.popupFontColor;
	        ModalPopupsDefaults.footerBackColor = parameters.footerBackColor != null ? parameters.footerBackColor : ModalPopupsDefaults.footerBackColor;
	        ModalPopupsDefaults.footerFontColor = parameters.footerFontColor != null ? parameters.footerFontColor : ModalPopupsDefaults.footerFontColor;
	        ModalPopupsDefaults.fontFamily = parameters.fontFamily != null ? parameters.fontFamily : ModalPopupsDefaults.fontFamily;
	        ModalPopupsDefaults.fontSize = parameters.fontSize != null ? parameters.fontSize : ModalPopupsDefaults.fontSize;
	    },

	    Alert: function(id, title, message, parameters) {
	        //Get parameters
	        parameters = parameters || {};
	        if(!title) title = "Alert";

	        //'Alert' specific parameters
	        parameters.buttons = "ok";
	        parameters.okButtonText = parameters.okButtonText != null ? parameters.okButtonText : ModalPopupsDefaults.okButtonText;

	        //Create layers
	        var myLayers = ModalPopups._createAllLayers(id, title, message, parameters);
	        var oPopupBody = myLayers[4];
	        
	        //'Alert' specific setup of Body
	        oPopupBody.innerHTML = message;

	        //Style all layers        
	        ModalPopups._styleAllLayers(id, parameters, myLayers);
	    },

	    Confirm: function(id, title, question, parameters) {
	        //Get parameters
	        parameters = parameters || {};
	        if(!title) title = "Confirm";

	        //'Confirm' specific parameters
	        parameters.buttons = "yes,no";
	        parameters.yesButtonText = parameters.yesButtonText != null ? parameters.yesButtonText : ModalPopupsDefaults.yesButtonText;
	        parameters.noButtonText = parameters.noButtonText != null ? parameters.noButtonText : ModalPopupsDefaults.noButtonText;

	        //Create layers
	        var myLayers = ModalPopups._createAllLayers(id, title, question, parameters);
	        var oPopupBody = myLayers[4];
	        
	        //'Confirm' specific setup of Body
	        oPopupBody.innerHTML = question;
	        
	        //Style all layers   
	        ModalPopups._styleAllLayers(id, parameters, myLayers);
	    },
	    
	    YesNoCancel: function(id, title, question, parameters) {
	        //Get parameters
	        parameters = parameters || {};
	        if(!title) title = "YesNoCancel";

	        //'Confirm' specific parameters
	        parameters.buttons = "yes,no,cancel";
	        parameters.yesButtonText = parameters.yesButtonText != null ? parameters.yesButtonText : ModalPopupsDefaults.yesButtonText;
	        parameters.noButtonText = parameters.noButtonText != null ? parameters.noButtonText : ModalPopupsDefaults.noButtonText;
	        parameters.cancelButtonText = parameters.cancelButtonText != null ? parameters.cancelButtonText : ModalPopupsDefaults.cancelButtonText;

	        //Create layers
	        var myLayers = ModalPopups._createAllLayers(id, title, question, parameters);
	        var oPopupBody = myLayers[4];
	        
	        //'Confirm' specific setup of Body
	        oPopupBody.innerHTML = question;
	        
	        //Style all layers   
	        ModalPopups._styleAllLayers(id, parameters, myLayers);
	    },
	    
	    Prompt: function(id, title, question, parameters) {
	        //Get parameters
	        parameters = parameters || {};
	        if(!title) title = "Prompt";
	        
	        //'Prompt' specific parameters
	        parameters.buttons = "ok,cancel";
	        parameters.okButtonText = parameters.okButtonText != null ? parameters.okButtonText : "OK";
	        parameters.cancelButtonText = parameters.cancelButtonText != null ? parameters.cancelButtonText : "Cancel";
	        
	        //Create layers
	        var myLayers = ModalPopups._createAllLayers(id, title, question, parameters);
	        var oPopupBody = myLayers[4];
	        
	        var txtStyle = "";
	        if(parameters.width != null)
	            txtStyle = "width:95%;";

	        //'Prompt' specific setup of Body
	        var txtHtml = question + "<br/>";
	        txtHtml += "<input type=text id='" + id + "_promptInput' value='' " + 
	            "style='border: solid 1px #859DBE; "  + txtStyle + "'>";

	        oPopupBody.innerHTML = txtHtml;
	        
	        //Style all layers   
	        ModalPopups._styleAllLayers(id, parameters, myLayers);

	        //Focus input box        
	        ModalPopupsSupport.findControl(id+"_promptInput").focus();
	    },
	    
	    GetPromptInput: function(id) {
	        var promptValue = ModalPopupsSupport.findControl(id+"_promptInput");
	        return promptValue;
	    },
	    
	    GetPromptResult: function(id) {
	        var promptValue = ModalPopupsSupport.findControl(id+"_promptInput");
	        return promptValue;
	    },
	    
	    GetCustomControl: function(id) {
	        return ModalPopupsSupport.findControl(id);
	    },
	    
	    Indicator: function(id, title, message, parameters) {
	        //Get parameters
	        parameters = parameters || {};
	        if(!title) title = "Indicator";

	        //'Indicator' specific parameters
	        if(parameters.buttons == null)
	            parameters.buttons = "";

	        //Create layers
	        var myLayers = ModalPopups._createAllLayers(id, title, message, parameters);
	        var oPopupBody = myLayers[4];
	        
	        //'Indicator' specific setup of Body
	        oPopupBody.innerHTML = message;

	        //Style all layers        
	        ModalPopups._styleAllLayers(id, parameters, myLayers);
	    },

	    //Custom modal popup. parameters.buttons is a mandatory parameter
	    Custom: function(id, title, contents, parameters) {
	        //Get parameters
	        parameters = parameters || {};
	        if(!title) title = "Custom";
	        
	        if(parameters.buttons == null)
	        {
	            alert("buttons is a required parameter. ie: buttons: 'yes,no' or buttons: 'ok'.\nPossible buttons are yes, no, ok, cancel");
	            return;
	        }

	        //Create layers
	        var myLayers = ModalPopups._createAllLayers(id, title, contents, parameters);
	        var oPopupBody = myLayers[4];
	        
	        //'Custom' specific setup of Body
	        oPopupBody.innerHTML = contents;

	        //Style all layers        
	        ModalPopups._styleAllLayers(id, parameters, myLayers);
	    },

	    //Cancel/Close modal popup    
	    Close: function(id) {
	        window.onresize = null;
	        window.onscroll = null;
	    
	        //try
	        //{
	            document.body.removeChild(ModalPopupsSupport.findControl(id+"_background"));
	            document.body.removeChild(ModalPopupsSupport.findControl(id+"_popup"));
	            document.body.removeChild(ModalPopupsSupport.findControl(id+"_shadow"));
	        //}
	        //catch
	        //{
	        //}
	    },

	    //Cancel/Close modal popup    
	    Cancel: function(id) {
	        ModalPopups.Close(id);
	    },
	    
	     //Support variable to put each layer on top, increases everytime a modal popup is created
	    _zIndex: 10000,
	    
	     //Support function to create all layers
	    _createAllLayers: function(id, title, message, parameters) {
	        //Create all 6 layers for; BackGround, Popup, Shadow, PopupTitle, PopupBody, PopupFooter
	        var oBackground = ModalPopupsSupport.makeLayer(id+'_background', true, null);        // 0
	        var oPopup = ModalPopupsSupport.makeLayer(id+'_popup', true, null);                  // 1
	        var oShadow = ModalPopupsSupport.makeLayer(id+'_shadow', true, null);                // 2
	        var oPopupTitle = ModalPopupsSupport.makeLayer(id+'_popupTitle', true, oPopup);      // 3
	        var oPopupBody = ModalPopupsSupport.makeLayer(id+'_popupBody', true, oPopup);        // 4
	        var oPopupFooter = ModalPopupsSupport.makeLayer(id+'_popupFooter', true, oPopup);    // 5
	        
	        //Set default values for button related parameters; OK, Yes, No, Cancel
	        var okButtonText = parameters.okButtonText != null ? parameters.okButtonText : ModalPopupsDefaults.okButtonText;
	        var yesButtonText = parameters.yesButtonText != null ? parameters.yesButtonText : ModalPopupsDefaults.yesButtonText;
	        var noButtonText = parameters.noButtonText != null ? parameters.noButtonText : ModalPopupsDefaults.noButtonText;
	        var cancelButtonText = parameters.cancelButtonText != null ? parameters.cancelButtonText : ModalPopupsDefaults.cancelButtonText;
	        var onOk = parameters.onOk != null ? parameters.onOk : "ModalPopups.Close(\"" + id + "\");";
	        var onYes = parameters.onYes != null ? parameters.onYes : "ModalPopups.Close(\"" + id + "\");";
	        var onNo = parameters.onNo != null ? parameters.onNo : "ModalPopups.Close(\"" + id + "\");";
	        var onCancel = parameters.onCancel != null ? parameters.onCancel : "ModalPopups.Close(\"" + id + "\");";
	        
	        //Create popup 'title' layer
	        oPopupTitle.innerHTML = "<table cellpadding='0' cellspacing='0' style='border: 0;' height='100%'>" +
	            "<tr><td valign='middle'><b>" + title + "</b></td></tr>" + 
	            "</table>" ;
	        
	        //Create popup 'footer' layer
	        oPopupFooter.innerHTML = "";
	            
	        //Split buttons parameter and create buttons; OK, Yes, No, Cancel
	        parameters.fontFamily = parameters.fontFamily != null ? parameters.fontFamily : ModalPopupsDefaults.fontFamily;
	        var bt = parameters.buttons.split(',');
	        for(x in bt) {
	            if(bt[x] == "ok")
	                oPopupFooter.innerHTML += "<input name='" + id + "_okButton' id='" + id + "_okButton' type=button value='" + okButtonText + "' style='margin-right: 5px; margin-left: 5px;' onclick='" + onOk + "'/>";
	            if(bt[x] == "yes")
	                oPopupFooter.innerHTML += "<input name='" + id + "_yesButton' id='" + id + "_yesButton' type=button value='" + yesButtonText + "' style='margin-right: 5px; margin-left: 5px;' onclick='" + onYes + "'/>";
	            if(bt[x] == "no")
	                oPopupFooter.innerHTML += "<input name='" + id + "_noButton' id='" + id + "_noButton' type=button value='" + noButtonText + "' style='margin-right: 5px; margin-left: 5px;' onclick='" + onNo + "'/>";
	            if(bt[x] == "cancel")
	                oPopupFooter.innerHTML += "<input name='" + id + "_cancelButton' id='" + id + "_cancelButton' type=button value='" + cancelButtonText + "' style='height:20px; margin-right: 5px; margin-left: 5px;' onclick='" + onCancel + "'/>";
	        }
	        
	        //Create popup 'body' layer, is done in; Alert, Confirm, YesNoCancel, Prompt and Custom functions.
	        var allLayers = new Array(oBackground, oPopup, oShadow, oPopupTitle, oPopupBody, oPopupFooter);
	        
	        if(parameters.autoClose != null )
	            setTimeout('ModalPopups.Close(\"'+id+'\");', parameters.autoClose);

	        return allLayers;
	    },
	    
	     //Support function to style and position all layers
	    _styleAllLayers: function(id, parameters, allLayers) {
	        var myLayers = allLayers;
	        var oBackground = myLayers[0];
	        var oPopup = myLayers[1];
	        var oShadow = myLayers[2];
	        var oPopupTitle = myLayers[3];
	        var oPopupBody = myLayers[4];
	        var oPopupFooter = myLayers[5];
	        
	        ModalPopups._zIndex += 3;
	        var zIndex = ModalPopups._zIndex;

	        //Get Css parameters for borderColor. 
	        parameters.borderColor = parameters.borderColor != null ? parameters.borderColor : ModalPopupsDefaults.borderColor;  // #859DBE

	        //Default css for; oBackground, oPopup and oShadow layers
	        //Position elements excluded (except for background); top, left, width, height. 
	        //They will be calculated by contents of oPopup, or set by the parameters.
	        var cssBackground = "display:inline; position:absolute; z-index: " + (zIndex) + "; left:0px; top:0px; width:100%; height:100%; filter:alpha(opacity=70); opacity:0.7;";
	        var cssShadow = "display:inline; position:absolute; z-index: " + (zIndex+1) + ";"; 
	        var cssPopup = "display:inline; position:absolute; z-index: " + (zIndex+2) + "; background-color:white; color:black; border:solid 1px " + parameters.borderColor + "; padding:1px;"; // background-color:#EEF1F2

	        //Get Css parameters for oBackGround layer. 
	        parameters.backgroundColor = parameters.backgroundColor != null ? parameters.backgroundColor : ModalPopupsDefaults.backgroundColor;
	        cssBackground += " background-color:" + parameters.backgroundColor + ";";

	        //Css for oPopup content layers. (oPopupTitle, oPopupBody, oPopupFooter)
	        parameters.fontFamily = parameters.fontFamily != null ? parameters.fontFamily : ModalPopupsDefaults.fontFamily;
	        parameters.fontSize = parameters.fontSize != null ? parameters.fontSize : ModalPopupsDefaults.fontSize;
	        var cssPopupTitle = "position: absolute; font-family:" + parameters.fontFamily + "; font-size:" + parameters.fontSize + "; padding: 5px; text-align:left;";
	        var cssPopupBody = "position: absolute; font-family:" + parameters.fontFamily + "; font-size:" + parameters.fontSize + "; padding: 30px; text-align:left;";
	        var cssPopupFooter = "position: absolute; font-family:" + parameters.fontFamily + "; font-size:" + parameters.fontSize + "; padding: 5px; text-align:right;";

	        //First style the contents of the oPopup layer. (oPopupTitle, oPopupBody, oPopupFooter)
	        //When this is done we can calculate the height and width of the oPopup contents.
	        if(ModalPopupsSupport.isIE) {
	            oPopupTitle.style.cssText = cssPopupTitle;
	            oPopupBody.style.cssText = cssPopupBody; 
	            oPopupFooter.style.cssText = cssPopupFooter; 
	        }
	        else { 
	            oPopupTitle.setAttribute("style", cssPopupTitle);
	            oPopupBody.setAttribute("style", cssPopupBody);
	            oPopupFooter.setAttribute("style", cssPopupFooter);
	        } 

	        //Get css color related parameters for; oPopup, oPopupTitle, oPopupBody, oPopupFooter.
	        parameters.titleBackColor = parameters.titleBackColor != null ? parameters.titleBackColor : ModalPopupsDefaults.titleBackColor;
	        parameters.titleFontColor = parameters.titleFontColor != null ? parameters.titleFontColor : ModalPopupsDefaults.titleFontColor;
	        parameters.popupBackColor = parameters.popupBackColor != null ? parameters.popupBackColor : ModalPopupsDefaults.popupBackColor;
	        parameters.popupFontColor = parameters.popupFontColor != null ? parameters.popupFontColor : ModalPopupsDefaults.popupFontColor;
	        parameters.footerBackColor = parameters.footerBackColor != null ? parameters.footerBackColor : ModalPopupsDefaults.footerBackColor;
	        parameters.footerFontColor = parameters.footerFontColor != null ? parameters.footerFontColor : ModalPopupsDefaults.footerFontColor;
	        cssPopupTitle += " background-color:" + parameters.titleBackColor + ";";
	        cssPopupTitle += " color:" + parameters.titleFontColor + ";";
	        cssPopupBody += " background-color:" + parameters.popupBackColor + ";";
	        cssPopupBody += " color:" + parameters.popupFontColor + ";";
	        cssPopupFooter += " background-color:" + parameters.footerBackColor + ";";
	        cssPopupFooter += " color:" + parameters.footerFontColor + ";";

	        //Calculate maxWidth of the 3 layers in oPopup. (oPopupTitle,oPopupBody,oPopupFooter)
	        var calcMaxWidth = 0;
	        if(ModalPopupsSupport.getLayerWidth(oPopupTitle.id) > calcMaxWidth) 
	            calcMaxWidth = ModalPopupsSupport.getLayerWidth(oPopupTitle.id);
	        if(ModalPopupsSupport.getLayerWidth(oPopupBody.id) > calcMaxWidth)
	            calcMaxWidth = ModalPopupsSupport.getLayerWidth(oPopupBody.id);  
	        if(ModalPopupsSupport.getLayerWidth(oPopupFooter.id) > calcMaxWidth)
	            calcMaxWidth = ModalPopupsSupport.getLayerWidth(oPopupFooter.id);   
	                        
	        //Calculate total height of the 3 layers in oPopup. (oPopupTitle+oPopupBody+oPopupFooter)
	        var calcTotalHeight = ModalPopupsSupport.getLayerHeight(oPopupTitle.id) + ModalPopupsSupport.getLayerHeight(oPopupBody.id) + ModalPopupsSupport.getLayerHeight(oPopupFooter.id);    
	        
	        parameters.width = parameters.width != null ? parameters.width : (calcMaxWidth + 4); // Add 4px for; padding: 1px and border: 1px;
	        parameters.height = parameters.height != null ? parameters.height : calcTotalHeight; // Set height as height of; oPopupTitle + oPopupBody + oPopupFooter
	        
	        //Eerst hoogte oPopupBody aanpassen indien parameters.height is meegegeven
	        var newBodyHeight = ModalPopupsSupport.getLayerHeight(oPopupBody.id)
	        if(parameters.height > calcTotalHeight) {
	            // Sub 10px for; padding: 5px;
	            newBodyHeight = parameters.height - ModalPopupsSupport.getLayerHeight(oPopupTitle.id) - ModalPopupsSupport.getLayerHeight(oPopupFooter.id);
	            cssPopupBody += " height:" + newBodyHeight + "px;";
	            calcTotalHeight = ModalPopupsSupport.getLayerHeight(oPopupTitle.id) + newBodyHeight + ModalPopupsSupport.getLayerHeight(oPopupFooter.id);  
	        }
	        
	        cssPopupTitle += " top:1px;";
	        cssPopupBody += " top:" + ModalPopupsSupport.getLayerHeight(oPopupTitle.id) + "px;";
	        cssPopupFooter += " bottom:0;";
	        cssPopupTitle += "width:710px;"; // Sub 10px for; padding-left+right: 5px;
	        cssPopupBody += " width:660px;"; // Sub 10px for-left+right; padding: 5px;
	        cssPopupFooter += " width:660px;padding-top:20px;border-top:#E5E5E5 solid 1px;display:block;margin-top:20px;margin-left:25px;margin-bottom:25px;"; // Sub 10px for-left+right; padding: 5px;

			cssPopupBody += " height:370px;";

	         //Get browser width and height
	        var frameWidth = ModalPopupsSupport.getFrameWidth();
	        var frameHeight = ModalPopupsSupport.getFrameHeight();
	        
	        if(parameters.height < calcTotalHeight)
	            parameters.height = calcTotalHeight;
	        
	        //Get parameters for oPopup layer.
	        parameters.top = parameters.top != null ? parameters.top : ((frameHeight/2) - (parameters.height/2));
	        parameters.left = parameters.left != null ? parameters.left : ((frameWidth/2) - (parameters.width/2));

	        //Set modal popup position
	        //cssPopup += " top:" + parameters.top + "px;";
	        //cssPopup += " left:" + parameters.left + "px;";
	        
	        cssPopupTitle += " left:1px;";
	        cssPopupBody += " left:1px;";
	        cssPopupFooter += " left:1px;";
	        
	        if(parameters.width) 
	            cssPopup += " width:720px;";
	        else
	            cssPopup += " width:720px;";
	            
	        if(parameters.height) 
	            cssPopup += " height:470px;";
	        else
	            cssPopup += " height:470px;";
	        
	        //First style the contents of the oPopup layer. (oPopupTitle, oPopupBody, oPopupFooter)
	        //When this is done we can calculate the height and width of the oPopup contents.
	        if(ModalPopupsSupport.isIE) {
	            oPopupTitle.style.cssText = cssPopupTitle;
	            oPopupBody.style.cssText = cssPopupBody; 
	            oPopupFooter.style.cssText = cssPopupFooter; 
	        }
	        else { 
	            oPopupTitle.setAttribute("style", cssPopupTitle);
	            oPopupBody.setAttribute("style", cssPopupBody);
	            oPopupFooter.setAttribute("style", cssPopupFooter);
	        }   

	        //Setup shadow layer
	        parameters.shadow = parameters.shadow != null ? parameters.shadow : ModalPopupsDefaults.shadow;
	        parameters.shadowSize = parameters.shadowSize != null ? parameters.shadowSize : ModalPopupsDefaults.shadowSize;
	        if(parameters.shadow) {
	            //Get parameters for oShadow layer.
	            parameters.shadowSize = parameters.shadowSize != null ? parameters.shadowSize : ModalPopupsDefaults.shadowSize;
	            parameters.shadowColor = parameters.shadowColor != null ? parameters.shadowColor : ModalPopupsDefaults.shadowColor;
	            cssShadow += "background-color:" + parameters.shadowColor + ";"; 
	        
	            //cssShadow += " top:" + (parameters.top + parameters.shadowSize) + "px;";
	            //cssShadow += " left:" + (parameters.left + parameters.shadowSize) + "px;";
	            if(parameters.width) 
	                cssShadow += " width:720px;";
	            else
	                cssShadow += " width:720px;";
	            if(parameters.height) 
	                cssShadow += " height:470px;";
	            else
	                cssShadow += " height:470px;";
	            
	        }
	        else {
	            cssShadow += " display:none;";
	        }
	        
	        //Secondly style the contents of the main layers. (oBackGround, oPopup, oShadow)
	        if(ModalPopupsSupport.isIE) {
	            oPopup.style.cssText = cssPopup; 
	            oShadow.style.cssText = cssShadow; 
	            oBackground.style.cssText = cssBackground; 
	        }
	        else {
	            oPopup.setAttribute("style", cssPopup);
	            oShadow.setAttribute("style", cssShadow);
	            oBackground.setAttribute("style", cssBackground);
	        }
	        
	        ModalPopupsSupport.centerElement(document.getElementById(id+'_background'), 0, true);
	        ModalPopupsSupport.centerElement(document.getElementById(id+'_popup'), 0, false);
	        if(parameters.shadow)
	            ModalPopupsSupport.centerElement(document.getElementById(id+'_shadow'), parameters.shadowSize, false);
	        
	        //Load file?
	        parameters.loadTextFile = parameters.loadTextFile != null ? parameters.loadTextFile : "";
	        if(parameters.loadTextFile != "")
	            ModalPopups._loadTextFile(id, parameters, allLayers, parameters.loadTextFile);
	            
//	        parameters.autoClose = parameters.autoClose != null ? parameters.autoClose : 0;
//	        if(!parameters.autoClose)
//	        {
	        window.onresize = function() {
	            ModalPopupsSupport.centerElement(document.getElementById(id+'_background'), 0, true);
	            ModalPopupsSupport.centerElement(document.getElementById(id+'_popup'), 0, false);
	            if(parameters.shadow) {
	                ModalPopupsSupport.centerElement(document.getElementById(id+'_shadow'), parameters.shadowSize, false);
	                }
	            }
	            
	        window.onscroll = function() {
	            ModalPopupsSupport.centerElement(document.getElementById(id+'_background'), 0, true);
	            ModalPopupsSupport.centerElement(document.getElementById(id+'_popup'), 0, false);
	            if(parameters.shadow) {
	                ModalPopupsSupport.centerElement(document.getElementById(id+'_shadow'), parameters.shadowSize, false);
	                }
	        }

	        //}
	     },
	     
	     //Support function to load text file via AJAX call
	     _loadTextFile: function(id, parameters, allLayers, filename)
	     {
	        var objXml = ModalPopupsSupport.getXmlHttp(); 
	        objXml.open("GET", filename, true);
	        objXml.onreadystatechange=function() 
	        {
	            if (objXml.readyState==4) 
	            {
	                var txt = objXml.responseText.replace("\r\n","<br>").replace("\n\r","<br>").replace("\n","<br>").replace("\r","<br>");
	                var html = "<div style='overflow-y: scroll; position:absolute; " + 
	                    "top:5px; left:5px; height:" + (parameters.height - 65) + "px; " + 
	                    "width:" + (parameters.width - 10) + "px;'>";
	                html += txt;
	                html += "</div>";
	                ModalPopups.GetCustomControl(id+"_popupBody").innerHTML = html;
	                parameters.loadTextFile = "";
	                ModalPopups._styleAllLayers(id, parameters, allLayers);
	            }
	        }
	        objXml.send(null);
	    }
	};

	var ModalPopupsSupport = {
	    isIE: function() {
	        return (window.ActiveXObject) ? true : false;
	    },
	    
	    getDialog: function() {
	    
	    },
	    
	    makeLayer : function(id,layerVisible,layerParent) {
	        var container = document.createElement("div");
	        container.id = id;
	        
	        if(layerParent)
	            layerParent.appendChild(container);
	        else
	            document.body.appendChild(container);
	        
	        return container;
	    },
	    
	    deleteLayer: function(id) {
	        var del = findLayer(id);
	        if(del) 
	            document.body.removeChild(del);
	    },
	    
	    findLayer: function(id) {
	        return document.all ? document.all[id] : document.getElementById(id);
	    },
	        
	    findControl: function(id, parent) {
	        if(parent == null)
	        {  
	            return document.all ? document.all[id] : document.getElementById(id);
	        }
	        else
	        {
	            return document.all ? document.all[id] : document.getElementById(id);
	        }
	    },
	    
	    getLayerHeight: function(id) {
	        if (document.all) {
	            gh = document.getElementById(id).offsetHeight;  
	        }
	        else {
	            gh = document.getElementById(id).offsetHeight;  //-5;
	        }
	        return gh;
	    },
	    
	    getLayerWidth: function(id) {
	        gw = document.getElementById(id).offsetWidth;
	        return gw;
	    },
	    
	    getViewportDimensions: function() {
	        var intH = 0, intW = 0;
	        
	        if(self.innerHeight) {
	           intH = window.innerHeight;
	           intW = window.innerWidth;
	        } 
	        else {
	            if(document.documentElement && document.documentElement.clientHeight) {
	                intH = document.documentElement.clientHeight;
	                intW = document.documentElement.clientWidth;
	            }
	            else {
	                if(document.body) {
	                    intH = document.body.clientHeight;
	                    intW = document.body.clientWidth;
	                }
	            }
	        }

	        return {
	            height: parseInt(intH, 10),
	            width: parseInt(intW, 10)
	        };
	    },
	    
	    getScrollXY: function() {
	        var scrOfX = 0, scrOfY = 0;
	        if( typeof( window.pageYOffset ) == 'number' ) {
	            //Netscape compliant
	            scrOfY = window.pageYOffset;
	            scrOfX = window.pageXOffset;
	        } else if( document.body && ( document.body.scrollLeft || document.body.scrollTop ) ) {
	            //DOM compliant
	            scrOfY = document.body.scrollTop;
	            scrOfX = document.body.scrollLeft;
	        } else if( document.documentElement && ( document.documentElement.scrollLeft || document.documentElement.scrollTop ) ) {
	            //IE6 standards compliant mode
	            scrOfY = document.documentElement.scrollTop;
	            scrOfX = document.documentElement.scrollLeft;
	        }
	        return [ scrOfX, scrOfY ];
	        },
	    
	    centerElement: function(elem,add,noleft) {
	        var viewport = ModalPopupsSupport.getViewportDimensions();
	        var left = (viewport.width == 0) ? 50 : parseInt((viewport.width - elem.offsetWidth) / 2, 10);
	        var top = (viewport.height == 0) ? 50 : parseInt((viewport.height - elem.offsetHeight) / 2, 10);
	        var scroll = ModalPopupsSupport.getScrollXY();
	        //alert(scroll[1]);

	        if(!noleft) {
	            elem.style.left = (left + add) + 'px';
	        }
	        elem.style.top = (top + add + scroll[1]) + 'px';

	        viewport, left, top, elem = null;    
	    },
	    
	    readFile: function(filename, intoElement) {
	        var xmlHttp = getXmlHttp();
	        var file = filename+"?r="+Math.random();
	        xmlHttp.open("GET", file, true);
	        xmlHttp.onreadystatechange=function() 
	        {
	            if (xmlHttp.readyState==4) 
	            {
	                intoElement.innerHTML = xmlHttp.responseText;
	            }
	        }
	        xmlHttp.send(null);
	    },
	        
	    getFrameWidth: function() {
	        var frameWidth = document.documentElement.clientWidth;
	        if (self.innerWidth) // Als de browser deze manier van aanroepen hanteerd
	        {
	            frameWidth = self.innerWidth; // Haal de frame-width op
	        }
	        else if (document.documentElement && document.documentElement.clientWidth)  // Als de browser deze manier van aanroepen hanteerd
	        {
	            frameWidth = document.documentElement.clientWidth; // Haal de frame-width op
	        }
	        else if (document.body)  // Als de browser deze manier van aanroepen hanteerd
	        {
	            frameWidth = document.body.clientWidth; // Haal de frame-width op
	        }
	        else return;
	        return frameWidth;
	    },
	    
	    getFrameHeight: function() {
	        var frameHeight = document.documentElement.clientHeight;
	        if (self.innerWidth) // Als de browser deze manier van aanroepen hanteerd
	        {
	            frameHeight = self.innerHeight; // Haal de frame-height op
	        }
	        else if (document.documentElement && document.documentElement.clientWidth)  // Als de browser deze manier van aanroepen hanteerd
	        {
	            frameHeight = document.documentElement.clientHeight; // Haal de frame-height op
	        }
	        else if (document.body)  // Als de browser deze manier van aanroepen hanteerd
	        {
	            frameHeight = document.body.clientHeight; // Haal de frame-height op
	        }
	        else return;
	        return frameHeight;
	    },
	    
	    getXmlHttp: function()
	    {
	        var xmlHttp;
	        try
	        {  // Firefox, Opera 8.0+, Safari  
	            xmlHttp=new XMLHttpRequest();  
	        }
	        catch (e)
	        {  // Internet Explorer  
	            try
	            {    
	                xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");    
	            }
	            catch (e)
	            {    
	                try
	                {      
	                    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");      
	                }
	                catch (e)
	                {      
	                    alert("Your browser does not support AJAX!");      
	                    return false;      
	                }    
	            }  
	        }  
	        return xmlHttp;
	    }
	    
	    

	};

</script>

<body onLoad="ModalPopupsConfirm()">
<aui:form action='<%= themeDisplay.getPathMain() + "/portal/update_terms_of_use" %>' name="fm">
	<aui:input name="doAsUserId" type="hidden" value="<%= themeDisplay.getDoAsUserId() %>" />
	<aui:input name="<%= WebKeys.REFERER %>" type="hidden" value="<%= referer %>" />

     <div id="banner">
         <div id="heading">
              <div class="portlet-layout">
                   <div class="portlet-column portlet-column-only" id="column-1">
                         <div class="logo_main"> <a href="<%= themeDisplay.getURLHome() %>"> <img class="company-logo" src="<%= themeDisplay.getCompanyLogo() %>" width="<%= themeDisplay.getCompanyLogoWidth() %>" height="<%= themeDisplay.getCompanyLogoHeight() %>"/> </a> </div>
                   </div>
              </div>
        </div>
        
    </div>
    <div id="content_main">
    <div class="home_title">HOME</div>
	</div>
    <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
     <div id="content_main" >
    <footer id="footer">
      <div class="footer_wrap">
        <p>Proprietary information � 2012 SLC, LLC</p>
      </div>
    </footer>
    </div>
<!-- <div align="center"><span style="font-family:Casual;font-size:16px;font-weight:bold;font-style:normal;text-decoration:none;color:#000000;">License Agreement</span></div> -->

 <!-- This is <b>Wireless Generation EULA</b> page.(dummy text) -->
<!--  <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi viverra urna quis ante bibendum gravida. Suspendisse lorem eros, vehicula quis condimentum eget, pharetra ac enim. Phasellus elit enim, eleifend a pharetra et, tempus vel ligula. Etiam aliquam mi ut mi tristique accumsan.Aliquam ut velit ante. Praesent pulvinar, enim ac feugiat pharetra, massa ipsum rhoncus tellus, sed venenatis arcu ipsum quis nibh. Phasellus lacinia venenatis arcu, eu aliquet urna dapibus vel. Pellentesque tempor dictum turpis ac ullamcorper. Donec est ipsum, dictum eget gravida eget, vulputate et urna. Praesent a ipsum faucibus velit gravida placerat. Ut odio lorem, condimentum nec eleifend a, vehicula ut nulla. In rutrum augue eu nibh egestas id congue sapien vestibulum. Proin eleifend tempor ipsum et ultrices. Sed id velit volutpat diam iaculis egestas. Aliquam lobortis lectus sit amet ante sollicitudin in vehicula nulla placerat. Nulla adipiscing magna eget lorem semper vel bibendum leo scelerisque.</div>
<div>&nbsp;</div>
<div>Suspendisse at erat a magna malesuada blandit. Vestibulum rhoncus, diam sed porta egestas, enim velit sagittis lorem, in scelerisque risus nisl at elit. Duis accumsan tempor turpis, id imperdiet nisi sodales a. Sed metus magna, elementum ut sagittis pretium, vulputate sed tellus. Integer consequat fringilla libero et venenatis. Nulla ut dolor quam, ac vulputate risus. Sed fermentum ultricies interdum. Vestibulum rhoncus nulla eu ipsum dignissim volutpat. Donec lacus lectus, varius id posuere eu, dictum sagittis nulla. Etiam quis sem mi, vel porta metus. Phasellus auctor, elit eu aliquam malesuada, sem tellus posuere neque, sed semper arcu purus ac nibh. Integer lobortis lorem libero, ac feugiat lectus. Aliquam eu purus id orci cursus fringilla. Fusce at blandit erat.</div>
<div>&nbsp;</div>
<div>Vivamus lacus lorem, venenatis in tincidunt ac, gravida ut turpis. Ut in mi tortor. Proin nec sapien orci. Ut vitae tincidunt velit. Suspendisse potenti. Vestibulum consequat feugiat metus non tincidunt. Donec elementum porttitor metus, et egestas libero consectetur non. Nulla diam lectus, malesuada lacinia porta sit amet, feugiat non magna. Donec dignissim sagittis ultrices. Curabitur porttitor faucibus nulla, eu feugiat magna bibendum vel. Donec ultrices ipsum sed magna varius sodales.</div>
<div>&nbsp;</div>
<div>Vivamus luctus adipiscing vestibulum. Sed a nunc quis metus tempor rhoncus. Proin imperdiet nibh id erat tempus eu adipiscing nulla pulvinar. Quisque porta placerat lectus ut aliquet. Ut a quam est, sit amet tincidunt lacus. Sed eros odio, aliquam varius rutrum non, tincidunt non ante. Nam facilisis, ipsum et pulvinar sollicitudin, nunc magna fermentum nibh, nec lacinia neque velit nec urna. Etiam pellentesque venenatis enim, nec accumsan nisl tempor vel. Aenean dignissim scelerisque ultrices. Fusce eget purus justo, blandit tempor tellus. Praesent eget nunc eros. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aliquam dignissim justo eget elit egestas ac ultrices felis condimentum. Curabitur consectetur diam in eros elementum ut mollis est pharetra.</div>
<div>&nbsp;</div>
<div>Praesent feugiat viverra varius. Duis at massa arcu, eget porttitor turpis. Donec sodales lorem sit amet lorem tincidunt lobortis. Vivamus eget enim nunc, et ultricies eros. Etiam bibendum, nunc vel imperdiet dignissim, mauris dolor sollicitudin felis, non scelerisque erat justo eu elit. Nam mattis, dui vitae aliquam hendrerit, sapien enim laoreet orci, in interdum metus arcu et arcu. Nam sit amet elit odio, sed tempor lacus. Aenean bibendum blandit libero, a rhoncus nulla posuere ut. Suspendisse sodales mollis iaculis. Suspendisse ac neque quam.</div> -->
	<%-- <c:choose>
		<c:when test="<%= (PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_GROUP_ID > 0) && Validator.isNotNull(PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_ID) %>">
			<liferay-ui:journal-article groupId="<%= PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_GROUP_ID %>" articleId="<%= PropsValues.TERMS_OF_USE_JOURNAL_ARTICLE_ID %>" />
		</c:when>
		<c:otherwise>
			Welcome to our site. We maintain this web site as a service to our members. By using our site, you are agreeing to comply with and be bound by the following terms of use. Please review the following terms carefully. If you do not agree to these terms, you should not use this site.

			<br /><br />

			<ol>
				<li>
					<strong><u>Acceptance of Agreement</u></strong>.<br />

					You agree to the terms and conditions outlined in this Terms of Use Agreement (&quot;Agreement&quot;) with respect to our site (the &quot;Site&quot;). This Agreement constitutes the entire and only agreement between us and you, and supersedes all prior or contemporaneous agreements, representations, warranties and understandings with respect to the Site, the content, products or services provided by or through the Site, and the subject matter of this Agreement. This Agreement may be amended at any time by us from time to time without specific notice to you. The latest Agreement will be posted on the Site, and you should review this Agreement prior to using the Site.

					<br /><br />
				</li>
				<li>
					<strong><u>Copyright</u></strong>.<br />

					The content, organization, graphics, design, compilation, magnetic translation, digital conversion and other matters related to the Site are protected under applicable copyrights, trademarks and other proprietary (including but not limited to intellectual property) rights. The copying, redistribution, use or publication by you of any such matters or any part of the Site, except as allowed by Section 4, is strictly prohibited. You do not acquire ownership rights to any content, document or other materials viewed through the Site. The posting of information or materials on the Site does not constitute a waiver of any right in such information and materials.

					<br /><br />
				</li>
				<li>
					<strong><u>Service Marks</u></strong>.<br />

					Products and names mentioned on the Site may be trademarks of their respective owners.

					<br /><br />
				</li>
				<li>
					<strong><u>Limited Right to Use</u></strong>.<br />

					The viewing, printing or downloading of any content, graphic, form or document from the Site grants you only a limited, nonexclusive license for use solely by you for your own personal use and not for republication, distribution, assignment, sublicense, sale, preparation of derivative works or other use. No part of any content, form or document may be reproduced in any form or incorporated into any information retrieval system, electronic or mechanical, other than for your personal use (but not for resale or redistribution).

					<br /><br />
				</li>
				<li>
					<strong><u>Editing, Deleting and Modification</u></strong>.<br />

					We reserve the right in our sole discretion to edit or delete any documents, information or other content appearing on the Site.

					<br /><br />
				</li>
				<li>
					<strong><u>Indemnification</u></strong>.<br />

					You agree to indemnify, defend and hold us and our partners, attorneys, staff, advertisers, product and service providers, and affiliates (collectively, &quot;Affiliated Parties&quot;) harmless from any liability, loss, claim and expense, including reasonable attorney's fees, related to your violation of this Agreement or use of the Site.

					<br /><br />
				</li>
				<li>
					<strong><u>Nontransferable</u></strong>.<br />

					Your right to use the Site is not transferable. Any password or right given to you to obtain information or documents is not transferable.

					<br /><br />
				</li>
				<li>
					<strong><u>Disclaimer and Limits</u></strong>.<br />

					THE INFORMATION FROM OR THROUGH THE SITE ARE PROVIDED &quot;AS-IS,&quot; &quot;AS AVAILABLE,&quot; AND ALL WARRANTIES, EXPRESS OR IMPLIED, ARE DISCLAIMED (INCLUDING BUT NOT LIMITED TO THE DISCLAIMER OF ANY IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE). THE INFORMATION AND SERVICES MAY CONTAIN BUGS, ERRORS, PROBLEMS OR OTHER LIMITATIONS. WE AND OUR AFFILIATED PARTIES HAVE NO LIABILITY WHATSOEVER FOR YOUR USE OF ANY INFORMATION OR SERVICE. IN PARTICULAR, BUT NOT AS A LIMITATION THEREOF, WE AND OUR AFFILIATED PARTIES ARE NOT LIABLE FOR ANY INDIRECT, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES (INCLUDING DAMAGES FOR LOSS OF BUSINESS, LOSS OF PROFITS, LITIGATION, OR THE LIKE), WHETHER BASED ON BREACH OF CONTRACT, BREACH OF WARRANTY, TORT (INCLUDING NEGLIGENCE), PRODUCT LIABILITY OR OTHERWISE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. THE NEGATION OF DAMAGES SET FORTH ABOVE ARE FUNDAMENTAL ELEMENTS OF THE BASIS OF THE BARGAIN BETWEEN US AND YOU. THIS SITE AND THE PRODUCTS, SERVICES, AND INFORMATION PRESENTED WOULD NOT BE PROVIDED WITHOUT SUCH LIMITATIONS. NO ADVICE OR INFORMATION, WHETHER ORAL OR WRITTEN, OBTAINED BY YOU FROM US THROUGH THE SITE SHALL CREATE ANY WARRANTY, REPRESENTATION OR GUARANTEE NOT EXPRESSLY STATED IN THIS AGREEMENT. WE DO NOT PROVIDE LEGAL ADVICE NOR ENTER INTO ANY ATTORNEY-CLIENT RELATIONSHIP.

					<br /><br />
					ALL RESPONSIBILITY OR LIABILITY FOR ANY DAMAGES CAUSED BY VIRUSES CONTAINED WITHIN THE ELECTRONIC FILE CONTAINING THE FORM OR DOCUMENT IS DISCLAIMED. WE WILL NOT BE LIABLE TO YOU FOR ANY INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES OF ANY KIND THAT MAY RESULT FROM USE OF OR INABILITY TO USE OUR SITE. OUR MAXIMUM LIABILITY TO YOU UNDER ALL CIRCUMSTANCES WILL BE EQUAL TO THE PURCHASE PRICE YOU PAY FOR ANY GOODS, SERVICES OR INFORMATION.

					<br /><br />
				</li>
				<li>
					<strong><u>Use of Information</u></strong>.<br />

					We reserve the right, and you authorize us, to the use and assignment of all information regarding Site uses by you and all information provided by you in any manner consistent with our Privacy Policy. All remarks, suggestions, ideas, graphics, or other information communicated by you to us through the Site (collectively, the "Submission") will forever be the property of <%= company.getName() %>. <%= company.getName() %> will not be required to treat any Submission as confidential, and will not be liable for any ideas for its business (including without limitation, product, service or advertising ideas) and will not incur any liability as a result of any similarities that may appear in future <%= company.getName() %> products, services or operations. Without limitation, <%= company.getName() %> will have exclusive ownership of all present and future existing rights to the Submission of every kind and nature everywhere. <%= company.getName() %> will be entitled to use the Submission for any commercial or other purpose whatsoever, without compensation to you or any other person sending the Submission. You acknowledge that you are responsible for whatever material you submit, and you, not <%= company.getName() %>, have full responsibility for the message, including its legality, reliability, appropriateness, originality, and copyright.

					<br /><br />
				</li>
				<li>
					<strong><u>Third-Party Services</u></strong>.<br />

					We may allow access to or advertise third-party product or service providers (&quot;Merchants&quot;) from which you may purchase certain goods or services. You understand that we do not operate or control the products or services offered by Merchants. Merchants are responsible for all aspects of order processing, fulfillment, billing and customer service. We are not a party to the transactions entered into between you and Merchants. You agree that use of such Merchants is AT YOUR SOLE RISK AND IS WITHOUT WARRANTIES OF ANY KIND BY US, EXPRESSED, IMPLIED OR OTHERWISE INCLUDING WARRANTIES OF TITLE, FITNESS FOR PURPOSE, MERCHANTABILITY OR NON-INFRINGEMENT. UNDER NO CIRCUMSTANCES ARE WE LIABLE FOR ANY DAMAGES ARISING FROM THE TRANSACTIONS BETWEEN YOU AND MERCHANTS OR FOR ANY INFORMATION APPEARING ON MERCHANT SITES OR ANY OTHER SITE LINKED TO OUR SITE.

					<br /><br />
				</li>
				<li>
					<strong><u>Third-Party Merchant Policies</u></strong>.<br />

					All rules, policies (including privacy policies) and operating procedures of Merchants will apply to you while on such sites. We are not responsible for information provided by you to Merchants. We and the Merchants are independent contractors and neither party has authority to make any representations or commitments on behalf of the other.

					<br /><br />
				</li>
				<li>
					<strong><u>Privacy Policy</u></strong>.<br />

					Our Privacy Policy, as it may change from time to time, is a part of this Agreement.

					<br /><br />
				</li>
				<li>
					<strong><u>Payments</u></strong>.<br />

					You represent and warrant that if you are purchasing something from us or from Merchants that (i) any credit information you supply is true and complete, (ii) charges incurred by you will be honored by your credit card company, and (iii) you will pay the charges incurred by you at the posted prices, including any applicable taxes.

					<br /><br />
				</li>
				<li>
					<strong><u>Securities Laws</u></strong>.<br />

					This Site may include statements concerning our operations, prospects, strategies, financial condition, future economic performance and demand for our products or services, as well as our intentions, plans and objectives (particularly with respect to product and service offerings), that are forward-looking statements. These statements are based upon a number of assumptions and estimates which are subject to significant uncertainties, many of which are beyond our control. When used on our Site, words like &quot;anticipates,&quot; &quot;expects,&quot; &quot;believes,&quot; &quot;estimates,&quot; &quot;seeks,&quot; &quot;plans,&quot; &quot;intends,&quot; &quot;will&quot; and similar expressions are intended to identify forward-looking statements designed to fall within securities law safe harbors for forward-looking statements. The Site and the information contained herein does not constitute an offer or a solicitation of an offer for sale of any securities. None of the information contained herein is intended to be, and shall not be deemed to be, incorporated into any of our securities-related filings or documents.

					<br /><br />
				</li>
				<li>
					<strong><u>Links to Other Web Sites</u></strong>.<br />

					The Site contains links to other web sites. We are not responsible for the content, accuracy or opinions express in such web sites, and such web sites are not investigated, monitored or checked for accuracy or completeness by us. Inclusion of any linked web site on our Site does not imply approval or endorsement of the linked web site by us. If you decide to leave our Site and access these third-party sites, you do so at your own risk.

					<br /><br />
				</li>
				<li>
					<strong><u>Copyrights and Copyright Agents</u></strong>.<br />

					We respect the intellectual property of others, and we ask you to do the same. If you believe that your work has been copied in a way that constitutes copyright infringement, please provide our Copyright Agent the following information:

					<br /><br />

					(a) An electronic or physical signature of the person authorized to act on behalf of the owner of the copyright interest;

					<br /><br />

					(b) A description of the copyrighted work that you claim has been infringed;

					<br /><br />

					(c) A description of where the material that you claim is infringing is located on the Site;

					<br /><br />

					(d) Your address, telephone number, and email address;

					<br /><br />

					(e) A statement by you that you have a good faith belief that the disputed use is not authorized by the copyright owner, its agent, or the law; and

					<br /><br />

					(f) A statement by you, made under penalty of perjury, that the above information in your Notice is accurate and that you are the copyright owner or authorized to act on the copyright owner's behalf. Our Copyright Agent for Notice of claims of copyright infringement on the Site can be reached by directing an e-mail to the Copyright Agent at <a class="gamma" href="mailto:<%= company.getEmailAddress() %>"><%= company.getEmailAddress() %></a>

					<br /><br />
				</li>
				<li>
					<strong><u>Proposed Product and Service Offerings</u></strong>.<br />

					All descriptions of proposed products and services are based on assumptions subject to change and you should not rely on the availability or functionality of products or services until they are actually offered through the Site. We reserve the right in its sole discretion to determine how registration and other promotions will be awarded. This determination includes, without limitation, the scope, nature and timing of all such awards.

					<br /><br />
				</li>
				<li>
					<strong><u>Information and Press Releases</u></strong>.<br />

					The Site contains information and press releases about us. While this information was believed to be accurate as of the date prepared, we disclaim any duty or obligation to update this information or any press releases. Information about companies other than ours contained in the press release or otherwise, should not be relied upon as being provided or endorsed by us.

					<br /><br />
				</li>
				<li>
					<strong><u>Miscellaneous</u></strong>.<br />

					This Agreement shall be treated as though it were executed and performed in Los Angeles, CA, and shall be governed by and construed in accordance with the laws of the State of California (without regard to conflict of law principles). Any cause of action by you with respect to the Site (and/or any information, products or services related thereto) must be instituted within one (1) year after the cause of action arose or be forever waived and barred. All actions shall be subject to the limitations set forth in Section 8 and Section 10. The language in this Agreement shall be interpreted as to its fair meaning and not strictly for or against either party. All legal proceedings arising out of or in connection with this Agreement shall be brought solely in Los Angeles, CA. You expressly submit to the exclusive jurisdiction of said courts and consents to extra-territorial service of process. Should any part of this Agreement be held invalid or unenforceable, that portion shall be construed consistent with applicable law and the remaining portions shall remain in full force and effect. To the extent that anything in or associated with the Site is in conflict or inconsistent with this Agreement, this Agreement shall take precedence. Our failure to enforce any provision of this Agreement shall not be deemed a waiver of such provision nor of the right to enforce such provision.<br />
				</li>
			</ol>
		</c:otherwise>
	</c:choose>
 --%>
 
	<c:if test="<%= !user.isAgreedToTermsOfUse() %>">
		<aui:button-row>
			
			
			<%
			String taglibOnClick = "alert('" + UnicodeLanguageUtil.get(pageContext, "you-must-agree-with-the-terms-of-use-to-continue") + "');";
			%>

			<%-- <aui:button onClick="<%= taglibOnClick %>" type="cancel" value="i-disagree" /> --%>
			<div align="right">
		<!--  <a href="/c/portal/logout" style="text-decoration: none"><aui:button type="button" value="i-disagree"/></a>  -->
			<!-- <a href="/web/guest/landing" style="text-decoration: none"><aui:button type="button" value="i-disagree"/></a> -->
			
			 <!-- <input type="submit" name="isAgree" value="Cancel"/>
			<input type="submit" name="isAgree" value="Agree"/>  -->
			
			<!-- <aui:input type="hidden" name="EULA_CHOICE" id="hiddenChoice" value="AGREE" /> -->
		<!-- 	<aui:button type="button" value="i-disagree" onClick='cancelClick();'/> -->
		<!-- 	<aui:button type="button" value="i-disagree"/>
			<aui:button type="submit" value="i-agree" />
	<aui:button type="button" value="modal pop up" onClick='ModalPopupsConfirm();'/> -->
	<!-- <script type="text/javascript">

	function cancelClick(){
		document.getElementById("hiddenChoice").value="DISAGREE";
		document.fm.submit();
	}
</script> -->
	
<script type="text/javascript">
function ModalPopupsConfirm() {  
	   ModalPopups.Confirm("idConfirm1",  
    " ",  
    '<div><span class="aui-legend" style="font-weight:bold;font-size: 18px; color:#333333; ">License Agreement</span></div><br /><br /><div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi viverra urna quis ante bibendum gravida. Suspendisse lorem eros, vehicula quis condimentum eget, pharetra ac enim. Phasellus elit enim, eleifend a pharetra et, tempus vel ligula. Etiam aliquam mi ut mi tristique accumsan.Aliquam ut velit ante. Praesent pulvinar, enim ac feugiat pharetra, massa ipsum rhoncus tellus, sed venenatis arcu ipsum quis nibh. Phasellus lacinia venenatis arcu, eu aliquet urna dapibus vel. Pellentesque tempor dictum turpis ac ullamcorper. Donec est ipsum, dictum eget gravida eget, vulputate et urna. Praesent a ipsum faucibus velit gravida placerat. Ut odio lorem, condimentum nec eleifend a, vehicula ut nulla. In rutrum augue eu nibh egestas id congue sapien vestibulum. Proin eleifend tempor ipsum et ultrices. Sed id velit volutpat diam iaculis egestas. Aliquam lobortis lectus sit amet ante sollicitudin in vehicula nulla placerat. Nulla adipiscing magna eget lorem semper vel bibendum leo scelerisque.<br /><br /> Pellentesque tempor dictum turpis ac ullamcorper. Donec est ipsum, dictum eget gravida eget, vulputate et urna. Praesent a ipsum faucibus velit gravida placerat. Ut odio lorem, condimentum nec eleifend a, vehicula ut nulla. In rutrum augue eu nibh egestas id congue sapien vestibulum. Proin eleifend tempor ipsum et ultrices. Sed id velit volutpat diam iaculis egestas. Aliquam lobortis lectus sit amet ante sollicitudin in vehicula nulla placerat. Nulla adipiscing magna eget lorem semper vel bibendum leo scelerisque.</div>',   
    {  	
    	yesButtonText: "Logout",
    	noButtonText: "Agree",  
    	onYes: "EULALogout",
        onNo: "EULAAgree()"  
    }  
);   
   
}  
function EULALogout() {  
  //  alert('You Disagreed EULA');  
   // ModalPopups.Close("idConfirm1");  
   return false;
}  
function EULAAgree() {  
 //   alert('you have accepted EULA');  
   // ModalPopups.Cancel("idConfirm1");
	document.fm.submit();
}  

</script>



			</div>
			<!-- <a href="http://www.google.com" style="text-decoration: none"><aui:button type="button" value="i-disagree"/></a> -->
		</aui:button-row>
	</c:if>

</aui:form>

<style type="text/css">
#portlet_terms-of-use .portlet-topper{
	display:none;
}
#portlet_terms-of-use .portlet-content{
	padding:0;
}
</style>
</body>