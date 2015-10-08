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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.politaktiv.map.service.ClpSerializer;
import org.politaktiv.map.service.ShapeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Paul Butenko
 */
public class ShapeClp extends BaseModelImpl<Shape> implements Shape {
	public ShapeClp() {
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
	public long getPrimaryKey() {
		return _shapeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setShapeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _shapeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
	}

	@Override
	public long getShapeId() {
		return _shapeId;
	}

	@Override
	public void setShapeId(long shapeId) {
		_shapeId = shapeId;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setShapeId", long.class);

				method.invoke(_shapeRemoteModel, shapeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_shapeRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_shapeRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_shapeRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_shapeRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_shapeRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_shapeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_shapeRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAbstractDescription() {
		return _abstractDescription;
	}

	@Override
	public void setAbstractDescription(String abstractDescription) {
		_abstractDescription = abstractDescription;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setAbstractDescription",
						String.class);

				method.invoke(_shapeRemoteModel, abstractDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_shapeRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShapeType() {
		return _shapeType;
	}

	@Override
	public void setShapeType(String shapeType) {
		_shapeType = shapeType;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setShapeType", String.class);

				method.invoke(_shapeRemoteModel, shapeType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRadius() {
		return _radius;
	}

	@Override
	public void setRadius(long radius) {
		_radius = radius;

		if (_shapeRemoteModel != null) {
			try {
				Class<?> clazz = _shapeRemoteModel.getClass();

				Method method = clazz.getMethod("setRadius", long.class);

				method.invoke(_shapeRemoteModel, radius);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Coordinate> getCoordinates() {
		try {
			String methodName = "getCoordinates";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<org.politaktiv.map.model.Coordinate> returnObj = (java.util.List<org.politaktiv.map.model.Coordinate>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setUpdatableByCurrentUser(boolean updatableByCurrentUser) {
		try {
			String methodName = "setUpdatableByCurrentUser";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { updatableByCurrentUser };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isUpdatableByCurrentUser() {
		try {
			String methodName = "isUpdatableByCurrentUser";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void validate(
		java.util.List<java.util.List<java.lang.String>> points) {
		try {
			String methodName = "validate";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.List.class };

			Object[] parameterValues = new Object[] { points };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getShapeRemoteModel() {
		return _shapeRemoteModel;
	}

	public void setShapeRemoteModel(BaseModel<?> shapeRemoteModel) {
		_shapeRemoteModel = shapeRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _shapeRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_shapeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ShapeLocalServiceUtil.addShape(this);
		}
		else {
			ShapeLocalServiceUtil.updateShape(this);
		}
	}

	@Override
	public Shape toEscapedModel() {
		return (Shape)ProxyUtil.newProxyInstance(Shape.class.getClassLoader(),
			new Class[] { Shape.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ShapeClp clone = new ShapeClp();

		clone.setShapeId(getShapeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setAbstractDescription(getAbstractDescription());
		clone.setUrl(getUrl());
		clone.setShapeType(getShapeType());
		clone.setRadius(getRadius());

		return clone;
	}

	@Override
	public int compareTo(Shape shape) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), shape.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShapeClp)) {
			return false;
		}

		ShapeClp shape = (ShapeClp)obj;

		long primaryKey = shape.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{shapeId=");
		sb.append(getShapeId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", abstractDescription=");
		sb.append(getAbstractDescription());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", shapeType=");
		sb.append(getShapeType());
		sb.append(", radius=");
		sb.append(getRadius());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.model.Shape");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>shapeId</column-name><column-value><![CDATA[");
		sb.append(getShapeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>abstractDescription</column-name><column-value><![CDATA[");
		sb.append(getAbstractDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shapeType</column-name><column-value><![CDATA[");
		sb.append(getShapeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>radius</column-name><column-value><![CDATA[");
		sb.append(getRadius());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _shapeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _abstractDescription;
	private String _url;
	private String _shapeType;
	private long _radius;
	private BaseModel<?> _shapeRemoteModel;
}