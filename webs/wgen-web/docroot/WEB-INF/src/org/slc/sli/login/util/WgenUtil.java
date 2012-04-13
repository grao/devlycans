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

package org.slc.sli.login.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;

import org.slc.sli.login.util.WgenPropsKeys;

import java.util.List;
import org.slc.sli.json.bean.UserData;

public class WgenUtil {

	public static boolean isAdmin(UserData userdata){
		boolean isAdmin=false;
		if(Validator.isNotNull(userdata)){
			String[] granted_authorities = userdata.getGranted_authorities();
			for(String role : granted_authorities){
				if(role.equalsIgnoreCase(GetterUtil.getString(PropsUtil.get(WgenPropsKeys.ROLE_IT_ADMINISTRATOR))) || 
						role.equalsIgnoreCase( GetterUtil.getString(PropsUtil.get(WgenPropsKeys.ROLE_SLI_ADMINISTRATOR))))
				{
					isAdmin=true;
					break;
				}
			}
		}
		return isAdmin;
	}
}