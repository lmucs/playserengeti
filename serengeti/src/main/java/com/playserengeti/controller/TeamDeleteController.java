package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.service.TeamService;

/**
 * The controller for handling the deletion of teams.
 * @author Chris
 *
 */
public class TeamDeleteController extends SimpleFormController {

    private TeamService service;

	/**
	 * Constructor.  Sets the service.
	 * @param service
	 */
    public TeamDeleteController (TeamService service) {
        this.service = service;
    }

    /**
     * On submit, takes the teamId and deletes it from the database.
     */
	public ModelAndView onSubmit(Object _command) {
		TeamDeleteCommand command = (TeamDeleteCommand)_command;
		int teamId = command.getTeamId();
		
		// Delete the entry from the database.
		service.deleteTeam(teamId);
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("name", ((TeamDeleteCommand)_command).getName());
		return new ModelAndView(getSuccessView(), model);
	}

}
