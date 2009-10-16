package com.playserengeti.controller;

import java.util.Map;

/**
 * The command object for inviting users to teams.
 * @author Chris
 *
 */
public class TeamInviteCommand {

	private Integer teamId;
	private Integer userId;
	private Map<Integer, String> users;
	private Integer[] invitees;

	/**
	 * Gets the current team's id.
	 * @return
	 */
	public Integer getTeamId() {
		return teamId;
	}

	/**
	 * Sets the current team's id.
	 * @param teamId
	 */
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	/**
	 * Gets the current user's id.
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the current user's id.
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Gets the map of invite-able users.
	 * @return
	 */
	public Map<Integer, String> getUsers() {
		return users;
	}

	/**
	 * Sets the map of users available for invite.
	 * @param users
	 */
	public void setUsers(Map<Integer, String> users) {
		this.users = users;
	}

	/**
	 * Gets the array of selected users to invite to the team.
	 * @return
	 */
	public Integer[] getInvitees() {
		return invitees;
	}

	/**
	 * Sets the array of users to invite to the team.
	 * @param invitees
	 */
	public void setInvitees(Integer[] invitees) {
		this.invitees = invitees;
	}
}
