package com.serengeti.dao;

import java.util.List;

import com.playserengeti.domain.User;

public interface UserDao {
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public List<User> getAllUsers();
	public User getUserById(int id);
	public User getUserByLoginName(String login);
	public User getUserByDisplayName(String display);
}
