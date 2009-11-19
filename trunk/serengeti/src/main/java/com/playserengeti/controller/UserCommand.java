package com.playserengeti.controller;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class UserCommand {

    private Integer userId;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Map<Integer, String> friends;
    private Map<Integer, String> teams;
    private String format;

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

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", userId)
            .append("email", email)
            .append("firstName", firstName)
            .append("lastName", lastName)
            .append("password", password)
            .toString();
    }
}
