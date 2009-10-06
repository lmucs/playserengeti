/*
 * UserUpdateCommand. Contains the methods to get and set UserManage parameters (ie, userID)
 */

package com.playserengeti.controller;

public class UserUpdateCommand {

	private String userID;

    public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
