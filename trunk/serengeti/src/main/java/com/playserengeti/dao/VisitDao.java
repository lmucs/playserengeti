package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.Visit;

public interface VisitDao {

	/**
	 * Commit the visit to storage for the first time.
	 */
	public Integer insertVisit(Visit visit);

	/**
	 * Update a visit in storage.
	 * Is this even necessary? Is there a case where such a thing would be done?
	 */
	public void updateVisit(Visit visit);

	/**
	 * Delete a visit from storage.
	 * Is this even necessary? Is there a case where such a thing would be done?
	 */
	public void deleteVisit(Integer vistiId);

	/**
	 * Get all visits from storage.
	 */
	public Collection<Visit> getAllVisits();

	/**
	 * Get a visit from storage by Id.
	 */
	public Visit getVisitByVisitId(Integer visitId);

	/**
	 * Get a history of visits from storage by userId.
	 */
	public Collection<Visit> getVisitsByUserId(Integer userId);

	/**
	 * Get a history of visits from storage by locationId.
	 */
	public Collection<Visit> getVisitBylocationId(Integer locationId);
}
