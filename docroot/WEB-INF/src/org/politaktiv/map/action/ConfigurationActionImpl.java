/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.politaktiv.map.action;

import static org.politaktiv.map.Constants.CENTER_LATITUDE;
import static org.politaktiv.map.Constants.CENTER_LONGTITUDE;
import static org.politaktiv.map.Constants.ZOOM_LEVEL;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.politaktiv.map.MapValidator;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (Validator.isNotNull(cmd)) {
			validateMapPreferences(actionRequest);
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	protected void validateMapPreferences(ActionRequest actionRequest) throws Exception {

		String centerLongtitude = getParameter(actionRequest, CENTER_LONGTITUDE);
		String centerLatitude = getParameter(actionRequest, CENTER_LATITUDE);
		String zoomLevel = getParameter(actionRequest, ZOOM_LEVEL);

		if (MapValidator.isNotValidCoordinate(centerLongtitude)) {

			SessionErrors.add(actionRequest, CENTER_LONGTITUDE);

		} else if (MapValidator.isNotValidCoordinate(centerLatitude)) {

			SessionErrors.add(actionRequest, CENTER_LATITUDE);

		} else if (Validator.isNull(zoomLevel) || !Validator.isNumber(zoomLevel) || Integer.parseInt(zoomLevel) > 18) {

			SessionErrors.add(actionRequest, ZOOM_LEVEL);
		}
	}

}