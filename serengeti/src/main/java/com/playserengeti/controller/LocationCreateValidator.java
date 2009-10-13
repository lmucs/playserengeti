package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LocationCreateValidator implements Validator {
	@Override
	public boolean supports(Class c) {
		return LocationCreateCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		LocationCreateCommand c = LocationCreateCommand.class.cast(object);

		if (c.getLatitude() < -180 || c.getLatitude() > 180) {
			errors.reject("error.invalid.Latitude");
		}
		if (c.getLongitude() < -180 || c.getLongitude() > 180) {
			errors.reject("error.invalid.Longitude");
		}
	}
}
