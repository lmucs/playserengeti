package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.Membership;

public interface MembershipDao {

	public Integer insertMembership(Membership membership);
	
	public void updateMembership(Membership membership);
	
	public void deleteMembership(Integer id);
	
	public Collection<Membership> getAllMemberships();
	
	public Membership getMembershipById(Integer membershipId);
	
	public Collection<Membership> getMembershipsByTeam(Integer teamId);
	
	public Collection<Membership> getMembershipsByUser(Integer userId);
}
