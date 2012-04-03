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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.wgenapp.service.WgenAppLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Brian Wing Shun Chan
 */
public class WgenAppClp extends BaseModelImpl<WgenApp> implements WgenApp {
	public WgenAppClp() {
	}

	public Class<?> getModelClass() {
		return WgenApp.class;
	}

	public String getModelClassName() {
		return WgenApp.class.getName();
	}

	public long getPrimaryKey() {
		return _WgenAppId;
	}

	public void setPrimaryKey(long primaryKey) {
		setWgenAppId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_WgenAppId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getWgenAppId() {
		return _WgenAppId;
	}

	public void setWgenAppId(long WgenAppId) {
		_WgenAppId = WgenAppId;
	}

	public String getWgenAppTitle() {
		return _WgenAppTitle;
	}

	public void setWgenAppTitle(String WgenAppTitle) {
		_WgenAppTitle = WgenAppTitle;
	}

	public String getWgenAppDescription() {
		return _WgenAppDescription;
	}

	public void setWgenAppDescription(String WgenAppDescription) {
		_WgenAppDescription = WgenAppDescription;
	}

	public String getWgenAppURL() {
		return _WgenAppURL;
	}

	public void setWgenAppURL(String WgenAppURL) {
		_WgenAppURL = WgenAppURL;
	}

	public void persist() throws SystemException {
		WgenAppLocalServiceUtil.updateWgenApp(this);
	}

	@Override
	public WgenApp toEscapedModel() {
		return (WgenApp)Proxy.newProxyInstance(WgenApp.class.getClassLoader(),
			new Class[] { WgenApp.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WgenAppClp clone = new WgenAppClp();

		clone.setWgenAppId(getWgenAppId());
		clone.setWgenAppTitle(getWgenAppTitle());
		clone.setWgenAppDescription(getWgenAppDescription());
		clone.setWgenAppURL(getWgenAppURL());

		return clone;
	}

	public int compareTo(WgenApp wgenApp) {
		long primaryKey = wgenApp.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		WgenAppClp wgenApp = null;

		try {
			wgenApp = (WgenAppClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wgenApp.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{WgenAppId=");
		sb.append(getWgenAppId());
		sb.append(", WgenAppTitle=");
		sb.append(getWgenAppTitle());
		sb.append(", WgenAppDescription=");
		sb.append(getWgenAppDescription());
		sb.append(", WgenAppURL=");
		sb.append(getWgenAppURL());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.wgenapp.model.WgenApp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>WgenAppId</column-name><column-value><![CDATA[");
		sb.append(getWgenAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>WgenAppTitle</column-name><column-value><![CDATA[");
		sb.append(getWgenAppTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>WgenAppDescription</column-name><column-value><![CDATA[");
		sb.append(getWgenAppDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>WgenAppURL</column-name><column-value><![CDATA[");
		sb.append(getWgenAppURL());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _WgenAppId;
	private String _WgenAppTitle;
	private String _WgenAppDescription;
	private String _WgenAppURL;
}