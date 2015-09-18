// TODO: review mje 18.09.: Pls add Apache2 License

package org.politaktiv.map.service.permission;

import org.politaktiv.map.model.Marker;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class MarkerPermission {

	public static final String ADD_MARKER_ACTION = "ADD_MARKER";
	public static final String UPDATE_MARKER_ACTION = "UPDATE_MARKER";
	
	private MarkerPermission() {
	}

	public static void checkUpdate(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey, long userId) throws PortalException {
		if (isOwner(permissionChecker, userId)) {
			return;
		}

		if (!canUpdateMarkers(permissionChecker, groupId, resourceName, primKey)) {
			throw new PrincipalException("User " + userId + " has no permission to make action " + UPDATE_MARKER_ACTION);
		}
	}
	
	public static void checkAdd(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) throws PortalException {
		if (!canAddMarkers(permissionChecker, groupId, resourceName, primKey)) {
			throw new PrincipalException("User " + permissionChecker.getUserId() + " has no permission to make action " + ADD_MARKER_ACTION);
		}
	}

	// TODO: review mje 18.09.: If we've ambivalent semantics of owner, so let's give them differrent names.
	// [Portlet-/Page-]Owner (if feasible in Liferay) and ResourceOwner (I think that's in our hand).
	public static void checkOwner(PermissionChecker permissionChecker, long userId) throws PrincipalException {
		if (!isOwner(permissionChecker, userId)) {
			throw new PrincipalException("User " + userId + " can't make action for another user", null);
		}
	}
	
	public static boolean isOwner(PermissionChecker permissionChecker, long userId) {
		long currentUserId = permissionChecker.getUserId();

		return (userId == currentUserId);
	}
	
	public static boolean canAddMarkers(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) {
		return contains(permissionChecker, groupId, resourceName, primKey, ADD_MARKER_ACTION);
	}
	
	public static boolean canUpdateMarkers(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) {
		return contains(permissionChecker, groupId, resourceName, primKey, UPDATE_MARKER_ACTION);
	}
	
	public static boolean canUpdateMarker(PermissionChecker permissionChecker, Marker marker, String resourceName, String primKey) {
		return (isOwner(permissionChecker, marker.getUserId()) || canUpdateMarkers(permissionChecker, marker.getGroupId(), resourceName, primKey));
	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId, String resourceName,
			String primKey, String actionId) {
		return permissionChecker.hasPermission(groupId, resourceName, primKey, actionId);
	}

}