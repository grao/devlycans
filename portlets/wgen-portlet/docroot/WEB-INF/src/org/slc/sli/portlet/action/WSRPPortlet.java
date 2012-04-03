package org.slc.sli.portlet.action;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class WSRPPortlet extends GenericPortlet {

	public void init(PortletConfig portletConfig) throws PortletException {
		super.init(portletConfig);

		if (_log.isInfoEnabled()) {
			_log.info("Initializing portlet");
		}
	}

	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		/*String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		long foodItemId = ParamUtil.getLong(actionRequest, "foodItemId");

		String name = actionRequest.getParameter("name");
		int points = ParamUtil.getInteger(actionRequest, "points");

		try {
			if (cmd.equals(Constants.ADD)) {
				FoodItem foodItem = new FoodItem();

				foodItem.setName(name);
				foodItem.setPoints(points);

				FoodItemDAO.addFoodItem(foodItem);
			}
			else if (cmd.equals(Constants.EDIT)) {
				FoodItem foodItem = FoodItemDAO.getFoodItem(foodItemId);

				foodItem.setName(name);
				foodItem.setPoints(points);

				FoodItemDAO.updateFoodItem(foodItem);
			}
			else if (cmd.equals(Constants.DELETE)) {
				FoodItemDAO.deleteFoodItem(foodItemId);
			}
		}
		catch (SQLException sqle) {
			throw new PortletException(sqle);
		}*/
		System.out.println("inside process action ....");
	}

	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletContext portletContext = getPortletContext();

		PortletRequestDispatcher portletRequestDispatcher =
			portletContext.getRequestDispatcher("/html/wsrp/view.jsp");

		System.out.println("inside doview ....");
		
		if (portletRequestDispatcher == null) {
			_log.error("/html/wsrp/view.jsp is not a valid include");
		}
		else {
			try {
				portletRequestDispatcher.include(renderRequest, renderResponse);
			}
			catch (Exception e) {
				_log.error(e, e);

				portletRequestDispatcher = portletContext.getRequestDispatcher(
					"/error.jsp");

				if (portletRequestDispatcher == null) {
					_log.error("/error.jsp is not a valid include");
				}
				else {
					portletRequestDispatcher.include(
						renderRequest, renderResponse);
				}
			}
		}
	}

	public void destroy() {
		if (_log.isInfoEnabled()) {
			_log.info("Destroying portlet");
		}
	}

	private static Log _log = LogFactoryUtil.getLog(WSRPPortlet.class);

}