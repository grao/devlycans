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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the header footer remote service. This utility wraps {@link org.slc.sli.headerfooter.service.impl.HeaderFooterServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author manoj
 * @see HeaderFooterService
 * @see org.slc.sli.headerfooter.service.base.HeaderFooterServiceBaseImpl
 * @see org.slc.sli.headerfooter.service.impl.HeaderFooterServiceImpl
 * @generated
 */
public class HeaderFooterServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.slc.sli.headerfooter.service.impl.HeaderFooterServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.lang.String getHeader(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeader(token);
	}

	public static java.lang.String getFooter(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFooter(token);
	}

	public static void clearService() {
		_service = null;
	}

	public static HeaderFooterService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HeaderFooterService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					HeaderFooterService.class.getName(), portletClassLoader);

			_service = new HeaderFooterServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(HeaderFooterServiceUtil.class,
				"_service");
			MethodCache.remove(HeaderFooterService.class);
		}

		return _service;
	}

	public void setService(HeaderFooterService service) {
		MethodCache.remove(HeaderFooterService.class);

		_service = service;

		ReferenceRegistry.registerReference(HeaderFooterServiceUtil.class,
			"_service");
		MethodCache.remove(HeaderFooterService.class);
	}

	private static HeaderFooterService _service;
}