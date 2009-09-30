package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserCreateValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return UserCreateCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		UserCreateCommand c = UserCreateCommand.class.cast(object);
		
		/* Doesn't do anything. */
	}
}
