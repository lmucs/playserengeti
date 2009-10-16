package com.playserengeti.domain;

public class Friendship {

	private Integer friendshipId;
	private Integer primaryUserId;
	private Integer secondaryUserId;
	
	public Friendship(Integer friendshipId, Integer primaryUserId, Integer secondaryUserId) {
		this.friendshipId = friendshipId;
		this.primaryUserId = primaryUserId;
		this.secondaryUserId = secondaryUserId;
	}
	
	public Friendship(Friendship f) {
		this(f.friendshipId, f.primaryUserId, f.secondaryUserId);
	}

	public Integer getFriendshipId() {
		return friendshipId;
	}

	public void setFriendshipId(Integer friendshipId) {
		this.friendshipId = friendshipId;
	}

	public Integer getPrimaryUserId() {
		return primaryUserId;
	}

	public void setPrimaryUserId(Integer primaryUserId) {
		this.primaryUserId = primaryUserId;
	}

	public Integer getSecondaryUserId() {
		return secondaryUserId;
	}

	public void setSecondaryUserId(Integer secondaryUserId) {
		this.secondaryUserId = secondaryUserId;
	}
	
	/**
	 * Checks to see if the users involved in two friendships 
	 * are the same.
	 * @param f
	 * @return
	 */
	public boolean equals(Friendship f) {
        if ((this.primaryUserId == f.primaryUserId 
        	&& this.secondaryUserId == f.secondaryUserId) || 
        	(this.primaryUserId == f.secondaryUserId 
        	&& this.secondaryUserId == f.primaryUserId)) return true;
        return false;
	}
}
