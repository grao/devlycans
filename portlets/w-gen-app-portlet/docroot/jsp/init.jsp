<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.service.UserServiceUtil"%>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@ page import="com.wgenapp.service.WgenAppLocalServiceUtil" %>
<%@ page import="com.wgenapp.model.WgenApp" %>


<liferay-theme:defineObjects />
<portlet:defineObjects />