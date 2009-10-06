package com.playserengeti.controller;

import java.awt.Image;

public class TeamUpdateCommand {
	private String name;
	private int teamID;
	private int leaderID;
	private String color;
	private Image image;
	private int homeLocation;	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTeamID() {
		return teamID;
	}
	
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	
	public int getLeaderID() {
		return leaderID;
	}
	
	public void setLeaderID(int leaderID) {
		this.leaderID = leaderID;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public int getHomeLocation() {
		return homeLocation;
	}
	
	public void setHomeLocation(int homeLocation) {
		this.homeLocation = homeLocation;
	}

	
}
