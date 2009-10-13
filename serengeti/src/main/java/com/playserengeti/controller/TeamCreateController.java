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
	 * Sets the BackingObject of the .jsp page.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        TeamCreateCommand createTeam = new TeamCreateCommand();
        
        //Won't be needed when sign in is implemented because the team's
        //leader will automatically be set by the given userId.
        createTeam.setAllUsers(userService.getAllUsers());
        //Don't know how we want to specify a home location...
        //By city maybe?
        createTeam.setAllLocations(locationService.getAllLocations());
        
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
		User leader = userService.getUserById(command.getUserId());
		Location homeLocation = locationService.getLocationById(command.getHomeLocation());
		String image = command.getImage();
		
		Team team = new Team(null, display, color);
		if (leader != null) team.setLeader(leader);
		if (homeLocation != null) team.setHomeLocation(homeLocation);
		if (image != null) team.setImage(image);
		
		// Insert the entry into the database.
		teamService.saveTeam(team);
		//Need to add the team to the User's teams attribute.
		
		ModelAndView mav = new ModelAndView("redirect:view");
		
		mav.addObject("teamId", team.getId());
		//mav.addObject("userId", leader.getId());
		
		return mav;
	}

}
