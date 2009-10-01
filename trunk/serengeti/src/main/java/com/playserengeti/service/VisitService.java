package com.playserengeti.service;

import java.util.Collection;

import com.playserengeti.dao.VisitDao;
import com.playserengeti.domain.Visit;

/**
 * Service for operations related to users.
 */
public class VisitService {

	private VisitDao visitDao;

	public VisitService(VisitDao visitDao) {
	    this.visitDao = visitDao;
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
	 */
	public void saveVisit(Visit visit) {
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
}
