package org.politaktiv.map;

public final class Constants {

	private Constants() {
	}
	
	public static final String DEFAULT_CENTER_LONGTITUDE = "9.0777437";
	public static final String DEFAULT_CENTER_LATITUDE = "48.5222366";
	public static final String DEFAULT_ZOOM_LEVEL = "10";
	public static final String DEFAULT_SHAPES_LAYER = "Main";
	public static final String DEFAULT_OVERLAY_HACK = "";
	public static final String DEFAULT_TILE_SERVER_KEY = TileServerHelper.getInstance().getDefaultKey();
	
    public static final String DEFAULT_MAX_ZOOM_LEVEL = "18";
    public static final String DEFAULT_MIN_ZOOM_LEVEL = "1";
	

	public static final String CENTER_LONGTITUDE = "centerLongtitude";
	public static final String CENTER_LATITUDE = "centerLatitude";
	public static final String ZOOM_LEVEL = "zoomLevel";
    public static final String SHAPES_LAYER = "shapesLayer";
    public static final String OVERLAY_HACK = "overlayHack";
    public static final String TILE_SERVER_KEY = "tileServerKey";
    
    public static final String MAX_ZOOM_LEVEL = "maxZoomLevel";
    public static final String MIN_ZOOM_LEVEL = "minZoomLevel";
    
}
