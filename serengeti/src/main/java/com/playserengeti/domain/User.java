package com.playserengeti.domain;

import static com.playserengeti.util.ArgumentChecker.assertArgument;

import java.util.Date;

/**
 * A Serengeti user (player).
 */
public class User {

	private Integer userId;	// User table primary key.
    private String userName;		// Not null.
    private String passwordHash;	// Not null.
    private String firstName;		// Optional.
    private String lastName;		// Optional.
    private String email;			// Not null.
    private Date dateOfBirth;		// Optional.

	public User(Integer userId, String userName, String passwordHash,
			String firstName, String lastName, String email, Date dateOfBirth) {

		setUserId(userId);
		setUserName(userName);
		setPasswordHash(passwordHash);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setDateOfBirth(dateOfBirth);
	}

	public User(Integer userId, String userName, String passwordHash,
			String email) {
		this(userId, userName, passwordHash, null, null, email, null);
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		assertArgument(userName != null, "A username must be provided.");
		this.userName = userName;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		assertArgument(passwordHash != null, "A user must have a password.");
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
		assertArgument(email != null, "A user must have an email address.");
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		return prime * 1 + userId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User)obj;
		if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
}
