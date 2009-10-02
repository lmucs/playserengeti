package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserCreateValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return UserCreateCommand.class.equals(c);
	}

	@Override
	public void validate(Object _command, Errors errors) {
		UserCreateCommand command = (UserCreateCommand)_command;
		
		// TODO: Validation.
	}
}
