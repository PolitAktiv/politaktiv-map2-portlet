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

package org.politaktiv.map.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.politaktiv.map.service.ShapeServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.politaktiv.map.service.ShapeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.politaktiv.map.model.ShapeSoap}.
 * If the method in the service utility returns a
 * {@link org.politaktiv.map.model.Shape}, that is translated to a
 * {@link org.politaktiv.map.model.ShapeSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Paul Butenko
 * @see ShapeServiceHttp
 * @see org.politaktiv.map.model.ShapeSoap
 * @see org.politaktiv.map.service.ShapeServiceUtil
 * @generated
 */
public class ShapeServiceSoap {
	public static org.politaktiv.map.model.ShapeSoap addShape(
		java.lang.String portletInstance, java.lang.String portletId,
		java.lang.String primKey, long groupId, long companyId,
		java.lang.String title, java.lang.String abstractDescription,
		java.lang.String image, java.lang.String shapeType, long radius,
		java.lang.String shapesLayer,
		java.util.List<java.util.List<java.lang.String>> points,
		java.lang.String userId) throws RemoteException {
		try {
			org.politaktiv.map.model.Shape returnValue = ShapeServiceUtil.addShape(portletInstance,
					portletId, primKey, groupId, companyId, title,
					abstractDescription, image, shapeType, radius, shapesLayer,
					points, userId);

			return org.politaktiv.map.model.ShapeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.politaktiv.map.model.ShapeSoap updateShape(
		java.lang.String portletInstance, java.lang.String portletId,
		java.lang.String primKey, long shapeId, java.lang.String title,
		java.lang.String abstractDescription, java.lang.String image,
		java.lang.String shapeType, long radius, java.lang.String shapesLayer,
		java.util.List<java.util.List<java.lang.String>> points)
		throws RemoteException {
		try {
			org.politaktiv.map.model.Shape returnValue = ShapeServiceUtil.updateShape(portletInstance,
					portletId, primKey, shapeId, title, abstractDescription,
					image, shapeType, radius, shapesLayer, points);

			return org.politaktiv.map.model.ShapeSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.politaktiv.map.model.ShapeSoap[] getShapes(
		java.lang.String portletInstance, java.lang.String primKey,
		long userId, java.lang.String shapesLayer) throws RemoteException {
		try {
			java.util.List<org.politaktiv.map.model.Shape> returnValue = ShapeServiceUtil.getShapes(portletInstance,
					primKey, userId, shapesLayer);

			return org.politaktiv.map.model.ShapeSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteShape(java.lang.String portletInstance,
		java.lang.String portletId, java.lang.String primKey, long shapeId)
		throws RemoteException {
		try {
			ShapeServiceUtil.deleteShape(portletInstance, portletId, primKey,
				shapeId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ShapeServiceSoap.class);
}