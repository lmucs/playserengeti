package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * The validator for deleting teams.
 * @author Chris
 *
 */
public class TeamDeleteValidator implements Validator {
	@Override
	public boolean supports(Class c) {
		return TeamDeleteCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		TeamDeleteCommand c = TeamDeleteCommand.class.cast(object);

		/* Doesn't do anything. */
	}
}
