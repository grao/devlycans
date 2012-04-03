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

import com.liferay.portal.service.persistence.BasePersistence;

import org.slc.sli.headerfooter.model.HeaderFooter;

/**
 * The persistence interface for the header footer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author manoj
 * @see HeaderFooterPersistenceImpl
 * @see HeaderFooterUtil
 * @generated
 */
public interface HeaderFooterPersistence extends BasePersistence<HeaderFooter> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HeaderFooterUtil} to access the header footer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the header footer in the entity cache if it is enabled.
	*
	* @param headerFooter the header footer
	*/
	public void cacheResult(
		org.slc.sli.headerfooter.model.HeaderFooter headerFooter);

	/**
	* Caches the header footers in the entity cache if it is enabled.
	*
	* @param headerFooters the header footers
	*/
	public void cacheResult(
		java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> headerFooters);

	/**
	* Creates a new header footer with the primary key. Does not add the header footer to the database.
	*
	* @param id the primary key for the new header footer
	* @return the new header footer
	*/
	public org.slc.sli.headerfooter.model.HeaderFooter create(long id);

	/**
	* Removes the header footer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the header footer
	* @return the header footer that was removed
	* @throws org.slc.sli.headerfooter.NoSuchHeaderFooterException if a header footer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.slc.sli.headerfooter.model.HeaderFooter remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.slc.sli.headerfooter.NoSuchHeaderFooterException;

	public org.slc.sli.headerfooter.model.HeaderFooter updateImpl(
		org.slc.sli.headerfooter.model.HeaderFooter headerFooter, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the header footer with the primary key or throws a {@link org.slc.sli.headerfooter.NoSuchHeaderFooterException} if it could not be found.
	*
	* @param id the primary key of the header footer
	* @return the header footer
	* @throws org.slc.sli.headerfooter.NoSuchHeaderFooterException if a header footer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.slc.sli.headerfooter.model.HeaderFooter findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.slc.sli.headerfooter.NoSuchHeaderFooterException;

	/**
	* Returns the header footer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the header footer
	* @return the header footer, or <code>null</code> if a header footer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.slc.sli.headerfooter.model.HeaderFooter fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the header footers where type = &#63;.
	*
	* @param type the type
	* @return the matching header footers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findByType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findByType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.slc.sli.headerfooter.model.HeaderFooter findByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.slc.sli.headerfooter.NoSuchHeaderFooterException;

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
	public org.slc.sli.headerfooter.model.HeaderFooter findByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.slc.sli.headerfooter.NoSuchHeaderFooterException;

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
	public org.slc.sli.headerfooter.model.HeaderFooter[] findByType_PrevAndNext(
		long id, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.slc.sli.headerfooter.NoSuchHeaderFooterException;

	/**
	* Returns all the header footers.
	*
	* @return the header footers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.slc.sli.headerfooter.model.HeaderFooter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the header footers where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the header footers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of header footers where type = &#63;.
	*
	* @param type the type
	* @return the number of matching header footers
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of header footers.
	*
	* @return the number of header footers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}