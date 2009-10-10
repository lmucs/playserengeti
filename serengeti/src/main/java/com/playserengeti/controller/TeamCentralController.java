package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Location;
import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;

public class TeamCentralController extends SimpleFormController {

	private TeamService teamService;
	private UserService userService;
	
	public TeamCentralController(TeamService teamService, UserService userService) {
		this.teamService = teamService;
		this.userService = userService;
	}

	
	/**
	 * Sets the BackingObject.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        TeamCentralCommand teamCentral = new TeamCentralCommand();
        
        //String id = request.getParameter("userId");
        //teamCentral.setUser(userService.getUserById(Integer.valueOf(id)));
        
        teamCentral.setUserTeams(teamService.getAllTeams());

        return teamCentral;
	}
	
	/**
	 * On submit, go to createTeam and give the current userId so 
	 * they are automatically the leader.
	 */
	public ModelAndView onSubmit(Object _command) {
		//TeamCentralCommand command = (TeamCentralCommand)_command;
		
		//Integer userId = command.getUser().getId();
		//return new ModelAndView(getSuccessView(),"userId", userId);
	
	    return new ModelAndView(getSuccessView());
	}

}
