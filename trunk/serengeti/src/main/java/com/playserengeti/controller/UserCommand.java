package com.playserengeti.controller;

import java.util.Map;

public class UserCommand {
    private Integer userId;
    private String email;
    private String password;
    private String displayName;
    private String image;
    private Map<Integer, String> friends;
    private Integer[] friendRemovals;
    private Map<Integer, String> teams;
    private Integer[] teamRemovals;

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

    public Integer[] getFriendRemovals() {
        return friendRemovals;
    }

    public void setFriendRemovals(Integer[] friendRemovals) {
        this.friendRemovals = friendRemovals;
    }

    public Integer[] getTeamRemovals() {
        return teamRemovals;
    }

    public void setTeamRemovals(Integer[] teamRemovals) {
        this.teamRemovals = teamRemovals;
    }
}
