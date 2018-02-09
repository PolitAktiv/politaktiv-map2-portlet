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
 * Provides the remote service utility for Layer. This utility wraps
 * {@link org.politaktiv.map.service.impl.LayerServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Paul Butenko
 * @see LayerService
 * @see org.politaktiv.map.service.base.LayerServiceBaseImpl
 * @see org.politaktiv.map.service.impl.LayerServiceImpl
 * @generated
 */
public class LayerServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.service.impl.LayerServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static boolean addLayer(long userId, java.lang.String shapesLayer,
		java.lang.String portletInstance, java.lang.String portletId,
		java.lang.String primKey, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return getService()
				   .addLayer(userId, shapesLayer, portletInstance, portletId,
			primKey, groupId);
	}

	public static boolean deleteLayer(long userId,
		java.lang.String shapesLayer, java.lang.String portletInstance,
		java.lang.String portletId, java.lang.String primKey, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return getService()
				   .deleteLayer(userId, shapesLayer, portletInstance,
			portletId, primKey, groupId);
	}

	public static java.util.List<org.politaktiv.map.model.Layer> getLayers(
		long userId, java.lang.String portletInstance,
		java.lang.String portletId, java.lang.String primKey, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return getService()
				   .getLayers(userId, portletInstance, portletId, primKey,
			groupId);
	}

	public static java.util.List<java.lang.String> getInstances(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return getService().getInstances(userId);
	}

	public static java.util.List<com.liferay.portal.model.User> getUsers(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return getService().getUsers(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LayerService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LayerService.class.getName());

			if (invokableService instanceof LayerService) {
				_service = (LayerService)invokableService;
			}
			else {
				_service = new LayerServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(LayerServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LayerService service) {
	}

	private static LayerService _service;
}