/*
 * UserViewProfileCommand. Contains the methods to get and set UserViewProfile parameters (ie, userID)
 */

package com.playserengeti.controller;

public class UserViewProfileCommand {

	private Integer userId;

    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
