package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Team;
import com.playserengeti.service.TeamService;

public class TeamUpdateController extends SimpleFormController {
	
	private TeamService service;
	
	public TeamUpdateController (TeamService service) {
		this.service = service;
	}
	
	public ModelAndView onSubmit(Object _command) {
		TeamUpdateCommand command = (TeamUpdateCommand)_command;
		int teamId = command.getTeamID();
		
		// Delete the entry from the database.
		Team team = service.getTeamById(teamId);
		team.setColor(command.getColor());
		service.saveTeam(team);
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("name", team.getName());
		
		return new ModelAndView(getSuccessView(), model);
	}
    
}
