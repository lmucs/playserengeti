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
public class UserLoginController extends SimpleFormController {

	private UserService userService;
	private UserSession session;

	/**
	 * Creates the controller, injecting a service.
	 */
	public UserLoginController(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ModelAndView onSubmit(Object _command) {
		UserCommand command = (UserCommand)_command;
		Integer userId;
		String email = command.getEmail();
		String password = command.getPassword();

		User user = userService.getUserByEmailAndPassword(email, password);
		
		if (user == null) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("command", command);
			model.put("message", "Email and/or password invalid.");
			return new ModelAndView(getFormView(), model);
		}
		
		// Login successful!
		session.setUser(user);
		return new ModelAndView("redirect:view", "userId", user.getUserId());
	}
	
	public UserSession getSession() {
		return session;
	}
	
	public void setSession(UserSession session) {
		this.session = session;
	}
}
