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

    // Storage for the location objects
    private Map<Integer, Location> storage;
    private int maxId;

    private TeamDao teamDao;

    public LocationDaoMockImpl(TeamDao teamDao) {
        this.teamDao = teamDao;

        storage = Collections.synchronizedMap(new HashMap<Integer, Location>());
        maxId = -1;

        Location[] sampleLocations = new Location[] {
            new Location(null, "Doolan Hall", 1.3819383, 2.4928394, teamDao.getTeamById(2)),
            new Location(null, "Viva Fresh", 3.3840183, 4.3892839, teamDao.getTeamById(1)),
            new Location(null, "LAX Airport", 5.382728, 1.28837392, teamDao.getTeamById(2)),
            new Location(null, "Chris's House", 1.2839282, 0.38371930, teamDao.getTeamById(1)),
            new Location(null, "3rd Street Promenade", 12.393028, 3.3948292, teamDao.getTeamById(0)),
            new Location(null, "ChickMagnetVille", 6.93838293, 6.93838469, teamDao.getTeamById(2)),
        };

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
