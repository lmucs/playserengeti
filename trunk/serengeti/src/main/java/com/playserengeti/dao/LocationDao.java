package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.Location;

public interface LocationDao {

	/**
	 * Create a new location.
	 * 
	 * @param location
	 *            to commit
	 * @return the location id of the newly inserted location
	 */
	public Integer insertLocation(Location location);

	/**
	 * Update the location in storage.
	 * 
	 * @param location
	 *            to update
	 */
	public void updateLocation(Location location);

	/**
	 * Delete a location from storage.
	 * 
	 * @param id
	 *            location id of the location to delete
	 */
	public void deleteLocation(Integer id);

	/**
	 * Get all locations from storage.
	 */
	public Collection<Location> getAllLocations();

	/**
	 * Get a location from storage.
	 * 
	 * @param id
	 *            location id of the location to fetch
	 * @return the fetched location or null if none exist with that id
	 */
	public Location getLocationById(Integer id);

	/**
	 * Get a location from storage.
	 * 
	 * @param loc
	 *            location name
	 * @return the fetched location
	 */
	public Location getLocationByName(String display);

	/**
	 * Gets a location based on it's name and lat long coordinates.
	 * @param display
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	public Location getLocationByLatLngAndName (String display, Double latitude, Double longitude);

	/*
	 * Check the existence of a locaitionId
	 */
	public boolean locationExists(Integer id);

	/**
	 * Get locations that are near the given latitude and longitude.
	 * 
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	public Collection<Location> getNearbyLocations(Double latitude,
			Double longitude);

	/**
	 * Get locations that are owned by the given team.
	 * 
	 * @param teamId
	 * @return
	 */
	public Collection<Location> getControlledTerritory(Integer teamId);

	/**
	 * Search locations based on a string.
	 * 
	 * @param query
	 * @return
	 */
	public Collection<Location> searchLocations(String query);

	/**
	 * Checks each team's score at a location and updates the owner accordingly.
	 * 
	 * @param locationId
	 * @return
	 */
	public boolean updateOwningTeam(Integer locationId);
}
