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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the wgen app local service. This utility wraps {@link com.wgenapp.service.impl.WgenAppLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WgenAppLocalService
 * @see com.wgenapp.service.base.WgenAppLocalServiceBaseImpl
 * @see com.wgenapp.service.impl.WgenAppLocalServiceImpl
 * @generated
 */
public class WgenAppLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.wgenapp.service.impl.WgenAppLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the wgen app to the database. Also notifies the appropriate model listeners.
	*
	* @param wgenApp the wgen app
	* @return the wgen app that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.wgenapp.model.WgenApp addWgenApp(
		com.wgenapp.model.WgenApp wgenApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWgenApp(wgenApp);
	}

	/**
	* Creates a new wgen app with the primary key. Does not add the wgen app to the database.
	*
	* @param WgenAppId the primary key for the new wgen app
	* @return the new wgen app
	*/
	public static com.wgenapp.model.WgenApp createWgenApp(long WgenAppId) {
		return getService().createWgenApp(WgenAppId);
	}

	/**
	* Deletes the wgen app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param WgenAppId the primary key of the wgen app
	* @throws PortalException if a wgen app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWgenApp(long WgenAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWgenApp(WgenAppId);
	}

	/**
	* Deletes the wgen app from the database. Also notifies the appropriate model listeners.
	*
	* @param wgenApp the wgen app
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWgenApp(com.wgenapp.model.WgenApp wgenApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWgenApp(wgenApp);
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

	public static com.wgenapp.model.WgenApp fetchWgenApp(long WgenAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWgenApp(WgenAppId);
	}

	/**
	* Returns the wgen app with the primary key.
	*
	* @param WgenAppId the primary key of the wgen app
	* @return the wgen app
	* @throws PortalException if a wgen app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.wgenapp.model.WgenApp getWgenApp(long WgenAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWgenApp(WgenAppId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the wgen apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wgen apps
	* @param end the upper bound of the range of wgen apps (not inclusive)
	* @return the range of wgen apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.wgenapp.model.WgenApp> getWgenApps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWgenApps(start, end);
	}

	/**
	* Returns the number of wgen apps.
	*
	* @return the number of wgen apps
	* @throws SystemException if a system exception occurred
	*/
	public static int getWgenAppsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWgenAppsCount();
	}

	/**
	* Updates the wgen app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wgenApp the wgen app
	* @return the wgen app that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.wgenapp.model.WgenApp updateWgenApp(
		com.wgenapp.model.WgenApp wgenApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWgenApp(wgenApp);
	}

	/**
	* Updates the wgen app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wgenApp the wgen app
	* @param merge whether to merge the wgen app with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the wgen app that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.wgenapp.model.WgenApp updateWgenApp(
		com.wgenapp.model.WgenApp wgenApp, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWgenApp(wgenApp, merge);
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

	public static java.util.List<com.wgenapp.model.WgenApp> getAllWgenApps()
		throws java.lang.Exception {
		return getService().getAllWgenApps();
	}

	public static int getCountAllWgenApp() throws java.lang.Exception {
		return getService().getCountAllWgenApp();
	}

	public static void clearService() {
		_service = null;
	}

	public static WgenAppLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WgenAppLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					WgenAppLocalService.class.getName(), portletClassLoader);

			_service = new WgenAppLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(WgenAppLocalServiceUtil.class,
				"_service");
			MethodCache.remove(WgenAppLocalService.class);
		}

		return _service;
	}

	public void setService(WgenAppLocalService service) {
		MethodCache.remove(WgenAppLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(WgenAppLocalServiceUtil.class,
			"_service");
		MethodCache.remove(WgenAppLocalService.class);
	}

	private static WgenAppLocalService _service;
}