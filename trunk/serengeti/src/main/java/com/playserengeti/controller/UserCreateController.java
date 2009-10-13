package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.User;
import com.playserengeti.service.UserService;

/**
 * Controller for creating a user.
 */
public class UserCreateController extends SimpleFormController {

	private UserService userService;

	/**
	 * Creates the controller, injecting a service.
	 */
	public UserCreateController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ModelAndView onSubmit(Object _command) {
		UserCreateCommand command = (UserCreateCommand)_command;
		Integer userId;
		String userName = command.getUserName();
		String password = command.getPassword();
		String email = command.getEmail();
		User user = new User(null, userName, password, null, null, email, null);

		try {
			// Insert the entry into the database.
		    userId = userService.saveUser(user);

		    Map<String, String> model = new HashMap<String, String>();
		    model.put("userId", Integer.toString(userId));
		    model.put("userName", userName);
			model.put("email", email);
		    return new ModelAndView(getSuccessView(), model);

		} catch (Exception e) {
			// On service error, try again
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("command", command);
			model.put("message", e.getMessage());
			return new ModelAndView(getFormView(), model);
		}
	}
}
