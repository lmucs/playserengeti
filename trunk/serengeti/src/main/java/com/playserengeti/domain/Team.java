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
    private List<User> members;
    private Location homeLocation;


    public Team(Integer id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.members = new ArrayList<User>();
    }

    public Team(Team b) {
    	this(b.id, b.name, b.color);
    	this.leader = b.leader;
    	this.image = b.image;
    	this.homeLocation = b.homeLocation;
    	this.members = b.members;
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
		if (!members.contains(user)) this.members.add(user);
	}

	public Location getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(Location location) {
		this.homeLocation = location;
	}

    public List<User> getMembers() {
    	return members;
    }

    public void setMembers(List<User> members) {
    	this.members = members;
    }

    public User getMemberById(Integer id) {
    	for (User user : members) {
    		if (user.getUserId() == id) {
    			return user;
    		}
    	}
    	return null;
    }

    public void addMember(User user) {
    	if (!this.members.contains(user)) this.members.add(user);
    }

    public void addMembers(Collection<User> users) {
    	for (User user : users) {
    		addMember(user);
    	}
    }

    public void removeMember(User user) {
    	this.members.remove(user);
    }

    public void removeMemberById(Integer id) {
    	for (User user : members) {
    		if (user.getUserId() == id) {
    			this.members.remove(user);
    		}
    	}
    }

    public boolean equals(Team team) {
    	if (this.id != team.id) return false;
    	return true;
    }
    // TODO: hashCode, toString
}
