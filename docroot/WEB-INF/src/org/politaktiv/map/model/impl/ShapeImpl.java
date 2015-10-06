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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.Validator;
import org.politaktiv.map.model.Coordinate;
import org.politaktiv.map.service.persistence.CoordinateUtil;

import javax.portlet.ValidatorException;
import java.util.List;

/**
 * The extended model implementation for the Shape service. Represents a row in the &quot;politaktivmaptwo_Shape&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.model.Shape} interface.
 * </p>
 *
 * @author Paul Butenko
 */
public class ShapeImpl extends ShapeBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a shape model instance should use the {@link org.politaktiv.map.model.Shape} interface instead.
	 */

    /** The updatable by current user json property - used to detect if current user can update marker.
     * Does not stored to DB, used at JSON frontend communication. */
    @JSON
    public boolean updatableByCurrentUser;


	public ShapeImpl() {
	}

    @Override
    public boolean isUpdatableByCurrentUser() {
        return updatableByCurrentUser;
    }

    @Override
    public void setUpdatableByCurrentUser(boolean updatableByCurrentUser) {
        this.updatableByCurrentUser = updatableByCurrentUser;
    }

    @JSON
    @Override
    public List<Coordinate> getCoordinates() throws SystemException {
        return CoordinateUtil.findByShapeId(getShapeId());
    }

    @Override
    public void validate() throws ValidatorException, SystemException {

        this.validateAbstractDescription();
        this.validateTitle();
        this.validateCoordinates();

    }

    private void validateCoordinates() throws SystemException, ValidatorException {
        for (Coordinate coordinate:getCoordinates()){
            coordinate.validate();
        }

    }

    private void validateAbstractDescription() throws ValidatorException {
        if (Validator.isNotNull(getAbstractDescription()) && getAbstractDescription().length() > 1024) {
            throw new ValidatorException("Abstract description length is not valid", null);
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