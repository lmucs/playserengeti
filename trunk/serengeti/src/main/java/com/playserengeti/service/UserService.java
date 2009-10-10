package com.playserengeti.service;

import java.util.Collection;

import com.playserengeti.dao.UserDao;
import com.playserengeti.domain.User;

/**
 * Service for operations related to users.
 */
public class UserService {

	private UserDao userDao;
	
	public UserService(UserDao userDao) {
	    this.userDao = userDao;	
	}
	
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}
	
	/**
	 * Creates a user from the provided information and writes the user to
	 * storage. 
	 */
	public User createUser(String userName, String password, String email) {
		return userDao.insertUser(userName, password, email);
	}
	
	/**
	 * Deletes the user with the given id from persistent storage.  If no
	 * such user exists, throws an IllegalArgumentException.
	 */
	public void deleteUser(Integer id) {
	    userDao.deleteUser(id);	
	}
	
	/**
	 * Fetches all the users from persistent storage.
	 */
	public Collection<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
