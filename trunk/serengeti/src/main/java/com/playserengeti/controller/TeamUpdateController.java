package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

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
		setSessionForm(true);
	}
	
	/**
	 * Sets the BackingObject to the team specified by the given teamId.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String teamId = request.getParameter("teamId");
        Team team;
        TeamUpdateCommand updateTeam = new TeamUpdateCommand();
		if (teamId != null) {
			team = service.getTeamById(Integer.valueOf(teamId));
		    updateTeam.setTeamId(team.getId());
	    	updateTeam.setName(team.getName());
    		updateTeam.setColor(team.getColor());
    		if (team.getLeaderId() != null) updateTeam.setLeaderId(team.getLeaderId());
    		if (team.getHomeLocation() != null) updateTeam.setHomeLocation(team.getHomeLocation());
    		if (team.getImage() != null) updateTeam.setImage(team.getImage());
		}
		
		return updateTeam;
	}
	
	/**
	 * Modifies the database entry with the information from the command.  
	 * Should be modified to check what info has changed.
	 */
	public ModelAndView onSubmit(Object _command) {
		TeamUpdateCommand command = (TeamUpdateCommand)_command;
		int teamId = command.getTeamId();
		
		// Modify the entry in the database.
		Team team = service.getTeamById(teamId);
		team.setColor(command.getColor());
		team.setLeaderId(command.getLeaderId());
		team.setHomeLocation(command.getHomeLocation());
		team.setImage(command.getImage());
		
		service.saveTeam(team);

		String success = "teamViewProfile.jsp?teamId=" + Integer.toString(teamId);
		
		ModelAndView mav = new ModelAndView(success);
		mav.addObject(team);

		return mav;
	}
    
}
