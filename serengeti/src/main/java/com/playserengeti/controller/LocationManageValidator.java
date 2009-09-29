package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LocationManageValidator implements Validator {
	@Override
	public boolean supports(Class c) {
		return LocationManageCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		LocationManageCommand c = LocationManageCommand.class.cast(object);

		/* Doesn't do anything. */
	}
}
