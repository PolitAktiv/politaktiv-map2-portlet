package org.politaktiv.map;

// review mje 12.08.: buildpath is not working in eclipse - we have to fix this as soon as default vm is available ...
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

public final class MapValidator {

	private MapValidator() {
	}

	// review mje 12.08.: why static?
	public static boolean isNotValidCoordinate(final String coordinate) {
		String replacedCoordinate = StringUtil.replaceFirst(coordinate, new String[] {".", "-", "+"}, new String[] {"", "", ""});
		
		return Validator.isNull(coordinate)
				|| !Validator.isNumber(replacedCoordinate)
				|| coordinate.length() > 11;
	}
}
