package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Team;
import com.playserengeti.service.LocationService;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;

/**
 * Controller for updating/modifying teams.
 * @author Chris
 *
 */
public class TeamUpdateController extends SimpleFormController {
	
	private TeamService teamService;
	private UserService userService;
	private LocationService locationService;
	
	/**
	 * Constructor.  Sets the service.
	 * @param service
	 */
	public TeamUpdateController (TeamService teamService, UserService userService, 
			LocationService locationService) {
		this.teamService = teamService;
		this.userService = userService;
		this.locationService = locationService;
		setSessionForm(true);
	}
	
	/**
	 * Sets the BackingObject to the team specified by the given teamId.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String teamId = request.getParameter("teamId");
        //String userId = request.getParameter("userId");
       
        TeamUpdateCommand updateTeam = new TeamUpdateCommand();
        Team team; 
		
        if (teamId != null) {
			team = teamService.getTeamById(Integer.valueOf(teamId));
		    updateTeam.setTeamId(team.getId());
	    	updateTeam.setName(team.getName());
    		updateTeam.setColor(team.getColor());
    		
    		if (team.getLeader() != null) updateTeam.setLeaderId(team.getLeader().getUserId());
    		if (team.getHomeLocation() != null) updateTeam.setHomeLocation(team.getHomeLocation().getLocationId());
    		if (team.getImage() != null) updateTeam.setImage(team.getImage());
    		
    		updateTeam.setTeamUsers(team.getMembers());

		}
		
        //updateTeam.setUserId(Integer.valueOf(userId));
		updateTeam.setAllLocations(locationService.getAllLocations());
		
		return updateTeam;
	}
	
	/**
	 * Modifies the database entry with the information from the command.  
	 * Should be modified to check what info has changed.
	 */
	public ModelAndView onSubmit(Object _command) {
		TeamUpdateCommand command = (TeamUpdateCommand)_command;
		Integer teamId = command.getTeamId();
		//Integer userId = command.getUserId();
		
		// Modify the entry in the database.
		Team team = teamService.getTeamById(teamId);
		team.setColor(command.getColor());
		team.setLeader(userService.getUserById(command.getLeaderId()));
		team.setHomeLocation(locationService.getLocationById(command.getHomeLocation()));
		team.setImage(command.getImage());
		
		teamService.saveTeam(team);
		
		ModelAndView mav = new ModelAndView("redirect:view");
		
		mav.addObject("teamId", teamId);
		//mav.addObject("userId", userID);

		return mav;
	}
    
}
