package com.playserengeti.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.playserengeti.dao.UserDao;
import com.playserengeti.domain.User;

/**
 * Service for operations related to users.
 */
public class UserService {

	private Logger log = Logger.getLogger(getClass());
	
	private UserDao userDao;
	private String avatarDirectory;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getAvatarDirectory() {
		return avatarDirectory;
	}
	
	public void setAvatarDirectory(String directory) {
		this.avatarDirectory = directory;
	}
	
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	public User authenticateUserByEmailAndPassword(String email, String password) {
		User user = userDao.authenticateUserByEmailAndPassword(email, password);
		return user;
	}

	/**
	 * Creates a user from the provided information and writes the user to
	 * storage.
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public Integer insertUserWithPassword(User user, String password) {
		Integer id = userDao.insertUserWithPassword(user, password);

		User storedUser = userDao.getUserById(id);
		user.setDateCreated(storedUser.getDateCreated());
		return id;
	}

	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	public boolean updateUserPassword(Integer userId, String password) {
		return userDao.updateUserPassword(userId, password);
	}

	/**
	 * Deletes the user with the given id from persistent storage.
	 */
	public boolean deleteUser(Integer id) {
		// TODO: If no such user exists, throws an IllegalArgumentException.
		return userDao.deleteUser(id);
	}

	/**
	 * Fetches all the users from persistent storage.
	 */
	public Collection<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	/**
	 * Returns all users as a map with key userId and value email.
	 */
	public Map<Integer, String> getAllUsersMap() {
		Map<Integer, String> result = new HashMap<Integer, String>();
		for (User u : userDao.getAllUsers()) {
			result.put(u.getId(), u.getEmail());
		}
		return result;
	}

	public void removeFriend(Integer firstId, Integer secondId) {
		userDao.removeFriend(firstId, secondId);
	}

	/**
	 * Returns a collection of users as a JSON string array.
	 */
	public String asJSON(Collection<User> users) {
		String result = "[";
		int count = users.size();

		for (User u : users) {
			result += u.asMinimalJSON();
			if (count > 1) {
				result += ", ";
			}
			count--;
		}
		result += "]";
		return result;
	}

	public Collection<User> getFriends(Integer userId) {
		return userDao.getFriends(userId);
	}

	public Collection<User> getFriendInvites(Integer userId) {
		return userDao.getFriendInvites(userId);
	}

	public Collection<User> getNewestUsers() {
		return userDao.getNewestUsers();
	}

	public Collection<User> getMostActiveUsers() {
		return userDao.getMostActiveUsers();
	}

	public void acceptFriendInvite(Integer firstId, Integer secondId) {
		userDao.acceptFriendInvite(firstId, secondId);
	}

	public void rejectFriendInvite(Integer firstId, Integer secondId) {
		userDao.rejectFriendInvite(firstId, secondId);
	}

	public void sendFriendInvite(Integer firstId, Integer secondId) {
		userDao.sendFriendInvite(firstId, secondId);
	}

	public Collection<User> searchUsers(String query) {
		return userDao.searchUsers(query);
	}

	/**
	 * Doesn't modify the database!
	 */
	// TODO: Revisit this method!
	public void saveImageForUser(User user, MultipartFile inputFile) {
		Pattern p = Pattern.compile(".*\\.([^.]*)$");
		Matcher m = p.matcher(inputFile.getOriginalFilename());
		String extension = null;
		
		if (m.matches()) {
			extension = m.group(1);
			
			try {
				String path =
					avatarDirectory + File.separator + user.getId() + "." + extension;
				
				// Write file.
				FileOutputStream out = new FileOutputStream(path);
				out.write(inputFile.getBytes());
				out.flush();
				out.close();
				
				// Set the extension field.
				user.setAvatarFileSuffix(extension);
			} catch (IOException e) {
				// TODO: Do something else here.
				log.warn(e);
			}
		} else {
			// TODO: File has no extension!  Throw exception or something.
		}
	}
}
