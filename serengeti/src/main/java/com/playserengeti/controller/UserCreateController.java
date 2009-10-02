package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.User;
import com.playserengeti.service.UserService;


/**
 * Main controller for the calculator webapp.
 */
public class UserCreateController extends SimpleFormController {

	private UserService service;
	
	public UserCreateController(UserService service) {
		this.service = service;
	}
	
	public ModelAndView onSubmit(Object _command) {
		UserCreateCommand command = (UserCreateCommand)_command;
		String login = command.getLogin();
		String display = command.getDisplay();
		
		// Insert the entry into the database.
		service.saveUser(new User(null, login, display));
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("login", ((UserCreateCommand)_command).getLogin());
		return new ModelAndView(getSuccessView(), model);
	}
}
