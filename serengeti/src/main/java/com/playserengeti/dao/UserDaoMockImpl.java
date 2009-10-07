package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataIntegrityViolationException;

import com.playserengeti.domain.User;

/**
 * A mock implementation of the User DAO that's backed by an id-keyed map.
 */
public class UserDaoMockImpl implements UserDao {

	// TODO: Implement synchronization and defensive copying.

	// Sample users to insert into the database.
	private static final User sampleUsers[] = {
		new User(null, "Loren Abrams", "durnew"),
		new User(null, "Ray Toal", "hihimanuhahalua"),
		new User(null, "Chris Mueller", "mueller.chris0"),
		new User(null, "Lita Gratrix", "lgratrix"),
		new User(null, "James Coleman", "jcol88"),
		new User(null, "Mark Miscavage", "mxchickmagnet86"),
		new User(null, "Edgardo Ineguez", "malevolentman87"),
		new User(null, "Don Murphy", "DJScythe15")
	};

	private Map<Integer, User> storage = 
		Collections.synchronizedMap(new HashMap<Integer, User>());

	private int maxId = -1;

	/**
	 * A convenience method to insert an array of users into the database.
	 */
	private void insertUsers(User[] users) {
		for (User user : users) {
			insertUser(user);
		}
	}

	public UserDaoMockImpl() {
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
		for (User u : storage.values()) {
			if (u.getLoginName().equals(user.getLoginName())) {
				throw new DataIntegrityViolationException(
						"Login name already exists");
			}
		}
		
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

	public boolean userExists(Integer userId) {
		return (storage.get(userId) != null);
	}
}
