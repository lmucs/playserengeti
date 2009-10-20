package com.playserengeti.domain;

public class Location {

    private Integer locationId;
    private String locationName;
    private double longitude;
    private double latitude;
    private Team teamOwner;
    private String description;
    private String email;
    private String phoneNumber;
    private String hours;
    private String image;

    public Location(Integer locationId, String locationName, double longitude, double latitude) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(String locationName, double latitude, double longitude){
    	this.locationName = locationName;
    	this.latitude = latitude;
    	this.longitude = longitude;
    }

    public Location(Location b) {
    	this(b.locationId, b.locationName, b.longitude, b.latitude);
    	this.teamOwner = b.teamOwner;
    	this.description = b.description;
    	this.email = b.email;
    	this.phoneNumber = b.phoneNumber;
    	this.hours = b.hours;
    	this.image = b.image;
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

	public Team getTeamOwner() {
		return teamOwner;
	}

	public void setTeamOwner(Team teamOwner) {
		this.teamOwner = teamOwner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

    // TODO: equals, hashCode, toString

}
