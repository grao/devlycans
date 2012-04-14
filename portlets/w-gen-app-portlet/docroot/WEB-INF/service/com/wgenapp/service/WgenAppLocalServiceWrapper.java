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
 * This class is a wrapper for {@link WgenAppLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WgenAppLocalService
 * @generated
 */
public class WgenAppLocalServiceWrapper implements WgenAppLocalService,
	ServiceWrapper<WgenAppLocalService> {
	public WgenAppLocalServiceWrapper(WgenAppLocalService wgenAppLocalService) {
		_wgenAppLocalService = wgenAppLocalService;
	}

	/**
	* Adds the wgen app to the database. Also notifies the appropriate model listeners.
	*
	* @param wgenApp the wgen app
	* @return the wgen app that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.wgenapp.model.WgenApp addWgenApp(
		com.wgenapp.model.WgenApp wgenApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.addWgenApp(wgenApp);
	}

	/**
	* Creates a new wgen app with the primary key. Does not add the wgen app to the database.
	*
	* @param WgenAppId the primary key for the new wgen app
	* @return the new wgen app
	*/
	public com.wgenapp.model.WgenApp createWgenApp(long WgenAppId) {
		return _wgenAppLocalService.createWgenApp(WgenAppId);
	}

	/**
	* Deletes the wgen app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param WgenAppId the primary key of the wgen app
	* @throws PortalException if a wgen app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWgenApp(long WgenAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_wgenAppLocalService.deleteWgenApp(WgenAppId);
	}

	/**
	* Deletes the wgen app from the database. Also notifies the appropriate model listeners.
	*
	* @param wgenApp the wgen app
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWgenApp(com.wgenapp.model.WgenApp wgenApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		_wgenAppLocalService.deleteWgenApp(wgenApp);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.wgenapp.model.WgenApp fetchWgenApp(long WgenAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.fetchWgenApp(WgenAppId);
	}

	/**
	* Returns the wgen app with the primary key.
	*
	* @param WgenAppId the primary key of the wgen app
	* @return the wgen app
	* @throws PortalException if a wgen app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wgenapp.model.WgenApp getWgenApp(long WgenAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.getWgenApp(WgenAppId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.wgenapp.model.WgenApp> getWgenApps(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.getWgenApps(start, end);
	}

	/**
	* Returns the number of wgen apps.
	*
	* @return the number of wgen apps
	* @throws SystemException if a system exception occurred
	*/
	public int getWgenAppsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.getWgenAppsCount();
	}

	/**
	* Updates the wgen app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wgenApp the wgen app
	* @return the wgen app that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.wgenapp.model.WgenApp updateWgenApp(
		com.wgenapp.model.WgenApp wgenApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.updateWgenApp(wgenApp);
	}

	/**
	* Updates the wgen app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param wgenApp the wgen app
	* @param merge whether to merge the wgen app with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the wgen app that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.wgenapp.model.WgenApp updateWgenApp(
		com.wgenapp.model.WgenApp wgenApp, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _wgenAppLocalService.updateWgenApp(wgenApp, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _wgenAppLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_wgenAppLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<com.wgenapp.model.WgenApp> getAllWgenApps()
		throws java.lang.Exception {
		return _wgenAppLocalService.getAllWgenApps();
	}

	public int getCountAllWgenApp() throws java.lang.Exception {
		return _wgenAppLocalService.getCountAllWgenApp();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public WgenAppLocalService getWrappedWgenAppLocalService() {
		return _wgenAppLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedWgenAppLocalService(
		WgenAppLocalService wgenAppLocalService) {
		_wgenAppLocalService = wgenAppLocalService;
	}

	public WgenAppLocalService getWrappedService() {
		return _wgenAppLocalService;
	}

	public void setWrappedService(WgenAppLocalService wgenAppLocalService) {
		_wgenAppLocalService = wgenAppLocalService;
	}

	private WgenAppLocalService _wgenAppLocalService;
}