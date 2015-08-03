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


This is the <b>PolitAktive Map2</b> portlet.

<p/>
<b>Example of the get-all-markers-call</b>

<p/>
<div id="result"></div>
<p/>
Rest of the calls can be found <a target="blank" href="/api/jsonws?contextPath=/politaktiv-map2-portlet">here</a>

<aui:script use="aui-base">
Liferay.Service(
		  '/politaktiv-map2-portlet.marker/get-all-markers',
		  successCallback = function(res) {
			  A.one('#result').html('Success: ' + JSON.stringify(res));
		  },
		  exceptionCallback = function(res) {
				A.one('#result').html('Exception: ' + res);
		  }
);
</aui:script>


<% // div contains map %>
 <div id="map"></div>


<script type="text/javascript">

    window.onload = function () {
    	
	/*---------------------*/
    /*--------BASICS-------*/	
    /*---------------------*/
    
	//define map
        var map = L.map('map').setView([centerLongtitude, centerLatitude], zoomLevel);
    
	//add image layer
        var firstLayer = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);
	
	
    /*---------------------*/	
    /*-----ORDERLAYERS-----*/
    /*---------------------*/
    
    <%@include file="jspf/orderlayers.jspf" %>
       
    
    
    /*---------------------*/	
    /*--------LABEL--------*/
    /*---------------------*/

	<%@include file="jspf/label.jspf" %>
    
    
    
    /*---------------------*/	
    /*------BOOKMARKS------*/
    /*---------------------*/
    
    
    <%@include file="jspf/bookmarks.jspf" %>

	
    
    /*---------------------*/	
    /*--------DRAW---------*/
    /*---------------------*/

    <%@include file="jspf/draw.jspf" %>
    
    
    /*---------------------*/	
    /*-------INDOOR--------*/
    /*---------------------*/

    <%@include file="jspf/indoor.jspf" %>
    
    
    /*---------------------*/	
    /*------VIEWCENTER-----*/
    /*---------------------*/
    
    <%@include file="jspf/viewcenter.jspf" %>
    
    };
      
</script>
