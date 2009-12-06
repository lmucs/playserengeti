package com.playserengeti.controller;

import java.util.Collection;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;

public class UserCommand {

    private Integer userId;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String image;
    private Collection<User> friends;
    private Collection<Team> teams;
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
    
    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<User> getFriends() {
        return friends;
    }

    public void setFriends(Collection<User> friends) {
        this.friends = friends;
    }

    public Collection<Team> getTeams() {
        return teams;
    }

    public void setTeams(Collection<Team> teams) {
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
