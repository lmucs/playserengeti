package com.playserengeti.session;

import com.playserengeti.domain.User;

/**
 * A session object. Keeps track of the currently logged in user.
 * 
 * @author Chris
 * 
 */
public class UserSession {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return user != null;
	}

}
