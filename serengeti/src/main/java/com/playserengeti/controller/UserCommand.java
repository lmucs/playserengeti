package com.playserengeti.controller;

import java.util.Date;
import java.util.Map;

public class UserCommand {
	Integer userId;	
    String userName;	
    String password;	
    String firstName;	
    String lastName;	
    String email;		
    String image;
    Date dateOfBirth;
    Map<Integer, String> friends;
    Integer[] friendRemovals;
    Map<Integer, String> teams;
    Integer[] teamRemovals;
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
