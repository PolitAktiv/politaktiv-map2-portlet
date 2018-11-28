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

package org.politaktiv.map.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.politaktiv.map.exception.NoSuchShapeException;
import org.politaktiv.map.model.Shape;
import org.politaktiv.map.model.impl.ShapeImpl;
import org.politaktiv.map.model.impl.ShapeModelImpl;
import org.politaktiv.map.service.persistence.ShapePersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the shape service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Aleksandar Lukic
 * @see ShapePersistence
 * @see org.politaktiv.map.service.persistence.ShapeUtil
 * @generated
 */
@ProviderType
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
	 */
	@Override
	public List<Shape> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Shape> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<Shape> findByUserId(long userId, int start, int end,
		OrderByComparator<Shape> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Shape> findByUserId(long userId, int start, int end,
		OrderByComparator<Shape> orderByComparator, boolean retrieveFromCache) {
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

		List<Shape> list = null;

		if (retrieveFromCache) {
			list = (List<Shape>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Shape shape : list) {
					if ((userId != shape.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * @throws NoSuchShapeException if a matching shape could not be found
	 */
	@Override
	public Shape findByUserId_First(long userId,
		OrderByComparator<Shape> orderByComparator) throws NoSuchShapeException {
		Shape shape = fetchByUserId_First(userId, orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchShapeException(msg.toString());
	}

	/**
	 * Returns the first shape in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shape, or <code>null</code> if a matching shape could not be found
	 */
	@Override
	public Shape fetchByUserId_First(long userId,
		OrderByComparator<Shape> orderByComparator) {
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
	 * @throws NoSuchShapeException if a matching shape could not be found
	 */
	@Override
	public Shape findByUserId_Last(long userId,
		OrderByComparator<Shape> orderByComparator) throws NoSuchShapeException {
		Shape shape = fetchByUserId_Last(userId, orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchShapeException(msg.toString());
	}

	/**
	 * Returns the last shape in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shape, or <code>null</code> if a matching shape could not be found
	 */
	@Override
	public Shape fetchByUserId_Last(long userId,
		OrderByComparator<Shape> orderByComparator) {
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
	 * @throws NoSuchShapeException if a shape with the primary key could not be found
	 */
	@Override
	public Shape[] findByUserId_PrevAndNext(long shapeId, long userId,
		OrderByComparator<Shape> orderByComparator) throws NoSuchShapeException {
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
		long userId, OrderByComparator<Shape> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
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
	 */
	@Override
	public void removeByUserId(long userId) {
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
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 */
	@Override
	public List<Shape> findByLayer(String layer) {
		return findByLayer(layer, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Shape> findByLayer(String layer, int start, int end) {
		return findByLayer(layer, start, end, null);
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
	@Override
	public List<Shape> findByLayer(String layer, int start, int end,
		OrderByComparator<Shape> orderByComparator) {
		return findByLayer(layer, start, end, orderByComparator, true);
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
	@Override
	public List<Shape> findByLayer(String layer, int start, int end,
		OrderByComparator<Shape> orderByComparator, boolean retrieveFromCache) {
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

		List<Shape> list = null;

		if (retrieveFromCache) {
			list = (List<Shape>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Shape shape : list) {
					if (!Objects.equals(layer, shape.getLayer())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SHAPE_WHERE);

			boolean bindLayer = false;

			if (layer == null) {
				query.append(_FINDER_COLUMN_LAYER_LAYER_1);
			}
			else if (layer.equals("")) {
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * @throws NoSuchShapeException if a matching shape could not be found
	 */
	@Override
	public Shape findByLayer_First(String layer,
		OrderByComparator<Shape> orderByComparator) throws NoSuchShapeException {
		Shape shape = fetchByLayer_First(layer, orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("layer=");
		msg.append(layer);

		msg.append("}");

		throw new NoSuchShapeException(msg.toString());
	}

	/**
	 * Returns the first shape in the ordered set where layer = &#63;.
	 *
	 * @param layer the layer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shape, or <code>null</code> if a matching shape could not be found
	 */
	@Override
	public Shape fetchByLayer_First(String layer,
		OrderByComparator<Shape> orderByComparator) {
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
	 * @throws NoSuchShapeException if a matching shape could not be found
	 */
	@Override
	public Shape findByLayer_Last(String layer,
		OrderByComparator<Shape> orderByComparator) throws NoSuchShapeException {
		Shape shape = fetchByLayer_Last(layer, orderByComparator);

		if (shape != null) {
			return shape;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("layer=");
		msg.append(layer);

		msg.append("}");

		throw new NoSuchShapeException(msg.toString());
	}

	/**
	 * Returns the last shape in the ordered set where layer = &#63;.
	 *
	 * @param layer the layer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shape, or <code>null</code> if a matching shape could not be found
	 */
	@Override
	public Shape fetchByLayer_Last(String layer,
		OrderByComparator<Shape> orderByComparator) {
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
	 * @throws NoSuchShapeException if a shape with the primary key could not be found
	 */
	@Override
	public Shape[] findByLayer_PrevAndNext(long shapeId, String layer,
		OrderByComparator<Shape> orderByComparator) throws NoSuchShapeException {
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
		String layer, OrderByComparator<Shape> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
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
		else if (layer.equals("")) {
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
	 */
	@Override
	public void removeByLayer(String layer) {
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
	 */
	@Override
	public int countByLayer(String layer) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LAYER;

		Object[] finderArgs = new Object[] { layer };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SHAPE_WHERE);

			boolean bindLayer = false;

			if (layer == null) {
				query.append(_FINDER_COLUMN_LAYER_LAYER_1);
			}
			else if (layer.equals("")) {
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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 */
	@Override
	public List<Shape> findByUserIdAndLayer(long userId, String layer) {
		return findByUserIdAndLayer(userId, layer, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Shape> findByUserIdAndLayer(long userId, String layer,
		int start, int end) {
		return findByUserIdAndLayer(userId, layer, start, end, null);
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
	@Override
	public List<Shape> findByUserIdAndLayer(long userId, String layer,
		int start, int end, OrderByComparator<Shape> orderByComparator) {
		return findByUserIdAndLayer(userId, layer, start, end,
			orderByComparator, true);
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
	@Override
	public List<Shape> findByUserIdAndLayer(long userId, String layer,
		int start, int end, OrderByComparator<Shape> orderByComparator,
		boolean retrieveFromCache) {
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

		List<Shape> list = null;

		if (retrieveFromCache) {
			list = (List<Shape>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Shape shape : list) {
					if ((userId != shape.getUserId()) ||
							!Objects.equals(layer, shape.getLayer())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
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
			else if (layer.equals("")) {
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * @throws NoSuchShapeException if a matching shape could not be found
	 */
	@Override
	public Shape findByUserIdAndLayer_First(long userId, String layer,
		OrderByComparator<Shape> orderByComparator) throws NoSuchShapeException {
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

		msg.append("}");

		throw new NoSuchShapeException(msg.toString());
	}

	/**
	 * Returns the first shape in the ordered set where userId = &#63; and layer = &#63;.
	 *
	 * @param userId the user ID
	 * @param layer the layer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shape, or <code>null</code> if a matching shape could not be found
	 */
	@Override
	public Shape fetchByUserIdAndLayer_First(long userId, String layer,
		OrderByComparator<Shape> orderByComparator) {
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
	 * @throws NoSuchShapeException if a matching shape could not be found
	 */
	@Override
	public Shape findByUserIdAndLayer_Last(long userId, String layer,
		OrderByComparator<Shape> orderByComparator) throws NoSuchShapeException {
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

		msg.append("}");

		throw new NoSuchShapeException(msg.toString());
	}

	/**
	 * Returns the last shape in the ordered set where userId = &#63; and layer = &#63;.
	 *
	 * @param userId the user ID
	 * @param layer the layer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shape, or <code>null</code> if a matching shape could not be found
	 */
	@Override
	public Shape fetchByUserIdAndLayer_Last(long userId, String layer,
		OrderByComparator<Shape> orderByComparator) {
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
	 * @throws NoSuchShapeException if a shape with the primary key could not be found
	 */
	@Override
	public Shape[] findByUserIdAndLayer_PrevAndNext(long shapeId, long userId,
		String layer, OrderByComparator<Shape> orderByComparator)
		throws NoSuchShapeException {
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
		OrderByComparator<Shape> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
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
		else if (layer.equals("")) {
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
	 */
	@Override
	public void removeByUserIdAndLayer(long userId, String layer) {
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
	 */
	@Override
	public int countByUserIdAndLayer(long userId, String layer) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDLAYER;

		Object[] finderArgs = new Object[] { userId, layer };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SHAPE_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDLAYER_USERID_2);

			boolean bindLayer = false;

			if (layer == null) {
				query.append(_FINDER_COLUMN_USERIDANDLAYER_LAYER_1);
			}
			else if (layer.equals("")) {
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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
		entityCache.putResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
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
			if (entityCache.getResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
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
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ShapeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the shape.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Shape shape) {
		entityCache.removeResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeImpl.class, shape.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Shape> shapes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Shape shape : shapes) {
			entityCache.removeResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
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

		shape.setCompanyId(companyProvider.getCompanyId());

		return shape;
	}

	/**
	 * Removes the shape with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param shapeId the primary key of the shape
	 * @return the shape that was removed
	 * @throws NoSuchShapeException if a shape with the primary key could not be found
	 */
	@Override
	public Shape remove(long shapeId) throws NoSuchShapeException {
		return remove((Serializable)shapeId);
	}

	/**
	 * Removes the shape with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shape
	 * @return the shape that was removed
	 * @throws NoSuchShapeException if a shape with the primary key could not be found
	 */
	@Override
	public Shape remove(Serializable primaryKey) throws NoSuchShapeException {
		Session session = null;

		try {
			session = openSession();

			Shape shape = (Shape)session.get(ShapeImpl.class, primaryKey);

			if (shape == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
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
	protected Shape removeImpl(Shape shape) {
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
	public Shape updateImpl(Shape shape) {
		boolean isNew = shape.isNew();

		if (!(shape instanceof ShapeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(shape.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(shape);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in shape proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Shape implementation " +
				shape.getClass());
		}

		ShapeModelImpl shapeModelImpl = (ShapeModelImpl)shape;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (shape.getCreateDate() == null)) {
			if (serviceContext == null) {
				shape.setCreateDate(now);
			}
			else {
				shape.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!shapeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				shape.setModifiedDate(now);
			}
			else {
				shape.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (shape.isNew()) {
				session.save(shape);

				shape.setNew(false);
			}
			else {
				shape = (Shape)session.merge(shape);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ShapeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { shapeModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
				args);

			args = new Object[] { shapeModelImpl.getLayer() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LAYER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYER,
				args);

			args = new Object[] {
					shapeModelImpl.getUserId(), shapeModelImpl.getLayer()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDANDLAYER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYER,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((shapeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { shapeModelImpl.getOriginalUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { shapeModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((shapeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { shapeModelImpl.getOriginalLayer() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LAYER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYER,
					args);

				args = new Object[] { shapeModelImpl.getLayer() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LAYER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAYER,
					args);
			}

			if ((shapeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						shapeModelImpl.getOriginalUserId(),
						shapeModelImpl.getOriginalLayer()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDANDLAYER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYER,
					args);

				args = new Object[] {
						shapeModelImpl.getUserId(), shapeModelImpl.getLayer()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDANDLAYER,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDLAYER,
					args);
			}
		}

		entityCache.putResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
			ShapeImpl.class, shape.getPrimaryKey(), shape, false);

		shape.resetOriginalValues();

		return shape;
	}

	/**
	 * Returns the shape with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the shape
	 * @return the shape
	 * @throws NoSuchShapeException if a shape with the primary key could not be found
	 */
	@Override
	public Shape findByPrimaryKey(Serializable primaryKey)
		throws NoSuchShapeException {
		Shape shape = fetchByPrimaryKey(primaryKey);

		if (shape == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchShapeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return shape;
	}

	/**
	 * Returns the shape with the primary key or throws a {@link NoSuchShapeException} if it could not be found.
	 *
	 * @param shapeId the primary key of the shape
	 * @return the shape
	 * @throws NoSuchShapeException if a shape with the primary key could not be found
	 */
	@Override
	public Shape findByPrimaryKey(long shapeId) throws NoSuchShapeException {
		return findByPrimaryKey((Serializable)shapeId);
	}

	/**
	 * Returns the shape with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shape
	 * @return the shape, or <code>null</code> if a shape with the primary key could not be found
	 */
	@Override
	public Shape fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
				ShapeImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Shape shape = (Shape)serializable;

		if (shape == null) {
			Session session = null;

			try {
				session = openSession();

				shape = (Shape)session.get(ShapeImpl.class, primaryKey);

				if (shape != null) {
					cacheResult(shape);
				}
				else {
					entityCache.putResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
						ShapeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
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
	 */
	@Override
	public Shape fetchByPrimaryKey(long shapeId) {
		return fetchByPrimaryKey((Serializable)shapeId);
	}

	@Override
	public Map<Serializable, Shape> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Shape> map = new HashMap<Serializable, Shape>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Shape shape = fetchByPrimaryKey(primaryKey);

			if (shape != null) {
				map.put(primaryKey, shape);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
					ShapeImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Shape)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SHAPE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Shape shape : (List<Shape>)q.list()) {
				map.put(shape.getPrimaryKeyObj(), shape);

				cacheResult(shape);

				uncachedPrimaryKeys.remove(shape.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ShapeModelImpl.ENTITY_CACHE_ENABLED,
					ShapeImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the shapes.
	 *
	 * @return the shapes
	 */
	@Override
	public List<Shape> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Shape> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Shape> findAll(int start, int end,
		OrderByComparator<Shape> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Shape> findAll(int start, int end,
		OrderByComparator<Shape> orderByComparator, boolean retrieveFromCache) {
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

		List<Shape> list = null;

		if (retrieveFromCache) {
			list = (List<Shape>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Shape>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 */
	@Override
	public void removeAll() {
		for (Shape shape : findAll()) {
			remove(shape);
		}
	}

	/**
	 * Returns the number of shapes.
	 *
	 * @return the number of shapes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SHAPE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ShapeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the shape persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ShapeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_SHAPE = "SELECT shape FROM Shape shape";
	private static final String _SQL_SELECT_SHAPE_WHERE_PKS_IN = "SELECT shape FROM Shape shape WHERE shapeId IN (";
	private static final String _SQL_SELECT_SHAPE_WHERE = "SELECT shape FROM Shape shape WHERE ";
	private static final String _SQL_COUNT_SHAPE = "SELECT COUNT(shape) FROM Shape shape";
	private static final String _SQL_COUNT_SHAPE_WHERE = "SELECT COUNT(shape) FROM Shape shape WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "shape.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Shape exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Shape exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ShapePersistenceImpl.class);
}