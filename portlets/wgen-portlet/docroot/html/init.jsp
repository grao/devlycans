<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="java.util.List" %>

<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="com.liferay.portal.theme.NavItem" %>
<%@ page import="com.liferay.portal.theme.RequestVars" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>



<%@page import="org.slc.sli.headerfooter.service.HeaderFooterServiceUtil"%>
<%@page import="org.slc.sli.headerfooter.service.HeaderFooterLocalServiceUtil"%>
<%@page import="org.slc.sli.headerfooter.model.HeaderFooter"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />