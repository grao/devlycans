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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.slc.sli.headerfooter.service.HeaderFooterLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author manoj
 */
public class HeaderFooterClp extends BaseModelImpl<HeaderFooter>
	implements HeaderFooter {
	public HeaderFooterClp() {
	}

	public Class<?> getModelClass() {
		return HeaderFooter.class;
	}

	public String getModelClassName() {
		return HeaderFooter.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			HeaderFooterLocalServiceUtil.addHeaderFooter(this);
		}
		else {
			HeaderFooterLocalServiceUtil.updateHeaderFooter(this);
		}
	}

	@Override
	public HeaderFooter toEscapedModel() {
		return (HeaderFooter)Proxy.newProxyInstance(HeaderFooter.class.getClassLoader(),
			new Class[] { HeaderFooter.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HeaderFooterClp clone = new HeaderFooterClp();

		clone.setId(getId());
		clone.setType(getType());
		clone.setData(getData());

		return clone;
	}

	public int compareTo(HeaderFooter headerFooter) {
		long primaryKey = headerFooter.getPrimaryKey();

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

		HeaderFooterClp headerFooter = null;

		try {
			headerFooter = (HeaderFooterClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = headerFooter.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", data=");
		sb.append(getData());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.slc.sli.headerfooter.model.HeaderFooter");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data</column-name><column-value><![CDATA[");
		sb.append(getData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _type;
	private String _data;
}