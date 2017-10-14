
L.Control.ShapesList = L.Control.extend({

    options: {
        containerClass: 'leaflet-control-layers leaflet-control leaflet-markers-list',
        headerClass: 'leaflet-markers-list-header',
        listItemClass: 'leaflet-markers-list-item'
    },

    initialize: function(options) {
        this.options = L.Util.extend(this.options, options);

        L.Control.prototype.initialize.call(this, this.options);
    },

    onAdd: function(map) {
        var container = this._container = L.DomUtil.create('div', this.options.containerClass);

        L.DomEvent
          .disableClickPropagation(container)
          .disableScrollPropagation(container);

        this._list = L.DomUtil.create('div', 'list');
        this._container.appendChild(this._list);
        this.update();

        return container;
    },

    update: function() {
        this._list.innerHTML = '';

        var own = this.options.ownLayers.getLayers();
        var other = this.options.otherLayers.getLayers();

        if (own.length) {
            var listHeader = L.DomUtil.create('div', this.options.headerClass);
            listHeader.innerHTML = this.options.translations.yourShapes;
            this._list.appendChild(listHeader);

            for (var i = 0, len = own.length; i < len; i++) {
                this.addItem(own[i]);
            }
        }

        if (own.length && other.length) {
            var hr = L.DomUtil.create('hr');
            this._list.appendChild(hr);
        }

        if (other.length) {
            var list2Header = L.DomUtil.create('div', this.options.headerClass);
            list2Header.innerHTML = this.options.translations.allShapes;
            this._list.appendChild(list2Header);

            for (var i = 0, len = other.length; i < len; i++) {
                this.addItem(other[i]);
            }
        }
    },

    addItem: function(shape) {
        var self = this;
        var item;

        item = L.DomUtil.create('div', this.options.listItemClass);
        item.innerHTML = shape.options.shapeData.title;
        this._list.appendChild(item);

        L.DomEvent.on(item, 'click', function() {
        	var center;
        	if (typeof shape.getLatLng === 'function'){
        		center = shape.getLatLng();
            } else {
            	center = shape.getBounds().getCenter();
            }
    		if (console) console.log(center);
            self._map.setView(center);
            shape.openPopup();
            shape._popup.setLatLng(center);
        });
    }

});

