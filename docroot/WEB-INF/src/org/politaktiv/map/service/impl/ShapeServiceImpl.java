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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.auth.PrincipalException;
import org.apache.log4j.Logger;
import org.politaktiv.map.model.Shape;
import org.politaktiv.map.service.CoordinateLocalServiceUtil;
import org.politaktiv.map.service.ShapeLocalServiceUtil;
import org.politaktiv.map.service.base.ShapeServiceBaseImpl;
import org.politaktiv.map.service.permission.ShapePermission;
import org.politaktiv.map.service.persistence.ShapeUtil;

import javax.portlet.ValidatorException;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the shape remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.service.ShapeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Paul Butenko
 * @see org.politaktiv.map.service.base.ShapeServiceBaseImpl
 * @see org.politaktiv.map.service.ShapeServiceUtil
 */
public class ShapeServiceImpl extends ShapeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.politaktiv.map.service.ShapeServiceUtil} to access the shape remote service.
	 */


    private static final Logger LOGGER = Logger.getLogger(ShapeServiceImpl.class);


    public Shape addShape(String portletId, String primKey, long groupId, long companyId, String title, String abstractDescription, String image, String shapeType, long radius, String shapesLayer, List<List<String>> points)
            throws SystemException, ValidatorException, PortalException {

        User user = getPermissionChecker().getUser();
        long currentUserId = user.getUserId();

        ShapePermission.checkAddAndUpdatePersonalShape(getPermissionChecker(), groupId, portletId, primKey);

        Date currentDate = new Date();

        long shapeId = CounterLocalServiceUtil.increment(Shape.class.getName());
        Shape shape = shapePersistence.create(shapeId);

        shape.setGroupId(groupId);
        shape.setCompanyId(companyId);

        shape.setUserId(currentUserId);
        shape.setUserName(user.getFullName());
        shape.setCreateDate(currentDate);
        shape.setModifiedDate(currentDate);

        shape.setTitle(title);
        shape.setAbstractDescription(abstractDescription);
        shape.setImage(image);
        shape.setShapeType(shapeType);
        shape.setRadius(radius);
        shape.setLayer(shapesLayer);

        CoordinateLocalServiceUtil.addCoordinates(shapeId, points);

        shape.validate(points);

        ShapeLocalServiceUtil.updateShape(shape);

        LOGGER.info("Shape: " + shape.getShapeId() + " for user: " + getPermissionChecker().getUserId() + " has been created.");
        return shape;
    }

    public Shape updateShape(String portletId, String primKey, long shapeId, String title, String abstractDescription, String image, String shapeType, long radius, String shapesLayer, List<List<String>> points)
            throws SystemException, ValidatorException, PortalException {

        Shape shape = ShapeLocalServiceUtil.getShape(shapeId);

        ShapePermission.checkUpdate(getPermissionChecker(), shape.getGroupId(), portletId, primKey, shape.getUserId());

        Date currentDate = new Date();

        shape.setModifiedDate(currentDate);

        shape.setTitle(title);
        shape.setAbstractDescription(abstractDescription);
        shape.setImage(image);
        shape.setRadius(radius);
        shape.setLayer(shapesLayer);

        CoordinateLocalServiceUtil.removeCoordinatesByShapeId(shapeId);
        CoordinateLocalServiceUtil.addCoordinates(shapeId, points);

        shape.validate(points);

        ShapeLocalServiceUtil.updateShape(shape);

        LOGGER.info("Shape: " + shape.getShapeId() + " for user: " + getPermissionChecker().getUserId() + " has been updated.");

        return shape;
    }


    @AccessControlled(guestAccessEnabled = true)
    public List<Shape> getAllShapes(String portletId, String primKey, String shapesLayer) throws SystemException {

        List<Shape> shapes = ShapeUtil.findByLayer(shapesLayer);

        for (Shape shape : shapes) {

            shape.setAbstractDescription(HtmlUtil.escape(shape.getAbstractDescription()));
            shape.setTitle(HtmlUtil.escape(shape.getTitle()));
        }

        return shapes;
    }

    public List<Shape> getShapesByUserId(String portletId, String primKey, long userId, String shapesLayer) throws SystemException, PrincipalException {

        List<Shape> shapes = ShapeUtil.findByUserIdAndLayer(userId, shapesLayer);

        for (Shape shape : shapes) {
            shape.setAbstractDescription(HtmlUtil.escape(shape.getAbstractDescription()));
            shape.setTitle(HtmlUtil.escape(shape.getTitle()));
        }

        return shapes;
    }

    public void deleteShapeById(String portletId, String primKey, long shapeId) throws SystemException, PortalException {

        Shape shape = ShapeLocalServiceUtil.getShape(shapeId);

        if(ShapePermission.canUpdateShape(getPermissionChecker(), shape, portletId, primKey)){

            ShapeUtil.remove(shapeId);
            CoordinateLocalServiceUtil.removeCoordinatesByShapeId(shapeId);

            LOGGER.info("Shape: " + shape.getShapeId() + " for user: " + getPermissionChecker().getUserId() + " has been deleted.");
        }
    }
}