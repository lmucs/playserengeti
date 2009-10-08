package com.playserengeti.controller;

public class LocationDeleteCommand {

    private String locationName;
    private int locationId;
    private double locationLongitude;
    private double locationLatitude;
    private int teamOwnerId;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId){
    	this.locationId = locationId;
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

	public void setLocationLatitude(double locationLatitude) {
		this.locationLatitude = locationLatitude;
	}

    public int getTeamOwnerId() {
        return teamOwnerId;
    }

    public void setTeamOwnerId(Integer teamOwnerId) {
        this.teamOwnerId = teamOwnerId;
    }
}
