package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.playserengeti.domain.Team;

/**
 * A mock implementation of the Team DAO that's backed by an id-keyed map.
 */
public class TeamDaoMockImpl implements TeamDao {

	// Sample teams to insert into the database.
	private static final Team sampleTeams[] = {
		new Team(null, "UmpaLumpas", "Green"),
		new Team(null, "Constipated Koalas", "Gray"),
		new Team(null, "Raptors", "Red"),
		new Team(null, "Lions", "Gold"),
		new Team(null, "frivolous fliers", "Orange"),
		new Team(null, "ChickMagnets", "Money"),
	};
	
	private Map<Integer, Team> storage;
	private int maxId;
	
	/**
	 * Sets the storage map and id counter.  Inserts the sample teams into the 
	 * database.
	 */
	public TeamDaoMockImpl() {
		storage = Collections.synchronizedMap(new HashMap<Integer, Team>());
		maxId = -1;
		
		// Insert the sample teams into the database as this is a mock impl.
		insertTeams(sampleTeams);
	}
	
	/**
	 * Removes a team specified by the given id from the database.
	 */
	@Override
	public void deleteTeam(Integer id) {
		storage.remove(id);
	}

	/**
	 * Returns a collection of all teams in the database.
	 */
	@Override
	public Collection<Team> getAllTeams() {
		return storage.values();
	}

	/**
	 * Returns a collection of teams who's name match the given string.  
	 * Must return collection because currently duplicate team names are 
	 * allowed.
	 */
	@Override
	public Collection<Team> getTeamsByTeamName(String display) {
		Set<Team> results = new HashSet<Team>();
		
		for (Team team : storage.values()) {
			if (team.getName().equals(display)) {
				results.add(team);
			}
		}
		
		return results;
	}

	/**
	 * Returns the team specified by the given id.  Returns a 
	 * defensive copy.
	 */
	@Override
	public Team getTeamById(Integer id) {
		Team orig = storage.get(id);
		Team copy = new Team(storage.get(id));
		copy.setLeaderId(orig.getLeaderId());
		copy.setHomeLocation(orig.getHomeLocation());
		copy.setImage(orig.getImage());
		
		return copy;
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
	public void updateTeam(Team team) {
		storage.put(team.getId(), team);
	}


}
