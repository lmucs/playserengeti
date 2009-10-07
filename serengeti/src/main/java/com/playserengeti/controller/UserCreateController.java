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

	private UserService service;
	
	public UserCreateController(UserService service) {
		this.service = service;
	}
	
	@Override
	public ModelAndView onSubmit(Object _command) {
		UserCreateCommand command = (UserCreateCommand)_command;
		String login = command.getLogin();
		String display = command.getDisplay();
		
		// Insert the entry into the database.
		try {
		    service.saveUser(new User(null, login, display));
		    return new ModelAndView(getSuccessView(), "login", login);
		} catch (Exception e) {
			return new ModelAndView(getFormView(), "message", e.getMessage());
		}
	}
}
