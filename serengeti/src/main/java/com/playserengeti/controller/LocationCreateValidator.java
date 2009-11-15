package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LocationCreateValidator implements Validator {
    @Override
    public boolean supports(Class c) {
        return LocationCommand.class.equals(c);
    }

    @Override
    public void validate(Object object, Errors errors) {
        LocationCommand c = LocationCommand.class.cast(object);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locationName",
                "locationName.blank", "The location name can not be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "latitude",
                "latitude.blank", "The latitude can not be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "longitude",
                "longitude.blank", "The longitude can not be blank");
        if (c.getLatitude() < -90 || c.getLatitude() > 90) {
            errors.rejectValue("latitude", "invalid.latitude",
                    "latitudes must be between -180 and 180");
        }
        if (c.getLongitude() < -180 || c.getLongitude() > 180) {
            errors.rejectValue("longitude", "invalid.longitude",
                    "longitudes must be between -180 and 180");
        }
    }
}
