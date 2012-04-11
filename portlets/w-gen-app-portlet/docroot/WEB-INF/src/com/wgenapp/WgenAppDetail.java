package com.wgenapp;

import java.rmi.RemoteException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.wgenapp.model.WgenApp;
import com.wgenapp.model.impl.WgenAppImpl;
import com.wgenapp.service.WgenAppLocalServiceUtil;

/**
 * Portlet implementation class WgenAppDetail
 */
public class WgenAppDetail extends MVCPortlet {
 
	public void WgenAppDetailAdd(ActionRequest req, ActionResponse res)throws PortalException, SystemException, RemoteException 
	{
		
		 String primaryKey=req.getParameter("primaryKey");
		 String WgenApp_Title = req.getParameter("WgenAppTitle");
		 String WgenApp_Description = req.getParameter("WgenAppDescription");
		 String WgenApp_URL = req.getParameter("WgenAppURL");
		 
		 System.out.println("WgenApp_Title:->"+WgenApp_Title+" WgenApp_Description"+WgenApp_Description+" WgenApp_URL:->"+WgenApp_URL);
		 
		 WgenApp  wgenapp= new WgenAppImpl() ;	 
		 //System.out.println("The Primary Key is:->"+primaryKey);
		try {
				 if(primaryKey !=null && !primaryKey.equals(""))
				 {		 
					System.out.println("**** True ****");
					 
					 wgenapp.setWgenAppId(Long.parseLong(primaryKey));
					 wgenapp.setWgenAppTitle(WgenApp_Title);

					 wgenapp.setWgenAppDescription(WgenApp_Description);
					 wgenapp.setWgenAppURL(WgenApp_URL);

					 //System.out.println("WgenApp Image : " + WgenApp_Image);
					 WgenAppLocalServiceUtil.updateWgenApp(wgenapp);		
				 }
				 else 			
				{
					System.out.println("**** False ****");
					 wgenapp.setWgenAppId(CounterLocalServiceUtil.increment());
					 wgenapp.setWgenAppTitle(WgenApp_Title);

					 wgenapp.setWgenAppDescription(WgenApp_Description);
					 wgenapp.setWgenAppURL(WgenApp_URL);

					 WgenAppLocalServiceUtil.addWgenApp(wgenapp);		
				}	
			}	
			catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
	public void WgenAppDetailDelete(ActionRequest req, ActionResponse res)throws PortalException, SystemException, RemoteException 
	{
		try {
			System.out.println("The delete Id is:->"+req.getParameter("deleteAppId"));	
			WgenAppLocalServiceUtil.deleteWgenApp(Long.parseLong(req.getParameter("deleteAppId")));
		}
		catch (Exception e) {
			
			
		}
	}
}
