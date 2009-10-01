package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.playserengeti.domain.User;

/**
 * A mock implementation of the User DAO that's backed by an id-keyed map.
 */
public class UserDaoMockImpl implements UserDao {

	// Sample users to insert into the database.
	private static final User sampleUsers[] = {
		new User(0, "Loren Abrams", "durnew"),
		new User(1, "Ray Toal", "hihimanuhahalua"),
		new User(2, "Christian Mueller", "mueller.chris0"),
		new User(3, "Lita Gratrix", "lgratrix"),
		new User(4, "James Coleman", "jcol88"),
		new User(5, "Mark Miscavage", "mxchickmagnet86"),
		new User(6, "Edgardo Ineguez", "malevolentman87"),
		new User(7, "Don Murphy", "DJScythe15")
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
		return new HashSet<User>(storage.values());
	}

	@Override
	public User getUserByDisplayName(String display) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User getUserById(Integer id) {
		return new User(storage.get(id));
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
