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
 * Provides a wrapper for {@link CoordinateLocalService}.
 *
 * @author Aleksandar Lukic
 * @see CoordinateLocalService
 * @generated
 */
@ProviderType
public class CoordinateLocalServiceWrapper implements CoordinateLocalService,
	ServiceWrapper<CoordinateLocalService> {
	public CoordinateLocalServiceWrapper(
		CoordinateLocalService coordinateLocalService) {
		_coordinateLocalService = coordinateLocalService;
	}

	/**
	* Adds the coordinate to the database. Also notifies the appropriate model listeners.
	*
	* @param coordinate the coordinate
	* @return the coordinate that was added
	*/
	@Override
	public org.politaktiv.map.model.Coordinate addCoordinate(
		org.politaktiv.map.model.Coordinate coordinate) {
		return _coordinateLocalService.addCoordinate(coordinate);
	}

	@Override
	public org.politaktiv.map.model.Coordinate addCoordinate(long shapeId,
		String longitude, String latitude)
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return _coordinateLocalService.addCoordinate(shapeId, longitude,
			latitude);
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Coordinate> addCoordinates(
		long shapeId, java.util.List<java.util.List<String>> coordinatesList)
		throws javax.portlet.ValidatorException,
			com.liferay.portal.kernel.exception.SystemException {
		return _coordinateLocalService.addCoordinates(shapeId, coordinatesList);
	}

	/**
	* Creates a new coordinate with the primary key. Does not add the coordinate to the database.
	*
	* @param coordinateId the primary key for the new coordinate
	* @return the new coordinate
	*/
	@Override
	public org.politaktiv.map.model.Coordinate createCoordinate(
		long coordinateId) {
		return _coordinateLocalService.createCoordinate(coordinateId);
	}

	/**
	* Deletes the coordinate from the database. Also notifies the appropriate model listeners.
	*
	* @param coordinate the coordinate
	* @return the coordinate that was removed
	*/
	@Override
	public org.politaktiv.map.model.Coordinate deleteCoordinate(
		org.politaktiv.map.model.Coordinate coordinate) {
		return _coordinateLocalService.deleteCoordinate(coordinate);
	}

	/**
	* Deletes the coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate that was removed
	* @throws PortalException if a coordinate with the primary key could not be found
	*/
	@Override
	public org.politaktiv.map.model.Coordinate deleteCoordinate(
		long coordinateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _coordinateLocalService.deleteCoordinate(coordinateId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _coordinateLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _coordinateLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _coordinateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _coordinateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _coordinateLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _coordinateLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _coordinateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.politaktiv.map.model.Coordinate fetchCoordinate(
		long coordinateId) {
		return _coordinateLocalService.fetchCoordinate(coordinateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _coordinateLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Coordinate> getAllCoordinatesByShapeId(
		long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _coordinateLocalService.getAllCoordinatesByShapeId(shapeId);
	}

	/**
	* Returns the coordinate with the primary key.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate
	* @throws PortalException if a coordinate with the primary key could not be found
	*/
	@Override
	public org.politaktiv.map.model.Coordinate getCoordinate(long coordinateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _coordinateLocalService.getCoordinate(coordinateId);
	}

	/**
	* Returns a range of all the coordinates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of coordinates
	* @param end the upper bound of the range of coordinates (not inclusive)
	* @return the range of coordinates
	*/
	@Override
	public java.util.List<org.politaktiv.map.model.Coordinate> getCoordinates(
		int start, int end) {
		return _coordinateLocalService.getCoordinates(start, end);
	}

	/**
	* Returns the number of coordinates.
	*
	* @return the number of coordinates
	*/
	@Override
	public int getCoordinatesCount() {
		return _coordinateLocalService.getCoordinatesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _coordinateLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _coordinateLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _coordinateLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void removeCoordinatesByShapeId(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_coordinateLocalService.removeCoordinatesByShapeId(shapeId);
	}

	/**
	* Updates the coordinate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coordinate the coordinate
	* @return the coordinate that was updated
	*/
	@Override
	public org.politaktiv.map.model.Coordinate updateCoordinate(
		org.politaktiv.map.model.Coordinate coordinate) {
		return _coordinateLocalService.updateCoordinate(coordinate);
	}

	@Override
	public CoordinateLocalService getWrappedService() {
		return _coordinateLocalService;
	}

	@Override
	public void setWrappedService(CoordinateLocalService coordinateLocalService) {
		_coordinateLocalService = coordinateLocalService;
	}

	private CoordinateLocalService _coordinateLocalService;
}