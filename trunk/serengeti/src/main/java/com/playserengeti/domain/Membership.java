package com.playserengeti.domain;

public class Membership {

	private Integer membershipId;
	private Integer teamId;
	private Integer userId;
	
	public Membership(Integer membershipId, Integer teamId, Integer userId) {
		this.membershipId = membershipId;
		this.teamId = teamId;
		this.userId = userId;
	}
	
	public Membership(Membership m) {
		this(m.membershipId, m.teamId, m.userId);
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
	
	public boolean equals(Membership m) {
		return this.membershipId != m.membershipId ? false : true;
	}
}
