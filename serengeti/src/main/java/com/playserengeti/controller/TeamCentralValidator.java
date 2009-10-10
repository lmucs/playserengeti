package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TeamCentralValidator implements Validator{

	@Override
	public boolean supports(Class c) {
		return TeamCentralCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		TeamCentralCommand c = TeamCentralCommand.class.cast(object);

		/* Doesn't do anything. */
	}
}

