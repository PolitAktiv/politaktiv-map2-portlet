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
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.service.http.MarkerServiceSoap}.
 *
 * @author Paul Butenko
 * @see org.politaktiv.map.service.http.MarkerServiceSoap
 * @generated
 */
public class MarkerSoap implements Serializable {
	public static MarkerSoap toSoapModel(Marker model) {
		MarkerSoap soapModel = new MarkerSoap();

		soapModel.setMarkerId(model.getMarkerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setLatitude(model.getLatitude());

		return soapModel;
	}

	public static MarkerSoap[] toSoapModels(Marker[] models) {
		MarkerSoap[] soapModels = new MarkerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MarkerSoap[][] toSoapModels(Marker[][] models) {
		MarkerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MarkerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MarkerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MarkerSoap[] toSoapModels(List<Marker> models) {
		List<MarkerSoap> soapModels = new ArrayList<MarkerSoap>(models.size());

		for (Marker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MarkerSoap[soapModels.size()]);
	}

	public MarkerSoap() {
	}

	public long getPrimaryKey() {
		return _markerId;
	}

	public void setPrimaryKey(long pk) {
		setMarkerId(pk);
	}

	public long getMarkerId() {
		return _markerId;
	}

	public void setMarkerId(long markerId) {
		_markerId = markerId;
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

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getLongitude() {
		return _longitude;
	}

	public void setLongitude(String longitude) {
		_longitude = longitude;
	}

	public String getLatitude() {
		return _latitude;
	}

	public void setLatitude(String latitude) {
		_latitude = latitude;
	}

	private long _markerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _content;
	private String _longitude;
	private String _latitude;
}