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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.politaktiv.map.model.Layer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Layer in entity cache.
 *
 * @author Paul Butenko
 * @see Layer
 * @generated
 */
public class LayerCacheModel implements CacheModel<Layer>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{layerId=");
		sb.append(layerId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", label=");
		sb.append(label);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", portletInstance=");
		sb.append(portletInstance);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Layer toEntityModel() {
		LayerImpl layerImpl = new LayerImpl();

		layerImpl.setLayerId(layerId);

		if (createDate == Long.MIN_VALUE) {
			layerImpl.setCreateDate(null);
		}
		else {
			layerImpl.setCreateDate(new Date(createDate));
		}

		if (label == null) {
			layerImpl.setLabel(StringPool.BLANK);
		}
		else {
			layerImpl.setLabel(label);
		}

		layerImpl.setUserId(userId);

		if (portletInstance == null) {
			layerImpl.setPortletInstance(StringPool.BLANK);
		}
		else {
			layerImpl.setPortletInstance(portletInstance);
		}

		layerImpl.resetOriginalValues();

		return layerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		layerId = objectInput.readLong();
		createDate = objectInput.readLong();
		label = objectInput.readUTF();
		userId = objectInput.readLong();
		portletInstance = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(layerId);
		objectOutput.writeLong(createDate);

		if (label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(label);
		}

		objectOutput.writeLong(userId);

		if (portletInstance == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletInstance);
		}
	}

	public long layerId;
	public long createDate;
	public String label;
	public long userId;
	public String portletInstance;
}