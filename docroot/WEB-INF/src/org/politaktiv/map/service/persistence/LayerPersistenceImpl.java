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

import org.politaktiv.map.NoSuchLayerException;
import org.politaktiv.map.model.Layer;
import org.politaktiv.map.model.impl.LayerImpl;
import org.politaktiv.map.model.impl.LayerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the layer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul Butenko
 * @see LayerPersistence
 * @see LayerUtil
 * @generated
 */
public class LayerPersistenceImpl extends BasePersistenceImpl<Layer>
	implements LayerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LayerUtil} to access the layer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LayerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerModelImpl.FINDER_CACHE_ENABLED, LayerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerModelImpl.FINDER_CACHE_ENABLED, LayerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerModelImpl.FINDER_CACHE_ENABLED, LayerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerModelImpl.FINDER_CACHE_ENABLED, LayerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			LayerModelImpl.USERID_COLUMN_BITMASK |
			LayerModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the layers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching layers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Layer> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Layer> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<Layer> findByUserId(long userId, int start, int end,
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

		List<Layer> list = (List<Layer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Layer layer : list) {
				if ((userId != layer.getUserId())) {
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

			query.append(_SQL_SELECT_LAYER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LayerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Layer>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Layer>(list);
				}
				else {
					list = (List<Layer>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first layer in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layer
	 * @throws org.politaktiv.map.NoSuchLayerException if a matching layer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLayerException, SystemException {
		Layer layer = fetchByUserId_First(userId, orderByComparator);

		if (layer != null) {
			return layer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLayerException(msg.toString());
	}

	/**
	 * Returns the first layer in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layer, or <code>null</code> if a matching layer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Layer> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Layer findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLayerException, SystemException {
		Layer layer = fetchByUserId_Last(userId, orderByComparator);

		if (layer != null) {
			return layer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLayerException(msg.toString());
	}

	/**
	 * Returns the last layer in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layer, or <code>null</code> if a matching layer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Layer> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Layer[] findByUserId_PrevAndNext(long layerId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchLayerException, SystemException {
		Layer layer = findByPrimaryKey(layerId);

		Session session = null;

		try {
			session = openSession();

			Layer[] array = new LayerImpl[3];

			array[0] = getByUserId_PrevAndNext(session, layer, userId,
					orderByComparator, true);

			array[1] = layer;

			array[2] = getByUserId_PrevAndNext(session, layer, userId,
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

	protected Layer getByUserId_PrevAndNext(Session session, Layer layer,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LAYER_WHERE);

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
			query.append(LayerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(layer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Layer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the layers where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (Layer layer : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(layer);
		}
	}

	/**
	 * Returns the number of layers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching layers
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

			query.append(_SQL_COUNT_LAYER_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "layer.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDPORTLETINSTANCE =
		new FinderPath(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerModelImpl.FINDER_CACHE_ENABLED, LayerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdAndPortletInstance",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDPORTLETINSTANCE =
		new FinderPath(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerModelImpl.FINDER_CACHE_ENABLED, LayerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdAndPortletInstance",
			new String[] { Long.class.getName(), String.class.getName() },
			LayerModelImpl.USERID_COLUMN_BITMASK |
			LayerModelImpl.PORTLETINSTANCE_COLUMN_BITMASK |
			LayerModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDPORTLETINSTANCE =
		new FinderPath(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndPortletInstance",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the layers where userId = &#63; and portletInstance = &#63;.
	 *
	 * @param userId the user ID
	 * @param portletInstance the portlet instance
	 * @return the matching layers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Layer> findByUserIdAndPortletInstance(long userId,
		String portletInstance) throws SystemException {
		return findByUserIdAndPortletInstance(userId, portletInstance,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Layer> findByUserIdAndPortletInstance(long userId,
		String portletInstance, int start, int end) throws SystemException {
		return findByUserIdAndPortletInstance(userId, portletInstance, start,
			end, null);
	}

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
	@Override
	public List<Layer> findByUserIdAndPortletInstance(long userId,
		String portletInstance, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDPORTLETINSTANCE;
			finderArgs = new Object[] { userId, portletInstance };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDPORTLETINSTANCE;
			finderArgs = new Object[] {
					userId, portletInstance,
					
					start, end, orderByComparator
				};
		}

		List<Layer> list = (List<Layer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Layer layer : list) {
				if ((userId != layer.getUserId()) ||
						!Validator.equals(portletInstance,
							layer.getPortletInstance())) {
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

			query.append(_SQL_SELECT_LAYER_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_USERID_2);

			boolean bindPortletInstance = false;

			if (portletInstance == null) {
				query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_1);
			}
			else if (portletInstance.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_3);
			}
			else {
				bindPortletInstance = true;

				query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LayerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindPortletInstance) {
					qPos.add(portletInstance);
				}

				if (!pagination) {
					list = (List<Layer>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Layer>(list);
				}
				else {
					list = (List<Layer>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first layer in the ordered set where userId = &#63; and portletInstance = &#63;.
	 *
	 * @param userId the user ID
	 * @param portletInstance the portlet instance
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layer
	 * @throws org.politaktiv.map.NoSuchLayerException if a matching layer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer findByUserIdAndPortletInstance_First(long userId,
		String portletInstance, OrderByComparator orderByComparator)
		throws NoSuchLayerException, SystemException {
		Layer layer = fetchByUserIdAndPortletInstance_First(userId,
				portletInstance, orderByComparator);

		if (layer != null) {
			return layer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", portletInstance=");
		msg.append(portletInstance);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLayerException(msg.toString());
	}

	/**
	 * Returns the first layer in the ordered set where userId = &#63; and portletInstance = &#63;.
	 *
	 * @param userId the user ID
	 * @param portletInstance the portlet instance
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching layer, or <code>null</code> if a matching layer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer fetchByUserIdAndPortletInstance_First(long userId,
		String portletInstance, OrderByComparator orderByComparator)
		throws SystemException {
		List<Layer> list = findByUserIdAndPortletInstance(userId,
				portletInstance, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Layer findByUserIdAndPortletInstance_Last(long userId,
		String portletInstance, OrderByComparator orderByComparator)
		throws NoSuchLayerException, SystemException {
		Layer layer = fetchByUserIdAndPortletInstance_Last(userId,
				portletInstance, orderByComparator);

		if (layer != null) {
			return layer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", portletInstance=");
		msg.append(portletInstance);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLayerException(msg.toString());
	}

	/**
	 * Returns the last layer in the ordered set where userId = &#63; and portletInstance = &#63;.
	 *
	 * @param userId the user ID
	 * @param portletInstance the portlet instance
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching layer, or <code>null</code> if a matching layer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer fetchByUserIdAndPortletInstance_Last(long userId,
		String portletInstance, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdAndPortletInstance(userId, portletInstance);

		if (count == 0) {
			return null;
		}

		List<Layer> list = findByUserIdAndPortletInstance(userId,
				portletInstance, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public Layer[] findByUserIdAndPortletInstance_PrevAndNext(long layerId,
		long userId, String portletInstance, OrderByComparator orderByComparator)
		throws NoSuchLayerException, SystemException {
		Layer layer = findByPrimaryKey(layerId);

		Session session = null;

		try {
			session = openSession();

			Layer[] array = new LayerImpl[3];

			array[0] = getByUserIdAndPortletInstance_PrevAndNext(session,
					layer, userId, portletInstance, orderByComparator, true);

			array[1] = layer;

			array[2] = getByUserIdAndPortletInstance_PrevAndNext(session,
					layer, userId, portletInstance, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Layer getByUserIdAndPortletInstance_PrevAndNext(Session session,
		Layer layer, long userId, String portletInstance,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LAYER_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_USERID_2);

		boolean bindPortletInstance = false;

		if (portletInstance == null) {
			query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_1);
		}
		else if (portletInstance.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_3);
		}
		else {
			bindPortletInstance = true;

			query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_2);
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
			query.append(LayerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindPortletInstance) {
			qPos.add(portletInstance);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(layer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Layer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the layers where userId = &#63; and portletInstance = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param portletInstance the portlet instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndPortletInstance(long userId,
		String portletInstance) throws SystemException {
		for (Layer layer : findByUserIdAndPortletInstance(userId,
				portletInstance, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(layer);
		}
	}

	/**
	 * Returns the number of layers where userId = &#63; and portletInstance = &#63;.
	 *
	 * @param userId the user ID
	 * @param portletInstance the portlet instance
	 * @return the number of matching layers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndPortletInstance(long userId,
		String portletInstance) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDPORTLETINSTANCE;

		Object[] finderArgs = new Object[] { userId, portletInstance };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LAYER_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_USERID_2);

			boolean bindPortletInstance = false;

			if (portletInstance == null) {
				query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_1);
			}
			else if (portletInstance.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_3);
			}
			else {
				bindPortletInstance = true;

				query.append(_FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERIDANDPORTLETINSTANCE_USERID_2 =
		"layer.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_1 =
		"layer.portletInstance IS NULL";
	private static final String _FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_2 =
		"layer.portletInstance = ?";
	private static final String _FINDER_COLUMN_USERIDANDPORTLETINSTANCE_PORTLETINSTANCE_3 =
		"(layer.portletInstance IS NULL OR layer.portletInstance = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE =
		new FinderPath(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerModelImpl.FINDER_CACHE_ENABLED, LayerImpl.class,
			FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdAndLabelAndPortletInstance",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			LayerModelImpl.USERID_COLUMN_BITMASK |
			LayerModelImpl.LABEL_COLUMN_BITMASK |
			LayerModelImpl.PORTLETINSTANCE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDLABELANDPORTLETINSTANCE =
		new FinderPath(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndLabelAndPortletInstance",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

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
	@Override
	public Layer findByUserIdAndLabelAndPortletInstance(long userId,
		String label, String portletInstance)
		throws NoSuchLayerException, SystemException {
		Layer layer = fetchByUserIdAndLabelAndPortletInstance(userId, label,
				portletInstance);

		if (layer == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", label=");
			msg.append(label);

			msg.append(", portletInstance=");
			msg.append(portletInstance);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLayerException(msg.toString());
		}

		return layer;
	}

	/**
	 * Returns the layer where userId = &#63; and label = &#63; and portletInstance = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param label the label
	 * @param portletInstance the portlet instance
	 * @return the matching layer, or <code>null</code> if a matching layer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer fetchByUserIdAndLabelAndPortletInstance(long userId,
		String label, String portletInstance) throws SystemException {
		return fetchByUserIdAndLabelAndPortletInstance(userId, label,
			portletInstance, true);
	}

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
	@Override
	public Layer fetchByUserIdAndLabelAndPortletInstance(long userId,
		String label, String portletInstance, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, label, portletInstance };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE,
					finderArgs, this);
		}

		if (result instanceof Layer) {
			Layer layer = (Layer)result;

			if ((userId != layer.getUserId()) ||
					!Validator.equals(label, layer.getLabel()) ||
					!Validator.equals(portletInstance,
						layer.getPortletInstance())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_LAYER_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_USERID_2);

			boolean bindLabel = false;

			if (label == null) {
				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_LABEL_1);
			}
			else if (label.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_LABEL_3);
			}
			else {
				bindLabel = true;

				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_LABEL_2);
			}

			boolean bindPortletInstance = false;

			if (portletInstance == null) {
				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_PORTLETINSTANCE_1);
			}
			else if (portletInstance.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_PORTLETINSTANCE_3);
			}
			else {
				bindPortletInstance = true;

				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_PORTLETINSTANCE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindLabel) {
					qPos.add(label);
				}

				if (bindPortletInstance) {
					qPos.add(portletInstance);
				}

				List<Layer> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LayerPersistenceImpl.fetchByUserIdAndLabelAndPortletInstance(long, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Layer layer = list.get(0);

					result = layer;

					cacheResult(layer);

					if ((layer.getUserId() != userId) ||
							(layer.getLabel() == null) ||
							!layer.getLabel().equals(label) ||
							(layer.getPortletInstance() == null) ||
							!layer.getPortletInstance().equals(portletInstance)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE,
							finderArgs, layer);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Layer)result;
		}
	}

	/**
	 * Removes the layer where userId = &#63; and label = &#63; and portletInstance = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param label the label
	 * @param portletInstance the portlet instance
	 * @return the layer that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer removeByUserIdAndLabelAndPortletInstance(long userId,
		String label, String portletInstance)
		throws NoSuchLayerException, SystemException {
		Layer layer = findByUserIdAndLabelAndPortletInstance(userId, label,
				portletInstance);

		return remove(layer);
	}

	/**
	 * Returns the number of layers where userId = &#63; and label = &#63; and portletInstance = &#63;.
	 *
	 * @param userId the user ID
	 * @param label the label
	 * @param portletInstance the portlet instance
	 * @return the number of matching layers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndLabelAndPortletInstance(long userId,
		String label, String portletInstance) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDLABELANDPORTLETINSTANCE;

		Object[] finderArgs = new Object[] { userId, label, portletInstance };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LAYER_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_USERID_2);

			boolean bindLabel = false;

			if (label == null) {
				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_LABEL_1);
			}
			else if (label.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_LABEL_3);
			}
			else {
				bindLabel = true;

				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_LABEL_2);
			}

			boolean bindPortletInstance = false;

			if (portletInstance == null) {
				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_PORTLETINSTANCE_1);
			}
			else if (portletInstance.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_PORTLETINSTANCE_3);
			}
			else {
				bindPortletInstance = true;

				query.append(_FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_PORTLETINSTANCE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindLabel) {
					qPos.add(label);
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

	private static final String _FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_USERID_2 =
		"layer.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_LABEL_1 =
		"layer.label IS NULL AND ";
	private static final String _FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_LABEL_2 =
		"layer.label = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_LABEL_3 =
		"(layer.label IS NULL OR layer.label = '') AND ";
	private static final String _FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_PORTLETINSTANCE_1 =
		"layer.portletInstance IS NULL";
	private static final String _FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_PORTLETINSTANCE_2 =
		"layer.portletInstance = ?";
	private static final String _FINDER_COLUMN_USERIDANDLABELANDPORTLETINSTANCE_PORTLETINSTANCE_3 =
		"(layer.portletInstance IS NULL OR layer.portletInstance = '')";

	public LayerPersistenceImpl() {
		setModelClass(Layer.class);
	}

	/**
	 * Caches the layer in the entity cache if it is enabled.
	 *
	 * @param layer the layer
	 */
	@Override
	public void cacheResult(Layer layer) {
		EntityCacheUtil.putResult(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerImpl.class, layer.getPrimaryKey(), layer);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE,
			new Object[] {
				layer.getUserId(), layer.getLabel(), layer.getPortletInstance()
			}, layer);

		layer.resetOriginalValues();
	}

	/**
	 * Caches the layers in the entity cache if it is enabled.
	 *
	 * @param layers the layers
	 */
	@Override
	public void cacheResult(List<Layer> layers) {
		for (Layer layer : layers) {
			if (EntityCacheUtil.getResult(LayerModelImpl.ENTITY_CACHE_ENABLED,
						LayerImpl.class, layer.getPrimaryKey()) == null) {
				cacheResult(layer);
			}
			else {
				layer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all layers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LayerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LayerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the layer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Layer layer) {
		EntityCacheUtil.removeResult(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerImpl.class, layer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(layer);
	}

	@Override
	public void clearCache(List<Layer> layers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Layer layer : layers) {
			EntityCacheUtil.removeResult(LayerModelImpl.ENTITY_CACHE_ENABLED,
				LayerImpl.class, layer.getPrimaryKey());

			clearUniqueFindersCache(layer);
		}
	}

	protected void cacheUniqueFindersCache(Layer layer) {
		if (layer.isNew()) {
			Object[] args = new Object[] {
					layer.getUserId(), layer.getLabel(),
					layer.getPortletInstance()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDLABELANDPORTLETINSTANCE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE,
				args, layer);
		}
		else {
			LayerModelImpl layerModelImpl = (LayerModelImpl)layer;

			if ((layerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						layer.getUserId(), layer.getLabel(),
						layer.getPortletInstance()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDLABELANDPORTLETINSTANCE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE,
					args, layer);
			}
		}
	}

	protected void clearUniqueFindersCache(Layer layer) {
		LayerModelImpl layerModelImpl = (LayerModelImpl)layer;

		Object[] args = new Object[] {
				layer.getUserId(), layer.getLabel(), layer.getPortletInstance()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDLABELANDPORTLETINSTANCE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE,
			args);

		if ((layerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE.getColumnBitmask()) != 0) {
			args = new Object[] {
					layerModelImpl.getOriginalUserId(),
					layerModelImpl.getOriginalLabel(),
					layerModelImpl.getOriginalPortletInstance()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDLABELANDPORTLETINSTANCE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDLABELANDPORTLETINSTANCE,
				args);
		}
	}

	/**
	 * Creates a new layer with the primary key. Does not add the layer to the database.
	 *
	 * @param layerId the primary key for the new layer
	 * @return the new layer
	 */
	@Override
	public Layer create(long layerId) {
		Layer layer = new LayerImpl();

		layer.setNew(true);
		layer.setPrimaryKey(layerId);

		return layer;
	}

	/**
	 * Removes the layer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param layerId the primary key of the layer
	 * @return the layer that was removed
	 * @throws org.politaktiv.map.NoSuchLayerException if a layer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer remove(long layerId)
		throws NoSuchLayerException, SystemException {
		return remove((Serializable)layerId);
	}

	/**
	 * Removes the layer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the layer
	 * @return the layer that was removed
	 * @throws org.politaktiv.map.NoSuchLayerException if a layer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer remove(Serializable primaryKey)
		throws NoSuchLayerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Layer layer = (Layer)session.get(LayerImpl.class, primaryKey);

			if (layer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLayerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(layer);
		}
		catch (NoSuchLayerException nsee) {
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
	protected Layer removeImpl(Layer layer) throws SystemException {
		layer = toUnwrappedModel(layer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(layer)) {
				layer = (Layer)session.get(LayerImpl.class,
						layer.getPrimaryKeyObj());
			}

			if (layer != null) {
				session.delete(layer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (layer != null) {
			clearCache(layer);
		}

		return layer;
	}

	@Override
	public Layer updateImpl(org.politaktiv.map.model.Layer layer)
		throws SystemException {
		layer = toUnwrappedModel(layer);

		boolean isNew = layer.isNew();

		LayerModelImpl layerModelImpl = (LayerModelImpl)layer;

		Session session = null;

		try {
			session = openSession();

			if (layer.isNew()) {
				session.save(layer);

				layer.setNew(false);
			}
			else {
				session.merge(layer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LayerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((layerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { layerModelImpl.getOriginalUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { layerModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((layerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDPORTLETINSTANCE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						layerModelImpl.getOriginalUserId(),
						layerModelImpl.getOriginalPortletInstance()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDPORTLETINSTANCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDPORTLETINSTANCE,
					args);

				args = new Object[] {
						layerModelImpl.getUserId(),
						layerModelImpl.getPortletInstance()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDPORTLETINSTANCE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDPORTLETINSTANCE,
					args);
			}
		}

		EntityCacheUtil.putResult(LayerModelImpl.ENTITY_CACHE_ENABLED,
			LayerImpl.class, layer.getPrimaryKey(), layer);

		clearUniqueFindersCache(layer);
		cacheUniqueFindersCache(layer);

		return layer;
	}

	protected Layer toUnwrappedModel(Layer layer) {
		if (layer instanceof LayerImpl) {
			return layer;
		}

		LayerImpl layerImpl = new LayerImpl();

		layerImpl.setNew(layer.isNew());
		layerImpl.setPrimaryKey(layer.getPrimaryKey());

		layerImpl.setLayerId(layer.getLayerId());
		layerImpl.setCreateDate(layer.getCreateDate());
		layerImpl.setLabel(layer.getLabel());
		layerImpl.setUserId(layer.getUserId());
		layerImpl.setPortletInstance(layer.getPortletInstance());

		return layerImpl;
	}

	/**
	 * Returns the layer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the layer
	 * @return the layer
	 * @throws org.politaktiv.map.NoSuchLayerException if a layer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLayerException, SystemException {
		Layer layer = fetchByPrimaryKey(primaryKey);

		if (layer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLayerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return layer;
	}

	/**
	 * Returns the layer with the primary key or throws a {@link org.politaktiv.map.NoSuchLayerException} if it could not be found.
	 *
	 * @param layerId the primary key of the layer
	 * @return the layer
	 * @throws org.politaktiv.map.NoSuchLayerException if a layer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer findByPrimaryKey(long layerId)
		throws NoSuchLayerException, SystemException {
		return findByPrimaryKey((Serializable)layerId);
	}

	/**
	 * Returns the layer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the layer
	 * @return the layer, or <code>null</code> if a layer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Layer layer = (Layer)EntityCacheUtil.getResult(LayerModelImpl.ENTITY_CACHE_ENABLED,
				LayerImpl.class, primaryKey);

		if (layer == _nullLayer) {
			return null;
		}

		if (layer == null) {
			Session session = null;

			try {
				session = openSession();

				layer = (Layer)session.get(LayerImpl.class, primaryKey);

				if (layer != null) {
					cacheResult(layer);
				}
				else {
					EntityCacheUtil.putResult(LayerModelImpl.ENTITY_CACHE_ENABLED,
						LayerImpl.class, primaryKey, _nullLayer);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LayerModelImpl.ENTITY_CACHE_ENABLED,
					LayerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return layer;
	}

	/**
	 * Returns the layer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param layerId the primary key of the layer
	 * @return the layer, or <code>null</code> if a layer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Layer fetchByPrimaryKey(long layerId) throws SystemException {
		return fetchByPrimaryKey((Serializable)layerId);
	}

	/**
	 * Returns all the layers.
	 *
	 * @return the layers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Layer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Layer> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Layer> findAll(int start, int end,
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

		List<Layer> list = (List<Layer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LAYER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LAYER;

				if (pagination) {
					sql = sql.concat(LayerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Layer>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Layer>(list);
				}
				else {
					list = (List<Layer>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the layers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Layer layer : findAll()) {
			remove(layer);
		}
	}

	/**
	 * Returns the number of layers.
	 *
	 * @return the number of layers
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

				Query q = session.createQuery(_SQL_COUNT_LAYER);

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
	 * Initializes the layer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.politaktiv.map.model.Layer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Layer>> listenersList = new ArrayList<ModelListener<Layer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Layer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LayerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LAYER = "SELECT layer FROM Layer layer";
	private static final String _SQL_SELECT_LAYER_WHERE = "SELECT layer FROM Layer layer WHERE ";
	private static final String _SQL_COUNT_LAYER = "SELECT COUNT(layer) FROM Layer layer";
	private static final String _SQL_COUNT_LAYER_WHERE = "SELECT COUNT(layer) FROM Layer layer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "layer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Layer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Layer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LayerPersistenceImpl.class);
	private static Layer _nullLayer = new LayerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Layer> toCacheModel() {
				return _nullLayerCacheModel;
			}
		};

	private static CacheModel<Layer> _nullLayerCacheModel = new CacheModel<Layer>() {
			@Override
			public Layer toEntityModel() {
				return _nullLayer;
			}
		};
}