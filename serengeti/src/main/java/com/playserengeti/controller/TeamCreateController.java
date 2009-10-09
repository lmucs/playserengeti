package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Location;
import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;
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
    private LocationService locationService;

	/**
	 * Constructor.  Sets the service.
	 * @param service
	 */
    public TeamCreateController (TeamService teamService, UserService userService, 
    		LocationService locationService) {
        this.teamService = teamService;
        this.userService = userService;
        this.locationService = locationService;
    }

	/**
	 * Sets the BackingObject.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        TeamCreateCommand createTeam = new TeamCreateCommand();
        createTeam.setAllUsers(userService.getAllUsers());
        createTeam.setAllLocations(locationService.getAllLocations());
        return createTeam;
	}
	
    /**
     * Handles the submit functionality of the controller.  Currently only uses
     * name and color for development purposes.
     */
	public ModelAndView onSubmit(Object _command) {
		TeamCreateCommand command = (TeamCreateCommand)_command;
		String display = command.getName();
		String color = command.getColor();
		User leader = userService.getUserById(command.getLeaderId());
		Location homeLocation = locationService.getLocationById(command.getHomeLocation());
		String image = command.getImage();
		
		Team team = new Team(null, display, color);
		if (leader != null) team.setLeader(leader);
		if (homeLocation != null) team.setHomeLocation(homeLocation);
		if (image != null) team.setImage(image);
		
		// Insert the entry into the database.
		teamService.saveTeam(team);
		
		ModelAndView mav = new ModelAndView(getSuccessView());
		mav.addObject("team", team);
		return mav;
	}

}
