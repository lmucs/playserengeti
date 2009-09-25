package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TeamUpdateValidator implements Validator {
	@Override
	public boolean supports(Class c) {
		return TeamUpdateCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		TeamUpdateCommand c = TeamUpdateCommand.class.cast(object);

		/* Doesn't do anything. */
	}
}
