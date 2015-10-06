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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Coordinate service. Represents a row in the &quot;politaktivmaptwo_Coordinate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.politaktiv.map.model.impl.CoordinateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.politaktiv.map.model.impl.CoordinateImpl}.
 * </p>
 *
 * @author Paul Butenko
 * @see Coordinate
 * @see org.politaktiv.map.model.impl.CoordinateImpl
 * @see org.politaktiv.map.model.impl.CoordinateModelImpl
 * @generated
 */
public interface CoordinateModel extends BaseModel<Coordinate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a coordinate model instance should use the {@link Coordinate} interface instead.
	 */

	/**
	 * Returns the primary key of this coordinate.
	 *
	 * @return the primary key of this coordinate
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this coordinate.
	 *
	 * @param primaryKey the primary key of this coordinate
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the coordinate ID of this coordinate.
	 *
	 * @return the coordinate ID of this coordinate
	 */
	public long getCoordinateId();

	/**
	 * Sets the coordinate ID of this coordinate.
	 *
	 * @param coordinateId the coordinate ID of this coordinate
	 */
	public void setCoordinateId(long coordinateId);

	/**
	 * Returns the shape ID of this coordinate.
	 *
	 * @return the shape ID of this coordinate
	 */
	public long getShapeId();

	/**
	 * Sets the shape ID of this coordinate.
	 *
	 * @param shapeId the shape ID of this coordinate
	 */
	public void setShapeId(long shapeId);

	/**
	 * Returns the longitude of this coordinate.
	 *
	 * @return the longitude of this coordinate
	 */
	@AutoEscape
	public String getLongitude();

	/**
	 * Sets the longitude of this coordinate.
	 *
	 * @param longitude the longitude of this coordinate
	 */
	public void setLongitude(String longitude);

	/**
	 * Returns the latitude of this coordinate.
	 *
	 * @return the latitude of this coordinate
	 */
	@AutoEscape
	public String getLatitude();

	/**
	 * Sets the latitude of this coordinate.
	 *
	 * @param latitude the latitude of this coordinate
	 */
	public void setLatitude(String latitude);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Coordinate coordinate);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Coordinate> toCacheModel();

	@Override
	public Coordinate toEscapedModel();

	@Override
	public Coordinate toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}