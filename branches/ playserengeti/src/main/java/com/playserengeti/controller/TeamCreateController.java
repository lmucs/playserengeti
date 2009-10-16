package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Location;
import com.playserengeti.domain.Membership;
import com.playserengeti.domain.Team;
import com.playserengeti.service.LocationService;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;

/**
 * The controller for creating a team.
 * @author Chris
 *
 */
public class TeamCreateController extends SimpleFormController {

    private TeamService teamService;
    private UserService userService;

	/**
	 * Constructor.  Sets the service.
	 * @param service
	 */
    public TeamCreateController (TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }

	/**
	 * Sets the BackingObject of the .jsp page.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        TeamCreateCommand createTeam = new TeamCreateCommand();
        
        //Won't be needed when sign in is implemented because the team's
        //leader will automatically be set by the given userId.
        createTeam.setAllUsers(userService.getAllUsers());
        
		setSessionForm(true);

        return createTeam;
	}
	
    /**
     * Handles the submit functionality of the controller.  
     */
	public ModelAndView onSubmit(Object _command) {
		TeamCreateCommand command = (TeamCreateCommand)_command;
		String display = command.getName();
		String color = command.getColor();
		Integer userId = command.getUserId();
		String image = command.getImage();
		
		Team team = new Team(null, display, color);
		if (userId != null) { 
			team.setLeader(userService.getUserById(userId));
		}
		if (image != null) team.setImage(image);
		
		// Insert the entry into the database.
		teamService.saveTeam(team);
        teamService.saveMembership(new Membership(null, team.getId(), userId));
		
		ModelAndView mav = new ModelAndView("redirect:view");
		
		mav.addObject("teamId", team.getId());
		//mav.addObject("userId", userId);
		
		return mav;
	}

}
