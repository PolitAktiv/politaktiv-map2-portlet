/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package org.politaktiv.map.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import org.politaktiv.map.model.Shape;

import java.util.List;

import javax.portlet.ValidatorException;

/**
 * Provides the remote service interface for Shape. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Aleksandar Lukic
 * @see ShapeServiceUtil
 * @see org.politaktiv.map.service.base.ShapeServiceBaseImpl
 * @see org.politaktiv.map.service.impl.ShapeServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ShapeService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShapeServiceUtil} to access the shape remote service. Add custom service methods to {@link org.politaktiv.map.service.impl.ShapeServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Shape addShape(String portletId, String primKey, long groupId,
		long companyId, String title, String abstractDescription, String url,
		String shapeType, long radius, String shapesLayer,
		List<List<String>> points)
		throws SystemException, ValidatorException, PortalException;

	public void deleteShapeById(String portletId, String primKey, long shapeId)
		throws SystemException, PortalException;

	@AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Shape> getAllShapes(String portletId, String primKey,
		String shapesLayer) throws SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Shape> getShapesByUserId(String portletId, String primKey,
		long userId, String shapesLayer)
		throws SystemException, PrincipalException;

	public Shape updateShape(String portletId, String primKey, long shapeId,
		String title, String abstractDescription, String url, String shapeType,
		long radius, String shapesLayer, List<List<String>> points)
		throws SystemException, ValidatorException, PortalException;
}