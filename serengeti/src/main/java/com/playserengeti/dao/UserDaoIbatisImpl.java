package com.playserengeti.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.playserengeti.domain.Avatar;
import com.playserengeti.domain.User;

public class UserDaoIbatisImpl extends SqlMapClientDaoSupport implements UserDao {

    @Override
	public User authenticateUserByEmailAndPassword(String email, String password) {
    	Map<String,String> parameterMap = new HashMap<String,String>();
    	parameterMap.put("email", email);
    	parameterMap.put("password", password);
		return (User)getSqlMapClientTemplate().queryForObject(
				"authenticateUserByEmailAndPassword",
				parameterMap);
	}

	@Override
	public boolean deleteUser(Integer id) {
		return getSqlMapClientTemplate().delete("deleteUser", id) > 0;
	}

	@Override
	public Collection<User> getAllUsers() {
		return (List<User>)getSqlMapClientTemplate().queryForList("getAllUsers");
	}

	@Override
	public User getUserByEmail(String email) {
		return (User)getSqlMapClientTemplate().queryForObject(
				"getUserByEmail",
				email);
	}

	@Override
	public User getUserById(Integer id) {
		return (User)getSqlMapClientTemplate().queryForObject(
				"getUserById",
				id);
	}

	@Override
	public Integer insertUserWithPassword(User user, String password) {
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("user", user);
		parameterMap.put("password", password);
		getSqlMapClientTemplate().insert(
				"insertUserWithPassword",
				parameterMap);
		return user.getId();
	}

	@Override
	public boolean updateUser(User user) {
		return getSqlMapClientTemplate().update("updateUser", user) > 0;
	}

	@Override
	public boolean updateUserPassword(Integer id, String password) {
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("id", id);
		parameterMap.put("password", password);
		return getSqlMapClientTemplate().update(
				"updateUserPassword",
				parameterMap) > 0;
	}
	
	public Collection<User> getFriends(Integer userId) {
		return (List<User>)getSqlMapClientTemplate().queryForList("getFriends", userId);
	}
	
	public Collection<User> getFriendInvites(Integer userId) {
		return (List<User>)getSqlMapClientTemplate().queryForList("getFriendInvites", userId);
	}
	
	public Collection<User> getNewestUsers() {
		return (List<User>)getSqlMapClientTemplate().queryForList("getNewestUsers");
	}
	
	public Collection<User> getMostActiveUsers() {
		return (List<User>)getSqlMapClientTemplate().queryForList("getMostActiveUsers");
	}
	
	public boolean acceptFriendInvite(Integer firstId, Integer secondId) {
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("firstId", firstId);
		parameterMap.put("secondId", secondId);
		return getSqlMapClientTemplate().update("acceptFriendInvite", parameterMap) > 0;
	}
	
	public boolean rejectFriendInvite(Integer firstId, Integer secondId) {
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("firstId", firstId);
		parameterMap.put("secondId", secondId);
		return getSqlMapClientTemplate().update("rejectFriendInvite", parameterMap) > 0;
	}
	
	public void sendFriendInvite(Integer firstId, Integer secondId) {
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("firstId", firstId);
		parameterMap.put("secondId", secondId);
		getSqlMapClientTemplate().insert("sendFriendInvite", parameterMap);
	}
	
	public boolean removeFriend(Integer firstId, Integer secondId) {
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("firstId", firstId);
		parameterMap.put("secondId", secondId);
		return getSqlMapClientTemplate().delete("removeFriend", parameterMap) > 0;
	}
	
	@Override
	public Collection<User> searchUsers(String query) {
		return (Collection<User>)getSqlMapClientTemplate().queryForList("searchUsers", query);
	}

	@Override
	public Avatar getUserAvatarByUserId(Integer userId) {
		return (Avatar)getSqlMapClientTemplate().queryForObject("getUserAvatarByUserId", userId);
	}

	@Override
	public void activateAvatarIdForUserId(Integer userId, Integer avatarId) {
		Map<String, Object> propMap = new HashMap<String, Object>();
    	propMap.put("userId", userId);
    	propMap.put("avatarId", avatarId);
		getSqlMapClientTemplate().update("activateAvatarIdForUserId", propMap);
	}

	@Override
	public void insertAvatarForUserId(Map<String, Object> properties) {
		getSqlMapClientTemplate().insert("insertAvatarForUserId", properties);
	}
}
