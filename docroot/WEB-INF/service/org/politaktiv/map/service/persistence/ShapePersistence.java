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

import org.politaktiv.map.model.Shape;

/**
 * The persistence interface for the shape service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul Butenko
 * @see ShapePersistenceImpl
 * @see ShapeUtil
 * @generated
 */
public interface ShapePersistence extends BasePersistence<Shape> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShapeUtil} to access the shape persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the shapes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shapes where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @return the range of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shapes where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Returns the first shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Returns the last shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shapes before and after the current shape in the ordered set where userId = &#63;.
	*
	* @param shapeId the primary key of the current shape
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shape
	* @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape[] findByUserId_PrevAndNext(
		long shapeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Removes all the shapes where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shapes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shapes where layer = &#63;.
	*
	* @param layer the layer
	* @return the matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByLayer(
		java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shapes where layer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layer the layer
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @return the range of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByLayer(
		java.lang.String layer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shapes where layer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layer the layer
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByLayer(
		java.lang.String layer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape findByLayer_First(
		java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Returns the first shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape fetchByLayer_First(
		java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape findByLayer_Last(
		java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Returns the last shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape fetchByLayer_Last(
		java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shapes before and after the current shape in the ordered set where layer = &#63;.
	*
	* @param shapeId the primary key of the current shape
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shape
	* @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape[] findByLayer_PrevAndNext(
		long shapeId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Removes all the shapes where layer = &#63; from the database.
	*
	* @param layer the layer
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLayer(java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shapes where layer = &#63;.
	*
	* @param layer the layer
	* @return the number of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public int countByLayer(java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shapes where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @return the matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayer(
		long userId, java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shapes where userId = &#63; and layer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param layer the layer
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @return the range of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayer(
		long userId, java.lang.String layer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shapes where userId = &#63; and layer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param layer the layer
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayer(
		long userId, java.lang.String layer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape findByUserIdAndLayer_First(
		long userId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Returns the first shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape fetchByUserIdAndLayer_First(
		long userId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape findByUserIdAndLayer_Last(
		long userId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Returns the last shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape fetchByUserIdAndLayer_Last(
		long userId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shapes before and after the current shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param shapeId the primary key of the current shape
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shape
	* @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape[] findByUserIdAndLayer_PrevAndNext(
		long shapeId, long userId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Removes all the shapes where userId = &#63; and layer = &#63; from the database.
	*
	* @param userId the user ID
	* @param layer the layer
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdAndLayer(long userId, java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shapes where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @return the number of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndLayer(long userId, java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shapes where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @return the matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayerAndPortletInstance(
		long userId, java.lang.String layer, java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shapes where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @return the range of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayerAndPortletInstance(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shapes where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayerAndPortletInstance(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first shape in the ordered set where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape findByUserIdAndLayerAndPortletInstance_First(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Returns the first shape in the ordered set where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape fetchByUserIdAndLayerAndPortletInstance_First(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last shape in the ordered set where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape findByUserIdAndLayerAndPortletInstance_Last(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Returns the last shape in the ordered set where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape fetchByUserIdAndLayerAndPortletInstance_Last(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shapes before and after the current shape in the ordered set where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	*
	* @param shapeId the primary key of the current shape
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shape
	* @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape[] findByUserIdAndLayerAndPortletInstance_PrevAndNext(
		long shapeId, long userId, java.lang.String layer,
		java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Removes all the shapes where userId = &#63; and layer = &#63; and portletInstance = &#63; from the database.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdAndLayerAndPortletInstance(long userId,
		java.lang.String layer, java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shapes where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @return the number of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndLayerAndPortletInstance(long userId,
		java.lang.String layer, java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the shape in the entity cache if it is enabled.
	*
	* @param shape the shape
	*/
	public void cacheResult(org.politaktiv.map.model.Shape shape);

	/**
	* Caches the shapes in the entity cache if it is enabled.
	*
	* @param shapes the shapes
	*/
	public void cacheResult(
		java.util.List<org.politaktiv.map.model.Shape> shapes);

	/**
	* Creates a new shape with the primary key. Does not add the shape to the database.
	*
	* @param shapeId the primary key for the new shape
	* @return the new shape
	*/
	public org.politaktiv.map.model.Shape create(long shapeId);

	/**
	* Removes the shape with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shapeId the primary key of the shape
	* @return the shape that was removed
	* @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape remove(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	public org.politaktiv.map.model.Shape updateImpl(
		org.politaktiv.map.model.Shape shape)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shape with the primary key or throws a {@link org.politaktiv.map.NoSuchShapeException} if it could not be found.
	*
	* @param shapeId the primary key of the shape
	* @return the shape
	* @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape findByPrimaryKey(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException;

	/**
	* Returns the shape with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shapeId the primary key of the shape
	* @return the shape, or <code>null</code> if a shape with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Shape fetchByPrimaryKey(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shapes.
	*
	* @return the shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shapes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @return the range of shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shapes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of shapes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Shape> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shapes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shapes.
	*
	* @return the number of shapes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}