package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.playserengeti.domain.Location;

/**
 * A mock implementation of the Location DAO that's backed by an id-keyed map.
 */
public class LocationDaoMockImpl implements LocationDao {

	// Sample teams to insert into the database.
	private static final Location sampleLocations[] = {
		new Location(null, "Doolan Hall", 1.3819383, 2.4928394),
		new Location(null, "Viva Fresh", 3.3840183, 4.3892839),
		new Location(null, "LAX Airport", 5.382728, 1.28837392),
		new Location(null, "Chris's House", 1.2839282, 0.38371930),
		new Location(null, "3rd Street Promenade", 12.393028, 3.3948292),
		new Location(null, "ChickMagnetVille", 6.93838293, 6.93838469),
	};
	
	private Map<Integer, Location> storage;
	private int maxId;
	
	public LocationDaoMockImpl() {
		storage = Collections.synchronizedMap(new HashMap<Integer, Location>());
		maxId = -1;
		
		// Insert the sample locations into the database as this is a mock impl.
		insertLocations(sampleLocations);
	}
	
	@Override
	public void deleteLocation(Integer id) {
		storage.remove(id);
	}

	@Override
	public Collection<Location> getAllLocations() {
		return new HashSet<Location>(storage.values());
	}

	@Override
	public Location getLocationByLocationName(String loc) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Location getLocationById(Integer id) {
		return new Location(storage.get(id));
	}

	/**
	 * A convenience method to insert an array of teams into the database.
	 */
	private void insertLocations(Location[] teams) {
		for (Location team : teams) {
			insertLocation(team);
		}
	}
	
	
	public Integer insertLocation(Location loc) {
		Integer id = ++maxId;
		
		loc.setId(id);
		updateLocation(loc);
		
		return id;
	}
	
	@Override
	public void updateLocation(Location loc) {
		storage.put(loc.getId(), loc);
	}

	@Override
	public Integer insertLocaion(Location loc) {
		// TODO Auto-generated method stub
		return null;
	}


}

