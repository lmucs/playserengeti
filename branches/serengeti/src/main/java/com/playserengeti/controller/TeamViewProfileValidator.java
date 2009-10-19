package com.playserengeti.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * The validator for viewing a team's profile.
 * @author Chris
 *
 */
public class TeamViewProfileValidator implements Validator {

	@Override
	public boolean supports(Class c) {
		return TeamCommand.class.equals(c);
	}

	@Override
	public void validate(Object object, Errors errors) {
		TeamCommand c = TeamCommand.class.cast(object);
		
		/* Should eventually validate that the teamID is currently in the dB? 
		if (c.getTeamId() == null) {
			errors.reject("error.missing.teamId");
		}
		*/
		
	}
}
