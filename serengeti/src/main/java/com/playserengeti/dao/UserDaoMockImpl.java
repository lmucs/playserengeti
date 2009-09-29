package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.playserengeti.domain.User;

/**
 * A mock implementation of the User DAO that's backed by an id-keyed map.
 */
public class UserDaoMockImpl implements UserDao {

	// Sample users to insert into the database.
	private static final User sampleUsers[] = {
		new User(null, "Loren Abrams", "durnew"),
		new User(null, "Ray Toal", "hihimanuhahalua"),
		new User(null, "Christian Mueller", "mueller.chris0"),
		new User(null, "Lita Gratrix", "lgratrix"),
		new User(null, "James Coleman", "jcol88"),
		new User(null, "Mark Miscavage", "mxchickmagnet86"),
		new User(null, "Edgardo Ineguez", "malevolentman87"),
		new User(null, "Don Murphy", "DJScythe15")
	};
	
	private Map<Integer, User> storage;
	private int maxId;
	
	public UserDaoMockImpl() {
		storage = Collections.synchronizedMap(new HashMap<Integer, User>());
		maxId = -1;
		
		// Insert the sample users into the database as this is a mock impl.
		insertUsers(sampleUsers);
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

	/**
	 * A convenience method to insert an array of users into the database.
	 */
	private void insertUsers(User[] users) {
		for (User user : users) {
			insertUser(user);
		}
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
