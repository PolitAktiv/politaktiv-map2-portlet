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

package org.politaktiv.map.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.politaktiv.map.model.Coordinate;

import java.util.List;

/**
 * The persistence utility for the coordinate service. This utility wraps {@link CoordinatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul Butenko
 * @see CoordinatePersistence
 * @see CoordinatePersistenceImpl
 * @generated
 */
public class CoordinateUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Coordinate coordinate) {
		getPersistence().clearCache(coordinate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Coordinate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Coordinate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Coordinate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Coordinate update(Coordinate coordinate)
		throws SystemException {
		return getPersistence().update(coordinate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Coordinate update(Coordinate coordinate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(coordinate, serviceContext);
	}

	/**
	* Returns all the coordinates where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @return the matching coordinates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Coordinate> findByShapeId(
		long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByShapeId(shapeId);
	}

	/**
	* Returns a range of all the coordinates where shapeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shapeId the shape ID
	* @param start the lower bound of the range of coordinates
	* @param end the upper bound of the range of coordinates (not inclusive)
	* @return the range of matching coordinates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Coordinate> findByShapeId(
		long shapeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByShapeId(shapeId, start, end);
	}

	/**
	* Returns an ordered range of all the coordinates where shapeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shapeId the shape ID
	* @param start the lower bound of the range of coordinates
	* @param end the upper bound of the range of coordinates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching coordinates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Coordinate> findByShapeId(
		long shapeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByShapeId(shapeId, start, end, orderByComparator);
	}

	/**
	* Returns the first coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinate
	* @throws org.politaktiv.map.NoSuchCoordinateException if a matching coordinate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Coordinate findByShapeId_First(
		long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchCoordinateException {
		return getPersistence().findByShapeId_First(shapeId, orderByComparator);
	}

	/**
	* Returns the first coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinate, or <code>null</code> if a matching coordinate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Coordinate fetchByShapeId_First(
		long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByShapeId_First(shapeId, orderByComparator);
	}

	/**
	* Returns the last coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinate
	* @throws org.politaktiv.map.NoSuchCoordinateException if a matching coordinate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Coordinate findByShapeId_Last(
		long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchCoordinateException {
		return getPersistence().findByShapeId_Last(shapeId, orderByComparator);
	}

	/**
	* Returns the last coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinate, or <code>null</code> if a matching coordinate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Coordinate fetchByShapeId_Last(
		long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByShapeId_Last(shapeId, orderByComparator);
	}

	/**
	* Returns the coordinates before and after the current coordinate in the ordered set where shapeId = &#63;.
	*
	* @param coordinateId the primary key of the current coordinate
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next coordinate
	* @throws org.politaktiv.map.NoSuchCoordinateException if a coordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Coordinate[] findByShapeId_PrevAndNext(
		long coordinateId, long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchCoordinateException {
		return getPersistence()
				   .findByShapeId_PrevAndNext(coordinateId, shapeId,
			orderByComparator);
	}

	/**
	* Removes all the coordinates where shapeId = &#63; from the database.
	*
	* @param shapeId the shape ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByShapeId(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByShapeId(shapeId);
	}

	/**
	* Returns the number of coordinates where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @return the number of matching coordinates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByShapeId(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByShapeId(shapeId);
	}

	/**
	* Caches the coordinate in the entity cache if it is enabled.
	*
	* @param coordinate the coordinate
	*/
	public static void cacheResult(
		org.politaktiv.map.model.Coordinate coordinate) {
		getPersistence().cacheResult(coordinate);
	}

	/**
	* Caches the coordinates in the entity cache if it is enabled.
	*
	* @param coordinates the coordinates
	*/
	public static void cacheResult(
		java.util.List<org.politaktiv.map.model.Coordinate> coordinates) {
		getPersistence().cacheResult(coordinates);
	}

	/**
	* Creates a new coordinate with the primary key. Does not add the coordinate to the database.
	*
	* @param coordinateId the primary key for the new coordinate
	* @return the new coordinate
	*/
	public static org.politaktiv.map.model.Coordinate create(long coordinateId) {
		return getPersistence().create(coordinateId);
	}

	/**
	* Removes the coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate that was removed
	* @throws org.politaktiv.map.NoSuchCoordinateException if a coordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Coordinate remove(long coordinateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchCoordinateException {
		return getPersistence().remove(coordinateId);
	}

	public static org.politaktiv.map.model.Coordinate updateImpl(
		org.politaktiv.map.model.Coordinate coordinate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(coordinate);
	}

	/**
	* Returns the coordinate with the primary key or throws a {@link org.politaktiv.map.NoSuchCoordinateException} if it could not be found.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate
	* @throws org.politaktiv.map.NoSuchCoordinateException if a coordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Coordinate findByPrimaryKey(
		long coordinateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchCoordinateException {
		return getPersistence().findByPrimaryKey(coordinateId);
	}

	/**
	* Returns the coordinate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate, or <code>null</code> if a coordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Coordinate fetchByPrimaryKey(
		long coordinateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(coordinateId);
	}

	/**
	* Returns all the coordinates.
	*
	* @return the coordinates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Coordinate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Coordinate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the coordinates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of coordinates
	* @param end the upper bound of the range of coordinates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of coordinates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Coordinate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the coordinates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of coordinates.
	*
	* @return the number of coordinates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CoordinatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoordinatePersistence)PortletBeanLocatorUtil.locate(org.politaktiv.map.service.ClpSerializer.getServletContextName(),
					CoordinatePersistence.class.getName());

			ReferenceRegistry.registerReference(CoordinateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CoordinatePersistence persistence) {
	}

	private static CoordinatePersistence _persistence;
}