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
 * Provides a wrapper for {@link MarkerService}.
 *
 * @author Paul Butenko
 * @see MarkerService
 * @generated
 */
public class MarkerServiceWrapper implements MarkerService,
	ServiceWrapper<MarkerService> {
	public MarkerServiceWrapper(MarkerService markerService) {
		_markerService = markerService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _markerService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_markerService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _markerService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public org.politaktiv.map.model.Marker addMarker(
		java.lang.String portletId, java.lang.String primKey, long groupId,
		long companyId, java.lang.String title, java.lang.String content,
		java.lang.String longitude, java.lang.String latitude)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return _markerService.addMarker(portletId, primKey, groupId, companyId,
			title, content, longitude, latitude);
	}

	@Override
	public void updateMarker(java.lang.String portletId,
		java.lang.String primKey, long markerId, java.lang.String title,
		java.lang.String content, java.lang.String longitude,
		java.lang.String latitude)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		_markerService.updateMarker(portletId, primKey, markerId, title,
			content, longitude, latitude);
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Marker> getAllMarkers(
		java.lang.String portletId, java.lang.String primKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerService.getAllMarkers(portletId, primKey);
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Marker> getMarkersByUserId(
		java.lang.String portletId, java.lang.String primKey, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		return _markerService.getMarkersByUserId(portletId, primKey, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MarkerService getWrappedMarkerService() {
		return _markerService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMarkerService(MarkerService markerService) {
		_markerService = markerService;
	}

	@Override
	public MarkerService getWrappedService() {
		return _markerService;
	}

	@Override
	public void setWrappedService(MarkerService markerService) {
		_markerService = markerService;
	}

	private MarkerService _markerService;
}