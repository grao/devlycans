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
 * The utility for the header footer local service. This utility wraps {@link org.slc.sli.headerfooter.service.impl.HeaderFooterLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author manoj
 * @see HeaderFooterLocalService
 * @see org.slc.sli.headerfooter.service.base.HeaderFooterLocalServiceBaseImpl
 * @see org.slc.sli.headerfooter.service.impl.HeaderFooterLocalServiceImpl
 * @generated
 */
public class HeaderFooterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.slc.sli.headerfooter.service.impl.HeaderFooterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the header footer to the database. Also notifies the appropriate model listeners.
	*
	* @param headerFooter the header footer
	* @return the header footer that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.slc.sli.headerfooter.model.HeaderFooter addHeaderFooter(
		org.slc.sli.headerfooter.model.HeaderFooter headerFooter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addHeaderFooter(headerFooter);
	}

	/**
	* Creates a new header footer with the primary key. Does not add the header footer to the database.
	*
	* @param id the primary key for the new header footer
	* @return the new header footer
	*/
	public static org.slc.sli.headerfooter.model.HeaderFooter createHeaderFooter(
		long id) {
		return getService().createHeaderFooter(id);
	}

	/**
	* Deletes the header footer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the header footer
	* @throws PortalException if a header footer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHeaderFooter(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHeaderFooter(id);
	}

	/**
	* Deletes the header footer from the database. Also notifies the appropriate model listeners.
	*
	* @param headerFooter the header footer
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteHeaderFooter(
		org.slc.sli.headerfooter.model.HeaderFooter headerFooter)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteHeaderFooter(headerFooter);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static org.slc.sli.headerfooter.model.HeaderFooter fetchHeaderFooter(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchHeaderFooter(id);
	}

	/**
	* Returns the header footer with the primary key.
	*
	* @param id the primary key of the header footer
	* @return the header footer
	* @throws PortalException if a header footer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.slc.sli.headerfooter.model.HeaderFooter getHeaderFooter(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeaderFooter(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the header footers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of header footers
	* @param end the upper bound of the range of header footers (not inclusive)
	* @return the range of header footers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> getHeaderFooters(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeaderFooters(start, end);
	}

	/**
	* Returns the number of header footers.
	*
	* @return the number of header footers
	* @throws SystemException if a system exception occurred
	*/
	public static int getHeaderFootersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeaderFootersCount();
	}

	/**
	* Updates the header footer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param headerFooter the header footer
	* @return the header footer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.slc.sli.headerfooter.model.HeaderFooter updateHeaderFooter(
		org.slc.sli.headerfooter.model.HeaderFooter headerFooter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHeaderFooter(headerFooter);
	}

	/**
	* Updates the header footer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param headerFooter the header footer
	* @param merge whether to merge the header footer with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the header footer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.slc.sli.headerfooter.model.HeaderFooter updateHeaderFooter(
		org.slc.sli.headerfooter.model.HeaderFooter headerFooter, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateHeaderFooter(headerFooter, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static org.slc.sli.headerfooter.model.HeaderFooter addHeader(
		java.lang.String headerData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addHeader(headerData);
	}

	public static org.slc.sli.headerfooter.model.HeaderFooter editHeader(
		long id, java.lang.String headerData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().editHeader(id, headerData);
	}

	public static org.slc.sli.headerfooter.model.HeaderFooter getCurrentHeader()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCurrentHeader();
	}

	public static java.lang.String getHeader(java.lang.String token,
		java.lang.String currUrl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeader(token, currUrl);
	}

	public static java.lang.String getHeader(boolean isAdmin)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getHeader(isAdmin);
	}

	public static org.slc.sli.headerfooter.model.HeaderFooter addFooter(
		java.lang.String footerData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addFooter(footerData);
	}

	public static org.slc.sli.headerfooter.model.HeaderFooter editFooter(
		long id, java.lang.String footerData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().editFooter(id, footerData);
	}

	public static org.slc.sli.headerfooter.model.HeaderFooter getCurrentFooter()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCurrentFooter();
	}

	public static java.lang.String getFooter(boolean isAdmin)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFooter(isAdmin);
	}

	public static java.lang.String getFooter(java.lang.String token)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFooter(token);
	}

	public static void clearService() {
		_service = null;
	}

	public static HeaderFooterLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HeaderFooterLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					HeaderFooterLocalService.class.getName(), portletClassLoader);

			_service = new HeaderFooterLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(HeaderFooterLocalServiceUtil.class,
				"_service");
			MethodCache.remove(HeaderFooterLocalService.class);
		}

		return _service;
	}

	public void setService(HeaderFooterLocalService service) {
		MethodCache.remove(HeaderFooterLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(HeaderFooterLocalServiceUtil.class,
			"_service");
		MethodCache.remove(HeaderFooterLocalService.class);
	}

	private static HeaderFooterLocalService _service;
}