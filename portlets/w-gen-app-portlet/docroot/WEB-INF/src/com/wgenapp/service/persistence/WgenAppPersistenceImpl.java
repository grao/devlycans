/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.wgenapp.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.wgenapp.NoSuchWgenAppException;

import com.wgenapp.model.WgenApp;
import com.wgenapp.model.impl.WgenAppImpl;
import com.wgenapp.model.impl.WgenAppModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the wgen app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WgenAppPersistence
 * @see WgenAppUtil
 * @generated
 */
public class WgenAppPersistenceImpl extends BasePersistenceImpl<WgenApp>
	implements WgenAppPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WgenAppUtil} to access the wgen app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WgenAppImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WgenAppModelImpl.ENTITY_CACHE_ENABLED,
			WgenAppModelImpl.FINDER_CACHE_ENABLED, WgenAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WgenAppModelImpl.ENTITY_CACHE_ENABLED,
			WgenAppModelImpl.FINDER_CACHE_ENABLED, WgenAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WgenAppModelImpl.ENTITY_CACHE_ENABLED,
			WgenAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the wgen app in the entity cache if it is enabled.
	 *
	 * @param wgenApp the wgen app
	 */
	public void cacheResult(WgenApp wgenApp) {
		EntityCacheUtil.putResult(WgenAppModelImpl.ENTITY_CACHE_ENABLED,
			WgenAppImpl.class, wgenApp.getPrimaryKey(), wgenApp);

		wgenApp.resetOriginalValues();
	}

	/**
	 * Caches the wgen apps in the entity cache if it is enabled.
	 *
	 * @param wgenApps the wgen apps
	 */
	public void cacheResult(List<WgenApp> wgenApps) {
		for (WgenApp wgenApp : wgenApps) {
			if (EntityCacheUtil.getResult(
						WgenAppModelImpl.ENTITY_CACHE_ENABLED,
						WgenAppImpl.class, wgenApp.getPrimaryKey()) == null) {
				cacheResult(wgenApp);
			}
			else {
				wgenApp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all wgen apps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WgenAppImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WgenAppImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the wgen app.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WgenApp wgenApp) {
		EntityCacheUtil.removeResult(WgenAppModelImpl.ENTITY_CACHE_ENABLED,
			WgenAppImpl.class, wgenApp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Creates a new wgen app with the primary key. Does not add the wgen app to the database.
	 *
	 * @param WgenAppId the primary key for the new wgen app
	 * @return the new wgen app
	 */
	public WgenApp create(long WgenAppId) {
		WgenApp wgenApp = new WgenAppImpl();

		wgenApp.setNew(true);
		wgenApp.setPrimaryKey(WgenAppId);

		return wgenApp;
	}

	/**
	 * Removes the wgen app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the wgen app
	 * @return the wgen app that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a wgen app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WgenApp remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the wgen app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param WgenAppId the primary key of the wgen app
	 * @return the wgen app that was removed
	 * @throws com.wgenapp.NoSuchWgenAppException if a wgen app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WgenApp remove(long WgenAppId)
		throws NoSuchWgenAppException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WgenApp wgenApp = (WgenApp)session.get(WgenAppImpl.class,
					Long.valueOf(WgenAppId));

			if (wgenApp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + WgenAppId);
				}

				throw new NoSuchWgenAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					WgenAppId);
			}

			return wgenAppPersistence.remove(wgenApp);
		}
		catch (NoSuchWgenAppException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes the wgen app from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wgenApp the wgen app
	 * @return the wgen app that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WgenApp remove(WgenApp wgenApp) throws SystemException {
		return super.remove(wgenApp);
	}

	@Override
	protected WgenApp removeImpl(WgenApp wgenApp) throws SystemException {
		wgenApp = toUnwrappedModel(wgenApp);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, wgenApp);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		EntityCacheUtil.removeResult(WgenAppModelImpl.ENTITY_CACHE_ENABLED,
			WgenAppImpl.class, wgenApp.getPrimaryKey());

		return wgenApp;
	}

	@Override
	public WgenApp updateImpl(com.wgenapp.model.WgenApp wgenApp, boolean merge)
		throws SystemException {
		wgenApp = toUnwrappedModel(wgenApp);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, wgenApp, merge);

			wgenApp.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(WgenAppModelImpl.ENTITY_CACHE_ENABLED,
			WgenAppImpl.class, wgenApp.getPrimaryKey(), wgenApp);

		return wgenApp;
	}

	protected WgenApp toUnwrappedModel(WgenApp wgenApp) {
		if (wgenApp instanceof WgenAppImpl) {
			return wgenApp;
		}

		WgenAppImpl wgenAppImpl = new WgenAppImpl();

		wgenAppImpl.setNew(wgenApp.isNew());
		wgenAppImpl.setPrimaryKey(wgenApp.getPrimaryKey());

		wgenAppImpl.setWgenAppId(wgenApp.getWgenAppId());
		wgenAppImpl.setWgenAppTitle(wgenApp.getWgenAppTitle());
		wgenAppImpl.setWgenAppDescription(wgenApp.getWgenAppDescription());
		wgenAppImpl.setWgenAppURL(wgenApp.getWgenAppURL());

		return wgenAppImpl;
	}

	/**
	 * Returns the wgen app with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the wgen app
	 * @return the wgen app
	 * @throws com.liferay.portal.NoSuchModelException if a wgen app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WgenApp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the wgen app with the primary key or throws a {@link com.wgenapp.NoSuchWgenAppException} if it could not be found.
	 *
	 * @param WgenAppId the primary key of the wgen app
	 * @return the wgen app
	 * @throws com.wgenapp.NoSuchWgenAppException if a wgen app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WgenApp findByPrimaryKey(long WgenAppId)
		throws NoSuchWgenAppException, SystemException {
		WgenApp wgenApp = fetchByPrimaryKey(WgenAppId);

		if (wgenApp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + WgenAppId);
			}

			throw new NoSuchWgenAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				WgenAppId);
		}

		return wgenApp;
	}

	/**
	 * Returns the wgen app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the wgen app
	 * @return the wgen app, or <code>null</code> if a wgen app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WgenApp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the wgen app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param WgenAppId the primary key of the wgen app
	 * @return the wgen app, or <code>null</code> if a wgen app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public WgenApp fetchByPrimaryKey(long WgenAppId) throws SystemException {
		WgenApp wgenApp = (WgenApp)EntityCacheUtil.getResult(WgenAppModelImpl.ENTITY_CACHE_ENABLED,
				WgenAppImpl.class, WgenAppId);

		if (wgenApp == _nullWgenApp) {
			return null;
		}

		if (wgenApp == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				wgenApp = (WgenApp)session.get(WgenAppImpl.class,
						Long.valueOf(WgenAppId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (wgenApp != null) {
					cacheResult(wgenApp);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(WgenAppModelImpl.ENTITY_CACHE_ENABLED,
						WgenAppImpl.class, WgenAppId, _nullWgenApp);
				}

				closeSession(session);
			}
		}

		return wgenApp;
	}

	/**
	 * Returns all the wgen apps.
	 *
	 * @return the wgen apps
	 * @throws SystemException if a system exception occurred
	 */
	public List<WgenApp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wgen apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of wgen apps
	 * @param end the upper bound of the range of wgen apps (not inclusive)
	 * @return the range of wgen apps
	 * @throws SystemException if a system exception occurred
	 */
	public List<WgenApp> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the wgen apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of wgen apps
	 * @param end the upper bound of the range of wgen apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of wgen apps
	 * @throws SystemException if a system exception occurred
	 */
	public List<WgenApp> findAll(int start, int end,
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

		List<WgenApp> list = (List<WgenApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WGENAPP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WGENAPP;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<WgenApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<WgenApp>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the wgen apps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (WgenApp wgenApp : findAll()) {
			wgenAppPersistence.remove(wgenApp);
		}
	}

	/**
	 * Returns the number of wgen apps.
	 *
	 * @return the number of wgen apps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WGENAPP);

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
	 * Initializes the wgen app persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.wgenapp.model.WgenApp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WgenApp>> listenersList = new ArrayList<ModelListener<WgenApp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WgenApp>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WgenAppImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = WgenAppPersistence.class)
	protected WgenAppPersistence wgenAppPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_WGENAPP = "SELECT wgenApp FROM WgenApp wgenApp";
	private static final String _SQL_COUNT_WGENAPP = "SELECT COUNT(wgenApp) FROM WgenApp wgenApp";
	private static final String _ORDER_BY_ENTITY_ALIAS = "wgenApp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WgenApp exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WgenAppPersistenceImpl.class);
	private static WgenApp _nullWgenApp = new WgenAppImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WgenApp> toCacheModel() {
				return _nullWgenAppCacheModel;
			}
		};

	private static CacheModel<WgenApp> _nullWgenAppCacheModel = new CacheModel<WgenApp>() {
			public WgenApp toEntityModel() {
				return _nullWgenApp;
			}
		};
}