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
import org.apache.log4j.Logger;
import org.politaktiv.map.model.Layer;
import org.politaktiv.map.service.LayerLocalServiceUtil;
import org.politaktiv.map.service.base.LayerServiceBaseImpl;
import org.politaktiv.map.service.persistence.LayerUtil;

import javax.portlet.ValidatorException;
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
 * @author Paul Butenko
 * @see org.politaktiv.map.service.base.LayerServiceBaseImpl
 * @see org.politaktiv.map.service.LayerServiceUtil
 */
public class LayerServiceImpl extends LayerServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.politaktiv.map.service.LayerServiceUtil} to access the layer remote service.
	 */

    private static final Logger LOGGER = Logger.getLogger(ShapeServiceImpl.class);

    public boolean addLayer(long userId, String shapesLayer) throws SystemException, ValidatorException, PortalException {

        System.out.println("YES!!!!!");
        System.out.println("userId: " + userId);
        System.out.println(shapesLayer);

//        User user = getPermissionChecker().getUser();
//        long currentUserId = user.getUserId();
//        System.out.println("currentUserId: " + userId);

        long layerId = CounterLocalServiceUtil.increment(Layer.class.getName());
        Layer layer = layerPersistence.create(layerId);
        layer.setLabel(shapesLayer);
        layer.setUserId(userId);

        int count = layerPersistence.countByUserIdAndLabel(userId, shapesLayer);
        System.out.println("count is: " + count);

        if (count < 1){
            LayerLocalServiceUtil.updateLayer(layer);
            LOGGER.info("Layer: " + layer.getLayerId() + " for user: " + getPermissionChecker().getUserId() + " has been created.");
            return true;
        }

        System.out.println("There are already layer with such label");
        return false;
    }

    public boolean deleteLayer(long userId, String shapesLayer) throws SystemException, ValidatorException, PortalException {

        System.out.println("deleteLayer!!!!!");
        System.out.println("userId: " + userId);
        System.out.println(shapesLayer);

        int count = layerPersistence.countByUserIdAndLabel(userId, shapesLayer);
        System.out.println("count is: " + count);

        if (count > 0){
            layerPersistence.removeByUserIdAndLabel(userId, shapesLayer);
            LOGGER.info("Layer with label: " + shapesLayer + " for user: " + getPermissionChecker().getUserId() + " has been deleted.");
            return true;
        }

        return false;
    }

    public List<Layer> findAllLayers(long userId) throws SystemException, ValidatorException, PortalException {

        System.out.println("FindAllLayers!!!!!");
        System.out.println("userId: " + userId);

        List<Layer> layers = LayerUtil.findByUserId(userId);

        for (Layer layer : layers) {
            System.out.println("layer label: " + layer.getLabel());
        }
        return layers;
    }
}