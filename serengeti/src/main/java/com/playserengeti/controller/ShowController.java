/*
 * ShowController. Calls ShowService and provides the result to show.jsp. 
 * Probably there is no need for show.jsp, but it can be corrected as needed.
 */

package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.service.ShowService;

public class ShowController extends AbstractCommandController {

	private ShowService service;
	
	public ShowController(ShowService service) {
		this.service = service;
	}
	
	
    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

    	if (errors.hasErrors()) {
    	    return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());	
    	}
    	
        ShowCommand command = (ShowCommand)commandObject;
        String userID = command.getUserID();
  
        String viewName = "show.jsp";
        
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("userID", userID);
        return mav;
    }
}
