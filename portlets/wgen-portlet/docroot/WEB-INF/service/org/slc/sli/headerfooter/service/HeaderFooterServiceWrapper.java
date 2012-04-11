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

package org.slc.sli.headerfooter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HeaderFooterService}.
 * </p>
 *
 * @author    manoj
 * @see       HeaderFooterService
 * @generated
 */
public class HeaderFooterServiceWrapper implements HeaderFooterService,
	ServiceWrapper<HeaderFooterService> {
	public HeaderFooterServiceWrapper(HeaderFooterService headerFooterService) {
		_headerFooterService = headerFooterService;
	}

	public java.lang.String getHeader(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headerFooterService.getHeader(token);
	}

	public java.lang.String getFooter(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _headerFooterService.getFooter(token);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public HeaderFooterService getWrappedHeaderFooterService() {
		return _headerFooterService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedHeaderFooterService(
		HeaderFooterService headerFooterService) {
		_headerFooterService = headerFooterService;
	}

	public HeaderFooterService getWrappedService() {
		return _headerFooterService;
	}

	public void setWrappedService(HeaderFooterService headerFooterService) {
		_headerFooterService = headerFooterService;
	}

	private HeaderFooterService _headerFooterService;
}