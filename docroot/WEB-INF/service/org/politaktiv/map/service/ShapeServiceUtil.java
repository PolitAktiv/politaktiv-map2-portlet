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

package org.politaktiv.map.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the remote service utility for Shape. This utility wraps
 * {@link org.politaktiv.map.service.impl.ShapeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Aleksandar Lukic
 * @see ShapeService
 * @see org.politaktiv.map.service.base.ShapeServiceBaseImpl
 * @see org.politaktiv.map.service.impl.ShapeServiceImpl
 * @generated
 */
@ProviderType
public class ShapeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.service.impl.ShapeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static org.politaktiv.map.model.Shape addShape(String portletId,
		String primKey, long groupId, long companyId, String title,
		String abstractDescription, String url, String shapeType, long radius,
		String shapesLayer, java.util.List<java.util.List<String>> points)
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException,
			com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addShape(portletId, primKey, groupId, companyId, title,
			abstractDescription, url, shapeType, radius, shapesLayer, points);
	}

	public static void deleteShapeById(String portletId, String primKey,
		long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		getService().deleteShapeById(portletId, primKey, shapeId);
	}

	public static java.util.List<org.politaktiv.map.model.Shape> getAllShapes(
		String portletId, String primKey, String shapesLayer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllShapes(portletId, primKey, shapesLayer);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<org.politaktiv.map.model.Shape> getShapesByUserId(
		String portletId, String primKey, long userId, String shapesLayer)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService()
				   .getShapesByUserId(portletId, primKey, userId, shapesLayer);
	}

	public static org.politaktiv.map.model.Shape updateShape(String portletId,
		String primKey, long shapeId, String title, String abstractDescription,
		String url, String shapeType, long radius, String shapesLayer,
		java.util.List<java.util.List<String>> points)
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException,
			com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateShape(portletId, primKey, shapeId, title,
			abstractDescription, url, shapeType, radius, shapesLayer, points);
	}

	public static void clearService() {
		_service = null;
	}

	public static ShapeService getService() {
		if (_service == null) {
			_service = (ShapeService)PortletBeanLocatorUtil.locate(ServletContextUtil.getServletContextName(),
					ShapeService.class.getName());

			ReferenceRegistry.registerReference(ShapeServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static ShapeService _service;
}