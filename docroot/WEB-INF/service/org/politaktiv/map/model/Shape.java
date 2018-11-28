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
 * The extended model interface for the Shape service. Represents a row in the &quot;politaktivmaptwo_Shape&quot; database table, with each column mapped to a property of this class.
 *
 * @author Aleksandar Lukic
 * @see ShapeModel
 * @see org.politaktiv.map.model.impl.ShapeImpl
 * @see org.politaktiv.map.model.impl.ShapeModelImpl
 * @generated
 */
@ImplementationClassName("org.politaktiv.map.model.impl.ShapeImpl")
@ProviderType
public interface Shape extends ShapeModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.politaktiv.map.model.impl.ShapeImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Shape, Long> SHAPE_ID_ACCESSOR = new Accessor<Shape, Long>() {
			@Override
			public Long get(Shape shape) {
				return shape.getShapeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Shape> getTypeClass() {
				return Shape.class;
			}
		};

	@com.liferay.portal.kernel.json.JSON()
	public java.util.List<Coordinate> getCoordinates()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void validate(java.util.List<java.util.List<String>> points)
		throws javax.portlet.ValidatorException,
			com.liferay.portal.kernel.exception.SystemException;
}