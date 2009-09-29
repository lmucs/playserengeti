package com.playserengeti.domain;

/**
 * A game user, or player.
 */
public class User {

	private Integer id;
	private String loginName;
	private String displayName;
	
	public User(Integer id, String loginName, String displayName) {
		this.id = id;
		this.loginName = loginName;
		this.displayName = displayName;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getLoginName() {
		return loginName;
	}
	
	public String getDisplayName() {
		return displayName;
	}	
}
