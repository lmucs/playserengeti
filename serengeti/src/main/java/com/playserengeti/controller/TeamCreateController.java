package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Team;
import com.playserengeti.service.TeamService;

/**
 * The controller for creating a team.
 * @author Chris
 *
 */
public class TeamCreateController extends SimpleFormController {

    private TeamService service;

	/**
	 * Constructor.  Sets the service.
	 * @param service
	 */
    public TeamCreateController (TeamService service) {
        this.service = service;
    }

    /**
     * Handles the submit functionality of the controller.  Currently only uses
     * name and color for development purposes.
     */
	public ModelAndView onSubmit(Object _command) {
		TeamCreateCommand command = (TeamCreateCommand)_command;
		String display = command.getName();
		String color = command.getColor();
		Integer leaderId = Integer.valueOf(command.getLeaderId());
		String homeLocation = command.getHomeLocation();
		String image = command.getImage();
		
		Team team = new Team(null, display, color);
		if (leaderId != null) team.setLeaderId(leaderId);
		if (homeLocation != null) team.setHomeLocation(homeLocation);
		if (image != null) team.setImage(image);
		
		// Insert the entry into the database.
		service.saveTeam(team);
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("name", display);
		model.put("color", color);
		model.put("leaderId", leaderId.toString());
		model.put("homeLocation", homeLocation.toString());
		model.put("image", image);
		
		return new ModelAndView(getSuccessView(), model);
	}

}
