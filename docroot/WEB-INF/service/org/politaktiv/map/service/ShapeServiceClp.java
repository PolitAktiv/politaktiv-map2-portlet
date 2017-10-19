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

package org.politaktiv.map.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author Paul Butenko
 * @generated
 */
public class ShapeServiceClp implements ShapeService {
	public ShapeServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "addShape";

		_methodParameterTypes3 = new String[] {
				"java.lang.String", "java.lang.String", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.lang.String", "java.util.List"
			};

		_methodName4 = "updateShape";

		_methodParameterTypes4 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.lang.String", "java.util.List"
			};

		_methodName5 = "getAllShapes";

		_methodParameterTypes5 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName6 = "getShapesByUserId";

		_methodParameterTypes6 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String"
			};

		_methodName7 = "deleteShapeById";

		_methodParameterTypes7 = new String[] {
				"java.lang.String", "java.lang.String", "long"
			};
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public org.politaktiv.map.model.Shape addShape(java.lang.String portletId,
		java.lang.String primKey, long groupId, long companyId,
		java.lang.String title, java.lang.String abstractDescription,
		java.lang.String image, java.lang.String shapeType, long radius,
		java.lang.String shapesLayer,
		java.util.List<java.util.List<java.lang.String>> points)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] {
						ClpSerializer.translateInput(portletId),
						
					ClpSerializer.translateInput(primKey),
						
					groupId,
						
					companyId,
						
					ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(abstractDescription),
						
					ClpSerializer.translateInput(image),
						
					ClpSerializer.translateInput(shapeType),
						
					radius,
						
					ClpSerializer.translateInput(shapesLayer),
						
					ClpSerializer.translateInput(points)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof javax.portlet.ValidatorException) {
				throw (javax.portlet.ValidatorException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.politaktiv.map.model.Shape)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public org.politaktiv.map.model.Shape updateShape(
		java.lang.String portletId, java.lang.String primKey, long shapeId,
		java.lang.String title, java.lang.String abstractDescription,
		java.lang.String image, java.lang.String shapeType, long radius,
		java.lang.String shapesLayer,
		java.util.List<java.util.List<java.lang.String>> points)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			javax.portlet.ValidatorException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] {
						ClpSerializer.translateInput(portletId),
						
					ClpSerializer.translateInput(primKey),
						
					shapeId,
						
					ClpSerializer.translateInput(title),
						
					ClpSerializer.translateInput(abstractDescription),
						
					ClpSerializer.translateInput(image),
						
					ClpSerializer.translateInput(shapeType),
						
					radius,
						
					ClpSerializer.translateInput(shapesLayer),
						
					ClpSerializer.translateInput(points)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof javax.portlet.ValidatorException) {
				throw (javax.portlet.ValidatorException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.politaktiv.map.model.Shape)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Shape> getAllShapes(
		java.lang.String portletId, java.lang.String primKey,
		java.lang.String shapesLayer)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] {
						ClpSerializer.translateInput(portletId),
						
					ClpSerializer.translateInput(primKey),
						
					ClpSerializer.translateInput(shapesLayer)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<org.politaktiv.map.model.Shape>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<org.politaktiv.map.model.Shape> getShapesByUserId(
		java.lang.String portletId, java.lang.String primKey, long userId,
		java.lang.String shapesLayer)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.security.auth.PrincipalException {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(portletId),
						
					ClpSerializer.translateInput(primKey),
						
					userId,
						
					ClpSerializer.translateInput(shapesLayer)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof com.liferay.portal.security.auth.PrincipalException) {
				throw (com.liferay.portal.security.auth.PrincipalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<org.politaktiv.map.model.Shape>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void deleteShapeById(java.lang.String portletId,
		java.lang.String primKey, long shapeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableService.invokeMethod(_methodName7,
				_methodParameterTypes7,
				new Object[] {
					ClpSerializer.translateInput(portletId),
					
				ClpSerializer.translateInput(primKey),
					
				shapeId
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
}