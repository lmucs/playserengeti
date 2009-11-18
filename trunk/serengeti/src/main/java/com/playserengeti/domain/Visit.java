package com.playserengeti.domain;

import java.util.Date;

/**
 * A game visit, or check-in.
 */
public class Visit {

	private Integer id;
    private Integer userId;
    private Integer teamId;
    private Integer locationId;
    private Date date;

    public Visit(Visit b) {
    	this(b.id, b.userId, b.teamId, b.locationId);
    	this.date = b.date;
    }

    public Visit(Integer id, Integer userId, Integer teamId, Integer locationId) {
        this.id = id;
        this.userId = userId;
        this.teamId = teamId;
        this.locationId = locationId;
        this.date = new Date();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String asJSON() {
		return "{\"id\" : \"" + this.id + "\", \"userId\" : \"" + this.userId + "\", \"teamId\" : \"" + this.teamId + 
		    "\", \"locationId\" : \"" + this.locationId + "\"}";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((locationId == null) ? 0 : locationId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	// TODO: toString
}
