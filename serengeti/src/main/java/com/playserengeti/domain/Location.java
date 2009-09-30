package com.playserengeti.domain;

public class Location {

    private Integer id;
    private String name;
    private double longitude;
    private double latitude;
    private int teamOwner;

    public Location(Integer id, String name, double longitude, double latitude) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
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

	public int getTeamOwner() {
		return teamOwner;
	}

	public void setTeamOwner(int teamOwner) {
		this.teamOwner = teamOwner;
	}
    
    // TODO: equals, hashCode, toString

}
