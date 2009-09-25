package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TeamCreateValidator implements Validator {
	
	@Override
	public boolean supports(Class c) {
		return TeamCreateCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		TeamCreateCommand c = TeamCreateCommand.class.cast(object);

		/* Doesn't do anything. */
	}
}
