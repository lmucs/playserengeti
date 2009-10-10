package com.playserengeti.domain;

import java.util.Date;

import static com.playserengeti.util.ArgumentChecker.assertArgument;

/**
 * A Serengeti user (player).
 */
public class User {
	
	private final Integer userId;	// User table primary key.
    private String userName;		// Not null.
    private byte[] passwordHash;	// Not null.
    private String firstName;		// Optional.
    private String lastName;		// Optional.
    private String email;			// Not null.
    private Date dateOfBirth;		// Optional.
    
	public User(Integer userId, String userName, byte[] passwordHash,
			String firstName, String lastName, String email, Date dateOfBirth) {
		// Set userId.
		assertArgument(userId != null, "UserId must not be null.");
		this.userId = userId;
		
		setUserName(userName);
		setPasswordHash(passwordHash);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setDateOfBirth(dateOfBirth);
	}
	
	public User(Integer userId, String userName, byte[] passwordHash,
			String email) {
		this(userId, userName, passwordHash, null, null, email, null);
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

	public byte[] getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(byte[] passwordHash) {
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
	
}
