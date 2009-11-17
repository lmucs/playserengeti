package com.playserengeti.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.playserengeti.domain.Team;

public class TeamDaoIbatisImpl extends SqlMapClientDaoSupport implements
		TeamDao {

	@Override
	public boolean deleteTeam(Integer id) {
		return getSqlMapClientTemplate().delete("deleteTeam", id) > 0;
	}

	@Override
	public Collection<Team> getAllTeams() {
		return (List<Team>)getSqlMapClientTemplate().queryForList("getAllTeams");
	}

	@Override
	public Team getTeamById(Integer id) {
		return (Team)getSqlMapClientTemplate().queryForObject(
				"getTeamById",
				id);
	}

	@Override
	public Team getTeamByTeamName(String name) {
		return (Team)getSqlMapClientTemplate().queryForObject(
				"getUserByName",
				name);
	}

	@Override
	public Integer insertTeam(Team team) {
		getSqlMapClientTemplate().insert(
				"insertTeam",
				team);
		return team.getId();
	}

	@Override
	public boolean updateTeam(Team team) {
		return getSqlMapClientTemplate().update("updateTeam", team) > 0;
	}

}
