package com.playserengeti.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.playserengeti.domain.Location;

public class LocationDaoIbatisImpl extends SqlMapClientDaoSupport implements
		LocationDao {

	@Override
	public void deleteLocation(Integer id) {
		getSqlMapClientTemplate().delete("deleteLocation", id);
	}

	@Override
	public Collection<Location> getAllLocations() {
		return (Collection<Location>)
			getSqlMapClientTemplate().queryForList("getAllLocations");
	}

	@Override
	public Location getLocationById(Integer id) {
		return (Location)getSqlMapClientTemplate().queryForObject(
				"getLocationById",
				id);
	}

	@Override
	public Location getLocationByName(String display) {
		return (Location)getSqlMapClientTemplate().queryForObject(
				"getLocationByName",
				display);
	}

	@Override
	public Integer insertLocation(Location location) {
		getSqlMapClientTemplate().insert(
				"insertLocation",
				location);
		return location.getId();
	}

	@Override
	public boolean locationExists(Integer id) {
		// TODO Make this more efficient or extract to Service.
		return getLocationById(id) != null;
	}

	@Override
	public void updateLocation(Location location) {
		getSqlMapClientTemplate().update("updateLocation", location);
	}
	
	@Override
	public Collection<Location> getNearbyLocations(Double latitude, Double longitude) {
	    Map<String, Double> parameterMap = new HashMap<String, Double>();
	    parameterMap.put("latitude", latitude);
	    parameterMap.put("longitude", longitude);
		return (List<Location>)getSqlMapClientTemplate().queryForList("getNearbyLocations", parameterMap);
	}
	
	@Override
	public Collection<Location> getControlledTerritory(Integer teamId) {
		return (Collection<Location>)getSqlMapClientTemplate().queryForList("getControlledTerritory", teamId);
	}
	
	@Override
	public Collection<Location> searchLocations(String query) {
		return (Collection<Location>)getSqlMapClientTemplate().queryForList("searchLocations", query);
	}
}
