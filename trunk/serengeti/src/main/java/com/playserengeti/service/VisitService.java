package com.playserengeti.service;

import java.util.Collection;

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

	public VisitService(VisitDao visitDao, UserDao userDao,
			LocationDao locationDao, TeamDao teamDao) {
		this.visitDao = visitDao;
		this.userDao = userDao;
		this.locationDao = locationDao;
		this.teamDao = teamDao;
	}

	public Visit getVisitByVisitId(Integer visitId) {
		return visitDao.getVisitById(visitId);
	}

	/**
	 * Writes the given visit to persistent storage. If the given visit has a
	 * null id, a visit is created in persistent storage. If the id is not null,
	 * and a visit with that id exists, the visit in persistent storage will be
	 * updated with the fields in the argument. If the id is not null, but no
	 * such visit with that id exists, then throws some kind of exception.
	 * (TODO)
	 * 
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
	 * Deletes the visit with the given id from persistent storage. If no such
	 * visit exists, throws an IllegalArgumentException.
	 */
	// Is there ever a case where a visit record needs to be deleted?
	public void deleteVisit(Integer visitId) {
		visitDao.deleteVisit(visitId);
	}

	/**
	 * Creates a visit for a user, on behalf of a team, at a location. Returns
	 * the visit as a JSON string and whether or not the checkin made the team
	 * the owner of the location.
	 * 
	 * @param userId
	 * @param teamId
	 * @param locationId
	 * @return
	 */
	public String checkIn(Integer userId, Integer teamId, Integer locationId) {
		visitDao.insertVisit(userId, teamId, locationId);
		return "{\"visit\" : "
				+ visitDao.getUsersMostRecentCheckin(userId).asJSON()
				+ ", \"overtaken\" : \""
				+ locationDao.updateOwningTeam(locationId) + "\"}";
	}

	/**
	 * Fetches all the visits from persistent storage.
	 */
	public Collection<Visit> getAllVisits() {
		return visitDao.getAllVisits();
	}

	/**
	 * Validates a visit to make sure the user, team, and locaiton exist.
	 * 
	 * @param visit
	 * @throws NoSuchFieldException
	 */
	private void validateVisit(Visit visit) throws NoSuchFieldException {

		Integer userId = visit.getUser().getId();
		Integer locationId = visit.getLocation().getId();
		Integer teamId = visit.getTeam().getId();

		String message = "No such ";

		if (userDao.getUserById(userId) == null) {
			message += "User Id " + userId + " Exists";
			throw new NoSuchFieldException(message);
		}
		if (locationDao.locationExists(locationId) == false) {
			message += "Location Id " + locationId + " Exists";
			throw new NoSuchFieldException(message);
		}
		if (teamDao.getTeamById(teamId) == null) {
			message += "Team Id " + teamId + " Exists";
			throw new NoSuchFieldException(message);
		}
		return;
	}

	public Collection<Team> getCompetingTeams(Integer locationId) {
		return visitDao.getTeamsThatVisitedLocationByLocationId(locationId);
	}

	public Collection<Visit> getRecentCheckIns() {
		return visitDao.getRecentCheckIns();
	}

	public Collection<Visit> getRecentFriendCheckIns(Integer userId) {
		return visitDao.getRecentFriendCheckIns(userId);
	}

	public Collection<Visit> getUsersRecentActivity(Integer userId) {
		return visitDao.getUsersRecentActivity(userId);
	}

	public Collection<Visit> getTeamsRecentActivity(Integer teamId) {
		return visitDao.getTeamsRecentActivity(teamId);
	}

	/**
	 * Returns a collection of visits as a JSON string array.
	 * 
	 * @param visits
	 * @return
	 */
	public String asJSON(Collection<Visit> visits) {
		String result = "[";
		int count = visits.size();

		for (Visit v : visits) {
			result += v.asJSON();
			if (count > 1) {
				result += ", ";
			}
			count--;
		}
		result += "]";
		return result;
	}
}