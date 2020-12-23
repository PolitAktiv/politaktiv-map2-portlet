// TODO: review mje 18.09.: Pls add Apache2 License

package org.politaktiv.map.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import org.politaktiv.map.model.Shape;

/**
 * @author aleksandar
 *
 */
public class ShapePermission {

    /**
     * to Add or update Shape you need to have ADD_AND_UPDATE_PERSONAL_SHAPE privilegy
     */
    public static final String ADD_AND_UPDATE_PERSONAL_SHAPE = "ADD_AND_UPDATE_PERSONAL_SHAPE";
    public static final String UPDATE_ANY_SHAPE_ACTION = "UPDATE_ANY_SHAPE";


    private ShapePermission() {
	}

	/**
	 * @param permissionChecker
	 * @param groupId
	 * @param resourceName
	 * @param primKey
	 * @param userId
	 * @throws PortalException
	 */
	public static void checkUpdate(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey, long userId) throws PortalException {
	/*	 User user = permissionChecker.getUser();
	     long currentUserId = user.getUserId();*/
	     
	   
	     
		if (canAddAndUpdatePersonalShape(permissionChecker, groupId, resourceName, primKey)) {
				return;
		}

		if (!canUpdateAnyShapes(permissionChecker, groupId, resourceName, primKey)) {
			throw new PrincipalException("User " + userId + " has no permission to make action " + UPDATE_ANY_SHAPE_ACTION);
		}
	}

	
	
	
	/**
	 * When Add shape this method should be invoked. 
	 * 
	 * @param permissionChecker
	 * @param groupId
	 * @param resourceName
	 * @param primKey
	 * @throws PortalException
	 * 
	 * @see ShapeServiceImpl.addShape
	 */
	public static void checkAddAndUpdatePersonalShape(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) throws PortalException {
		if (!canAddAndUpdatePersonalShape(permissionChecker, groupId, resourceName, primKey)) {
			throw new PrincipalException("User " + permissionChecker.getUserId() + " has no permission to make action " + ADD_AND_UPDATE_PERSONAL_SHAPE);
		}
	}


	/**
	 * @param permissionChecker
	 * @param groupId
	 * @param resourceName
	 * @param primKey
	 * @return
	 */
	public static boolean canAddAndUpdatePersonalShape(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) {
		return contains(permissionChecker, groupId, resourceName, primKey, ADD_AND_UPDATE_PERSONAL_SHAPE);
	}
	
	/**
	 * @param permissionChecker
	 * @param groupId
	 * @param resourceName
	 * @param primKey
	 * @return
	 */
	public static boolean canUpdateAnyShapes(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) {
		return contains(permissionChecker, groupId, resourceName, primKey, UPDATE_ANY_SHAPE_ACTION);
	}
	
    /**
     * @param permissionChecker
     * @param shape
     * @param resourceName
     * @param primKey
     * @return
     */
    public static boolean canUpdateShape(PermissionChecker permissionChecker, Shape shape, String resourceName, String primKey) {

       return (((permissionChecker.getUserId()==shape.getUserId())&&canAddAndUpdatePersonalShape(permissionChecker,shape.getGroupId(),resourceName,primKey))||
               canUpdateAnyShapes(permissionChecker,shape.getGroupId(),resourceName,primKey));

    }

	/**
	 * @param permissionChecker
	 * @param groupId
	 * @param resourceName
	 * @param primKey
	 * @param actionId
	 * @return
	 */
	public static boolean contains(PermissionChecker permissionChecker, long groupId, String resourceName,
			String primKey, String actionId) {
		return permissionChecker.hasPermission(groupId, resourceName, primKey, actionId);
	}

}
