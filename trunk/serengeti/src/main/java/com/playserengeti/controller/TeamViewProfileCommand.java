package com.playserengeti.controller;

/**
 * The commander for viewing a team's profile.
 * @author Chris
 *
 */
public class TeamViewProfileCommand {

	private Integer teamId;

	/**
	 * Returns the team's id.
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
}
