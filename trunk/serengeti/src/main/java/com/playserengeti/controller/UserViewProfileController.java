/*
 * UserViewProfileController. Calls UserViewProfileService and provides the result to userViewProfile.jsp
 */

package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.domain.User;
import com.playserengeti.service.UserService;

public class UserViewProfileController extends AbstractCommandController {
	
	private UserService service;
	
	public UserViewProfileController(UserService service) {
		this.service = service;
	}
	
    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

    	if (errors.hasErrors()) {
    	    return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());	
    	}
    	
        UserViewProfileCommand command = (UserViewProfileCommand)commandObject;
        
        Integer userId = command.getUserId();
        User user = null;
        if (userId != null) {
        	user = service.getUserById(userId);
        }

        String viewName = "userViewProfile.jsp";
        
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("user", user);
        return mav;
    }
}
