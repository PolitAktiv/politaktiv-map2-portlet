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

package org.politaktiv.map.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Shape. This utility wraps
 * {@link org.politaktiv.map.service.impl.ShapeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Paul Butenko
 * @see ShapeService
 * @see org.politaktiv.map.service.base.ShapeServiceBaseImpl
 * @see org.politaktiv.map.service.impl.ShapeServiceImpl
 * @generated
 */
public class ShapeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.service.impl.ShapeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.politaktiv.map.model.Shape addShape(
		java.lang.String portletId, java.lang.String primKey, long groupId,
		long companyId, java.lang.String title,
		java.lang.String abstractDescription, java.lang.String url,
		java.lang.String shapeType, long radius,
		java.util.List<java.util.List<java.lang.String>> points)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return getService()
				   .addShape(portletId, primKey, groupId, companyId, title,
			abstractDescription, url, shapeType, radius, points);
	}

	public static org.politaktiv.map.model.Shape updateShape(
		java.lang.String portletId, java.lang.String primKey, long shapeId,
		java.lang.String title, java.lang.String abstractDescription,
		java.lang.String url, java.lang.String shapeType, long radius,
		java.util.List<java.util.List<java.lang.String>> points)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return getService()
				   .updateShape(portletId, primKey, shapeId, title,
			abstractDescription, url, shapeType, radius, points);
	}

	public static java.util.List<org.politaktiv.map.model.Shape> getAllShapes(
		java.lang.String portletId, java.lang.String primKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllShapes(portletId, primKey);
	}

	public static java.util.List<org.politaktiv.map.model.Shape> getShapesByUserId(
		java.lang.String portletId, java.lang.String primKey, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return getService().getShapesByUserId(portletId, primKey, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ShapeService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ShapeService.class.getName());

			if (invokableService instanceof ShapeService) {
				_service = (ShapeService)invokableService;
			}
			else {
				_service = new ShapeServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ShapeServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ShapeService service) {
	}

	private static ShapeService _service;
}