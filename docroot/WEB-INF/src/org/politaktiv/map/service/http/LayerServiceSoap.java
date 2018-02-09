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

import org.politaktiv.map.service.LayerServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.politaktiv.map.service.LayerServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.politaktiv.map.model.LayerSoap}.
 * If the method in the service utility returns a
 * {@link org.politaktiv.map.model.Layer}, that is translated to a
 * {@link org.politaktiv.map.model.LayerSoap}. Methods that SOAP cannot
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
 * @see LayerServiceHttp
 * @see org.politaktiv.map.model.LayerSoap
 * @see org.politaktiv.map.service.LayerServiceUtil
 * @generated
 */
public class LayerServiceSoap {
	public static boolean addLayer(long userId, java.lang.String shapesLayer,
		java.lang.String portletInstance, java.lang.String portletId,
		java.lang.String primKey, long groupId) throws RemoteException {
		try {
			boolean returnValue = LayerServiceUtil.addLayer(userId,
					shapesLayer, portletInstance, portletId, primKey, groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean deleteLayer(long userId,
		java.lang.String shapesLayer, java.lang.String portletInstance,
		java.lang.String portletId, java.lang.String primKey, long groupId)
		throws RemoteException {
		try {
			boolean returnValue = LayerServiceUtil.deleteLayer(userId,
					shapesLayer, portletInstance, portletId, primKey, groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static org.politaktiv.map.model.LayerSoap[] getLayers(long userId,
		java.lang.String portletInstance, java.lang.String portletId,
		java.lang.String primKey, long groupId) throws RemoteException {
		try {
			java.util.List<org.politaktiv.map.model.Layer> returnValue = LayerServiceUtil.getLayers(userId,
					portletInstance, portletId, primKey, groupId);

			return org.politaktiv.map.model.LayerSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String[] getInstances(long userId)
		throws RemoteException {
		try {
			java.util.List<java.lang.String> returnValue = LayerServiceUtil.getInstances(userId);

			return returnValue.toArray(new java.lang.String[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.UserSoap[] getUsers(long userId)
		throws RemoteException {
		try {
			java.util.List<com.liferay.portal.model.User> returnValue = LayerServiceUtil.getUsers(userId);

			return com.liferay.portal.model.UserSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LayerServiceSoap.class);
}