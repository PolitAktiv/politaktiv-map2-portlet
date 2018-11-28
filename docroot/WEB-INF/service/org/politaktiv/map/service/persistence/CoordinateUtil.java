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

package org.politaktiv.map.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import org.politaktiv.map.model.Coordinate;

import java.util.List;

/**
 * The persistence utility for the coordinate service. This utility wraps {@link org.politaktiv.map.service.persistence.impl.CoordinatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aleksandar Lukic
 * @see CoordinatePersistence
 * @see org.politaktiv.map.service.persistence.impl.CoordinatePersistenceImpl
 * @generated
 */
@ProviderType
public class CoordinateUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Coordinate coordinate) {
		getPersistence().clearCache(coordinate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Coordinate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Coordinate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Coordinate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Coordinate> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Coordinate update(Coordinate coordinate) {
		return getPersistence().update(coordinate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Coordinate update(Coordinate coordinate,
		ServiceContext serviceContext) {
		return getPersistence().update(coordinate, serviceContext);
	}

	/**
	* Returns all the coordinates where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @return the matching coordinates
	*/
	public static List<Coordinate> findByShapeId(long shapeId) {
		return getPersistence().findByShapeId(shapeId);
	}

	/**
	* Returns a range of all the coordinates where shapeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shapeId the shape ID
	* @param start the lower bound of the range of coordinates
	* @param end the upper bound of the range of coordinates (not inclusive)
	* @return the range of matching coordinates
	*/
	public static List<Coordinate> findByShapeId(long shapeId, int start,
		int end) {
		return getPersistence().findByShapeId(shapeId, start, end);
	}

	/**
	* Returns an ordered range of all the coordinates where shapeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shapeId the shape ID
	* @param start the lower bound of the range of coordinates
	* @param end the upper bound of the range of coordinates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching coordinates
	*/
	public static List<Coordinate> findByShapeId(long shapeId, int start,
		int end, OrderByComparator<Coordinate> orderByComparator) {
		return getPersistence()
				   .findByShapeId(shapeId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the coordinates where shapeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shapeId the shape ID
	* @param start the lower bound of the range of coordinates
	* @param end the upper bound of the range of coordinates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching coordinates
	*/
	public static List<Coordinate> findByShapeId(long shapeId, int start,
		int end, OrderByComparator<Coordinate> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByShapeId(shapeId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinate
	* @throws NoSuchCoordinateException if a matching coordinate could not be found
	*/
	public static Coordinate findByShapeId_First(long shapeId,
		OrderByComparator<Coordinate> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchCoordinateException {
		return getPersistence().findByShapeId_First(shapeId, orderByComparator);
	}

	/**
	* Returns the first coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinate, or <code>null</code> if a matching coordinate could not be found
	*/
	public static Coordinate fetchByShapeId_First(long shapeId,
		OrderByComparator<Coordinate> orderByComparator) {
		return getPersistence().fetchByShapeId_First(shapeId, orderByComparator);
	}

	/**
	* Returns the last coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinate
	* @throws NoSuchCoordinateException if a matching coordinate could not be found
	*/
	public static Coordinate findByShapeId_Last(long shapeId,
		OrderByComparator<Coordinate> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchCoordinateException {
		return getPersistence().findByShapeId_Last(shapeId, orderByComparator);
	}

	/**
	* Returns the last coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinate, or <code>null</code> if a matching coordinate could not be found
	*/
	public static Coordinate fetchByShapeId_Last(long shapeId,
		OrderByComparator<Coordinate> orderByComparator) {
		return getPersistence().fetchByShapeId_Last(shapeId, orderByComparator);
	}

	/**
	* Returns the coordinates before and after the current coordinate in the ordered set where shapeId = &#63;.
	*
	* @param coordinateId the primary key of the current coordinate
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next coordinate
	* @throws NoSuchCoordinateException if a coordinate with the primary key could not be found
	*/
	public static Coordinate[] findByShapeId_PrevAndNext(long coordinateId,
		long shapeId, OrderByComparator<Coordinate> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchCoordinateException {
		return getPersistence()
				   .findByShapeId_PrevAndNext(coordinateId, shapeId,
			orderByComparator);
	}

	/**
	* Removes all the coordinates where shapeId = &#63; from the database.
	*
	* @param shapeId the shape ID
	*/
	public static void removeByShapeId(long shapeId) {
		getPersistence().removeByShapeId(shapeId);
	}

	/**
	* Returns the number of coordinates where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @return the number of matching coordinates
	*/
	public static int countByShapeId(long shapeId) {
		return getPersistence().countByShapeId(shapeId);
	}

	/**
	* Caches the coordinate in the entity cache if it is enabled.
	*
	* @param coordinate the coordinate
	*/
	public static void cacheResult(Coordinate coordinate) {
		getPersistence().cacheResult(coordinate);
	}

	/**
	* Caches the coordinates in the entity cache if it is enabled.
	*
	* @param coordinates the coordinates
	*/
	public static void cacheResult(List<Coordinate> coordinates) {
		getPersistence().cacheResult(coordinates);
	}

	/**
	* Creates a new coordinate with the primary key. Does not add the coordinate to the database.
	*
	* @param coordinateId the primary key for the new coordinate
	* @return the new coordinate
	*/
	public static Coordinate create(long coordinateId) {
		return getPersistence().create(coordinateId);
	}

	/**
	* Removes the coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate that was removed
	* @throws NoSuchCoordinateException if a coordinate with the primary key could not be found
	*/
	public static Coordinate remove(long coordinateId)
		throws org.politaktiv.map.exception.NoSuchCoordinateException {
		return getPersistence().remove(coordinateId);
	}

	public static Coordinate updateImpl(Coordinate coordinate) {
		return getPersistence().updateImpl(coordinate);
	}

	/**
	* Returns the coordinate with the primary key or throws a {@link NoSuchCoordinateException} if it could not be found.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate
	* @throws NoSuchCoordinateException if a coordinate with the primary key could not be found
	*/
	public static Coordinate findByPrimaryKey(long coordinateId)
		throws org.politaktiv.map.exception.NoSuchCoordinateException {
		return getPersistence().findByPrimaryKey(coordinateId);
	}

	/**
	* Returns the coordinate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate, or <code>null</code> if a coordinate with the primary key could not be found
	*/
	public static Coordinate fetchByPrimaryKey(long coordinateId) {
		return getPersistence().fetchByPrimaryKey(coordinateId);
	}

	public static java.util.Map<java.io.Serializable, Coordinate> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the coordinates.
	*
	* @return the coordinates
	*/
	public static List<Coordinate> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the coordinates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of coordinates
	* @param end the upper bound of the range of coordinates (not inclusive)
	* @return the range of coordinates
	*/
	public static List<Coordinate> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the coordinates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of coordinates
	* @param end the upper bound of the range of coordinates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of coordinates
	*/
	public static List<Coordinate> findAll(int start, int end,
		OrderByComparator<Coordinate> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the coordinates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of coordinates
	* @param end the upper bound of the range of coordinates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of coordinates
	*/
	public static List<Coordinate> findAll(int start, int end,
		OrderByComparator<Coordinate> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the coordinates from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of coordinates.
	*
	* @return the number of coordinates
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CoordinatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoordinatePersistence)PortletBeanLocatorUtil.locate(org.politaktiv.map.service.ServletContextUtil.getServletContextName(),
					CoordinatePersistence.class.getName());

			ReferenceRegistry.registerReference(CoordinateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static CoordinatePersistence _persistence;
}