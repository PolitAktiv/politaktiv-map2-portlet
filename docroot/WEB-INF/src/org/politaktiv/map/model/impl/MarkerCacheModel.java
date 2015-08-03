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

import org.politaktiv.map.model.Marker;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Marker in entity cache.
 *
 * @author Paul Butenko
 * @see Marker
 * @generated
 */
public class MarkerCacheModel implements CacheModel<Marker>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{markerId=");
		sb.append(markerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Marker toEntityModel() {
		MarkerImpl markerImpl = new MarkerImpl();

		markerImpl.setMarkerId(markerId);
		markerImpl.setGroupId(groupId);
		markerImpl.setCompanyId(companyId);
		markerImpl.setUserId(userId);

		if (userName == null) {
			markerImpl.setUserName(StringPool.BLANK);
		}
		else {
			markerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			markerImpl.setCreateDate(null);
		}
		else {
			markerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			markerImpl.setModifiedDate(null);
		}
		else {
			markerImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			markerImpl.setTitle(StringPool.BLANK);
		}
		else {
			markerImpl.setTitle(title);
		}

		if (content == null) {
			markerImpl.setContent(StringPool.BLANK);
		}
		else {
			markerImpl.setContent(content);
		}

		if (longitude == null) {
			markerImpl.setLongitude(StringPool.BLANK);
		}
		else {
			markerImpl.setLongitude(longitude);
		}

		if (latitude == null) {
			markerImpl.setLatitude(StringPool.BLANK);
		}
		else {
			markerImpl.setLatitude(latitude);
		}

		markerImpl.resetOriginalValues();

		return markerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		markerId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
		longitude = objectInput.readUTF();
		latitude = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(markerId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (longitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longitude);
		}

		if (latitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(latitude);
		}
	}

	public long markerId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String content;
	public String longitude;
	public String latitude;
}