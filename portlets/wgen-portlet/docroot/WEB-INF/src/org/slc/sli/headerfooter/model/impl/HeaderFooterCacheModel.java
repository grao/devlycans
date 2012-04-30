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

package org.slc.sli.headerfooter.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.slc.sli.headerfooter.model.HeaderFooter;

import java.io.Serializable;

/**
 * The cache model class for representing HeaderFooter in entity cache.
 *
 * @author manoj
 * @see HeaderFooter
 * @generated
 */
public class HeaderFooterCacheModel implements CacheModel<HeaderFooter>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", type=");
		sb.append(type);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	public HeaderFooter toEntityModel() {
		HeaderFooterImpl headerFooterImpl = new HeaderFooterImpl();

		headerFooterImpl.setId(id);

		if (type == null) {
			headerFooterImpl.setType(StringPool.BLANK);
		}
		else {
			headerFooterImpl.setType(type);
		}

		if (data == null) {
			headerFooterImpl.setData(StringPool.BLANK);
		}
		else {
			headerFooterImpl.setData(data);
		}

		headerFooterImpl.resetOriginalValues();

		return headerFooterImpl;
	}

	public long id;
	public String type;
	public String data;
}