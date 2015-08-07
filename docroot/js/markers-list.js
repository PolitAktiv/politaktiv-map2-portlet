
L.Control.MarkersList = L.Control.extend({
/*
  statics: {
    Storage: Storage,
    FormPopup: FormPopup
  },*/

    options: {
        containerClass: 'leaflet-control-layers leaflet-control leaflet-markers-list'/*,
        expandedClass: 'expanded',
        headerClass: 'bookmarks-header'*/
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

        var fixed = this.options.fixedLayers.getLayers();
        var editable = this.options.editableLayers.getLayers();

        var item;

        for (var i=0, len=editable.length; i<len; i++) {
            this.addItem(editable[i]);
        }

        var hr = L.DomUtil.create('hr');
        this._list.appendChild(hr);

        for (var i=0, len=fixed.length; i<len; i++) {
            this.addItem(fixed[i]);
        }
    },

    addItem: function(marker) {
        var self = this;

        item = L.DomUtil.create('div', 'list-item-own');
        item.innerHTML = marker.options.markerData.title;
        this._list.appendChild(item);

        L.DomEvent.on(item, 'click', function() {
            if (console) console.log(marker.getLatLng());
            self._map.setView(marker.getLatLng()/*, bookmark.zoom*/);
            marker.openPopup();
        });
    }

});

