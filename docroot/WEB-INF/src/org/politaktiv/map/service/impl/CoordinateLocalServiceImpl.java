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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import org.apache.log4j.Logger;
import org.politaktiv.map.model.Coordinate;
import org.politaktiv.map.service.base.CoordinateLocalServiceBaseImpl;

import javax.portlet.ValidatorException;
import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the coordinate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.service.CoordinateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Paul Butenko
 * @see org.politaktiv.map.service.base.CoordinateLocalServiceBaseImpl
 * @see org.politaktiv.map.service.CoordinateLocalServiceUtil
 */
public class CoordinateLocalServiceImpl extends CoordinateLocalServiceBaseImpl {


	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.politaktiv.map.service.CoordinateLocalServiceUtil} to access the coordinate local service.
	 */

    private static final Logger LOGGER = Logger.getLogger(CoordinateLocalServiceImpl.class);
    public static final int POINT_SIZE = 2;
    public static final int COORDINATE_LONGITUDE = 0;
    public static final int COORDINATE_LATITUDE = 1;

    public Coordinate addCoordinate(long shapeId, String longitude, String latitude) throws SystemException, ValidatorException {

        long coordinateId = CounterLocalServiceUtil.increment(Coordinate.class.getName());
        Coordinate coordinate = coordinatePersistence.create(coordinateId);

        coordinate.setShapeId(shapeId);
        coordinate.setLongitude(longitude);
        coordinate.setLatitude(latitude);

        coordinate.validate();

        coordinatePersistence.update(coordinate);

        return coordinate;
    }

    public List<Coordinate> addCoordinates(long shapeId, List<List<String>> coordinatesList) throws ValidatorException, SystemException {

        List<Coordinate> coordinates = new ArrayList<Coordinate>();

        for (List<String> points:coordinatesList){
            if (points.size() < POINT_SIZE){
                throw new ValidatorException("Coordinate must have longitude and latitude", null);
            }
            Coordinate coordinate = addCoordinate(shapeId, points.get(COORDINATE_LONGITUDE), points.get(COORDINATE_LATITUDE));
            coordinates.add(coordinate);
        }

        return coordinates;
    }

    public List<Coordinate> getAllCoordinatesByShapeId(long shapeId) throws SystemException {
        return coordinatePersistence.findByShapeId(shapeId);
    }


    public void removeCoordinatesByShapeId(long shapeId) throws SystemException {

        coordinatePersistence.removeByShapeId(shapeId);
    }

}