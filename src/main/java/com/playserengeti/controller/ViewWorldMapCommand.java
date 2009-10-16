/*
 * ViewWorldMapCommand. Contains the methods to get and set ViewWorldMap parameters (ie, userID)
 */

package com.playserengeti.controller;

public class ViewWorldMapCommand {
	
	private double currentLat;
	private double currentLong;
	
	private String userID;

    public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
    public double getCurrentLat() {
		return currentLat;
	}

	public void setCurrentLat(double currentLat) {
		this.currentLat = currentLat;
	}
	
    public double getCurrentLong() {
		return currentLong;
	}

	public void setCurrentLong(double currentLong) {
		this.currentLong = currentLong;
	}
	
}
