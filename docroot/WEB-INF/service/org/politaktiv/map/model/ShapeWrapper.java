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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Shape}.
 * </p>
 *
 * @author Aleksandar Lukic
 * @see Shape
 * @generated
 */
@ProviderType
public class ShapeWrapper implements Shape, ModelWrapper<Shape> {
	public ShapeWrapper(Shape shape) {
		_shape = shape;
	}

	@Override
	public Class<?> getModelClass() {
		return Shape.class;
	}

	@Override
	public String getModelClassName() {
		return Shape.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("shapeId", getShapeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("abstractDescription", getAbstractDescription());
		attributes.put("url", getUrl());
		attributes.put("shapeType", getShapeType());
		attributes.put("radius", getRadius());
		attributes.put("layer", getLayer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long shapeId = (Long)attributes.get("shapeId");

		if (shapeId != null) {
			setShapeId(shapeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String abstractDescription = (String)attributes.get(
				"abstractDescription");

		if (abstractDescription != null) {
			setAbstractDescription(abstractDescription);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String shapeType = (String)attributes.get("shapeType");

		if (shapeType != null) {
			setShapeType(shapeType);
		}

		Long radius = (Long)attributes.get("radius");

		if (radius != null) {
			setRadius(radius);
		}

		String layer = (String)attributes.get("layer");

		if (layer != null) {
			setLayer(layer);
		}
	}

	@Override
	public Object clone() {
		return new ShapeWrapper((Shape)_shape.clone());
	}

	@Override
	public int compareTo(Shape shape) {
		return _shape.compareTo(shape);
	}

	/**
	* Returns the abstract description of this shape.
	*
	* @return the abstract description of this shape
	*/
	@Override
	public String getAbstractDescription() {
		return _shape.getAbstractDescription();
	}

	/**
	* Returns the company ID of this shape.
	*
	* @return the company ID of this shape
	*/
	@Override
	public long getCompanyId() {
		return _shape.getCompanyId();
	}

	@Override
	public java.util.List<Coordinate> getCoordinates()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shape.getCoordinates();
	}

	/**
	* Returns the create date of this shape.
	*
	* @return the create date of this shape
	*/
	@Override
	public Date getCreateDate() {
		return _shape.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _shape.getExpandoBridge();
	}

	/**
	* Returns the group ID of this shape.
	*
	* @return the group ID of this shape
	*/
	@Override
	public long getGroupId() {
		return _shape.getGroupId();
	}

	/**
	* Returns the layer of this shape.
	*
	* @return the layer of this shape
	*/
	@Override
	public String getLayer() {
		return _shape.getLayer();
	}

	/**
	* Returns the modified date of this shape.
	*
	* @return the modified date of this shape
	*/
	@Override
	public Date getModifiedDate() {
		return _shape.getModifiedDate();
	}

	/**
	* Returns the primary key of this shape.
	*
	* @return the primary key of this shape
	*/
	@Override
	public long getPrimaryKey() {
		return _shape.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _shape.getPrimaryKeyObj();
	}

	/**
	* Returns the radius of this shape.
	*
	* @return the radius of this shape
	*/
	@Override
	public long getRadius() {
		return _shape.getRadius();
	}

	/**
	* Returns the shape ID of this shape.
	*
	* @return the shape ID of this shape
	*/
	@Override
	public long getShapeId() {
		return _shape.getShapeId();
	}

	/**
	* Returns the shape type of this shape.
	*
	* @return the shape type of this shape
	*/
	@Override
	public String getShapeType() {
		return _shape.getShapeType();
	}

	/**
	* Returns the title of this shape.
	*
	* @return the title of this shape
	*/
	@Override
	public String getTitle() {
		return _shape.getTitle();
	}

	/**
	* Returns the url of this shape.
	*
	* @return the url of this shape
	*/
	@Override
	public String getUrl() {
		return _shape.getUrl();
	}

	/**
	* Returns the user ID of this shape.
	*
	* @return the user ID of this shape
	*/
	@Override
	public long getUserId() {
		return _shape.getUserId();
	}

	/**
	* Returns the user name of this shape.
	*
	* @return the user name of this shape
	*/
	@Override
	public String getUserName() {
		return _shape.getUserName();
	}

	/**
	* Returns the user uuid of this shape.
	*
	* @return the user uuid of this shape
	*/
	@Override
	public String getUserUuid() {
		return _shape.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _shape.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _shape.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _shape.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _shape.isNew();
	}

	@Override
	public void persist() {
		_shape.persist();
	}

	/**
	* Sets the abstract description of this shape.
	*
	* @param abstractDescription the abstract description of this shape
	*/
	@Override
	public void setAbstractDescription(String abstractDescription) {
		_shape.setAbstractDescription(abstractDescription);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_shape.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this shape.
	*
	* @param companyId the company ID of this shape
	*/
	@Override
	public void setCompanyId(long companyId) {
		_shape.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this shape.
	*
	* @param createDate the create date of this shape
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_shape.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_shape.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_shape.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_shape.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this shape.
	*
	* @param groupId the group ID of this shape
	*/
	@Override
	public void setGroupId(long groupId) {
		_shape.setGroupId(groupId);
	}

	/**
	* Sets the layer of this shape.
	*
	* @param layer the layer of this shape
	*/
	@Override
	public void setLayer(String layer) {
		_shape.setLayer(layer);
	}

	/**
	* Sets the modified date of this shape.
	*
	* @param modifiedDate the modified date of this shape
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_shape.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_shape.setNew(n);
	}

	/**
	* Sets the primary key of this shape.
	*
	* @param primaryKey the primary key of this shape
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_shape.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_shape.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the radius of this shape.
	*
	* @param radius the radius of this shape
	*/
	@Override
	public void setRadius(long radius) {
		_shape.setRadius(radius);
	}

	/**
	* Sets the shape ID of this shape.
	*
	* @param shapeId the shape ID of this shape
	*/
	@Override
	public void setShapeId(long shapeId) {
		_shape.setShapeId(shapeId);
	}

	/**
	* Sets the shape type of this shape.
	*
	* @param shapeType the shape type of this shape
	*/
	@Override
	public void setShapeType(String shapeType) {
		_shape.setShapeType(shapeType);
	}

	/**
	* Sets the title of this shape.
	*
	* @param title the title of this shape
	*/
	@Override
	public void setTitle(String title) {
		_shape.setTitle(title);
	}

	/**
	* Sets the url of this shape.
	*
	* @param url the url of this shape
	*/
	@Override
	public void setUrl(String url) {
		_shape.setUrl(url);
	}

	/**
	* Sets the user ID of this shape.
	*
	* @param userId the user ID of this shape
	*/
	@Override
	public void setUserId(long userId) {
		_shape.setUserId(userId);
	}

	/**
	* Sets the user name of this shape.
	*
	* @param userName the user name of this shape
	*/
	@Override
	public void setUserName(String userName) {
		_shape.setUserName(userName);
	}

	/**
	* Sets the user uuid of this shape.
	*
	* @param userUuid the user uuid of this shape
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_shape.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Shape> toCacheModel() {
		return _shape.toCacheModel();
	}

	@Override
	public Shape toEscapedModel() {
		return new ShapeWrapper(_shape.toEscapedModel());
	}

	@Override
	public String toString() {
		return _shape.toString();
	}

	@Override
	public Shape toUnescapedModel() {
		return new ShapeWrapper(_shape.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _shape.toXmlString();
	}

	@Override
	public void validate(java.util.List<java.util.List<String>> points)
		throws javax.portlet.ValidatorException,
			com.liferay.portal.kernel.exception.SystemException {
		_shape.validate(points);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShapeWrapper)) {
			return false;
		}

		ShapeWrapper shapeWrapper = (ShapeWrapper)obj;

		if (Objects.equals(_shape, shapeWrapper._shape)) {
			return true;
		}

		return false;
	}

	@Override
	public Shape getWrappedModel() {
		return _shape;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _shape.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _shape.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_shape.resetOriginalValues();
	}

	private final Shape _shape;
}