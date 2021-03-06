package com.playserengeti.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A Serengeti team.
 */
public class Team {
	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"MMM dd, yyyy hh:mma");

	private Integer id;
	private Integer avatarId;
	private String name;
	private Date dateCreated;
	private String color;
	private User leader;
	private String description;
	private String homeBase;

	public Team() {
	}

	public Team(Integer id, String name, String color) {
		this.id = id;
		this.name = name;
		this.dateCreated = new Date();
		this.color = color;
	}

	public Team(Team b) {
		this(b.id, b.name, b.color);
		this.dateCreated = b.dateCreated;
		this.leader = b.leader;
		this.description = b.description;
		this.homeBase = b.homeBase;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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

	public Integer getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(Integer avatarId) {
		this.avatarId = avatarId;
	}

	/**
	 * Returns the team as a JSON string with all properties.
	 * Escapes quotations to prevent parse errors.
	 * 
	 * @return
	 */
	public String asJSON() {
		return "{\"id\" : \"" + this.id 
		        + "\", \"name\" : \"" + this.name.replace("\"", "&#34") 
		        + "\", \"color\" : \"" + this.color 
		        + "\", \"leader\" : " + this.leader.asJSON()
				+ ", \"description\" : \"" + this.description.replace("\"", "&#34")
				+ "\", \"homeBase\" : \"" + this.homeBase.replace("\"", "&#34")
				+ "\", \"dateCreated\" : \"" + sdf.format(this.dateCreated) + "\"}";
	}

	/**
	 * Returns the team as a JSON string with minimal information.
	 * Escapes quotations to prevent parse errors.
	 * 
	 * @return
	 */
	public String asMinimalJSON() {
		return "{\"id\" : " + this.id 
		        + ", \"name\" : \"" + this.name.replace("\"", "&#34") + "\"}";
	}

	public boolean equals(Team team) {
		if (this.id != team.id)
			return false;
		return true;
	}
	// TODO: hashCode, toString
}
