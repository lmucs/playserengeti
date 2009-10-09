package com.playserengeti.domain;

public class Location {

    private Integer locationId;
    private String locationName;
    private double longitude;
    private double latitude;
    private Team teamOwnerId;

    public Location(Integer locationId, String locationName, double longitude, double latitude, Team teamOwner) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(Location b) {
    	this(b.locationId, b.locationName, b.longitude, b.latitude, b.teamOwnerId);
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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

    // TODO: equals, hashCode, toString

}
