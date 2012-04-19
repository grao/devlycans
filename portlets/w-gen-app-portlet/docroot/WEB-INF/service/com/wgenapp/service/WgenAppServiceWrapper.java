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

package com.wgenapp.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link WgenAppService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WgenAppService
 * @generated
 */
public class WgenAppServiceWrapper implements WgenAppService,
	ServiceWrapper<WgenAppService> {
	public WgenAppServiceWrapper(WgenAppService wgenAppService) {
		_wgenAppService = wgenAppService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WgenAppService getWrappedWgenAppService() {
		return _wgenAppService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWgenAppService(WgenAppService wgenAppService) {
		_wgenAppService = wgenAppService;
	}

	public WgenAppService getWrappedService() {
		return _wgenAppService;
	}

	public void setWrappedService(WgenAppService wgenAppService) {
		_wgenAppService = wgenAppService;
	}

	private WgenAppService _wgenAppService;
}