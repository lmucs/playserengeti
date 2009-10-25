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
    public void deleteLocation(Integer locationId) {
        storage.remove(locationId);
    }

    @Override
    public Collection<Location> getAllLocations() {
        return new HashSet<Location>(storage.values());
    }

    @Override
    public Location getLocationByLocationName(String location) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Location getLocationById(Integer locationId) {
        return new Location(storage.get(locationId));
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
        storage.put(location.getLocationId(), location);
    }

    @Override
    public Integer insertLocation(Location location) {
        Integer locationId = ++maxId;

        location.setLocationId(locationId);
        updateLocation(location);

        return locationId;
    }

    @Override
    public boolean locationExists(Integer locationId){
        return (storage.get(locationId) != null);
    }
}
