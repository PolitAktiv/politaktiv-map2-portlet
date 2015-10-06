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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ShapeService}.
 *
 * @author Paul Butenko
 * @see ShapeService
 * @generated
 */
public class ShapeServiceWrapper implements ShapeService,
	ServiceWrapper<ShapeService> {
	public ShapeServiceWrapper(ShapeService shapeService) {
		_shapeService = shapeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _shapeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_shapeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _shapeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void addShape(java.lang.String portletId, java.lang.String primKey,
		long groupId, long companyId, java.lang.String title,
		java.lang.String abstractDescription, java.lang.String url,
		java.lang.String shapeType, long radius,
		java.util.List<java.util.List<java.lang.String>> points)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		_shapeService.addShape(portletId, primKey, groupId, companyId, title,
			abstractDescription, url, shapeType, radius, points);
	}

	@Override
	public void updateShape(java.lang.String portletId,
		java.lang.String primKey, long shapeId, java.lang.String title,
		java.lang.String abstractDescription, java.lang.String url,
		java.lang.String shapeType, long radius,
		java.util.List<java.util.List<java.lang.String>> points)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		_shapeService.updateShape(portletId, primKey, shapeId, title,
			abstractDescription, url, shapeType, radius, points);
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Shape> getAllShapes(
		java.lang.String portletId, java.lang.String primKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shapeService.getAllShapes(portletId, primKey);
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Shape> getShapesByUserId(
		java.lang.String portletId, java.lang.String primKey, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _shapeService.getShapesByUserId(portletId, primKey, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ShapeService getWrappedShapeService() {
		return _shapeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedShapeService(ShapeService shapeService) {
		_shapeService = shapeService;
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