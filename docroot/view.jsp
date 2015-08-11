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

<% // div contains map %>
<div id="<portlet:namespace />map" class="map"></div>

<aui:script use="aui-base">
    var map2 = createMap2({
        wrapperId: '<portlet:namespace />map',
        groupId: <%= portletGroupId %>,
        companyId: <%= company.getCompanyId() %>,
        isSignedIn: <%= themeDisplay.isSignedIn() %>,
        center: { lat:<%= centerLatitude %>, lng:<%= centerLongtitude %> },
        zoomLevel: <%= zoomLevel %>,
        translations: {
            yourMarkers: 'Your markers:',
            allMarkers: 'All markers:',
            addedBy: 'Added by: ',
            addTitleMessage: 'Please enter title:',
            editTitleMessage: 'Please enter new title:'
        }
    });
</aui:script>
