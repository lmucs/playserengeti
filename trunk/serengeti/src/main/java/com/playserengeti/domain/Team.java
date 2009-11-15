package com.playserengeti.domain;

import java.util.Date;



/**
 * A Serengeti team.
 */
public class Team {

    private Integer id;
    private String name;
    private Date dateCreated;
    private String color;
    private User leader;
    private String description;
    private String homeBase;

    public Team() {
    }
    
    public Team(Integer id, String name, String color) {
        this.id = id;
        this.name = name;
        this.dateCreated = new Date();
        this.color = color;
    }

    public Team(Team b) {
    	this(b.id, b.name, b.color);
    	this.dateCreated = b.dateCreated;
    	this.leader = b.leader;
    	this.description = b.description;
    	this.homeBase = b.homeBase;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User user) {
		this.leader = user;
	}

    public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHomeBase() {
		return homeBase;
	}

	public void setHomeBase(String homeBase) {
		this.homeBase = homeBase;
	}

	public boolean equals(Team team) {
    	if (this.id != team.id) return false;
    	return true;
    }
    // TODO: hashCode, toString
}
