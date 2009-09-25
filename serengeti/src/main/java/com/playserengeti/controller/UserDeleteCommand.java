/*
 * UserDeleteCommand. Contains the methods to get and set UserDelete parameters (ie, userID)
 */

package com.playserengeti.controller;

public class UserDeleteCommand {

	private String userID;

    public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
