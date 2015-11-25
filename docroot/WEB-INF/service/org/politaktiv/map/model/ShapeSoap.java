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
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.service.http.ShapeServiceSoap}.
 *
 * @author Paul Butenko
 * @see org.politaktiv.map.service.http.ShapeServiceSoap
 * @generated
 */
public class ShapeSoap implements Serializable {
	public static ShapeSoap toSoapModel(Shape model) {
		ShapeSoap soapModel = new ShapeSoap();

		soapModel.setShapeId(model.getShapeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setAbstractDescription(model.getAbstractDescription());
		soapModel.setUrl(model.getUrl());
		soapModel.setShapeType(model.getShapeType());
		soapModel.setRadius(model.getRadius());
		soapModel.setLayer(model.getLayer());

		return soapModel;
	}

	public static ShapeSoap[] toSoapModels(Shape[] models) {
		ShapeSoap[] soapModels = new ShapeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ShapeSoap[][] toSoapModels(Shape[][] models) {
		ShapeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ShapeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ShapeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ShapeSoap[] toSoapModels(List<Shape> models) {
		List<ShapeSoap> soapModels = new ArrayList<ShapeSoap>(models.size());

		for (Shape model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ShapeSoap[soapModels.size()]);
	}

	public ShapeSoap() {
	}

	public long getPrimaryKey() {
		return _shapeId;
	}

	public void setPrimaryKey(long pk) {
		setShapeId(pk);
	}

	public long getShapeId() {
		return _shapeId;
	}

	public void setShapeId(long shapeId) {
		_shapeId = shapeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getAbstractDescription() {
		return _abstractDescription;
	}

	public void setAbstractDescription(String abstractDescription) {
		_abstractDescription = abstractDescription;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getShapeType() {
		return _shapeType;
	}

	public void setShapeType(String shapeType) {
		_shapeType = shapeType;
	}

	public long getRadius() {
		return _radius;
	}

	public void setRadius(long radius) {
		_radius = radius;
	}

	public String getLayer() {
		return _layer;
	}

	public void setLayer(String layer) {
		_layer = layer;
	}

	private long _shapeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _abstractDescription;
	private String _url;
	private String _shapeType;
	private long _radius;
	private String _layer;
}