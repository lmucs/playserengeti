package com.playserengeti.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	private static final String sampleUsers[][] = {
		{"durnew", "password1", "labrams@lion.lmu.edu"},
		{"rtoal", "password2", "rtoal@lmu.edu"}
	};

	private Map<Integer, User> storage = 
		Collections.synchronizedMap(new HashMap<Integer, User>());

	private int maxId = -1;

	/**
	 * A convenience method to insert an array of users into the database.
	 */
	private void insertUsers(String[][] usersInfo) {
		for (String[] userInfo : usersInfo) {
			insertUser(userInfo[0], userInfo[1], userInfo[2]);
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
	public Collection<User> getUsersByUserName(String userName) {
		Set<User> results = new HashSet<User>();

		for (User user : storage.values()) {
			if (user.getUserName().equals(userName)) {
				results.add(user);
			}
		}

		return results;
	}

	@Override
	public Collection<User> getUsersByEmail(String email) {
		Set<User> results = new HashSet<User>();

		for (User user : storage.values()) {
			if (user.getEmail().equals(email)) {
				results.add(user);
			}
		}

		return results;
	}

	@Override
	public User insertUser(String userName, String password, String email) {
		for (User u : storage.values()) {
			if (u.getUserName().equals(userName)) {
				throw new DataIntegrityViolationException(
						"Login name already exists");
			}
		}
		
		User user = new User(++maxId, userName, hashPassword(password), email);
		updateUser(user);

		return user;
	}

	@Override
	public void updateUser(User user) {
		storage.put(user.getUserId(), user);
	}

	@Override
	public void deleteUser(Integer id) {
		if (!storage.containsKey(id)) {
			// TODO: Localize message.
			throw new IllegalArgumentException("Invalid user ID.");
		}
		storage.remove(id);
	}

	public boolean userExists(Integer userId) {
		return (storage.get(userId) != null);
	}
	
	
	private static byte[] hashPassword(String password) {
		try {
			return MessageDigest.getInstance("MD5").digest(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO: Do further error handling.
			System.err.println("User password hashing: " + e.getMessage());
			return null;
		}
	}
}
