/*
 * ViewWorldMapValidator. Validates parameters for ViewWorldMap.
 * If the lat and long are blank, they should be retrieved from the userIDs current
 * location.
 */

package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ViewWorldMapValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return ViewWorldMapCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ViewWorldMapCommand c = ViewWorldMapCommand.class.cast(object);
		
		/* Should eventually validate that the userID is currently in the dB? */
		if (c.getUserID() == null) {
			errors.reject("error.missing.userID");
		}
		
	}
}
