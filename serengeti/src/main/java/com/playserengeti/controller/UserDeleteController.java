/*
 * UserDeleteController. Calls UserDeleteService and provides the result to userDelete.jsp
 */

package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.service.UserDeleteService;

public class UserDeleteController extends AbstractCommandController {

	private UserDeleteService service;
	
	public UserDeleteController(UserDeleteService service) {
		this.service = service;
	}
	
    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

    	if (errors.hasErrors()) {
    	    return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());	
    	}
    	
        UserDeleteCommand command = (UserDeleteCommand)commandObject;
    	String userID = command.getUserID();
    	String viewName = "userDelete.jsp";    

        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("userID", userID);
        return mav;
    }
}
