package com.playserengeti.controller;

import com.playserengeti.domain.Location;
import com.playserengeti.domain.Team;

public class LocationCreateCommand {

    private String locationName;
    private int locationId;
    private double longitude;
    private double latitude;
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
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Team getTeamOwnerId() {
		return teamOwnerId;
	}

	public void setTeamOwnerId(Team teamOwnerId) {
		this.teamOwnerId = teamOwnerId;
	}

}
