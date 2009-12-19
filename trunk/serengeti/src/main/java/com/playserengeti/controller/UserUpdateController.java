package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.User;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

/**
 * The controller for updating a user's information.
 * 
 * @author Chris
 * 
 */
public class UserUpdateController extends SimpleFormController {

	private UserService userService;
	private TeamService teamService;
	private UserSession session;

	public UserUpdateController(UserService userService, TeamService teamService) {
		this.userService = userService;
		this.teamService = teamService;
		setSessionForm(true);
	}

	/**
	 * Sets the BackingObject to the user specified by the given userId.
	 */
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		User user;
		UserCommand userCommand = new UserCommand();

		if (session.isLoggedIn()) {
			userCommand.setSessionId(session.getUser().getId());		
		    if (userId != null && session.getUser().getId().equals(userId)) {
			    user = userService.getUserById(userId);
			    userCommand.setUserId(user.getId());
		    	userCommand.setEmail(user.getEmail());
			    userCommand.setFirstName(user.getFirstName());
			    userCommand.setLastName(user.getLastName());
			    userCommand.setFriends(userService.getFriends(userId));
			    userCommand.setTeams(teamService.getUsersTeams(userId));
		    }
		}
		return userCommand;
	}
	/**
	 * Modify the user based on the information on the input form.
	 */
	public ModelAndView onSubmit(Object _command) {
		UserCommand command = (UserCommand) _command;
		Integer userId = command.getUserId();

		if (session.isLoggedIn() && userId != null
		  && session.getUser().getId().equals(userId)) {
			MultipartFile file = command.getImageFile();
			
			// Modify the entry in the database
			User user = userService.getUserById(userId);
			user.setEmail(command.getEmail());
			user.setFirstName(command.getFirstName());
			user.setLastName(command.getLastName());

			// Save the image to disk.  This method does not modify the DB!
			if (file != null) {
				userService.saveImageForUser(user, file);
			}
			
			// Update the entry in the database.
			userService.updateUser(user);
			userService.updateUserPassword(userId, command.getPassword());
		}
		
		ModelAndView mav = new ModelAndView("redirect:/user/" + userId);
		return mav;
	}

	public UserSession getSession() {
		return session;
	}

	public void setSession(UserSession session) {
		this.session = session;
	}
}
