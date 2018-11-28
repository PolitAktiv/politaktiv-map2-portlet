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
 * Provides the remote service utility for Coordinate. This utility wraps
 * {@link org.politaktiv.map.service.impl.CoordinateServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Aleksandar Lukic
 * @see CoordinateService
 * @see org.politaktiv.map.service.base.CoordinateServiceBaseImpl
 * @see org.politaktiv.map.service.impl.CoordinateServiceImpl
 * @generated
 */
@ProviderType
public class CoordinateServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.service.impl.CoordinateServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void clearService() {
		_service = null;
	}

	public static CoordinateService getService() {
		if (_service == null) {
			_service = (CoordinateService)PortletBeanLocatorUtil.locate(ServletContextUtil.getServletContextName(),
					CoordinateService.class.getName());

			ReferenceRegistry.registerReference(CoordinateServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static CoordinateService _service;
}