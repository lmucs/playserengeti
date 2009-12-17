package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for requests to create locations.
 */
public class LocationCreateValidator implements Validator {

    @SuppressWarnings("unchecked")
    @Override
    public boolean supports(Class c) {
        return LocationCommand.class.equals(c);
    }

    @Override
    public void validate(Object object, Errors errors) {
        LocationCommand c = LocationCommand.class.cast(object);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
                "name.blank", "The location name cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "latitude",
                "latitude.blank", "The latitude cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "longitude",
                "longitude.blank", "The longitude cannot be blank");
        if (c.getLatitude() < -180 || c.getLatitude() > 180) {
            errors.rejectValue("latitude", "invalid.latitude",
                    "latitudes must be between -180 and 180");
        }
        if (c.getLongitude() < -180 || c.getLongitude() > 180) {
            errors.rejectValue("longitude", "invalid.longitude",
                    "longitudes must be between -180 and 180");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street",
                "street.blank", "The street address cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city",
                "city.blank", "The city cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state",
                "state.blank", "The state cannot be blank");
    }
}
