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
// TODO: review mje 18.09.: Wrong copyright.

package org.politaktiv.map.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.politaktiv.map.model.Marker;
import org.politaktiv.map.model.MarkerModel;
import org.politaktiv.map.model.MarkerSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Marker service. Represents a row in the &quot;politaktivmaptwo_Marker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.politaktiv.map.model.MarkerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MarkerImpl}.
 * </p>
 *
 * @author Paul Butenko
 * @see MarkerImpl
 * @see org.politaktiv.map.model.Marker
 * @see org.politaktiv.map.model.MarkerModel
 * @generated
 */
@JSON(strict = true)
public class MarkerModelImpl extends BaseModelImpl<Marker>
	implements MarkerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a marker model instance should use the {@link org.politaktiv.map.model.Marker} interface instead.
	 */
	public static final String TABLE_NAME = "politaktivmaptwo_Marker";
	public static final Object[][] TABLE_COLUMNS = {
			{ "markerId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "content", Types.VARCHAR },
			{ "longitude", Types.VARCHAR },
			{ "latitude", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table politaktivmaptwo_Marker (markerId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,content VARCHAR(1024) null,longitude VARCHAR(11) null,latitude VARCHAR(11) null)";
	public static final String TABLE_SQL_DROP = "drop table politaktivmaptwo_Marker";
	public static final String ORDER_BY_JPQL = " ORDER BY marker.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY politaktivmaptwo_Marker.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.politaktiv.map.model.Marker"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.politaktiv.map.model.Marker"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.politaktiv.map.model.Marker"),
			true);
	public static long USERID_COLUMN_BITMASK = 1L;
	public static long CREATEDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Marker toModel(MarkerSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Marker model = new MarkerImpl();

		model.setMarkerId(soapModel.getMarkerId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTitle(soapModel.getTitle());
		model.setContent(soapModel.getContent());
		model.setLongitude(soapModel.getLongitude());
		model.setLatitude(soapModel.getLatitude());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Marker> toModels(MarkerSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Marker> models = new ArrayList<Marker>(soapModels.length);

		for (MarkerSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.politaktiv.map.model.Marker"));

	public MarkerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _markerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMarkerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _markerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@JSON
	@Override
	public long getMarkerId() {
		return _markerId;
	}

	@Override
	public void setMarkerId(long markerId) {
		_markerId = markerId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@JSON
	@Override
	public String getLongitude() {
		if (_longitude == null) {
			return StringPool.BLANK;
		}
		else {
			return _longitude;
		}
	}

	@Override
	public void setLongitude(String longitude) {
		_longitude = longitude;
	}

	@JSON
	@Override
	public String getLatitude() {
		if (_latitude == null) {
			return StringPool.BLANK;
		}
		else {
			return _latitude;
		}
	}

	@Override
	public void setLatitude(String latitude) {
		_latitude = latitude;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Marker.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Marker toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Marker)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MarkerImpl markerImpl = new MarkerImpl();

		markerImpl.setMarkerId(getMarkerId());
		markerImpl.setGroupId(getGroupId());
		markerImpl.setCompanyId(getCompanyId());
		markerImpl.setUserId(getUserId());
		markerImpl.setUserName(getUserName());
		markerImpl.setCreateDate(getCreateDate());
		markerImpl.setModifiedDate(getModifiedDate());
		markerImpl.setTitle(getTitle());
		markerImpl.setContent(getContent());
		markerImpl.setLongitude(getLongitude());
		markerImpl.setLatitude(getLatitude());

		markerImpl.resetOriginalValues();

		return markerImpl;
	}

	@Override
	public int compareTo(Marker marker) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), marker.getCreateDate());

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

		if (!(obj instanceof Marker)) {
			return false;
		}

		Marker marker = (Marker)obj;

		long primaryKey = marker.getPrimaryKey();

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
	public void resetOriginalValues() {
		MarkerModelImpl markerModelImpl = this;

		markerModelImpl._originalUserId = markerModelImpl._userId;

		markerModelImpl._setOriginalUserId = false;

		markerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Marker> toCacheModel() {
		MarkerCacheModel markerCacheModel = new MarkerCacheModel();

		markerCacheModel.markerId = getMarkerId();

		markerCacheModel.groupId = getGroupId();

		markerCacheModel.companyId = getCompanyId();

		markerCacheModel.userId = getUserId();

		markerCacheModel.userName = getUserName();

		String userName = markerCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			markerCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			markerCacheModel.createDate = createDate.getTime();
		}
		else {
			markerCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			markerCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			markerCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		markerCacheModel.title = getTitle();

		String title = markerCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			markerCacheModel.title = null;
		}

		markerCacheModel.content = getContent();

		String content = markerCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			markerCacheModel.content = null;
		}

		markerCacheModel.longitude = getLongitude();

		String longitude = markerCacheModel.longitude;

		if ((longitude != null) && (longitude.length() == 0)) {
			markerCacheModel.longitude = null;
		}

		markerCacheModel.latitude = getLatitude();

		String latitude = markerCacheModel.latitude;

		if ((latitude != null) && (latitude.length() == 0)) {
			markerCacheModel.latitude = null;
		}

		return markerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{markerId=");
		sb.append(getMarkerId());
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
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.politaktiv.map.model.Marker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>markerId</column-name><column-value><![CDATA[");
		sb.append(getMarkerId());
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
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
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

	private static ClassLoader _classLoader = Marker.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Marker.class };
	private long _markerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _content;
	private String _longitude;
	private String _latitude;
	private long _columnBitmask;
	private Marker _escapedModel;
}