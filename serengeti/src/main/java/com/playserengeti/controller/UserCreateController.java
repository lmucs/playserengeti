package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.service.UserService;


/**
 * Main controller for the calculator webapp.
 */
public class UserCreateController extends AbstractCommandController {

	private UserService service;
	
	public UserCreateController(UserService service) {
		this.service = service;
	}
	
    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

    	if (errors.hasErrors()) {
    	    return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());	
    	}
    	
        UserCreateCommand command = (UserCreateCommand)commandObject;
        String login = command.getLogin();
        String password = command.getPassword();

        String viewName = "signup.jsp";
        
        /*
        if ("xml".equals(command.getFormat())) {
        	viewName = "answer.jspx";
        }
        */
        
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("login", login);
        mav.addObject("password", password);        
        return mav;
    }
}
