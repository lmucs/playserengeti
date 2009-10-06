package com.playserengeti.controller;

public class LocationCreateCommand {

    private String locationName;
    private int locationId;
    private double locationLongitude;
    private double locationLatitude;
    private int userOwnerId;
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

    public int getUserOwnerId() {
        return userOwnerId;
    }

    public int getTeamOwnerId() {
        return teamOwnerId;
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

}
