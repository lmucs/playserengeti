package com.playserengeti.domain;

public class Location {

    private Integer id;
    private String name;
    private double latitude;
    private double longitude;
    private Team owner;
    private String phoneNumber;
    private String street;
    private String city;
    private String state;
    private String zipcode;

    public Location() {
    }
    
    public Location(Integer id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(Location b) {
    	this(b.id, b.name, b.latitude, b.longitude);
    	this.owner = b.owner;
    	this.phoneNumber = b.phoneNumber;
    	this.street = b.street;
    	this.city = b.city;
    	this.state = b.state;
    	this.zipcode = b.zipcode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Team getOwner() {
		return owner;
	}

	public void setOwner(Team owner) {
		this.owner = owner;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public String asJSON() {
		String owner = this.owner != null ? this.owner.asMinimalJSON() : "{\"id\" : \"\", \"name\" : \"In Conflict\"}";
		return "{\"id\" : " + this.id + ", \"name\" : \"" + this.name.replace("\"", "&#34") + "\", \"latitude\" : \"" + 
		    this.latitude + "\", \"longitude\" : \"" + this.longitude + "\", \"street\" : \"" + this.street + 
		    "\", \"city\" : \"" + this.city + "\", \"state\" : \"" + this.state + "\", \"zipcode\" : \"" + this.zipcode + 
		    "\", \"owner\" : " + owner + ", \"phoneNumber\" : \"" + this.phoneNumber + 
		    "\"}";
	}
	
	public String asMinimalJSON() {
		return "{\"id\" : " + this.id + ", \"name\" : \"" + this.name.replace("\"", "&#34") + "\", \"latitude\" : \"" + 
	    this.latitude + "\", \"longitude\" : \"" + this.longitude + "\"}";
	}
	

	
    // TODO: equals, hashCode, toString

}
