package com.playserengeti.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Team;
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
	
	/**
	 * Constructor.  Sets the service.
	 * @param service
	 */
	public TeamUpdateController (TeamService teamService, UserService userService) {
		this.teamService = teamService;
		this.userService = userService;
		setSessionForm(true);
	}
	
	/**
	 * Sets the BackingObject to the team specified by the given teamId.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        Integer teamId = Integer.valueOf(request.getParameter("teamId"));
       
        TeamCommand teamCommand = new TeamCommand();
        Team team; 
		
        if (teamId != null) {
			team = teamService.getTeamById(teamId);
		    teamCommand.setTeamId(team.getId());
	    	teamCommand.setName(team.getName());
    		teamCommand.setColor(team.getColor());
      		teamCommand.setImage(team.getImage());
      		teamCommand.setDescription(team.getDescription());
      		teamCommand.setHomeBase(team.getHomeBase());
    		if (team.getLeader() != null) teamCommand.setLeaderId(team.getLeader().getUserId());
    		
    		Collection<Integer> members = teamService.getTeamMembers(teamId);
    		Map<Integer, String> candidates = new HashMap<Integer, String>();
    		for (Integer id : members) {
    			candidates.put(id, userService.getUserById(id).getUserName());
    		}
    		teamCommand.setCandidates(candidates);
		}
        
		return teamCommand;
	}
	
	/**
	 * Modifies the database entry with the information from the command.  
	 * Should be modified to check what info has changed.
	 */
	public ModelAndView onSubmit(Object _command) {
		TeamCommand command = (TeamCommand)_command;
		Integer teamId = command.getTeamId();
		
		// Modify the entry in the database.
		Team team = teamService.getTeamById(teamId);
		team.setName(command.getName());
		team.setColor(command.getColor());
		if(command.getLeaderId() != null) team.setLeader(userService.getUserById(command.getLeaderId()));
		team.setImage(command.getImage());
		team.setDescription(command.getDescription());
		team.setHomeBase(command.getHomeBase());
		
		teamService.saveTeam(team);
		
		Integer[] removals = command.getRemovals();
		for (Integer id : removals) {
			teamService.removeFromTeam(teamId, id);
		}

		ModelAndView mav = new ModelAndView("redirect:view");		
		mav.addObject("teamId", teamId);

		return mav;
	}
    
}
