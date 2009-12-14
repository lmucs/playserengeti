package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.Visit;

public interface VisitDao {

	/**
	 * Commit the visit to storage for the first time.
	 */
	public void insertVisit(Integer userId, Integer teamId, Integer locationId);

	public Integer insertVisit(Visit visit);

	/**
	 * Update a visit in storage. Is this even necessary? Is there a case where
	 * such a thing would be done?
	 */
	public void updateVisit(Visit visit);

	/**
	 * Delete a visit from storage. Is this even necessary? Is there a case
	 * where such a thing would be done?
	 */
	public void deleteVisit(Integer visitId);

	/**
	 * Get all visits from storage.
	 */
	public Collection<Visit> getAllVisits();

	/**
	 * Get a visit from storage by Id.
	 */
	public Visit getVisitById(Integer visitId);

	/**
	 * Get a history of visits from storage by userId.
	 */
	public Collection<Visit> getVisitsByUserId(Integer userId);

	/**
	 * Get a history of visits from storage by locationId.
	 */
	public Collection<Visit> getVisitByLocationId(Integer locationId);

	/**
	 * Gets all checkins by a given team's members.
	 * 
	 * @param teamId
	 * @return
	 */
	public Collection<Visit> getVisitsByTeamId(Integer teamId);

	/**
	 * Gets all the teams that have checked in to the given location.
	 * 
	 * @param locationId
	 * @return
	 */
	public Collection<Team> getTeamsThatVisitedLocationByLocationId(
			Integer locationId);

	/**
	 * Gets the most recent checkins of all users in Serengeti.
	 * 
	 * @return
	 */
	public Collection<Visit> getRecentCheckIns();

	/**
	 * Gets recent checkins made by a user's friends.
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<Visit> getFriendsRecentActivity(Integer userId);

	/**
	 * Gets the recent checkins of a given user.
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<Visit> getUsersRecentActivity(Integer userId);

	/**
	 * Gets the recent checkins of a given team's members.
	 * 
	 * @param teamId
	 * @return
	 */
	public Collection<Visit> getTeamsRecentActivity(Integer teamId);

	/**
	 * Gets a users most recent checkin.
	 * 
	 * @param userId
	 * @return
	 */
	public Visit getUsersMostRecentCheckin(Integer userId);
}
