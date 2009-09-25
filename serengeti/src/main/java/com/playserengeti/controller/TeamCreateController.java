package com.playserengeti.controller;

import java.awt.Color;
import java.awt.Image;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.service.TeamCreateService;

/**
 * The controller for creating a team.
 * @author Chris
 *
 */
public class TeamCreateController extends AbstractCommandController {
	
	private TeamCreateService service;
	
	public TeamCreateController (TeamCreateService service) {
		this.service = service;
	}
	
    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

    	if (errors.hasErrors()) {
    	    return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());	
    	}
    	
        TeamCreateCommand command = (TeamCreateCommand)commandObject;
        String name = command.getName();
        int teamID = command.getTeamID();
        int teamTypeID = command.getTeamTypeID();
        int leaderID = command.getLeaderID();
        Color color = command.getColor();
        Image image = command.getImage();
        double homeLongitude = command.getHomeLongitude();
        double homeLatitude = command.getHomeLatitude();


        String viewName = "teamCreate.jsp";
        
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("name", name);
        mav.addObject("teamID", teamID);
        mav.addObject("teamTypeID", teamTypeID);
        mav.addObject("leaderID", leaderID); 
        mav.addObject("color", color);        
        mav.addObject("image", image);        
        mav.addObject("homeLongitude", homeLongitude);        
        mav.addObject("homeLatitude", homeLatitude);        

        return mav;
    }
    
}
