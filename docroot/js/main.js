function createMap2 (prop) {
    var _Map2 = {

        markerTitleClass: 'leaflet-marker-custom-title',
        editButtonClass: 'leaflet-marker-edit-descr',

        init: function(prop) {
            if (console) console.log(prop);

            _Map2.map = L.map('map');

            _Map2.firstLayer = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
                attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors'
                //maxZoom: 18
            }).addTo(_Map2.map);
/*
            _Map2.firemap = L.tileLayer('http://openfiremap.org/hytiles/{z}/{x}/{y}.png', {
                attribution: '&copy; OpenFireMap contributors - &copy; OpenStreetMap contributors',
                continuousWorld: true
            }).addTo(_Map2.map);*/

            //_Map2.initLayerControls();
            _Map2.initViewCenter();

            _Map2.getMarkers();
            //_Map2.initBookmarks();

            _Map2.map.setView([prop.center.lng, prop.center.lat], prop.zoomLevel);

            _Map2.bindUI();
        },
/*
        initLayerControls: function() {
            var baseLayers = {
                //'Layer 1': _Map2.firstLayer
            };

            var overlayLayers = {
                'OpenFireMap': _Map2.firemap
            };

            _Map2.orderLayerControls = L.control.orderlayers(baseLayers, overlayLayers, {collapsed: false});
            _Map2.orderLayerControls.addTo(_Map2.map);
        },*/

        initViewCenter: function() {
            var viewCenterOptions = {
                    position: 'topleft',
                    title: 'Springe zum Tübinger Bahnhof',
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
                        _Map2.initMarkersControls();
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

        initMarker: function(markerData, markerObj) {

            // create a marker if it doesn't exist
            if (!markerObj) {
                if (markerData.isOwner) {
                    markerObj = L.marker([markerData.longitude, markerData.latitude], {icon: _Map2.ownIcon, markerData: markerData});
                    _Map2.editableLayers.addLayer(markerObj);
                } else {
                    markerObj = L.marker([markerData.longitude, markerData.latitude], {markerData: markerData});
                    _Map2.fixedLayers.addLayer(markerObj);
                }
            }

            // create a popup
            var popupObj = new L.Popup();
            var popupContent = L.DomUtil.create('div', 'leaflet-custom-popup-content');

            var popupTitleWrap = L.DomUtil.create('div', 'wrap');
            var popupTitle = L.DomUtil.create('span', _Map2.markerTitleClass);
            popupTitle.innerHTML = markerData.title;
            popupTitleWrap.appendChild(popupTitle);
            popupContent.appendChild(popupTitleWrap);

            if (markerData.isOwner) { // add "edit button" if marker is editable
                var editTitle = L.DomUtil.create('span', _Map2.editButtonClass);
                editTitle.innerHTML = 'Edit Title';
                popupTitleWrap.appendChild(editTitle);

                L.DomEvent.on(editTitle, 'click', function(){
                    var markerTitle = prompt('Please enter some info:', markerData.title);

                    if (markerTitle != null) {
                        markerData.title = markerTitle;
                        popupTitle.innerHTML = markerTitle;
                        popupObj.update();
                        _Map2.markersList.update();
                    }
                    // update marker
                });
            }

            var popupText = L.DomUtil.create('div', 'text');
            popupText.innerHTML = markerData.content
            popupContent.appendChild(popupText);

            popupObj.setContent(popupContent);
            markerObj.bindPopup(popupObj);
        },

        initMarkersList: function(markersData) {
            _Map2.markersList = new L.Control.MarkersList({
                titleClass: _Map2.markerTitleClass,
                fixedLayers: _Map2.fixedLayers,
                editableLayers: _Map2.editableLayers
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
                    var markerTitle = prompt('Please enter title:');

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
                                console.log('add ok: ' + res);
                                layer.options.markerData = markerData;
                                _Map2.initMarker(markerData, layer);
                                _Map2.editableLayers.addLayer(layer);
                                _Map2.markersList.update();
                                layer.openPopup();
                            },
                            exceptionCallback = function(res) {
                                console.log('add fail: ' + res);
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
            });
            
            _Map2.editableLayers.on('dblclick', function() { console.log('double click'); });
        },
/*
        initBookmarks: function() {
            _Map2.bookmarkControl = new L.Control.Bookmarks({
                allBookmarksVisible: true,
                bookmarks: [
                            {
                                latlng: [ 48.8919221, 9.0039218 ],
                                id: 'dfghjk1',
                                name: 'testing...'
                                //zoom:
                             },
                            {
                                latlng: [ 48.7919221, 9.1039218 ],
                                id: 'dfghjk234',
                                name: 'testing..2...'
                                //zoom:
                             }
                            ]
            });
            _Map2.bookmarkControl.addTo(_Map2.map);
        },
*/
        addMarker: function(lat,lng) {
        },

        bindUI: function() {
            //marker.bindPopup("<b>Hello world!</b><br>I am a popup.");
        }
    }

    _Map2.init(prop);

    return {
        addMarker: function (lat,lng) {
            return _Map2.addMarker(lat,lng);
        }
    }
};