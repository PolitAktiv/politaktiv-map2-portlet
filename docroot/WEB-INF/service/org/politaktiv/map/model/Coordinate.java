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

package org.politaktiv.map.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Coordinate service. Represents a row in the &quot;politaktivmaptwo_Coordinate&quot; database table, with each column mapped to a property of this class.
 *
 * @author Aleksandar Lukic
 * @see CoordinateModel
 * @see org.politaktiv.map.model.impl.CoordinateImpl
 * @see org.politaktiv.map.model.impl.CoordinateModelImpl
 * @generated
 */
@ImplementationClassName("org.politaktiv.map.model.impl.CoordinateImpl")
@ProviderType
public interface Coordinate extends CoordinateModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.politaktiv.map.model.impl.CoordinateImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Coordinate, Long> COORDINATE_ID_ACCESSOR = new Accessor<Coordinate, Long>() {
			@Override
			public Long get(Coordinate coordinate) {
				return coordinate.getCoordinateId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Coordinate> getTypeClass() {
				return Coordinate.class;
			}
		};

	public void validate() throws javax.portlet.ValidatorException;
}