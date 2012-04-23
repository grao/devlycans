package org.slc.sli.portlet.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.slc.sli.headerfooter.service.HeaderFooterLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class HeaderPortlet
 */
public class HeaderPortlet extends MVCPortlet {
 

	public void addHeaderPrefs(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {

		String headerInfo = ParamUtil.getString(actionRequest, "data");
		long headerId = ParamUtil.getLong(actionRequest,"id",0);
		

		if (headerId > 0) {
			HeaderFooterLocalServiceUtil.editHeader(headerId, headerInfo);
		} else {
			HeaderFooterLocalServiceUtil.addHeader(headerInfo);
		}
		actionResponse.setRenderParameter("jspPage",
				"/html/header/view.jsp");
		
	}
}
