/*
 * UserViewProfileCommand. Contains the methods to get and set UserViewProfile parameters (ie, userID)
 */

package com.playserengeti.controller;

public class UserViewProfileCommand {

	private String userID;

    public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
