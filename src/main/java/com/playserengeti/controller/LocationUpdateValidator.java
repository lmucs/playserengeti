package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LocationUpdateValidator implements Validator {
	@Override
	public boolean supports(Class c) {
		return LocationUpdateCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		LocationUpdateCommand c = LocationUpdateCommand.class.cast(object);
		if (c.getLatitude() < -180 || c.getLatitude() > 180) {
			errors.rejectValue("latitude", "invalid.latitude", "latitudes must be between -180 and 180");
		}
		if (c.getLongitude() < -180 || c.getLongitude() > 180) {
			errors.rejectValue("longitude", "invalid.longitude", "longitudes must be between -180 and 180");
		}
	}
}
