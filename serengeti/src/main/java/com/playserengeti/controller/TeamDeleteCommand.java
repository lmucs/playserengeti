package com.playserengeti.controller;


/**
 * The commander for deleting teams.
 * @author Chris
 *
 */
public class TeamDeleteCommand {

	private String name;
	private Integer teamId;
	
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
	 * Sets the team's ID.
	 * @param teamId
	 */
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
}
