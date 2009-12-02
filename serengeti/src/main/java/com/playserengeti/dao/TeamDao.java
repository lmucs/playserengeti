package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;

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
	public boolean updateTeam(Team team);
	
	/**
	 * Delete a team from storage.
	 * 
	 * @param id team id of the team to delete
	 */
	public boolean deleteTeam(Integer id);
	
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
	public Team getTeamByTeamName(String display);
	
	/**
	 * Get all of the given teams members.
	 * @param teamId
	 * @return
	 */
	public Collection<User> getTeamMembers(Integer teamId);
	
	/**
	 * Get all of the given user's teams.
	 * @param userId
	 * @return
	 */
	public Collection<Team> getUsersTeams(Integer userId);
	
	/**
	 * Get all of the given user's team invites.
	 * @param userId
	 * @return
	 */
	public Collection<Team> getTeamInvites(Integer userId);
	
	/**
	 * Get the teams that were created most recently.
	 * @return
	 */
	public Collection<Team> getNewestTeams();
	
	/**
	 * Get the teams that have had the most activity within the 
	 * past week.
	 * @return
	 */
	public Collection<Team> getMostActiveTeams();
	
	/**
	 * Get the teams that control the most territory.
	 * @return
	 */
	public Collection<Team> getLeadingTeams();
	
	public boolean acceptTeamInvite(Integer teamId, Integer userId);
	
	public boolean rejectTeamInvite(Integer teamId, Integer userId);
	
	public Collection<Team> getInvitableTeams(Integer sourceId, Integer targetId);
}

