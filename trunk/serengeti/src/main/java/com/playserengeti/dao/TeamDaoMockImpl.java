package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;

/**
 * A mock implementation of the Team DAO that's backed by an id-keyed map.
 */
public class TeamDaoMockImpl implements TeamDao {

	@Override
	public boolean acceptTeamInvite(Integer teamId, Integer userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectTeamInvite(Integer teamId, Integer userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Team> getLeadingTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Team> getMostActiveTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Team> getNewestTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Team> getTeamInvites(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> getTeamMembers(Integer teamId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Team> getUsersTeams(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	// Sample teams to insert into the database.
	private static final Team sampleTeams[] = {
		new Team(null, "UmpaLumpas", "Green"),
		new Team(null, "Constipated Koalas", "Gray"),
		new Team(null, "Raptors", "Red"),
		new Team(null, "Lions", "Gold"),
		new Team(null, "frivolous fliers", "Orange"),
		new Team(null, "ChickMagnets", "Money")
	};
	
	private Map<Integer, Team> storage;
	private int maxId;
	
	/**
	 * Sets the storage map and id counter.  Inserts the sample teams into the 
	 * database.
	 */
	public TeamDaoMockImpl() {
		storage = Collections.synchronizedMap(new HashMap<Integer, Team>());
		maxId = 0;
		
		// Insert the sample teams into the database as this is a mock impl.
		insertTeams(sampleTeams);
	}
	
	/**
	 * Removes a team specified by the given id from the database.
	 */
	@Override
	public boolean deleteTeam(Integer id) {
		return storage.remove(id) != null;
	}

	/**
	 * Returns a collection of all teams in the database.
	 */
	@Override
	public Collection<Team> getAllTeams() {
		return storage.values();
	}

	/**
	 * Returns a team who's name matches the given string.
	 */
	@Override
	public Team getTeamByTeamName(String display) {
		for (Team team : storage.values()) {
			if (team.getName().equals(display)) {
				return team;
			}
		}
		return null;
	}

	/**
	 * Returns the team specified by the given id.
	 */
	@Override
	public Team getTeamById(Integer id) {
		return storage.get(id);
	}

	/**
	 * A convenience method to insert an array of teams into the database.
	 */
	private void insertTeams(Team[] teams) {
		for (Team team : teams) {
			insertTeam(team);
		}
	}
	
	/**
	 * Inserts the given team into the database with a unique id.
	 */
	@Override
	public Integer insertTeam(Team team) {
		Integer id = ++maxId;
		
		team.setId(id);
		updateTeam(team);
		
		return id;
	}
	
	/**
	 * Updates the corresponding team in the database with the one given.
	 */
	@Override
	public boolean updateTeam(Team team) {
		storage.put(team.getId(), team);
		return true;
	}

	public boolean teamExists(Integer teamId) {
		return (storage.get(teamId) != null);
	}
}
