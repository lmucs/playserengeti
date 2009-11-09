package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.User;
import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

/**
 * Controller for creating a user.
 */
public class UserCreateController extends SimpleFormController {

	private UserService userService;
	private UserSession session;

	/**
	 * Creates the controller, injecting a service.
	 */
	public UserCreateController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ModelAndView onSubmit(Object _command) {
		UserCommand command = (UserCommand)_command;
		Integer userId;
		String email = command.getEmail();
		String firstName = command.getFirstName();
		String lastName = command.getLastName();
		String password = command.getPassword();

		User user = new User(email, firstName, lastName);

		try {
			// Insert the entry into the database.
		    userId = userService.insertUserWithPassword(user, password);
		    session.setUser(user);

			ModelAndView mav = new ModelAndView("redirect:view");
			mav.addObject("userId", userId);		
			
			return mav;

		} catch (Exception e) {
			// On service error, try again
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("command", command);
			model.put("message", e.getMessage());
			return new ModelAndView(getFormView(), model);
		}
	}
	
	public UserSession getSession() {
		return session;
	}
	
	public void setSession(UserSession session) {
		this.session = session;
	}
}
