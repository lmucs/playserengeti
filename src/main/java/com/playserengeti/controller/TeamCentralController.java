package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Location;
import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;

/**
 * The controller for the team central section.  Is the gateway for all 
 * team functionality
 * @author Chris
 *
 */
public class TeamCentralController extends SimpleFormController {

	private TeamService teamService;
	private UserService userService;
	
	public TeamCentralController(TeamService teamService, UserService userService) {
		this.teamService = teamService;
		this.userService = userService;
	}

	/**
	 * Sets the backing object for the .jsp page.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        TeamCentralCommand teamCentral = new TeamCentralCommand();
        
        //Integer userId = request.getParameter("userId");
        //teamCentral.setUserId(userService.getUserById(userId));
        
        teamCentral.setUserTeams(teamService.getAllTeams());

        return teamCentral;
	}
	
	/**
	 * On submit, go to createTeam and give the current userId so 
	 * they are automatically the leader.
	 */
	public ModelAndView onSubmit(Object _command) {
		//TeamCentralCommand command = (TeamCentralCommand)_command;
		
		//Integer userId = command.getUserId();
		//return new ModelAndView(getSuccessView(),"userId", userId);
	
	    return new ModelAndView(getSuccessView());
	}

}
