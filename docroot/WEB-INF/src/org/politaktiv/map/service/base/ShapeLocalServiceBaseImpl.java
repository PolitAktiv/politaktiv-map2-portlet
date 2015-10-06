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

package org.politaktiv.map.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import org.politaktiv.map.model.Shape;
import org.politaktiv.map.service.ShapeLocalService;
import org.politaktiv.map.service.persistence.CoordinatePersistence;
import org.politaktiv.map.service.persistence.ShapePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the shape local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.politaktiv.map.service.impl.ShapeLocalServiceImpl}.
 * </p>
 *
 * @author Paul Butenko
 * @see org.politaktiv.map.service.impl.ShapeLocalServiceImpl
 * @see org.politaktiv.map.service.ShapeLocalServiceUtil
 * @generated
 */
public abstract class ShapeLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements ShapeLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.politaktiv.map.service.ShapeLocalServiceUtil} to access the shape local service.
	 */

	/**
	 * Adds the shape to the database. Also notifies the appropriate model listeners.
	 *
	 * @param shape the shape
	 * @return the shape that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Shape addShape(Shape shape) throws SystemException {
		shape.setNew(true);

		return shapePersistence.update(shape);
	}

	/**
	 * Creates a new shape with the primary key. Does not add the shape to the database.
	 *
	 * @param shapeId the primary key for the new shape
	 * @return the new shape
	 */
	@Override
	public Shape createShape(long shapeId) {
		return shapePersistence.create(shapeId);
	}

	/**
	 * Deletes the shape with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shapeId the primary key of the shape
	 * @return the shape that was removed
	 * @throws PortalException if a shape with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Shape deleteShape(long shapeId)
		throws PortalException, SystemException {
		return shapePersistence.remove(shapeId);
	}

	/**
	 * Deletes the shape from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shape the shape
	 * @return the shape that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Shape deleteShape(Shape shape) throws SystemException {
		return shapePersistence.remove(shape);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Shape.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return shapePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return shapePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.ShapeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return shapePersistence.findWithDynamicQuery(dynamicQuery, start, end,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return shapePersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return shapePersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Shape fetchShape(long shapeId) throws SystemException {
		return shapePersistence.fetchByPrimaryKey(shapeId);
	}

	/**
	 * Returns the shape with the primary key.
	 *
	 * @param shapeId the primary key of the shape
	 * @return the shape
	 * @throws PortalException if a shape with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape getShape(long shapeId) throws PortalException, SystemException {
		return shapePersistence.findByPrimaryKey(shapeId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return shapePersistence.findByPrimaryKey(primaryKeyObj);
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
	@Override
	public List<Shape> getShapes(int start, int end) throws SystemException {
		return shapePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of shapes.
	 *
	 * @return the number of shapes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getShapesCount() throws SystemException {
		return shapePersistence.countAll();
	}

	/**
	 * Updates the shape in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param shape the shape
	 * @return the shape that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Shape updateShape(Shape shape) throws SystemException {
		return shapePersistence.update(shape);
	}

	/**
	 * Returns the coordinate local service.
	 *
	 * @return the coordinate local service
	 */
	public org.politaktiv.map.service.CoordinateLocalService getCoordinateLocalService() {
		return coordinateLocalService;
	}

	/**
	 * Sets the coordinate local service.
	 *
	 * @param coordinateLocalService the coordinate local service
	 */
	public void setCoordinateLocalService(
		org.politaktiv.map.service.CoordinateLocalService coordinateLocalService) {
		this.coordinateLocalService = coordinateLocalService;
	}

	/**
	 * Returns the coordinate remote service.
	 *
	 * @return the coordinate remote service
	 */
	public org.politaktiv.map.service.CoordinateService getCoordinateService() {
		return coordinateService;
	}

	/**
	 * Sets the coordinate remote service.
	 *
	 * @param coordinateService the coordinate remote service
	 */
	public void setCoordinateService(
		org.politaktiv.map.service.CoordinateService coordinateService) {
		this.coordinateService = coordinateService;
	}

	/**
	 * Returns the coordinate persistence.
	 *
	 * @return the coordinate persistence
	 */
	public CoordinatePersistence getCoordinatePersistence() {
		return coordinatePersistence;
	}

	/**
	 * Sets the coordinate persistence.
	 *
	 * @param coordinatePersistence the coordinate persistence
	 */
	public void setCoordinatePersistence(
		CoordinatePersistence coordinatePersistence) {
		this.coordinatePersistence = coordinatePersistence;
	}

	/**
	 * Returns the shape local service.
	 *
	 * @return the shape local service
	 */
	public org.politaktiv.map.service.ShapeLocalService getShapeLocalService() {
		return shapeLocalService;
	}

	/**
	 * Sets the shape local service.
	 *
	 * @param shapeLocalService the shape local service
	 */
	public void setShapeLocalService(
		org.politaktiv.map.service.ShapeLocalService shapeLocalService) {
		this.shapeLocalService = shapeLocalService;
	}

	/**
	 * Returns the shape remote service.
	 *
	 * @return the shape remote service
	 */
	public org.politaktiv.map.service.ShapeService getShapeService() {
		return shapeService;
	}

	/**
	 * Sets the shape remote service.
	 *
	 * @param shapeService the shape remote service
	 */
	public void setShapeService(
		org.politaktiv.map.service.ShapeService shapeService) {
		this.shapeService = shapeService;
	}

	/**
	 * Returns the shape persistence.
	 *
	 * @return the shape persistence
	 */
	public ShapePersistence getShapePersistence() {
		return shapePersistence;
	}

	/**
	 * Sets the shape persistence.
	 *
	 * @param shapePersistence the shape persistence
	 */
	public void setShapePersistence(ShapePersistence shapePersistence) {
		this.shapePersistence = shapePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("org.politaktiv.map.model.Shape",
			shapeLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.politaktiv.map.model.Shape");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Shape.class;
	}

	protected String getModelClassName() {
		return Shape.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = shapePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.politaktiv.map.service.CoordinateLocalService.class)
	protected org.politaktiv.map.service.CoordinateLocalService coordinateLocalService;
	@BeanReference(type = org.politaktiv.map.service.CoordinateService.class)
	protected org.politaktiv.map.service.CoordinateService coordinateService;
	@BeanReference(type = CoordinatePersistence.class)
	protected CoordinatePersistence coordinatePersistence;
	@BeanReference(type = org.politaktiv.map.service.ShapeLocalService.class)
	protected org.politaktiv.map.service.ShapeLocalService shapeLocalService;
	@BeanReference(type = org.politaktiv.map.service.ShapeService.class)
	protected org.politaktiv.map.service.ShapeService shapeService;
	@BeanReference(type = ShapePersistence.class)
	protected ShapePersistence shapePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ShapeLocalServiceClpInvoker _clpInvoker = new ShapeLocalServiceClpInvoker();
}