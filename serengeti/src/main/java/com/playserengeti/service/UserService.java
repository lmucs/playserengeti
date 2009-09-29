package com.playserengeti.service;

import com.playserengeti.domain.User;
import com.serengeti.dao.UserDao;

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
	 * Writes the given user to persistent storage.  If the given
	 * user has a null id, a user is created in persistent storage.
	 * If the id is not null, and a user with that id exists, the
	 * user in persistent storage will be updated with the fields in
	 * the argument.  If the id is not null, but no such user with that
	 * id exists, then throws some kind of exception.  (TODO) 
	 */
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
	
	/**
	 * Deletes the user with the given id from persistent storage.  If no
	 * such user exists, throws an IllegalArgumentException.
	 */
	public void deleteUser(Integer id) {
	    userDao.deleteUser(id);	
	}
}
