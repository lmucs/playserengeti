package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.playserengeti.domain.User;

/**
 * A mock implementation of the User DAO that's backed by an id-keyed map.
 */
public class UserDaoMockImpl implements UserDao {

	// TODO: Implement synchornization and defensive copying.
	
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

	/**
	 * A convenience method to insert an array of users into the database.
	 */
	private void insertUsers(User[] users) {
		for (User user : users) {
			insertUser(user);
		}
	}
	
	private Map<Integer, User> storage;
	private int maxId;

	public UserDaoMockImpl() {
		storage = Collections.synchronizedMap(new HashMap<Integer, User>());
		maxId = -1;

		insertUsers(sampleUsers);
	}

	@Override
	public Collection<User> getAllUsers() {
		return storage.values();
	}
	
	@Override
	public User getUserById(Integer id) {
		return storage.get(id);
	}
	
	@Override
	public Collection<User> getUsersByDisplayName(String display) {
		Set<User> results = new HashSet<User>();
		
		for (User user : storage.values()) {
			if (user.getDisplayName().equals(display)) {
				results.add(user);
			}
		}
		
		return results;
	}

	@Override
	public Collection<User> getUsersByLoginName(String login) {
		Set<User> results = new HashSet<User>();
		
		for (User user : storage.values()) {
			if (user.getLoginName().equals(login)) {
				results.add(user);
			}
		}
		
		return results;
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

	@Override
	public void deleteUser(Integer id) {
		storage.remove(id);
	}
	
}
