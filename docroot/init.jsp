<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>

<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="javax.portlet.PortletPreferences" %>

<%@ page import="org.politaktiv.map.service.permission.ShapePermission" %>

<%@ page import="static org.politaktiv.map.Constants.CENTER_LONGTITUDE" %>
<%@ page import="static org.politaktiv.map.Constants.CENTER_LATITUDE" %>
<%@ page import="static org.politaktiv.map.Constants.ZOOM_LEVEL" %>
<%@ page import="static org.politaktiv.map.Constants.SHAPES_LAYER" %>

<%@ page import="static org.politaktiv.map.Constants.DEFAULT_CENTER_LONGTITUDE" %>
<%@ page import="static org.politaktiv.map.Constants.DEFAULT_CENTER_LATITUDE" %>
<%@ page import="static org.politaktiv.map.Constants.DEFAULT_ZOOM_LEVEL" %>
<%@ page import="static org.politaktiv.map.Constants.DEFAULT_SHAPES_LAYER" %>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	String centerLongtitude = PrefsParamUtil.getString(portletPreferences, renderRequest, CENTER_LONGTITUDE, DEFAULT_CENTER_LONGTITUDE);
	String centerLatitude = PrefsParamUtil.getString(portletPreferences, renderRequest, CENTER_LATITUDE, DEFAULT_CENTER_LATITUDE);
	String zoomLevel = PrefsParamUtil.getString(portletPreferences, renderRequest, ZOOM_LEVEL, DEFAULT_ZOOM_LEVEL);
	String shapesLayer = PrefsParamUtil.getString(portletPreferences, renderRequest, SHAPES_LAYER, DEFAULT_SHAPES_LAYER);
%>

<script type="text/javascript">
/*<![CDATA[*/
	var centerLongtitude = <%= centerLongtitude %>
	var centerLatitude = <%= centerLatitude %>
	var zoomLevel = <%= zoomLevel %>
	var shapesLayer = <%= shapesLayer %>

/*]]>*/
</script>