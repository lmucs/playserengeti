package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.User;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

/**
 * Controller for deleting users.
 * 
 * @author Chris
 * 
 */
public class UserDeleteController extends SimpleFormController {

	private UserService userService;
	private TeamService teamService;
	private UserSession session;

	public UserDeleteController(UserService userService, TeamService teamService) {
		this.userService = userService;
		this.teamService = teamService;
	}

	/**
	 * Sets the backing object to contain information about the user to be
	 * deleted.
	 */
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		UserCommand userCommand = new UserCommand();
		if (session.isLoggedIn()) {
			userCommand.setSessionId(session.getUser().getId());		
		    if (userId != null && session.getUser().getId().equals(userId)) {
		    	User user = userService.getUserById(userId);
		    	userCommand.setUserId(userId);
		    	userCommand.setEmail(user.getEmail());
			    userCommand.setFirstName(user.getFirstName());
			    userCommand.setLastName(user.getLastName());
			    userCommand.setTeams(teamService.getTeamsLedByUser(userId));
		    }
		}
		setSessionForm(true);
		return userCommand;
	}

	/**
	 * Performs the deletion of a user.
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object _command, BindException errors)
			throws Exception {
		UserCommand command = (UserCommand) _command;
		Integer userId = command.getUserId();

		try {
			if (session.isLoggedIn() && userId != null
			  && session.getUser().getId().equals(userId)) {
				session.setUser(null);
				// Deletes the user from the database.
				userService.deleteUser(userId);

			}
			return new ModelAndView("redirect:/");
		}

		catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("command", command);
			model.put("message", e.getMessage());
			return showForm(request, response, errors, model);
		}
	}

	public UserSession getSession() {
		return session;
	}

	public void setSession(UserSession session) {
		this.session = session;
	}
}
