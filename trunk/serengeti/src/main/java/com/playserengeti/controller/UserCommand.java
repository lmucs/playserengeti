package com.playserengeti.controller;

import java.util.List;
import java.util.Map;

public class UserCommand {
    private Integer userId;
    private String email;
    private String password;
    private String displayName;
    private String image;
    private Map<Integer, String> friends;
    private List<Integer> friendRemovals;
    private Map<Integer, String> teams;
    private List<Integer> teamRemovals;
    private Integer checkinLocation;
    private Integer checkinTeam;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<Integer, String> getFriends() {
        return friends;
    }

    public void setFriends(Map<Integer, String> friends) {
        this.friends = friends;
    }

    public Map<Integer, String> getTeams() {
        return teams;
    }

    public void setTeams(Map<Integer, String> teams) {
        this.teams = teams;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Integer> getFriendRemovals() {
        return friendRemovals;
    }

    public void setFriendRemovals(List<Integer> friendRemovals) {
        this.friendRemovals = friendRemovals;
    }

    public List<Integer> getTeamRemovals() {
        return teamRemovals;
    }

    public void setTeamRemovals(List<Integer> teamRemovals) {
        this.teamRemovals = teamRemovals;
    }

	public Integer getCheckinLocation() {
		return checkinLocation;
	}

	public void setCheckinLocation(Integer checkinLocation) {
		this.checkinLocation = checkinLocation;
	}

	public Integer getCheckinTeam() {
		return checkinTeam;
	}

	public void setCheckinTeam(Integer checkinTeam) {
		this.checkinTeam = checkinTeam;
	}
}
