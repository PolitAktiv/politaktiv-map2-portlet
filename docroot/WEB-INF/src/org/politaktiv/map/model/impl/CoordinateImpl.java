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


import com.liferay.portal.kernel.util.Validator;
import org.politaktiv.map.MapValidator;

import javax.portlet.ValidatorException;
/**
 * The extended model implementation for the Coordinate service. Represents a row in the &quot;politaktivmaptwo_Coordinate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.model.Coordinate} interface.
 * </p>
 *
 * @author Paul Butenko
 */
public class CoordinateImpl extends CoordinateBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a coordinate model instance should use the {@link org.politaktiv.map.model.Coordinate} interface instead.
	 */
	public CoordinateImpl() {
	}


    public void validate() throws ValidatorException {
        this.validateShapeId();
        this.validateLatitude();
        this.validateLongtitude();
    }

    private void validateShapeId() throws ValidatorException {
        if (Validator.isNull(getShapeId())) {
            throw new ValidatorException("ShapeId is not valid", null);
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

}