package com.playserengeti.controller;

import java.util.Collection;

import com.playserengeti.domain.Location;
import com.playserengeti.domain.User;

/**
 * The commander for creating a new team.
 * @author Chris
 *
 */
public class TeamCreateCommand {

	private String name;
	private Integer teamId;
	private Integer userId;
	private String color;
	private String image;
	private Integer homeLocation;
	private Collection<User> allUsers;
	private Collection<Location> allLocations;
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
	 * Returns the user ID of the team's leader.
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * Sets the leader of the team.
	 * @param leaderID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Integer getHomeLocation() {
		return homeLocation;
	}
	
	/**
	 * Sets the team's home location to that specified by the given location ID.
	 * @param homeLocation
	 */
	public void setHomeLocation(Integer homeLocation) {
		this.homeLocation = homeLocation;
	}

	public Collection<User> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(Collection<User> allUsers) {
		this.allUsers = allUsers;
	}

	public Collection<Location> getAllLocations() {
		return allLocations;
	}

	public void setAllLocations(Collection<Location> allLocations) {
		this.allLocations = allLocations;
	}
	
	
}