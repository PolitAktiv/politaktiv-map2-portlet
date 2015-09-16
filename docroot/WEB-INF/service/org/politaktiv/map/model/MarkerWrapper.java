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
 * This class is a wrapper for {@link Marker}.
 * </p>
 *
 * @author Paul Butenko
 * @see Marker
 * @generated
 */
public class MarkerWrapper implements Marker, ModelWrapper<Marker> {
	public MarkerWrapper(Marker marker) {
		_marker = marker;
	}

	@Override
	public Class<?> getModelClass() {
		return Marker.class;
	}

	@Override
	public String getModelClassName() {
		return Marker.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("markerId", getMarkerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("longitude", getLongitude());
		attributes.put("latitude", getLatitude());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long markerId = (Long)attributes.get("markerId");

		if (markerId != null) {
			setMarkerId(markerId);
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

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
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
	* Returns the primary key of this marker.
	*
	* @return the primary key of this marker
	*/
	@Override
	public long getPrimaryKey() {
		return _marker.getPrimaryKey();
	}

	/**
	* Sets the primary key of this marker.
	*
	* @param primaryKey the primary key of this marker
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_marker.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the marker ID of this marker.
	*
	* @return the marker ID of this marker
	*/
	@Override
	public long getMarkerId() {
		return _marker.getMarkerId();
	}

	/**
	* Sets the marker ID of this marker.
	*
	* @param markerId the marker ID of this marker
	*/
	@Override
	public void setMarkerId(long markerId) {
		_marker.setMarkerId(markerId);
	}

	/**
	* Returns the group ID of this marker.
	*
	* @return the group ID of this marker
	*/
	@Override
	public long getGroupId() {
		return _marker.getGroupId();
	}

	/**
	* Sets the group ID of this marker.
	*
	* @param groupId the group ID of this marker
	*/
	@Override
	public void setGroupId(long groupId) {
		_marker.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this marker.
	*
	* @return the company ID of this marker
	*/
	@Override
	public long getCompanyId() {
		return _marker.getCompanyId();
	}

	/**
	* Sets the company ID of this marker.
	*
	* @param companyId the company ID of this marker
	*/
	@Override
	public void setCompanyId(long companyId) {
		_marker.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this marker.
	*
	* @return the user ID of this marker
	*/
	@Override
	public long getUserId() {
		return _marker.getUserId();
	}

	/**
	* Sets the user ID of this marker.
	*
	* @param userId the user ID of this marker
	*/
	@Override
	public void setUserId(long userId) {
		_marker.setUserId(userId);
	}

	/**
	* Returns the user uuid of this marker.
	*
	* @return the user uuid of this marker
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _marker.getUserUuid();
	}

	/**
	* Sets the user uuid of this marker.
	*
	* @param userUuid the user uuid of this marker
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_marker.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this marker.
	*
	* @return the user name of this marker
	*/
	@Override
	public java.lang.String getUserName() {
		return _marker.getUserName();
	}

	/**
	* Sets the user name of this marker.
	*
	* @param userName the user name of this marker
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_marker.setUserName(userName);
	}

	/**
	* Returns the create date of this marker.
	*
	* @return the create date of this marker
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _marker.getCreateDate();
	}

	/**
	* Sets the create date of this marker.
	*
	* @param createDate the create date of this marker
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_marker.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this marker.
	*
	* @return the modified date of this marker
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _marker.getModifiedDate();
	}

	/**
	* Sets the modified date of this marker.
	*
	* @param modifiedDate the modified date of this marker
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_marker.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this marker.
	*
	* @return the title of this marker
	*/
	@Override
	public java.lang.String getTitle() {
		return _marker.getTitle();
	}

	/**
	* Sets the title of this marker.
	*
	* @param title the title of this marker
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_marker.setTitle(title);
	}

	/**
	* Returns the content of this marker.
	*
	* @return the content of this marker
	*/
	@Override
	public java.lang.String getContent() {
		return _marker.getContent();
	}

	/**
	* Sets the content of this marker.
	*
	* @param content the content of this marker
	*/
	@Override
	public void setContent(java.lang.String content) {
		_marker.setContent(content);
	}

	/**
	* Returns the longitude of this marker.
	*
	* @return the longitude of this marker
	*/
	@Override
	public java.lang.String getLongitude() {
		return _marker.getLongitude();
	}

	/**
	* Sets the longitude of this marker.
	*
	* @param longitude the longitude of this marker
	*/
	@Override
	public void setLongitude(java.lang.String longitude) {
		_marker.setLongitude(longitude);
	}

	/**
	* Returns the latitude of this marker.
	*
	* @return the latitude of this marker
	*/
	@Override
	public java.lang.String getLatitude() {
		return _marker.getLatitude();
	}

	/**
	* Sets the latitude of this marker.
	*
	* @param latitude the latitude of this marker
	*/
	@Override
	public void setLatitude(java.lang.String latitude) {
		_marker.setLatitude(latitude);
	}

	@Override
	public boolean isNew() {
		return _marker.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_marker.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _marker.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_marker.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _marker.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _marker.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_marker.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _marker.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_marker.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_marker.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_marker.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MarkerWrapper((Marker)_marker.clone());
	}

	@Override
	public int compareTo(org.politaktiv.map.model.Marker marker) {
		return _marker.compareTo(marker);
	}

	@Override
	public int hashCode() {
		return _marker.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.politaktiv.map.model.Marker> toCacheModel() {
		return _marker.toCacheModel();
	}

	@Override
	public org.politaktiv.map.model.Marker toEscapedModel() {
		return new MarkerWrapper(_marker.toEscapedModel());
	}

	@Override
	public org.politaktiv.map.model.Marker toUnescapedModel() {
		return new MarkerWrapper(_marker.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _marker.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _marker.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_marker.persist();
	}

	@Override
	public boolean isUpdatableByCurrentUser() {
		return _marker.isUpdatableByCurrentUser();
	}

	@Override
	public void setUpdatableByCurrentUser(boolean updatableByCurrentUser) {
		_marker.setUpdatableByCurrentUser(updatableByCurrentUser);
	}

	@Override
	public void validate() throws javax.portlet.ValidatorException {
		_marker.validate();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MarkerWrapper)) {
			return false;
		}

		MarkerWrapper markerWrapper = (MarkerWrapper)obj;

		if (Validator.equals(_marker, markerWrapper._marker)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Marker getWrappedMarker() {
		return _marker;
	}

	@Override
	public Marker getWrappedModel() {
		return _marker;
	}

	@Override
	public void resetOriginalValues() {
		_marker.resetOriginalValues();
	}

	private Marker _marker;
}