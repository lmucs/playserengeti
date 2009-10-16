package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VisitCreateValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return VisitCreateCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		VisitCreateCommand c = VisitCreateCommand.class.cast(object);
		    //TODO - fix stub so it ensures userId and locationId are in dB

	}
}
