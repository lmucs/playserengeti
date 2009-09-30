package com.playserengeti.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.playserengeti.domain.Team;

/**
 * A mock implementation of the Team DAO that's backed by an id-keyed map.
 */
public class TeamDaoMockImpl implements TeamDao {

	// Sample teams to insert into the database.
	private static final Team sampleTeams[] = {
		new Team(null, "UmpaLumpas", "umpa"),
		new Team(null, "Constipated Koalas", "koala"),
		new Team(null, "Raptors", "chillupa"),
		new Team(null, "Lions", "house cat"),
		new Team(null, "frivolous fliers", "DonQuiote"),
		new Team(null, "ChickMagnets", "mxchickmagnet86"),
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
		return new HashSet<Team>(storage.values());
	}

	@Override
	public Team getTeamByTeamName(String team) {
		throw new UnsupportedOperationException();
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
