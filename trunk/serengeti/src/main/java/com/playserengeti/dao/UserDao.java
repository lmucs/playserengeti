package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.User;

public interface UserDao {

	/**
	 * Commit a user to storage for the first time. The user id must be null in
	 * the user object. After the insert occurs, the user id will be populated
	 * with the user id and the user id will be returned.
	 * 
	 * NOTE: The creation date will NOT be populated in the user object. A
	 * separate select is required for this.
	 */
	public Integer insertUserWithPassword(User user, String password);

	/**
	 * Update the user in storage. All fields but id and dateCreated will be
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

	/**
	 * Gets all friends of a user.
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<User> getFriends(Integer userId);

	/**
	 * Gets a user's friend invites.
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<User> getFriendInvites(Integer userId);

	/**
	 * Gets the users who have signed up most recently.
	 */
	public Collection<User> getNewestUsers();

	/**
	 * Gets the users with the most checkins.
	 * 
	 * @return
	 */
	public Collection<User> getMostActiveUsers();

	/**
	 * Accepts a friend invitation from the users specified by firstId to that
	 * specified by secondId.
	 * 
	 * @param firstId
	 * @param secondId
	 * @return
	 */
	public boolean acceptFriendInvite(Integer firstId, Integer secondId);

	/**
	 * Rejects a friend invitation between the two given users.
	 * 
	 * @param firstId
	 * @param secondId
	 * @return
	 */
	public boolean rejectFriendInvite(Integer firstId, Integer secondId);

	/**
	 * Sends a friend invitation from the user specified by firstId to that
	 * specified by seocondId.
	 * 
	 * @param firstId
	 * @param secondId
	 */
	public void sendFriendInvite(Integer firstId, Integer secondId);

	/**
	 * Removes a friendship between the two given users.
	 * 
	 * @param firstId
	 * @param secondId
	 * @return
	 */
	public boolean removeFriend(Integer firstId, Integer secondId);

	/**
	 * Searches users based on a string.
	 * 
	 * @param query
	 * @return
	 */
	public Collection<User> searchUsers(String query);
}
