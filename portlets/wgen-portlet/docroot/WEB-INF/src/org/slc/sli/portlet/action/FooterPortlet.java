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
public class FooterPortlet extends MVCPortlet {
 
	public void addFooterPrefs(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {

		String footerInfo = ParamUtil.getString(actionRequest, "data");
		long footerId = ParamUtil.getLong(actionRequest,"id",0);
		

		if (footerId > 0) {
			HeaderFooterLocalServiceUtil.editFooter(footerId, footerInfo);
		} else {
			HeaderFooterLocalServiceUtil.addFooter(footerInfo);
		}

		actionResponse.setRenderParameter("jspPage",
				"/html/footer/view.jsp");
		
	}
}
