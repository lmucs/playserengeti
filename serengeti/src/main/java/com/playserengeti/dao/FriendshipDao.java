package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.Friendship;

public interface FriendshipDao {

	public Integer insertFriendship(Friendship friendship);
	
	public void updateFriendship(Friendship friendship);
	
	public void deleteFriendship(Integer id);
	
	public Collection<Friendship> getAllFriendships();
	
	public Friendship getFriendshipById(Integer id);
	
	public Collection<Friendship> getFriendshipsByUser(Integer userId);
	
}
