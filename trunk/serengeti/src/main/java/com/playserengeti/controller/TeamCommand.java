package com.playserengeti.controller;

import java.util.Collection;

import org.springframework.web.multipart.MultipartFile;

import com.playserengeti.domain.User;

/**
 * The command class for controllers/pages dealing with teams. Contains
 * information about the team in questions.
 * 
 * @author Chris
 * 
 */
public class TeamCommand {

	private Integer teamId;
	private String name;
	private String color;
	private MultipartFile imageFile;
	private User leader;
	private String description;
	private String homeBase;
	private Collection<User> members;
	private Collection<User> candidates;
	private Integer[] invitees;
	private Integer sessionId;

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

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
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

	public Collection<User> getMembers() {
		return members;
	}

	public void setMembers(Collection<User> members) {
		this.members = members;
	}

	public Integer[] getInvitees() {
		return invitees;
	}

	public void setInvitees(Integer[] invitees) {
		this.invitees = invitees;
	}

	public Collection<User> getCandidates() {
		return candidates;
	}

	public void setCandidates(Collection<User> candidates) {
		this.candidates = candidates;
	}

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}
}
