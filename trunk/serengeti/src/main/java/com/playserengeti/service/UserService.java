package com.playserengeti.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
	
	public User authenticateUserByEmailAndPassword(String email, String password) {
		User user = userDao.authenticateUserByEmailAndPassword(email, password);
		return user;
	}

	/**
	 * Creates a user from the provided information and writes the user to
	 * storage.
	 */
    public Integer insertUserWithPassword(User user, String password) {
		Integer id = userDao.insertUserWithPassword(user, password);
		User storedUser = userDao.getUserById(id);
		user.setDateCreated(storedUser.getDateCreated());
		return id;
    }
    
    public boolean updateUser(User user) {
    	return userDao.updateUser(user);
    }

    public boolean updateUserPassword(Integer userId, String password) {
    	return userDao.updateUserPassword(userId, password);
    }
    
	/**
	 * Deletes the user with the given id from persistent storage.
	 */
	public boolean deleteUser(Integer id) {
		// TODO: If no such user exists, throws an IllegalArgumentException.
	    return userDao.deleteUser(id);
	}

	/**
	 * Fetches all the users from persistent storage.
	 */
	public Collection<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	/**
	 * Returns all users as a map with key userId and value email.
	 */
	public Map<Integer, String> getAllUsersMap() {
		Map<Integer, String> result = new HashMap<Integer, String>();
		for(User u : userDao.getAllUsers()) {
			result.put(u.getId(), u.getEmail());
		}
		return result;
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
    
    public Collection<User> getFriends(Integer userId) {
    	Set<User> result = new HashSet<User>();
    	Collection<Friendship> friends = friendshipDao.getFriendshipsByUser(userId);
    	
    	for (Friendship f : friends) {
    		if (f.getStatus().equals("accepted")) {
    			if (f.getPrimaryUserId().equals(userId)) result.add(getUserById(f.getSecondaryUserId()));
    			else {
    				result.add(getUserById(f.getPrimaryUserId()));
    			}
    		}
    	}
    	
    	return result;
    }
    
    public Collection<Friendship> getFriendInvites(Integer userId) {
    	Set<Friendship> result = new HashSet<Friendship>();
    	Collection<Friendship> friends = friendshipDao.getFriendshipsByUser(userId);
    	
    	for(Friendship f : friends) {
    		if (f.getStatus().equals("pending") && f.getSecondaryUserId().equals(userId)) result.add(f);
    	}
    	
    	return result;
    }
    
    public Map<Integer, User> getFriendInvitesMap(Integer userId) {
    	Map<Integer, User> result = new HashMap<Integer, User>();
    	Collection<Friendship> friends = friendshipDao.getFriendshipsByUser(userId);
    	
    	for(Friendship f : friends) {
    		if (f.getStatus().equals("pending") && f.getSecondaryUserId().equals(userId)) {
    			result.put(f.getFriendshipId(), getUserById(f.getPrimaryUserId()));
    		}
    	}
    	
    	return result;
    }
    
    public Friendship getFriendshipByUserPair(Integer pUserId, Integer sUserId) {
    	Collection<Friendship> friendships = getAllFriendships();
    	
    	for(Friendship f: friendships) {
    		if (pUserId.equals(f.getPrimaryUserId()) && sUserId.equals(f.getSecondaryUserId())) {
    			return f;
    		}
    	}
    	return null;
    }
    
    /**
     * Returns a map of the given users friends.
     * Key is the friend's userId and value is their username.
     * @param userId
     * @return
     */
    public Map<Integer, String> getFriendsMap(Integer userId) {
    	Map<Integer, String> result = new HashMap<Integer, String>();
    	for(User u : getFriends(userId)) {
    		result.put(u.getId(), u.getEmail());
    	}
    	return result;
    }
    
    public void removeFriendship(Integer primaryId, Integer secondaryId) {
    	Collection<Friendship> friendships = getFriendshipsByUser(primaryId);
    	
    	for(Friendship f : friendships) {
    		if(secondaryId.equals(f.getSecondaryUserId()) 
    				|| secondaryId.equals(f.getPrimaryUserId())) {
    		    deleteFriendship(f.getFriendshipId());
    		}
    	}
    }
    
    public void inviteFriend(Integer pUserId, Integer sUserId) {
    	saveFriendship(new Friendship(null, pUserId, sUserId));
    }
    
    public void acceptFriend(Integer friendshipId) {
    	getFriendshipById(friendshipId).setStatus("accepted");
    }
    
    //TODO
    public Collection<User> getNewestUsers(int bound) {
        return null;
    }
}
