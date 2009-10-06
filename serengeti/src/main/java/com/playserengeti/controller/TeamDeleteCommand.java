package com.playserengeti.controller;


/**
 * The commander for deleting teams.
 * @author Chris
 *
 */
public class TeamDeleteCommand {

	private String name;
	private int teamId;
	private int leaderId;
	private String color;
	private String image;
	private int homeLocation;
	
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
	public int getLeaderId() {
		return leaderId;
	}
	
	/**
	 * Sets the leader of the team.
	 * @param leaderID
	 */
	public void setLeaderId(int leaderId) {
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
	public int getHomeLocation() {
		return homeLocation;
	}
	
	/**
	 * Sets the team's home location to that specified by the given location ID.
	 * @param homeLocation
	 */
	public void setHomeLocation(int homeLocation) {
		this.homeLocation = homeLocation;
	}
	
}
