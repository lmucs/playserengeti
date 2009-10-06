package com.playserengeti.domain;

public class Location {

    private Integer locationId;
    private String locationName;
    private double longitude;
    private double latitude;
    private int teamOwner;

    public Location(Integer locationId, String locationName, double longitude, double latitude, int teamOwner) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(Location b) {
    	this(b.locationId, b.locationName, b.longitude, b.latitude, b.teamOwner);
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

	public int getTeamOwner() {
		return teamOwner;
	}

	public void setTeamOwner(int teamOwner) {
		this.teamOwner = teamOwner;
	}

    // TODO: equals, hashCode, toString

}
