package com.playserengeti.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Team;
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
		setSessionForm(true);
    }
    
	/**
	 * Sets the BackingObject to the team specified by the given teamId.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String teamId = request.getParameter("teamId");
        //String userId = request.getParameter("userId");
        
        Team team;
        TeamDeleteCommand deleteTeam = new TeamDeleteCommand();
		if (teamId != null) {
			team = service.getTeamById(Integer.valueOf(teamId));
		    deleteTeam.setTeamId(team.getId());
	    	deleteTeam.setName(team.getName());
		}
		
		//if (userID != null) deleteTeam.setUserId(Integer.valueOf(userId));
		
		return deleteTeam;
	}

    /**
     * Deletes the team from the database upon load then shows the list
     * of remaining teams.
     */
	@Override
	protected ModelAndView onSubmit(Object _command) {
        
		TeamDeleteCommand command = (TeamDeleteCommand)_command;
		
		Integer teamId = command.getTeamId();
		//Integer userId = command.getUserId();
				
		//Deletes the team from the database.
		service.deleteTeam(teamId);

        ModelAndView mav = new ModelAndView("redirect:central");
        
        //mav.addObject("userId", userId);
        
		return mav;
	}



}
