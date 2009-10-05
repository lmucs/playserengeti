package com.playserengeti.service;

import java.util.Collection;

import com.playserengeti.dao.TeamDao;
import com.playserengeti.domain.Team;

/**
 * Service for operations related to teams.
 */
public class TeamService {

    private TeamDao teamDao;

    public TeamService(TeamDao TeamDao) {
        this.teamDao = TeamDao;
    }

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
			teamDao.insertTeam(team);
		} else {
			teamDao.updateTeam(team);
		}    }

    /**
     * Deletes the team with the given id from persistent storage. If no such
     * team exists, throws an IllegalArgumentException.
     */
    public void deleteTeam(Integer id) {
        teamDao.deleteTeam(id);
    }
    
    public Collection<Team> getAllTeams() {
    	return teamDao.getAllTeams();
    }
}
