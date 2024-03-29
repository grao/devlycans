/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package org.slc.sli.headerfooter.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.slc.sli.headerfooter.NoSuchHeaderFooterException;
import org.slc.sli.headerfooter.model.HeaderFooter;
import org.slc.sli.headerfooter.model.impl.HeaderFooterImpl;
import org.slc.sli.headerfooter.model.impl.HeaderFooterModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the header footer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manoj
 * @see HeaderFooterPersistence
 * @see HeaderFooterUtil
 * @generated
 */
public class HeaderFooterPersistenceImpl extends BasePersistenceImpl<HeaderFooter>
	implements HeaderFooterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HeaderFooterUtil} to access the header footer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HeaderFooterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
			HeaderFooterModelImpl.FINDER_CACHE_ENABLED, HeaderFooterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
			HeaderFooterModelImpl.FINDER_CACHE_ENABLED, HeaderFooterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { String.class.getName() },
			HeaderFooterModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
			HeaderFooterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
			HeaderFooterModelImpl.FINDER_CACHE_ENABLED, HeaderFooterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
			HeaderFooterModelImpl.FINDER_CACHE_ENABLED, HeaderFooterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
			HeaderFooterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the header footer in the entity cache if it is enabled.
	 *
	 * @param headerFooter the header footer
	 */
	public void cacheResult(HeaderFooter headerFooter) {
		EntityCacheUtil.putResult(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
			HeaderFooterImpl.class, headerFooter.getPrimaryKey(), headerFooter);

		headerFooter.resetOriginalValues();
	}

	/**
	 * Caches the header footers in the entity cache if it is enabled.
	 *
	 * @param headerFooters the header footers
	 */
	public void cacheResult(List<HeaderFooter> headerFooters) {
		for (HeaderFooter headerFooter : headerFooters) {
			if (EntityCacheUtil.getResult(
						HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
						HeaderFooterImpl.class, headerFooter.getPrimaryKey()) == null) {
				cacheResult(headerFooter);
			}
			else {
				headerFooter.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all header footers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HeaderFooterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HeaderFooterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the header footer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HeaderFooter headerFooter) {
		EntityCacheUtil.removeResult(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
			HeaderFooterImpl.class, headerFooter.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HeaderFooter> headerFooters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HeaderFooter headerFooter : headerFooters) {
			EntityCacheUtil.removeResult(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
				HeaderFooterImpl.class, headerFooter.getPrimaryKey());
		}
	}

	/**
	 * Creates a new header footer with the primary key. Does not add the header footer to the database.
	 *
	 * @param id the primary key for the new header footer
	 * @return the new header footer
	 */
	public HeaderFooter create(long id) {
		HeaderFooter headerFooter = new HeaderFooterImpl();

		headerFooter.setNew(true);
		headerFooter.setPrimaryKey(id);

		return headerFooter;
	}

	/**
	 * Removes the header footer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the header footer
	 * @return the header footer that was removed
	 * @throws org.slc.sli.headerfooter.NoSuchHeaderFooterException if a header footer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeaderFooter remove(long id)
		throws NoSuchHeaderFooterException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the header footer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the header footer
	 * @return the header footer that was removed
	 * @throws org.slc.sli.headerfooter.NoSuchHeaderFooterException if a header footer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HeaderFooter remove(Serializable primaryKey)
		throws NoSuchHeaderFooterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HeaderFooter headerFooter = (HeaderFooter)session.get(HeaderFooterImpl.class,
					primaryKey);

			if (headerFooter == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHeaderFooterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(headerFooter);
		}
		catch (NoSuchHeaderFooterException nsee) {
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
	protected HeaderFooter removeImpl(HeaderFooter headerFooter)
		throws SystemException {
		headerFooter = toUnwrappedModel(headerFooter);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, headerFooter);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(headerFooter);

		return headerFooter;
	}

	@Override
	public HeaderFooter updateImpl(
		org.slc.sli.headerfooter.model.HeaderFooter headerFooter, boolean merge)
		throws SystemException {
		headerFooter = toUnwrappedModel(headerFooter);

		boolean isNew = headerFooter.isNew();

		HeaderFooterModelImpl headerFooterModelImpl = (HeaderFooterModelImpl)headerFooter;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, headerFooter, merge);

			headerFooter.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HeaderFooterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((headerFooterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						headerFooterModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { headerFooterModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
			HeaderFooterImpl.class, headerFooter.getPrimaryKey(), headerFooter);

		return headerFooter;
	}

	protected HeaderFooter toUnwrappedModel(HeaderFooter headerFooter) {
		if (headerFooter instanceof HeaderFooterImpl) {
			return headerFooter;
		}

		HeaderFooterImpl headerFooterImpl = new HeaderFooterImpl();

		headerFooterImpl.setNew(headerFooter.isNew());
		headerFooterImpl.setPrimaryKey(headerFooter.getPrimaryKey());

		headerFooterImpl.setId(headerFooter.getId());
		headerFooterImpl.setType(headerFooter.getType());
		headerFooterImpl.setData(headerFooter.getData());

		return headerFooterImpl;
	}

	/**
	 * Returns the header footer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the header footer
	 * @return the header footer
	 * @throws com.liferay.portal.NoSuchModelException if a header footer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HeaderFooter findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the header footer with the primary key or throws a {@link org.slc.sli.headerfooter.NoSuchHeaderFooterException} if it could not be found.
	 *
	 * @param id the primary key of the header footer
	 * @return the header footer
	 * @throws org.slc.sli.headerfooter.NoSuchHeaderFooterException if a header footer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeaderFooter findByPrimaryKey(long id)
		throws NoSuchHeaderFooterException, SystemException {
		HeaderFooter headerFooter = fetchByPrimaryKey(id);

		if (headerFooter == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchHeaderFooterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return headerFooter;
	}

	/**
	 * Returns the header footer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the header footer
	 * @return the header footer, or <code>null</code> if a header footer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HeaderFooter fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the header footer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the header footer
	 * @return the header footer, or <code>null</code> if a header footer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeaderFooter fetchByPrimaryKey(long id) throws SystemException {
		HeaderFooter headerFooter = (HeaderFooter)EntityCacheUtil.getResult(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
				HeaderFooterImpl.class, id);

		if (headerFooter == _nullHeaderFooter) {
			return null;
		}

		if (headerFooter == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				headerFooter = (HeaderFooter)session.get(HeaderFooterImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (headerFooter != null) {
					cacheResult(headerFooter);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(HeaderFooterModelImpl.ENTITY_CACHE_ENABLED,
						HeaderFooterImpl.class, id, _nullHeaderFooter);
				}

				closeSession(session);
			}
		}

		return headerFooter;
	}

	/**
	 * Returns all the header footers where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching header footers
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeaderFooter> findByType(String type) throws SystemException {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the header footers where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of header footers
	 * @param end the upper bound of the range of header footers (not inclusive)
	 * @return the range of matching header footers
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeaderFooter> findByType(String type, int start, int end)
		throws SystemException {
		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the header footers where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of header footers
	 * @param end the upper bound of the range of header footers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching header footers
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeaderFooter> findByType(String type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<HeaderFooter> list = (List<HeaderFooter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_HEADERFOOTER_WHERE);

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else {
				if (type.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TYPE_TYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TYPE_TYPE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (type != null) {
					qPos.add(type);
				}

				list = (List<HeaderFooter>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first header footer in the ordered set where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching header footer
	 * @throws org.slc.sli.headerfooter.NoSuchHeaderFooterException if a matching header footer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeaderFooter findByType_First(String type,
		OrderByComparator orderByComparator)
		throws NoSuchHeaderFooterException, SystemException {
		List<HeaderFooter> list = findByType(type, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHeaderFooterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last header footer in the ordered set where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching header footer
	 * @throws org.slc.sli.headerfooter.NoSuchHeaderFooterException if a matching header footer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeaderFooter findByType_Last(String type,
		OrderByComparator orderByComparator)
		throws NoSuchHeaderFooterException, SystemException {
		int count = countByType(type);

		List<HeaderFooter> list = findByType(type, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchHeaderFooterException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the header footers before and after the current header footer in the ordered set where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param id the primary key of the current header footer
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next header footer
	 * @throws org.slc.sli.headerfooter.NoSuchHeaderFooterException if a header footer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public HeaderFooter[] findByType_PrevAndNext(long id, String type,
		OrderByComparator orderByComparator)
		throws NoSuchHeaderFooterException, SystemException {
		HeaderFooter headerFooter = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			HeaderFooter[] array = new HeaderFooterImpl[3];

			array[0] = getByType_PrevAndNext(session, headerFooter, type,
					orderByComparator, true);

			array[1] = headerFooter;

			array[2] = getByType_PrevAndNext(session, headerFooter, type,
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

	protected HeaderFooter getByType_PrevAndNext(Session session,
		HeaderFooter headerFooter, String type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HEADERFOOTER_WHERE);

		if (type == null) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_1);
		}
		else {
			if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (type != null) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(headerFooter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HeaderFooter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the header footers.
	 *
	 * @return the header footers
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeaderFooter> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the header footers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of header footers
	 * @param end the upper bound of the range of header footers (not inclusive)
	 * @return the range of header footers
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeaderFooter> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the header footers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of header footers
	 * @param end the upper bound of the range of header footers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of header footers
	 * @throws SystemException if a system exception occurred
	 */
	public List<HeaderFooter> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<HeaderFooter> list = (List<HeaderFooter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HEADERFOOTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HEADERFOOTER;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<HeaderFooter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<HeaderFooter>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the header footers where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByType(String type) throws SystemException {
		for (HeaderFooter headerFooter : findByType(type)) {
			remove(headerFooter);
		}
	}

	/**
	 * Removes all the header footers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (HeaderFooter headerFooter : findAll()) {
			remove(headerFooter);
		}
	}

	/**
	 * Returns the number of header footers where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching header footers
	 * @throws SystemException if a system exception occurred
	 */
	public int countByType(String type) throws SystemException {
		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HEADERFOOTER_WHERE);

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else {
				if (type.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TYPE_TYPE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TYPE_TYPE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (type != null) {
					qPos.add(type);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of header footers.
	 *
	 * @return the number of header footers
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HEADERFOOTER);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the header footer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.slc.sli.headerfooter.model.HeaderFooter")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HeaderFooter>> listenersList = new ArrayList<ModelListener<HeaderFooter>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HeaderFooter>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(HeaderFooterImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = HeaderFooterPersistence.class)
	protected HeaderFooterPersistence headerFooterPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_HEADERFOOTER = "SELECT headerFooter FROM HeaderFooter headerFooter";
	private static final String _SQL_SELECT_HEADERFOOTER_WHERE = "SELECT headerFooter FROM HeaderFooter headerFooter WHERE ";
	private static final String _SQL_COUNT_HEADERFOOTER = "SELECT COUNT(headerFooter) FROM HeaderFooter headerFooter";
	private static final String _SQL_COUNT_HEADERFOOTER_WHERE = "SELECT COUNT(headerFooter) FROM HeaderFooter headerFooter WHERE ";
	private static final String _FINDER_COLUMN_TYPE_TYPE_1 = "headerFooter.type IS NULL";
	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "headerFooter.type = ?";
	private static final String _FINDER_COLUMN_TYPE_TYPE_3 = "(headerFooter.type IS NULL OR headerFooter.type = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "headerFooter.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HeaderFooter exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HeaderFooter exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HeaderFooterPersistenceImpl.class);
	private static HeaderFooter _nullHeaderFooter = new HeaderFooterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HeaderFooter> toCacheModel() {
				return _nullHeaderFooterCacheModel;
			}
		};

	private static CacheModel<HeaderFooter> _nullHeaderFooterCacheModel = new CacheModel<HeaderFooter>() {
			public HeaderFooter toEntityModel() {
				return _nullHeaderFooter;
			}
		};
}