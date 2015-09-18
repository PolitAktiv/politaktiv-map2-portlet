// TODO: review mje 18.09.: Pls add Apache2 License

package org.politaktiv.map.service.permission;

import org.politaktiv.map.model.Marker;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class MarkerPermission {

	public static final String ADD_MARKER_ACTION = "ADD_MARKER";
	public static final String UPDATE_ANY_MARKER_ACTION = "UPDATE_ANY_MARKER";
	public static final String UPDATE_PERSONAL_MARKER_ACTION = "UPDATE_PERSONAL_MARKER";
	
	private MarkerPermission() {
	}

	public static void checkUpdate(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey, long userId) throws PortalException {
		if (isOwner(permissionChecker, userId) && canUpdatePersonalMarkers(permissionChecker, groupId, resourceName, primKey)) {
			return;
		}

		if (!canUpdateAnyMarkers(permissionChecker, groupId, resourceName, primKey)) {
			throw new PrincipalException("User " + userId + " has no permission to make action " + UPDATE_ANY_MARKER_ACTION);
		}
	}
	
	public static void checkAdd(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) throws PortalException {
		if (!canAddMarkers(permissionChecker, groupId, resourceName, primKey)) {
			throw new PrincipalException("User " + permissionChecker.getUserId() + " has no permission to make action " + ADD_MARKER_ACTION);
		}
	}

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
	
	public static boolean canUpdatePersonalMarkers(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) {
		return contains(permissionChecker, groupId, resourceName, primKey, UPDATE_PERSONAL_MARKER_ACTION);
	}
	
	public static boolean canUpdateAnyMarkers(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) {
		return contains(permissionChecker, groupId, resourceName, primKey, UPDATE_ANY_MARKER_ACTION);
	}
	
	/**
	 * Can user update marker.
	 * User can update marker if he is owner of the marker and has permission UPDATE_PERSONAL_MARKER or has permission UPDATE_ANY_MARKER
	 *
	 * @param permissionChecker the permission checker
	 * @param marker the marker
	 * @param resourceName the resource name
	 * @param primKey the prim key
	 * @return true, if successful
	 */
	public static boolean canUpdateMarker(PermissionChecker permissionChecker, Marker marker, String resourceName, String primKey) {
		return ((isOwner(permissionChecker, marker.getUserId()) && canUpdatePersonalMarkers(permissionChecker, marker.getGroupId(), resourceName, primKey)) || 
				canUpdateAnyMarkers(permissionChecker, marker.getGroupId(), resourceName, primKey));
	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId, String resourceName,
			String primKey, String actionId) {
		return permissionChecker.hasPermission(groupId, resourceName, primKey, actionId);
	}

}