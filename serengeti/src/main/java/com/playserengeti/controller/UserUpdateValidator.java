package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserUpdateValidator implements Validator {

    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class c) {
        return UserCommand.class.equals(c);
    }

    @Override
    public void validate(Object object, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "email.blank", "The email address can not be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "password.blank", "The password can not be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
                "firstName.blank", "Your first name can not be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
                "lastName.blank", "Your last name can not be blank");
    }
}
