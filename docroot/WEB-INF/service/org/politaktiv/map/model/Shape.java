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

package org.politaktiv.map.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Shape service. Represents a row in the &quot;politaktivmaptwo_Shape&quot; database table, with each column mapped to a property of this class.
 *
 * @author Paul Butenko
 * @see ShapeModel
 * @see org.politaktiv.map.model.impl.ShapeImpl
 * @see org.politaktiv.map.model.impl.ShapeModelImpl
 * @generated
 */
public interface Shape extends ShapeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.politaktiv.map.model.impl.ShapeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@com.liferay.portal.kernel.json.JSON()
	public java.util.List<org.politaktiv.map.model.Coordinate> getCoordinates()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void validate(
		java.util.List<java.util.List<java.lang.String>> points)
		throws com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException;
}