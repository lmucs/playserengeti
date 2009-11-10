/*
 * UserUpdateController. Calls UserManageService and provides the result to userManage.jsp
 */

package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.User;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;

public class UserUpdateController extends SimpleFormController {

    private UserService userService;
    private TeamService teamService;

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
		if (userId != null) {
			user = userService.getUserById(userId);
			userCommand.setUserId(user.getId());
			userCommand.setEmail(user.getEmail());
			userCommand.setFirstName(user.getFirstName());
			userCommand.setLastName(user.getLastName());
			userCommand.setFriends(userService.getFriendsMap(userId));
			userCommand.setTeams(teamService.getTeamsMap(userId));
		}

		return userCommand;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(java.lang.Object)
	 */
	public ModelAndView onSubmit(Object _command) {
		UserCommand command = (UserCommand)_command;
		Integer userId = command.getUserId();

		//Modify the entry in the database
		User user = userService.getUserById(userId);
		user.setEmail(command.getEmail());
		user.setFirstName(command.getFirstName());
		user.setLastName(command.getLastName());
		
		// Update the entry in the database.
		userService.updateUser(user);
		userService.updateUserPassword(userId, command.getPassword());
		
		ModelAndView mav = new ModelAndView("redirect:/user/" + userId);

		return mav;
	}
}
