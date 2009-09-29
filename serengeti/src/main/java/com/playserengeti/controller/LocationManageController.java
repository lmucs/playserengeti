package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.service.LocationManageService;

/*
 *The controller for managing a location
 */

public class LocationManageController extends AbstractCommandController {

	private LocationManageService service;
	
	public LocationManageController(LocationManageService service) {
		this.service = service;
	}
	
	
    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

    	if (errors.hasErrors()) {
    	    return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());	
    	}
    	
        LocationManageCommand command = (LocationManageCommand)commandObject;
        String name = command.getName();
        int locationID = command.getLocationID();
        double locationLongitude = command.getLocationLongitude();
        double locationLatitude = command.getLocationLatitude();
        int userOwnerID = command.getUserOwnerID();
        int teamOwnerID = command.getTeamOwnerID();

        String viewName = "LocationManage.jsp";
        
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("name", name);
        mav.addObject("locationID", locationID);
        mav.addObject("locationLongitude", locationLongitude);
        mav.addObject("locationLatitude", locationLatitude);
        mav.addObject("userOwnerID", userOwnerID);
        mav.addObject("teamOwnerID", teamOwnerID);
        return mav;
    }
}