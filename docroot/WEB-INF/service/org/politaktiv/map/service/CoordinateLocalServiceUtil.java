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
 * Provides the local service utility for Coordinate. This utility wraps
 * {@link org.politaktiv.map.service.impl.CoordinateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Aleksandar Lukic
 * @see CoordinateLocalService
 * @see org.politaktiv.map.service.base.CoordinateLocalServiceBaseImpl
 * @see org.politaktiv.map.service.impl.CoordinateLocalServiceImpl
 * @generated
 */
@ProviderType
public class CoordinateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.politaktiv.map.service.impl.CoordinateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the coordinate to the database. Also notifies the appropriate model listeners.
	*
	* @param coordinate the coordinate
	* @return the coordinate that was added
	*/
	public static org.politaktiv.map.model.Coordinate addCoordinate(
		org.politaktiv.map.model.Coordinate coordinate) {
		return getService().addCoordinate(coordinate);
	}

	public static org.politaktiv.map.model.Coordinate addCoordinate(
		long shapeId, String longitude, String latitude)
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		return getService().addCoordinate(shapeId, longitude, latitude);
	}

	public static java.util.List<org.politaktiv.map.model.Coordinate> addCoordinates(
		long shapeId, java.util.List<java.util.List<String>> coordinatesList)
		throws javax.portlet.ValidatorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addCoordinates(shapeId, coordinatesList);
	}

	/**
	* Creates a new coordinate with the primary key. Does not add the coordinate to the database.
	*
	* @param coordinateId the primary key for the new coordinate
	* @return the new coordinate
	*/
	public static org.politaktiv.map.model.Coordinate createCoordinate(
		long coordinateId) {
		return getService().createCoordinate(coordinateId);
	}

	/**
	* Deletes the coordinate from the database. Also notifies the appropriate model listeners.
	*
	* @param coordinate the coordinate
	* @return the coordinate that was removed
	*/
	public static org.politaktiv.map.model.Coordinate deleteCoordinate(
		org.politaktiv.map.model.Coordinate coordinate) {
		return getService().deleteCoordinate(coordinate);
	}

	/**
	* Deletes the coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate that was removed
	* @throws PortalException if a coordinate with the primary key could not be found
	*/
	public static org.politaktiv.map.model.Coordinate deleteCoordinate(
		long coordinateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCoordinate(coordinateId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.politaktiv.map.model.Coordinate fetchCoordinate(
		long coordinateId) {
		return getService().fetchCoordinate(coordinateId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<org.politaktiv.map.model.Coordinate> getAllCoordinatesByShapeId(
		long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCoordinatesByShapeId(shapeId);
	}

	/**
	* Returns the coordinate with the primary key.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate
	* @throws PortalException if a coordinate with the primary key could not be found
	*/
	public static org.politaktiv.map.model.Coordinate getCoordinate(
		long coordinateId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCoordinate(coordinateId);
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
	public static java.util.List<org.politaktiv.map.model.Coordinate> getCoordinates(
		int start, int end) {
		return getService().getCoordinates(start, end);
	}

	/**
	* Returns the number of coordinates.
	*
	* @return the number of coordinates
	*/
	public static int getCoordinatesCount() {
		return getService().getCoordinatesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static void removeCoordinatesByShapeId(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeCoordinatesByShapeId(shapeId);
	}

	/**
	* Updates the coordinate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param coordinate the coordinate
	* @return the coordinate that was updated
	*/
	public static org.politaktiv.map.model.Coordinate updateCoordinate(
		org.politaktiv.map.model.Coordinate coordinate) {
		return getService().updateCoordinate(coordinate);
	}

	public static void clearService() {
		_service = null;
	}

	public static CoordinateLocalService getService() {
		if (_service == null) {
			_service = (CoordinateLocalService)PortletBeanLocatorUtil.locate(ServletContextUtil.getServletContextName(),
					CoordinateLocalService.class.getName());

			ReferenceRegistry.registerReference(CoordinateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static CoordinateLocalService _service;
}