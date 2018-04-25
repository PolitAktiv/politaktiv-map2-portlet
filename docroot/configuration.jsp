<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.Set"%>
<%@ include file="/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<div class="row-fluid" id="<portlet:namespace />configMapForm">
	<div class="span3">
		<aui:form action="<%= configurationURL %>" method="post" name="fm">
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
			<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		
				<aui:fieldset>
					<liferay-ui:error key="centerLatitude" message="please-enter-a-valid-latitude" />
					<aui:input cssClass="map-center-latitude" label="center-latitude" name="preferences--centerLatitude--" value="<%= centerLatitude %>" >
						<aui:validator name="number"></aui:validator>
						<aui:validator name="required"/>
						<aui:validator name="maxLength">11</aui:validator>
					</aui:input>
		
					<liferay-ui:error key="centerLongtitude" message="please-enter-a-valid-longtitude" />
					<aui:input cssClass="map-center-longtitude" label="center-longtitude" name="preferences--centerLongtitude--" value="<%= centerLongtitude %>" >
						<aui:validator name="number"></aui:validator>
						<aui:validator name="required"/>
						<aui:validator name="maxLength">11</aui:validator>
					</aui:input>
		
					<liferay-ui:error key="zoomLevel" message="please-enter-a-valid-zoom-level" />
					<aui:input cssClass="map-zoom-level" label="zoom-level" name="preferences--zoomLevel--" value="<%= zoomLevel %>" >
						<aui:validator name="digits"></aui:validator>
						<aui:validator name="required"/>
						<aui:validator name="min">1</aui:validator>
						<aui:validator name="max">18</aui:validator>
					</aui:input>
					
					<liferay-ui:error key="minZoomLevel"  />
					<aui:input cssClass="map-zoom-level" label="Kleinstes mögliches Zoom-Level" name="preferences--minZoomLevel--" value="<%= minZoomLevel %>" >
						<aui:validator name="digits"></aui:validator>
						<aui:validator name="required"/>
						<aui:validator name="min">1</aui:validator>
						<aui:validator name="max">18</aui:validator>
					</aui:input>

					<liferay-ui:error key="maxZoomLevel"  />
					<aui:input cssClass="map-zoom-level" label="Größtes mögliches Zoom-Level" name="preferences--maxZoomLevel--" value="<%= maxZoomLevel %>" >
						<aui:validator name="digits"></aui:validator>
						<aui:validator name="required"/>
						<aui:validator name="min">1</aui:validator>
						<aui:validator name="max">18</aui:validator>
					</aui:input>
					
					
					
                    <aui:input label="shapes-layer" name="preferences--shapesLayer--" value="<%=shapesLayer%>"></aui:input>
				</aui:fieldset>
				
			<aui:select name="preferences--tileServerKey--" label="Stil der Basiskarte / Kartenserver">
			<%
				TileServerHelper tileHelper = TileServerHelper.getInstance();
				for (String key : tileHelper.keySet() ) {
			%>
    			<aui:option value="<%= key %>" selected="<%= tileServerKey.equals(key) %>"><%= tileHelper.getEntry(key).getDisplayName()  %></aui:option>
    		<%
				}
    		%>	
			</aui:select>				
				
				
		<aui:input type="textarea"
			name="preferences--overlayHack--"
			label="Overlay Hack" value="<%=overlayHack%>"
			width="800" ></aui:input>				
				
		
			<aui:button-row>
				<aui:button type="submit" />
			</aui:button-row>
		</aui:form>
	</div>
	
	<div class="span9">
		<div class="config-map"></div>
	</div>

</div>


<aui:script use="aui-base">
	initMapConfig({
		wrapperId: '<portlet:namespace />configMapForm',
		center: { lat:<%= centerLatitude %>, lng:<%= centerLongtitude %> },
		zoomLevel: <%= zoomLevel %>,
        tileServer: '<%= HtmlUtil.escapeJS(tileServer.getUrl()) %>',
        tileCredits: '<%= HtmlUtil.escapeJS(tileServer.getCredits()) %>',	});

	function initMapConfig(prop) {
		var wrap = L.DomUtil.get(prop.wrapperId);
		var configMap = L.map(wrap.querySelector('.config-map'));
		var center = L.marker([prop.center.lat, prop.center.lng]);
		var latInput = wrap.querySelector('.map-center-latitude');
		var lngInput = wrap.querySelector('.map-center-longtitude');

		L.tileLayer(prop.tileServer, {
                attribution: prop.tileCredits
					}).addTo(configMap);
		configMap.setView([prop.center.lat, prop.center.lng], prop.zoomLevel);
		configMap.addLayer(center);

		configMap.on('click', function(e) {
			latInput.value = e.latlng.lat.toString().substr(0,10);
			lngInput.value = e.latlng.lng.toString().substr(0,10);
			center.setLatLng(e.latlng);
		});
		L.DomEvent.on(latInput, 'change', function() {
			center.setLatLng([latInput.value, lngInput.value]);
		});
		L.DomEvent.on(lngInput, 'change', function() {
			center.setLatLng([latInput.value, lngInput.value]);
		});
	}
</aui:script>


