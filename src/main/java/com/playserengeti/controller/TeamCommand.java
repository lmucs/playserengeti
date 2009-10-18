package com.playserengeti.controller;

import java.util.Collection;

public class TeamCommand {

	Integer teamId;
	String name;
	String color;
	String image;
	Integer leaderId;
	String description;
	String homeBase;
	Collection<Integer> members;
	Collection<Integer> invitees;
	Collection<Integer> removals;
	
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
	public Collection<Integer> getMembers() {
		return members;
	}
	public void setMembers(Collection<Integer> members) {
		this.members = members;
	}
	public Collection<Integer> getInvitees() {
		return invitees;
	}
	public void setInvitees(Collection<Integer> invitees) {
		this.invitees = invitees;
	}
	public Collection<Integer> getRemovals() {
		return removals;
	}
	public void setRemovals(Collection<Integer> removals) {
		this.removals = removals;
	}
	
	
}
