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
		new Membership(null, 1, 1),
		new Membership(null, 1, 2),		
		new Membership(null, 1, 8),
		new Membership(null, 2, 1),
		new Membership(null, 2, 2),
		new Membership(null, 2, 3),		
		new Membership(null, 2, 5),
		new Membership(null, 3, 5),
		new Membership(null, 3, 4),
		new Membership(null, 3, 7),
		new Membership(null, 3, 1),
		new Membership(null, 4, 1),
		new Membership(null, 4, 2),	
		new Membership(null, 4, 6),
		new Membership(null, 4, 5),
		new Membership(null, 5, 8),
		new Membership(null, 5, 1),
		new Membership(null, 5, 2),
		new Membership(null, 5, 3),
		new Membership(null, 6, 1),
		new Membership(null, 6, 2),
		new Membership(null, 6, 4),
		new Membership(null, 6, 8),
		new Membership(null, 6, 7),
		new Membership(null, 6, 6)
	};
	
	private Map<Integer, Membership> storage;
	private int maxId;
	
	public MembershipDaoMockImpl(){
		storage = Collections.synchronizedMap(new HashMap<Integer, Membership>());
		maxId = 0;
		
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
			if (m.getTeamId().equals(teamId)) result.add(m);
		}
		return result;
	}

	@Override
	public Collection<Membership> getMembershipsByUser(Integer userId) {
		Set<Membership> result = new HashSet<Membership>();
		
		for (Membership m : storage.values()){
			if (m.getUserId().equals(userId)) result.add(m);
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
