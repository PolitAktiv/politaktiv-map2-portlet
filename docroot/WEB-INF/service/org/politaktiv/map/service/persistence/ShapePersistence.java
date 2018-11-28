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

import org.politaktiv.map.exception.NoSuchShapeException;
import org.politaktiv.map.model.Shape;

/**
 * The persistence interface for the shape service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aleksandar Lukic
 * @see org.politaktiv.map.service.persistence.impl.ShapePersistenceImpl
 * @see ShapeUtil
 * @generated
 */
@ProviderType
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
	*/
	public java.util.List<Shape> findByUserId(long userId);

	/**
	* Returns a range of all the shapes where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @return the range of matching shapes
	*/
	public java.util.List<Shape> findByUserId(long userId, int start, int end);

	/**
	* Returns an ordered range of all the shapes where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shapes
	*/
	public java.util.List<Shape> findByUserId(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator);

	/**
	* Returns an ordered range of all the shapes where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching shapes
	*/
	public java.util.List<Shape> findByUserId(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public Shape findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator)
		throws NoSuchShapeException;

	/**
	* Returns the first shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public Shape fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator);

	/**
	* Returns the last shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public Shape findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator)
		throws NoSuchShapeException;

	/**
	* Returns the last shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public Shape fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator);

	/**
	* Returns the shapes before and after the current shape in the ordered set where userId = &#63;.
	*
	* @param shapeId the primary key of the current shape
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shape
	* @throws NoSuchShapeException if a shape with the primary key could not be found
	*/
	public Shape[] findByUserId_PrevAndNext(long shapeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator)
		throws NoSuchShapeException;

	/**
	* Removes all the shapes where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of shapes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching shapes
	*/
	public int countByUserId(long userId);

	/**
	* Returns all the shapes where layer = &#63;.
	*
	* @param layer the layer
	* @return the matching shapes
	*/
	public java.util.List<Shape> findByLayer(String layer);

	/**
	* Returns a range of all the shapes where layer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layer the layer
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @return the range of matching shapes
	*/
	public java.util.List<Shape> findByLayer(String layer, int start, int end);

	/**
	* Returns an ordered range of all the shapes where layer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layer the layer
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shapes
	*/
	public java.util.List<Shape> findByLayer(String layer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator);

	/**
	* Returns an ordered range of all the shapes where layer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layer the layer
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching shapes
	*/
	public java.util.List<Shape> findByLayer(String layer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public Shape findByLayer_First(String layer,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator)
		throws NoSuchShapeException;

	/**
	* Returns the first shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public Shape fetchByLayer_First(String layer,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator);

	/**
	* Returns the last shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public Shape findByLayer_Last(String layer,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator)
		throws NoSuchShapeException;

	/**
	* Returns the last shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public Shape fetchByLayer_Last(String layer,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator);

	/**
	* Returns the shapes before and after the current shape in the ordered set where layer = &#63;.
	*
	* @param shapeId the primary key of the current shape
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shape
	* @throws NoSuchShapeException if a shape with the primary key could not be found
	*/
	public Shape[] findByLayer_PrevAndNext(long shapeId, String layer,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator)
		throws NoSuchShapeException;

	/**
	* Removes all the shapes where layer = &#63; from the database.
	*
	* @param layer the layer
	*/
	public void removeByLayer(String layer);

	/**
	* Returns the number of shapes where layer = &#63;.
	*
	* @param layer the layer
	* @return the number of matching shapes
	*/
	public int countByLayer(String layer);

	/**
	* Returns all the shapes where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @return the matching shapes
	*/
	public java.util.List<Shape> findByUserIdAndLayer(long userId, String layer);

	/**
	* Returns a range of all the shapes where userId = &#63; and layer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param layer the layer
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @return the range of matching shapes
	*/
	public java.util.List<Shape> findByUserIdAndLayer(long userId,
		String layer, int start, int end);

	/**
	* Returns an ordered range of all the shapes where userId = &#63; and layer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param layer the layer
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shapes
	*/
	public java.util.List<Shape> findByUserIdAndLayer(long userId,
		String layer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator);

	/**
	* Returns an ordered range of all the shapes where userId = &#63; and layer = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param layer the layer
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching shapes
	*/
	public java.util.List<Shape> findByUserIdAndLayer(long userId,
		String layer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public Shape findByUserIdAndLayer_First(long userId, String layer,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator)
		throws NoSuchShapeException;

	/**
	* Returns the first shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public Shape fetchByUserIdAndLayer_First(long userId, String layer,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator);

	/**
	* Returns the last shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public Shape findByUserIdAndLayer_Last(long userId, String layer,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator)
		throws NoSuchShapeException;

	/**
	* Returns the last shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public Shape fetchByUserIdAndLayer_Last(long userId, String layer,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator);

	/**
	* Returns the shapes before and after the current shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param shapeId the primary key of the current shape
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shape
	* @throws NoSuchShapeException if a shape with the primary key could not be found
	*/
	public Shape[] findByUserIdAndLayer_PrevAndNext(long shapeId, long userId,
		String layer,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator)
		throws NoSuchShapeException;

	/**
	* Removes all the shapes where userId = &#63; and layer = &#63; from the database.
	*
	* @param userId the user ID
	* @param layer the layer
	*/
	public void removeByUserIdAndLayer(long userId, String layer);

	/**
	* Returns the number of shapes where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @return the number of matching shapes
	*/
	public int countByUserIdAndLayer(long userId, String layer);

	/**
	* Caches the shape in the entity cache if it is enabled.
	*
	* @param shape the shape
	*/
	public void cacheResult(Shape shape);

	/**
	* Caches the shapes in the entity cache if it is enabled.
	*
	* @param shapes the shapes
	*/
	public void cacheResult(java.util.List<Shape> shapes);

	/**
	* Creates a new shape with the primary key. Does not add the shape to the database.
	*
	* @param shapeId the primary key for the new shape
	* @return the new shape
	*/
	public Shape create(long shapeId);

	/**
	* Removes the shape with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shapeId the primary key of the shape
	* @return the shape that was removed
	* @throws NoSuchShapeException if a shape with the primary key could not be found
	*/
	public Shape remove(long shapeId) throws NoSuchShapeException;

	public Shape updateImpl(Shape shape);

	/**
	* Returns the shape with the primary key or throws a {@link NoSuchShapeException} if it could not be found.
	*
	* @param shapeId the primary key of the shape
	* @return the shape
	* @throws NoSuchShapeException if a shape with the primary key could not be found
	*/
	public Shape findByPrimaryKey(long shapeId) throws NoSuchShapeException;

	/**
	* Returns the shape with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shapeId the primary key of the shape
	* @return the shape, or <code>null</code> if a shape with the primary key could not be found
	*/
	public Shape fetchByPrimaryKey(long shapeId);

	@Override
	public java.util.Map<java.io.Serializable, Shape> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the shapes.
	*
	* @return the shapes
	*/
	public java.util.List<Shape> findAll();

	/**
	* Returns a range of all the shapes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @return the range of shapes
	*/
	public java.util.List<Shape> findAll(int start, int end);

	/**
	* Returns an ordered range of all the shapes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of shapes
	*/
	public java.util.List<Shape> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator);

	/**
	* Returns an ordered range of all the shapes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of shapes
	* @param end the upper bound of the range of shapes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of shapes
	*/
	public java.util.List<Shape> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Shape> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the shapes from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of shapes.
	*
	* @return the number of shapes
	*/
	public int countAll();
}