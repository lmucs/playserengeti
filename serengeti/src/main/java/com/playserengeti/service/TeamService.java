package com.playserengeti.service;

import java.util.Collection;

import com.playserengeti.dao.TeamDao;
import com.playserengeti.domain.Avatar;
import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;

/**
 * Service for operations related to teams.
 */
public class TeamService {

	private TeamDao teamDao;

	/**
	 * Constructor. Sets the dao.
	 * 
	 * @param TeamDao
	 */
	public TeamService(TeamDao TeamDao) {
		this.teamDao = TeamDao;
	}

	/**
	 * Returns the team specified by the given id.
	 * 
	 * @param id
	 * @return
	 */
	public Team getTeamById(Integer id) {
		return teamDao.getTeamById(id);
	}

	/**
	 * Writes the given team to persistent storage. If the given team has a null
	 * id, a team is created in persistent storage. If the id is not null, and a
	 * team with that id exists, the team in persistent storage will be updated
	 * with the fields in the argument. If the id is not null, but no such team
	 * with that id exists, then throws some kind of exception. (TODO)
	 */
	public void saveTeam(Team team) {
		if (team.getId() == null) {
			Integer id = teamDao.insertTeam(team);
			Team persistedTeam = teamDao.getTeamById(id);
			team.setDateCreated(persistedTeam.getDateCreated());
		} else {
			teamDao.updateTeam(team);
		}
	}

	/**
	 * Deletes the team with the given id from persistent storage. If no such
	 * team exists, throws an IllegalArgumentException.
	 */
	public void deleteTeam(Integer id) {
		teamDao.deleteTeam(id);
	}

	/**
	 * Returns a collection of all teams in the database.
	 * 
	 * @return
	 */
	public Collection<Team> getAllTeams() {
		return teamDao.getAllTeams();
	}

	public Collection<User> getTeamMembers(Integer teamId) {
		return teamDao.getTeamMembers(teamId);
	}

	public String getTeamsJSON(Integer userId) {
		return asJSON(getUsersTeams(userId));
	}

	public Collection<Team> getTeamInvites(Integer userId) {
		return teamDao.getTeamInvites(userId);
	}

	public void sendTeamInvite(Integer teamId, Integer userId) {
		teamDao.sendTeamInvite(teamId, userId);
	}

	public void removeFromTeam(Integer teamId, Integer userId) {
		teamDao.removeMember(teamId, userId);
	}

	/**
	 * Returns a collection of teams as a JSON string array.
	 * 
	 * @param teams
	 * @return
	 */
	public String asJSON(Collection<Team> teams) {
		String result = "[";
		int count = teams.size();

		for (Team t : teams) {
			result += t.asMinimalJSON();
			if (count > 1) {
				result += ", ";
			}
			count--;
		}
		result += "]";
		return result;
	}

	public Collection<Team> getNewestTeams() {
		return teamDao.getNewestTeams();
	}

	public Collection<Team> getUsersTeams(Integer userId) {
		return teamDao.getUsersTeams(userId);
	}

	public Collection<Team> getMostActiveTeams() {
		return teamDao.getMostActiveTeams();
	}

	public Collection<Team> getLeadingTeams() {
		return teamDao.getLeadingTeams();
	}

	public Collection<Team> getInvitableTeams(Integer sourceId, Integer targetId) {
		return teamDao.getInvitableTeams(sourceId, targetId);
	}

	public void acceptTeamInvite(Integer teamId, Integer userId) {
		teamDao.acceptTeamInvite(teamId, userId);
	}

	public void rejectTeamInvite(Integer teamId, Integer userId) {
		teamDao.rejectTeamInvite(teamId, userId);
	}

	public Collection<Team> getTeamsLedByUser(Integer userId) {
		return teamDao.getTeamsLedByUser(userId);
	}

	public Collection<Team> searchTeams(String query) {
		return teamDao.searchTeams(query);
	}

	public Avatar getTeamAvatarByTeamId(Integer teamId) {
		return teamDao.getTeamAvatarByTeamId(teamId);
	}
}
