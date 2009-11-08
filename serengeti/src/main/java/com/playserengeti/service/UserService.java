package com.playserengeti.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.playserengeti.dao.FriendshipDao;
import com.playserengeti.dao.UserDao;
import com.playserengeti.domain.Friendship;
import com.playserengeti.domain.Team;
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
	
	public User getUserByEmailAndPassword(String email, String password) {
		User user = userDao.getUserByEmail(email);
		if (user == null || !password.equals(user.getPasswordHash())) {
			return null;
		}
		return user;
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
	
	/**
	 * Returns all users as a map with key userId and value username.
	 * @return
	 */
	public Map<Integer, String> getAllUsersMap() {
		Map<Integer, String> result = new HashMap<Integer, String>();
		Collection<User> users = userDao.getAllUsers();
		
		for(User u : users) {
			result.put(u.getUserId(), u.getDisplayName());
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
    	Collection<User> friends = getFriends(userId);
    	
    	for(User u : friends) {
    		result.put(u.getUserId(), u.getDisplayName());
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
