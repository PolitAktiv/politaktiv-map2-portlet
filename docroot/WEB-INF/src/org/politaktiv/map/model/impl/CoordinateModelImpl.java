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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.politaktiv.map.model.Coordinate;
import org.politaktiv.map.model.CoordinateModel;
import org.politaktiv.map.model.CoordinateSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Coordinate service. Represents a row in the &quot;politaktivmaptwo_Coordinate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.politaktiv.map.model.CoordinateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CoordinateImpl}.
 * </p>
 *
 * @author Paul Butenko
 * @see CoordinateImpl
 * @see org.politaktiv.map.model.Coordinate
 * @see org.politaktiv.map.model.CoordinateModel
 * @generated
 */
@JSON(strict = true)
public class CoordinateModelImpl extends BaseModelImpl<Coordinate>
	implements CoordinateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a coordinate model instance should use the {@link org.politaktiv.map.model.Coordinate} interface instead.
	 */
	public static final String TABLE_NAME = "politaktivmaptwo_Coordinate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "coordinateId", Types.BIGINT },
			{ "shapeId", Types.BIGINT },
			{ "longitude", Types.VARCHAR },
			{ "latitude", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table politaktivmaptwo_Coordinate (coordinateId LONG not null primary key,shapeId LONG,longitude VARCHAR(11) null,latitude VARCHAR(11) null)";
	public static final String TABLE_SQL_DROP = "drop table politaktivmaptwo_Coordinate";
	public static final String ORDER_BY_JPQL = " ORDER BY coordinate.coordinateId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY politaktivmaptwo_Coordinate.coordinateId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.politaktiv.map.model.Coordinate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.politaktiv.map.model.Coordinate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.politaktiv.map.model.Coordinate"),
			true);
	public static long SHAPEID_COLUMN_BITMASK = 1L;
	public static long COORDINATEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Coordinate toModel(CoordinateSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Coordinate model = new CoordinateImpl();

		model.setCoordinateId(soapModel.getCoordinateId());
		model.setShapeId(soapModel.getShapeId());
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
	public static List<Coordinate> toModels(CoordinateSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Coordinate> models = new ArrayList<Coordinate>(soapModels.length);

		for (CoordinateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.politaktiv.map.model.Coordinate"));

	public CoordinateModelImpl() {
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
	public Class<?> getModelClass() {
		return Coordinate.class;
	}

	@Override
	public String getModelClassName() {
		return Coordinate.class.getName();
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

	@JSON
	@Override
	public long getCoordinateId() {
		return _coordinateId;
	}

	@Override
	public void setCoordinateId(long coordinateId) {
		_coordinateId = coordinateId;
	}

	@JSON
	@Override
	public long getShapeId() {
		return _shapeId;
	}

	@Override
	public void setShapeId(long shapeId) {
		_columnBitmask |= SHAPEID_COLUMN_BITMASK;

		if (!_setOriginalShapeId) {
			_setOriginalShapeId = true;

			_originalShapeId = _shapeId;
		}

		_shapeId = shapeId;
	}

	public long getOriginalShapeId() {
		return _originalShapeId;
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
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Coordinate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Coordinate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Coordinate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CoordinateImpl coordinateImpl = new CoordinateImpl();

		coordinateImpl.setCoordinateId(getCoordinateId());
		coordinateImpl.setShapeId(getShapeId());
		coordinateImpl.setLongitude(getLongitude());
		coordinateImpl.setLatitude(getLatitude());

		coordinateImpl.resetOriginalValues();

		return coordinateImpl;
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

		if (!(obj instanceof Coordinate)) {
			return false;
		}

		Coordinate coordinate = (Coordinate)obj;

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
	public void resetOriginalValues() {
		CoordinateModelImpl coordinateModelImpl = this;

		coordinateModelImpl._originalShapeId = coordinateModelImpl._shapeId;

		coordinateModelImpl._setOriginalShapeId = false;

		coordinateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Coordinate> toCacheModel() {
		CoordinateCacheModel coordinateCacheModel = new CoordinateCacheModel();

		coordinateCacheModel.coordinateId = getCoordinateId();

		coordinateCacheModel.shapeId = getShapeId();

		coordinateCacheModel.longitude = getLongitude();

		String longitude = coordinateCacheModel.longitude;

		if ((longitude != null) && (longitude.length() == 0)) {
			coordinateCacheModel.longitude = null;
		}

		coordinateCacheModel.latitude = getLatitude();

		String latitude = coordinateCacheModel.latitude;

		if ((latitude != null) && (latitude.length() == 0)) {
			coordinateCacheModel.latitude = null;
		}

		return coordinateCacheModel;
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

	private static ClassLoader _classLoader = Coordinate.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Coordinate.class
		};
	private long _coordinateId;
	private long _shapeId;
	private long _originalShapeId;
	private boolean _setOriginalShapeId;
	private String _longitude;
	private String _latitude;
	private long _columnBitmask;
	private Coordinate _escapedModel;
}