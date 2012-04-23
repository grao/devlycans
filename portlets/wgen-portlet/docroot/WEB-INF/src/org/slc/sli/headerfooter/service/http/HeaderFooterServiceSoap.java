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

package org.slc.sli.headerfooter.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.slc.sli.headerfooter.service.HeaderFooterServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link org.slc.sli.headerfooter.service.HeaderFooterServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.slc.sli.headerfooter.model.HeaderFooterSoap}.
 * If the method in the service utility returns a
 * {@link org.slc.sli.headerfooter.model.HeaderFooter}, that is translated to a
 * {@link org.slc.sli.headerfooter.model.HeaderFooterSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    manoj
 * @see       HeaderFooterServiceHttp
 * @see       org.slc.sli.headerfooter.model.HeaderFooterSoap
 * @see       org.slc.sli.headerfooter.service.HeaderFooterServiceUtil
 * @generated
 */
public class HeaderFooterServiceSoap {
	public static java.lang.String getHeader(java.lang.String token,
		java.lang.String currUrl) throws RemoteException {
		try {
			java.lang.String returnValue = HeaderFooterServiceUtil.getHeader(token,
					currUrl);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getFooter(java.lang.String token)
		throws RemoteException {
		try {
			java.lang.String returnValue = HeaderFooterServiceUtil.getFooter(token);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getHeader(boolean isAdmin,
		java.lang.String fullName) throws RemoteException {
		try {
			java.lang.String returnValue = HeaderFooterServiceUtil.getHeader(isAdmin,
					fullName);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getFooter(boolean isAdmin,
		java.lang.String fullName) throws RemoteException {
		try {
			java.lang.String returnValue = HeaderFooterServiceUtil.getFooter(isAdmin,
					fullName);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(HeaderFooterServiceSoap.class);
}