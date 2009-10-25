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

	// Storage for the user objects
    private Map<Integer, User> storage;
    private int maxId;

    public UserDaoMockImpl() {
        storage = Collections.synchronizedMap(new HashMap<Integer, User>());
        maxId = 0;

        User[] sampleUsers = new User[] {
        		new User(null, "labrams@lion.lmu.edu", "password", "Loren Abrams"),
        		new User(null, "rtoal@lmu.edu", "password", "Ray Toal"),
        		new User(null, "litagratrix@gmail.com", "password", "Lita Gratrix"),
        		new User(null, "mueller.chris0@gmail.com", "password", "Chris Mueller"),
        		new User(null, "jcol88@gmail.com", "password", "James Coleman"),
        		new User(null, "mxchickmagnet86@gmail.com", "password", "Mark Miscavage"),
        		new User(null, "malevolentman87@gmail.com", "password", "Edgardo Ineguez"),
        		new User(null, "DJScythe15@gmail.com", "password", "Don Murphy")
        };

        // Insert the sample locations into the database as this is a mock impl.
        insertUsers(sampleUsers);
    }

	/**
	 * A convenience method to insert an array of users into the database.
	 */
	private void insertUsers(User[] sampleUsers) {
		for (User sampleUser : sampleUsers) {
			insertUser(sampleUser);
		}
	}

	@Override
	public Collection<User> getAllUsers() {
		return storage.values();
	}

    @Override
    public User getUserById(Integer userId) {
        return storage.get(userId);
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
    public Integer insertUser(User user) {
		for (User u : storage.values()) {
			if (u.getEmail().equals(user.getEmail())) {
				throw new DataIntegrityViolationException(
						"Login name already exists");
			}
		}
        Integer userId = ++maxId;

        user.setUserId(userId);
        updateUser(user);

        return userId;
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
