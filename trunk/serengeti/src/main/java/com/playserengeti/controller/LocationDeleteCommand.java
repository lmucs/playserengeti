package com.playserengeti.controller;

public class LocationDeleteCommand {

    private String name;
    private int locationID;
    private double locationLongitude;
    private double locationLatitude;
    private int userOwnerID;
    private int teamOwnerID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocationID() {
        return locationID;
    }

    public int getUserOwnerID() {
        return userOwnerID;
    }

    public int getTeamOwnerID() {
        return teamOwnerID;
    }

	public double getLocationLongitude() {
		return locationLongitude;
	}
		
	public void setLocationLongitude(double locationLongitude) {
		this.locationLongitude = locationLongitude;
	}

	public double getLocationLatitude() {
		return locationLatitude;
	}
		
	public void setLocationLatitude(double LocationLatitude) {
		this.locationLatitude = locationLatitude;
	}

}
