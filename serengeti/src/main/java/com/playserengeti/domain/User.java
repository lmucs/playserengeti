package com.playserengeti.domain;

import static com.playserengeti.util.ArgumentChecker.assertArgument;

import java.util.Date;

/**
 * A Serengeti user (player).
 */
public class User {

	private Integer userId;	// User table primary key.
    private String email;		    // Used as the username.  Not null.
    private String passwordHash;	// Not null.
    private String displayName;     // Not null.
    private String image;

	public User(Integer userId, String email, String passwordHash,
			String displayName) {
		setEmail(email);
		setPasswordHash(passwordHash);
		setDisplayName(displayName);
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		assertArgument(email != null, "An email address must be provided.");
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		assertArgument(passwordHash != null, "A user must have a password.");
		this.passwordHash = passwordHash;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
