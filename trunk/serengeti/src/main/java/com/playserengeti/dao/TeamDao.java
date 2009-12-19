package com.playserengeti.dao;

import java.util.Collection;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;

public interface TeamDao {

	/**
	 * Create a new team.
	 * 
	 * @param team
	 *            team to commit
	 * @return the team id of the newly inserted team
	 */
	public Integer insertTeam(Team team);

	/**
	 * Update the team in storage.
	 * 
	 * @param team
	 *            team to update
	 */
	public boolean updateTeam(Team team);

	/**
	 * Delete a team from storage.
	 * 
	 * @param id
	 *            team id of the team to delete
	 */
	public boolean deleteTeam(Integer id);

	/**
	 * Get all teams from storage.
	 */
	public Collection<Team> getAllTeams();

	/**
	 * Get a team from storage.
	 * 
	 * @param id
	 *            team id of the team to fetch
	 * @return the fetched team or null if none exist with that id
	 */
	public Team getTeamById(Integer id);

	/**
	 * Get a team from storage.
	 * 
	 * @param team
	 *            team name
	 * @return the fetched team
	 */
	public Team getTeamByTeamName(String display);

	/**
	 * Get all of the given teams members.
	 * 
	 * @param teamId
	 * @return
	 */
	public Collection<User> getTeamMembers(Integer teamId);

	/**
	 * Get all of the given user's teams.
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<Team> getUsersTeams(Integer userId);

	/**
	 * Get all of the given user's team invites.
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<Team> getTeamInvites(Integer userId);

	/**
	 * Get the teams that were created most recently.
	 * 
	 * @return
	 */
	public Collection<Team> getNewestTeams();

	/**
	 * Get the teams that have had the most activity within the past week.
	 * 
	 * @return
	 */
	public Collection<Team> getMostActiveTeams();

	/**
	 * Get the teams that control the most territory.
	 * 
	 * @return
	 */
	public Collection<Team> getLeadingTeams();

	/**
	 * Accepts an invitation for the given user to join the given team.
	 * 
	 * @param teamId
	 * @param userId
	 * @return
	 */
	public boolean acceptTeamInvite(Integer teamId, Integer userId);

	/**
	 * Rejects the invitation for the given user to join the given team.
	 * 
	 * @param teamId
	 * @param userId
	 * @return
	 */
	public boolean rejectTeamInvite(Integer teamId, Integer userId);

	/**
	 * Gets a list of teams that the user specified by sourceId is a member of
	 * which the user specified by targetId is not a member of or has an open
	 * invitation to.
	 * 
	 * @param sourceId
	 * @param targetId
	 * @return
	 */
	public Collection<Team> getInvitableTeams(Integer sourceId, Integer targetId);

	/**
	 * Sends an invitation for the given user to join the given team.
	 * 
	 * @param teamId
	 * @param userId
	 */
	public void sendTeamInvite(Integer teamId, Integer userId);

	/**
	 * Removes a team member.
	 * 
	 * @param teamId
	 * @param userId
	 * @return
	 */
	public boolean removeMember(Integer teamId, Integer userId);

	/**
	 * Gets all team that the given user is the leader of.
	 * 
	 * @param userId
	 * @return
	 */
	public Collection<Team> getTeamsLedByUser(Integer userId);

	/**
	 * Searches teams based on a given string.
	 * 
	 * @param query
	 * @return
	 */
	public Collection<Team> searchTeams(String query);
}
