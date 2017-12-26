L.Draw.ImageOverlay = L.Draw.Feature.extend({
    statics: {
        TYPE: 'image'
    },

    initialize: function (map, options) {
        this.type = L.Draw.Image.TYPE;
        this._map = map;
        L.Draw.Feature.prototype.initialize.call(this, map, options);
    },
	_getFileUrl: function (callback) {
		var self = this;
		var input = document.createElement('input');
		var reader = new FileReader();
		input.setAttribute('type', 'file');
		input.setAttribute('accept', 'image/*');

		input.addEventListener('change', function () {
			if (input.files.length > 0 && input.files[0].size / 1024 <= 65) {
				reader.readAsDataURL(input.files[0]);
			}
		});

		reader.addEventListener('loadend', function () {
			self.imageUrl = reader.result;
			// console.log('loadend');

			if (callback) {
                callback.call(self, reader.result);
			}
		});

		input.click();
	},

    forceUpdate: function () {
        var image   = this.overlay._image,
            topLeft = this._map.latLngToLayerPoint(this.overlay._bounds.getNorthWest()),
            size = this._map.latLngToLayerPoint(this.overlay._bounds.getSouthEast())._subtract(topLeft);

        L.DomUtil.setPosition(image, topLeft);

        image.style.width  = size.x + 'px';
        image.style.height = size.y + 'px';
    },

	createOverlay: function () {
		var self = this;
        self._getFileUrl(function () {
            self.overlay = new L.ImageOverlay(self.imageUrl, [self._map.getCenter(), self._map.getCenter()]);

            self._mapDraggable = self._map.dragging.enabled();

            if (self._mapDraggable) {
                self._map.dragging.disable();
            }

            function mouseDown(mouseDownEvent) {
                L.DomEvent.stopPropagation(mouseDownEvent);
                // console.log(mouseDownEvent, 'mousedown');

                self.overlay._bounds._northEast = new L.LatLng(mouseDownEvent.latlng.lat, mouseDownEvent.latlng.lng);

                var mouseMove = function (mouseMoveEvent) {
                    L.DomEvent.stopPropagation(mouseMoveEvent);
                    // console.log(mouseMoveEvent, 'mousemove');

                    self.overlay._bounds._southWest = new L.LatLng(mouseMoveEvent.latlng.lat, mouseMoveEvent.latlng.lng);
                    self.overlay._reset();
                };

                var mouseUp = function (mouseUpEvent) {
                    L.DomEvent.stopPropagation(mouseUpEvent);
                    // console.log(mouseUpEvent, 'mouseup');
                    self.overlay._bounds._southWest = new L.LatLng(mouseUpEvent.latlng.lat, mouseUpEvent.latlng.lng);
                    L.DomEvent.off(self._map, 'mousemove', mouseMove);
                    L.DomEvent.off(self._map, 'mouseup', mouseUp);
                    L.DomEvent.off(self._map, 'mousedown', mouseDown);

                    self._map.dragging.enable();

                    self._fireCreatedEvent();
                };

                L.DomEvent.on(self._map, 'mousemove', mouseMove);
                L.DomEvent.on(self._map, 'mouseup', mouseUp);

                self._map.addLayer(self.overlay);
            }



            L.DomEvent.on(self._map, 'mousedown', mouseDown);
        });
    },

    addHooks: function () {
    	var self = this;
		this.createOverlay(function(){
            L.Draw.Feature.prototype.addHooks.call(self);
		});
    },

    removeHooks: function () {
        L.Draw.Feature.prototype.removeHooks.call(this);

        if (this._map) {
            if (this.overlay) {
                this._map
                    .removeLayer(this.overlay);
                delete this.overlay;
            }
        }
    },

    _fireCreatedEvent: function () {
        var marker = new L.ImageOverlay(this.imageUrl, this.overlay._bounds);
        L.Draw.Feature.prototype._fireCreatedEvent.call(this, marker);
    }
});

L.Draw.Image = L.Draw.Feature.extend({
	statics: {
		TYPE: 'image'
	},

	options: {
		icon: new L.Icon.Default(),
		repeatMode: false,
		zIndexOffset: 2000 // This should be > than the highest z-index any markers
	},

	initialize: function (map, options) {
		// Save the type so super can fire, need to do this as cannot do this.TYPE :(
		this.type = L.Draw.Image.TYPE;

		L.Draw.Feature.prototype.initialize.call(this, map, options);
	},

	addHooks: function () {
		L.Draw.Feature.prototype.addHooks.call(this);

		if (this._map) {
			this._tooltip.updateContent({ text: L.drawLocal.draw.handlers.image.tooltip.start });

			// Same mouseMarker as in Draw.Polyline
			if (!this._mouseMarker) {
				this._mouseMarker = L.marker(this._map.getCenter(), {
					icon: L.divIcon({
						className: 'leaflet-mouse-marker',
						iconAnchor: [20, 20],
						iconSize: [40, 40]
					}),
					opacity: 0,
					zIndexOffset: this.options.zIndexOffset
				});
			}

			this._mouseMarker
				.on('click', this._onClick, this)
				.addTo(this._map);

			this._map.on('mousemove', this._onMouseMove, this);
		}
	},

	removeHooks: function () {
		L.Draw.Feature.prototype.removeHooks.call(this);

		if (this._map) {
			if (this._marker) {
				this._marker.off('click', this._onClick, this);
				this._map
					.off('click', this._onClick, this)
					.removeLayer(this._marker);
				delete this._marker;
			}

			this._mouseMarker.off('click', this._onClick, this);
			this._map.removeLayer(this._mouseMarker);
			delete this._mouseMarker;

			this._map.off('mousemove', this._onMouseMove, this);
		}
	},

	_onMouseMove: function (e) {
		var latlng = e.latlng;

		this._tooltip.updatePosition(latlng);
		this._mouseMarker.setLatLng(latlng);

		if (!this._marker) {
			this._marker = new L.Marker(latlng, {
				icon: this.options.icon,
				zIndexOffset: this.options.zIndexOffset
			});
			// Bind to both marker and map to make sure we get the click event.
			this._marker.on('click', this._onClick, this);
			this._map
				.on('click', this._onClick, this)
				.addLayer(this._marker);
		}
		else {
			latlng = this._mouseMarker.getLatLng();
			this._marker.setLatLng(latlng);
		}
	},

	_onClick: function () {
		this._fireCreatedEvent();

		this.disable();
		if (this.options.repeatMode) {
			this.enable();
		}
	},

	_fireCreatedEvent: function () {
		var marker = new L.Marker(this._marker.getLatLng(), { icon: this.options.icon });
		L.Draw.Feature.prototype._fireCreatedEvent.call(this, marker);
	}
});