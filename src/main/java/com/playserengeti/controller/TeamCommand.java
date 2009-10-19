package com.playserengeti.controller;

import java.util.Map;

public class TeamCommand {

	Integer teamId;
	String name;
	String color;
	String image;
	Integer leaderId;
	String description;
	String homeBase;
	Map<Integer, String> members;
	Integer[] invitees;
	Integer[] removals;
	Map<Integer, String> candidates;
	
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
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
	public Map<Integer, String> getMembers() {
		return members;
	}
	public void setMembers(Map<Integer, String> members) {
		this.members = members;
	}
	public Integer[] getInvitees() {
		return invitees;
	}
	public void setInvitees(Integer[] invitees) {
		this.invitees = invitees;
	}
	public Integer[] getRemovals() {
		return removals;
	}
	public void setRemovals(Integer[] removals) {
		this.removals = removals;
	}
	public Map<Integer, String> getCandidates() {
		return candidates;
	}
	public void setCandidates(Map<Integer, String> candidates) {
		this.candidates = candidates;
	}
	
}
