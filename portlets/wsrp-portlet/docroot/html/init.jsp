<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>

<%@ page import="com.liferay.wsrp.NoSuchConsumerException" %>
<%@ page import="com.liferay.wsrp.NoSuchConsumerPortletException" %>
<%@ page import="com.liferay.wsrp.WSRPConsumerNameException" %>
<%@ page import="com.liferay.wsrp.WSRPConsumerPortletHandleException" %>
<%@ page import="com.liferay.wsrp.WSRPConsumerPortletNameException" %>
<%@ page import="com.liferay.wsrp.WSRPConsumerWSDLException" %>
<%@ page import="org.slc.sli.portlet.action.WSRPURLException" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />