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

import org.politaktiv.map.model.Layer;

import java.util.List;

/**
 * The persistence utility for the layer service. This utility wraps {@link LayerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul Butenko
 * @see LayerPersistence
 * @see LayerPersistenceImpl
 * @generated
 */
public class LayerUtil {
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
	public static void clearCache(Layer layer) {
		getPersistence().clearCache(layer);
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
	public static List<Layer> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Layer> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Layer> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Layer update(Layer layer) throws SystemException {
		return getPersistence().update(layer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Layer update(Layer layer, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(layer, serviceContext);
	}

	/**
	* Returns all the layers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching layers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Layer> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the layers where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.LayerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of layers
	* @param end the upper bound of the range of layers (not inclusive)
	* @return the range of matching layers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Layer> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the layers where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.LayerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of layers
	* @param end the upper bound of the range of layers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Layer> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first layer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layer
	* @throws org.politaktiv.map.NoSuchLayerException if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first layer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last layer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layer
	* @throws org.politaktiv.map.NoSuchLayerException if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last layer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the layers before and after the current layer in the ordered set where userId = &#63;.
	*
	* @param layerId the primary key of the current layer
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layer
	* @throws org.politaktiv.map.NoSuchLayerException if a layer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer[] findByUserId_PrevAndNext(
		long layerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException {
		return getPersistence()
				   .findByUserId_PrevAndNext(layerId, userId, orderByComparator);
	}

	/**
	* Removes all the layers where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of layers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching layers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the layer where label = &#63; or throws a {@link org.politaktiv.map.NoSuchLayerException} if it could not be found.
	*
	* @param label the label
	* @return the matching layer
	* @throws org.politaktiv.map.NoSuchLayerException if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer findByLabel(
		java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException {
		return getPersistence().findByLabel(label);
	}

	/**
	* Returns the layer where label = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param label the label
	* @return the matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer fetchByLabel(
		java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLabel(label);
	}

	/**
	* Returns the layer where label = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param label the label
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer fetchByLabel(
		java.lang.String label, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLabel(label, retrieveFromCache);
	}

	/**
	* Removes the layer where label = &#63; from the database.
	*
	* @param label the label
	* @return the layer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer removeByLabel(
		java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException {
		return getPersistence().removeByLabel(label);
	}

	/**
	* Returns the number of layers where label = &#63;.
	*
	* @param label the label
	* @return the number of matching layers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLabel(java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLabel(label);
	}

	/**
	* Returns the layer where userId = &#63; and label = &#63; or throws a {@link org.politaktiv.map.NoSuchLayerException} if it could not be found.
	*
	* @param userId the user ID
	* @param label the label
	* @return the matching layer
	* @throws org.politaktiv.map.NoSuchLayerException if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer findByUserIdAndLabel(
		long userId, java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException {
		return getPersistence().findByUserIdAndLabel(userId, label);
	}

	/**
	* Returns the layer where userId = &#63; and label = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param label the label
	* @return the matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer fetchByUserIdAndLabel(
		long userId, java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserIdAndLabel(userId, label);
	}

	/**
	* Returns the layer where userId = &#63; and label = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param label the label
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer fetchByUserIdAndLabel(
		long userId, java.lang.String label, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndLabel(userId, label, retrieveFromCache);
	}

	/**
	* Removes the layer where userId = &#63; and label = &#63; from the database.
	*
	* @param userId the user ID
	* @param label the label
	* @return the layer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer removeByUserIdAndLabel(
		long userId, java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException {
		return getPersistence().removeByUserIdAndLabel(userId, label);
	}

	/**
	* Returns the number of layers where userId = &#63; and label = &#63;.
	*
	* @param userId the user ID
	* @param label the label
	* @return the number of matching layers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdAndLabel(long userId, java.lang.String label)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdAndLabel(userId, label);
	}

	/**
	* Caches the layer in the entity cache if it is enabled.
	*
	* @param layer the layer
	*/
	public static void cacheResult(org.politaktiv.map.model.Layer layer) {
		getPersistence().cacheResult(layer);
	}

	/**
	* Caches the layers in the entity cache if it is enabled.
	*
	* @param layers the layers
	*/
	public static void cacheResult(
		java.util.List<org.politaktiv.map.model.Layer> layers) {
		getPersistence().cacheResult(layers);
	}

	/**
	* Creates a new layer with the primary key. Does not add the layer to the database.
	*
	* @param layerId the primary key for the new layer
	* @return the new layer
	*/
	public static org.politaktiv.map.model.Layer create(long layerId) {
		return getPersistence().create(layerId);
	}

	/**
	* Removes the layer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param layerId the primary key of the layer
	* @return the layer that was removed
	* @throws org.politaktiv.map.NoSuchLayerException if a layer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer remove(long layerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException {
		return getPersistence().remove(layerId);
	}

	public static org.politaktiv.map.model.Layer updateImpl(
		org.politaktiv.map.model.Layer layer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(layer);
	}

	/**
	* Returns the layer with the primary key or throws a {@link org.politaktiv.map.NoSuchLayerException} if it could not be found.
	*
	* @param layerId the primary key of the layer
	* @return the layer
	* @throws org.politaktiv.map.NoSuchLayerException if a layer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer findByPrimaryKey(long layerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException {
		return getPersistence().findByPrimaryKey(layerId);
	}

	/**
	* Returns the layer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param layerId the primary key of the layer
	* @return the layer, or <code>null</code> if a layer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.politaktiv.map.model.Layer fetchByPrimaryKey(long layerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(layerId);
	}

	/**
	* Returns all the layers.
	*
	* @return the layers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Layer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the layers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.LayerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of layers
	* @param end the upper bound of the range of layers (not inclusive)
	* @return the range of layers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Layer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the layers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.LayerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of layers
	* @param end the upper bound of the range of layers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of layers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.politaktiv.map.model.Layer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the layers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of layers.
	*
	* @return the number of layers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LayerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LayerPersistence)PortletBeanLocatorUtil.locate(org.politaktiv.map.service.ClpSerializer.getServletContextName(),
					LayerPersistence.class.getName());

			ReferenceRegistry.registerReference(LayerUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LayerPersistence persistence) {
	}

	private static LayerPersistence _persistence;
}