package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.User;

public interface UserDao {
	
	/**
	 * Commit the user to storage for the first time.
	 * 
	 * @param user user to commit
	 * @return the user id of the newly inserted user
	 */
	public Integer insertUser(User user);
	
	/**
	 * Update the user in storage.
	 * 
	 * @param user user to update
	 */
	public void updateUser(User user);
	
	/**
	 * Delete a user from storage.
	 * 
	 * @param id user id of the user to delete
	 */
	public void deleteUser(Integer id);
	
	/**
	 * Get all users from storage.
	 */
	public Collection<User> getAllUsers();
	
	/**
	 * Get a user from storage.
	 * 
	 * @param id user id of the user to fetch
	 * @return the fetched user or null if none exist with that id
	 */
	public User getUserById(Integer id);
	
	/**
	 * Get a user from storage.
	 * 
	 * @param login login name of the user
	 * @return the fetched user
	 */
	public User getUserByLoginName(String login);
	
	/**
	 * Get a user from storage.
	 * 
	 * @param display display name of the user
	 * @return the fetched user
	 */
	public User getUserByDisplayName(String display);
}
