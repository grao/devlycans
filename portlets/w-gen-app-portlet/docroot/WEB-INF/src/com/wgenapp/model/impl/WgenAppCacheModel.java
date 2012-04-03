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

package com.wgenapp.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.wgenapp.model.WgenApp;

import java.io.Serializable;

/**
 * The cache model class for representing WgenApp in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see WgenApp
 * @generated
 */
public class WgenAppCacheModel implements CacheModel<WgenApp>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{WgenAppId=");
		sb.append(WgenAppId);
		sb.append(", WgenAppTitle=");
		sb.append(WgenAppTitle);
		sb.append(", WgenAppDescription=");
		sb.append(WgenAppDescription);
		sb.append(", WgenAppURL=");
		sb.append(WgenAppURL);
		sb.append("}");

		return sb.toString();
	}

	public WgenApp toEntityModel() {
		WgenAppImpl wgenAppImpl = new WgenAppImpl();

		wgenAppImpl.setWgenAppId(WgenAppId);

		if (WgenAppTitle == null) {
			wgenAppImpl.setWgenAppTitle(StringPool.BLANK);
		}
		else {
			wgenAppImpl.setWgenAppTitle(WgenAppTitle);
		}

		if (WgenAppDescription == null) {
			wgenAppImpl.setWgenAppDescription(StringPool.BLANK);
		}
		else {
			wgenAppImpl.setWgenAppDescription(WgenAppDescription);
		}

		if (WgenAppURL == null) {
			wgenAppImpl.setWgenAppURL(StringPool.BLANK);
		}
		else {
			wgenAppImpl.setWgenAppURL(WgenAppURL);
		}

		wgenAppImpl.resetOriginalValues();

		return wgenAppImpl;
	}

	public long WgenAppId;
	public String WgenAppTitle;
	public String WgenAppDescription;
	public String WgenAppURL;
}