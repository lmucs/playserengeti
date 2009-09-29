package com.serengeti.dao;

import org.springframework.dao.DataAccessException;

import com.playserengeti.domain.User;

public interface UserDao {
	public void saveUser(User user) throws DataAccessException;
	public void updateUser(User user) throws DataAccessException;
	public void deleteUser(int id) throws DataAccessException;
	public User[] getAllUsers() throws DataAccessException;
	public User getUserById(int id) throws DataAccessException;
	public User getUserByLoginName(String login) throws DataAccessException;
	public User getUserByDisplayName(String display) throws DataAccessException;
}
