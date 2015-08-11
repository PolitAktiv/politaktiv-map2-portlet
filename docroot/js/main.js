function createMap2 (prop) {
    var _Map2 = {

        markerTitleClass: 'leaflet-marker-custom-title',
        markerTitleWrapClass: 'leaflet-marker-custom-title-wrap',
        editButtonClass: 'leaflet-marker-edit-descr',
        markerTextClass: 'leaflet-marker-text',
        markerAuthorClass: 'leaflet-marker-author',

        init: function(prop) {
            if (console) console.log(prop);

            _Map2.map = L.map(prop.wrapperId);

            _Map2.firstLayer = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
                attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors'
            }).addTo(_Map2.map);

            _Map2.initViewCenter();

            _Map2.getMarkers();

            _Map2.map.setView([prop.center.lng, prop.center.lat], prop.zoomLevel);
        },

        initViewCenter: function() {
            var viewCenterOptions = {
                    position: 'topleft',
                    title: 'Springe zum T�binger Bahnhof',
                    forceSeparateButton: false,
                    vcLatLng: [prop.center.lng, prop.center.lat],
                    vcZoom: prop.zoomLevel
            };

            _Map2.viewCenter = new L.Control.ViewCenter(viewCenterOptions);   
            _Map2.map.addControl(_Map2.viewCenter);
        },

        getMarkers: function() {
            Liferay.Service(
                    '/politaktiv-map2-portlet.marker/get-all-markers',
                    successCallback = function(res) {
                        if (console) console.log('ok:');
                        if (console) console.log(res);

                        _Map2.initMarkers(res);
                        _Map2.initMarkersList(res);
                        if (prop.isSignedIn) {
                            _Map2.initMarkersControls();
                        }
                    },
                    exceptionCallback = function(res) {
                        if (console) console.log('fail:');
                        if (console) console.log(res);
                    }
            );
        },

        initMarkers: function(markersData) {
            var i, len = markersData.length;

            _Map2.ownIcon = L.icon({
                iconUrl: '/politaktiv-map2-portlet/images/marker-icon-red.png',
                iconRetinaUrl: '/politaktiv-map2-portlet/images/marker-icon-red-2x.png',
                shadowUrl: '/politaktiv-map2-portlet/images/marker-shadow.png',

                iconSize: [25, 41],
                shadowSize: [41, 41],
                iconAnchor: [12, 41],
                shadowAnchor: [12, 41],
                popupAnchor: [1, -34]
            });

            _Map2.fixedLayers = new L.FeatureGroup();
            _Map2.map.addLayer(_Map2.fixedLayers);

            _Map2.editableLayers = new L.FeatureGroup();
            _Map2.map.addLayer(_Map2.editableLayers);

            for (i=0; i<len; i++) {
                _Map2.initMarker(markersData[i]);
            }
        },

        initMarker: function(markerData) {
            var marker;
            if (markerData.isOwner) {
                marker = L.marker([markerData.latitude, markerData.longitude], {icon: _Map2.ownIcon, markerData: markerData});
                _Map2.editableLayers.addLayer(marker);
            } else {
                marker = L.marker([markerData.latitude, markerData.longitude], {markerData: markerData});
                _Map2.fixedLayers.addLayer(marker);
            }

            _Map2.initPopup(marker);
        },
        
        initPopup: function(marker) {

            // create a popup
            var popupObj = new L.Popup();
            var popupContent = L.DomUtil.create('div', 'leaflet-custom-popup-content');

            var popupTitleWrap = L.DomUtil.create('div', _Map2.markerTitleWrapClass);
            var popupTitle = L.DomUtil.create('span', _Map2.markerTitleClass);
            popupTitle.innerHTML = marker.options.markerData.title;
            popupTitleWrap.appendChild(popupTitle);
            popupContent.appendChild(popupTitleWrap);

            if (marker.options.markerData.isOwner) { // add "edit button" if marker is editable
                var editTitle = L.DomUtil.create('span', _Map2.editButtonClass);
                popupTitleWrap.appendChild(editTitle);

                L.DomEvent.on(editTitle, 'click', function() {
                    var markerTitle = prompt(prop.translations.editTitleMessage, marker.options.markerData.title);

                    if (markerTitle != null) {
                        marker.options.markerData.title = markerTitle;
                        _Map2.updateMarkerData(marker, function(){
                            popupTitle.innerHTML = markerTitle;
                            popupObj.update();
                            _Map2.markersList.update();
                        },
                        function(){
                            marker.options.markerData.title = popupTitle.innerHTML;
                        });
                    }
                    // update marker
                });
            }

            var popupText = L.DomUtil.create('div', _Map2.markerTextClass);
            popupText.innerHTML = marker.options.markerData.content;
            popupContent.appendChild(popupText);

            var popupAuthor = L.DomUtil.create('div', _Map2.markerAuthorClass);
            popupAuthor.innerHTML = (prop.translations.addedBy + marker.options.markerData.userName);
            popupContent.appendChild(popupAuthor);

            popupObj.setContent(popupContent);
            marker.bindPopup(popupObj);
        },

        updateMarkerData: function(marker, success, onError) {
            Liferay.Service(
                '/politaktiv-map2-portlet.marker/update-marker',
                data = {
                        markerId: marker.options.markerData.markerId,
                        title: marker.options.markerData.title,
                        content: marker.options.markerData.content,
                        longitude: marker.options.markerData.longitude,
                        latitude: marker.options.markerData.latitude
                },
                successCallback = function(res) {
                    console.log('edit ok: ' + res);
                    if (console) console.log(arguments);
                    if (typeof success === 'function') success();
                },
                exceptionCallback = function(res) {
                    console.log('edit fail: ' + res);
                    if (console) console.log(arguments);
                    alert(res);
                    if (typeof onError === 'function') onError();
                }
            );
        },

        initMarkersList: function(markersData) {
            _Map2.markersList = new L.Control.MarkersList({
                titleClass: _Map2.markerTitleClass,
                fixedLayers: _Map2.fixedLayers,
                editableLayers: _Map2.editableLayers,
                translations: prop.translations
            });
            _Map2.map.addControl(_Map2.markersList);
        },

        initMarkersControls: function() {
            //leaflet.draw options
            var drawOptions = {
                draw: {
                    polyline: false,
                    polygon: false,
                    circle: false,
                    rectangle: false,
                    marker: {
                        icon: _Map2.ownIcon
                    }
                },
                edit: {
                    featureGroup: _Map2.editableLayers,
                    remove: false
                },
                position: 'topright'
            };

            //add leaflet.draw options to map
            var drawControl = new L.Control.Draw(drawOptions);
            _Map2.map.addControl(drawControl);

            //leaflet.draw event functions
            _Map2.map.on('draw:created', function (e) {
                var type = e.layerType,
                    layer = e.layer;

                if (type === 'marker') {
                    var markerTitle = prompt(prop.translations.addTitleMessage);

                    if (markerTitle != null) {
                        var markerData = {
                            groupId: prop.groupId,
                            companyId: prop.companyId,
                            title: markerTitle,
                            content: '',
                            longitude: layer.getLatLng().lng.toString().substr(0,10),
                            latitude: layer.getLatLng().lat.toString().substr(0,10)
                        }
                        Liferay.Service(
                            '/politaktiv-map2-portlet.marker/add-marker',
                            data = markerData,
                            successCallback = function(res) {
                                if (console) console.log('add ok:');
                                if (console) console.log(res);
                                //markerData.isOwner = true;
                                layer.options.markerData = res;
                                _Map2.editableLayers.addLayer(layer);
                                _Map2.initPopup(layer);
                                _Map2.markersList.update();
                                layer.openPopup();
                            },
                            exceptionCallback = function(res) {
                                console.log('add fail:');
                                console.log(res);
                                _Map2.map.removeLayer(layer);
                            }
                        );
                    } else {
                        _Map2.map.removeLayer(layer);
                    }
                }
            });

            _Map2.map.on('draw:edited', function (e) {
                if (console) console.log('edited');
                var markers = e.layers.getLayers();
                for (var i=0, len=markers.length; i<len; i++) {
                    var newLatLng = markers[i].getLatLng();
                    markers[i].options.markerData.longitude = newLatLng.lng.toString().substr(0,10);
                    markers[i].options.markerData.latitude = newLatLng.lat.toString().substr(0,10);

                    _Map2.updateMarkerData(markers[i]);
                }
            });

            _Map2.editableLayers.on('dblclick', function() { console.log('double click'); });
        },
/*
        addMarker: function(lat,lng) {
        }*/
    }

    _Map2.init(prop);
/*
    return {
        addMarker: function (lat,lng) {
            return _Map2.addMarker(lat,lng);
        }
    }*/
};