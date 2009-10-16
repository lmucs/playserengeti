/*
 * UserUpdateCommand. Contains the methods to get and set UserManage parameters (ie, userID)
 */

package com.playserengeti.controller;

import java.util.Date;

public class UserUpdateCommand {

	private Integer userId;
    private String userName;		// Not null.
    private String passwordHash;	// Not null.
    private String firstName;		// Optional.
    private String lastName;		// Optional.
    private String email;			// Not null.
    private Date dateOfBirth;		// Optional.

    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String userName(){
		return userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
