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

import org.politaktiv.map.model.Shape;

import java.util.List;

/**
 * The persistence utility for the shape service. This utility wraps {@link org.politaktiv.map.service.persistence.impl.ShapePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aleksandar Lukic
 * @see ShapePersistence
 * @see org.politaktiv.map.service.persistence.impl.ShapePersistenceImpl
 * @generated
 */
@ProviderType
public class ShapeUtil {
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
	public static void clearCache(Shape shape) {
		getPersistence().clearCache(shape);
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
	public static List<Shape> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Shape> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Shape> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Shape> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Shape update(Shape shape) {
		return getPersistence().update(shape);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Shape update(Shape shape, ServiceContext serviceContext) {
		return getPersistence().update(shape, serviceContext);
	}

	/**
	* Returns all the shapes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching shapes
	*/
	public static List<Shape> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

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
	public static List<Shape> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static List<Shape> findByUserId(long userId, int start, int end,
		OrderByComparator<Shape> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

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
	public static List<Shape> findByUserId(long userId, int start, int end,
		OrderByComparator<Shape> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public static Shape findByUserId_First(long userId,
		OrderByComparator<Shape> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchShapeException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public static Shape fetchByUserId_First(long userId,
		OrderByComparator<Shape> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public static Shape findByUserId_Last(long userId,
		OrderByComparator<Shape> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchShapeException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public static Shape fetchByUserId_Last(long userId,
		OrderByComparator<Shape> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the shapes before and after the current shape in the ordered set where userId = &#63;.
	*
	* @param shapeId the primary key of the current shape
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shape
	* @throws NoSuchShapeException if a shape with the primary key could not be found
	*/
	public static Shape[] findByUserId_PrevAndNext(long shapeId, long userId,
		OrderByComparator<Shape> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchShapeException {
		return getPersistence()
				   .findByUserId_PrevAndNext(shapeId, userId, orderByComparator);
	}

	/**
	* Removes all the shapes where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of shapes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching shapes
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the shapes where layer = &#63;.
	*
	* @param layer the layer
	* @return the matching shapes
	*/
	public static List<Shape> findByLayer(String layer) {
		return getPersistence().findByLayer(layer);
	}

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
	public static List<Shape> findByLayer(String layer, int start, int end) {
		return getPersistence().findByLayer(layer, start, end);
	}

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
	public static List<Shape> findByLayer(String layer, int start, int end,
		OrderByComparator<Shape> orderByComparator) {
		return getPersistence().findByLayer(layer, start, end, orderByComparator);
	}

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
	public static List<Shape> findByLayer(String layer, int start, int end,
		OrderByComparator<Shape> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByLayer(layer, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public static Shape findByLayer_First(String layer,
		OrderByComparator<Shape> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchShapeException {
		return getPersistence().findByLayer_First(layer, orderByComparator);
	}

	/**
	* Returns the first shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public static Shape fetchByLayer_First(String layer,
		OrderByComparator<Shape> orderByComparator) {
		return getPersistence().fetchByLayer_First(layer, orderByComparator);
	}

	/**
	* Returns the last shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public static Shape findByLayer_Last(String layer,
		OrderByComparator<Shape> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchShapeException {
		return getPersistence().findByLayer_Last(layer, orderByComparator);
	}

	/**
	* Returns the last shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public static Shape fetchByLayer_Last(String layer,
		OrderByComparator<Shape> orderByComparator) {
		return getPersistence().fetchByLayer_Last(layer, orderByComparator);
	}

	/**
	* Returns the shapes before and after the current shape in the ordered set where layer = &#63;.
	*
	* @param shapeId the primary key of the current shape
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shape
	* @throws NoSuchShapeException if a shape with the primary key could not be found
	*/
	public static Shape[] findByLayer_PrevAndNext(long shapeId, String layer,
		OrderByComparator<Shape> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchShapeException {
		return getPersistence()
				   .findByLayer_PrevAndNext(shapeId, layer, orderByComparator);
	}

	/**
	* Removes all the shapes where layer = &#63; from the database.
	*
	* @param layer the layer
	*/
	public static void removeByLayer(String layer) {
		getPersistence().removeByLayer(layer);
	}

	/**
	* Returns the number of shapes where layer = &#63;.
	*
	* @param layer the layer
	* @return the number of matching shapes
	*/
	public static int countByLayer(String layer) {
		return getPersistence().countByLayer(layer);
	}

	/**
	* Returns all the shapes where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @return the matching shapes
	*/
	public static List<Shape> findByUserIdAndLayer(long userId, String layer) {
		return getPersistence().findByUserIdAndLayer(userId, layer);
	}

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
	public static List<Shape> findByUserIdAndLayer(long userId, String layer,
		int start, int end) {
		return getPersistence().findByUserIdAndLayer(userId, layer, start, end);
	}

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
	public static List<Shape> findByUserIdAndLayer(long userId, String layer,
		int start, int end, OrderByComparator<Shape> orderByComparator) {
		return getPersistence()
				   .findByUserIdAndLayer(userId, layer, start, end,
			orderByComparator);
	}

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
	public static List<Shape> findByUserIdAndLayer(long userId, String layer,
		int start, int end, OrderByComparator<Shape> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserIdAndLayer(userId, layer, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public static Shape findByUserIdAndLayer_First(long userId, String layer,
		OrderByComparator<Shape> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchShapeException {
		return getPersistence()
				   .findByUserIdAndLayer_First(userId, layer, orderByComparator);
	}

	/**
	* Returns the first shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public static Shape fetchByUserIdAndLayer_First(long userId, String layer,
		OrderByComparator<Shape> orderByComparator) {
		return getPersistence()
				   .fetchByUserIdAndLayer_First(userId, layer, orderByComparator);
	}

	/**
	* Returns the last shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws NoSuchShapeException if a matching shape could not be found
	*/
	public static Shape findByUserIdAndLayer_Last(long userId, String layer,
		OrderByComparator<Shape> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchShapeException {
		return getPersistence()
				   .findByUserIdAndLayer_Last(userId, layer, orderByComparator);
	}

	/**
	* Returns the last shape in the ordered set where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	*/
	public static Shape fetchByUserIdAndLayer_Last(long userId, String layer,
		OrderByComparator<Shape> orderByComparator) {
		return getPersistence()
				   .fetchByUserIdAndLayer_Last(userId, layer, orderByComparator);
	}

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
	public static Shape[] findByUserIdAndLayer_PrevAndNext(long shapeId,
		long userId, String layer, OrderByComparator<Shape> orderByComparator)
		throws org.politaktiv.map.exception.NoSuchShapeException {
		return getPersistence()
				   .findByUserIdAndLayer_PrevAndNext(shapeId, userId, layer,
			orderByComparator);
	}

	/**
	* Removes all the shapes where userId = &#63; and layer = &#63; from the database.
	*
	* @param userId the user ID
	* @param layer the layer
	*/
	public static void removeByUserIdAndLayer(long userId, String layer) {
		getPersistence().removeByUserIdAndLayer(userId, layer);
	}

	/**
	* Returns the number of shapes where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @return the number of matching shapes
	*/
	public static int countByUserIdAndLayer(long userId, String layer) {
		return getPersistence().countByUserIdAndLayer(userId, layer);
	}

	/**
	* Caches the shape in the entity cache if it is enabled.
	*
	* @param shape the shape
	*/
	public static void cacheResult(Shape shape) {
		getPersistence().cacheResult(shape);
	}

	/**
	* Caches the shapes in the entity cache if it is enabled.
	*
	* @param shapes the shapes
	*/
	public static void cacheResult(List<Shape> shapes) {
		getPersistence().cacheResult(shapes);
	}

	/**
	* Creates a new shape with the primary key. Does not add the shape to the database.
	*
	* @param shapeId the primary key for the new shape
	* @return the new shape
	*/
	public static Shape create(long shapeId) {
		return getPersistence().create(shapeId);
	}

	/**
	* Removes the shape with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shapeId the primary key of the shape
	* @return the shape that was removed
	* @throws NoSuchShapeException if a shape with the primary key could not be found
	*/
	public static Shape remove(long shapeId)
		throws org.politaktiv.map.exception.NoSuchShapeException {
		return getPersistence().remove(shapeId);
	}

	public static Shape updateImpl(Shape shape) {
		return getPersistence().updateImpl(shape);
	}

	/**
	* Returns the shape with the primary key or throws a {@link NoSuchShapeException} if it could not be found.
	*
	* @param shapeId the primary key of the shape
	* @return the shape
	* @throws NoSuchShapeException if a shape with the primary key could not be found
	*/
	public static Shape findByPrimaryKey(long shapeId)
		throws org.politaktiv.map.exception.NoSuchShapeException {
		return getPersistence().findByPrimaryKey(shapeId);
	}

	/**
	* Returns the shape with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shapeId the primary key of the shape
	* @return the shape, or <code>null</code> if a shape with the primary key could not be found
	*/
	public static Shape fetchByPrimaryKey(long shapeId) {
		return getPersistence().fetchByPrimaryKey(shapeId);
	}

	public static java.util.Map<java.io.Serializable, Shape> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the shapes.
	*
	* @return the shapes
	*/
	public static List<Shape> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Shape> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Shape> findAll(int start, int end,
		OrderByComparator<Shape> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Shape> findAll(int start, int end,
		OrderByComparator<Shape> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the shapes from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of shapes.
	*
	* @return the number of shapes
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ShapePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ShapePersistence)PortletBeanLocatorUtil.locate(org.politaktiv.map.service.ServletContextUtil.getServletContextName(),
					ShapePersistence.class.getName());

			ReferenceRegistry.registerReference(ShapeUtil.class, "_persistence");
		}

		return _persistence;
	}

	private static ShapePersistence _persistence;
}