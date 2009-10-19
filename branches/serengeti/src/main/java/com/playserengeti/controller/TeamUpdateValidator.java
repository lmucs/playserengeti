package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * The validator for updating/modifying teams.
 * @author Chris
 *
 */
public class TeamUpdateValidator implements Validator {
	@Override
	public boolean supports(Class c) {
		return TeamCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		TeamCommand c = TeamCommand.class.cast(object);

		/* Doesn't do anything. */
	}
}
