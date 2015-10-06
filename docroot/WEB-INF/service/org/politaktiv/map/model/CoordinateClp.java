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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.politaktiv.map.service.ClpSerializer;
import org.politaktiv.map.service.CoordinateLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Paul Butenko
 */
public class CoordinateClp extends BaseModelImpl<Coordinate>
	implements Coordinate {
	public CoordinateClp() {
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
	public long getPrimaryKey() {
		return _coordinateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCoordinateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _coordinateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
	public long getCoordinateId() {
		return _coordinateId;
	}

	@Override
	public void setCoordinateId(long coordinateId) {
		_coordinateId = coordinateId;

		if (_coordinateRemoteModel != null) {
			try {
				Class<?> clazz = _coordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setCoordinateId", long.class);

				method.invoke(_coordinateRemoteModel, coordinateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getShapeId() {
		return _shapeId;
	}

	@Override
	public void setShapeId(long shapeId) {
		_shapeId = shapeId;

		if (_coordinateRemoteModel != null) {
			try {
				Class<?> clazz = _coordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setShapeId", long.class);

				method.invoke(_coordinateRemoteModel, shapeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLongitude() {
		return _longitude;
	}

	@Override
	public void setLongitude(String longitude) {
		_longitude = longitude;

		if (_coordinateRemoteModel != null) {
			try {
				Class<?> clazz = _coordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", String.class);

				method.invoke(_coordinateRemoteModel, longitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLatitude() {
		return _latitude;
	}

	@Override
	public void setLatitude(String latitude) {
		_latitude = latitude;

		if (_coordinateRemoteModel != null) {
			try {
				Class<?> clazz = _coordinateRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", String.class);

				method.invoke(_coordinateRemoteModel, latitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void validate() {
		try {
			String methodName = "validate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getCoordinateRemoteModel() {
		return _coordinateRemoteModel;
	}

	public void setCoordinateRemoteModel(BaseModel<?> coordinateRemoteModel) {
		_coordinateRemoteModel = coordinateRemoteModel;
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

		Class<?> remoteModelClass = _coordinateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_coordinateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CoordinateLocalServiceUtil.addCoordinate(this);
		}
		else {
			CoordinateLocalServiceUtil.updateCoordinate(this);
		}
	}

	@Override
	public Coordinate toEscapedModel() {
		return (Coordinate)ProxyUtil.newProxyInstance(Coordinate.class.getClassLoader(),
			new Class[] { Coordinate.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CoordinateClp clone = new CoordinateClp();

		clone.setCoordinateId(getCoordinateId());
		clone.setShapeId(getShapeId());
		clone.setLongitude(getLongitude());
		clone.setLatitude(getLatitude());

		return clone;
	}

	@Override
	public int compareTo(Coordinate coordinate) {
		long primaryKey = coordinate.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CoordinateClp)) {
			return false;
		}

		CoordinateClp coordinate = (CoordinateClp)obj;

		long primaryKey = coordinate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{coordinateId=");
		sb.append(getCoordinateId());
		sb.append(", shapeId=");
		sb.append(getShapeId());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.model.Coordinate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>coordinateId</column-name><column-value><![CDATA[");
		sb.append(getCoordinateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shapeId</column-name><column-value><![CDATA[");
		sb.append(getShapeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _coordinateId;
	private long _shapeId;
	private String _longitude;
	private String _latitude;
	private BaseModel<?> _coordinateRemoteModel;
}