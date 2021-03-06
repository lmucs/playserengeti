package com.playserengeti.dao;


// TODO Redo mock dao.

/**
 * A mock implementation of the User DAO that's backed by an id-keyed map.
 */
/*
public class VisitDaoMockImpl implements VisitDao {

	// Sample users to insert into the database.
	private static final Visit sampleVisits[] = {
		new Visit(null ,1, 1, 2),
		new Visit(null ,1, 2, 3),		
		new Visit(null, 2, 2, 4),
		new Visit(null ,3, 2, 1),	
		new Visit(null, 3, 5, 5),
		new Visit(null, 4, 3, 2),
		new Visit(null, 4, 3, 6),
		new Visit(null, 4, 6, 4),
		new Visit(null, 5, 2, 3),
		new Visit(null, 5, 3, 4),
		new Visit(null, 6, 4, 4),
		new Visit(null, 6, 6, 5),
		new Visit(null, 7, 3, 6),
		new Visit(null, 7, 6, 2),
		new Visit(null, 8, 1, 1),
		new Visit(null, 8, 5, 1),
		new Visit(null, 8, 6, 4),
		new Visit(null, 8, 5, 3)
	};

	private Map<Integer, Visit> storage;
	private int maxId;

	public VisitDaoMockImpl() {
		storage = Collections.synchronizedMap(new HashMap<Integer, Visit>());
		maxId = 0;

		// Insert the sample visits into the database as this is a mock impl.
		insertVisits(sampleVisits);
	}

	
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
	public void deleteVisit(Integer visitId) {
		storage.remove(visitId);
	}

	@Override
	public Collection<Visit> getAllVisits() {
		return new HashSet<Visit>(storage.values());
	}

	@Override
	public Visit getVisitById(Integer visitId) {
		return new Visit(storage.get(visitId));
	}

	@Override
	public Collection<Visit> getVisitByLocationId(Integer locationId) {
		Set<Visit> results = new HashSet<Visit>();

		for (Visit v : storage.values()) {
			if (v.getLocationId().equals(locationId)) {
				results.add(v);
			}
		}

		return results;	
    }

	@Override
	public Collection<Visit> getVisitsByUserId(Integer userId) {
		Set<Visit> results = new HashSet<Visit>();

		for (Visit v : storage.values()) {
			if (v.getUserId().equals(userId)) {
				results.add(v);
			}
		}

		return results;		
	}
	
	@Override
	public Collection<Visit> getVisitsByTeamId(Integer teamId) {
		Set<Visit> results = new HashSet<Visit>();

		for (Visit v : storage.values()) {
			if (v.getTeamId().equals(teamId)) {
				results.add(v);
			}
		}

		return results;		
	}

}
*/