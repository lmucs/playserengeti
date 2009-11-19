package com.playserengeti.domain;

public class Membership {

	private Integer membershipId;
	private Integer teamId;
	private Integer userId;
	private String status;
	
	public Membership(Integer membershipId, Integer teamId, Integer userId) {
		this.membershipId = membershipId;
		this.teamId = teamId;
		this.userId = userId;
		this.status = "pending";
	}
	
	public Membership(Membership m) {
		this(m.membershipId, m.teamId, m.userId);
		this.status = m.status;
	}

	public Integer getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Integer membershipId) {
		this.membershipId = membershipId;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String asJSON() {
		return "{\"id\" : " + this.membershipId + ", \"teamId\" : " + this.teamId + ", \"userId\" : " + 
		    this.userId + ", \"status\" : \"" + this.status + "\"}";
	}

	public boolean equals(Membership m) {
		return this.membershipId != m.membershipId ? false : true;
	}
}
