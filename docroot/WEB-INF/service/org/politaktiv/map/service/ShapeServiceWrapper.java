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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShapeService}.
 *
 * @author Aleksandar Lukic
 * @see ShapeService
 * @generated
 */
@ProviderType
public class ShapeServiceWrapper implements ShapeService,
	ServiceWrapper<ShapeService> {
	public ShapeServiceWrapper(ShapeService shapeService) {
		_shapeService = shapeService;
	}

	@Override
	public org.politaktiv.map.model.Shape addShape(String portletId,
		String primKey, long groupId, long companyId, String title,
		String abstractDescription, String url, String shapeType, long radius,
		String shapesLayer, java.util.List<java.util.List<String>> points)
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException,
			com.liferay.portal.kernel.exception.PortalException {
		return _shapeService.addShape(portletId, primKey, groupId, companyId,
			title, abstractDescription, url, shapeType, radius, shapesLayer,
			points);
	}

	@Override
	public void deleteShapeById(String portletId, String primKey, long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.exception.PortalException {
		_shapeService.deleteShapeById(portletId, primKey, shapeId);
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Shape> getAllShapes(
		String portletId, String primKey, String shapesLayer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shapeService.getAllShapes(portletId, primKey, shapesLayer);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _shapeService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Shape> getShapesByUserId(
		String portletId, String primKey, long userId, String shapesLayer)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _shapeService.getShapesByUserId(portletId, primKey, userId,
			shapesLayer);
	}

	@Override
	public org.politaktiv.map.model.Shape updateShape(String portletId,
		String primKey, long shapeId, String title, String abstractDescription,
		String url, String shapeType, long radius, String shapesLayer,
		java.util.List<java.util.List<String>> points)
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException,
			com.liferay.portal.kernel.exception.PortalException {
		return _shapeService.updateShape(portletId, primKey, shapeId, title,
			abstractDescription, url, shapeType, radius, shapesLayer, points);
	}

	@Override
	public ShapeService getWrappedService() {
		return _shapeService;
	}

	@Override
	public void setWrappedService(ShapeService shapeService) {
		_shapeService = shapeService;
	}

	private ShapeService _shapeService;
}