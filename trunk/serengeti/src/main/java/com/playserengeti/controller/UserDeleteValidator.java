/*
 * UserDeleteValidator. Validates parameters for UserDeleteCommand.
 */

package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDeleteValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return UserDeleteCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		UserDeleteCommand c = UserDeleteCommand.class.cast(object);
		
		if (c.getUserID() == null) {
			errors.reject("error.missing.userID");
		}
		
		/* Should eventually validate that the userID is currently in the dB? */
	}
}
