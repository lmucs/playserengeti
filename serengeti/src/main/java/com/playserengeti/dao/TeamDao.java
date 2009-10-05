package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.Team;

public interface TeamDao {
	
	/**
	 * Create a new team.
	 * 
	 * @param team team to commit
	 * @return the team id of the newly inserted team
	 */
	public Integer insertTeam(Team team);
	
	/**
	 * Update the team in storage.
	 * 
	 * @param team team to update
	 */
	public void updateTeam(Team team);
	
	/**
	 * Delete a team from storage.
	 * 
	 * @param id team id of the team to delete
	 */
	public void deleteTeam(Integer id);
	
	/**
	 * Get all teams from storage.
	 */
	public Collection<Team> getAllTeams();
	
	/**
	 * Get a team from storage.
	 * 
	 * @param id team id of the team to fetch
	 * @return the fetched team or null if none exist with that id
	 */
	public Team getTeamById(Integer id);
	
	/**
	 * Get a team from storage.
	 * 
	 * @param team team name
	 * @return the fetched team
	 */
	public Collection<Team> getTeamsByTeamName(String display);
}
