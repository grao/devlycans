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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.slc.sli.headerfooter.model.HeaderFooter;

import java.util.List;

/**
 * The persistence utility for the header footer service. This utility wraps {@link HeaderFooterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manoj
 * @see HeaderFooterPersistence
 * @see HeaderFooterPersistenceImpl
 * @generated
 */
public class HeaderFooterUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(HeaderFooter headerFooter) {
		getPersistence().clearCache(headerFooter);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HeaderFooter> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HeaderFooter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HeaderFooter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static HeaderFooter update(HeaderFooter headerFooter, boolean merge)
		throws SystemException {
		return getPersistence().update(headerFooter, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static HeaderFooter update(HeaderFooter headerFooter, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(headerFooter, merge, serviceContext);
	}

	/**
	* Caches the header footer in the entity cache if it is enabled.
	*
	* @param headerFooter the header footer
	*/
	public static void cacheResult(
		org.slc.sli.headerfooter.model.HeaderFooter headerFooter) {
		getPersistence().cacheResult(headerFooter);
	}

	/**
	* Caches the header footers in the entity cache if it is enabled.
	*
	* @param headerFooters the header footers
	*/
	public static void cacheResult(
		java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> headerFooters) {
		getPersistence().cacheResult(headerFooters);
	}

	/**
	* Creates a new header footer with the primary key. Does not add the header footer to the database.
	*
	* @param id the primary key for the new header footer
	* @return the new header footer
	*/
	public static org.slc.sli.headerfooter.model.HeaderFooter create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the header footer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the header footer
	* @return the header footer that was removed
	* @throws org.slc.sli.headerfooter.NoSuchHeaderFooterException if a header footer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.slc.sli.headerfooter.model.HeaderFooter remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.slc.sli.headerfooter.NoSuchHeaderFooterException {
		return getPersistence().remove(id);
	}

	public static org.slc.sli.headerfooter.model.HeaderFooter updateImpl(
		org.slc.sli.headerfooter.model.HeaderFooter headerFooter, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(headerFooter, merge);
	}

	/**
	* Returns the header footer with the primary key or throws a {@link org.slc.sli.headerfooter.NoSuchHeaderFooterException} if it could not be found.
	*
	* @param id the primary key of the header footer
	* @return the header footer
	* @throws org.slc.sli.headerfooter.NoSuchHeaderFooterException if a header footer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.slc.sli.headerfooter.model.HeaderFooter findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.slc.sli.headerfooter.NoSuchHeaderFooterException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the header footer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the header footer
	* @return the header footer, or <code>null</code> if a header footer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.slc.sli.headerfooter.model.HeaderFooter fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the header footers where type = &#63;.
	*
	* @param type the type
	* @return the matching header footers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type);
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
	public static java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findByType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end);
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
	public static java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findByType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end, orderByComparator);
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
	public static org.slc.sli.headerfooter.model.HeaderFooter findByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.slc.sli.headerfooter.NoSuchHeaderFooterException {
		return getPersistence().findByType_First(type, orderByComparator);
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
	public static org.slc.sli.headerfooter.model.HeaderFooter findByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.slc.sli.headerfooter.NoSuchHeaderFooterException {
		return getPersistence().findByType_Last(type, orderByComparator);
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
	public static org.slc.sli.headerfooter.model.HeaderFooter[] findByType_PrevAndNext(
		long id, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.slc.sli.headerfooter.NoSuchHeaderFooterException {
		return getPersistence()
				   .findByType_PrevAndNext(id, type, orderByComparator);
	}

	/**
	* Returns all the header footers.
	*
	* @return the header footers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the header footers where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(type);
	}

	/**
	* Removes all the header footers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of header footers where type = &#63;.
	*
	* @param type the type
	* @return the number of matching header footers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(type);
	}

	/**
	* Returns the number of header footers.
	*
	* @return the number of header footers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HeaderFooterPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HeaderFooterPersistence)PortletBeanLocatorUtil.locate(org.slc.sli.headerfooter.service.ClpSerializer.getServletContextName(),
					HeaderFooterPersistence.class.getName());

			ReferenceRegistry.registerReference(HeaderFooterUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(HeaderFooterPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(HeaderFooterUtil.class,
			"_persistence");
	}

	private static HeaderFooterPersistence _persistence;
}