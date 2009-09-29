package com.playserengeti.service;

import com.playserengeti.domain.Location;

/**
 * Service for operations related to location.
 */
public class LocationService {

    // TODO: private LocationDao LocationDao;

    public LocationService(/* LocationDao LocationDao */) {
        // TODO: this.LocationDao = LocationDao;
    }

    public Location getLocationId(Integer id) {
        // TODO: return LocationDao.getLocationById(id);
        return null;
    }

    /**
     * Writes the given location to persistent storage. If the given location has a null
     * id, a location is created in persistent storage. If the id is not null, and a
     * location with that id exists, the location in persistent storage will be updated
     * with the fields in the argument. If the id is not null, but no such location
     * with that id exists, then throws some kind of exception. (TODO)
     */
    public void saveLocation(Location location) {
        // TODO: LocationDao.saveLocation(location);
    }

    /**
     * Deletes the location with the given id from persistent storage. If no such
     * location exists, throws an IllegalArgumentException.
     */
    public void deleteLocation(Integer id) {
        // TODO: LocationDao.deleteLocation(id);
    }
}

