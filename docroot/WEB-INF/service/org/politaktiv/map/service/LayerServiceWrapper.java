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
 * Provides a wrapper for {@link LayerService}.
 *
 * @author Paul Butenko
 * @see LayerService
 * @generated
 */
public class LayerServiceWrapper implements LayerService,
	ServiceWrapper<LayerService> {
	public LayerServiceWrapper(LayerService layerService) {
		_layerService = layerService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _layerService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_layerService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _layerService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public boolean addLayer(long userId, java.lang.String shapesLayer,
		java.lang.String portletInstance, java.lang.String portletId,
		java.lang.String primKey, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return _layerService.addLayer(userId, shapesLayer, portletInstance,
			portletId, primKey, groupId);
	}

	@Override
	public boolean deleteLayer(long userId, java.lang.String shapesLayer,
		java.lang.String portletInstance, java.lang.String portletId,
		java.lang.String primKey, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return _layerService.deleteLayer(userId, shapesLayer, portletInstance,
			portletId, primKey, groupId);
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Layer> getLayers(
		long userId, java.lang.String portletInstance,
		java.lang.String portletId, java.lang.String primKey, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return _layerService.getLayers(userId, portletInstance, portletId,
			primKey, groupId);
	}

	@Override
	public java.util.List<java.lang.String> getInstances(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return _layerService.getInstances(userId);
	}

	@Override
	public java.util.List<com.liferay.portal.model.User> getUsers(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return _layerService.getUsers(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LayerService getWrappedLayerService() {
		return _layerService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLayerService(LayerService layerService) {
		_layerService = layerService;
	}

	@Override
	public LayerService getWrappedService() {
		return _layerService;
	}

	@Override
	public void setWrappedService(LayerService layerService) {
		_layerService = layerService;
	}

	private LayerService _layerService;
}