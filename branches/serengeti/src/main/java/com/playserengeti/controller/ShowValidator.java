/*
 * ShowValidator. Validates parameters for Show.
 */

package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ShowValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return ShowCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ShowCommand c = ShowCommand.class.cast(object);

		/* Should eventually validate that the userID is currently in the dB?
		if (c.getUserID() == null) {
			errors.reject("error.missing.userID");
		}
		*/
	}
}
