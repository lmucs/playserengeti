package com.playserengeti.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.Visit;

/**
 * An ibatis implementation of visit dao. Calls upon sql queries.
 * 
 * @author Chris
 * 
 */
public class VisitDaoIbatisImpl extends SqlMapClientDaoSupport implements
		VisitDao {

	@Override
	public void deleteVisit(Integer visitId) {
		getSqlMapClientTemplate().delete("deleteVisit", visitId);
	}

	@Override
	public Collection<Visit> getAllVisits() {
		return (Collection<Visit>) getSqlMapClientTemplate().queryForList(
				"getAllVisits");
	}

	@Override
	public Visit getVisitById(Integer visitId) {
		return (Visit) getSqlMapClientTemplate().queryForObject("getVisitById",
				visitId);
	}

	@Override
	public Collection<Visit> getVisitByLocationId(Integer locationId) {
		return (Collection<Visit>) getSqlMapClientTemplate().queryForList(
				"getVisitsByLocationId", locationId);
	}

	@Override
	public Collection<Visit> getVisitsByTeamId(Integer teamId) {
		return (Collection<Visit>) getSqlMapClientTemplate().queryForList(
				"getVisitsByTeamId", teamId);
	}

	@Override
	public Collection<Visit> getVisitsByUserId(Integer userId) {
		return (Collection<Visit>) getSqlMapClientTemplate().queryForList(
				"getVisitsByUserId", userId);
	}

	@Override
	public void insertVisit(Integer userId, Integer teamId, Integer locationId) {
		Map<String, Object> pmap = new HashMap<String, Object>();
		pmap.put("userId", userId);
		pmap.put("teamId", teamId);
		pmap.put("locationId", locationId);
		getSqlMapClientTemplate().insert("insertVisitByIds", pmap);
	}

	@Override
	public Integer insertVisit(Visit visit) {
		Integer id = (Integer) getSqlMapClientTemplate().insert("insertVisit",
				visit);
		visit.setDate(((Visit) getSqlMapClientTemplate().queryForObject(
				"getLocationById", visit.getId())).getDate());
		return id;
	}

	@Override
	public void updateVisit(Visit visit) {
		getSqlMapClientTemplate().update("updateVisit", visit);
	}

	@Override
	public Collection<Team> getTeamsThatVisitedLocationByLocationId(
			Integer locationId) {
		return (Collection<Team>) getSqlMapClientTemplate().queryForList(
				"getTeamsThatVisitedLocationByLocationId", locationId);
	}

	@Override
	public Collection<Visit> getRecentCheckIns() {
		return (Collection<Visit>) getSqlMapClientTemplate().queryForList(
				"getRecentCheckIns");
	}

	@Override
	public Collection<Visit> getRecentFriendCheckIns(Integer userId) {
		return (Collection<Visit>) getSqlMapClientTemplate().queryForList(
				"getRecentFriendCheckIns", userId);
	}

	@Override
	public Collection<Visit> getUsersRecentActivity(Integer userId) {
		return (Collection<Visit>) getSqlMapClientTemplate().queryForList(
				"getUsersRecentActivity", userId);
	}

	@Override
	public Collection<Visit> getTeamsRecentActivity(Integer teamId) {
		return (Collection<Visit>) getSqlMapClientTemplate().queryForList(
				"getTeamsRecentActivity", teamId);
	}

	@Override
	public Visit getUsersMostRecentCheckin(Integer userId) {
		return (Visit) getSqlMapClientTemplate().queryForObject(
				"getUsersMostRecentCheckin", userId);
	}
}
