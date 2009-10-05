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
	
	public TeamDaoMockImpl() {
		storage = Collections.synchronizedMap(new HashMap<Integer, Team>());
		maxId = -1;
		
		// Insert the sample teams into the database as this is a mock impl.
		insertTeams(sampleTeams);
	}
	
	@Override
	public void deleteTeam(Integer id) {
		storage.remove(id);
	}

	@Override
	public Collection<Team> getAllTeams() {
		return storage.values();
	}

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

	@Override
	public Team getTeamById(Integer id) {
		return new Team(storage.get(id));
	}

	/**
	 * A convenience method to insert an array of teams into the database.
	 */
	private void insertTeams(Team[] teams) {
		for (Team team : teams) {
			insertTeam(team);
		}
	}
	
	@Override
	public Integer insertTeam(Team team) {
		Integer id = ++maxId;
		
		team.setId(id);
		updateTeam(team);
		
		return id;
	}
	
	@Override
	public void updateTeam(Team team) {
		storage.put(team.getId(), team);
	}


}
