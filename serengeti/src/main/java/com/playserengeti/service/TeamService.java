package com.playserengeti.service;

import com.playserengeti.domain.Team;

/**
 * Service for operations related to teams.
 */
public class TeamService {

    // TODO: private TeamDao TeamDao;

    public TeamService(/* TeamDao TeamDao */) {
        // TODO: this.TeamDao = TeamDao;
    }

    public Team getTeamById(Integer id) {
        // TODO: return TeamDao.getTeamById(id);
        return null;
    }

    /**
     * Writes the given team to persistent storage. If the given team has a null
     * id, a team is created in persistent storage. If the id is not null, and a
     * team with that id exists, the team in persistent storage will be updated
     * with the fields in the argument. If the id is not null, but no such team
     * with that id exists, then throws some kind of exception. (TODO)
     */
    public void saveTeam(Team team) {
        // TODO: TeamDao.saveTeam(team);
    }

    /**
     * Deletes the team with the given id from persistent storage. If no such
     * team exists, throws an IllegalArgumentException.
     */
    public void deleteTeam(Integer id) {
        // TODO: TeamDao.deleteTeam(id);
    }
}
