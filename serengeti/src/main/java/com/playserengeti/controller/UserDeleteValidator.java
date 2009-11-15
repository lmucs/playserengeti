/*
 * UserDeleteValidator. Validates parameters for UserDeleteCommand.
 */

package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDeleteValidator implements Validator {

    @Override
    public boolean supports(Class c) {
        return UserCommand.class.equals(c);
    }

    @Override
    public void validate(Object object, Errors errors) {
        UserCommand c = UserCommand.class.cast(object);

        /*
         * Should eventually validate that the userID is currently in the dB? if
         * (c.getUserID() == null) { errors.reject("error.invalid.userID"); }
         */

    }
}
