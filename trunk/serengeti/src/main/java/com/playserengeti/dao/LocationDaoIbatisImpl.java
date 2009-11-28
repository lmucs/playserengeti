package com.playserengeti.dao;

import java.util.Collection;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.playserengeti.domain.Location;
import com.playserengeti.domain.Team;

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
	public Location getLocationByLocationName(String location) {
		return (Location)getSqlMapClientTemplate().queryForObject(
				"getLocationByName",
				location);
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
	
}
