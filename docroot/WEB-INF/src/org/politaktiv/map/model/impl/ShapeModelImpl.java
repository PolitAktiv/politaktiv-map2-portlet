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

import org.politaktiv.map.model.Shape;
import org.politaktiv.map.model.ShapeModel;
import org.politaktiv.map.model.ShapeSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Shape service. Represents a row in the &quot;politaktivmaptwo_Shape&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.politaktiv.map.model.ShapeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShapeImpl}.
 * </p>
 *
 * @author Paul Butenko
 * @see ShapeImpl
 * @see org.politaktiv.map.model.Shape
 * @see org.politaktiv.map.model.ShapeModel
 * @generated
 */
@JSON(strict = true)
public class ShapeModelImpl extends BaseModelImpl<Shape> implements ShapeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a shape model instance should use the {@link org.politaktiv.map.model.Shape} interface instead.
	 */
	public static final String TABLE_NAME = "politaktivmaptwo_Shape";
	public static final Object[][] TABLE_COLUMNS = {
			{ "shapeId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "abstractDescription", Types.VARCHAR },
			{ "image", Types.CLOB },
			{ "shapeType", Types.VARCHAR },
			{ "radius", Types.BIGINT },
			{ "layer", Types.VARCHAR },
			{ "portletInstance", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table politaktivmaptwo_Shape (shapeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,abstractDescription VARCHAR(1024) null,image TEXT null,shapeType VARCHAR(75) null,radius LONG,layer VARCHAR(75) null,portletInstance VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table politaktivmaptwo_Shape";
	public static final String ORDER_BY_JPQL = " ORDER BY shape.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY politaktivmaptwo_Shape.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.politaktiv.map.model.Shape"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.politaktiv.map.model.Shape"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.politaktiv.map.model.Shape"),
			true);
	public static long LAYER_COLUMN_BITMASK = 1L;
	public static long PORTLETINSTANCE_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;
	public static long CREATEDATE_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Shape toModel(ShapeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Shape model = new ShapeImpl();

		model.setShapeId(soapModel.getShapeId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTitle(soapModel.getTitle());
		model.setAbstractDescription(soapModel.getAbstractDescription());
		model.setImage(soapModel.getImage());
		model.setShapeType(soapModel.getShapeType());
		model.setRadius(soapModel.getRadius());
		model.setLayer(soapModel.getLayer());
		model.setPortletInstance(soapModel.getPortletInstance());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Shape> toModels(ShapeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Shape> models = new ArrayList<Shape>(soapModels.length);

		for (ShapeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.politaktiv.map.model.Shape"));

	public ShapeModelImpl() {
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
		attributes.put("image", getImage());
		attributes.put("shapeType", getShapeType());
		attributes.put("radius", getRadius());
		attributes.put("layer", getLayer());
		attributes.put("portletInstance", getPortletInstance());

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

		String image = (String)attributes.get("image");

		if (image != null) {
			setImage(image);
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

		String portletInstance = (String)attributes.get("portletInstance");

		if (portletInstance != null) {
			setPortletInstance(portletInstance);
		}
	}

	@JSON
	@Override
	public long getShapeId() {
		return _shapeId;
	}

	@Override
	public void setShapeId(long shapeId) {
		_shapeId = shapeId;
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
	public String getAbstractDescription() {
		if (_abstractDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _abstractDescription;
		}
	}

	@Override
	public void setAbstractDescription(String abstractDescription) {
		_abstractDescription = abstractDescription;
	}

	@JSON
	@Override
	public String getImage() {
		if (_image == null) {
			return StringPool.BLANK;
		}
		else {
			return _image;
		}
	}

	@Override
	public void setImage(String image) {
		_image = image;
	}

	@JSON
	@Override
	public String getShapeType() {
		if (_shapeType == null) {
			return StringPool.BLANK;
		}
		else {
			return _shapeType;
		}
	}

	@Override
	public void setShapeType(String shapeType) {
		_shapeType = shapeType;
	}

	@JSON
	@Override
	public long getRadius() {
		return _radius;
	}

	@Override
	public void setRadius(long radius) {
		_radius = radius;
	}

	@JSON
	@Override
	public String getLayer() {
		if (_layer == null) {
			return StringPool.BLANK;
		}
		else {
			return _layer;
		}
	}

	@Override
	public void setLayer(String layer) {
		_columnBitmask |= LAYER_COLUMN_BITMASK;

		if (_originalLayer == null) {
			_originalLayer = _layer;
		}

		_layer = layer;
	}

	public String getOriginalLayer() {
		return GetterUtil.getString(_originalLayer);
	}

	@JSON
	@Override
	public String getPortletInstance() {
		if (_portletInstance == null) {
			return StringPool.BLANK;
		}
		else {
			return _portletInstance;
		}
	}

	@Override
	public void setPortletInstance(String portletInstance) {
		_columnBitmask |= PORTLETINSTANCE_COLUMN_BITMASK;

		if (_originalPortletInstance == null) {
			_originalPortletInstance = _portletInstance;
		}

		_portletInstance = portletInstance;
	}

	public String getOriginalPortletInstance() {
		return GetterUtil.getString(_originalPortletInstance);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Shape.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Shape toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Shape)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ShapeImpl shapeImpl = new ShapeImpl();

		shapeImpl.setShapeId(getShapeId());
		shapeImpl.setGroupId(getGroupId());
		shapeImpl.setCompanyId(getCompanyId());
		shapeImpl.setUserId(getUserId());
		shapeImpl.setUserName(getUserName());
		shapeImpl.setCreateDate(getCreateDate());
		shapeImpl.setModifiedDate(getModifiedDate());
		shapeImpl.setTitle(getTitle());
		shapeImpl.setAbstractDescription(getAbstractDescription());
		shapeImpl.setImage(getImage());
		shapeImpl.setShapeType(getShapeType());
		shapeImpl.setRadius(getRadius());
		shapeImpl.setLayer(getLayer());
		shapeImpl.setPortletInstance(getPortletInstance());

		shapeImpl.resetOriginalValues();

		return shapeImpl;
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

		if (!(obj instanceof Shape)) {
			return false;
		}

		Shape shape = (Shape)obj;

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
	public void resetOriginalValues() {
		ShapeModelImpl shapeModelImpl = this;

		shapeModelImpl._originalUserId = shapeModelImpl._userId;

		shapeModelImpl._setOriginalUserId = false;

		shapeModelImpl._originalLayer = shapeModelImpl._layer;

		shapeModelImpl._originalPortletInstance = shapeModelImpl._portletInstance;

		shapeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Shape> toCacheModel() {
		ShapeCacheModel shapeCacheModel = new ShapeCacheModel();

		shapeCacheModel.shapeId = getShapeId();

		shapeCacheModel.groupId = getGroupId();

		shapeCacheModel.companyId = getCompanyId();

		shapeCacheModel.userId = getUserId();

		shapeCacheModel.userName = getUserName();

		String userName = shapeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			shapeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			shapeCacheModel.createDate = createDate.getTime();
		}
		else {
			shapeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			shapeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			shapeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		shapeCacheModel.title = getTitle();

		String title = shapeCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			shapeCacheModel.title = null;
		}

		shapeCacheModel.abstractDescription = getAbstractDescription();

		String abstractDescription = shapeCacheModel.abstractDescription;

		if ((abstractDescription != null) &&
				(abstractDescription.length() == 0)) {
			shapeCacheModel.abstractDescription = null;
		}

		shapeCacheModel.image = getImage();

		String image = shapeCacheModel.image;

		if ((image != null) && (image.length() == 0)) {
			shapeCacheModel.image = null;
		}

		shapeCacheModel.shapeType = getShapeType();

		String shapeType = shapeCacheModel.shapeType;

		if ((shapeType != null) && (shapeType.length() == 0)) {
			shapeCacheModel.shapeType = null;
		}

		shapeCacheModel.radius = getRadius();

		shapeCacheModel.layer = getLayer();

		String layer = shapeCacheModel.layer;

		if ((layer != null) && (layer.length() == 0)) {
			shapeCacheModel.layer = null;
		}

		shapeCacheModel.portletInstance = getPortletInstance();

		String portletInstance = shapeCacheModel.portletInstance;

		if ((portletInstance != null) && (portletInstance.length() == 0)) {
			shapeCacheModel.portletInstance = null;
		}

		return shapeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

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
		sb.append(", image=");
		sb.append(getImage());
		sb.append(", shapeType=");
		sb.append(getShapeType());
		sb.append(", radius=");
		sb.append(getRadius());
		sb.append(", layer=");
		sb.append(getLayer());
		sb.append(", portletInstance=");
		sb.append(getPortletInstance());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

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
			"<column><column-name>image</column-name><column-value><![CDATA[");
		sb.append(getImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shapeType</column-name><column-value><![CDATA[");
		sb.append(getShapeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>radius</column-name><column-value><![CDATA[");
		sb.append(getRadius());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layer</column-name><column-value><![CDATA[");
		sb.append(getLayer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletInstance</column-name><column-value><![CDATA[");
		sb.append(getPortletInstance());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Shape.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Shape.class };
	private long _shapeId;
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
	private String _abstractDescription;
	private String _image;
	private String _shapeType;
	private long _radius;
	private String _layer;
	private String _originalLayer;
	private String _portletInstance;
	private String _originalPortletInstance;
	private long _columnBitmask;
	private Shape _escapedModel;
}