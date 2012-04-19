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

package com.wgenapp.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.wgenapp.model.WgenApp;

import java.util.List;

/**
 * The persistence utility for the wgen app service. This utility wraps {@link WgenAppPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WgenAppPersistence
 * @see WgenAppPersistenceImpl
 * @generated
 */
public class WgenAppUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(WgenApp wgenApp) {
		getPersistence().clearCache(wgenApp);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WgenApp> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WgenApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WgenApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static WgenApp remove(WgenApp wgenApp) throws SystemException {
		return getPersistence().remove(wgenApp);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static WgenApp update(WgenApp wgenApp, boolean merge)
		throws SystemException {
		return getPersistence().update(wgenApp, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static WgenApp update(WgenApp wgenApp, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(wgenApp, merge, serviceContext);
	}

	/**
	* Caches the wgen app in the entity cache if it is enabled.
	*
	* @param wgenApp the wgen app
	*/
	public static void cacheResult(com.wgenapp.model.WgenApp wgenApp) {
		getPersistence().cacheResult(wgenApp);
	}

	/**
	* Caches the wgen apps in the entity cache if it is enabled.
	*
	* @param wgenApps the wgen apps
	*/
	public static void cacheResult(
		java.util.List<com.wgenapp.model.WgenApp> wgenApps) {
		getPersistence().cacheResult(wgenApps);
	}

	/**
	* Creates a new wgen app with the primary key. Does not add the wgen app to the database.
	*
	* @param WgenAppId the primary key for the new wgen app
	* @return the new wgen app
	*/
	public static com.wgenapp.model.WgenApp create(long WgenAppId) {
		return getPersistence().create(WgenAppId);
	}

	/**
	* Removes the wgen app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param WgenAppId the primary key of the wgen app
	* @return the wgen app that was removed
	* @throws com.wgenapp.NoSuchWgenAppException if a wgen app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.wgenapp.model.WgenApp remove(long WgenAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wgenapp.NoSuchWgenAppException {
		return getPersistence().remove(WgenAppId);
	}

	public static com.wgenapp.model.WgenApp updateImpl(
		com.wgenapp.model.WgenApp wgenApp, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(wgenApp, merge);
	}

	/**
	* Returns the wgen app with the primary key or throws a {@link com.wgenapp.NoSuchWgenAppException} if it could not be found.
	*
	* @param WgenAppId the primary key of the wgen app
	* @return the wgen app
	* @throws com.wgenapp.NoSuchWgenAppException if a wgen app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.wgenapp.model.WgenApp findByPrimaryKey(long WgenAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wgenapp.NoSuchWgenAppException {
		return getPersistence().findByPrimaryKey(WgenAppId);
	}

	/**
	* Returns the wgen app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param WgenAppId the primary key of the wgen app
	* @return the wgen app, or <code>null</code> if a wgen app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.wgenapp.model.WgenApp fetchByPrimaryKey(long WgenAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(WgenAppId);
	}

	/**
	* Returns all the wgen apps.
	*
	* @return the wgen apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.wgenapp.model.WgenApp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.wgenapp.model.WgenApp> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the wgen apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of wgen apps
	* @param end the upper bound of the range of wgen apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of wgen apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.wgenapp.model.WgenApp> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the wgen apps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of wgen apps.
	*
	* @return the number of wgen apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WgenAppPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WgenAppPersistence)PortletBeanLocatorUtil.locate(com.wgenapp.service.ClpSerializer.getServletContextName(),
					WgenAppPersistence.class.getName());

			ReferenceRegistry.registerReference(WgenAppUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(WgenAppPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(WgenAppUtil.class, "_persistence");
	}

	private static WgenAppPersistence _persistence;
}