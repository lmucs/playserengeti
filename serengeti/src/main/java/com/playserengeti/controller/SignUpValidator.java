package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SignUpValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return SignUpCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		SignUpCommand c = SignUpCommand.class.cast(object);
		
		/* Doesn't do anything. */
	}
}
