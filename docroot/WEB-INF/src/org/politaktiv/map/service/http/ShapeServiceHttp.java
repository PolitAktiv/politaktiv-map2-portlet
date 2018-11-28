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

package org.politaktiv.map.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import org.politaktiv.map.service.ShapeServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link ShapeServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Aleksandar Lukic
 * @see ShapeServiceSoap
 * @see HttpPrincipal
 * @see ShapeServiceUtil
 * @generated
 */
@ProviderType
public class ShapeServiceHttp {
	public static org.politaktiv.map.model.Shape addShape(
		HttpPrincipal httpPrincipal, String portletId, String primKey,
		long groupId, long companyId, String title, String abstractDescription,
		String url, String shapeType, long radius, String shapesLayer,
		java.util.List<java.util.List<String>> points)
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException,
			com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ShapeServiceUtil.class,
					"addShape", _addShapeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					portletId, primKey, groupId, companyId, title,
					abstractDescription, url, shapeType, radius, shapesLayer,
					points);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof javax.portlet.ValidatorException) {
					throw (javax.portlet.ValidatorException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (org.politaktiv.map.model.Shape)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.politaktiv.map.model.Shape updateShape(
		HttpPrincipal httpPrincipal, String portletId, String primKey,
		long shapeId, String title, String abstractDescription, String url,
		String shapeType, long radius, String shapesLayer,
		java.util.List<java.util.List<String>> points)
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException,
			com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ShapeServiceUtil.class,
					"updateShape", _updateShapeParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					portletId, primKey, shapeId, title, abstractDescription,
					url, shapeType, radius, shapesLayer, points);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof javax.portlet.ValidatorException) {
					throw (javax.portlet.ValidatorException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (org.politaktiv.map.model.Shape)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<org.politaktiv.map.model.Shape> getAllShapes(
		HttpPrincipal httpPrincipal, String portletId, String primKey,
		String shapesLayer)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(ShapeServiceUtil.class,
					"getAllShapes", _getAllShapesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					portletId, primKey, shapesLayer);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<org.politaktiv.map.model.Shape>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<org.politaktiv.map.model.Shape> getShapesByUserId(
		HttpPrincipal httpPrincipal, String portletId, String primKey,
		long userId, String shapesLayer)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		try {
			MethodKey methodKey = new MethodKey(ShapeServiceUtil.class,
					"getShapesByUserId", _getShapesByUserIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					portletId, primKey, userId, shapesLayer);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof com.liferay.portal.kernel.security.auth.PrincipalException) {
					throw (com.liferay.portal.kernel.security.auth.PrincipalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<org.politaktiv.map.model.Shape>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void deleteShapeById(HttpPrincipal httpPrincipal,
		String portletId, String primKey, long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(ShapeServiceUtil.class,
					"deleteShapeById", _deleteShapeByIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					portletId, primKey, shapeId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ShapeServiceHttp.class);
	private static final Class<?>[] _addShapeParameterTypes0 = new Class[] {
			String.class, String.class, long.class, long.class, String.class,
			String.class, String.class, String.class, long.class, String.class,
			java.util.List.class
		};
	private static final Class<?>[] _updateShapeParameterTypes1 = new Class[] {
			String.class, String.class, long.class, String.class, String.class,
			String.class, String.class, long.class, String.class,
			java.util.List.class
		};
	private static final Class<?>[] _getAllShapesParameterTypes2 = new Class[] {
			String.class, String.class, String.class
		};
	private static final Class<?>[] _getShapesByUserIdParameterTypes3 = new Class[] {
			String.class, String.class, long.class, String.class
		};
	private static final Class<?>[] _deleteShapeByIdParameterTypes4 = new Class[] {
			String.class, String.class, long.class
		};
}