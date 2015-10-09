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

            _Map2.map.setView([prop.center.lat, prop.center.lng], prop.zoomLevel);
        },

        initViewCenter: function() {
            var viewCenterOptions = {
                    position: 'topleft',
                    title: prop.translations.resetZoom,
                    forceSeparateButton: false,
                    vcLatLng: [prop.center.lat, prop.center.lng],
                    vcZoom: prop.zoomLevel
            };

            _Map2.viewCenter = new L.Control.ViewCenter(viewCenterOptions);   
            _Map2.map.addControl(_Map2.viewCenter);
        },

        getMarkers: function() {
            Liferay.Service(
                    '/politaktiv-map2-portlet.shape/get-all-shapes',
                    data = {
                            portletId: prop.portletId,
                            primKey: prop.primKey
                    },
                    successCallback = function(res) {
                        if (console) console.log('ok:');
                        if (console) console.log(res);

                        _Map2.initShapes(res);
                        _Map2.initShapesList(res);
                        _Map2.initShapesControls();
                    },
                    exceptionCallback = function(res) {
                        if (console) console.log('fail:');
                        if (console) console.log(res);
                    }
            );
        },

        initShapes: function(shapesData) {
            var i, len = shapesData.length;

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

            _Map2.ownLayers = new L.FeatureGroup();
            _Map2.map.addLayer(_Map2.ownLayers);

            _Map2.otherLayers = new L.FeatureGroup();
            _Map2.map.addLayer(_Map2.otherLayers);

            _Map2.editableLayers = new L.FeatureGroup();

            for (i=0; i<len; i++) {
                _Map2.initShape(shapesData[i]);
            }
        },

        initShape: function(shapeData) {
            var shape;
    		var points = [];
    		var coordsFormatted = [];
    		for (var i=0; i<shapeData.coordinates.length; i++) {
    			points.push([	Number(shapeData.coordinates[i].latitude).toString(),
    			                Number(shapeData.coordinates[i].longitude).toString()  ]);
    			coordsFormatted.push([	Number(shapeData.coordinates[i].latitude),
    			                      	Number(shapeData.coordinates[i].longitude)  ]);
    		}
    		shapeData.coordinates = null;
    		shapeData.points = points;

    		var properties = { markerData: shapeData };
    		if (shapeData.userId === prop.userId) {
    			if(shapeData.shapeType === 'POINT') {
	    			properties.icon = _Map2.ownIcon;
	    		} else {
	    			properties.color = '#d11';
	    		}
			}

            switch (shapeData.shapeType) {
	        	case 'POINT':
        			shape = L.marker(coordsFormatted[0], properties);
	        		break;
	        	case 'POLYLINE':
        			shape = L.polyline(coordsFormatted, properties);
	        		break;
	        	case 'CIRCLE':
        			shape = L.circle(coordsFormatted[0], shapeData.radius, properties);
	        		break;
	        	case 'POLYGON':
        			shape = L.polygon(coordsFormatted, properties);
	        		break;
	        	case 'RECTANGLE':
        			shape = L.rectangle(coordsFormatted, properties);
	        		break;
            }

            if (shapeData.userId === prop.userId) {
                _Map2.ownLayers.addLayer(shape);
            } else {
                _Map2.otherLayers.addLayer(shape);
            }
            if (shapeData.updatableByCurrentUser) {
                _Map2.editableLayers.addLayer(shape);
            }

            _Map2.initPopup(shape);
        },
        
        initPopup: function(shape) {

            // create a popup
        	/*var template = L.DomUtil.get(prop.popupTemplateId);
        	var popupContent = template.cloneNode();
        	popupContent.removeClass('hide');*/

            var popupObj = new L.Popup();
            var popupContent = L.DomUtil.create('div', 'leaflet-custom-popup-content');

            var popupTitleWrap = L.DomUtil.create('div', _Map2.markerTitleWrapClass);
            var popupTitle;
            if (shape.options.markerData.url) {
	            popupTitle = L.DomUtil.create('a', _Map2.markerTitleClass);
	            popupTitle.href = shape.options.markerData.url;
	            popupTitle.target='_blank';
            } else {
	            popupTitle = L.DomUtil.create('span', _Map2.markerTitleClass);
            }

            popupTitle.innerHTML = shape.options.markerData.title;
            popupTitleWrap.appendChild(popupTitle);
            popupContent.appendChild(popupTitleWrap);

            if (shape.options.markerData.updatableByCurrentUser) { // add "edit button" if marker is editable
                var editTitle = L.DomUtil.create('span', _Map2.editButtonClass);
                popupTitleWrap.appendChild(editTitle);

                L.DomEvent.on(editTitle, 'click', function() {
                    var title = prompt(prop.translations.editTitleMessage, shape.options.markerData.title);

                    if (title != null) {
                        // update marker
                    	shape.options.markerData.title = title;
                        _Map2.updateMarkerData(shape, function(){
                            popupTitle.innerHTML = title;
                            popupObj.update();
                            _Map2.markersList.update();
                        },
                        function(){
                        	shape.options.markerData.title = popupTitle.innerHTML;
                        });
                    }
                });

            	var popupUrlWrap = L.DomUtil.create('div', 'leaflet-marker-url-wrap');
            	var popupUrl = L.DomUtil.create('span');
            	popupUrl.innerHTML = shape.options.markerData.url || 'http://';
            	popupUrlWrap.appendChild(popupUrl);
            	var editUrl = L.DomUtil.create('span', _Map2.editButtonClass);
            	popupUrlWrap.appendChild(editUrl);
            	popupContent.appendChild(popupUrlWrap);

            	L.DomEvent.on(editUrl, 'click', function() {
                    var url = prompt(prop.translations.editUrlMessage, shape.options.markerData.url);

                    if (url != null) {
                    	shape.options.markerData.url = url;
                        _Map2.updateMarkerData(shape, function(){
                            popupUrl.innerHTML = url;
                            popupObj.update();
                            _Map2.markersList.update();
                        },
                        function() {
                        	shape.options.markerData.url = popupUrl.innerHTML;
                        });
                    }
                });
            }

            var popupTextWrap = L.DomUtil.create('div', 'leaflet-marker-text-wrap');
            var popupText = L.DomUtil.create('div', _Map2.markerTextClass);
            popupText.innerHTML = shape.options.markerData.abstractDescription;
            popupTextWrap.appendChild(popupText);
            popupContent.appendChild(popupTextWrap);

            if (shape.options.markerData.updatableByCurrentUser) {    
                var editText = L.DomUtil.create('span', _Map2.editButtonClass);
                popupTextWrap.appendChild(editText);

                L.DomEvent.on(editText, 'click', function() {
                    var text = prompt(prop.translations.editTextMessage, shape.options.markerData.abstractDescription);

                    if (text != null) {
                    	shape.options.markerData.abstractDescription = text;
                        _Map2.updateMarkerData(shape, function(){
                            popupText.innerHTML = text;
                            popupObj.update();
                            _Map2.markersList.update();
                        },
                        function(){
                        	shape.options.markerData.abstractDescription = popupText.innerHTML;
                        });
                    }
                });
            }

            var popupAuthor = L.DomUtil.create('div', _Map2.markerAuthorClass);
            popupAuthor.innerHTML = (prop.translations.addedBy + shape.options.markerData.userName);
            popupContent.appendChild(popupAuthor);

            popupObj.setContent(popupContent);
            shape.bindPopup(popupObj);
        },

        updateMarkerData: function(shape, success, onError) {
        	var data = shape.options.markerData;
            Liferay.Service(
                '/politaktiv-map2-portlet.shape/update-shape',
                data = {
                        portletId: prop.portletId,
                        primKey: prop.primKey,
                        shapeId: data.shapeId,
                        title: data.title,
                        abstractDescription: data.abstractDescription,
                        url: data.url,
                        shapeType: data.shapeType,
                        radius: data.radius,
                        points: data.points
                },
                successCallback = function(res) {
                    if (console) console.log('edit ok:');
                    if (console) console.log(res);
                    if (typeof success === 'function') success();
                },
                exceptionCallback = function(res) {
                    if (console) console.log('edit fail:');
                    if (console) console.log(res);
                    alert(res);
                    if (typeof onError === 'function') onError();
                }
            );
        },

        initShapesList: function(markersData) {
            _Map2.markersList = new L.Control.MarkersList({
                titleClass: _Map2.markerTitleClass,
                otherLayers: _Map2.otherLayers,
                ownLayers: _Map2.ownLayers,
                translations: prop.translations
            });
            _Map2.map.addControl(_Map2.markersList);
        },

        initShapesControls: function() {
        	//leaflet.draw options
        	var instance = this;
        	var drawOptions = {};
        	var drawProp = { color: '#d11' };
        	
        	if (prop.canAddMarkers) {
        		drawOptions.draw = {
                    polyline: drawProp,
                    polygon: drawProp,
                    circle: drawProp,
                    rectangle: drawProp,
                    marker: {
                        icon: _Map2.ownIcon
                    }
                };
        	} else {
        		drawOptions.draw = {
                        polyline: false,
                        polygon: false,
                        circle: false,
                        rectangle: false,
                        marker: false
                };
        	}
        	
        	if (prop.canUpdateMarkers) {
        		drawOptions.edit = {
                        featureGroup: _Map2.editableLayers,
                        remove: false
                };
        	}
        	
        	drawOptions.position = 'topright';

            //add leaflet.draw options to map
            var drawControl = new L.Control.Draw(drawOptions);
            _Map2.map.addControl(drawControl);

            //leaflet.draw event functions
            _Map2.map.on('draw:created', function (e) {
                var type = e.layerType,
                    layer = e.layer;

                var shapeTitle = prompt(prop.translations.addTitleMessage),
                	url, description;

                if (shapeTitle != null) {
                	url = prompt(prop.translations.addUrlMessage);
                	url = url || '';
                	description = prompt(prop.translations.addDescriptionMessage);
                	description = description || '';
                	instance.saveShape(layer, type, shapeTitle, url, description);
                } else {
                    _Map2.map.removeLayer(layer);
                }
            });

            _Map2.map.on('draw:edited', function (e) {
                if (console) console.log('edited');
                var shapes = e.layers.getLayers();

                for (var i=0, len=shapes.length; i<len; i++) {
                	shapes[i].options.markerData.points = instance.parsePoints(shapes[i]);
                	if (typeof shapes[i].getRadius === 'function') {
                		shapes[i].options.markerData.radius = shapes[i].getRadius();
                	}
                    _Map2.updateMarkerData(shapes[i]);
                }
            });
        },
        
        parsePoints: function(layer) {
	    	var points = [];
	    	if (typeof layer.getLatLng === 'function'){
	    		points.push([  layer.getLatLng().lat.toString().substr(0,10),
	                	       layer.getLatLng().lng.toString().substr(0,10)  ]);
	        } else {
	        	var latLngs = layer.getLatLngs();
	        	for (var i=0; i<latLngs.length; i++) {
	        		points.push([  latLngs[i].lat.toString().substr(0,10),
	        		               latLngs[i].lng.toString().substr(0,10)  ]);
	        	}
	        }
	    	return points;
        },
        
        saveShape: function(layer, type, title, url, description) {
        	var instance = this;
	        var markerData = {
	            portletId: prop.portletId,
	            primKey: prop.primKey,
	            groupId: prop.groupId,
	            companyId: prop.companyId,
	            title: title,
	            abstractDescription: description,
	            url: url,
	            shapeType: (type==='marker')?'POINT':type.toUpperCase(),
	            radius: (type==='circle')?layer.getRadius():0,
	            points: instance.parsePoints(layer)
	        }
	        Liferay.Service(
	            '/politaktiv-map2-portlet.shape/add-shape',
	            data = markerData,
	            successCallback = function(res) {
	                if (console) console.log('add ok:');
	                if (console) console.log(res);
	                layer.options.markerData = res;
	                _Map2.editableLayers.addLayer(layer);
	                _Map2.ownLayers.addLayer(layer);
	                _Map2.initPopup(layer);
	                _Map2.markersList.update();
	                layer.openPopup();
	            },
	            exceptionCallback = function(res) {
	                if (console) console.log('add fail:');
	                if (console) console.log(res);
	                _Map2.map.removeLayer(layer);
	            }
	        );
        }
    }

    _Map2.init(prop);
};