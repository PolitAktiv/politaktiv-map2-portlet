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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Shape service. Represents a row in the &quot;politaktivmaptwo_Shape&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.politaktiv.map.model.impl.ShapeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.politaktiv.map.model.impl.ShapeImpl}.
 * </p>
 *
 * @author Paul Butenko
 * @see Shape
 * @see org.politaktiv.map.model.impl.ShapeImpl
 * @see org.politaktiv.map.model.impl.ShapeModelImpl
 * @generated
 */
public interface ShapeModel extends BaseModel<Shape>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a shape model instance should use the {@link Shape} interface instead.
	 */

	/**
	 * Returns the primary key of this shape.
	 *
	 * @return the primary key of this shape
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this shape.
	 *
	 * @param primaryKey the primary key of this shape
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the shape ID of this shape.
	 *
	 * @return the shape ID of this shape
	 */
	public long getShapeId();

	/**
	 * Sets the shape ID of this shape.
	 *
	 * @param shapeId the shape ID of this shape
	 */
	public void setShapeId(long shapeId);

	/**
	 * Returns the group ID of this shape.
	 *
	 * @return the group ID of this shape
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this shape.
	 *
	 * @param groupId the group ID of this shape
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this shape.
	 *
	 * @return the company ID of this shape
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this shape.
	 *
	 * @param companyId the company ID of this shape
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this shape.
	 *
	 * @return the user ID of this shape
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this shape.
	 *
	 * @param userId the user ID of this shape
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this shape.
	 *
	 * @return the user uuid of this shape
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this shape.
	 *
	 * @param userUuid the user uuid of this shape
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this shape.
	 *
	 * @return the user name of this shape
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this shape.
	 *
	 * @param userName the user name of this shape
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this shape.
	 *
	 * @return the create date of this shape
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this shape.
	 *
	 * @param createDate the create date of this shape
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this shape.
	 *
	 * @return the modified date of this shape
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this shape.
	 *
	 * @param modifiedDate the modified date of this shape
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this shape.
	 *
	 * @return the title of this shape
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this shape.
	 *
	 * @param title the title of this shape
	 */
	public void setTitle(String title);

	/**
	 * Returns the abstract description of this shape.
	 *
	 * @return the abstract description of this shape
	 */
	@AutoEscape
	public String getAbstractDescription();

	/**
	 * Sets the abstract description of this shape.
	 *
	 * @param abstractDescription the abstract description of this shape
	 */
	public void setAbstractDescription(String abstractDescription);

	/**
	 * Returns the url of this shape.
	 *
	 * @return the url of this shape
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this shape.
	 *
	 * @param url the url of this shape
	 */
	public void setUrl(String url);

	/**
	 * Returns the shape type of this shape.
	 *
	 * @return the shape type of this shape
	 */
	@AutoEscape
	public String getShapeType();

	/**
	 * Sets the shape type of this shape.
	 *
	 * @param shapeType the shape type of this shape
	 */
	public void setShapeType(String shapeType);

	/**
	 * Returns the radius of this shape.
	 *
	 * @return the radius of this shape
	 */
	public long getRadius();

	/**
	 * Sets the radius of this shape.
	 *
	 * @param radius the radius of this shape
	 */
	public void setRadius(long radius);

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
	public int compareTo(Shape shape);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Shape> toCacheModel();

	@Override
	public Shape toEscapedModel();

	@Override
	public Shape toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}