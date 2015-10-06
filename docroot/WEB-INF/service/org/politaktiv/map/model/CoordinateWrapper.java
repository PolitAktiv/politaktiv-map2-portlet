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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Coordinate}.
 * </p>
 *
 * @author Paul Butenko
 * @see Coordinate
 * @generated
 */
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

	/**
	* Returns the primary key of this coordinate.
	*
	* @return the primary key of this coordinate
	*/
	@Override
	public long getPrimaryKey() {
		return _coordinate.getPrimaryKey();
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

	/**
	* Returns the coordinate ID of this coordinate.
	*
	* @return the coordinate ID of this coordinate
	*/
	@Override
	public long getCoordinateId() {
		return _coordinate.getCoordinateId();
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

	/**
	* Returns the shape ID of this coordinate.
	*
	* @return the shape ID of this coordinate
	*/
	@Override
	public long getShapeId() {
		return _coordinate.getShapeId();
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

	/**
	* Returns the longitude of this coordinate.
	*
	* @return the longitude of this coordinate
	*/
	@Override
	public java.lang.String getLongitude() {
		return _coordinate.getLongitude();
	}

	/**
	* Sets the longitude of this coordinate.
	*
	* @param longitude the longitude of this coordinate
	*/
	@Override
	public void setLongitude(java.lang.String longitude) {
		_coordinate.setLongitude(longitude);
	}

	/**
	* Returns the latitude of this coordinate.
	*
	* @return the latitude of this coordinate
	*/
	@Override
	public java.lang.String getLatitude() {
		return _coordinate.getLatitude();
	}

	/**
	* Sets the latitude of this coordinate.
	*
	* @param latitude the latitude of this coordinate
	*/
	@Override
	public void setLatitude(java.lang.String latitude) {
		_coordinate.setLatitude(latitude);
	}

	@Override
	public boolean isNew() {
		return _coordinate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_coordinate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _coordinate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_coordinate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _coordinate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _coordinate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_coordinate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _coordinate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_coordinate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_coordinate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_coordinate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CoordinateWrapper((Coordinate)_coordinate.clone());
	}

	@Override
	public int compareTo(org.politaktiv.map.model.Coordinate coordinate) {
		return _coordinate.compareTo(coordinate);
	}

	@Override
	public int hashCode() {
		return _coordinate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.politaktiv.map.model.Coordinate> toCacheModel() {
		return _coordinate.toCacheModel();
	}

	@Override
	public org.politaktiv.map.model.Coordinate toEscapedModel() {
		return new CoordinateWrapper(_coordinate.toEscapedModel());
	}

	@Override
	public org.politaktiv.map.model.Coordinate toUnescapedModel() {
		return new CoordinateWrapper(_coordinate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _coordinate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _coordinate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_coordinate.persist();
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

		if (Validator.equals(_coordinate, coordinateWrapper._coordinate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Coordinate getWrappedCoordinate() {
		return _coordinate;
	}

	@Override
	public Coordinate getWrappedModel() {
		return _coordinate;
	}

	@Override
	public void resetOriginalValues() {
		_coordinate.resetOriginalValues();
	}

	private Coordinate _coordinate;
}