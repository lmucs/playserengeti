package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserCreateValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return UserCreateCommand.class.equals(c);
	}

	@Override
	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", 
				"login.blank", "The login name can not be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "display", 
				"display.blank", "The display name can not be blank");
	}
}
