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

import org.politaktiv.map.model.Layer;

/**
 * The persistence interface for the layer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul Butenko
 * @see LayerPersistenceImpl
 * @see LayerUtil
 * @generated
 */
public interface LayerPersistence extends BasePersistence<Layer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LayerUtil} to access the layer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the layers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching layers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Layer> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.model.Layer> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.model.Layer> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first layer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layer
	* @throws org.politaktiv.map.NoSuchLayerException if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException;

	/**
	* Returns the first layer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last layer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layer
	* @throws org.politaktiv.map.NoSuchLayerException if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException;

	/**
	* Returns the last layer in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.politaktiv.map.model.Layer[] findByUserId_PrevAndNext(
		long layerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException;

	/**
	* Removes all the layers where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of layers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching layers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the layers where userId = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param portletInstance the portlet instance
	* @return the matching layers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Layer> findByUserIdAndPortletInstance(
		long userId, java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the layers where userId = &#63; and portletInstance = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.LayerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param portletInstance the portlet instance
	* @param start the lower bound of the range of layers
	* @param end the upper bound of the range of layers (not inclusive)
	* @return the range of matching layers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Layer> findByUserIdAndPortletInstance(
		long userId, java.lang.String portletInstance, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the layers where userId = &#63; and portletInstance = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.LayerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param portletInstance the portlet instance
	* @param start the lower bound of the range of layers
	* @param end the upper bound of the range of layers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Layer> findByUserIdAndPortletInstance(
		long userId, java.lang.String portletInstance, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first layer in the ordered set where userId = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param portletInstance the portlet instance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layer
	* @throws org.politaktiv.map.NoSuchLayerException if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer findByUserIdAndPortletInstance_First(
		long userId, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException;

	/**
	* Returns the first layer in the ordered set where userId = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param portletInstance the portlet instance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer fetchByUserIdAndPortletInstance_First(
		long userId, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last layer in the ordered set where userId = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param portletInstance the portlet instance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layer
	* @throws org.politaktiv.map.NoSuchLayerException if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer findByUserIdAndPortletInstance_Last(
		long userId, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException;

	/**
	* Returns the last layer in the ordered set where userId = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param portletInstance the portlet instance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer fetchByUserIdAndPortletInstance_Last(
		long userId, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the layers before and after the current layer in the ordered set where userId = &#63; and portletInstance = &#63;.
	*
	* @param layerId the primary key of the current layer
	* @param userId the user ID
	* @param portletInstance the portlet instance
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layer
	* @throws org.politaktiv.map.NoSuchLayerException if a layer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer[] findByUserIdAndPortletInstance_PrevAndNext(
		long layerId, long userId, java.lang.String portletInstance,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException;

	/**
	* Removes all the layers where userId = &#63; and portletInstance = &#63; from the database.
	*
	* @param userId the user ID
	* @param portletInstance the portlet instance
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdAndPortletInstance(long userId,
		java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of layers where userId = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param portletInstance the portlet instance
	* @return the number of matching layers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndPortletInstance(long userId,
		java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the layer where userId = &#63; and label = &#63; and portletInstance = &#63; or throws a {@link org.politaktiv.map.NoSuchLayerException} if it could not be found.
	*
	* @param userId the user ID
	* @param label the label
	* @param portletInstance the portlet instance
	* @return the matching layer
	* @throws org.politaktiv.map.NoSuchLayerException if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer findByUserIdAndLabelAndPortletInstance(
		long userId, java.lang.String label, java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException;

	/**
	* Returns the layer where userId = &#63; and label = &#63; and portletInstance = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param label the label
	* @param portletInstance the portlet instance
	* @return the matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer fetchByUserIdAndLabelAndPortletInstance(
		long userId, java.lang.String label, java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the layer where userId = &#63; and label = &#63; and portletInstance = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param label the label
	* @param portletInstance the portlet instance
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching layer, or <code>null</code> if a matching layer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer fetchByUserIdAndLabelAndPortletInstance(
		long userId, java.lang.String label, java.lang.String portletInstance,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the layer where userId = &#63; and label = &#63; and portletInstance = &#63; from the database.
	*
	* @param userId the user ID
	* @param label the label
	* @param portletInstance the portlet instance
	* @return the layer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer removeByUserIdAndLabelAndPortletInstance(
		long userId, java.lang.String label, java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException;

	/**
	* Returns the number of layers where userId = &#63; and label = &#63; and portletInstance = &#63;.
	*
	* @param userId the user ID
	* @param label the label
	* @param portletInstance the portlet instance
	* @return the number of matching layers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndLabelAndPortletInstance(long userId,
		java.lang.String label, java.lang.String portletInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the layer in the entity cache if it is enabled.
	*
	* @param layer the layer
	*/
	public void cacheResult(org.politaktiv.map.model.Layer layer);

	/**
	* Caches the layers in the entity cache if it is enabled.
	*
	* @param layers the layers
	*/
	public void cacheResult(
		java.util.List<org.politaktiv.map.model.Layer> layers);

	/**
	* Creates a new layer with the primary key. Does not add the layer to the database.
	*
	* @param layerId the primary key for the new layer
	* @return the new layer
	*/
	public org.politaktiv.map.model.Layer create(long layerId);

	/**
	* Removes the layer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param layerId the primary key of the layer
	* @return the layer that was removed
	* @throws org.politaktiv.map.NoSuchLayerException if a layer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer remove(long layerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException;

	public org.politaktiv.map.model.Layer updateImpl(
		org.politaktiv.map.model.Layer layer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the layer with the primary key or throws a {@link org.politaktiv.map.NoSuchLayerException} if it could not be found.
	*
	* @param layerId the primary key of the layer
	* @return the layer
	* @throws org.politaktiv.map.NoSuchLayerException if a layer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer findByPrimaryKey(long layerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.politaktiv.map.NoSuchLayerException;

	/**
	* Returns the layer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param layerId the primary key of the layer
	* @return the layer, or <code>null</code> if a layer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.politaktiv.map.model.Layer fetchByPrimaryKey(long layerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the layers.
	*
	* @return the layers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.politaktiv.map.model.Layer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.model.Layer> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.politaktiv.map.model.Layer> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the layers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of layers.
	*
	* @return the number of layers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}