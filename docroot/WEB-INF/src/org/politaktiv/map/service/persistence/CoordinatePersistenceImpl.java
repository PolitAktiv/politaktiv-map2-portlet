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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.politaktiv.map.NoSuchCoordinateException;
import org.politaktiv.map.model.Coordinate;
import org.politaktiv.map.model.impl.CoordinateImpl;
import org.politaktiv.map.model.impl.CoordinateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the coordinate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul Butenko
 * @see CoordinatePersistence
 * @see CoordinateUtil
 * @generated
 */
public class CoordinatePersistenceImpl extends BasePersistenceImpl<Coordinate>
	implements CoordinatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CoordinateUtil} to access the coordinate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CoordinateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
			CoordinateModelImpl.FINDER_CACHE_ENABLED, CoordinateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
			CoordinateModelImpl.FINDER_CACHE_ENABLED, CoordinateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
			CoordinateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SHAPEID = new FinderPath(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
			CoordinateModelImpl.FINDER_CACHE_ENABLED, CoordinateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByShapeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAPEID =
		new FinderPath(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
			CoordinateModelImpl.FINDER_CACHE_ENABLED, CoordinateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByShapeId",
			new String[] { Long.class.getName() },
			CoordinateModelImpl.SHAPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SHAPEID = new FinderPath(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
			CoordinateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByShapeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the coordinates where shapeId = &#63;.
	 *
	 * @param shapeId the shape ID
	 * @return the matching coordinates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinate> findByShapeId(long shapeId)
		throws SystemException {
		return findByShapeId(shapeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coordinates where shapeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param shapeId the shape ID
	 * @param start the lower bound of the range of coordinates
	 * @param end the upper bound of the range of coordinates (not inclusive)
	 * @return the range of matching coordinates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinate> findByShapeId(long shapeId, int start, int end)
		throws SystemException {
		return findByShapeId(shapeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the coordinates where shapeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param shapeId the shape ID
	 * @param start the lower bound of the range of coordinates
	 * @param end the upper bound of the range of coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coordinates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinate> findByShapeId(long shapeId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAPEID;
			finderArgs = new Object[] { shapeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SHAPEID;
			finderArgs = new Object[] { shapeId, start, end, orderByComparator };
		}

		List<Coordinate> list = (List<Coordinate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Coordinate coordinate : list) {
				if ((shapeId != coordinate.getShapeId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COORDINATE_WHERE);

			query.append(_FINDER_COLUMN_SHAPEID_SHAPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CoordinateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(shapeId);

				if (!pagination) {
					list = (List<Coordinate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Coordinate>(list);
				}
				else {
					list = (List<Coordinate>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first coordinate in the ordered set where shapeId = &#63;.
	 *
	 * @param shapeId the shape ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinate
	 * @throws org.politaktiv.map.NoSuchCoordinateException if a matching coordinate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinate findByShapeId_First(long shapeId,
		OrderByComparator orderByComparator)
		throws NoSuchCoordinateException, SystemException {
		Coordinate coordinate = fetchByShapeId_First(shapeId, orderByComparator);

		if (coordinate != null) {
			return coordinate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shapeId=");
		msg.append(shapeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoordinateException(msg.toString());
	}

	/**
	 * Returns the first coordinate in the ordered set where shapeId = &#63;.
	 *
	 * @param shapeId the shape ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coordinate, or <code>null</code> if a matching coordinate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinate fetchByShapeId_First(long shapeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Coordinate> list = findByShapeId(shapeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last coordinate in the ordered set where shapeId = &#63;.
	 *
	 * @param shapeId the shape ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinate
	 * @throws org.politaktiv.map.NoSuchCoordinateException if a matching coordinate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinate findByShapeId_Last(long shapeId,
		OrderByComparator orderByComparator)
		throws NoSuchCoordinateException, SystemException {
		Coordinate coordinate = fetchByShapeId_Last(shapeId, orderByComparator);

		if (coordinate != null) {
			return coordinate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shapeId=");
		msg.append(shapeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCoordinateException(msg.toString());
	}

	/**
	 * Returns the last coordinate in the ordered set where shapeId = &#63;.
	 *
	 * @param shapeId the shape ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coordinate, or <code>null</code> if a matching coordinate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinate fetchByShapeId_Last(long shapeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByShapeId(shapeId);

		if (count == 0) {
			return null;
		}

		List<Coordinate> list = findByShapeId(shapeId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the coordinates before and after the current coordinate in the ordered set where shapeId = &#63;.
	 *
	 * @param coordinateId the primary key of the current coordinate
	 * @param shapeId the shape ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coordinate
	 * @throws org.politaktiv.map.NoSuchCoordinateException if a coordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinate[] findByShapeId_PrevAndNext(long coordinateId,
		long shapeId, OrderByComparator orderByComparator)
		throws NoSuchCoordinateException, SystemException {
		Coordinate coordinate = findByPrimaryKey(coordinateId);

		Session session = null;

		try {
			session = openSession();

			Coordinate[] array = new CoordinateImpl[3];

			array[0] = getByShapeId_PrevAndNext(session, coordinate, shapeId,
					orderByComparator, true);

			array[1] = coordinate;

			array[2] = getByShapeId_PrevAndNext(session, coordinate, shapeId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Coordinate getByShapeId_PrevAndNext(Session session,
		Coordinate coordinate, long shapeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COORDINATE_WHERE);

		query.append(_FINDER_COLUMN_SHAPEID_SHAPEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CoordinateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(shapeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(coordinate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Coordinate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the coordinates where shapeId = &#63; from the database.
	 *
	 * @param shapeId the shape ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByShapeId(long shapeId) throws SystemException {
		for (Coordinate coordinate : findByShapeId(shapeId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(coordinate);
		}
	}

	/**
	 * Returns the number of coordinates where shapeId = &#63;.
	 *
	 * @param shapeId the shape ID
	 * @return the number of matching coordinates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByShapeId(long shapeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SHAPEID;

		Object[] finderArgs = new Object[] { shapeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COORDINATE_WHERE);

			query.append(_FINDER_COLUMN_SHAPEID_SHAPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(shapeId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SHAPEID_SHAPEID_2 = "coordinate.shapeId = ?";

	public CoordinatePersistenceImpl() {
		setModelClass(Coordinate.class);
	}

	/**
	 * Caches the coordinate in the entity cache if it is enabled.
	 *
	 * @param coordinate the coordinate
	 */
	@Override
	public void cacheResult(Coordinate coordinate) {
		EntityCacheUtil.putResult(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
			CoordinateImpl.class, coordinate.getPrimaryKey(), coordinate);

		coordinate.resetOriginalValues();
	}

	/**
	 * Caches the coordinates in the entity cache if it is enabled.
	 *
	 * @param coordinates the coordinates
	 */
	@Override
	public void cacheResult(List<Coordinate> coordinates) {
		for (Coordinate coordinate : coordinates) {
			if (EntityCacheUtil.getResult(
						CoordinateModelImpl.ENTITY_CACHE_ENABLED,
						CoordinateImpl.class, coordinate.getPrimaryKey()) == null) {
				cacheResult(coordinate);
			}
			else {
				coordinate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all coordinates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CoordinateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CoordinateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the coordinate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Coordinate coordinate) {
		EntityCacheUtil.removeResult(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
			CoordinateImpl.class, coordinate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Coordinate> coordinates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Coordinate coordinate : coordinates) {
			EntityCacheUtil.removeResult(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
				CoordinateImpl.class, coordinate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new coordinate with the primary key. Does not add the coordinate to the database.
	 *
	 * @param coordinateId the primary key for the new coordinate
	 * @return the new coordinate
	 */
	@Override
	public Coordinate create(long coordinateId) {
		Coordinate coordinate = new CoordinateImpl();

		coordinate.setNew(true);
		coordinate.setPrimaryKey(coordinateId);

		return coordinate;
	}

	/**
	 * Removes the coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coordinateId the primary key of the coordinate
	 * @return the coordinate that was removed
	 * @throws org.politaktiv.map.NoSuchCoordinateException if a coordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinate remove(long coordinateId)
		throws NoSuchCoordinateException, SystemException {
		return remove((Serializable)coordinateId);
	}

	/**
	 * Removes the coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the coordinate
	 * @return the coordinate that was removed
	 * @throws org.politaktiv.map.NoSuchCoordinateException if a coordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinate remove(Serializable primaryKey)
		throws NoSuchCoordinateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Coordinate coordinate = (Coordinate)session.get(CoordinateImpl.class,
					primaryKey);

			if (coordinate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoordinateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(coordinate);
		}
		catch (NoSuchCoordinateException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Coordinate removeImpl(Coordinate coordinate)
		throws SystemException {
		coordinate = toUnwrappedModel(coordinate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(coordinate)) {
				coordinate = (Coordinate)session.get(CoordinateImpl.class,
						coordinate.getPrimaryKeyObj());
			}

			if (coordinate != null) {
				session.delete(coordinate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (coordinate != null) {
			clearCache(coordinate);
		}

		return coordinate;
	}

	@Override
	public Coordinate updateImpl(org.politaktiv.map.model.Coordinate coordinate)
		throws SystemException {
		coordinate = toUnwrappedModel(coordinate);

		boolean isNew = coordinate.isNew();

		CoordinateModelImpl coordinateModelImpl = (CoordinateModelImpl)coordinate;

		Session session = null;

		try {
			session = openSession();

			if (coordinate.isNew()) {
				session.save(coordinate);

				coordinate.setNew(false);
			}
			else {
				session.merge(coordinate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CoordinateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((coordinateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						coordinateModelImpl.getOriginalShapeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHAPEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAPEID,
					args);

				args = new Object[] { coordinateModelImpl.getShapeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SHAPEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SHAPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
			CoordinateImpl.class, coordinate.getPrimaryKey(), coordinate);

		return coordinate;
	}

	protected Coordinate toUnwrappedModel(Coordinate coordinate) {
		if (coordinate instanceof CoordinateImpl) {
			return coordinate;
		}

		CoordinateImpl coordinateImpl = new CoordinateImpl();

		coordinateImpl.setNew(coordinate.isNew());
		coordinateImpl.setPrimaryKey(coordinate.getPrimaryKey());

		coordinateImpl.setCoordinateId(coordinate.getCoordinateId());
		coordinateImpl.setShapeId(coordinate.getShapeId());
		coordinateImpl.setLongitude(coordinate.getLongitude());
		coordinateImpl.setLatitude(coordinate.getLatitude());

		return coordinateImpl;
	}

	/**
	 * Returns the coordinate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the coordinate
	 * @return the coordinate
	 * @throws org.politaktiv.map.NoSuchCoordinateException if a coordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCoordinateException, SystemException {
		Coordinate coordinate = fetchByPrimaryKey(primaryKey);

		if (coordinate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCoordinateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return coordinate;
	}

	/**
	 * Returns the coordinate with the primary key or throws a {@link org.politaktiv.map.NoSuchCoordinateException} if it could not be found.
	 *
	 * @param coordinateId the primary key of the coordinate
	 * @return the coordinate
	 * @throws org.politaktiv.map.NoSuchCoordinateException if a coordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinate findByPrimaryKey(long coordinateId)
		throws NoSuchCoordinateException, SystemException {
		return findByPrimaryKey((Serializable)coordinateId);
	}

	/**
	 * Returns the coordinate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the coordinate
	 * @return the coordinate, or <code>null</code> if a coordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Coordinate coordinate = (Coordinate)EntityCacheUtil.getResult(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
				CoordinateImpl.class, primaryKey);

		if (coordinate == _nullCoordinate) {
			return null;
		}

		if (coordinate == null) {
			Session session = null;

			try {
				session = openSession();

				coordinate = (Coordinate)session.get(CoordinateImpl.class,
						primaryKey);

				if (coordinate != null) {
					cacheResult(coordinate);
				}
				else {
					EntityCacheUtil.putResult(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
						CoordinateImpl.class, primaryKey, _nullCoordinate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CoordinateModelImpl.ENTITY_CACHE_ENABLED,
					CoordinateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return coordinate;
	}

	/**
	 * Returns the coordinate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coordinateId the primary key of the coordinate
	 * @return the coordinate, or <code>null</code> if a coordinate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Coordinate fetchByPrimaryKey(long coordinateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)coordinateId);
	}

	/**
	 * Returns all the coordinates.
	 *
	 * @return the coordinates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinates
	 * @param end the upper bound of the range of coordinates (not inclusive)
	 * @return the range of coordinates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the coordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.CoordinateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of coordinates
	 * @param end the upper bound of the range of coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coordinates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Coordinate> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Coordinate> list = (List<Coordinate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COORDINATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COORDINATE;

				if (pagination) {
					sql = sql.concat(CoordinateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Coordinate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Coordinate>(list);
				}
				else {
					list = (List<Coordinate>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the coordinates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Coordinate coordinate : findAll()) {
			remove(coordinate);
		}
	}

	/**
	 * Returns the number of coordinates.
	 *
	 * @return the number of coordinates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_COORDINATE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the coordinate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.politaktiv.map.model.Coordinate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Coordinate>> listenersList = new ArrayList<ModelListener<Coordinate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Coordinate>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CoordinateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COORDINATE = "SELECT coordinate FROM Coordinate coordinate";
	private static final String _SQL_SELECT_COORDINATE_WHERE = "SELECT coordinate FROM Coordinate coordinate WHERE ";
	private static final String _SQL_COUNT_COORDINATE = "SELECT COUNT(coordinate) FROM Coordinate coordinate";
	private static final String _SQL_COUNT_COORDINATE_WHERE = "SELECT COUNT(coordinate) FROM Coordinate coordinate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "coordinate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Coordinate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Coordinate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CoordinatePersistenceImpl.class);
	private static Coordinate _nullCoordinate = new CoordinateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Coordinate> toCacheModel() {
				return _nullCoordinateCacheModel;
			}
		};

	private static CacheModel<Coordinate> _nullCoordinateCacheModel = new CacheModel<Coordinate>() {
			@Override
			public Coordinate toEntityModel() {
				return _nullCoordinate;
			}
		};
}