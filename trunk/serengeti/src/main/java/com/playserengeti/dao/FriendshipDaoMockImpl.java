package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.playserengeti.domain.Friendship;

public class FriendshipDaoMockImpl implements FriendshipDao {

	// Sample memberships to insert into the database.
	private static final Friendship sampleFriendships[] = {
        new Friendship(null, 0, 1),
        new Friendship(null, 1, 2),
        new Friendship(null, 0, 2),
        new Friendship(null, 0, 3),
        new Friendship(null, 0, 4),
        new Friendship(null, 0, 5),
        new Friendship(null, 0, 6),
        new Friendship(null, 0, 7),
        new Friendship(null, 2, 3),
        new Friendship(null, 4, 3),
        new Friendship(null, 4, 1),
        new Friendship(null, 6, 7),
        new Friendship(null, 7, 2),
        new Friendship(null, 6, 1),
        new Friendship(null, 7, 5)
	};
	
	private Map<Integer, Friendship> storage;
	private int maxId;
	
	public FriendshipDaoMockImpl(){
		storage = Collections.synchronizedMap(new HashMap<Integer, Friendship>());
		maxId = -1;
		
		// Insert the sample teams into the database as this is a mock impl.
		insertFriendships(sampleFriendships);		
	}
	
	private void insertFriendships(Friendship[] friendships) {
		for (Friendship friendship : friendships) {
			insertFriendship(friendship);
		}
	}
	
	@Override
	public void deleteFriendship(Integer id) {
		storage.remove(id);
	}

	@Override
	public Collection<Friendship> getAllFriendships() {
		return storage.values();
	}

	@Override
	public Friendship getFriendshipById(Integer id) {
		return new Friendship(storage.get(id));
	}

	@Override
	public Collection<Friendship> getFriendshipsByUser(
			Integer userId) {
		Set<Friendship> result = new HashSet<Friendship>();
	    for(Friendship f : storage.values()) {
	    	if (f.getPrimaryUserId().equals(userId) || f.getSecondaryUserId().equals(userId)) {
	    		result.add(f);
	    	}
	    }
	    
		return result;
	}

	@Override
	public Integer insertFriendship(Friendship friendship) {
		if (!duplicateFriendship(friendship)) {
		    Integer id = ++maxId;
		
	    	friendship.setFriendshipId(id);
    		updateFriendship(friendship);
		
		    return id;
	    }
		return null;
	}

	@Override
	public void updateFriendship(Friendship friendship) {
		storage.put(friendship.getFriendshipId(), friendship);

	}

	public boolean duplicateFriendship(Friendship friendship) {
		for(Friendship f : storage.values()) {
			if (f.equals(friendship)) return true;
		}
		return false;
	}
}
