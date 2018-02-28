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

import org.politaktiv.map.model.Shape;

import java.util.List;

/**
 * The persistence utility for the shape service. This utility wraps {@link ShapePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul Butenko
 * @see ShapePersistence
 * @see ShapePersistenceImpl
 * @generated
 */
public class ShapeUtil {
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
	public static void clearCache(Shape shape) {
		getPersistence().clearCache(shape);
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
	public static List<Shape> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Shape> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Shape> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Shape update(Shape shape) throws SystemException {
		return getPersistence().update(shape);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Shape update(Shape shape, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(shape, serviceContext);
	}

	/**
	* Returns all the shapes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Shape> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

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
	public static java.util.List<org.politaktiv.map.model.Shape> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static java.util.List<org.politaktiv.map.model.Shape> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last shape in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

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
	public static org.politaktiv.map.model.Shape[] findByUserId_PrevAndNext(
		long shapeId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence()
				   .findByUserId_PrevAndNext(shapeId, userId, orderByComparator);
	}

	/**
	* Removes all the shapes where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of shapes where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the shapes where layer = &#63;.
	*
	* @param layer the layer
	* @return the matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Shape> findByLayer(
		java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLayer(layer);
	}

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
	public static java.util.List<org.politaktiv.map.model.Shape> findByLayer(
		java.lang.String layer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLayer(layer, start, end);
	}

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
	public static java.util.List<org.politaktiv.map.model.Shape> findByLayer(
		java.lang.String layer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLayer(layer, start, end, orderByComparator);
	}

	/**
	* Returns the first shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape findByLayer_First(
		java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence().findByLayer_First(layer, orderByComparator);
	}

	/**
	* Returns the first shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape fetchByLayer_First(
		java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLayer_First(layer, orderByComparator);
	}

	/**
	* Returns the last shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape findByLayer_Last(
		java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence().findByLayer_Last(layer, orderByComparator);
	}

	/**
	* Returns the last shape in the ordered set where layer = &#63;.
	*
	* @param layer the layer
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shape, or <code>null</code> if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape fetchByLayer_Last(
		java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLayer_Last(layer, orderByComparator);
	}

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
	public static org.politaktiv.map.model.Shape[] findByLayer_PrevAndNext(
		long shapeId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence()
				   .findByLayer_PrevAndNext(shapeId, layer, orderByComparator);
	}

	/**
	* Removes all the shapes where layer = &#63; from the database.
	*
	* @param layer the layer
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLayer(java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLayer(layer);
	}

	/**
	* Returns the number of shapes where layer = &#63;.
	*
	* @param layer the layer
	* @return the number of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLayer(java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLayer(layer);
	}

	/**
	* Returns all the shapes where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @return the matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayer(
		long userId, java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdAndLayer(userId, layer);
	}

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
	public static java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayer(
		long userId, java.lang.String layer, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdAndLayer(userId, layer, start, end);
	}

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
	public static java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayer(
		long userId, java.lang.String layer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdAndLayer(userId, layer, start, end,
			orderByComparator);
	}

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
	public static org.politaktiv.map.model.Shape findByUserIdAndLayer_First(
		long userId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
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
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape fetchByUserIdAndLayer_First(
		long userId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape findByUserIdAndLayer_Last(
		long userId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
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
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape fetchByUserIdAndLayer_Last(
		long userId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
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
	* @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape[] findByUserIdAndLayer_PrevAndNext(
		long shapeId, long userId, java.lang.String layer,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence()
				   .findByUserIdAndLayer_PrevAndNext(shapeId, userId, layer,
			orderByComparator);
	}

	/**
	* Removes all the shapes where userId = &#63; and layer = &#63; from the database.
	*
	* @param userId the user ID
	* @param layer the layer
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdAndLayer(long userId,
		java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdAndLayer(userId, layer);
	}

	/**
	* Returns the number of shapes where userId = &#63; and layer = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @return the number of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdAndLayer(long userId, java.lang.String layer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdAndLayer(userId, layer);
	}

	/**
	* Returns all the shapes where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @return the matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayerAndPortletInstance(
		long userId, java.lang.String layer, java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdAndLayerAndPortletInstance(userId, layer,
			portletInstance);
	}

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
	public static java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayerAndPortletInstance(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdAndLayerAndPortletInstance(userId, layer,
			portletInstance, start, end);
	}

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
	public static java.util.List<org.politaktiv.map.model.Shape> findByUserIdAndLayerAndPortletInstance(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdAndLayerAndPortletInstance(userId, layer,
			portletInstance, start, end, orderByComparator);
	}

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
	public static org.politaktiv.map.model.Shape findByUserIdAndLayerAndPortletInstance_First(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence()
				   .findByUserIdAndLayerAndPortletInstance_First(userId, layer,
			portletInstance, orderByComparator);
	}

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
	public static org.politaktiv.map.model.Shape fetchByUserIdAndLayerAndPortletInstance_First(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndLayerAndPortletInstance_First(userId,
			layer, portletInstance, orderByComparator);
	}

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
	public static org.politaktiv.map.model.Shape findByUserIdAndLayerAndPortletInstance_Last(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence()
				   .findByUserIdAndLayerAndPortletInstance_Last(userId, layer,
			portletInstance, orderByComparator);
	}

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
	public static org.politaktiv.map.model.Shape fetchByUserIdAndLayerAndPortletInstance_Last(
		long userId, java.lang.String layer, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndLayerAndPortletInstance_Last(userId, layer,
			portletInstance, orderByComparator);
	}

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
	public static org.politaktiv.map.model.Shape[] findByUserIdAndLayerAndPortletInstance_PrevAndNext(
		long shapeId, long userId, java.lang.String layer,
		java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence()
				   .findByUserIdAndLayerAndPortletInstance_PrevAndNext(shapeId,
			userId, layer, portletInstance, orderByComparator);
	}

	/**
	* Removes all the shapes where userId = &#63; and layer = &#63; and portletInstance = &#63; from the database.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdAndLayerAndPortletInstance(long userId,
		java.lang.String layer, java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByUserIdAndLayerAndPortletInstance(userId, layer,
			portletInstance);
	}

	/**
	* Returns the number of shapes where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param layer the layer
	* @param portletInstance the portlet instance
	* @return the number of matching shapes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdAndLayerAndPortletInstance(long userId,
		java.lang.String layer, java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserIdAndLayerAndPortletInstance(userId, layer,
			portletInstance);
	}

	/**
	* Caches the shape in the entity cache if it is enabled.
	*
	* @param shape the shape
	*/
	public static void cacheResult(org.politaktiv.map.model.Shape shape) {
		getPersistence().cacheResult(shape);
	}

	/**
	* Caches the shapes in the entity cache if it is enabled.
	*
	* @param shapes the shapes
	*/
	public static void cacheResult(
		java.util.List<org.politaktiv.map.model.Shape> shapes) {
		getPersistence().cacheResult(shapes);
	}

	/**
	* Creates a new shape with the primary key. Does not add the shape to the database.
	*
	* @param shapeId the primary key for the new shape
	* @return the new shape
	*/
	public static org.politaktiv.map.model.Shape create(long shapeId) {
		return getPersistence().create(shapeId);
	}

	/**
	* Removes the shape with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param shapeId the primary key of the shape
	* @return the shape that was removed
	* @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape remove(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence().remove(shapeId);
	}

	public static org.politaktiv.map.model.Shape updateImpl(
		org.politaktiv.map.model.Shape shape)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(shape);
	}

	/**
	* Returns the shape with the primary key or throws a {@link org.politaktiv.map.NoSuchShapeException} if it could not be found.
	*
	* @param shapeId the primary key of the shape
	* @return the shape
	* @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape findByPrimaryKey(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchShapeException {
		return getPersistence().findByPrimaryKey(shapeId);
	}

	/**
	* Returns the shape with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param shapeId the primary key of the shape
	* @return the shape, or <code>null</code> if a shape with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Shape fetchByPrimaryKey(long shapeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(shapeId);
	}

	/**
	* Returns all the shapes.
	*
	* @return the shapes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Shape> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.politaktiv.map.model.Shape> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.politaktiv.map.model.Shape> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the shapes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of shapes.
	*
	* @return the number of shapes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ShapePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ShapePersistence)PortletBeanLocatorUtil.locate(org.politaktiv.map.service.ClpSerializer.getServletContextName(),
					ShapePersistence.class.getName());

			ReferenceRegistry.registerReference(ShapeUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ShapePersistence persistence) {
	}

	private static ShapePersistence _persistence;
}