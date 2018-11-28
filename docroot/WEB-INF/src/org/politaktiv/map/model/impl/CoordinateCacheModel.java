/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.politaktiv.map.model.Coordinate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Coordinate in entity cache.
 *
 * @author Aleksandar Lukic
 * @see Coordinate
 * @generated
 */
@ProviderType
public class CoordinateCacheModel implements CacheModel<Coordinate>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CoordinateCacheModel)) {
			return false;
		}

		CoordinateCacheModel coordinateCacheModel = (CoordinateCacheModel)obj;

		if (coordinateId == coordinateCacheModel.coordinateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, coordinateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{coordinateId=");
		sb.append(coordinateId);
		sb.append(", shapeId=");
		sb.append(shapeId);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Coordinate toEntityModel() {
		CoordinateImpl coordinateImpl = new CoordinateImpl();

		coordinateImpl.setCoordinateId(coordinateId);
		coordinateImpl.setShapeId(shapeId);

		if (longitude == null) {
			coordinateImpl.setLongitude("");
		}
		else {
			coordinateImpl.setLongitude(longitude);
		}

		if (latitude == null) {
			coordinateImpl.setLatitude("");
		}
		else {
			coordinateImpl.setLatitude(latitude);
		}

		coordinateImpl.resetOriginalValues();

		return coordinateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		coordinateId = objectInput.readLong();

		shapeId = objectInput.readLong();
		longitude = objectInput.readUTF();
		latitude = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(coordinateId);

		objectOutput.writeLong(shapeId);

		if (longitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(longitude);
		}

		if (latitude == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(latitude);
		}
	}

	public long coordinateId;
	public long shapeId;
	public String longitude;
	public String latitude;
}