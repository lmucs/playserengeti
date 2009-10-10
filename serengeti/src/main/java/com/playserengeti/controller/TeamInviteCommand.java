package com.playserengeti.controller;

import java.util.Collection;

import com.playserengeti.domain.User;

public class TeamInviteCommand {

	private Integer teamId;
	private Integer userId;
	private Collection<User> users;
	private Collection<User> invitees;
	
	
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	public Collection<User> getInvitees() {
		return invitees;
	}
	public void setInvitees(Collection<User> invitees) {
		this.invitees = invitees;
	}
	
	
	
}
