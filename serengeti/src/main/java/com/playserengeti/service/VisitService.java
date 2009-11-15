package com.playserengeti.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.playserengeti.dao.LocationDao;
import com.playserengeti.dao.TeamDao;
import com.playserengeti.dao.UserDao;
import com.playserengeti.dao.VisitDao;
import com.playserengeti.domain.Team;
import com.playserengeti.domain.Visit;


/**
 * Service for operations related to users.
 */
public class VisitService {

	private VisitDao visitDao;
	private UserDao userDao;
	private LocationDao locationDao;
	private TeamDao teamDao;

	public VisitService(VisitDao visitDao, UserDao userDao, LocationDao locationDao, TeamDao teamDao)  {
	    this.visitDao = visitDao;
	    this.userDao = userDao;
	    this.locationDao = locationDao;
	    this.teamDao = teamDao;
	}

	public Visit getVisitByVisitId(Integer visitId) {
		return visitDao.getVisitByVisitId(visitId);
	}
	
	public Collection<Visit> getVisitsByTeamAndLocation(Integer teamId, Integer locationId) {
		Set<Visit> result = new HashSet<Visit>();
		Collection<Visit> visits = visitDao.getVisitByLocationId(locationId);
		
		for (Visit v : visits) {
			if(v.getTeamId().equals(teamId)) result.add(v);
		}
		
		return result;
	}

	/**
	 * Writes the given visit to persistent storage.  If the given
	 * visit has a null id, a visit is created in persistent storage.
	 * If the id is not null, and a visit with that id exists, the
	 * visit in persistent storage will be updated with the fields in
	 * the argument.  If the id is not null, but no such visit with that
	 * id exists, then throws some kind of exception.  (TODO)
	 * @throws NoSuchFieldException
	 */
	public void saveVisit(Visit visit) throws NoSuchFieldException {
		validateVisit(visit);
		if (visit.getId() == null) {
			visitDao.insertVisit(visit);
		} else {
			visitDao.updateVisit(visit);
		}
	}

	/**
	 * Deletes the visit with the given id from persistent storage.  If no
	 * such visit exists, throws an IllegalArgumentException.
	 */
	//Is there ever a case where a visit record needs to be deleted?
	public void deleteVisit(Integer visitId) {
	    visitDao.deleteVisit(visitId);
	}
	
	public void checkIn(Integer userId, Integer teamId, Integer locationId) {
		visitDao.insertVisit(new Visit(null, userId, teamId, locationId));
	}

	/**
	 * Fetches all the visits from persistent storage.
	 */
	public Collection<Visit> getAllVisits() {
		return visitDao.getAllVisits();
	}

	private void validateVisit(Visit visit) throws NoSuchFieldException{

		Integer userId = visit.getUserId();
		Integer locationId = visit.getLocationId();
		Integer teamId = visit.getTeamId();

		String message = "No such ";

		if(userDao.getUserById(userId) == null){
			message += "User Id " + userId + " Exists";
			throw new NoSuchFieldException(message);
		}
		if(locationDao.locationExists(locationId) == false){
			message += "Location Id " + locationId + " Exists";
			throw new NoSuchFieldException(message);
		}
		if(teamDao.getTeamById(teamId) == null){
			message += "Team Id " + teamId + " Exists";
			throw new NoSuchFieldException(message);
		}
		return;
	}
	
	public Collection<Team> getCompetingTeams(Integer locationId) {
		Set<Team> result = new HashSet<Team>();
		Collection<Visit> visits = visitDao.getVisitByLocationId(locationId);
		
		Team team;
		for(Visit v : visits) {
			team = teamDao.getTeamById(v.getTeamId());
			if (!result.contains(team)) result.add(team);
		}
		
		return result;
	}
	
	public Team getLeadingTeam(Integer locationId) {
		Collection<Team> teams = getCompetingTeams(locationId);
	    Team result = null;
	    for(Team t : teams) {
	    	if (result == null) result = t;
	    	else {
	    		if (getVisitsByTeamAndLocation(t.getId(), locationId).size() > 
	    			getVisitsByTeamAndLocation(result.getId(), locationId).size()) {
	    			result = t;
	    		}
	    	}
	    }
	    
	    return result;
	}
	
}