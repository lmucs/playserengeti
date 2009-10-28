package com.playserengeti.session;

import com.playserengeti.domain.User;

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
