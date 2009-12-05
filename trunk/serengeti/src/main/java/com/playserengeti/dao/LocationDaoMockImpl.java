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

    @Override
	public Collection<Location> searchLocations(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Location> getControlledTerritory(Integer teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Location> getNearbyLocations(Double latitude,
			Double longitude) {
		// TODO Auto-generated method stub
		return null;
	}

	private static final Location sampleLocations[] = new Location[] {
            new Location(null, "Doolan Hall", 33.969326, -118.414387),
            new Location(null, "Viva Fresh", 33.959988, -118.416851),
            new Location(null, "LAX Airport", 33.946864, -118.401504),
            new Location(null, "Chris's House", 33.594681, -111.896031),
            new Location(null, "3rd Street Promenade", 34.015414, -118.491969),
            new Location(null, "ChickMagnetVille", 33.526151, -112.261047)
        };

    // Storage for the location objects
    private Map<Integer, Location> storage;
    private int maxId;

    public LocationDaoMockImpl() {
        storage = Collections.synchronizedMap(new HashMap<Integer, Location>());
        maxId = 0;

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
    public Location getLocationByName(String display) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Location getLocationById(Integer id) {
        return new Location(storage.get(id));
    }

    /**
     * A convenience method to insert an array of teams into the database.
     */
    private void insertLocations(Location[] locations) {
        for (Location location : locations) {
            insertLocation(location);
        }
    }

    @Override
    public void updateLocation(Location location) {
        storage.put(location.getId(), location);
    }

    @Override
    public Integer insertLocation(Location location) {
        Integer id = ++maxId;

        location.setId(id);
        updateLocation(location);

        return id;
    }

    @Override
    public boolean locationExists(Integer id){
        return (storage.get(id) != null);
    }
}
