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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.wgenapp.service.http.WgenAppServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.wgenapp.service.http.WgenAppServiceSoap
 * @generated
 */
public class WgenAppSoap implements Serializable {
	public static WgenAppSoap toSoapModel(WgenApp model) {
		WgenAppSoap soapModel = new WgenAppSoap();

		soapModel.setWgenAppId(model.getWgenAppId());
		soapModel.setWgenAppTitle(model.getWgenAppTitle());
		soapModel.setWgenAppDescription(model.getWgenAppDescription());
		soapModel.setWgenAppURL(model.getWgenAppURL());

		return soapModel;
	}

	public static WgenAppSoap[] toSoapModels(WgenApp[] models) {
		WgenAppSoap[] soapModels = new WgenAppSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WgenAppSoap[][] toSoapModels(WgenApp[][] models) {
		WgenAppSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WgenAppSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WgenAppSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WgenAppSoap[] toSoapModels(List<WgenApp> models) {
		List<WgenAppSoap> soapModels = new ArrayList<WgenAppSoap>(models.size());

		for (WgenApp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WgenAppSoap[soapModels.size()]);
	}

	public WgenAppSoap() {
	}

	public long getPrimaryKey() {
		return _WgenAppId;
	}

	public void setPrimaryKey(long pk) {
		setWgenAppId(pk);
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

	private long _WgenAppId;
	private String _WgenAppTitle;
	private String _WgenAppDescription;
	private String _WgenAppURL;
}