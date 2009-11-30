package com.playserengeti.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;

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
	
	@Override
    public Collection<User> getTeamMembers(Integer teamId) {
		return (List<User>)getSqlMapClientTemplate().queryForList("getTeamMembers", teamId);
	}
	
	@Override
	public Collection<Team> getUsersTeams(Integer userId) {
		return (List<Team>)getSqlMapClientTemplate().queryForList("getUsersTeams", userId);
	}

	@Override
	public Collection<Team> getTeamInvites(Integer userId) {
		return (List<Team>)getSqlMapClientTemplate().queryForList("getTeamInvites", userId);
	}
	
	@Override
	public Collection<Team> getNewestTeams() {
		return (List<Team>)getSqlMapClientTemplate().queryForList("getNewestTeams");
	}
	
	@Override
	public Collection<Team> getMostActiveTeams() {
		return (List<Team>)getSqlMapClientTemplate().queryForList("getMostActiveTeams");
	}
	
	@Override
	public Collection<Team> getLeadingTeams() {
		return (List<Team>)getSqlMapClientTemplate().queryForList("getLeadingTeams");
	}
	
	@Override
	public boolean acceptTeamInvite(Integer teamId, Integer userId) {
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("teamId", teamId);
		parameterMap.put("userId", userId);
		return getSqlMapClientTemplate().update("acceptTeamInvite", parameterMap) > 0;
	}
	
	@Override
	public boolean rejectTeamInvite(Integer teamId, Integer userId) {
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("teamId", teamId);
		parameterMap.put("userId", userId);
		return getSqlMapClientTemplate().update("rejectTeamInvite", parameterMap) > 0;
	}
}
