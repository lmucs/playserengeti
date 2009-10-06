package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.service.TeamService;

public class TeamDeleteController extends SimpleFormController {

    private TeamService service;

    public TeamDeleteController (TeamService service) {
        this.service = service;
    }

	public ModelAndView onSubmit(Object _command) {
		TeamDeleteCommand command = (TeamDeleteCommand)_command;
		int teamId = command.getTeamID();
		
		// Delete the entry from the database.
		service.deleteTeam(teamId);
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("name", ((TeamDeleteCommand)_command).getName());
		return new ModelAndView(getSuccessView(), model);
	}

}
