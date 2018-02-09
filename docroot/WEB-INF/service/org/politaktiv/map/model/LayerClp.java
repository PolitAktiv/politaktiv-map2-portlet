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
import org.politaktiv.map.service.LayerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Paul Butenko
 */
public class LayerClp extends BaseModelImpl<Layer> implements Layer {
	public LayerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Layer.class;
	}

	@Override
	public String getModelClassName() {
		return Layer.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _layerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLayerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _layerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("layerId", getLayerId());
		attributes.put("createDate", getCreateDate());
		attributes.put("label", getLabel());
		attributes.put("userId", getUserId());
		attributes.put("portletInstance", getPortletInstance());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long layerId = (Long)attributes.get("layerId");

		if (layerId != null) {
			setLayerId(layerId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String portletInstance = (String)attributes.get("portletInstance");

		if (portletInstance != null) {
			setPortletInstance(portletInstance);
		}
	}

	@Override
	public long getLayerId() {
		return _layerId;
	}

	@Override
	public void setLayerId(long layerId) {
		_layerId = layerId;

		if (_layerRemoteModel != null) {
			try {
				Class<?> clazz = _layerRemoteModel.getClass();

				Method method = clazz.getMethod("setLayerId", long.class);

				method.invoke(_layerRemoteModel, layerId);
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

		if (_layerRemoteModel != null) {
			try {
				Class<?> clazz = _layerRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_layerRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLabel() {
		return _label;
	}

	@Override
	public void setLabel(String label) {
		_label = label;

		if (_layerRemoteModel != null) {
			try {
				Class<?> clazz = _layerRemoteModel.getClass();

				Method method = clazz.getMethod("setLabel", String.class);

				method.invoke(_layerRemoteModel, label);
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

		if (_layerRemoteModel != null) {
			try {
				Class<?> clazz = _layerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_layerRemoteModel, userId);
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
	public String getPortletInstance() {
		return _portletInstance;
	}

	@Override
	public void setPortletInstance(String portletInstance) {
		_portletInstance = portletInstance;

		if (_layerRemoteModel != null) {
			try {
				Class<?> clazz = _layerRemoteModel.getClass();

				Method method = clazz.getMethod("setPortletInstance",
						String.class);

				method.invoke(_layerRemoteModel, portletInstance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLayerRemoteModel() {
		return _layerRemoteModel;
	}

	public void setLayerRemoteModel(BaseModel<?> layerRemoteModel) {
		_layerRemoteModel = layerRemoteModel;
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

		Class<?> remoteModelClass = _layerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_layerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LayerLocalServiceUtil.addLayer(this);
		}
		else {
			LayerLocalServiceUtil.updateLayer(this);
		}
	}

	@Override
	public Layer toEscapedModel() {
		return (Layer)ProxyUtil.newProxyInstance(Layer.class.getClassLoader(),
			new Class[] { Layer.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LayerClp clone = new LayerClp();

		clone.setLayerId(getLayerId());
		clone.setCreateDate(getCreateDate());
		clone.setLabel(getLabel());
		clone.setUserId(getUserId());
		clone.setPortletInstance(getPortletInstance());

		return clone;
	}

	@Override
	public int compareTo(Layer layer) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), layer.getCreateDate());

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

		if (!(obj instanceof LayerClp)) {
			return false;
		}

		LayerClp layer = (LayerClp)obj;

		long primaryKey = layer.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{layerId=");
		sb.append(getLayerId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", label=");
		sb.append(getLabel());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", portletInstance=");
		sb.append(getPortletInstance());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.model.Layer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>layerId</column-name><column-value><![CDATA[");
		sb.append(getLayerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>label</column-name><column-value><![CDATA[");
		sb.append(getLabel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletInstance</column-name><column-value><![CDATA[");
		sb.append(getPortletInstance());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _layerId;
	private Date _createDate;
	private String _label;
	private long _userId;
	private String _userUuid;
	private String _portletInstance;
	private BaseModel<?> _layerRemoteModel;
}