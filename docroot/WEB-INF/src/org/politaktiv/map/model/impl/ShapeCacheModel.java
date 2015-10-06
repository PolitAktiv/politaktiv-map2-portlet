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

import org.politaktiv.map.model.Shape;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Shape in entity cache.
 *
 * @author Paul Butenko
 * @see Shape
 * @generated
 */
public class ShapeCacheModel implements CacheModel<Shape>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{shapeId=");
		sb.append(shapeId);
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
		sb.append(", abstractDescription=");
		sb.append(abstractDescription);
		sb.append(", url=");
		sb.append(url);
		sb.append(", shapeType=");
		sb.append(shapeType);
		sb.append(", radius=");
		sb.append(radius);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Shape toEntityModel() {
		ShapeImpl shapeImpl = new ShapeImpl();

		shapeImpl.setShapeId(shapeId);
		shapeImpl.setGroupId(groupId);
		shapeImpl.setCompanyId(companyId);
		shapeImpl.setUserId(userId);

		if (userName == null) {
			shapeImpl.setUserName(StringPool.BLANK);
		}
		else {
			shapeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			shapeImpl.setCreateDate(null);
		}
		else {
			shapeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			shapeImpl.setModifiedDate(null);
		}
		else {
			shapeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			shapeImpl.setTitle(StringPool.BLANK);
		}
		else {
			shapeImpl.setTitle(title);
		}

		if (abstractDescription == null) {
			shapeImpl.setAbstractDescription(StringPool.BLANK);
		}
		else {
			shapeImpl.setAbstractDescription(abstractDescription);
		}

		if (url == null) {
			shapeImpl.setUrl(StringPool.BLANK);
		}
		else {
			shapeImpl.setUrl(url);
		}

		if (shapeType == null) {
			shapeImpl.setShapeType(StringPool.BLANK);
		}
		else {
			shapeImpl.setShapeType(shapeType);
		}

		shapeImpl.setRadius(radius);

		shapeImpl.resetOriginalValues();

		return shapeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		shapeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		abstractDescription = objectInput.readUTF();
		url = objectInput.readUTF();
		shapeType = objectInput.readUTF();
		radius = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(shapeId);
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

		if (abstractDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(abstractDescription);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (shapeType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shapeType);
		}

		objectOutput.writeLong(radius);
	}

	public long shapeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String abstractDescription;
	public String url;
	public String shapeType;
	public long radius;
}