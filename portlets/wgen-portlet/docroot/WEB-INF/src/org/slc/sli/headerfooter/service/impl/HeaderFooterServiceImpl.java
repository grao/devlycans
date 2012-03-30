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

import org.slc.sli.headerfooter.model.HeaderFooter;
import org.slc.sli.headerfooter.service.base.HeaderFooterServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

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
	
	public String getHeader(String token) throws SystemException {
	    return headerFooterLocalService.getHeader(token);
	}

	public String getFooter(String token) throws SystemException {
		return headerFooterLocalService.getFooter(token);
	}	
	
	/*public HeaderFooter getCurrentFooter() throws SystemException {
		return headerFooterLocalService.getCurrentFooter();
	}*/	
	
}