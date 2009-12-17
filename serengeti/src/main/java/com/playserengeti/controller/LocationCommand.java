package com.playserengeti.controller;

import com.playserengeti.domain.Team;

/**
 * Command class for controllers/pages dealing with locations. Contains
 * information for the location in question.
 * 
 * @author Chris
 * 
 */
public class LocationCommand {

	private Integer id;
	private String name;
	private Double longitude;
	private Double latitude;
	private Team owner;
	private String description;
	private String phoneNumber;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	//Only used as hack to solve problem with 
	//setting formBackingObject
	private Integer sessionId;

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

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Team getOwner() {
		return owner;
	}

	public void setOwner(Team owner) {
		this.owner = owner;
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

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}
}
