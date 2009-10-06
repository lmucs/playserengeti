package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TeamViewProfileValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return TeamViewProfileCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		TeamViewProfileCommand c = TeamViewProfileCommand.class.cast(object);
		
		/* Should eventually validate that the teamID is currently in the dB? 
		if (c.getTeamID() == null) {
			errors.reject("error.missing.userID");
		}
		*/
		
	}
}
