<%@ page import="org.politaktiv.map.service.permission.ShapePermission" %>
<%
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
%>

<%@ include file="/init.jsp" %>


<%
String portletId = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();

boolean canAddMarkers = ShapePermission.canAddMarkers(permissionChecker, portletGroupId, portletId, primKey);
boolean canUpdateMarkers = ShapePermission.canUpdatePersonalMarkers(permissionChecker, portletGroupId, portletId, primKey) ||
						   ShapePermission.canUpdateAnyMarkers(permissionChecker, portletGroupId, portletId, primKey);
%>

<% // div contains map %>
<div id="<portlet:namespace />map" class="map"></div>


<br/>

<aui:script use="aui-base">
L.drawLocal.draw.toolbar.actions.title = '<liferay-ui:message key="drawLocal.draw.toolbar.actions.title" />';
L.drawLocal.draw.toolbar.actions.text = '<liferay-ui:message key="drawLocal.draw.toolbar.actions.text" />';
L.drawLocal.draw.toolbar.buttons.marker = '<liferay-ui:message key="drawLocal.draw.toolbar.buttons.marker" />';
L.drawLocal.draw.handlers.marker.tooltip.start = '<liferay-ui:message key="drawLocal.draw.handlers.marker.tooltip.start" />';
L.drawLocal.edit.toolbar.actions.save.title = '<liferay-ui:message key="drawLocal.edit.toolbar.actions.save.title" />';
L.drawLocal.edit.toolbar.actions.save.text = '<liferay-ui:message key="drawLocal.edit.toolbar.actions.save.text" />';
L.drawLocal.edit.toolbar.actions.cancel.title = '<liferay-ui:message key="drawLocal.edit.toolbar.actions.cancel.title" />';
L.drawLocal.edit.toolbar.actions.cancel.text = '<liferay-ui:message key="drawLocal.edit.toolbar.actions.cancel.text" />';
L.drawLocal.edit.toolbar.buttons.edit = '<liferay-ui:message key="drawLocal.edit.toolbar.buttons.edit" />';
L.drawLocal.edit.handlers.edit.tooltip.text = '<liferay-ui:message key="drawLocal.edit.handlers.edit.tooltip.text" />';
L.drawLocal.edit.handlers.edit.tooltip.subtext = '<liferay-ui:message key="drawLocal.edit.handlers.edit.tooltip.subtext" />';

<%-- ajax calls details: /api/jsonws?contextPath=/politaktiv-map2-portlet --%>
    var map2 = createMap2({
        wrapperId: '<portlet:namespace />map',
        groupId: <%= portletGroupId %>,
        companyId: <%= company.getCompanyId() %>,
        portletId: '<%= portletId %>',
        primKey: '<%= primKey %>',
        userId: <%= themeDisplay.getUserId() %>,
        canAddMarkers: <%= canAddMarkers %>,
        canUpdateMarkers: <%= canUpdateMarkers %>,
        center: { lat:<%= centerLatitude %>, lng:<%= centerLongtitude %> },
        zoomLevel: <%= zoomLevel %>,
        translations: {
            resetZoom: '<liferay-ui:message key="map2.reset-zoom" />',
            yourMarkers: '<liferay-ui:message key="map2.your-markers" />',
            allMarkers: '<liferay-ui:message key="map2.all-markers" />',
            addedBy: '<liferay-ui:message key="map2.added-by" />',
            addTitleMessage: '<liferay-ui:message key="map2.add-title-message" />',
            editTitleMessage: '<liferay-ui:message key="map2.edit-title-message" />'
        }
    });
</aui:script>
