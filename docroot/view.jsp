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

boolean canAddAndUpdatePersonalShape = ShapePermission.canAddAndUpdatePersonalShape(permissionChecker, portletGroupId, portletId, primKey);
boolean canUpdateAnyShapes = ShapePermission.canUpdateAnyShapes(permissionChecker, portletGroupId, portletId, primKey);
%>
<%-- div contains map --%>
<div id="<portlet:namespace />map" class="map"></div>

<div id="<portlet:namespace />PopupTemplate" class="hide">
	<div class="leaflet-custom-popup-content">
		<div class="leaflet-shape-title-wrap">
			<span class="leaflet-shape-title hide"></span>
			<a class="leaflet-shape-title hide" target="_blank" href=""></a>
			<input class="leaflet-shape-title hide" placeholder="<liferay-ui:message key="map2.shape-title-placeholder" />" />
		</div>
		<div class="leaflet-shape-url-wrap">
			<input class="leaflet-shape-url hide" placeholder="<liferay-ui:message key="map2.shape-url-placeholder" />" />
		</div>
		<div class="leaflet-shape-text-wrap">
			<span class="leaflet-shape-text"></span>
			<input class="leaflet-shape-text hide" placeholder="<liferay-ui:message key="map2.shape-text-placeholder" />" />
		</div>
		<div class="leaflet-shape-buttons">
			<span class="leaflet-shape-edit hide"><liferay-ui:message key="map2.edit-button" /></span>
			<span class="leaflet-shape-save hide"><liferay-ui:message key="map2.save-button" /></span>
			<span class="leaflet-shape-cancel hide"><liferay-ui:message key="map2.cancel-button" /></span>
		</div>
		<div class="leaflet-shape-author-wrap">
			<liferay-ui:message key="map2.added-by" />
			<span class="leaflet-shape-author"></span>
		</div>
	</div>
</div>


<br/>

<aui:script use="aui-base">
L.drawLocal.draw.toolbar.actions.title = '<liferay-ui:message key="drawLocal.draw.toolbar.actions.title" />';
L.drawLocal.draw.toolbar.actions.text = '<liferay-ui:message key="drawLocal.draw.toolbar.actions.text" />';
L.drawLocal.draw.toolbar.buttons.polyline = '<liferay-ui:message key="drawLocal.draw.toolbar.buttons.polyline" />';
L.drawLocal.draw.toolbar.buttons.polygon = '<liferay-ui:message key="drawLocal.draw.toolbar.buttons.polygon" />';
L.drawLocal.draw.toolbar.buttons.rectangle = '<liferay-ui:message key="drawLocal.draw.toolbar.buttons.rectangle" />';
L.drawLocal.draw.toolbar.buttons.circle = '<liferay-ui:message key="drawLocal.draw.toolbar.buttons.circle" />';
L.drawLocal.draw.toolbar.buttons.marker = '<liferay-ui:message key="drawLocal.draw.toolbar.buttons.marker" />';
L.drawLocal.draw.handlers.circle.tooltip.start = '<liferay-ui:message key="drawLocal.draw.handlers.circle.tooltip.start" />';
L.drawLocal.draw.handlers.circle.radius = '<liferay-ui:message key="drawLocal.draw.handlers.circle.radius" />';
L.drawLocal.draw.handlers.marker.tooltip.start = '<liferay-ui:message key="drawLocal.draw.handlers.marker.tooltip.start" />';
L.drawLocal.draw.handlers.polygon.tooltip.start = '<liferay-ui:message key="drawLocal.draw.handlers.polygon.tooltip.start" />';
L.drawLocal.draw.handlers.polygon.tooltip.cont = '<liferay-ui:message key="drawLocal.draw.handlers.polygon.tooltip.cont" />';
L.drawLocal.draw.handlers.polygon.tooltip.end = '<liferay-ui:message key="drawLocal.draw.handlers.polygon.tooltip.end" />';
L.drawLocal.draw.handlers.polyline.error = '<liferay-ui:message key="drawLocal.draw.handlers.polyline.error" />';
L.drawLocal.draw.handlers.polyline.tooltip.start = '<liferay-ui:message key="drawLocal.draw.handlers.polyline.tooltip.start" />';
L.drawLocal.draw.handlers.polyline.tooltip.cont = '<liferay-ui:message key="drawLocal.draw.handlers.polyline.tooltip.cont" />';
L.drawLocal.draw.handlers.polyline.tooltip.end = '<liferay-ui:message key="drawLocal.draw.handlers.polyline.tooltip.end" />';
L.drawLocal.draw.handlers.rectangle.tooltip.start = '<liferay-ui:message key="drawLocal.draw.handlers.rectangle.tooltip.start" />';
L.drawLocal.draw.handlers.simpleshape.tooltip.end = '<liferay-ui:message key="drawLocal.draw.handlers.simpleshape.tooltip.end" />';
L.drawLocal.edit.toolbar.actions.save.title = '<liferay-ui:message key="drawLocal.edit.toolbar.actions.save.title" />';
L.drawLocal.edit.toolbar.actions.save.text = '<liferay-ui:message key="drawLocal.edit.toolbar.actions.save.text" />';
L.drawLocal.edit.toolbar.actions.cancel.title = '<liferay-ui:message key="drawLocal.edit.toolbar.actions.cancel.title" />';
L.drawLocal.edit.toolbar.actions.cancel.text = '<liferay-ui:message key="drawLocal.edit.toolbar.actions.cancel.text" />';
L.drawLocal.edit.toolbar.buttons.edit = '<liferay-ui:message key="drawLocal.edit.toolbar.buttons.edit" />';
L.drawLocal.edit.handlers.edit.tooltip.text = '<liferay-ui:message key="drawLocal.edit.handlers.edit.tooltip.text" />';
L.drawLocal.edit.handlers.edit.tooltip.subtext = '<liferay-ui:message key="drawLocal.edit.handlers.edit.tooltip.subtext" />';
L.drawLocal.edit.handlers.remove.tooltip.text = '<liferay-ui:message key="drawLocal.edit.handlers.remove.tooltip.text" />';

