/*
 * PingCommand. Contains the methods to get and set Ping parameters (ie, latitude, longitude, location)
 */

package com.playserengeti.controller;

public class PingCommand {

	private double lat;
	private double lon;
	
	private String userID;

    public double getLat() {
		return lat;
	}

	public void setLet(double lat) {
		this.lat = lat;
	}
    public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

    public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
