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

import org.politaktiv.map.model.Marker;

/**
 * The persistence interface for the marker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul Butenko
 * @see MarkerPersistenceImpl
 * @see MarkerUtil
 * @generated
 */
public interface MarkerPersistence extends BasePersistence<Marker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MarkerUtil} to access the marker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the markers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Marker> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the markers where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of markers
	* @param end the upper bound of the range of markers (not inclusive)
	* @return the range of matching markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Marker> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the markers where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of markers
	* @param end the upper bound of the range of markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Marker> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first marker in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marker
	* @throws org.politaktiv.map.NoSuchMarkerException if a matching marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Marker findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchMarkerException;

	/**
	* Returns the first marker in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching marker, or <code>null</code> if a matching marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Marker fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last marker in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marker
	* @throws org.politaktiv.map.NoSuchMarkerException if a matching marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Marker findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchMarkerException;

	/**
	* Returns the last marker in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching marker, or <code>null</code> if a matching marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Marker fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the markers before and after the current marker in the ordered set where userId = &#63;.
	*
	* @param markerId the primary key of the current marker
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next marker
	* @throws org.politaktiv.map.NoSuchMarkerException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Marker[] findByUserId_PrevAndNext(
		long markerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchMarkerException;

	/**
	* Removes all the markers where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of markers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching markers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the marker in the entity cache if it is enabled.
	*
	* @param marker the marker
	*/
	public void cacheResult(org.politaktiv.map.model.Marker marker);

	/**
	* Caches the markers in the entity cache if it is enabled.
	*
	* @param markers the markers
	*/
	public void cacheResult(
		java.util.List<org.politaktiv.map.model.Marker> markers);

	/**
	* Creates a new marker with the primary key. Does not add the marker to the database.
	*
	* @param markerId the primary key for the new marker
	* @return the new marker
	*/
	public org.politaktiv.map.model.Marker create(long markerId);

	/**
	* Removes the marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param markerId the primary key of the marker
	* @return the marker that was removed
	* @throws org.politaktiv.map.NoSuchMarkerException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Marker remove(long markerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchMarkerException;

	public org.politaktiv.map.model.Marker updateImpl(
		org.politaktiv.map.model.Marker marker)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the marker with the primary key or throws a {@link org.politaktiv.map.NoSuchMarkerException} if it could not be found.
	*
	* @param markerId the primary key of the marker
	* @return the marker
	* @throws org.politaktiv.map.NoSuchMarkerException if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Marker findByPrimaryKey(long markerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchMarkerException;

	/**
	* Returns the marker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param markerId the primary key of the marker
	* @return the marker, or <code>null</code> if a marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Marker fetchByPrimaryKey(long markerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the markers.
	*
	* @return the markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Marker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.model.Marker> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of markers
	* @param end the upper bound of the range of markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of markers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Marker> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the markers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of markers.
	*
	* @return the number of markers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}