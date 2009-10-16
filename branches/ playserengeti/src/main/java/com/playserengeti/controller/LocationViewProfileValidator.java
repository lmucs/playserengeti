package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * The validator for viewing a team's profile.
 *
 */
public class LocationViewProfileValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return LocationViewProfileCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		LocationViewProfileCommand c = LocationViewProfileCommand.class.cast(object);

	}
}
