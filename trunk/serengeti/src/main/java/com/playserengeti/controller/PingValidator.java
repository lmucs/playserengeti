/*
 * PingValidator. Validates parameters for Ping.
 */

package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PingValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return PingCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		PingCommand c = PingCommand.class.cast(object);
		
		if (c.getUserID() == null) {
			errors.reject("error.missing.userID");
		}
		/* Should eventually validate that the locationID is currently in the dB? */
	}
}
