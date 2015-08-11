
L.Control.MarkersList = L.Control.extend({

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

        var editable = this.options.editableLayers.getLayers();
        var fixed = this.options.fixedLayers.getLayers();

        if (editable.length) {
            var listHeader = L.DomUtil.create('div', this.options.headerClass);
            listHeader.innerHTML = this.options.translations.yourMarkers;
            this._list.appendChild(listHeader);
    
            for (var i=0, len=editable.length; i<len; i++) {
                this.addItem(editable[i]);
            }
        }

        if (editable.length && fixed.length) {
            var hr = L.DomUtil.create('hr');
            this._list.appendChild(hr);
        }

        if (fixed.length) {
            var list2Header = L.DomUtil.create('div', this.options.headerClass);
            list2Header.innerHTML = this.options.translations.allMarkers;
            this._list.appendChild(list2Header);
    
            for (var i=0, len=fixed.length; i<len; i++) {
                this.addItem(fixed[i]);
            }
        }
    },

    addItem: function(marker) {
        var self = this;
        var item;

        item = L.DomUtil.create('div', this.options.listItemClass);
        item.innerHTML = marker.options.markerData.title;
        this._list.appendChild(item);

        L.DomEvent.on(item, 'click', function() {
            if (console) console.log(marker.getLatLng());
            self._map.setView(marker.getLatLng());
            marker.openPopup();
        });
    }

});

