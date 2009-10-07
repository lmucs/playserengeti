/*
 * UserDeleteCommand. Contains the methods to get and set UserDelete parameters (ie, userID)
 */

package com.playserengeti.controller;

public class UserDeleteCommand {

	private Integer userId;

    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
