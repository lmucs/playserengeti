package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Team;
import com.playserengeti.service.TeamService;

/**
 * Controller for updating/modifying teams.  May need to change back to 
 * extend AbstractController.
 * @author Chris
 *
 */
public class TeamUpdateController extends SimpleFormController {
	
	private TeamService service;
	
	/**
	 * Constructor.  Sets the service.
	 * @param service
	 */
	public TeamUpdateController (TeamService service) {
		this.service = service;
	}
	
	/**
	 * Modifies the database entry with the information from the command.  
	 * Should be modified to check what info has changed.  Currently only 
	 * modifies color for development.
	 */
	public ModelAndView onSubmit(Object _command) {
		TeamUpdateCommand command = (TeamUpdateCommand)_command;
		int teamId = command.getTeamId();
		
		// Modify the entry in the database.
		Team team = service.getTeamById(teamId);
		team.setColor(command.getColor());
		service.saveTeam(team);
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("name", team.getName());
		
		return new ModelAndView(getSuccessView(), model);
	}
    
}
