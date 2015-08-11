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

package org.politaktiv.map.service.impl;

import java.util.Date;
import java.util.List;

import javax.portlet.ValidatorException;

import org.apache.log4j.Logger;
import org.politaktiv.map.model.Marker;
import org.politaktiv.map.service.MarkerLocalServiceUtil;
import org.politaktiv.map.service.base.MarkerServiceBaseImpl;
import org.politaktiv.map.service.persistence.MarkerUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.auth.PrincipalException;

/**
 * The implementation of the marker remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.politaktiv.map.service.MarkerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Paul Butenko
 * @see org.politaktiv.map.service.base.MarkerServiceBaseImpl
 * @see org.politaktiv.map.service.MarkerServiceUtil
 */
public class MarkerServiceImpl extends MarkerServiceBaseImpl {
	private static final Logger LOGGER = Logger.getLogger(MarkerServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * org.politaktiv.map.service.MarkerServiceUtil} to access the marker remote
	 * service.
	 */

	public Marker addMarker(long groupId, long companyId, String title, String content, String longitude,
			String latitude) throws SystemException, ValidatorException, PrincipalException {

		User user = getPermissionChecker().getUser();
		long userId = user.getUserId();

		Date currentDate = new Date();

		long markerId = CounterLocalServiceUtil.increment(Marker.class.getName());
		Marker marker = MarkerLocalServiceUtil.createMarker(markerId);

		marker.setGroupId(groupId);
		marker.setCompanyId(companyId);

		marker.setUserId(userId);
		marker.setUserName(user.getFullName());
		marker.setCreateDate(currentDate);
		marker.setModifiedDate(currentDate);

		marker.setTitle(title);
		marker.setContent(content);
		marker.setLongitude(longitude);
		marker.setLatitude(latitude);

		marker.validate(userId);

		marker = MarkerLocalServiceUtil.addMarker(marker);
		
		marker.setOwner(userId);

		LOGGER.info("Marker: " + title + " for user: " + userId + " has been created.");

		return marker;
	}

	public void updateMarker(long markerId, String title, String content, String longitude, String latitude)
			throws SystemException, ValidatorException, PortalException {

		try {
			User user = getPermissionChecker().getUser();
			long userId = user.getUserId();

			Marker marker = MarkerLocalServiceUtil.getMarker(markerId);

			Date currentDate = new Date();

			marker.setModifiedDate(currentDate);

			marker.setTitle(title);
			marker.setContent(content);
			marker.setLongitude(longitude);
			marker.setLatitude(latitude);

			marker.validate(userId);

			MarkerLocalServiceUtil.updateMarker(marker);

			LOGGER.info("Marker: " + marker.getMarkerId() + " for user: " + userId + " has been updated.");
		} catch (PrincipalException e) {
			LOGGER.info("Can't get permission checker " + e.getMessage());
		}

	}

	@AccessControlled(guestAccessEnabled = true)
	public List<Marker> getAllMarkers() throws SystemException {

		List<Marker> markers = MarkerUtil.findAll();

		try {
			long currentUserId = getPermissionChecker().getUserId();

			for (Marker marker : markers) {
				marker.setOwner(currentUserId);
				marker.setContent(HtmlUtil.escape(marker.getContent()));
				marker.setTitle(HtmlUtil.escape(marker.getTitle()));
			}

		} catch (PrincipalException e) {
			LOGGER.info("Can't get permission checker " + e.getMessage());
		}

		return markers;
	}

	public List<Marker> getMarkersByUserId(long userId) throws SystemException, ValidatorException {

		List<Marker> markers = MarkerUtil.findByUserId(userId);

		try {
			long currentUserId = getPermissionChecker().getUserId();

			if (userId != getUserId()) {
				throw new ValidatorException("You can't get markers for another user", null);
			}

			for (Marker marker : markers) {
				marker.setOwner(currentUserId);
				marker.setContent(HtmlUtil.escape(marker.getContent()));
				marker.setTitle(HtmlUtil.escape(marker.getTitle()));
			}

		} catch (PrincipalException e) {
			LOGGER.info("Can't get permission checker " + e.getMessage());
		}

		return markers;
	}

}