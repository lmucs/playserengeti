package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.service.UserService;

/**
 * Controller for creating a user.
 */
public class UserCreateController extends SimpleFormController {

	private UserService service;

	/**
	 * Creates the controller, injecting a service.
	 */
	public UserCreateController(UserService service) {
		this.service = service;
	}
	
	@Override
	public ModelAndView onSubmit(Object _command) {
		UserCreateCommand command = (UserCreateCommand)_command;
		String userName = command.getUserName();
		String password = command.getPassword();
		String email = command.getEmail();
		
		try {
			// Insert the entry into the database.
		    service.createUser(userName, password, email);
		    return new ModelAndView(getSuccessView(), "userName", userName);

		} catch (Exception e) {
			// On service error, try again
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("command", command);
			model.put("message", e.getMessage());
			return new ModelAndView(getFormView(), model);
		}
	}
}
