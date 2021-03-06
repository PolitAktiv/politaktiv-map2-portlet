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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.politaktiv.map.NoSuchShapeException;
import org.politaktiv.map.model.Shape;
import org.politaktiv.map.model.impl.ShapeImpl;
import org.politaktiv.map.model.impl.ShapeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the shape service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul Butenko
 * @see ShapePersistence
 * @see ShapeUtil
 * @generated
 */
public class ShapePersistenceImpl extends BasePersistenceImpl<Shape>
	implements ShapePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ShapeUtil} to access the shape persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ShapeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, ShapeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, ShapeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, ShapeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, ShapeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			ShapeModelImpl.USERID_COLUMN_BITMASK |
			ShapeModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the shapes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching shapes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Shape> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Shape> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<Shape> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Shape> list = (List<Shape>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Shape shape : list) {
				if ((userId != shape.getUserId())) {
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

			query.append(_SQL_SELECT_SHAPE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShapeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Shape>(list);
				}
				else {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first shape in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shape
	 * @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = fetchByUserId_First(userId, orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShapeException(msg.toString());
	}

	/**
	 * Returns the first shape in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shape, or <code>null</code> if a matching shape could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Shape> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Shape findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = fetchByUserId_Last(userId, orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShapeException(msg.toString());
	}

	/**
	 * Returns the last shape in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shape, or <code>null</code> if a matching shape could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Shape> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Shape[] findByUserId_PrevAndNext(long shapeId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = findByPrimaryKey(shapeId);

		Session session = null;

		try {
			session = openSession();

			Shape[] array = new ShapeImpl[3];

			array[0] = getByUserId_PrevAndNext(session, shape, userId,
					orderByComparator, true);

			array[1] = shape;

			array[2] = getByUserId_PrevAndNext(session, shape, userId,
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

	protected Shape getByUserId_PrevAndNext(Session session, Shape shape,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHAPE_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(ShapeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shape);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Shape> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shapes where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (Shape shape : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(shape);
		}
	}

	/**
	 * Returns the number of shapes where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching shapes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHAPE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "shape.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LAYER = new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, ShapeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLayer",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYER = new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, ShapeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLayer",
			new String[] { String.class.getName() },
			ShapeModelImpl.LAYER_COLUMN_BITMASK |
			ShapeModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LAYER = new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLayer",
			new String[] { String.class.getName() });

	/**
	 * Returns all the shapes where layer = &#63;.
	 *
	 * @param layer the layer
	 * @return the matching shapes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Shape> findByLayer(String layer) throws SystemException {
		return findByLayer(layer, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Shape> findByLayer(String layer, int start, int end)
		throws SystemException {
		return findByLayer(layer, start, end, null);
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
	@Override
	public List<Shape> findByLayer(String layer, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYER;
			finderArgs = new Object[] { layer };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LAYER;
			finderArgs = new Object[] { layer, start, end, orderByComparator };
		}

		List<Shape> list = (List<Shape>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Shape shape : list) {
				if (!Validator.equals(layer, shape.getLayer())) {
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

			query.append(_SQL_SELECT_SHAPE_WHERE);

			boolean bindLayer = false;

			if (layer == null) {
				query.append(_FINDER_COLUMN_LAYER_LAYER_1);
			}
			else if (layer.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYER_LAYER_3);
			}
			else {
				bindLayer = true;

				query.append(_FINDER_COLUMN_LAYER_LAYER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShapeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLayer) {
					qPos.add(layer);
				}

				if (!pagination) {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Shape>(list);
				}
				else {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first shape in the ordered set where layer = &#63;.
	 *
	 * @param layer the layer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shape
	 * @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape findByLayer_First(String layer,
		OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = fetchByLayer_First(layer, orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("layer=");
		msg.append(layer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShapeException(msg.toString());
	}

	/**
	 * Returns the first shape in the ordered set where layer = &#63;.
	 *
	 * @param layer the layer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shape, or <code>null</code> if a matching shape could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape fetchByLayer_First(String layer,
		OrderByComparator orderByComparator) throws SystemException {
		List<Shape> list = findByLayer(layer, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Shape findByLayer_Last(String layer,
		OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = fetchByLayer_Last(layer, orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("layer=");
		msg.append(layer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShapeException(msg.toString());
	}

	/**
	 * Returns the last shape in the ordered set where layer = &#63;.
	 *
	 * @param layer the layer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shape, or <code>null</code> if a matching shape could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape fetchByLayer_Last(String layer,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLayer(layer);

		if (count == 0) {
			return null;
		}

		List<Shape> list = findByLayer(layer, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Shape[] findByLayer_PrevAndNext(long shapeId, String layer,
		OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = findByPrimaryKey(shapeId);

		Session session = null;

		try {
			session = openSession();

			Shape[] array = new ShapeImpl[3];

			array[0] = getByLayer_PrevAndNext(session, shape, layer,
					orderByComparator, true);

			array[1] = shape;

			array[2] = getByLayer_PrevAndNext(session, shape, layer,
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

	protected Shape getByLayer_PrevAndNext(Session session, Shape shape,
		String layer, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHAPE_WHERE);

		boolean bindLayer = false;

		if (layer == null) {
			query.append(_FINDER_COLUMN_LAYER_LAYER_1);
		}
		else if (layer.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LAYER_LAYER_3);
		}
		else {
			bindLayer = true;

			query.append(_FINDER_COLUMN_LAYER_LAYER_2);
		}

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
			query.append(ShapeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLayer) {
			qPos.add(layer);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shape);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Shape> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shapes where layer = &#63; from the database.
	 *
	 * @param layer the layer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLayer(String layer) throws SystemException {
		for (Shape shape : findByLayer(layer, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(shape);
		}
	}

	/**
	 * Returns the number of shapes where layer = &#63;.
	 *
	 * @param layer the layer
	 * @return the number of matching shapes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLayer(String layer) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LAYER;

		Object[] finderArgs = new Object[] { layer };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHAPE_WHERE);

			boolean bindLayer = false;

			if (layer == null) {
				query.append(_FINDER_COLUMN_LAYER_LAYER_1);
			}
			else if (layer.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LAYER_LAYER_3);
			}
			else {
				bindLayer = true;

				query.append(_FINDER_COLUMN_LAYER_LAYER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLayer) {
					qPos.add(layer);
				}

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

	private static final String _FINDER_COLUMN_LAYER_LAYER_1 = "shape.layer IS NULL";
	private static final String _FINDER_COLUMN_LAYER_LAYER_2 = "shape.layer = ?";
	private static final String _FINDER_COLUMN_LAYER_LAYER_3 = "(shape.layer IS NULL OR shape.layer = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDLAYER =
		new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, ShapeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdAndLayer",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYER =
		new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, ShapeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdAndLayer",
			new String[] { Long.class.getName(), String.class.getName() },
			ShapeModelImpl.USERID_COLUMN_BITMASK |
			ShapeModelImpl.LAYER_COLUMN_BITMASK |
			ShapeModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDLAYER = new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdAndLayer",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the shapes where userId = &#63; and layer = &#63;.
	 *
	 * @param userId the user ID
	 * @param layer the layer
	 * @return the matching shapes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Shape> findByUserIdAndLayer(long userId, String layer)
		throws SystemException {
		return findByUserIdAndLayer(userId, layer, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Shape> findByUserIdAndLayer(long userId, String layer,
		int start, int end) throws SystemException {
		return findByUserIdAndLayer(userId, layer, start, end, null);
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
	@Override
	public List<Shape> findByUserIdAndLayer(long userId, String layer,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYER;
			finderArgs = new Object[] { userId, layer };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDLAYER;
			finderArgs = new Object[] {
					userId, layer,
					
					start, end, orderByComparator
				};
		}

		List<Shape> list = (List<Shape>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Shape shape : list) {
				if ((userId != shape.getUserId()) ||
						!Validator.equals(layer, shape.getLayer())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SHAPE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDLAYER_USERID_2);

			boolean bindLayer = false;

			if (layer == null) {
				query.append(_FINDER_COLUMN_USERIDANDLAYER_LAYER_1);
			}
			else if (layer.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDLAYER_LAYER_3);
			}
			else {
				bindLayer = true;

				query.append(_FINDER_COLUMN_USERIDANDLAYER_LAYER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShapeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindLayer) {
					qPos.add(layer);
				}

				if (!pagination) {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Shape>(list);
				}
				else {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first shape in the ordered set where userId = &#63; and layer = &#63;.
	 *
	 * @param userId the user ID
	 * @param layer the layer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shape
	 * @throws org.politaktiv.map.NoSuchShapeException if a matching shape could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape findByUserIdAndLayer_First(long userId, String layer,
		OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = fetchByUserIdAndLayer_First(userId, layer,
				orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", layer=");
		msg.append(layer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShapeException(msg.toString());
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
	@Override
	public Shape fetchByUserIdAndLayer_First(long userId, String layer,
		OrderByComparator orderByComparator) throws SystemException {
		List<Shape> list = findByUserIdAndLayer(userId, layer, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Shape findByUserIdAndLayer_Last(long userId, String layer,
		OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = fetchByUserIdAndLayer_Last(userId, layer,
				orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", layer=");
		msg.append(layer);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShapeException(msg.toString());
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
	@Override
	public Shape fetchByUserIdAndLayer_Last(long userId, String layer,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserIdAndLayer(userId, layer);

		if (count == 0) {
			return null;
		}

		List<Shape> list = findByUserIdAndLayer(userId, layer, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Shape[] findByUserIdAndLayer_PrevAndNext(long shapeId, long userId,
		String layer, OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = findByPrimaryKey(shapeId);

		Session session = null;

		try {
			session = openSession();

			Shape[] array = new ShapeImpl[3];

			array[0] = getByUserIdAndLayer_PrevAndNext(session, shape, userId,
					layer, orderByComparator, true);

			array[1] = shape;

			array[2] = getByUserIdAndLayer_PrevAndNext(session, shape, userId,
					layer, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Shape getByUserIdAndLayer_PrevAndNext(Session session,
		Shape shape, long userId, String layer,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHAPE_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDLAYER_USERID_2);

		boolean bindLayer = false;

		if (layer == null) {
			query.append(_FINDER_COLUMN_USERIDANDLAYER_LAYER_1);
		}
		else if (layer.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERIDANDLAYER_LAYER_3);
		}
		else {
			bindLayer = true;

			query.append(_FINDER_COLUMN_USERIDANDLAYER_LAYER_2);
		}

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
			query.append(ShapeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindLayer) {
			qPos.add(layer);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shape);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Shape> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shapes where userId = &#63; and layer = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param layer the layer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndLayer(long userId, String layer)
		throws SystemException {
		for (Shape shape : findByUserIdAndLayer(userId, layer,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(shape);
		}
	}

	/**
	 * Returns the number of shapes where userId = &#63; and layer = &#63;.
	 *
	 * @param userId the user ID
	 * @param layer the layer
	 * @return the number of matching shapes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndLayer(long userId, String layer)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDLAYER;

		Object[] finderArgs = new Object[] { userId, layer };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHAPE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDLAYER_USERID_2);

			boolean bindLayer = false;

			if (layer == null) {
				query.append(_FINDER_COLUMN_USERIDANDLAYER_LAYER_1);
			}
			else if (layer.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDLAYER_LAYER_3);
			}
			else {
				bindLayer = true;

				query.append(_FINDER_COLUMN_USERIDANDLAYER_LAYER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindLayer) {
					qPos.add(layer);
				}

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

	private static final String _FINDER_COLUMN_USERIDANDLAYER_USERID_2 = "shape.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDLAYER_LAYER_1 = "shape.layer IS NULL";
	private static final String _FINDER_COLUMN_USERIDANDLAYER_LAYER_2 = "shape.layer = ?";
	private static final String _FINDER_COLUMN_USERIDANDLAYER_LAYER_3 = "(shape.layer IS NULL OR shape.layer = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDLAYERANDPORTLETINSTANCE =
		new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, ShapeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdAndLayerAndPortletInstance",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYERANDPORTLETINSTANCE =
		new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, ShapeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdAndLayerAndPortletInstance",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			ShapeModelImpl.USERID_COLUMN_BITMASK |
			ShapeModelImpl.LAYER_COLUMN_BITMASK |
			ShapeModelImpl.PORTLETINSTANCE_COLUMN_BITMASK |
			ShapeModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDLAYERANDPORTLETINSTANCE =
		new FinderPath(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndLayerAndPortletInstance",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the shapes where userId = &#63; and layer = &#63; and portletInstance = &#63;.
	 *
	 * @param userId the user ID
	 * @param layer the layer
	 * @param portletInstance the portlet instance
	 * @return the matching shapes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Shape> findByUserIdAndLayerAndPortletInstance(long userId,
		String layer, String portletInstance) throws SystemException {
		return findByUserIdAndLayerAndPortletInstance(userId, layer,
			portletInstance, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Shape> findByUserIdAndLayerAndPortletInstance(long userId,
		String layer, String portletInstance, int start, int end)
		throws SystemException {
		return findByUserIdAndLayerAndPortletInstance(userId, layer,
			portletInstance, start, end, null);
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
	@Override
	public List<Shape> findByUserIdAndLayerAndPortletInstance(long userId,
		String layer, String portletInstance, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYERANDPORTLETINSTANCE;
			finderArgs = new Object[] { userId, layer, portletInstance };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDLAYERANDPORTLETINSTANCE;
			finderArgs = new Object[] {
					userId, layer, portletInstance,
					
					start, end, orderByComparator
				};
		}

		List<Shape> list = (List<Shape>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Shape shape : list) {
				if ((userId != shape.getUserId()) ||
						!Validator.equals(layer, shape.getLayer()) ||
						!Validator.equals(portletInstance,
							shape.getPortletInstance())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SHAPE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_USERID_2);

			boolean bindLayer = false;

			if (layer == null) {
				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_1);
			}
			else if (layer.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_3);
			}
			else {
				bindLayer = true;

				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_2);
			}

			boolean bindPortletInstance = false;

			if (portletInstance == null) {
				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_1);
			}
			else if (portletInstance.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_3);
			}
			else {
				bindPortletInstance = true;

				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ShapeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindLayer) {
					qPos.add(layer);
				}

				if (bindPortletInstance) {
					qPos.add(portletInstance);
				}

				if (!pagination) {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Shape>(list);
				}
				else {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end);
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
	@Override
	public Shape findByUserIdAndLayerAndPortletInstance_First(long userId,
		String layer, String portletInstance,
		OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = fetchByUserIdAndLayerAndPortletInstance_First(userId,
				layer, portletInstance, orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", layer=");
		msg.append(layer);

		msg.append(", portletInstance=");
		msg.append(portletInstance);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShapeException(msg.toString());
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
	@Override
	public Shape fetchByUserIdAndLayerAndPortletInstance_First(long userId,
		String layer, String portletInstance,
		OrderByComparator orderByComparator) throws SystemException {
		List<Shape> list = findByUserIdAndLayerAndPortletInstance(userId,
				layer, portletInstance, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Shape findByUserIdAndLayerAndPortletInstance_Last(long userId,
		String layer, String portletInstance,
		OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = fetchByUserIdAndLayerAndPortletInstance_Last(userId,
				layer, portletInstance, orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", layer=");
		msg.append(layer);

		msg.append(", portletInstance=");
		msg.append(portletInstance);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchShapeException(msg.toString());
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
	@Override
	public Shape fetchByUserIdAndLayerAndPortletInstance_Last(long userId,
		String layer, String portletInstance,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserIdAndLayerAndPortletInstance(userId, layer,
				portletInstance);

		if (count == 0) {
			return null;
		}

		List<Shape> list = findByUserIdAndLayerAndPortletInstance(userId,
				layer, portletInstance, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Shape[] findByUserIdAndLayerAndPortletInstance_PrevAndNext(
		long shapeId, long userId, String layer, String portletInstance,
		OrderByComparator orderByComparator)
		throws NoSuchShapeException, SystemException {
		Shape shape = findByPrimaryKey(shapeId);

		Session session = null;

		try {
			session = openSession();

			Shape[] array = new ShapeImpl[3];

			array[0] = getByUserIdAndLayerAndPortletInstance_PrevAndNext(session,
					shape, userId, layer, portletInstance, orderByComparator,
					true);

			array[1] = shape;

			array[2] = getByUserIdAndLayerAndPortletInstance_PrevAndNext(session,
					shape, userId, layer, portletInstance, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Shape getByUserIdAndLayerAndPortletInstance_PrevAndNext(
		Session session, Shape shape, long userId, String layer,
		String portletInstance, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SHAPE_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_USERID_2);

		boolean bindLayer = false;

		if (layer == null) {
			query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_1);
		}
		else if (layer.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_3);
		}
		else {
			bindLayer = true;

			query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_2);
		}

		boolean bindPortletInstance = false;

		if (portletInstance == null) {
			query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_1);
		}
		else if (portletInstance.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_3);
		}
		else {
			bindPortletInstance = true;

			query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_2);
		}

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
			query.append(ShapeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindLayer) {
			qPos.add(layer);
		}

		if (bindPortletInstance) {
			qPos.add(portletInstance);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(shape);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Shape> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shapes where userId = &#63; and layer = &#63; and portletInstance = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param layer the layer
	 * @param portletInstance the portlet instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndLayerAndPortletInstance(long userId,
		String layer, String portletInstance) throws SystemException {
		for (Shape shape : findByUserIdAndLayerAndPortletInstance(userId,
				layer, portletInstance, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(shape);
		}
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
	@Override
	public int countByUserIdAndLayerAndPortletInstance(long userId,
		String layer, String portletInstance) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDLAYERANDPORTLETINSTANCE;

		Object[] finderArgs = new Object[] { userId, layer, portletInstance };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SHAPE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_USERID_2);

			boolean bindLayer = false;

			if (layer == null) {
				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_1);
			}
			else if (layer.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_3);
			}
			else {
				bindLayer = true;

				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_2);
			}

			boolean bindPortletInstance = false;

			if (portletInstance == null) {
				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_1);
			}
			else if (portletInstance.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_3);
			}
			else {
				bindPortletInstance = true;

				query.append(_FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindLayer) {
					qPos.add(layer);
				}

				if (bindPortletInstance) {
					qPos.add(portletInstance);
				}

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

	private static final String _FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_USERID_2 =
		"shape.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_1 =
		"shape.layer IS NULL AND ";
	private static final String _FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_2 =
		"shape.layer = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_LAYER_3 =
		"(shape.layer IS NULL OR shape.layer = '') AND ";
	private static final String _FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_1 =
		"shape.portletInstance IS NULL";
	private static final String _FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_2 =
		"shape.portletInstance = ?";
	private static final String _FINDER_COLUMN_USERIDANDLAYERANDPORTLETINSTANCE_PORTLETINSTANCE_3 =
		"(shape.portletInstance IS NULL OR shape.portletInstance = '')";

	public ShapePersistenceImpl() {
		setModelClass(Shape.class);
	}

	/**
	 * Caches the shape in the entity cache if it is enabled.
	 *
	 * @param shape the shape
	 */
	@Override
	public void cacheResult(Shape shape) {
		EntityCacheUtil.putResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeImpl.class, shape.getPrimaryKey(), shape);

		shape.resetOriginalValues();
	}

	/**
	 * Caches the shapes in the entity cache if it is enabled.
	 *
	 * @param shapes the shapes
	 */
	@Override
	public void cacheResult(List<Shape> shapes) {
		for (Shape shape : shapes) {
			if (EntityCacheUtil.getResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
						ShapeImpl.class, shape.getPrimaryKey()) == null) {
				cacheResult(shape);
			}
			else {
				shape.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all shapes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ShapeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ShapeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the shape.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Shape shape) {
		EntityCacheUtil.removeResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeImpl.class, shape.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Shape> shapes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Shape shape : shapes) {
			EntityCacheUtil.removeResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
				ShapeImpl.class, shape.getPrimaryKey());
		}
	}

	/**
	 * Creates a new shape with the primary key. Does not add the shape to the database.
	 *
	 * @param shapeId the primary key for the new shape
	 * @return the new shape
	 */
	@Override
	public Shape create(long shapeId) {
		Shape shape = new ShapeImpl();

		shape.setNew(true);
		shape.setPrimaryKey(shapeId);

		return shape;
	}

	/**
	 * Removes the shape with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shapeId the primary key of the shape
	 * @return the shape that was removed
	 * @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape remove(long shapeId)
		throws NoSuchShapeException, SystemException {
		return remove((Serializable)shapeId);
	}

	/**
	 * Removes the shape with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shape
	 * @return the shape that was removed
	 * @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape remove(Serializable primaryKey)
		throws NoSuchShapeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Shape shape = (Shape)session.get(ShapeImpl.class, primaryKey);

			if (shape == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchShapeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(shape);
		}
		catch (NoSuchShapeException nsee) {
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
	protected Shape removeImpl(Shape shape) throws SystemException {
		shape = toUnwrappedModel(shape);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(shape)) {
				shape = (Shape)session.get(ShapeImpl.class,
						shape.getPrimaryKeyObj());
			}

			if (shape != null) {
				session.delete(shape);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (shape != null) {
			clearCache(shape);
		}

		return shape;
	}

	@Override
	public Shape updateImpl(org.politaktiv.map.model.Shape shape)
		throws SystemException {
		shape = toUnwrappedModel(shape);

		boolean isNew = shape.isNew();

		ShapeModelImpl shapeModelImpl = (ShapeModelImpl)shape;

		Session session = null;

		try {
			session = openSession();

			if (shape.isNew()) {
				session.save(shape);

				shape.setNew(false);
			}
			else {
				session.merge(shape);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ShapeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((shapeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { shapeModelImpl.getOriginalUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { shapeModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((shapeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { shapeModelImpl.getOriginalLayer() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LAYER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYER,
					args);

				args = new Object[] { shapeModelImpl.getLayer() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LAYER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYER,
					args);
			}

			if ((shapeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shapeModelImpl.getOriginalUserId(),
						shapeModelImpl.getOriginalLayer()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDLAYER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYER,
					args);

				args = new Object[] {
						shapeModelImpl.getUserId(), shapeModelImpl.getLayer()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDLAYER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYER,
					args);
			}

			if ((shapeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYERANDPORTLETINSTANCE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shapeModelImpl.getOriginalUserId(),
						shapeModelImpl.getOriginalLayer(),
						shapeModelImpl.getOriginalPortletInstance()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDLAYERANDPORTLETINSTANCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYERANDPORTLETINSTANCE,
					args);

				args = new Object[] {
						shapeModelImpl.getUserId(), shapeModelImpl.getLayer(),
						shapeModelImpl.getPortletInstance()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDLAYERANDPORTLETINSTANCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYERANDPORTLETINSTANCE,
					args);
			}
		}

		EntityCacheUtil.putResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeImpl.class, shape.getPrimaryKey(), shape);

		return shape;
	}

	protected Shape toUnwrappedModel(Shape shape) {
		if (shape instanceof ShapeImpl) {
			return shape;
		}

		ShapeImpl shapeImpl = new ShapeImpl();

		shapeImpl.setNew(shape.isNew());
		shapeImpl.setPrimaryKey(shape.getPrimaryKey());

		shapeImpl.setShapeId(shape.getShapeId());
		shapeImpl.setGroupId(shape.getGroupId());
		shapeImpl.setCompanyId(shape.getCompanyId());
		shapeImpl.setUserId(shape.getUserId());
		shapeImpl.setUserName(shape.getUserName());
		shapeImpl.setCreateDate(shape.getCreateDate());
		shapeImpl.setModifiedDate(shape.getModifiedDate());
		shapeImpl.setTitle(shape.getTitle());
		shapeImpl.setAbstractDescription(shape.getAbstractDescription());
		shapeImpl.setImage(shape.getImage());
		shapeImpl.setShapeType(shape.getShapeType());
		shapeImpl.setRadius(shape.getRadius());
		shapeImpl.setLayer(shape.getLayer());
		shapeImpl.setPortletInstance(shape.getPortletInstance());

		return shapeImpl;
	}

	/**
	 * Returns the shape with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the shape
	 * @return the shape
	 * @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape findByPrimaryKey(Serializable primaryKey)
		throws NoSuchShapeException, SystemException {
		Shape shape = fetchByPrimaryKey(primaryKey);

		if (shape == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShapeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return shape;
	}

	/**
	 * Returns the shape with the primary key or throws a {@link org.politaktiv.map.NoSuchShapeException} if it could not be found.
	 *
	 * @param shapeId the primary key of the shape
	 * @return the shape
	 * @throws org.politaktiv.map.NoSuchShapeException if a shape with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape findByPrimaryKey(long shapeId)
		throws NoSuchShapeException, SystemException {
		return findByPrimaryKey((Serializable)shapeId);
	}

	/**
	 * Returns the shape with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shape
	 * @return the shape, or <code>null</code> if a shape with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Shape shape = (Shape)EntityCacheUtil.getResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
				ShapeImpl.class, primaryKey);

		if (shape == _nullShape) {
			return null;
		}

		if (shape == null) {
			Session session = null;

			try {
				session = openSession();

				shape = (Shape)session.get(ShapeImpl.class, primaryKey);

				if (shape != null) {
					cacheResult(shape);
				}
				else {
					EntityCacheUtil.putResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
						ShapeImpl.class, primaryKey, _nullShape);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
					ShapeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return shape;
	}

	/**
	 * Returns the shape with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param shapeId the primary key of the shape
	 * @return the shape, or <code>null</code> if a shape with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Shape fetchByPrimaryKey(long shapeId) throws SystemException {
		return fetchByPrimaryKey((Serializable)shapeId);
	}

	/**
	 * Returns all the shapes.
	 *
	 * @return the shapes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Shape> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Shape> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Shape> findAll(int start, int end,
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

		List<Shape> list = (List<Shape>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SHAPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SHAPE;

				if (pagination) {
					sql = sql.concat(ShapeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Shape>(list);
				}
				else {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the shapes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Shape shape : findAll()) {
			remove(shape);
		}
	}

	/**
	 * Returns the number of shapes.
	 *
	 * @return the number of shapes
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

				Query q = session.createQuery(_SQL_COUNT_SHAPE);

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
	 * Initializes the shape persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.politaktiv.map.model.Shape")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Shape>> listenersList = new ArrayList<ModelListener<Shape>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Shape>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ShapeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SHAPE = "SELECT shape FROM Shape shape";
	private static final String _SQL_SELECT_SHAPE_WHERE = "SELECT shape FROM Shape shape WHERE ";
	private static final String _SQL_COUNT_SHAPE = "SELECT COUNT(shape) FROM Shape shape";
	private static final String _SQL_COUNT_SHAPE_WHERE = "SELECT COUNT(shape) FROM Shape shape WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shape.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Shape exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Shape exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ShapePersistenceImpl.class);
	private static Shape _nullShape = new ShapeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Shape> toCacheModel() {
				return _nullShapeCacheModel;
			}
		};

	private static CacheModel<Shape> _nullShapeCacheModel = new CacheModel<Shape>() {
			@Override
			public Shape toEntityModel() {
				return _nullShape;
			}
		};
}