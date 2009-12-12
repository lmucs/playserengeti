package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for user creation requests.
 */
public class UserCreateValidator implements Validator {

    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class c) {
        return UserCommand.class.equals(c);
    }

    @Override
    public void validate(Object command, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "email.blank", "The email address can not be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "password.blank", "The password can not be blank");
    }
}
