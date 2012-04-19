/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.wgenapp.service.impl;

import java.util.List;

import com.wgenapp.model.WgenApp;
import com.wgenapp.service.base.WgenAppLocalServiceBaseImpl;

/**
 * The implementation of the wgen app local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.wgenapp.service.WgenAppLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.wgenapp.service.base.WgenAppLocalServiceBaseImpl
 * @see com.wgenapp.service.WgenAppLocalServiceUtil
 */
public class WgenAppLocalServiceImpl extends WgenAppLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.wgenapp.service.WgenAppLocalServiceUtil} to access the wgen app local service.
	 */
	
	public List<WgenApp> getAllWgenApps() throws Exception 
	{
		return wgenAppPersistence.findAll();
	}
	public int getCountAllWgenApp() throws Exception
	{
		return wgenAppPersistence.countAll();
	}
}