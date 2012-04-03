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

package com.wgenapp.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link WgenApp}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WgenApp
 * @generated
 */
public class WgenAppWrapper implements WgenApp, ModelWrapper<WgenApp> {
	public WgenAppWrapper(WgenApp wgenApp) {
		_wgenApp = wgenApp;
	}

	public Class<?> getModelClass() {
		return WgenApp.class;
	}

	public String getModelClassName() {
		return WgenApp.class.getName();
	}

	/**
	* Returns the primary key of this wgen app.
	*
	* @return the primary key of this wgen app
	*/
	public long getPrimaryKey() {
		return _wgenApp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this wgen app.
	*
	* @param primaryKey the primary key of this wgen app
	*/
	public void setPrimaryKey(long primaryKey) {
		_wgenApp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the wgen app ID of this wgen app.
	*
	* @return the wgen app ID of this wgen app
	*/
	public long getWgenAppId() {
		return _wgenApp.getWgenAppId();
	}

	/**
	* Sets the wgen app ID of this wgen app.
	*
	* @param WgenAppId the wgen app ID of this wgen app
	*/
	public void setWgenAppId(long WgenAppId) {
		_wgenApp.setWgenAppId(WgenAppId);
	}

	/**
	* Returns the wgen app title of this wgen app.
	*
	* @return the wgen app title of this wgen app
	*/
	public java.lang.String getWgenAppTitle() {
		return _wgenApp.getWgenAppTitle();
	}

	/**
	* Sets the wgen app title of this wgen app.
	*
	* @param WgenAppTitle the wgen app title of this wgen app
	*/
	public void setWgenAppTitle(java.lang.String WgenAppTitle) {
		_wgenApp.setWgenAppTitle(WgenAppTitle);
	}

	/**
	* Returns the wgen app description of this wgen app.
	*
	* @return the wgen app description of this wgen app
	*/
	public java.lang.String getWgenAppDescription() {
		return _wgenApp.getWgenAppDescription();
	}

	/**
	* Sets the wgen app description of this wgen app.
	*
	* @param WgenAppDescription the wgen app description of this wgen app
	*/
	public void setWgenAppDescription(java.lang.String WgenAppDescription) {
		_wgenApp.setWgenAppDescription(WgenAppDescription);
	}

	/**
	* Returns the wgen app u r l of this wgen app.
	*
	* @return the wgen app u r l of this wgen app
	*/
	public java.lang.String getWgenAppURL() {
		return _wgenApp.getWgenAppURL();
	}

	/**
	* Sets the wgen app u r l of this wgen app.
	*
	* @param WgenAppURL the wgen app u r l of this wgen app
	*/
	public void setWgenAppURL(java.lang.String WgenAppURL) {
		_wgenApp.setWgenAppURL(WgenAppURL);
	}

	public boolean isNew() {
		return _wgenApp.isNew();
	}

	public void setNew(boolean n) {
		_wgenApp.setNew(n);
	}

	public boolean isCachedModel() {
		return _wgenApp.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_wgenApp.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _wgenApp.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _wgenApp.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_wgenApp.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _wgenApp.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_wgenApp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WgenAppWrapper((WgenApp)_wgenApp.clone());
	}

	public int compareTo(com.wgenapp.model.WgenApp wgenApp) {
		return _wgenApp.compareTo(wgenApp);
	}

	@Override
	public int hashCode() {
		return _wgenApp.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.wgenapp.model.WgenApp> toCacheModel() {
		return _wgenApp.toCacheModel();
	}

	public com.wgenapp.model.WgenApp toEscapedModel() {
		return new WgenAppWrapper(_wgenApp.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _wgenApp.toString();
	}

	public java.lang.String toXmlString() {
		return _wgenApp.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_wgenApp.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public WgenApp getWrappedWgenApp() {
		return _wgenApp;
	}

	public WgenApp getWrappedModel() {
		return _wgenApp;
	}

	public void resetOriginalValues() {
		_wgenApp.resetOriginalValues();
	}

	private WgenApp _wgenApp;
}