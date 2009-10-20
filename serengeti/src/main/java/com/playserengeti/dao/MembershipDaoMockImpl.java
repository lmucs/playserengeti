package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.playserengeti.domain.Membership;

public class MembershipDaoMockImpl implements MembershipDao{

	// Sample memberships to insert into the database.
	private static final Membership sampleMemberships[] = {
		new Membership(null, 0, 0),
		new Membership(null, 0, 1),		
		new Membership(null, 0, 7),
		new Membership(null, 1, 0),
		new Membership(null, 1, 1),
		new Membership(null, 1, 2),		
		new Membership(null, 1, 4),
		new Membership(null, 2, 4),
		new Membership(null, 2, 3),
		new Membership(null, 2, 6),
		new Membership(null, 2, 0),
		new Membership(null, 3, 0),
		new Membership(null, 3, 1),	
		new Membership(null, 3, 5),
		new Membership(null, 3, 4),
		new Membership(null, 4, 7),
		new Membership(null, 4, 0),
		new Membership(null, 4, 1),
		new Membership(null, 4, 2),
		new Membership(null, 5, 0),
		new Membership(null, 5, 1),
		new Membership(null, 5, 3),
		new Membership(null, 5, 7),
		new Membership(null, 5, 6),
		new Membership(null, 5, 5)
	};
	
	private Map<Integer, Membership> storage;
	private int maxId;
	
	public MembershipDaoMockImpl(){
		storage = Collections.synchronizedMap(new HashMap<Integer, Membership>());
		maxId = -1;
		
		// Insert the sample teams into the database as this is a mock impl.
		insertMemberships(sampleMemberships);		
	}
	
	private void insertMemberships(Membership[] memberships) {
		for (Membership membership : memberships) {
			insertMembership(membership);
		}
	}
	
	@Override
	public void deleteMembership(Integer id) {
		storage.remove(id);
	}

	@Override
	public Collection<Membership> getAllMemberships() {
		return storage.values();
	}

	@Override
	public Membership getMembershipById(Integer membershipId) {
		return new Membership(storage.get(membershipId));
	}

	@Override
	public Collection<Membership> getMembershipsByTeam(Integer teamId) {
		Set<Membership> result = new HashSet<Membership>();
		
		for (Membership m : storage.values()){
			if (m.getTeamId() == teamId) result.add(m);
		}
		return result;
	}

	@Override
	public Collection<Membership> getMembershipsByUser(Integer userId) {
		Set<Membership> result = new HashSet<Membership>();
		
		for (Membership m : storage.values()){
			if (m.getUserId() == userId) result.add(m);
		}
		return result;
	}

	@Override
	public Integer insertMembership(Membership membership) {
		Integer id = ++maxId;
		
		membership.setMembershipId(id);
		updateMembership(membership);
		
		return id;
	}

	@Override
	public void updateMembership(Membership membership) {
		storage.put(membership.getMembershipId(), membership);
		
	}

}
