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

package org.politaktiv.map.model.impl;

import javax.portlet.ValidatorException;

import org.politaktiv.map.MapValidator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The extended model implementation for the Marker service. Represents a row in
 * the &quot;politaktivmap_Marker&quot; database table, with each column mapped
 * to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link org.politaktiv.map.model.Marker} interface.
 * </p>
 *
 * @author Paul Butenko
 */
public class MarkerImpl extends MarkerBaseImpl {

	@JSON
	public boolean isOwner;

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a marker
	 * model instance should use the {@link org.politaktiv.map.model.Marker}
	 * interface instead.
	 */
	public MarkerImpl() {
	}

	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(long invokerId) {
		isOwner = (getUserId() == invokerId);
	}

	public void validate(long userId) throws ValidatorException {
		this.validateUser(userId);
		this.validateLongtitude();
		this.validateLatitude();
		
		this.validateContent();
		this.validateTitle();
	}
	
	private void validateUser(long userId) throws ValidatorException {
		if (userId != getUserId()) {
			throw new ValidatorException("You can't edit this marker", null);
		}
	}

	private void validateLongtitude() throws ValidatorException {
		if (MapValidator.isNotValidCoordinate(getLongitude())) {
			throw new ValidatorException("Longtitude is not valid", null);
		}
	}

	private void validateLatitude() throws ValidatorException {
		if (MapValidator.isNotValidCoordinate(getLatitude())) {
			throw new ValidatorException("Latitude is not valid", null);
		}
	}
	
	private void validateContent() throws ValidatorException {
		if (Validator.isNotNull(getContent()) && getContent().length() > 1024) {
			throw new ValidatorException("Content length is not valid", null);
		}
	}
	
	private void validateTitle() throws ValidatorException {
		if (Validator.isNull(getTitle())) {
			throw new ValidatorException("Title is mandatory", null);
		}
		
		if (getTitle().length() > 75) {
			throw new ValidatorException("Title length is not valid", null);
		}
	}

}