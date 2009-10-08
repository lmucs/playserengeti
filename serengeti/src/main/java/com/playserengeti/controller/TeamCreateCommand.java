package com.playserengeti.controller;

/**
 * The commander for creating a new team.
 * @author Chris
 *
 */
public class TeamCreateCommand {

	private String name;
	private int teamId;
	private String leaderId;
	private String color;
	private String image;
	private String homeLocation;
	
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
	public int getTeamId() {
		return teamId;
	}
	
	/**
	 * Returns the user ID of the team's leader.
	 * @return
	 */
	public String getLeaderId() {
		return leaderId;
	}
	
	/**
	 * Sets the leader of the team.
	 * @param leaderID
	 */
	public void setLeaderId(String leaderId) {
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
	 * Returns the location ID of the team's home location.
	 * @return
	 */
	public String getHomeLocation() {
		return homeLocation;
	}
	
	/**
	 * Sets the team's home location to that specified by the given location ID.
	 * @param homeLocation
	 */
	public void setHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
	}
	
}
