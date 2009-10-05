package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Team;
import com.playserengeti.service.TeamService;

/**
 * The controller for creating a team.  Uses a 
 * @author Chris
 *
 */
public class TeamCreateController extends SimpleFormController {

    private TeamService service;

    public TeamCreateController (TeamService service) {
        this.service = service;
    }

	public ModelAndView onSubmit(Object _command) {
		TeamCreateCommand command = (TeamCreateCommand)_command;
		String display = command.getName();
		String color = command.getColor();
		
		// Insert the entry into the database.
		service.saveTeam(new Team(null, display, color));
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("name", ((TeamCreateCommand)_command).getName());
		model.put("color", ((TeamCreateCommand)_command).getColor());
		return new ModelAndView(getSuccessView(), model);
	}

}
