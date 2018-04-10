package org.politaktiv.map;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Set;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class TileServerHelper {
	
	/* Hardcoded defaults as fallback */
	private ServerEntry fallbackEntry = new ServerEntry(
			"http://{s}.tile.osm.org/{z}/{x}/{y}.png", 
			"Map data &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors",
			"OSM Standard Tile Layer");	

	
	private static String tileConfig = "tileservers.properties";
	
	private HashMap<String, ServerEntry> entries;
	private Log _log = LogFactoryUtil.getLog(TileServerHelper.class);
		
	private static TileServerHelper _instance = null;
	
	
	public class ServerEntry {
		public ServerEntry(String url, String credits, String displayName) {
			super();
			this.url = url;
			this.credits = credits;
			this.displayName = displayName;
		}
		public String getUrl() {
			return url;
		}
		public String getCredits() {
			return credits;
		}
		public String getDisplayName() {
			return displayName;
		}
		String url;
		String credits;
		String displayName;
		
		public String toString() {
			return "url: " + this.url + ", credits: " + this.credits + ", displayName: " + this.displayName;
		}
		
	}
	
	public static TileServerHelper getInstance() {
		if ( _instance == null) {
			_instance = new TileServerHelper();
		}
		
		return _instance;
	}
	
	private TileServerHelper() {
		entries = new HashMap<String, TileServerHelper.ServerEntry>();
		
		try {
			readConfig();
			
			
		} catch (IOException e) {
			_log.error("Cannot load data from " + tileConfig + ", using hardcoded default OSM tile server.");
			_log.error(e);
			
			entries.put("default", fallbackEntry);
		}
		
	}
	
	private void readConfig() throws IOException {
		Properties prop = new Properties();
		prop.load(TileServerHelper.class.getClassLoader().getResourceAsStream(tileConfig));
		
		// if we got here, we do have properties, so work with them
		
		
		// first, collect key prefixes
		HashSet<String> prefixes = new HashSet<String>();
		for (Object keyO : prop.keySet() ) {
			String key = (String)keyO;
			String[] parts = key.split("\\.");
			if (parts.length != 2 || parts[0].trim() == "" ) {
				_log.error("Strange property '" + key + "' in "+  tileConfig + ", ignoring");
				continue;
			}
			prefixes.add(parts[0]);
		}
		
		// collect data structures from properties
		for (String pref : prefixes ) {
			String url = prop.getProperty(pref + ".url");
			String credits = prop.getProperty(pref + ".credits");
			String display = prop.getProperty(pref + ".displayname");
			
			if ( url == null || credits == null || display == null) {
				_log.error("Entry for '" + pref + "' in "+  tileConfig + " is incomplete, ignoring");
				continue;
			}
			
			entries.put(pref, new ServerEntry(url, credits, display));
			
		}
		
		//_log.error(entries);

		
		
	}
	
	public Set<String> keySet() {
		return entries.keySet();
	}
	
	public String getDefaultKey() {
		if (entries.containsKey("default")) {
			return "default";
		} else {
			// take first one in alphabet
			LinkedList<String> list = new LinkedList<String>();
			list.addAll(entries.keySet());
			Collections.sort(list);
			return list.getFirst();
		}		
	}
	
	public ServerEntry getDefaultEntry() {
		return entries.get(getDefaultKey());
	}
	
	
	public ServerEntry getEntry(String key) {
		return entries.get(key);
	}
	
	
	

}
