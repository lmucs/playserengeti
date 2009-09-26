/*
 * ViewWorldMapController. Calls ViewWorldMapService and provides the result to viewWorldMap.jsp. 
 */

package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.service.ViewWorldMapService;

public class ViewWorldMapController extends AbstractCommandController {

	private ViewWorldMapService service;
	
	public ViewWorldMapController(ViewWorldMapService service) {
		this.service = service;
	}
	
	
    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

    	if (errors.hasErrors()) {
    	    return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());	
    	}
    	
        ViewWorldMapCommand command = (ViewWorldMapCommand)commandObject;
        String userID = command.getUserID();
  
        String viewName = "viewWorldMap.jsp";
        
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("userID", userID);
        return mav;
    }
}