<%-- ajax calls details: /api/jsonws?contextPath=/politaktiv-map2-portlet --%>
    var map2 = createMap2({
        wrapperId: '<portlet:namespace />map',
        popupTemplateId: '<portlet:namespace />PopupTemplate',
        groupId: <%= portletGroupId %>,
        companyId: <%= company.getCompanyId() %>,
        portletId: '<%= portletId %>',
        primKey: '<%= primKey %>',
        shapesLayer: '<%= shapesLayer %>',
        userId: <%= themeDisplay.getUserId() %>,
        canAddAndUpdatePersonalShape: <%= canAddAndUpdatePersonalShape %>,
        canUpdateAnyShapes: <%= canUpdateAnyShapes %>,
        center: { lat:<%= centerLatitude %>, lng:<%= centerLongtitude %> },
        zoomLevel: <%= zoomLevel %>,
		translations: {
		resetZoom: '<liferay-ui:message key="map2.reset-zoom" />',
		yourShapes: '<liferay-ui:message key="map2.your-shapes" />',
		allShapes: '<liferay-ui:message key="map2.all-shapes" />',
		addTitleMessage: '<liferay-ui:message key="map2.add-title-message" />',
		addLabelMessage: '<liferay-ui:message key="map2.add-label-message" />',
		deleteLabelMessage: '<liferay-ui:message key="map2.delete-label-message" />',
		addLabelMessageAgain: '<liferay-ui:message key="map2.add-label-message-again" />',
		exceptionAddMessage: '<liferay-ui:message key="map2.exception-add-message" />',
		exceptionDeleteMessage: '<liferay-ui:message key="map2.exception-delete-message" />',
		exceptionAddSecondMessage: '<liferay-ui:message key="map2.exception-add-second-message" />',
		exceptionDeleteSecondMessage: '<liferay-ui:message key="map2.exception-delete-second-message" />',
		addLayer: '<liferay-ui:message key="map2.add-layer" />',
		deleteLayer: '<liferay-ui:message key="map2.delete-layer" />',
		exceptionMessage: '<liferay-ui:message key="map2.exception-message" />',
		confirmDeleteMessage: '<liferay-ui:message key="map2.confirm-delete-message" />',
		confirmAddMessage: '<liferay-ui:message key="map2.confirm-add-message" />',
		maximumLayers: '<liferay-ui:message key="map2.maximum-layers" />',
		caution1: '<liferay-ui:message key="map2.caution1" />',
		caution2: '<liferay-ui:message key="map2.caution2" />',
		chooseLayer: '<liferay-ui:message key="map2.choose-layer" />',
		deleteConfirmation1: '<liferay-ui:message key="map2.delete-confirmation1" />',
		deleteConfirmation2: '<liferay-ui:message key="map2.delete-confirmation2" />'
		}
    });
</aui:script>
