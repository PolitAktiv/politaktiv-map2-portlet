// TODO: review mje 18.09.: Pls add Apache2 License

package org.politaktiv.map.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import org.politaktiv.map.model.Shape;

public class ShapePermission {

    public static final String ADD_AND_UPDATE_PERSONAL_SHAPE = "ADD_AND_UPDATE_PERSONAL_SHAPE";
    public static final String UPDATE_ANY_SHAPE_ACTION = "UPDATE_ANY_SHAPE";


    private ShapePermission() {
	}

	public static void checkUpdate(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey, long userId) throws PortalException {
		if (canAddAndUpdatePersonalShape(permissionChecker, groupId, resourceName, primKey)) {
			return;
		}

		if (!canUpdateAnyShapes(permissionChecker, groupId, resourceName, primKey)) {
			throw new PrincipalException("User " + userId + " has no permission to make action " + UPDATE_ANY_SHAPE_ACTION);
		}
	}
	
	public static void checkAddAndUpdatePersonalShape(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) throws PortalException {
		if (!canAddAndUpdatePersonalShape(permissionChecker, groupId, resourceName, primKey)) {
			throw new PrincipalException("User " + permissionChecker.getUserId() + " has no permission to make action " + ADD_AND_UPDATE_PERSONAL_SHAPE);
		}
	}


	public static boolean canAddAndUpdatePersonalShape(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) {
		return contains(permissionChecker, groupId, resourceName, primKey, ADD_AND_UPDATE_PERSONAL_SHAPE);
	}
	
	public static boolean canUpdateAnyShapes(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) {
		return contains(permissionChecker, groupId, resourceName, primKey, UPDATE_ANY_SHAPE_ACTION);
	}
	
	public static boolean canUpdateShape(PermissionChecker permissionChecker, Shape shape, String resourceName, String primKey) {
		return ((canAddAndUpdatePersonalShape(permissionChecker, shape.getGroupId(), resourceName, primKey)) ||
				canUpdateAnyShapes(permissionChecker, shape.getGroupId(), resourceName, primKey));
	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId, String resourceName,
			String primKey, String actionId) {
		return permissionChecker.hasPermission(groupId, resourceName, primKey, actionId);
	}

}
