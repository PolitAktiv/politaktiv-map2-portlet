function createMap2 (prop) {
    var selectContainer = L.DomUtil.create('div', 'leaflet-control-drop-down');
    var layers;
    var eventBind = false;

    var _Map2 = {

        shapeTitleClass: 'leaflet-shape-title',
        shapeUrlClass: 'leaflet-shape-url',
        shapeTextClass: 'leaflet-shape-text',
        shapeAuthorClass: 'leaflet-shape-author',
        shapeEditClass: 'leaflet-shape-edit',
        shapeSaveClass: 'leaflet-shape-save',
        shapeCancelClass: 'leaflet-shape-cancel',

        init: function(prop) {
            console.log('Map initializing');
            console.log(prop);

            _Map2.map = L.map(prop.wrapperId);

            _Map2.firstLayer = L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
                attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors'
            }).addTo(_Map2.map);

            _Map2.initViewCenter();

            _Map2.getAddLayerButton();

            _Map2.getDeleteLayerButton();

            _Map2.loadLayers().then(function(res) {
                _Map2.getLayers(res);
                _Map2.getDropDownMenu();
            });

            _Map2.map.setView([prop.center.lat, prop.center.lng], prop.zoomLevel);
        },

        getLayers: function(res) {
            var options = '<option>' + 'Select layer' +'</option>';
            var elem = '<select>{0}</select>';

            res.forEach(function(element) {
                var option = '<option>' + element.label +'</option>';
                options += option;
            });

            elem = elem.replace('{0}', options);
            selectContainer.innerHTML = elem;
        },

        getDropDownMenu: function() {
            var selector = L.control({
                position: 'topleft'
            });

            selector.onAdd = function(map) {
                L.DomEvent.on(selectContainer, 'change', function() {
                    var select = selectContainer.getElementsByTagName('select');
                    var label = select[0].value;

                    if (label !== 'Select layer') {
                        console.log(label);
                        _Map2.getShapes(label);
                    }
                });

                return selectContainer;
            };
            selector.addTo(_Map2.map);
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

        getShapes: function(label) {
            Liferay.Service(
                '/politaktiv-map2-portlet.shape/get-shapes-by-user-id',
                data = {
                    portletId: prop.portletId,
                    primKey: prop.primKey,
                    userId: prop.userId,
                    shapesLayer: label
                },
                successCallback = function(res) {

                    _Map2.cleanShapesAndControls();
                    console.log(res);
                    _Map2.initShapes(res);
                    _Map2.initShapesList();
                    _Map2.initShapesControls();

                    !eventBind && _Map2.initMapEvents();
                    eventBind = true;
                },
                exceptionCallback = function(res) {
                }
            );
        },

        initMapEvents: function() {
            console.log('INIT EVENTS');
            //leaflet.draw event functions
            _Map2.map.on('draw:created', function (e) {
                console.log('CREATED');

                var type = e.layerType,
                    layer = e.layer,
                    select = selectContainer.getElementsByTagName('select'),
                    label = select[0].value;

                var shapeTitle = prompt(prop.translations.addTitleMessage);

                if (shapeTitle.length) {
                    _Map2.saveShape(layer, label, type, shapeTitle, '', '');
                } else {
                    _Map2.map.removeLayer(layer);
                }
            });

            _Map2.map.on('draw:edited', function (e) {
                console.log('EDITED');
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
                console.log('DELETED');
                var shapes = e.layers.getLayers();

                for (var i=0, len=shapes.length; i<len; i++) {
                    _Map2.removeShape(shapes[i]);
                }
            });
        },

        cleanShapesAndControls: function() {
            var parent = document.getElementsByClassName('leaflet-marker-pane')[0];
            var shadow = document.getElementsByClassName('leaflet-shadow-pane')[0];
            var control_panel = document.getElementsByClassName('leaflet-top leaflet-right')[0];
            var otherFigures = document.querySelector('svg.leaflet-zoom-animated');

            _Map2.removeContentIfExists(parent);
            _Map2.removeContentIfExists(shadow);
            _Map2.removeContentIfExists(control_panel);
            _Map2.removeContentIfExists(otherFigures);
        },

        removeContentIfExists: function(node) {
            if(node) {
                node.innerHTML = '';
            }
        },

        getAddLayerButton: function() {
            var customControl =  L.Control.extend({
                options: {
                    position: 'topleft'
                },

                onAdd: function (map) {
                    var addButton = L.DomUtil.create('div', 'leaflet-bar leaflet-control-button');

                    addButton.innerHTML= 'Add layer';

                    L.DomEvent.on(addButton, 'click', function() {

                        do {
                            var label = prompt(prop.translations.addLabelMessage);
                            if(label.length < 1) {
                                alert(prop.translations.addLabelMessageAgain);
                            } else {
                                console.log('Label not empty');
                                _Map2.saveLayerContainer(label);
                            }
                        } while(label.length < 1)
                    });
                    return addButton;
                }
            });

            _Map2.map.addControl(new customControl());
        },

        getDeleteLayerButton: function() {
            var customControl =  L.Control.extend({
                options: {
                    position: 'topleft'
                },

                onAdd: function (map) {
                    var addButton = L.DomUtil.create('div', 'leaflet-bar leaflet-control-button');

                    addButton.innerHTML= prop.translations.deleteLayer;

                    L.DomEvent.on(addButton, 'click', function() {

                        do {
                            var label = prompt(prop.translations.deleteLabelMessage);

                            if(label.length < 1) {
                                alert(prop.translations.addLabelMessageAgain);
                            } else {
                                _Map2.deleteLayerContainer(label);
                                console.log("cleanShapesAndControls");
                                _Map2.cleanShapesAndControls();
                            }
                        } while(label.length < 1)
                    });
                    return addButton;
                }
            });

            _Map2.map.addControl(new customControl());
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
                };
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
                };

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
                    shapesLayer:prop.shapesLayer,
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

        saveLayerContainer: function(label) {
            var layerData = {
                userId: prop.userId,
                shapesLayer: label
            };

            Liferay.Service(
                '/politaktiv-map2-portlet.layer/add-layer',
                data = layerData,
                successCallback = function(res) {

                    if (res == false) {

                        do {
                            var newLabel = prompt(prop.translations.exceptionAddMessage);

                            if(newLabel.length && newLabel != label) {
                                _Map2.saveLayerContainer(newLabel);
                            } else {
                                alert(prop.translations.exceptionAddSecondMessage);
                            }
                        } while(newLabel.length == 0 || newLabel == label)

                    } else {
                        _Map2.loadLayers().then(function(res) {
                            _Map2.getLayers(res);
                            _Map2.getDropDownMenu();
                        });
                        alert(prop.translations.confirmAddMessage);
                    }

                },
                exceptionCallback = function(res) {
                    console.log('add fail:');
                }
            );
        },

        deleteLayerContainer: function(label) {
            var layerData = {
                userId: prop.userId,
                shapesLayer: label
            };

            Liferay.Service(
                '/politaktiv-map2-portlet.layer/delete-layer',
                data = layerData,
                successCallback = function(res) {

                    if (res == false) {

                        do {
                            var newLabel = prompt(prop.translations.exceptionDeleteMessage);

                            if(newLabel.length && newLabel != label) {
                                _Map2.deleteLayerContainer(newLabel);
                            } else {
                                alert(prop.translations.exceptionDeleteSecondMessage);
                            }
                        } while(newLabel.length == 0 || newLabel == label)

                    } else {
                        _Map2.loadLayers().then(function(res) {
                            _Map2.getLayers(res);
                            _Map2.getDropDownMenu();
                        });
                        alert(prop.translations.confirmDeleteMessage);
                    }
                },
                exceptionCallback = function(res) {
                    console.log('delete fail:');
                }
            );
        },

        loadLayers: function() {
            var layerData = {
                userId: prop.userId
            };

            var fetchData = function () {
                return new Promise(function (resolve, reject) {

                    Liferay.Service(
                        '/politaktiv-map2-portlet.layer/find-all-layers',
                        data = layerData,
                        successCallback = function(res) {
                            resolve(res);
                        },
                        exceptionCallback = function(res) {
                            reject(res);
                        }
                    );
                });
            };
            return fetchData();
        },

        saveShape: function(layer, label, type, title, url, description) {
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
                shapesLayer: label,
                points: _Map2.parsePoints(layer)
            };
            Liferay.Service(
                '/politaktiv-map2-portlet.shape/add-shape',
                data = shapeData,
                successCallback = function(res) {

                    console.log('Add-shape!!!');
                    console.log(res);
                    layer.options.shapeData = res;
                    _Map2.editableLayers.addLayer(layer);
                    _Map2.ownLayers.addLayer(layer);
                    _Map2.initPopup(layer);
                    _Map2.shapesList.update();
                    layer.openPopup();
                },
                exceptionCallback = function(res) {
                    console.log('add fail:');
                    console.log(res);
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
                    console.log(res);
                    if (shape.options.shapeData.userId === prop.userId) {
                        _Map2.ownLayers.removeLayer(shape);
                    } else {
                        _Map2.otherLayers.removeLayer(shape);
                    }
                    _Map2.shapesList.update();
                },
                exceptionCallback = function(res) {
                    console.log('del fail:');
                    console.log(res);
                }
            );
        }
    };

    _Map2.init(prop);
}