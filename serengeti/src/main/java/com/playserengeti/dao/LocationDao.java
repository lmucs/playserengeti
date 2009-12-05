package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.Location;

public interface LocationDao {

	/**
	 * Create a new location.
	 *
	 * @param location to commit
	 * @return the location id of the newly inserted location
	 */
	public Integer insertLocation(Location location);

	/**
	 * Update the location in storage.
	 *
	 * @param location to update
	 */
	public void updateLocation(Location location);

	/**
	 * Delete a location from storage.
	 *
	 * @param id location id of the location to delete
	 */
	public void deleteLocation(Integer id);

	/**
	 * Get all locations from storage.
	 */
	public Collection<Location> getAllLocations();

	/**
	 * Get a location from storage.
	 *
	 * @param id location id of the location to fetch
	 * @return the fetched location or null if none exist with that id
	 */
	public Location getLocationById(Integer id);

	/**
	 * Get a location from storage.
	 *
	 * @param loc location name
	 * @return the fetched location
	 */
	public Location getLocationByName(String display);

	/*
	 * Check the existence of a locaitionId
	 */
	public boolean locationExists(Integer id);
	
	public Collection<Location> getNearbyLocations(Double latitude, Double longitude);

	public Collection<Location> getControlledTerritory(Integer teamId);
	
	public Collection<Location> searchLocations(String query);
}
