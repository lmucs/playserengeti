package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.domain.Team;
import com.playserengeti.service.TeamService;

public class TeamViewProfileController extends AbstractCommandController{

	private TeamService service;
	
	public TeamViewProfileController(TeamService service) {
		this.service = service;
	}
	@Override
	protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors)throws Exception {
		
    	if (errors.hasErrors()) {
    	    return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());	
    	}	
    	
        TeamViewProfileCommand command = (TeamViewProfileCommand)commandObject;
        
        Integer teamId = command.getTeamId();
        Team team = null;
        if (teamId != null) {
        	team = service.getTeamById(teamId);
        }

        String viewName = "teamViewProfile.jsp";
        
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("team", team);
        return mav;
	}
}
