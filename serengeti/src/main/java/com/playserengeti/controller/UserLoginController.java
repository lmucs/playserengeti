package com.playserengeti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.User;
import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

/**
 * Controller for creating a user.
 */
public class UserLoginController extends SimpleFormController {

	private Logger logger = Logger.getLogger(getClass());

	private UserService userService;
	private UserSession session;

	/**
	 * Creates the controller, injecting a service.
	 */
	public UserLoginController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Logs in a user if the email address and password authenticate.
	 */
	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object _command, BindException errors) {
		UserCommand command = (UserCommand) _command;

		logger.debug(command);

		String email = command.getEmail();
		String password = command.getPassword();
		String format = command.getFormat();

		User user = userService.authenticateUserByEmailAndPassword(email,
				password);

		if (user == null) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("command", command);
			model.put("message", "Email and/or password invalid.");
			return new ModelAndView(getFormView(), model);
		}

		// Login successful!
		session.setUser(user);
		String view = "redirect:/user/" + user.getId();
		if ("json".equals(format)) {
			try {
				PrintWriter out = response.getWriter();
				out.println(user.asMinimalJSON());
				out.flush();
				return null;
			} catch (IOException e) {
			}
		}

		return new ModelAndView(view);
	}

	public UserSession getSession() {
		return session;
	}

	public void setSession(UserSession session) {
		this.session = session;
	}
}
