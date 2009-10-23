package com.playserengeti.domain;

public class Location {

    private Integer locationId;
    private String locationName;
    private double longitude;
    private double latitude;
    private Team teamOwner;
    private String description;
    private String phoneNumber;
    private String image;
    private String street;
    private String city;
    private String state;
    private String zipcode;

    public Location(Integer locationId, String locationName, double longitude, double latitude) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(Location b) {
    	this(b.locationId, b.locationName, b.longitude, b.latitude);
    	this.teamOwner = b.teamOwner;
    	this.description = b.description;
    	this.phoneNumber = b.phoneNumber;
    	this.image = b.image;
    	this.street = b.street;
    	this.city = b.city;
    	this.state = b.state;
    	this.zipcode = b.zipcode;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * Gets the full address of the location.
	 * Had to do it like this because the .jsp pages wouldn't
	 * render a newline character.
	 * @return
	 */
	public String[] getFullAddress() {
		return new String[]{street, city + ", " + state + " " + zipcode};
	}
	
    // TODO: equals, hashCode, toString

}
