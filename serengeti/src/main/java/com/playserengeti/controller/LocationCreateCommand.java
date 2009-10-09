package com.playserengeti.controller;

import com.playserengeti.domain.Team;

public class LocationCreateCommand {

    private String locationName;
    private int locationId;
    private double locationLongitude;
    private double locationLatitude;
    private Team teamOwnerId;

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLocationId() {
        return locationId;
    }

	public double getLongitude() {
		return locationLongitude;
	}

	public void setLongitude(double locationLongitude) {
		this.locationLongitude = locationLongitude;
	}

	public double getLatitude() {
		return locationLatitude;
	}

	public void setLatitude(double locationLatitude) {
		this.locationLatitude = locationLatitude;
	}

	public Team getTeamOwnerId() {
		return teamOwnerId;
	}

	public void setTeamOwnerId(Team teamOwnerId) {
		this.teamOwnerId = teamOwnerId;
	}

}
