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

package org.slc.sli.headerfooter.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HeaderFooter}.
 * </p>
 *
 * @author    manoj
 * @see       HeaderFooter
 * @generated
 */
public class HeaderFooterWrapper implements HeaderFooter,
	ModelWrapper<HeaderFooter> {
	public HeaderFooterWrapper(HeaderFooter headerFooter) {
		_headerFooter = headerFooter;
	}

	public Class<?> getModelClass() {
		return HeaderFooter.class;
	}

	public String getModelClassName() {
		return HeaderFooter.class.getName();
	}

	/**
	* Returns the primary key of this header footer.
	*
	* @return the primary key of this header footer
	*/
	public long getPrimaryKey() {
		return _headerFooter.getPrimaryKey();
	}

	/**
	* Sets the primary key of this header footer.
	*
	* @param primaryKey the primary key of this header footer
	*/
	public void setPrimaryKey(long primaryKey) {
		_headerFooter.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this header footer.
	*
	* @return the ID of this header footer
	*/
	public long getId() {
		return _headerFooter.getId();
	}

	/**
	* Sets the ID of this header footer.
	*
	* @param id the ID of this header footer
	*/
	public void setId(long id) {
		_headerFooter.setId(id);
	}

	/**
	* Returns the type of this header footer.
	*
	* @return the type of this header footer
	*/
	public java.lang.String getType() {
		return _headerFooter.getType();
	}

	/**
	* Sets the type of this header footer.
	*
	* @param type the type of this header footer
	*/
	public void setType(java.lang.String type) {
		_headerFooter.setType(type);
	}

	/**
	* Returns the data of this header footer.
	*
	* @return the data of this header footer
	*/
	public java.lang.String getData() {
		return _headerFooter.getData();
	}

	/**
	* Sets the data of this header footer.
	*
	* @param data the data of this header footer
	*/
	public void setData(java.lang.String data) {
		_headerFooter.setData(data);
	}

	public boolean isNew() {
		return _headerFooter.isNew();
	}

	public void setNew(boolean n) {
		_headerFooter.setNew(n);
	}

	public boolean isCachedModel() {
		return _headerFooter.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_headerFooter.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _headerFooter.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _headerFooter.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_headerFooter.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _headerFooter.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_headerFooter.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HeaderFooterWrapper((HeaderFooter)_headerFooter.clone());
	}

	public int compareTo(
		org.slc.sli.headerfooter.model.HeaderFooter headerFooter) {
		return _headerFooter.compareTo(headerFooter);
	}

	@Override
	public int hashCode() {
		return _headerFooter.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.slc.sli.headerfooter.model.HeaderFooter> toCacheModel() {
		return _headerFooter.toCacheModel();
	}

	public org.slc.sli.headerfooter.model.HeaderFooter toEscapedModel() {
		return new HeaderFooterWrapper(_headerFooter.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _headerFooter.toString();
	}

	public java.lang.String toXmlString() {
		return _headerFooter.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_headerFooter.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public HeaderFooter getWrappedHeaderFooter() {
		return _headerFooter;
	}

	public HeaderFooter getWrappedModel() {
		return _headerFooter;
	}

	public void resetOriginalValues() {
		_headerFooter.resetOriginalValues();
	}

	private HeaderFooter _headerFooter;
}