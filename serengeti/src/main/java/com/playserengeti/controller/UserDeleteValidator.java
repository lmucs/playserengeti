/*
 * UserDeleteValidator. Validates parameters for UserDeleteCommand.
 */

package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserDeleteValidator implements Validator {

    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class c) {
        return UserCommand.class.equals(c);
    }

    @Override
    public void validate(Object object, Errors errors) {

    }
}
