package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LocationDeleteValidator implements Validator {
	@Override
	public boolean supports(Class c) {
		return LocationDeleteCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		LocationDeleteCommand c = LocationDeleteCommand.class.cast(object);

		/* Doesn't do anything. */
	}
}
