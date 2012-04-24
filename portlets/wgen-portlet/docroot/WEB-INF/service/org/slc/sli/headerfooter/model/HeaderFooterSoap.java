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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.slc.sli.headerfooter.service.http.HeaderFooterServiceSoap}.
 *
 * @author    manoj
 * @see       org.slc.sli.headerfooter.service.http.HeaderFooterServiceSoap
 * @generated
 */
public class HeaderFooterSoap implements Serializable {
	public static HeaderFooterSoap toSoapModel(HeaderFooter model) {
		HeaderFooterSoap soapModel = new HeaderFooterSoap();

		soapModel.setId(model.getId());
		soapModel.setType(model.getType());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static HeaderFooterSoap[] toSoapModels(HeaderFooter[] models) {
		HeaderFooterSoap[] soapModels = new HeaderFooterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HeaderFooterSoap[][] toSoapModels(HeaderFooter[][] models) {
		HeaderFooterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HeaderFooterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HeaderFooterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HeaderFooterSoap[] toSoapModels(List<HeaderFooter> models) {
		List<HeaderFooterSoap> soapModels = new ArrayList<HeaderFooterSoap>(models.size());

		for (HeaderFooter model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HeaderFooterSoap[soapModels.size()]);
	}

	public HeaderFooterSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	private long _id;
	private String _type;
	private String _data;
}