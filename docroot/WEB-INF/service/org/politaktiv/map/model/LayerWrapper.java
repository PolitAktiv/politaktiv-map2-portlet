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
 * This class is a wrapper for {@link Layer}.
 * </p>
 *
 * @author Paul Butenko
 * @see Layer
 * @generated
 */
public class LayerWrapper implements Layer, ModelWrapper<Layer> {
	public LayerWrapper(Layer layer) {
		_layer = layer;
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

	/**
	* Returns the primary key of this layer.
	*
	* @return the primary key of this layer
	*/
	@Override
	public long getPrimaryKey() {
		return _layer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this layer.
	*
	* @param primaryKey the primary key of this layer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_layer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the layer ID of this layer.
	*
	* @return the layer ID of this layer
	*/
	@Override
	public long getLayerId() {
		return _layer.getLayerId();
	}

	/**
	* Sets the layer ID of this layer.
	*
	* @param layerId the layer ID of this layer
	*/
	@Override
	public void setLayerId(long layerId) {
		_layer.setLayerId(layerId);
	}

	/**
	* Returns the create date of this layer.
	*
	* @return the create date of this layer
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _layer.getCreateDate();
	}

	/**
	* Sets the create date of this layer.
	*
	* @param createDate the create date of this layer
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_layer.setCreateDate(createDate);
	}

	/**
	* Returns the label of this layer.
	*
	* @return the label of this layer
	*/
	@Override
	public java.lang.String getLabel() {
		return _layer.getLabel();
	}

	/**
	* Sets the label of this layer.
	*
	* @param label the label of this layer
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_layer.setLabel(label);
	}

	/**
	* Returns the user ID of this layer.
	*
	* @return the user ID of this layer
	*/
	@Override
	public long getUserId() {
		return _layer.getUserId();
	}

	/**
	* Sets the user ID of this layer.
	*
	* @param userId the user ID of this layer
	*/
	@Override
	public void setUserId(long userId) {
		_layer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this layer.
	*
	* @return the user uuid of this layer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layer.getUserUuid();
	}

	/**
	* Sets the user uuid of this layer.
	*
	* @param userUuid the user uuid of this layer
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_layer.setUserUuid(userUuid);
	}

	/**
	* Returns the portlet instance of this layer.
	*
	* @return the portlet instance of this layer
	*/
	@Override
	public java.lang.String getPortletInstance() {
		return _layer.getPortletInstance();
	}

	/**
	* Sets the portlet instance of this layer.
	*
	* @param portletInstance the portlet instance of this layer
	*/
	@Override
	public void setPortletInstance(java.lang.String portletInstance) {
		_layer.setPortletInstance(portletInstance);
	}

	@Override
	public boolean isNew() {
		return _layer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_layer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _layer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_layer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _layer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _layer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_layer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _layer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_layer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_layer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_layer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LayerWrapper((Layer)_layer.clone());
	}

	@Override
	public int compareTo(org.politaktiv.map.model.Layer layer) {
		return _layer.compareTo(layer);
	}

	@Override
	public int hashCode() {
		return _layer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.politaktiv.map.model.Layer> toCacheModel() {
		return _layer.toCacheModel();
	}

	@Override
	public org.politaktiv.map.model.Layer toEscapedModel() {
		return new LayerWrapper(_layer.toEscapedModel());
	}

	@Override
	public org.politaktiv.map.model.Layer toUnescapedModel() {
		return new LayerWrapper(_layer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _layer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _layer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_layer.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LayerWrapper)) {
			return false;
		}

		LayerWrapper layerWrapper = (LayerWrapper)obj;

		if (Validator.equals(_layer, layerWrapper._layer)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Layer getWrappedLayer() {
		return _layer;
	}

	@Override
	public Layer getWrappedModel() {
		return _layer;
	}

	@Override
	public void resetOriginalValues() {
		_layer.resetOriginalValues();
	}

	private Layer _layer;
}