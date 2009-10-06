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

		/* Doesn't do anything. */
	}
}
