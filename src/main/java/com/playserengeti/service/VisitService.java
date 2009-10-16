package com.playserengeti.service;

import java.util.Collection;

import com.playserengeti.dao.VisitDao;
import com.playserengeti.dao.UserDao;
import com.playserengeti.dao.LocationDao;

import com.playserengeti.domain.Visit;


/**
 * Service for operations related to users.
 */
public class VisitService {

	private VisitDao visitDao;
	private UserDao userDao;
	private LocationDao locationDao;

	public VisitService(VisitDao visitDao, UserDao userDao, LocationDao locationDao)  {
	    this.visitDao = visitDao;
	    this.userDao = userDao;
	    this.locationDao = locationDao;
	}

	public Visit getVisitByVisitId(Integer visitId) {
		return visitDao.getVisitByVisitId(visitId);
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

	/**
	 * Fetches all the visits from persistent storage.
	 */
	public Collection<Visit> getAllVisits() {
		return visitDao.getAllVisits();
	}

	private void validateVisit(Visit visit) throws NoSuchFieldException{

		Integer userId = visit.getUserId();
		Integer locationId = visit.getLocationId();

		String message = "No such ";

		if(userDao.userExists(userId) == false){
			message += "User Id " + userId + " Exists";
			throw new NoSuchFieldException(message);
		}
		if(locationDao.locationExists(locationId) == false){
			message += "Location Id " + locationId + " Exists";
			throw new NoSuchFieldException(message);
		}
		return;
	}

}
