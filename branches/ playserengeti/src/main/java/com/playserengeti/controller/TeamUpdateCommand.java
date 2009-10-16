package com.playserengeti.controller;

import java.util.Collection;
import java.util.Map;

import com.playserengeti.domain.User;


/**
 * Command for updating/modifying a team.
 * @author Chris
 *
 */
public class TeamUpdateCommand {
	private Integer userId;
	private String name;
	private Integer teamId;
	private Integer leaderId;
	private String color;
	private String image;
	//TODO re-design to use Map<Integer, String>
	private Map<Integer, String> teamUsers;
	//private Collection<User> teamUsers;


	/**
	 * Returns the name of the team.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the team.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the team's ID.
	 * @return
	 */
	public Integer getTeamId() {
		return teamId;
	}

	/**
	 * Sets the team's id.
	 * @param teamId
	 */
	public void setTeamId(Integer teamId) {
	    this.teamId = teamId;
	}

	/**
	 * Returns the user ID of the team's leader.
	 * @return
	 */
	public Integer getLeaderId() {
		return leaderId;
	}

	/**
	 * Sets the leader of the team.
	 * @param leaderID
	 */
	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}

	/**
	 * Returns the team's preferred color.
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the team's preferred color.
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Returns the url of the team's image.
	 * @return
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the url of the team's image.
	 * @param image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	/**
	 * Gets the users on the current team.
	 * @return
	 */
	public Map<Integer, String> getTeamUsers() {
		return teamUsers;
	}

	/**
	 * Sets the users on the current team.
	 * @param teamUsers
	 */
	public void setTeamUsers(Map<Integer, String> teamUsers) {
		this.teamUsers = teamUsers;
	}

	/**
	 * Gets the current user's id.
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}

	/*
	 * Sets the current user's id.
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}



}
