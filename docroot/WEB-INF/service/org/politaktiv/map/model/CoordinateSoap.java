/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.politaktiv.map.service.http.CoordinateServiceSoap}.
 *
 * @author Aleksandar Lukic
 * @see org.politaktiv.map.service.http.CoordinateServiceSoap
 * @generated
 */
@ProviderType
public class CoordinateSoap implements Serializable {
	public static CoordinateSoap toSoapModel(Coordinate model) {
		CoordinateSoap soapModel = new CoordinateSoap();

		soapModel.setCoordinateId(model.getCoordinateId());
		soapModel.setShapeId(model.getShapeId());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setLatitude(model.getLatitude());

		return soapModel;
	}

	public static CoordinateSoap[] toSoapModels(Coordinate[] models) {
		CoordinateSoap[] soapModels = new CoordinateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CoordinateSoap[][] toSoapModels(Coordinate[][] models) {
		CoordinateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CoordinateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CoordinateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CoordinateSoap[] toSoapModels(List<Coordinate> models) {
		List<CoordinateSoap> soapModels = new ArrayList<CoordinateSoap>(models.size());

		for (Coordinate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CoordinateSoap[soapModels.size()]);
	}

	public CoordinateSoap() {
	}

	public long getPrimaryKey() {
		return _coordinateId;
	}

	public void setPrimaryKey(long pk) {
		setCoordinateId(pk);
	}

	public long getCoordinateId() {
		return _coordinateId;
	}

	public void setCoordinateId(long coordinateId) {
		_coordinateId = coordinateId;
	}

	public long getShapeId() {
		return _shapeId;
	}

	public void setShapeId(long shapeId) {
		_shapeId = shapeId;
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

	private long _coordinateId;
	private long _shapeId;
	private String _longitude;
	private String _latitude;
}