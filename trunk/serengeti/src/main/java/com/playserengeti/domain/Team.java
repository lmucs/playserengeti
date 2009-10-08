package com.playserengeti.domain;


/**
 * A Serengeti team.
 */
public class Team {

    private Integer id;
    private String name;
    private String color;
    private String image;
    private Integer leaderId;
    private String homeLocation;
    

    public Team(Integer id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Team(Team b) {
    	this(b.id, b.name, b.color);
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

    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
    	this.image = image;
    }

	public String getColor() {
		return color;
	}

	public Integer getLeaderId() {
		return leaderId;
	}
	
	public void setLeaderId(Integer id) {
		this.leaderId = id;
	}
	
	public String getHomeLocation() {
		return homeLocation;
	}
	
	public void setHomeLocation(String location) {
		this.homeLocation = location;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

    // TODO: equals, hashCode, toString
}
