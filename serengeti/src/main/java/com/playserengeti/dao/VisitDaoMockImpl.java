package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.playserengeti.domain.Visit;

/**
 * A mock implementation of the User DAO that's backed by an id-keyed map.
 */
public class VisitDaoMockImpl implements VisitDao {

	// Sample users to insert into the database.
	private static final Visit sampleVisits[] = {
		new Visit(null ,3, 0),
		new Visit(null ,3, 1),
		new Visit(null ,0, 2),
		new Visit(null, 1, 3),
		new Visit(null, 2, 4),
		new Visit(null, 3, 0),
		new Visit(null ,4, 1),
		new Visit(null ,5, 2),
		new Visit(null ,6, 3)
	};

	private Map<Integer, Visit> storage;
	private int maxId;

	public VisitDaoMockImpl() {
		storage = Collections.synchronizedMap(new HashMap<Integer, Visit>());
		maxId = -1;

		// Insert the sample visits into the database as this is a mock impl.
		insertVisits(sampleVisits);
	}

	/**
	 * A convenience method to insert an array of visits into the database.
	 */
	private void insertVisits(Visit[] visits) {
		for (Visit visit : visits) {
			insertVisit(visit);
		}
	}

	@Override
	public Integer insertVisit(Visit visit) {
		Integer id = ++maxId;

		visit.setId(id);
		updateVisit(visit);

		return id;
	}

	@Override
	public void updateVisit(Visit visit) {
		storage.put(visit.getId(), visit);
	}

	@Override
	public void deleteVisit(Integer vistiId) {
		storage.remove(vistiId);
	}

	@Override
	public Collection<Visit> getAllVisits() {
		return new HashSet<Visit>(storage.values());
	}

	@Override
	public Visit getVisitByVisitId(Integer visitId) {
		return new Visit(storage.get(visitId));
	}

	@Override
	public Collection<Visit> getVisitByLocationId(Integer locationId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<Visit> getVisitsByUserId(Integer userId) {
		throw new UnsupportedOperationException();
	}

}
