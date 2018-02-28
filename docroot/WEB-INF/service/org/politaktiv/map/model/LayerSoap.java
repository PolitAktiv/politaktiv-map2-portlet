/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package org.politaktiv.map.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.service.http.LayerServiceSoap}.
 *
 * @author Paul Butenko
 * @see org.politaktiv.map.service.http.LayerServiceSoap
 * @generated
 */
public class LayerSoap implements Serializable {
	public static LayerSoap toSoapModel(Layer model) {
		LayerSoap soapModel = new LayerSoap();

		soapModel.setLayerId(model.getLayerId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setLabel(model.getLabel());
		soapModel.setUserId(model.getUserId());
		soapModel.setPortletInstance(model.getPortletInstance());

		return soapModel;
	}

	public static LayerSoap[] toSoapModels(Layer[] models) {
		LayerSoap[] soapModels = new LayerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LayerSoap[][] toSoapModels(Layer[][] models) {
		LayerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LayerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LayerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LayerSoap[] toSoapModels(List<Layer> models) {
		List<LayerSoap> soapModels = new ArrayList<LayerSoap>(models.size());

		for (Layer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LayerSoap[soapModels.size()]);
	}

	public LayerSoap() {
	}

	public long getPrimaryKey() {
		return _layerId;
	}

	public void setPrimaryKey(long pk) {
		setLayerId(pk);
	}

	public long getLayerId() {
		return _layerId;
	}

	public void setLayerId(long layerId) {
		_layerId = layerId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getPortletInstance() {
		return _portletInstance;
	}

	public void setPortletInstance(String portletInstance) {
		_portletInstance = portletInstance;
	}

	private long _layerId;
	private Date _createDate;
	private String _label;
	private long _userId;
	private String _portletInstance;
}