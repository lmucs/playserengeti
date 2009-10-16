package com.playserengeti.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * A Serengeti team.
 */
public class Team {

    private Integer id;
    private String name;
    private String color;
    private String image;
    private User leader;

    public Team(Integer id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Team(Team b) {
    	this(b.id, b.name, b.color);
    	this.leader = b.leader;
    	this.image = b.image;
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
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
    	this.image = image;
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

    public boolean equals(Team team) {
    	if (this.id != team.id) return false;
    	return true;
    }
    // TODO: hashCode, toString
}
