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

package org.politaktiv.map.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.politaktiv.map.service.ClpSerializer;
import org.politaktiv.map.service.CoordinateLocalServiceUtil;
import org.politaktiv.map.service.CoordinateServiceUtil;
import org.politaktiv.map.service.LayerLocalServiceUtil;
import org.politaktiv.map.service.LayerServiceUtil;
import org.politaktiv.map.service.ShapeLocalServiceUtil;
import org.politaktiv.map.service.ShapeServiceUtil;

/**
 * @author Paul Butenko
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			CoordinateLocalServiceUtil.clearService();

			CoordinateServiceUtil.clearService();
			LayerLocalServiceUtil.clearService();

			LayerServiceUtil.clearService();
			ShapeLocalServiceUtil.clearService();

			ShapeServiceUtil.clearService();
		}
	}
}