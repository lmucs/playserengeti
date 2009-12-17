package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for team creation requests.
 */
public class TeamCreateValidator implements Validator {

    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class c) {
        return TeamCommand.class.equals(c);
    }

    @Override
    public void validate(Object object, Errors errors) {
        TeamCommand c = TeamCommand.class.cast(object);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "name.blank", "The team name can not be blank");
    }
}
