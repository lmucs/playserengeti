package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserCreateValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return UserCommand.class.equals(c);
	}

	@Override
	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", 
				"login.blank", "The email address can not be blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", 
				"display.blank", "The display name can not be blank");

	}
}
