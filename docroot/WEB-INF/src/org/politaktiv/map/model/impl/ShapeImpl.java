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

import org.jruby.ir.operands.Array;
import org.politaktiv.map.MapValidator;
import org.politaktiv.map.ShapeType;
import org.politaktiv.map.model.Coordinate;
import org.politaktiv.map.service.CoordinateLocalServiceUtil;

import javax.portlet.ValidatorException;

import java.util.ArrayList;
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
@JSON(include = true)
public class ShapeImpl extends ShapeBaseImpl {
    public static final int POINT_COORDINATE_SIZE = 1;
    public static final int RECTANGLE_COORDINATE_SIZE = 4;
    /*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a shape model instance should use the {@link org.politaktiv.map.model.Shape} interface instead.
	 */

	public ShapeImpl() {
	}

    @JSON
    @Override
    public List<Coordinate> getCoordinates() throws SystemException {
       return CoordinateLocalServiceUtil.getAllCoordinatesByShapeId(getShapeId());
/*    	List<Coordinate> list = new ArrayList<Coordinate> ();
    	Coordinate coord1 = new CoordinateImpl();
    	coord1.setLatitude("13.23");
    	coord1.setLatitude("18.4");
    	list.add(coord1);
    	
    	Coordinate coord2= new CoordinateImpl();
    	coord1.setLatitude("19.23");
    	coord1.setLatitude("11.4");
    	list.add(coord2);
    	return list;*/
    }

    @Override
    public void validate(List<List<String>> points) throws ValidatorException, SystemException {

        this.validateAbstractDescription();
        this.validateTitle();
        this.validateCoordinates(points);

    }

    private void validateCoordinates(List<List<String>> points) throws SystemException, ValidatorException {

        if (Validator.isNull(points)||points.isEmpty()){
            throw new ValidatorException("Coordinates is mandatory ",null);
        }
        for (List<String> point:points){
            if (MapValidator.isNotValidCoordinate(point)){
                throw new ValidatorException("Coordinate is not valid", null);
            }
        }

        switch (ShapeType.valueOf(getShapeType())) {
            case POINT:
                validatePoint(points);
                break;
            case CIRCLE:
                validateCircle(points);
                break;
            case RECTANGLE:
                validateRectangle(points);
                break;
        }
    }

    private void validateRectangle(List<List<String>> points) throws ValidatorException {
        if (points.size() != RECTANGLE_COORDINATE_SIZE){
            throw new ValidatorException("Rectangle must have only "+RECTANGLE_COORDINATE_SIZE+" coordinate", null);
        }

    }

    private void validatePoint(List<List<String>> points) throws ValidatorException {
        if (points.size() != POINT_COORDINATE_SIZE) {
            throw new ValidatorException("POINT must have only "+POINT_COORDINATE_SIZE+" coordinate", null);
        }
    }

    private void validateCircle(List<List<String>> points) throws ValidatorException {
        if (points.size() != POINT_COORDINATE_SIZE){
            throw new ValidatorException("CIRCLE must have only one center", null);
        }
        if (Validator.isNull(getRadius())){
            throw new ValidatorException("Radius is mandatory", null);
        }
        if (getRadius()<0){
            throw new ValidatorException("Radius cannot be negative", null);
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