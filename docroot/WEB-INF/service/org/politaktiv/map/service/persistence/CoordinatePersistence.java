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

import com.liferay.portal.service.persistence.BasePersistence;

import org.politaktiv.map.model.Coordinate;

/**
 * The persistence interface for the coordinate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul Butenko
 * @see CoordinatePersistenceImpl
 * @see CoordinateUtil
 * @generated
 */
public interface CoordinatePersistence extends BasePersistence<Coordinate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CoordinateUtil} to access the coordinate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the coordinates where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @return the matching coordinates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Coordinate> findByShapeId(
		long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.model.Coordinate> findByShapeId(
		long shapeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.model.Coordinate> findByShapeId(
		long shapeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinate
	* @throws org.politaktiv.map.NoSuchCoordinateException if a matching coordinate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Coordinate findByShapeId_First(
		long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchCoordinateException;

	/**
	* Returns the first coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinate, or <code>null</code> if a matching coordinate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Coordinate fetchByShapeId_First(
		long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinate
	* @throws org.politaktiv.map.NoSuchCoordinateException if a matching coordinate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Coordinate findByShapeId_Last(
		long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchCoordinateException;

	/**
	* Returns the last coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinate, or <code>null</code> if a matching coordinate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Coordinate fetchByShapeId_Last(
		long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.politaktiv.map.model.Coordinate[] findByShapeId_PrevAndNext(
		long coordinateId, long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchCoordinateException;

	/**
	* Removes all the coordinates where shapeId = &#63; from the database.
	*
	* @param shapeId the shape ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByShapeId(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of coordinates where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @return the number of matching coordinates
	* @throws SystemException if a system exception occurred
	*/
	public int countByShapeId(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the coordinate in the entity cache if it is enabled.
	*
	* @param coordinate the coordinate
	*/
	public void cacheResult(org.politaktiv.map.model.Coordinate coordinate);

	/**
	* Caches the coordinates in the entity cache if it is enabled.
	*
	* @param coordinates the coordinates
	*/
	public void cacheResult(
		java.util.List<org.politaktiv.map.model.Coordinate> coordinates);

	/**
	* Creates a new coordinate with the primary key. Does not add the coordinate to the database.
	*
	* @param coordinateId the primary key for the new coordinate
	* @return the new coordinate
	*/
	public org.politaktiv.map.model.Coordinate create(long coordinateId);

	/**
	* Removes the coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate that was removed
	* @throws org.politaktiv.map.NoSuchCoordinateException if a coordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Coordinate remove(long coordinateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchCoordinateException;

	public org.politaktiv.map.model.Coordinate updateImpl(
		org.politaktiv.map.model.Coordinate coordinate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the coordinate with the primary key or throws a {@link org.politaktiv.map.NoSuchCoordinateException} if it could not be found.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate
	* @throws org.politaktiv.map.NoSuchCoordinateException if a coordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Coordinate findByPrimaryKey(
		long coordinateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchCoordinateException;

	/**
	* Returns the coordinate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate, or <code>null</code> if a coordinate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Coordinate fetchByPrimaryKey(
		long coordinateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the coordinates.
	*
	* @return the coordinates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Coordinate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.model.Coordinate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.model.Coordinate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the coordinates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of coordinates.
	*
	* @return the number of coordinates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}