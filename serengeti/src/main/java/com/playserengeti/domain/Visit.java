package com.playserengeti.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A game visit, or check-in.
 */
public class Visit {
	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"MMM dd, yyyy hh:mma");

	private Integer id;
	private User user;
	private Team team;
	private Location location;
	private Date date;

	public Visit() {
	}

	public Visit(Visit b) {
		this(b.id, b.user, b.team, b.location);
		this.date = b.date;
	}

	public Visit(Integer id, User user, Team team, Location location) {
		this.id = id;
		this.user = user;
		this.team = team;
		this.location = location;
		this.date = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Returns the visit as a JSON string with all properties as JSON strings.
	 * 
	 * @return
	 */
	public String asJSON() {
		return "{\"id\" : \"" + this.id 
		        + "\", \"user\" : " + this.user.asMinimalJSON() 
		        + ", \"team\" : " + this.team.asMinimalJSON() 
		        + ", \"location\" : " + this.location.asMinimalJSON() 
		        + ", \"date\" : \"" + sdf.format(this.date) + "\"}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visit other = (Visit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	// TODO: toString
}
