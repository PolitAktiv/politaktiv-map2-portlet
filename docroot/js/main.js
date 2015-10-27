function createMap2 (prop) {
    var _Map2 = {

        shapeTitleClass: 'leaflet-shape-title',
        shapeUrlClass: 'leaflet-shape-url',
        shapeTextClass: 'leaflet-shape-text',
        shapeAuthorClass: 'leaflet-shape-author',
        shapeEditClass: 'leaflet-shape-edit',
        shapeSaveClass: 'leaflet-shape-save',
        shapeCancelClass: 'leaflet-shape-cancel',

        init: function(prop) {
            if (console) console.log(prop);

            _Map2.map = L.map(prop.wrapperId);

            _Map2.firstLayer = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
                attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors'
            }).addTo(_Map2.map);

            _Map2.initViewCenter();

            _Map2.getShapes();

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

        getShapes: function() {
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
                        _Map2.initShapesList();
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
            //_Map2.map.addLayer(_Map2.ownLayers);

            _Map2.otherLayers = new L.FeatureGroup();
            //_Map2.map.addLayer(_Map2.otherLayers);

            _Map2.editableLayers = new L.FeatureGroup();
            _Map2.map.addLayer(_Map2.editableLayers);

            _Map2.fixedLayers = new L.FeatureGroup();
            _Map2.map.addLayer(_Map2.fixedLayers);

            for (i=0; i<len; i++) {
                _Map2.initShape(shapesData[i]);
            }
        },

        initShape: function(shapeData) {
            var shape;
            var points = [];
            var coordsFormatted = [];
            for (var i=0; i<shapeData.coordinates.length; i++) {
                points.push([   Number(shapeData.coordinates[i].latitude).toString(),
                                Number(shapeData.coordinates[i].longitude).toString()  ]);
                coordsFormatted.push([ Number(shapeData.coordinates[i].latitude),
                                       Number(shapeData.coordinates[i].longitude)  ]);
            }
            shapeData.coordinates = null;
            shapeData.points = points;

            var properties = { shapeData: shapeData };
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
            if ((shapeData.userId === prop.userId && prop.canAddAndUpdatePersonalShape) || prop.canUpdateAnyShapes) {
                _Map2.editableLayers.addLayer(shape);
            } else {
                _Map2.fixedLayers.addLayer(shape);
            }

            _Map2.initPopup(shape);
        },

        initPopup: function(shape) {

            // create a popup
            var template = L.DomUtil.get(prop.popupTemplateId).children[0];
            var popupContent = template.cloneNode(true);

            var titleNode = shape.options.shapeData.url ? popupContent.querySelector('a.' + _Map2.shapeTitleClass) : popupContent.querySelector('span.' + _Map2.shapeTitleClass),
                textNode = popupContent.querySelector('span.' + _Map2.shapeTextClass),
                authorNode = popupContent.querySelector('span.' + _Map2.shapeAuthorClass),
                titleInput = popupContent.querySelector('input.' + _Map2.shapeTitleClass),
                urlInput = popupContent.querySelector('input.' + _Map2.shapeUrlClass),
                textInput = popupContent.querySelector('input.' + _Map2.shapeTextClass),
                editButton = popupContent.querySelector('.' + _Map2.shapeEditClass),
                saveButton = popupContent.querySelector('.' + _Map2.shapeSaveClass),
                cancelButton = popupContent.querySelector('.' + _Map2.shapeCancelClass);

            titleNode.innerHTML = shape.options.shapeData.title;
            if (shape.options.shapeData.url) titleNode.href = shape.options.shapeData.url;
            L.DomUtil.removeClass(titleNode,'hide');
            textNode.innerHTML = shape.options.shapeData.abstractDescription;
            authorNode.innerHTML = shape.options.shapeData.userName;

            titleInput.value = shape.options.shapeData.title;
            urlInput.value = shape.options.shapeData.url;
            textInput.value = shape.options.shapeData.abstractDescription;

            if ((shape.options.shapeData.userId === prop.userId && prop.canAddAndUpdatePersonalShape) || prop.canUpdateAnyShapes) {
                L.DomUtil.removeClass(editButton,'hide');
                var switchToViewMode = function() {
                    L.DomUtil.removeClass(titleNode,'hide');
                    L.DomUtil.removeClass(textNode,'hide');
                    L.DomUtil.addClass(titleInput,'hide');
                    L.DomUtil.addClass(urlInput,'hide');
                    L.DomUtil.addClass(textInput,'hide');
                    L.DomUtil.addClass(saveButton,'hide');
                    L.DomUtil.addClass(cancelButton,'hide');
                    L.DomUtil.removeClass(editButton,'hide');
                    popupObj.update();
                }
                var switchToEditMode = function() {
                    L.DomUtil.addClass(titleNode,'hide');
                    L.DomUtil.addClass(textNode,'hide');
                    L.DomUtil.removeClass(titleInput,'hide');
                    L.DomUtil.removeClass(urlInput,'hide');
                    L.DomUtil.removeClass(textInput,'hide');
                    L.DomUtil.removeClass(saveButton,'hide');
                    L.DomUtil.removeClass(cancelButton,'hide');
                    L.DomUtil.addClass(editButton,'hide');
                    popupObj.update();
                }

                L.DomEvent.on(editButton, 'click', function() {
                    switchToEditMode();
                });

                L.DomEvent.on(saveButton, 'click', function() {
                    shape.options.shapeData.title = titleInput.value;
                    shape.options.shapeData.url = urlInput.value;
                    shape.options.shapeData.abstractDescription = textInput.value;

                    _Map2.updateShapeData(shape, function(res){
                        shape.options.shapeData.title = res.title;
                        shape.options.shapeData.url = res.url;
                        shape.options.shapeData.abstractDescription = res.abstractDescription;

                        L.DomUtil.addClass(titleNode,'hide');
                        titleNode = res.url ? popupContent.querySelector('a.' + _Map2.shapeTitleClass) : popupContent.querySelector('span.' + _Map2.shapeTitleClass) ;
                        titleNode.innerHTML = res.title;
                        titleNode.href = res.url;
                        L.DomUtil.removeClass(titleNode,'hide');
                        textNode.innerHTML = res.abstractDescription;

                        _Map2.shapesList.update();
                        switchToViewMode();
                    },
                    function(){
                        shape.options.shapeData.title = titleNode.innerHTML;
                        shape.options.shapeData.url = titleNode.href ? titleNode.href : '';
                        shape.options.shapeData.abstractDescription = textNode.innerHTML;

                        titleInput.value = shape.options.shapeData.title;
                        urlInput.value = shape.options.shapeData.url;
                        textInput.value = shape.options.shapeData.abstractDescription;
                    });
                });

                L.DomEvent.on(cancelButton, 'click', function() {
                    switchToViewMode();
                });
            }

            var popupObj = new L.Popup();
            //L.DomUtil.removeClass(popupContent,'hide');
            popupObj.setContent(popupContent);
            shape.bindPopup(popupObj);
        },

        updateShapeData: function(shape, success, onError) {
            var data = shape.options.shapeData;
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
                        points: data.points || _Map2.parsePoints(shape)
                },
                successCallback = function(res) {
                    if (console) console.log('edit ok:');
                    if (console) console.log(res);
                    if (typeof success === 'function') success(res);
                },
                exceptionCallback = function(res) {
                    if (console) console.log('edit fail:');
                    if (console) console.log(res);
                    alert(res);
                    if (typeof onError === 'function') onError(res);
                }
            );
        },

        initShapesList: function() {
            _Map2.shapesList = new L.Control.ShapesList({
                otherLayers: _Map2.otherLayers,
                ownLayers: _Map2.ownLayers,
                translations: prop.translations
            });
            _Map2.map.addControl(_Map2.shapesList);
        },

        initShapesControls: function() {
            //leaflet.draw options
            var drawOptions = {};
            var drawProp = { color: '#d11' };

            if (prop.canAddAndUpdatePersonalShape) {
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

            if (prop.canAddAndUpdatePersonalShape || prop.canUpdateAnyShapes) {
            drawOptions.edit = {
                            featureGroup: _Map2.editableLayers,
                            remove: true
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

                var shapeTitle = prompt(prop.translations.addTitleMessage);

                if (shapeTitle != null) {
                    /*url = prompt(prop.translations.addUrlMessage);
                    url = url || '';
                    description = prompt(prop.translations.addDescriptionMessage);
                    description = description || '';*/
                    _Map2.saveShape(layer, type, shapeTitle, '', '');
                } else {
                    _Map2.map.removeLayer(layer);
                }
            });

            _Map2.map.on('draw:edited', function (e) {
                //if (console) console.log('edited');
                var shapes = e.layers.getLayers();

                for (var i=0, len=shapes.length; i<len; i++) {
                    //shapes[i].options.shapeData.points = instance.parsePoints(shapes[i]);
                    if (typeof shapes[i].getRadius === 'function') {
                        shapes[i].options.shapeData.radius = shapes[i].getRadius();
                    }
                    shapes[i].options.shapeData.points = _Map2.parsePoints(shapes[i]);
                    _Map2.updateShapeData(shapes[i]);
                }
            });

            _Map2.map.on('draw:deleted', function (e) {
                //if (console) console.log('deleted');
                var shapes = e.layers.getLayers();

                for (var i=0, len=shapes.length; i<len; i++) {
                    _Map2.removeShape(shapes[i]);
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
            var shapeData = {
                portletId: prop.portletId,
                primKey: prop.primKey,
                groupId: prop.groupId,
                companyId: prop.companyId,
                title: title,
                abstractDescription: description,
                url: url,
                shapeType: (type==='marker')?'POINT':type.toUpperCase(),
                radius: (type==='circle')?layer.getRadius():0,
                points: _Map2.parsePoints(layer)
            }
            Liferay.Service(
                '/politaktiv-map2-portlet.shape/add-shape',
                data = shapeData,
                successCallback = function(res) {
                    if (console) console.log('add ok:');
                   if (console) console.log(res);
                    layer.options.shapeData = res;
                    _Map2.editableLayers.addLayer(layer);
                    _Map2.ownLayers.addLayer(layer);
                    _Map2.initPopup(layer);
                    _Map2.shapesList.update();
                    layer.openPopup();
                },
                exceptionCallback = function(res) {
                    if (console) console.log('add fail:');
                    if (console) console.log(res);
                    _Map2.map.removeLayer(layer);
                }
            );
        },

        removeShape: function(shape) {
            Liferay.Service(
                '/politaktiv-map2-portlet.shape/delete-shape-by-id',
                data = {
                        portletId: prop.portletId,
                        primKey: prop.primKey,
                        shapeId: shape.options.shapeData.shapeId
                },
                successCallback = function(res) {
                    if (console) console.log(res);
                    if (shape.options.shapeData.userId === prop.userId) {
                        _Map2.ownLayers.removeLayer(shape);
                    } else {
                        _Map2.otherLayers.removeLayer(shape);
                    }
                    _Map2.shapesList.update();
                },
                exceptionCallback = function(res) {
                    if (console) console.log('del fail:');
                    if (console) console.log(res);
                }
            );
        }
    }

    _Map2.init(prop);
};
