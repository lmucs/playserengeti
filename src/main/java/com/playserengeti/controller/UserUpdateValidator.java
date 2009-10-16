/*
 * UserUpdateValidator. Validates parameters for UserUpdateCommand.
 */

package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserUpdateValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return UserUpdateCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		UserUpdateCommand c = UserUpdateCommand.class.cast(object);

		/* Should eventually validate that the userID is currently in the dB? 
		if (c.getUserID() == null) {
			errors.reject("error.missing.userID");
		}
		*/

	}
}
