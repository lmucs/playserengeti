package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataIntegrityViolationException;

import com.playserengeti.domain.Avatar;
import com.playserengeti.domain.User;

// TODO: More argument checks/assertions!!

/**
 * A mock implementation of the User DAO that's backed by an id-keyed map.
 */
public class UserDaoMockImpl implements UserDao {

	@Override
	public Collection<User> searchUsers(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeFriend(Integer firstId, Integer secondId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendFriendInvite(Integer firstId, Integer secondId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean acceptFriendInvite(Integer firstId, Integer secondId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectFriendInvite(Integer firstId, Integer secondId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<User> getFriendInvites(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> getMostActiveUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> getNewestUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> getFriends(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	// Storage for the user objects
    private Map<Integer, DBEntry> storage;
    private int maxId;

    public UserDaoMockImpl() {
        storage = Collections.synchronizedMap(new HashMap<Integer, DBEntry>());
        maxId = 0;

        User[] sampleUsers = new User[] {
        		new User("labrams@lion.lmu.edu", "Loren", "Abrams"),
        		new User("rtoal@lmu.edu", "Ray", "Toal"),
        		new User("litagratrix@gmail.com", "Lita", "Gratrix"),
        		new User("mueller.chris0@gmail.com", "Chris", "Mueller"),
        		new User("jcol88@gmail.com", "James", "Coleman"),
        		new User("mxchickmagnet86@gmail.com", "Chick", "Magnet"),
        		new User("malevolentman87@gmail.com", "Edgardo", "Ineguez"),
        		new User("DJScythe15@gmail.com", "Don", "Murphy")
        };

        // Insert the sample locations into the database as this is a mock impl.
        insertUsers(sampleUsers);
    }

	/**
	 * A convenience method to insert an array of users into the database.
	 */
	private void insertUsers(User[] sampleUsers) {
		for (User user : sampleUsers) {
			String firstName = user.getFirstName();
			insertUserWithPassword(
					user,
					firstName.substring(0,1).toLowerCase() + firstName.substring(1));
		}
	}

	@Override
	public Collection<User> getAllUsers() {
		Set<User> users = new HashSet<User>();
		for (DBEntry entry : storage.values()) {
			users.add(entry.user);
		}
		return users;
	}

    @Override
    public User getUserById(Integer userId) {
    	DBEntry entry = storage.get(userId);
    	if (entry == null) {
    		return null;
    	}
        return entry.user;
    }

	@Override
	public User getUserByEmail(String email) {
		for (DBEntry entry : storage.values()) {
			if (entry.user.getEmail().equals(email)) {
				return entry.user;
			}
		}
		return null;
	}
	
	@Override
	public User authenticateUserByEmailAndPassword(String email, String password) {
		for (DBEntry entry : storage.values()) {
			if (entry.user.getEmail().equals(email)) {
				if (entry.password.equals(password)) {
					return entry.user;
				}
				break;
			}
		}
		return null;
	}

    @Override
    public Integer insertUserWithPassword(User user, String password) {
		for (DBEntry entry : storage.values()) {
			if (entry.user.getEmail().equals(user.getEmail())) {
				throw new DataIntegrityViolationException(
						"Login name already exists");
			}
		}
        Integer userId = ++maxId;

        // Need to store separate User which has a non-null creation date. 
        storage.put(userId, new DBEntry(
        		new User(
        				userId,
        				user.getEmail(),
        				user.getFirstName(),
        				user.getLastName(),
        				new Date()), password));

        user.setId(userId);
        return user.getId();
    }

	@Override
	public boolean updateUser(User user) {
		DBEntry entry = storage.remove(user.getId());
		entry.user = user;
		storage.put(user.getId(), entry);
		return true;
	}
	
	@Override
	public boolean updateUserPassword(Integer userId, String password) {
		DBEntry entry = storage.remove(userId);
		entry.password = password;
		storage.put(userId, entry);
		return true;
	}

	@Override
	public boolean deleteUser(Integer id) {
		if (!storage.containsKey(id)) {
			// TODO: Localize message.
			throw new IllegalArgumentException("Invalid user ID.");
		}
		storage.remove(id);
		return true;
	}
	
	private class DBEntry {
		public User user;
		public String password;
		public DBEntry(User u, String pw) { this.user = u; this.password = pw; }
		@Override public int hashCode() { return user.hashCode(); }
		@Override public boolean equals(Object o) { return user.equals(o); }
	}

	@Override
	public Avatar getUserAvatarByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
