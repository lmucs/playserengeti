package com.playserengeti.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.playserengeti.dao.FriendshipDao;
import com.playserengeti.dao.UserDao;
import com.playserengeti.domain.Friendship;
import com.playserengeti.domain.User;

/**
 * Service for operations related to users.
 */
public class UserService {

	private UserDao userDao;
	private FriendshipDao friendshipDao;

	public UserService(UserDao userDao, FriendshipDao friendshipDao) {
	    this.userDao = userDao;
	    this.friendshipDao = friendshipDao;
	}

	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	/**
	 * Creates a user from the provided information and writes the user to
	 * storage.
	 */
    public Integer saveUser(User user) {
		if (user.getUserId() == null) {
			return userDao.insertUser(user);
		} else {
			userDao.updateUser(user);
			return user.getUserId();
		}
    }

	/**
	 * Deletes the user with the given id from persistent storage.  If no
	 * such user exists, throws an IllegalArgumentException.
	 */
	public void deleteUser(Integer id) {
	    userDao.deleteUser(id);
	}

	/**
	 * Fetches all the users from persistent storage.
	 */
	public Collection<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
    public void saveFriendship(Friendship f) {
    	if(f.getFriendshipId() == null) {
    		friendshipDao.insertFriendship(f);
    	}
    	else {
    		friendshipDao.updateFriendship(f);
    	}
    }
    
    public void deleteFriendship(Integer id) {
    	friendshipDao.deleteFriendship(id);
    }
    
    public Collection<Friendship> getAllFriendships() {
    	return friendshipDao.getAllFriendships();
    }
    
    public Friendship getFriendshipById(Integer id) {
    	return friendshipDao.getFriendshipById(id);
    }
    
    public Collection<Friendship> getFriendshipsByUser(Integer userId) {
    	return friendshipDao.getFriendshipsByUser(userId);
    }
    
    public Collection<Integer> getFriends(Integer userId) {
    	Set<Integer> result = new HashSet<Integer>();
    	Collection<Friendship> friends = friendshipDao.getFriendshipsByUser(userId);
    	
    	for (Friendship f : friends) {
    		if (f.getPrimaryUserId() == userId) result.add(f.getSecondaryUserId());
    		else {
    			result.add(f.getPrimaryUserId());
    		}
    	}
    	
    	return result;
    }
}
