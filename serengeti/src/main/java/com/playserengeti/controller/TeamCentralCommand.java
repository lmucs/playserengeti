package com.playserengeti.controller;

import java.util.Collection;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;

/**
 * The command object for the team central section.
 * @author Chris
 *
 */
public class TeamCentralCommand {
    
	private Integer userId;
	
	//Only needed until the user sign in is in place. Then it can reference the user's 
	//team attribute.
	private Collection<Team> userTeams;

	/**
	 * Returns the id of the current user.
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * Sets the userId.
	 * @param name
	 */
	public void setUser(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Returns the teams a user is a member of.  TEMPORARY
	 * @return
	 */
	public Collection<Team> getUserTeams() {
		return userTeams;
	}

	/**
	 * Sets the teams a user is a member of.  TEMPORARY
	 * @param userTeams
	 */
	public void setUserTeams(Collection<Team> userTeams) {
		this.userTeams = userTeams;
	}

}
