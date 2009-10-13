package com.playserengeti.controller;

import java.util.Map;

public class TeamInviteCommand {

	private Integer teamId;
	private Integer userId;
	private Map<Integer, String> users;
	private Integer[] invitees;
	
	
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
	public Map<Integer, String> getUsers() {
		return users;
	}
	public void setUsers(Map<Integer, String> users) {
		this.users = users;
	}
	public Integer[] getInvitees() {
		return invitees;
	}
	public void setInvitees(Integer[] invitees) {
		this.invitees = invitees;
	}
}
