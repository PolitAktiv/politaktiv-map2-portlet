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
 * Provides a wrapper for {@link MarkerLocalService}.
 *
 * @author Paul Butenko
 * @see MarkerLocalService
 * @generated
 */
public class MarkerLocalServiceWrapper implements MarkerLocalService,
	ServiceWrapper<MarkerLocalService> {
	public MarkerLocalServiceWrapper(MarkerLocalService markerLocalService) {
		_markerLocalService = markerLocalService;
	}

	/**
	* Adds the marker to the database. Also notifies the appropriate model listeners.
	*
	* @param marker the marker
	* @return the marker that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.model.Marker addMarker(
		org.politaktiv.map.model.Marker marker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.addMarker(marker);
	}

	/**
	* Creates a new marker with the primary key. Does not add the marker to the database.
	*
	* @param markerId the primary key for the new marker
	* @return the new marker
	*/
	@Override
	public org.politaktiv.map.model.Marker createMarker(long markerId) {
		return _markerLocalService.createMarker(markerId);
	}

	/**
	* Deletes the marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the marker
	* @return the marker that was removed
	* @throws PortalException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.model.Marker deleteMarker(long markerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.deleteMarker(markerId);
	}

	/**
	* Deletes the marker from the database. Also notifies the appropriate model listeners.
	*
	* @param marker the marker
	* @return the marker that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.model.Marker deleteMarker(
		org.politaktiv.map.model.Marker marker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.deleteMarker(marker);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _markerLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.politaktiv.map.model.Marker fetchMarker(long markerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.fetchMarker(markerId);
	}

	/**
	* Returns the marker with the primary key.
	*
	* @param markerId the primary key of the marker
	* @return the marker
	* @throws PortalException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.model.Marker getMarker(long markerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.getMarker(markerId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of markers
	* @param end the upper bound of the range of markers (not inclusive)
	* @return the range of markers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.politaktiv.map.model.Marker> getMarkers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.getMarkers(start, end);
	}

	/**
	* Returns the number of markers.
	*
	* @return the number of markers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMarkersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.getMarkersCount();
	}

	/**
	* Updates the marker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param marker the marker
	* @return the marker that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.model.Marker updateMarker(
		org.politaktiv.map.model.Marker marker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _markerLocalService.updateMarker(marker);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _markerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_markerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _markerLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MarkerLocalService getWrappedMarkerLocalService() {
		return _markerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMarkerLocalService(
		MarkerLocalService markerLocalService) {
		_markerLocalService = markerLocalService;
	}

	@Override
	public MarkerLocalService getWrappedService() {
		return _markerLocalService;
	}

	@Override
	public void setWrappedService(MarkerLocalService markerLocalService) {
		_markerLocalService = markerLocalService;
	}

	private MarkerLocalService _markerLocalService;
}