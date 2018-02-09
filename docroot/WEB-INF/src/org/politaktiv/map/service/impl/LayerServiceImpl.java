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
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import org.apache.log4j.Logger;
import org.politaktiv.map.model.Layer;
import org.politaktiv.map.service.LayerLocalServiceUtil;
import org.politaktiv.map.service.base.LayerServiceBaseImpl;
import org.politaktiv.map.service.permission.LayerPermission;
import org.politaktiv.map.service.persistence.LayerUtil;

import javax.portlet.ValidatorException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * The implementation of the layer remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.politaktiv.map.service.LayerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Viktor Somka
 * @see org.politaktiv.map.service.base.LayerServiceBaseImpl
 * @see org.politaktiv.map.service.LayerServiceUtil
 */
public class LayerServiceImpl extends LayerServiceBaseImpl {

    public static final String DEFAULT_LAYER = "Default layer";
    public static final int USER_ROLE = 10168;
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.politaktiv.map.service.LayerServiceUtil} to access the layer remote service.
	 */

    private static final Logger LOGGER = Logger.getLogger(ShapeServiceImpl.class);

    public boolean addLayer(long userId, String shapesLayer, String portletInstance, String portletId, String primKey, long groupId)
            throws SystemException, ValidatorException, PortalException {

        long layerId = CounterLocalServiceUtil.increment(Layer.class.getName());
        Date currentDate = new Date();
        Layer layer = layerPersistence.create(layerId);
        layer.setCreateDate(currentDate);
        layer.setLabel(shapesLayer);
        layer.setUserId(userId);
        layer.setPortletInstance(portletInstance);

        LayerPermission.addAndDeletePersonalLayer(getPermissionChecker(), groupId, portletId, primKey);

        int count = layerPersistence.countByUserIdAndLabelAndPortletInstance(userId, shapesLayer, portletInstance);

        if (count < 1){
            LayerLocalServiceUtil.updateLayer(layer);
            LOGGER.info("Layer: " + layer.getLayerId() + " for user: " + getPermissionChecker().getUserId()
                    + " for portlet instance: " + portletInstance + " has been created.");
            return true;
        }

        System.out.println("There are already layer with such label");
        return false;
    }

    public boolean deleteLayer(long userId, String shapesLayer, String portletInstance, String portletId, String primKey, long groupId) throws SystemException, ValidatorException, PortalException {

        LayerPermission.addAndDeletePersonalLayer(getPermissionChecker(), groupId, portletId, primKey);

        int count = layerPersistence.countByUserIdAndLabelAndPortletInstance(userId, shapesLayer, portletInstance);

        if (count > 0){
            layerPersistence.removeByUserIdAndLabelAndPortletInstance(userId, shapesLayer, portletInstance);
            shapePersistence.removeByUserIdAndLayerAndPortletInstance(userId, shapesLayer, portletInstance);
            LOGGER.info("Layer with label: " + shapesLayer + " for user: " + getPermissionChecker().getUserId()
                    + " for portlet instance: " + portletInstance + " has been deleted.");
            return true;
        }

        return false;
    }

    public List<Layer> getLayers(long userId, String portletInstance, String portletId, String primKey, long groupId) throws SystemException, ValidatorException, PortalException {

//        LayerPermission.getPersonalLayers(getPermissionChecker(), groupId, portletId, primKey);

        LayerPermission.isAdmin(getPermissionChecker(), groupId);
        List<Layer> layers = LayerUtil.findByUserIdAndPortletInstance(userId, portletInstance);

        if (layers.size() == 0) {
            addLayer(userId, DEFAULT_LAYER, portletInstance, portletId, primKey, groupId);
            layers = LayerUtil.findByUserIdAndPortletInstance(userId, portletInstance);
        }

        return layers;
    }

    public List<String> getInstances(long userId) throws SystemException, ValidatorException, PortalException {

        List<Layer> layers = LayerUtil.findByUserId(userId);

        LinkedHashSet<String> set = new LinkedHashSet<String>();

        for (Layer layer: layers) {
            set.add(layer.getPortletInstance());
        }

        List<String> list = new ArrayList<String>(set);

        for (String str: list) {
            System.out.println(str);
        }

        return list;
    }

    public List<User> getUsers(long userId) throws SystemException, ValidatorException, PortalException {

        List<User> users = UserLocalServiceUtil.getRoleUsers(USER_ROLE);
        System.out.println("Total users: " + users.size());

        for (User user: users) {
            user.setScreenName(user.getEmailAddress());
        }

        return users;
    }
}