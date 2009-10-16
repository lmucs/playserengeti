package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.User;

public interface UserDao {

	/**
	 * Commit a user to storage for the first time.
	 *
	 * @return the user object that is generated
	 */
	public Integer insertUser(User user);

	/**
	 * Update the user in storage.
	 */
	public void updateUser(User user);

	/**
	 * Delete a user from storage.
	 */
	public void deleteUser(Integer id);

	/**
	 * Get a user from storage by user id.
	 *
	 * @return the fetched user or null if none exist with that id
	 */
	public User getUserById(Integer id);

	/**
	 * Get all users from storage.
	 */
	public Collection<User> getAllUsers();

	/**
	 * Get a users from storage by their user name.
	 */
	public Collection<User> getUsersByUserName(String userName);

	/**
	 * Get a users from storage by their email addresses.
	 */
	public Collection<User> getUsersByEmail(String email);

	/**
	 * Check the existance of a userId.
	 *
	 */
	public boolean userExists(Integer userId);

}
