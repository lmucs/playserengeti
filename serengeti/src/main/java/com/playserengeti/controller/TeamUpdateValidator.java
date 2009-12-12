package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validator for updating/modifying teams.
 */
public class TeamUpdateValidator implements Validator {

    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class c) {
        return TeamCommand.class.equals(c);
    }

    @Override
    public void validate(Object object, Errors errors) {

        // TODO
    }
}
