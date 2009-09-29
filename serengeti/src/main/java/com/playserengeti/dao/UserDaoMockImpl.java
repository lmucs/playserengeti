package com.playserengeti.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.playserengeti.domain.User;

/**
 * A mock implementation of the User DAO that's backed by a simple map.
 */
public class UserDaoMockImpl implements UserDao {

	private Map<Integer, User> storage;
	private int maxId;
	
	public UserDaoMockImpl() {
		storage = new HashMap<Integer, User>();
		maxId = -1;
	}
	
	@Override
	public void deleteUser(Integer id) {
		storage.remove(id);
	}

	@Override
	public Collection<User> getAllUsers() {
		return storage.values();
	}

	@Override
	public User getUserByDisplayName(String display) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User getUserById(Integer id) {
		return storage.get(id);
	}

	@Override
	public User getUserByLoginName(String login) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Integer insertUser(User user) {
		Integer id = ++maxId;
		
		user.setId(id);
		updateUser(user);
		
		return id;
	}
	
	@Override
	public void updateUser(User user) {
		storage.put(user.getId(), user);
	}

}
