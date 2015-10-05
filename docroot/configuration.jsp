<%@ include file="/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<aui:fieldset>
            <liferay-ui:error key="centerLongtitude" message="please-enter-a-valid-latitude" />
            <aui:input cssClass="lfr-input-text-container" label="center-latitude" name="preferences--centerLatitude--" value="<%= centerLatitude %>" >
                <aui:validator name="number"></aui:validator>
                <aui:validator name="required"/>
                <aui:validator name="maxLength">11</aui:validator>
            </aui:input>

			<liferay-ui:error key="centerLongtitude" message="please-enter-a-valid-longtitude" />
			<aui:input cssClass="lfr-input-text-container" label="center-longtitude" name="preferences--centerLongtitude--" value="<%= centerLongtitude %>" >
				<aui:validator name="number"></aui:validator>
				<aui:validator name="required"/>
				<aui:validator name="maxLength">11</aui:validator>
			</aui:input>

			<liferay-ui:error key="centerLongtitude" message="please-enter-a-valid-zoom-level" />
			<aui:input cssClass="lfr-input-text-container" label="zoom-level" name="preferences--zoomLevel--" value="<%= zoomLevel %>" >
				<aui:validator name="digits"></aui:validator>
				<aui:validator name="required"/>
				<aui:validator name="min">1</aui:validator>
				<aui:validator name="max">18</aui:validator>
			</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>