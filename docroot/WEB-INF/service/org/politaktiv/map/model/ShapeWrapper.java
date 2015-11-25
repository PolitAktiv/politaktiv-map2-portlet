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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Shape}.
 * </p>
 *
 * @author Paul Butenko
 * @see Shape
 * @generated
 */
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

	/**
	* Returns the primary key of this shape.
	*
	* @return the primary key of this shape
	*/
	@Override
	public long getPrimaryKey() {
		return _shape.getPrimaryKey();
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
	* Sets the shape ID of this shape.
	*
	* @param shapeId the shape ID of this shape
	*/
	@Override
	public void setShapeId(long shapeId) {
		_shape.setShapeId(shapeId);
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
	* Sets the group ID of this shape.
	*
	* @param groupId the group ID of this shape
	*/
	@Override
	public void setGroupId(long groupId) {
		_shape.setGroupId(groupId);
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
	* Returns the user ID of this shape.
	*
	* @return the user ID of this shape
	*/
	@Override
	public long getUserId() {
		return _shape.getUserId();
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
	* Returns the user uuid of this shape.
	*
	* @return the user uuid of this shape
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shape.getUserUuid();
	}

	/**
	* Sets the user uuid of this shape.
	*
	* @param userUuid the user uuid of this shape
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_shape.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this shape.
	*
	* @return the user name of this shape
	*/
	@Override
	public java.lang.String getUserName() {
		return _shape.getUserName();
	}

	/**
	* Sets the user name of this shape.
	*
	* @param userName the user name of this shape
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_shape.setUserName(userName);
	}

	/**
	* Returns the create date of this shape.
	*
	* @return the create date of this shape
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _shape.getCreateDate();
	}

	/**
	* Sets the create date of this shape.
	*
	* @param createDate the create date of this shape
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_shape.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this shape.
	*
	* @return the modified date of this shape
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _shape.getModifiedDate();
	}

	/**
	* Sets the modified date of this shape.
	*
	* @param modifiedDate the modified date of this shape
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_shape.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this shape.
	*
	* @return the title of this shape
	*/
	@Override
	public java.lang.String getTitle() {
		return _shape.getTitle();
	}

	/**
	* Sets the title of this shape.
	*
	* @param title the title of this shape
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_shape.setTitle(title);
	}

	/**
	* Returns the abstract description of this shape.
	*
	* @return the abstract description of this shape
	*/
	@Override
	public java.lang.String getAbstractDescription() {
		return _shape.getAbstractDescription();
	}

	/**
	* Sets the abstract description of this shape.
	*
	* @param abstractDescription the abstract description of this shape
	*/
	@Override
	public void setAbstractDescription(java.lang.String abstractDescription) {
		_shape.setAbstractDescription(abstractDescription);
	}

	/**
	* Returns the url of this shape.
	*
	* @return the url of this shape
	*/
	@Override
	public java.lang.String getUrl() {
		return _shape.getUrl();
	}

	/**
	* Sets the url of this shape.
	*
	* @param url the url of this shape
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_shape.setUrl(url);
	}

	/**
	* Returns the shape type of this shape.
	*
	* @return the shape type of this shape
	*/
	@Override
	public java.lang.String getShapeType() {
		return _shape.getShapeType();
	}

	/**
	* Sets the shape type of this shape.
	*
	* @param shapeType the shape type of this shape
	*/
	@Override
	public void setShapeType(java.lang.String shapeType) {
		_shape.setShapeType(shapeType);
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
	* Sets the radius of this shape.
	*
	* @param radius the radius of this shape
	*/
	@Override
	public void setRadius(long radius) {
		_shape.setRadius(radius);
	}

	/**
	* Returns the layer of this shape.
	*
	* @return the layer of this shape
	*/
	@Override
	public java.lang.String getLayer() {
		return _shape.getLayer();
	}

	/**
	* Sets the layer of this shape.
	*
	* @param layer the layer of this shape
	*/
	@Override
	public void setLayer(java.lang.String layer) {
		_shape.setLayer(layer);
	}

	@Override
	public boolean isNew() {
		return _shape.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_shape.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _shape.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_shape.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _shape.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _shape.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_shape.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shape.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_shape.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_shape.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shape.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ShapeWrapper((Shape)_shape.clone());
	}

	@Override
	public int compareTo(org.politaktiv.map.model.Shape shape) {
		return _shape.compareTo(shape);
	}

	@Override
	public int hashCode() {
		return _shape.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.politaktiv.map.model.Shape> toCacheModel() {
		return _shape.toCacheModel();
	}

	@Override
	public org.politaktiv.map.model.Shape toEscapedModel() {
		return new ShapeWrapper(_shape.toEscapedModel());
	}

	@Override
	public org.politaktiv.map.model.Shape toUnescapedModel() {
		return new ShapeWrapper(_shape.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _shape.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _shape.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_shape.persist();
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Coordinate> getCoordinates()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shape.getCoordinates();
	}

	@Override
	public void validate(
		java.util.List<java.util.List<java.lang.String>> points)
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
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

		if (Validator.equals(_shape, shapeWrapper._shape)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Shape getWrappedShape() {
		return _shape;
	}

	@Override
	public Shape getWrappedModel() {
		return _shape;
	}

	@Override
	public void resetOriginalValues() {
		_shape.resetOriginalValues();
	}

	private Shape _shape;
}