package org.politaktiv.map.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * Created by viktor.syomka on 22/01/2018.
 */
public class LayerPermission {

    public static final String ADD_AND_DELETE_PERSONAL_LAYER = "ADD_AND_DELETE_PERSONAL_LAYER";

    private LayerPermission() {
    }

    public static void addAndDeletePersonalLayer(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) throws PortalException {
        if (!canAddAndDeletePersonalLayer(permissionChecker, groupId, resourceName, primKey)) {
            throw new PrincipalException("User " + permissionChecker.getUserId() + " has no permission to make action " + ADD_AND_DELETE_PERSONAL_LAYER);
        }
    }

    public static boolean canAddAndDeletePersonalLayer(PermissionChecker permissionChecker, long groupId, String resourceName, String primKey) {

        System.out.println("canAddAndDeletePersonalLayer!!!");
        System.out.println(groupId);
        System.out.println(resourceName);
        System.out.println(primKey);

        return contains(permissionChecker, groupId, resourceName, primKey, ADD_AND_DELETE_PERSONAL_LAYER);
    }

    public static boolean isAdmin(PermissionChecker permissionChecker, long groupId) {

        System.out.println("----------------isAdmin-------------------");
        System.out.println(permissionChecker.isCompanyAdmin(permissionChecker.getCompanyId()));
        System.out.println(permissionChecker.isCompanyAdmin(groupId));
        System.out.println(permissionChecker.isOmniadmin());
        System.out.println(permissionChecker.isGroupAdmin(groupId));
        System.out.println("----------------is-------------------");
        long [] roleIds = (permissionChecker.getRoleIds(permissionChecker.getUserId(), groupId));
        for (long id: roleIds) {
            System.out.println(id);
        }

        return (permissionChecker.isCompanyAdmin(permissionChecker.getCompanyId()) ||
                permissionChecker.isCompanyAdmin(groupId) || permissionChecker.isOmniadmin() || permissionChecker.isGroupAdmin(groupId));
    }

    public static boolean isSignedInUser(PermissionChecker permissionChecker) {

        System.out.println("isSignedInUser");
        System.out.println(permissionChecker.isSignedIn());
        return (permissionChecker.isSignedIn());
    }

    public static boolean contains(PermissionChecker permissionChecker, long groupId, String resourceName,
                                   String primKey, String actionId) {
        return permissionChecker.hasPermission(groupId, resourceName, primKey, actionId);
    }

//    public static List<Layer> getLayers() throws SystemException, ValidatorException, PortalException {
//
//        System.out.println("!!!!!!!!!!!!!getLayers!!!!!!!!!!!!!!");
//        long userId=10201;
//        List<Layer> layers = LayerUtil.findByUserId(userId);
//        return layers;
//    }
}