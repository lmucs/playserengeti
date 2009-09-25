/*
 * UserManageValidator. Validates parameters for UserManageCommand.
 */

package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserManageValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return UserManageCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		UserManageCommand c = UserManageCommand.class.cast(object);
		
		if (c.getUserID() == null) {
			errors.reject("error.missing.userID");
		}
		
		/* Should eventually validate that the userID is currently in the dB? */
	}
}
