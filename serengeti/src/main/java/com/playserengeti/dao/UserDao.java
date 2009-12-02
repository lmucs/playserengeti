package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.User;

public interface UserDao {

	/**
	 * Commit a user to storage for the first time.  The user id must be null
	 * in the user object.  After the insert occurs, the user id will be
	 * populated with the user id and the user id will be returned.
	 * 
	 * NOTE: The creation date will NOT be populated in the user object.  A
	 * sepecate select is required for this.
	 */
	public Integer insertUserWithPassword(User user, String password);

	/**
	 * Update the user in storage.  All fields but id and dateCreated will be
	 * updated.
	 */
	public boolean updateUser(User user);

	/**
	 * Update user password.
	 */
	public boolean updateUserPassword(Integer id, String password);
	
	/**
	 * Delete a user from storage.
	 */
	public boolean deleteUser(Integer id);

	/**
	 * Get all users from storage.
	 */
	public Collection<User> getAllUsers();
	
	/**
	 * Get a user from storage by user id.
	 */
	public User getUserById(Integer id);

	/**
	 * Get a user from storage by their email addresses.
	 */
	public User getUserByEmail(String email);
	
	/**
	 * Authenticate a user by email and password.
	 */
	public User authenticateUserByEmailAndPassword(String email, String password);
	
	public Collection<User> getFriends(Integer userId);
	
	public Collection<User> getFriendInvites(Integer userId);
	
	public Collection<User> getNewestUsers();
	
	public Collection<User> getMostActiveUsers();
	
	public boolean acceptFriendInvite(Integer firstId, Integer secondId);

	public boolean rejectFriendInvite(Integer firstId, Integer secondId);
}
