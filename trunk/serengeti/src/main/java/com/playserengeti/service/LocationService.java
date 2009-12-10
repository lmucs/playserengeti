package com.playserengeti.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.playserengeti.dao.LocationDao;
import com.playserengeti.domain.Location;

/**
 * Service for operations related to location.
 */
public class LocationService {

	private LocationDao locationDao;

    // TODO: private LocationDao LocationDao;

    public LocationService(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    public Location getLocationById(Integer id) {
        return locationDao.getLocationById(id);
    }
    
    public Location getLocationByName(String display) {
    	return locationDao.getLocationByName(display);
    }

    /**
     * Writes the given location to persistent storage. If the given location has a null
     * id, a location is created in persistent storage. If the id is not null, and a
     * location with that id exists, the location in persistent storage will be updated
     * with the fields in the argument. If the id is not null, but no such location
     * with that id exists, then throws some kind of exception. (TODO)
     */
    public Integer saveLocation(Location location) {
		if (location.getId() == null) {
			return locationDao.insertLocation(location);

		} else {
			locationDao.updateLocation(location);
			return location.getId();
		}
    }

    /**
     * Deletes the location with the given id from persistent storage. If no such
     * location exists, throws an IllegalArgumentException.
     */
    public void deleteLocation(Integer id) {
        locationDao.deleteLocation(id);
    }

    /**
     * Returns a collection of all locations in the database.
     * @return
     */
    public Collection<Location> getAllLocations() {
    	return locationDao.getAllLocations();
    }
    
    public Collection<Location> getNearbyLocations(Double latitude, Double longitude) {
    	return locationDao.getNearbyLocations(latitude, longitude);
    }
    
    public Collection<Location> getControlledTerritory(Integer teamId) {
    	return locationDao.getControlledTerritory(teamId);
    }
        
    public String asJSON(Collection<Location> locations) {
    	String result = "[";
    	int count = locations.size();
    	
    	for (Location l : locations) {
    		result += l.asJSON();
    	    if (count > 1) {
    	    	result += ", ";
    	    }
    	    count--;
    	}
    	result += "]";
    	return result;
    }
    
    public Collection<Location> searchLocations(String query) {
    	return locationDao.searchLocations(query);
    }
    
    public List<Double[]> convexHull(Collection<Location> locations) {
    	List<Double[]> result = new ArrayList<Double[]>();
    	List<Double[]> points = new ArrayList<Double[]>();
    	for (Location l : locations) {
    		points.add(new Double[]{l.getLatitude(), l.getLongitude()});
    	}

    	Double[] pointOnHull = (getLeftMost(points));
    	Double[] endPoint = null;
    	while (endPoint != result.get(0)) {
    		result.add(pointOnHull);
    		endPoint = points.get(0);
    		for (int i = 0; i < points.size(); i++) {
    			List<Double[]> line = new ArrayList<Double[]>();
    			line.add(result.get(result.size() - 1));
    			line.add(endPoint);
    			//if (onLeftOfLine(points.get(i), line)) {
    				//endPoint = points.get(i);
    			//}
    		}
    		pointOnHull = endPoint;
    	}
    	return result;
    }
    
    public boolean angleBetweenLines(Double[] a, Double[] b, Double[] c) {
    	
    	
    	
    	return false;
    }
    
    
    public Double[] getLeftMost(List<Double[]> points) {
    	Double[] result = points.get(0);
    
    	for (Double[] point : points) {
    		if (point[0] < result[0]) {
    			result = point;
    		}
    	}
    	return result;
    }
}

