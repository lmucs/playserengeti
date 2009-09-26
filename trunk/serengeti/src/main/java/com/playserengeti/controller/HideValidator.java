/*
 * HideValidator. Validates parameters for Hide.
 */

package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class HideValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return HideCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		HideCommand c = HideCommand.class.cast(object);
		
		if (c.getUserID() == null) {
			errors.reject("error.missing.userID");
		}
		/* Should eventually validate that the userID is currently in the dB? */
	}
}
