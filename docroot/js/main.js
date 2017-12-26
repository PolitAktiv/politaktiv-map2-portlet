function createMap2 (prop) {
    var selectContainer = L.DomUtil.create('div', 'leaflet-control-drop-down');
    var layers;
    var eventBind = false;

    var _Map2 = window._Map = {

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
                console.log(res);
                _Map2.getLayers(res);
                _Map2.getDropDownMenu();
            });

            _Map2.map.setView([prop.center.lat, prop.center.lng], prop.zoomLevel);
        },

        getLayers: function(res) {
            var options = '<option data-value="default">' + prop.translations.defaultLayer +'</option>';
            var elem = '<select id="map-layers-select">{0}</select>';

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
                L.DomEvent.addListener(selectContainer, 'change', function(e) {
                    var currentOption = document.getElementById('map-layers-select').value;

                    _Map2.getShapes(currentOption);
                });
                return selectContainer;
            };

            selector.addTo(_Map2.map);

            // trigger change event for main layer to get shapes on map
            var el = document.getElementById('map-layers-select');
            var ev = document.createEvent('Event');
            ev.initEvent('change', true, false);
            el.dispatchEvent(ev);
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
                exceptionCallback = function(res) {}
            );
        },

        initMapEvents: function() {
            //leaflet.draw event functions
            _Map2.map.on('draw:created', function (e) {

                var type = e.layerType,
                    layer = e.layer,
                    select = selectContainer.getElementsByTagName('select'),
                    label = select[0].value;

                var shapeTitle = prompt(prop.translations.addTitleMessage);

                if (shapeTitle && shapeTitle.length) {

                    if (type === 'image') {
                        _Map2.saveShape(layer, label, type, shapeTitle, '', e.layer._url);
                    } else {
                        _Map2.saveShape(layer, label, type, shapeTitle, '', '');
                    }
                } else {
                    _Map2.map.removeLayer(layer);
                }
            });

            _Map2.map.on('draw:edited', function (e) {
                console.log('EDITED');
                var shapes = e.layers.getLayers();

                for (var i=0, len=shapes.length; i<len; i++) {

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

                    addButton.innerHTML= prop.translations.addLayer;

                    L.DomEvent.on(addButton, 'click', function() {
                        var layersExists = document.getElementById('map-layers-select').querySelectorAll('option').length - 1;
                        var maximumLayers = prop.translations.maximumLayers;

                        if(layersExists < maximumLayers) {
                            var label = prompt(prop.translations.addLabelMessage);

                            if(label !== null && label.length) {
                                _Map2.saveLayerContainer(label);
                            } else if(label !== null) {
                                alert(prop.translations.addLabelMessageAgain);
                            }
                        } else {
                            alert(prop.translations.caution1 + " " + prop.translations.maximumLayers + " " + prop.translations.caution2);
                        }
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
                    var deleteButton = L.DomUtil.create('div', 'leaflet-bar leaflet-control-button');

                    deleteButton.innerHTML= prop.translations.deleteLayer;

                    L.DomEvent.on(deleteButton, 'click', function(e) {
                        var currentOption = document.getElementById('map-layers-select').value;
                        var defaultOption = document.querySelector('[data-value]').value;

                        if(currentOption === defaultOption) {
                            alert(prop.translations.chooseLayer);
                        } else {

                            var confirmation = confirm(prop.translations.deleteConfirmation1 + " " + currentOption + " " + prop.translations.deleteConfirmation2);
                            confirmation && _Map2.deleteLayerContainer(currentOption);
                            confirmation && _Map2.cleanShapesAndControls();
                            confirmation &&_Map2.getShapes(prop.translations.defaultLayer);
                        }
                    });
                    return deleteButton;
                }
            });

            _Map2.map.addControl(new customControl());
        },

        initShapes: function(shapesData) {
            var i, len = shapesData.length;

            _Map2.ownLayers = new L.FeatureGroup();
            //_Map2.map.addLayer(_Map2.ownLayers);

            _Map2.otherLayers = new L.FeatureGroup();
            //_Map2.map.addLayer(_Map2.otherLayers);

            _Map2.editableLayers = new L.FeatureGroup();
            _Map2.map.addLayer(_Map2.editableLayers);

            _Map2.fixedLayers = new L.FeatureGroup();
            _Map2.map.addLayer(_Map2.fixedLayers);

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

            _Map2.imageIcon = L.icon({
                iconUrl: shapeData.image,
                iconRetinaUrl: shapeData.image,
                iconAnchor: [10, 26],
                popupAnchor: [1, -34]
            });

            var properties = { shapeData: shapeData };
            if (shapeData.userId === prop.userId) {
                if(shapeData.shapeType === 'POINT') {
                    properties.icon = _Map2.ownIcon;
                } else if(shapeData.shapeType === 'IMAGE') {
                    properties.icon = _Map2.imageIcon;
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
                case 'IMAGE':
                    shape = L.imageOverlay(shapeData.image, shapeData.points);
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

            if(shapeData.shapeType !== 'IMAGE'){
                _Map2.initPopup(shape);
            }
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
            console.log('updateShapeData!');
            var data = shape.options.shapeData;
            Liferay.Service(
                '/politaktiv-map2-portlet.shape/update-shape',
                data = {
                    portletId: prop.portletId,
                    primKey: prop.primKey,
                    shapeId: data.shapeId,
                    title: data.title,
                    abstractDescription: data.abstractDescription,
                    image: data.image,
                    shapeType: data.shapeType,
                    radius: data.radius,
                    shapesLayer:prop.shapesLayer,
                    points: data.points || _Map2.parsePoints(shape)
                },
                successCallback = function(res) {
                    console.log('edit ok:');
                    console.log(res);
                    if (typeof success === 'function') success(res);
                },
                exceptionCallback = function(res) {
                    console.log('edit fail:');
                    console.log(res);
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
                    },
                    image: {}
                };
            } else {
                drawOptions.draw = {
                    polyline: false,
                    polygon: false,
                    circle: false,
                    rectangle: false,
                    marker: false,
                    image: false
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
                var latLngs = layer.getLatLngs ? layer.getLatLngs() : [layer._bounds._northEast, layer._bounds._southWest];
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

                            if(newLabel && newLabel.length && newLabel != label) {
                                _Map2.saveLayerContainer(newLabel);
                            } else if(newLabel !== null) {
                                alert(prop.translations.exceptionAddSecondMessage);
                            }
                        } while(newLabel && newLabel.length == 0 || newLabel == label)

                    } else {
                        _Map2.loadLayers().then(function(res) {
                            _Map2.getLayers(res);

                            var select = document.getElementById('map-layers-select');
                            select.value = label;
                            var selectContainer = select.parentNode;

                            // set select value of created layer and trigger change event;
                            selectContainer.dispatchEvent(new Event('change'));
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

                    if (res == true) {
                        _Map2.loadLayers().then(function(res) {
                            _Map2.getLayers(res);
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

        saveShape: function(layer, label, type, title, description, image) {
            var shapeData = {
                portletId: prop.portletId,
                primKey: prop.primKey,
                groupId: prop.groupId,
                companyId: prop.companyId,
                title: title,
                abstractDescription: description,
                image: image,
                shapeType: (type==='marker')?'POINT':type.toUpperCase(),
                radius: (type==='circle')?layer.getRadius():0,
                shapesLayer: label,
                points: _Map2.parsePoints(layer)
            };

            var data;

            Liferay.Service(
                '/politaktiv-map2-portlet.shape/add-shape',
                data = shapeData,
                successCallback = function(res) {
                    if(res.image.length && type !== 'image') {
                        // update marker when we choose image
                        layer.options.icon.options = {
                            iconAnchor: [10, 26],
                            popupAnchor: [1, -34],
                            shadowSize: [0, 0]
                        };
                    }

                    layer.options.shapeData = res;
                    _Map2.editableLayers.addLayer(layer);
                    _Map2.ownLayers.addLayer(layer);
                    _Map2.initPopup(layer);
                    _Map2.shapesList.update();
                    layer.openPopup();
                    console.log(res);

                    if(res.image.length) {
                        var newIcon = layer.editing._marker._icon;
                        newIcon.src = res.image;

                        // reset to default blue marker
                        layer.options.icon.options = {
                            iconSize: [25, 41],
                            shadowSize: [41, 41],
                            iconAnchor: [12, 41],
                            shadowAnchor: [12, 41],
                            popupAnchor: [1, -34]
                        };
                    }

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