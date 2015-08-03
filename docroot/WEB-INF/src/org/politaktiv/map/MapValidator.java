package org.politaktiv.map;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

public final class MapValidator {

	private MapValidator() {
	}

	public static boolean isNotValidCoordinate(final String coordinate) {
		String replacedCoordinate = StringUtil.replaceFirst(coordinate, new String[] {".", "-", "+"}, new String[] {"", "", ""});
		
		return Validator.isNull(coordinate)
				|| !Validator.isNumber(replacedCoordinate)
				|| coordinate.length() > 11;
	}
}
