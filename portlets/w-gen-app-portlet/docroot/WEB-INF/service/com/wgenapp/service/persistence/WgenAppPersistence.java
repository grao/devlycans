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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

import com.wgenapp.model.WgenApp;

/**
 * The persistence interface for the wgen app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WgenAppPersistenceImpl
 * @see WgenAppUtil
 * @generated
 */
public interface WgenAppPersistence extends BasePersistence<WgenApp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WgenAppUtil} to access the wgen app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the wgen app in the entity cache if it is enabled.
	*
	* @param wgenApp the wgen app
	*/
	public void cacheResult(com.wgenapp.model.WgenApp wgenApp);

	/**
	* Caches the wgen apps in the entity cache if it is enabled.
	*
	* @param wgenApps the wgen apps
	*/
	public void cacheResult(java.util.List<com.wgenapp.model.WgenApp> wgenApps);

	/**
	* Creates a new wgen app with the primary key. Does not add the wgen app to the database.
	*
	* @param WgenAppId the primary key for the new wgen app
	* @return the new wgen app
	*/
	public com.wgenapp.model.WgenApp create(long WgenAppId);

	/**
	* Removes the wgen app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param WgenAppId the primary key of the wgen app
	* @return the wgen app that was removed
	* @throws com.wgenapp.NoSuchWgenAppException if a wgen app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wgenapp.model.WgenApp remove(long WgenAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wgenapp.NoSuchWgenAppException;

	public com.wgenapp.model.WgenApp updateImpl(
		com.wgenapp.model.WgenApp wgenApp, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the wgen app with the primary key or throws a {@link com.wgenapp.NoSuchWgenAppException} if it could not be found.
	*
	* @param WgenAppId the primary key of the wgen app
	* @return the wgen app
	* @throws com.wgenapp.NoSuchWgenAppException if a wgen app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wgenapp.model.WgenApp findByPrimaryKey(long WgenAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wgenapp.NoSuchWgenAppException;

	/**
	* Returns the wgen app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param WgenAppId the primary key of the wgen app
	* @return the wgen app, or <code>null</code> if a wgen app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wgenapp.model.WgenApp fetchByPrimaryKey(long WgenAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the wgen apps.
	*
	* @return the wgen apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.wgenapp.model.WgenApp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.wgenapp.model.WgenApp> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.wgenapp.model.WgenApp> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the wgen apps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of wgen apps.
	*
	* @return the number of wgen apps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public WgenApp remove(WgenApp wgenApp) throws SystemException;
}