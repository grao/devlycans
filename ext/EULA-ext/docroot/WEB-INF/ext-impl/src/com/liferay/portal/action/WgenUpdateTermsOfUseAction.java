package com.liferay.portal.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;

public class WgenUpdateTermsOfUseAction extends UpdateTermsOfUseAction {

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String eulaChoice = ParamUtil.getString(request, "EULA_CHOICE", "DISAGREE");

		if (eulaChoice.equalsIgnoreCase("AGREE")) {

			return super.execute(mapping, form, request, response);

		}

		return mapping.findForward("portal.eula_disagree");

	}

}
