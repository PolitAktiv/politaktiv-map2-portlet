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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>



<portlet:defineObjects />



This is the <b>leaflet-test</b> portlet.

<% // div contains map %>
 <div id="map"></div>


 
<script type="text/javascript">

 
    window.onload = function () {

	//define map
        var map = L.map('map').setView([40.712216, -74.22655], 10);

	//add image layers
        L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);

    //add layers for leaflet.draw drawings    
    var editableLayers = new L.FeatureGroup();
    map.addLayer(editableLayers);

    //leaflet.draw options
    var options = {
        draw: {
            polyline: {
                shapeOptions: {
                    color: '#f357a1',
                    weight: 10
                }
            },
            polygon: {
                allowIntersection: false, // Restricts shapes to simple polygons
                drawError: {
                    color: '#e1e100', // Color the shape will turn when intersects
                    message: '<strong>Oh snap!<strong> you can\'t draw that!' // Message that will show when intersect
                },
                shapeOptions: {
                    color: '#bada55'
                }
            },
            circle: false, // Turns off this drawing tool
            rectangle: {
                shapeOptions: {
                    clickable: false
                }
            }
        },
        edit: {
            featureGroup: editableLayers, //REQUIRED!!
            remove: false
        }
    };

    //add leaflet.draw options to map
    var drawControl = new L.Control.Draw(options);
    map.addControl(drawControl);

    //event functions
    map.on('draw:created', function (e) {
        var type = e.layerType,
            layer = e.layer;

        if (type === 'marker') {
            layer.bindPopup('A popup!');
            alert("Sie haben gerade einen heiligen Marker gesetzt. Am markierten Ort ertönt just in diesem Augenblick ein schallendes Halleluja. Eventuell... (Dies ist ein Klick-Event-Test)");
        }

        editableLayers.addLayer(layer);
    });


    
    };
</script>
