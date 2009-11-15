package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserUpdateValidator implements Validator {

    @Override
    public boolean supports(Class c) {
        return UserCommand.class.equals(c);
    }

    @Override
    public void validate(Object object, Errors errors) {
        UserCommand c = UserCommand.class.cast(object);
    }
}
