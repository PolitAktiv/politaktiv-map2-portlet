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

package org.politaktiv.map.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LayerLocalService}.
 *
 * @author Paul Butenko
 * @see LayerLocalService
 * @generated
 */
public class LayerLocalServiceWrapper implements LayerLocalService,
	ServiceWrapper<LayerLocalService> {
	public LayerLocalServiceWrapper(LayerLocalService layerLocalService) {
		_layerLocalService = layerLocalService;
	}

	/**
	* Adds the layer to the database. Also notifies the appropriate model listeners.
	*
	* @param layer the layer
	* @return the layer that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.model.Layer addLayer(
		org.politaktiv.map.model.Layer layer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.addLayer(layer);
	}

	/**
	* Creates a new layer with the primary key. Does not add the layer to the database.
	*
	* @param layerId the primary key for the new layer
	* @return the new layer
	*/
	@Override
	public org.politaktiv.map.model.Layer createLayer(long layerId) {
		return _layerLocalService.createLayer(layerId);
	}

	/**
	* Deletes the layer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param layerId the primary key of the layer
	* @return the layer that was removed
	* @throws PortalException if a layer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.model.Layer deleteLayer(long layerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.deleteLayer(layerId);
	}

	/**
	* Deletes the layer from the database. Also notifies the appropriate model listeners.
	*
	* @param layer the layer
	* @return the layer that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.model.Layer deleteLayer(
		org.politaktiv.map.model.Layer layer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.deleteLayer(layer);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _layerLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.LayerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.LayerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.politaktiv.map.model.Layer fetchLayer(long layerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.fetchLayer(layerId);
	}

	/**
	* Returns the layer with the primary key.
	*
	* @param layerId the primary key of the layer
	* @return the layer
	* @throws PortalException if a layer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.model.Layer getLayer(long layerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.getLayer(layerId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.politaktiv.map.model.Layer> getLayers(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.getLayers(start, end);
	}

	/**
	* Returns the number of layers.
	*
	* @return the number of layers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLayersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.getLayersCount();
	}

	/**
	* Updates the layer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param layer the layer
	* @return the layer that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.politaktiv.map.model.Layer updateLayer(
		org.politaktiv.map.model.Layer layer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _layerLocalService.updateLayer(layer);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _layerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_layerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _layerLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LayerLocalService getWrappedLayerLocalService() {
		return _layerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLayerLocalService(LayerLocalService layerLocalService) {
		_layerLocalService = layerLocalService;
	}

	@Override
	public LayerLocalService getWrappedService() {
		return _layerLocalService;
	}

	@Override
	public void setWrappedService(LayerLocalService layerLocalService) {
		_layerLocalService = layerLocalService;
	}

	private LayerLocalService _layerLocalService;
}