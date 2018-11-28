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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.politaktiv.map.exception.NoSuchCoordinateException;
import org.politaktiv.map.model.Coordinate;

/**
 * The persistence interface for the coordinate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aleksandar Lukic
 * @see org.politaktiv.map.service.persistence.impl.CoordinatePersistenceImpl
 * @see CoordinateUtil
 * @generated
 */
@ProviderType
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
	*/
	public java.util.List<Coordinate> findByShapeId(long shapeId);

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
	public java.util.List<Coordinate> findByShapeId(long shapeId, int start,
		int end);

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
	public java.util.List<Coordinate> findByShapeId(long shapeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coordinate> orderByComparator);

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
	public java.util.List<Coordinate> findByShapeId(long shapeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coordinate> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinate
	* @throws NoSuchCoordinateException if a matching coordinate could not be found
	*/
	public Coordinate findByShapeId_First(long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator<Coordinate> orderByComparator)
		throws NoSuchCoordinateException;

	/**
	* Returns the first coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching coordinate, or <code>null</code> if a matching coordinate could not be found
	*/
	public Coordinate fetchByShapeId_First(long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator<Coordinate> orderByComparator);

	/**
	* Returns the last coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinate
	* @throws NoSuchCoordinateException if a matching coordinate could not be found
	*/
	public Coordinate findByShapeId_Last(long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator<Coordinate> orderByComparator)
		throws NoSuchCoordinateException;

	/**
	* Returns the last coordinate in the ordered set where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching coordinate, or <code>null</code> if a matching coordinate could not be found
	*/
	public Coordinate fetchByShapeId_Last(long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator<Coordinate> orderByComparator);

	/**
	* Returns the coordinates before and after the current coordinate in the ordered set where shapeId = &#63;.
	*
	* @param coordinateId the primary key of the current coordinate
	* @param shapeId the shape ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next coordinate
	* @throws NoSuchCoordinateException if a coordinate with the primary key could not be found
	*/
	public Coordinate[] findByShapeId_PrevAndNext(long coordinateId,
		long shapeId,
		com.liferay.portal.kernel.util.OrderByComparator<Coordinate> orderByComparator)
		throws NoSuchCoordinateException;

	/**
	* Removes all the coordinates where shapeId = &#63; from the database.
	*
	* @param shapeId the shape ID
	*/
	public void removeByShapeId(long shapeId);

	/**
	* Returns the number of coordinates where shapeId = &#63;.
	*
	* @param shapeId the shape ID
	* @return the number of matching coordinates
	*/
	public int countByShapeId(long shapeId);

	/**
	* Caches the coordinate in the entity cache if it is enabled.
	*
	* @param coordinate the coordinate
	*/
	public void cacheResult(Coordinate coordinate);

	/**
	* Caches the coordinates in the entity cache if it is enabled.
	*
	* @param coordinates the coordinates
	*/
	public void cacheResult(java.util.List<Coordinate> coordinates);

	/**
	* Creates a new coordinate with the primary key. Does not add the coordinate to the database.
	*
	* @param coordinateId the primary key for the new coordinate
	* @return the new coordinate
	*/
	public Coordinate create(long coordinateId);

	/**
	* Removes the coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate that was removed
	* @throws NoSuchCoordinateException if a coordinate with the primary key could not be found
	*/
	public Coordinate remove(long coordinateId)
		throws NoSuchCoordinateException;

	public Coordinate updateImpl(Coordinate coordinate);

	/**
	* Returns the coordinate with the primary key or throws a {@link NoSuchCoordinateException} if it could not be found.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate
	* @throws NoSuchCoordinateException if a coordinate with the primary key could not be found
	*/
	public Coordinate findByPrimaryKey(long coordinateId)
		throws NoSuchCoordinateException;

	/**
	* Returns the coordinate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param coordinateId the primary key of the coordinate
	* @return the coordinate, or <code>null</code> if a coordinate with the primary key could not be found
	*/
	public Coordinate fetchByPrimaryKey(long coordinateId);

	@Override
	public java.util.Map<java.io.Serializable, Coordinate> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the coordinates.
	*
	* @return the coordinates
	*/
	public java.util.List<Coordinate> findAll();

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
	public java.util.List<Coordinate> findAll(int start, int end);

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
	public java.util.List<Coordinate> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coordinate> orderByComparator);

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
	public java.util.List<Coordinate> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coordinate> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the coordinates from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of coordinates.
	*
	* @return the number of coordinates
	*/
	public int countAll();
}