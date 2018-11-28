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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Coordinate}.
 * </p>
 *
 * @author Aleksandar Lukic
 * @see Coordinate
 * @generated
 */
@ProviderType
public class CoordinateWrapper implements Coordinate, ModelWrapper<Coordinate> {
	public CoordinateWrapper(Coordinate coordinate) {
		_coordinate = coordinate;
	}

	@Override
	public Class<?> getModelClass() {
		return Coordinate.class;
	}

	@Override
	public String getModelClassName() {
		return Coordinate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("coordinateId", getCoordinateId());
		attributes.put("shapeId", getShapeId());
		attributes.put("longitude", getLongitude());
		attributes.put("latitude", getLatitude());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long coordinateId = (Long)attributes.get("coordinateId");

		if (coordinateId != null) {
			setCoordinateId(coordinateId);
		}

		Long shapeId = (Long)attributes.get("shapeId");

		if (shapeId != null) {
			setShapeId(shapeId);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}
	}

	@Override
	public Object clone() {
		return new CoordinateWrapper((Coordinate)_coordinate.clone());
	}

	@Override
	public int compareTo(Coordinate coordinate) {
		return _coordinate.compareTo(coordinate);
	}

	/**
	* Returns the coordinate ID of this coordinate.
	*
	* @return the coordinate ID of this coordinate
	*/
	@Override
	public long getCoordinateId() {
		return _coordinate.getCoordinateId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _coordinate.getExpandoBridge();
	}

	/**
	* Returns the latitude of this coordinate.
	*
	* @return the latitude of this coordinate
	*/
	@Override
	public String getLatitude() {
		return _coordinate.getLatitude();
	}

	/**
	* Returns the longitude of this coordinate.
	*
	* @return the longitude of this coordinate
	*/
	@Override
	public String getLongitude() {
		return _coordinate.getLongitude();
	}

	/**
	* Returns the primary key of this coordinate.
	*
	* @return the primary key of this coordinate
	*/
	@Override
	public long getPrimaryKey() {
		return _coordinate.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _coordinate.getPrimaryKeyObj();
	}

	/**
	* Returns the shape ID of this coordinate.
	*
	* @return the shape ID of this coordinate
	*/
	@Override
	public long getShapeId() {
		return _coordinate.getShapeId();
	}

	@Override
	public int hashCode() {
		return _coordinate.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _coordinate.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _coordinate.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _coordinate.isNew();
	}

	@Override
	public void persist() {
		_coordinate.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_coordinate.setCachedModel(cachedModel);
	}

	/**
	* Sets the coordinate ID of this coordinate.
	*
	* @param coordinateId the coordinate ID of this coordinate
	*/
	@Override
	public void setCoordinateId(long coordinateId) {
		_coordinate.setCoordinateId(coordinateId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_coordinate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_coordinate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_coordinate.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the latitude of this coordinate.
	*
	* @param latitude the latitude of this coordinate
	*/
	@Override
	public void setLatitude(String latitude) {
		_coordinate.setLatitude(latitude);
	}

	/**
	* Sets the longitude of this coordinate.
	*
	* @param longitude the longitude of this coordinate
	*/
	@Override
	public void setLongitude(String longitude) {
		_coordinate.setLongitude(longitude);
	}

	@Override
	public void setNew(boolean n) {
		_coordinate.setNew(n);
	}

	/**
	* Sets the primary key of this coordinate.
	*
	* @param primaryKey the primary key of this coordinate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_coordinate.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_coordinate.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the shape ID of this coordinate.
	*
	* @param shapeId the shape ID of this coordinate
	*/
	@Override
	public void setShapeId(long shapeId) {
		_coordinate.setShapeId(shapeId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Coordinate> toCacheModel() {
		return _coordinate.toCacheModel();
	}

	@Override
	public Coordinate toEscapedModel() {
		return new CoordinateWrapper(_coordinate.toEscapedModel());
	}

	@Override
	public String toString() {
		return _coordinate.toString();
	}

	@Override
	public Coordinate toUnescapedModel() {
		return new CoordinateWrapper(_coordinate.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _coordinate.toXmlString();
	}

	@Override
	public void validate() throws javax.portlet.ValidatorException {
		_coordinate.validate();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CoordinateWrapper)) {
			return false;
		}

		CoordinateWrapper coordinateWrapper = (CoordinateWrapper)obj;

		if (Objects.equals(_coordinate, coordinateWrapper._coordinate)) {
			return true;
		}

		return false;
	}

	@Override
	public Coordinate getWrappedModel() {
		return _coordinate;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _coordinate.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _coordinate.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_coordinate.resetOriginalValues();
	}

	private final Coordinate _coordinate;
}