package com.playserengeti.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.playserengeti.dao.MembershipDao;
import com.playserengeti.dao.TeamDao;
import com.playserengeti.domain.Membership;
import com.playserengeti.domain.Team;

/**
 * Service for operations related to teams.
 */
public class TeamService {

    private TeamDao teamDao;
    private MembershipDao membershipDao;

    /**
     * Constructor.  Sets the dao.
     * @param TeamDao
     */
    public TeamService(TeamDao TeamDao, MembershipDao membershipDao) {
        this.teamDao = TeamDao;
        this.membershipDao = membershipDao;
    }

    /**
     * Returns the team specified by the given id.
     * @param id
     * @return
     */
    public Team getTeamById(Integer id) {
        return teamDao.getTeamById(id);
    }

    /**
     * Writes the given team to persistent storage. If the given team has a null
     * id, a team is created in persistent storage. If the id is not null, and a
     * team with that id exists, the team in persistent storage will be updated
     * with the fields in the argument. If the id is not null, but no such team
     * with that id exists, then throws some kind of exception. (TODO)
     */
    public void saveTeam(Team team) {
		if (team.getId() == null) {
			Integer id = teamDao.insertTeam(team);
			Team persistedTeam = teamDao.getTeamById(id);
			team.setDateCreated(persistedTeam.getDateCreated());
		} else {
			teamDao.updateTeam(team);
		}
    }

    /**
     * Deletes the team with the given id from persistent storage. If no such
     * team exists, throws an IllegalArgumentException.
     */
    public void deleteTeam(Integer id) {
        teamDao.deleteTeam(id);
    }
    
    /**
     * Returns a collection of all teams in the database.
     * @return
     */
    public Collection<Team> getAllTeams() {
    	return teamDao.getAllTeams();
    }
    
    public Map<Integer, String> getAllTeamsMap() {
    	Map<Integer, String> result = new HashMap<Integer, String>();
    	Collection<Team> teams = teamDao.getAllTeams();
    	
    	for (Team t : teams) {
    		result.put(t.getId(), t.getName());
    	}
    	
    	return result;
    }
    
    public void saveMembership(Membership m) {
    	if(m.getMembershipId() == null) {
    		membershipDao.insertMembership(m);
    	}
    	else {
    		membershipDao.updateMembership(m);
    	}
    }
    
    public void deleteMembership(Integer id) {
    	membershipDao.deleteMembership(id);
    }
    
    public Collection<Membership> getAllMemberships() {
    	return membershipDao.getAllMemberships();
    }
    
    public Membership getMembershipById(Integer id) {
    	return membershipDao.getMembershipById(id);
    }
    
    public Collection<Membership> getMembershipsByTeam(Integer id) {
    	return membershipDao.getMembershipsByTeam(id);
    }
    
    public Collection<Membership> getMembershipsByUser(Integer id) {
    	return membershipDao.getMembershipsByUser(id);
    }
    
    public Membership getMembershipByTeamAndUser(Integer teamId, Integer userId) {
    	Collection<Membership> mem = membershipDao.getMembershipsByTeam(teamId);
    	
    	for(Membership m : mem) {
    		if(m.getUserId().equals(userId)) return m;
    	}
    	
    	return null;
    }
    
    public Collection<Integer> getTeamMembers(Integer teamId) {
    	Set<Integer> result = new HashSet<Integer>();
    	Collection<Membership> mem = membershipDao.getMembershipsByTeam(teamId);
    	
    	for (Membership m : mem) {
    		if (m.getStatus().equals("accepted")) {
                result.add(m.getUserId());
    		}
    	}    	
    	
    	return result;
    }
    
    public Map<Integer, String> getTeamsMap(Integer userId) {
    	Map<Integer, String> result = new HashMap<Integer, String>();
    	Collection<Team> teams = getTeams(userId);
    	
    	for (Team t : teams) {
    		result.put(t.getId(), t.getName());
    	}
    	
    	return result;
    }
    
    public Collection<Team> getTeams(Integer userId) {
    	Set<Team> result = new HashSet<Team>();
    	Collection<Membership> mem = membershipDao.getMembershipsByUser(userId);
    	
    	for (Membership m : mem) {
    		if (m.getStatus().equals("accepted")) result.add(getTeamById(m.getTeamId()));
    	}
    	
    	return result;
    }
    
    public String getTeamsJSON(Integer userId) {
    	return asJSON(getTeams(userId));
    }
    
    public Collection<Team> getTeamInvites(Integer userId) {
    	Set<Team> result = new HashSet<Team>();
    	Collection<Membership> mem = membershipDao.getMembershipsByUser(userId);
    	
    	for (Membership m : mem) {
    		if (m.getStatus().equals("pending")) result.add(teamDao.getTeamById(m.getTeamId()));
    	}
    	
    	return result;
    }
    
    public void addToTeam(Integer teamId, Integer userId) {
    	Membership m = new Membership(null, teamId, userId);
    	m.setStatus("accepted");
    	saveMembership(m);
    }
    
    public void inviteToTeam(Integer teamId, Integer userId) {
        saveMembership(new Membership(null, teamId, userId));        
    }
    
    public void acceptTeamInvite(Integer teamId, Integer userId) {
        Membership m = getMembershipByTeamAndUser(teamId, userId);
        m.setStatus("accepted");
        saveMembership(m);
    }
    
    public void rejectTeamInvite(Integer teamId, Integer userId) {
        Membership m = getMembershipByTeamAndUser(teamId, userId);
        m.setStatus("rejected");
        saveMembership(m);
    }
    
    public void removeFromTeam(Integer teamId, Integer userId) {
    	Membership m = getMembershipByTeamAndUser(teamId, userId);
    	membershipDao.deleteMembership(m.getMembershipId());
    }
    
    public String asJSON(Collection<Team> teams) {
    	String result = "[";
    	int count = teams.size();
    	
    	for (Team t : teams) {
    		result += t.asMinimalJSON();
    	    if (count > 1) {
    	    	result += ", ";
    	    }
    	    count--;
    	}
    	result += "]";
    	return result;
    }
    
    //TODO
    public Collection<Team> getNewestTeams(int bound) {
        return null;
    }
}
