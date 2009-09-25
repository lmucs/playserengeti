/*
 * UserViewProfileValidator. Validates parameters for UserViewProfileCommand.
 */

package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserViewProfileValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return UserViewProfileCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		UserViewProfileCommand c = UserViewProfileCommand.class.cast(object);
		
		if (c.getUserID() == null) {
			errors.reject("error.missing.userID");
		}
		
		/* Should eventually validate that the userID is currently in the dB? */
	}
}
