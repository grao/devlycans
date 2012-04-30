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

package org.slc.sli.headerfooter.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;

import org.slc.sli.headerfooter.service.base.HeaderFooterServiceBaseImpl;
import org.slc.sli.util.VelocityUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.wgen.util.PortletPropsValues;

/**
 * The implementation of the header footer remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.slc.sli.headerfooter.service.HeaderFooterService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author manoj
 * @see org.slc.sli.headerfooter.service.base.HeaderFooterServiceBaseImpl
 * @see org.slc.sli.headerfooter.service.HeaderFooterServiceUtil
 */
public class HeaderFooterServiceImpl extends HeaderFooterServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.slc.sli.headerfooter.service.HeaderFooterServiceUtil} to access the header footer remote service.
	 */
	
	public String getHeader(String token,String currUrl) throws SystemException {
	    return headerFooterLocalService.getHeader(token,currUrl);
	}

	public String getFooter(String token) throws SystemException {
		return headerFooterLocalService.getFooter(token);
	}	
	
	public String getHeader(boolean isAdmin) throws SystemException {
	  
		String header = headerFooterLocalService.getHeader(isAdmin);
	    String headerWithLogo="";
		try {
			headerWithLogo = header.replace("[$SLI_LOGO$]","<img alt=\"sli_logo\" src=\""+VelocityUtil.getEncodedImg(PortletPropsValues.SLI_LOGO)+"\"/>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return VelocityUtil.velocityHeaderRes(headerWithLogo);
	}
	
	public String getFooter(boolean isAdmin) throws SystemException {
		String footer=headerFooterLocalService.getFooter(isAdmin);
		return VelocityUtil.velocityFooterRes(footer);
	}
	
	/*public HeaderFooter getCurrentFooter() throws SystemException {
		return headerFooterLocalService.getCurrentFooter();
	}*/	
	
}