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

import org.politaktiv.map.NoSuchMarkerException;
import org.politaktiv.map.model.Marker;
import org.politaktiv.map.model.impl.MarkerImpl;
import org.politaktiv.map.model.impl.MarkerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the marker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Paul Butenko
 * @see MarkerPersistence
 * @see MarkerUtil
 * @generated
 */
public class MarkerPersistenceImpl extends BasePersistenceImpl<Marker>
	implements MarkerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MarkerUtil} to access the marker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MarkerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, MarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, MarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, MarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, MarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			MarkerModelImpl.USERID_COLUMN_BITMASK |
			MarkerModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the markers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Marker> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the markers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of markers
	 * @param end the upper bound of the range of markers (not inclusive)
	 * @return the range of matching markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Marker> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the markers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of markers
	 * @param end the upper bound of the range of markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Marker> findByUserId(long userId, int start, int end,
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

		List<Marker> list = (List<Marker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Marker marker : list) {
				if ((userId != marker.getUserId())) {
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

			query.append(_SQL_SELECT_MARKER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MarkerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Marker>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Marker>(list);
				}
				else {
					list = (List<Marker>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first marker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marker
	 * @throws org.politaktiv.map.NoSuchMarkerException if a matching marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMarkerException, SystemException {
		Marker marker = fetchByUserId_First(userId, orderByComparator);

		if (marker != null) {
			return marker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarkerException(msg.toString());
	}

	/**
	 * Returns the first marker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching marker, or <code>null</code> if a matching marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Marker> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last marker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marker
	 * @throws org.politaktiv.map.NoSuchMarkerException if a matching marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMarkerException, SystemException {
		Marker marker = fetchByUserId_Last(userId, orderByComparator);

		if (marker != null) {
			return marker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMarkerException(msg.toString());
	}

	/**
	 * Returns the last marker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching marker, or <code>null</code> if a matching marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Marker> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the markers before and after the current marker in the ordered set where userId = &#63;.
	 *
	 * @param markerId the primary key of the current marker
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next marker
	 * @throws org.politaktiv.map.NoSuchMarkerException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker[] findByUserId_PrevAndNext(long markerId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchMarkerException, SystemException {
		Marker marker = findByPrimaryKey(markerId);

		Session session = null;

		try {
			session = openSession();

			Marker[] array = new MarkerImpl[3];

			array[0] = getByUserId_PrevAndNext(session, marker, userId,
					orderByComparator, true);

			array[1] = marker;

			array[2] = getByUserId_PrevAndNext(session, marker, userId,
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

	protected Marker getByUserId_PrevAndNext(Session session, Marker marker,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MARKER_WHERE);

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
			query.append(MarkerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(marker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Marker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the markers where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (Marker marker : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(marker);
		}
	}

	/**
	 * Returns the number of markers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching markers
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

			query.append(_SQL_COUNT_MARKER_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "marker.userId = ?";

	public MarkerPersistenceImpl() {
		setModelClass(Marker.class);
	}

	/**
	 * Caches the marker in the entity cache if it is enabled.
	 *
	 * @param marker the marker
	 */
	@Override
	public void cacheResult(Marker marker) {
		EntityCacheUtil.putResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerImpl.class, marker.getPrimaryKey(), marker);

		marker.resetOriginalValues();
	}

	/**
	 * Caches the markers in the entity cache if it is enabled.
	 *
	 * @param markers the markers
	 */
	@Override
	public void cacheResult(List<Marker> markers) {
		for (Marker marker : markers) {
			if (EntityCacheUtil.getResult(
						MarkerModelImpl.ENTITY_CACHE_ENABLED, MarkerImpl.class,
						marker.getPrimaryKey()) == null) {
				cacheResult(marker);
			}
			else {
				marker.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all markers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MarkerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MarkerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the marker.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Marker marker) {
		EntityCacheUtil.removeResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerImpl.class, marker.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Marker> markers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Marker marker : markers) {
			EntityCacheUtil.removeResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
				MarkerImpl.class, marker.getPrimaryKey());
		}
	}

	/**
	 * Creates a new marker with the primary key. Does not add the marker to the database.
	 *
	 * @param markerId the primary key for the new marker
	 * @return the new marker
	 */
	@Override
	public Marker create(long markerId) {
		Marker marker = new MarkerImpl();

		marker.setNew(true);
		marker.setPrimaryKey(markerId);

		return marker;
	}

	/**
	 * Removes the marker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param markerId the primary key of the marker
	 * @return the marker that was removed
	 * @throws org.politaktiv.map.NoSuchMarkerException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker remove(long markerId)
		throws NoSuchMarkerException, SystemException {
		return remove((Serializable)markerId);
	}

	/**
	 * Removes the marker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the marker
	 * @return the marker that was removed
	 * @throws org.politaktiv.map.NoSuchMarkerException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker remove(Serializable primaryKey)
		throws NoSuchMarkerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Marker marker = (Marker)session.get(MarkerImpl.class, primaryKey);

			if (marker == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMarkerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(marker);
		}
		catch (NoSuchMarkerException nsee) {
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
	protected Marker removeImpl(Marker marker) throws SystemException {
		marker = toUnwrappedModel(marker);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(marker)) {
				marker = (Marker)session.get(MarkerImpl.class,
						marker.getPrimaryKeyObj());
			}

			if (marker != null) {
				session.delete(marker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (marker != null) {
			clearCache(marker);
		}

		return marker;
	}

	@Override
	public Marker updateImpl(org.politaktiv.map.model.Marker marker)
		throws SystemException {
		marker = toUnwrappedModel(marker);

		boolean isNew = marker.isNew();

		MarkerModelImpl markerModelImpl = (MarkerModelImpl)marker;

		Session session = null;

		try {
			session = openSession();

			if (marker.isNew()) {
				session.save(marker);

				marker.setNew(false);
			}
			else {
				session.merge(marker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MarkerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((markerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { markerModelImpl.getOriginalUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { markerModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
			MarkerImpl.class, marker.getPrimaryKey(), marker);

		return marker;
	}

	protected Marker toUnwrappedModel(Marker marker) {
		if (marker instanceof MarkerImpl) {
			return marker;
		}

		MarkerImpl markerImpl = new MarkerImpl();

		markerImpl.setNew(marker.isNew());
		markerImpl.setPrimaryKey(marker.getPrimaryKey());

		markerImpl.setMarkerId(marker.getMarkerId());
		markerImpl.setGroupId(marker.getGroupId());
		markerImpl.setCompanyId(marker.getCompanyId());
		markerImpl.setUserId(marker.getUserId());
		markerImpl.setUserName(marker.getUserName());
		markerImpl.setCreateDate(marker.getCreateDate());
		markerImpl.setModifiedDate(marker.getModifiedDate());
		markerImpl.setTitle(marker.getTitle());
		markerImpl.setContent(marker.getContent());
		markerImpl.setLongitude(marker.getLongitude());
		markerImpl.setLatitude(marker.getLatitude());

		return markerImpl;
	}

	/**
	 * Returns the marker with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the marker
	 * @return the marker
	 * @throws org.politaktiv.map.NoSuchMarkerException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMarkerException, SystemException {
		Marker marker = fetchByPrimaryKey(primaryKey);

		if (marker == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMarkerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return marker;
	}

	/**
	 * Returns the marker with the primary key or throws a {@link org.politaktiv.map.NoSuchMarkerException} if it could not be found.
	 *
	 * @param markerId the primary key of the marker
	 * @return the marker
	 * @throws org.politaktiv.map.NoSuchMarkerException if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker findByPrimaryKey(long markerId)
		throws NoSuchMarkerException, SystemException {
		return findByPrimaryKey((Serializable)markerId);
	}

	/**
	 * Returns the marker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the marker
	 * @return the marker, or <code>null</code> if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Marker marker = (Marker)EntityCacheUtil.getResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
				MarkerImpl.class, primaryKey);

		if (marker == _nullMarker) {
			return null;
		}

		if (marker == null) {
			Session session = null;

			try {
				session = openSession();

				marker = (Marker)session.get(MarkerImpl.class, primaryKey);

				if (marker != null) {
					cacheResult(marker);
				}
				else {
					EntityCacheUtil.putResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
						MarkerImpl.class, primaryKey, _nullMarker);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(MarkerModelImpl.ENTITY_CACHE_ENABLED,
					MarkerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return marker;
	}

	/**
	 * Returns the marker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param markerId the primary key of the marker
	 * @return the marker, or <code>null</code> if a marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Marker fetchByPrimaryKey(long markerId) throws SystemException {
		return fetchByPrimaryKey((Serializable)markerId);
	}

	/**
	 * Returns all the markers.
	 *
	 * @return the markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Marker> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the markers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of markers
	 * @param end the upper bound of the range of markers (not inclusive)
	 * @return the range of markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Marker> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the markers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.politaktiv.map.model.impl.MarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of markers
	 * @param end the upper bound of the range of markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Marker> findAll(int start, int end,
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

		List<Marker> list = (List<Marker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MARKER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MARKER;

				if (pagination) {
					sql = sql.concat(MarkerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Marker>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Marker>(list);
				}
				else {
					list = (List<Marker>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the markers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Marker marker : findAll()) {
			remove(marker);
		}
	}

	/**
	 * Returns the number of markers.
	 *
	 * @return the number of markers
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

				Query q = session.createQuery(_SQL_COUNT_MARKER);

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
	 * Initializes the marker persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.politaktiv.map.model.Marker")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Marker>> listenersList = new ArrayList<ModelListener<Marker>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Marker>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(MarkerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_MARKER = "SELECT marker FROM Marker marker";
	private static final String _SQL_SELECT_MARKER_WHERE = "SELECT marker FROM Marker marker WHERE ";
	private static final String _SQL_COUNT_MARKER = "SELECT COUNT(marker) FROM Marker marker";
	private static final String _SQL_COUNT_MARKER_WHERE = "SELECT COUNT(marker) FROM Marker marker WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "marker.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Marker exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Marker exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MarkerPersistenceImpl.class);
	private static Marker _nullMarker = new MarkerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Marker> toCacheModel() {
				return _nullMarkerCacheModel;
			}
		};

	private static CacheModel<Marker> _nullMarkerCacheModel = new CacheModel<Marker>() {
			@Override
			public Marker toEntityModel() {
				return _nullMarker;
			}
		};
}