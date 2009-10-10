package com.playserengeti.controller;

import java.util.Collection;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;


public class TeamCentralCommand {
    
	private User user;
	
	//Only needed until the user sign in is in place. Then it can reference the user's 
	//team attribute.
	private Collection<Team> userTeams;

	/**
	 * Returns the id of the current user.
	 * @return
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * Sets the userId.
	 * @param name
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Team> getUserTeams() {
		return userTeams;
	}

	public void setUserTeams(Collection<Team> userTeams) {
		this.userTeams = userTeams;
	}

}
