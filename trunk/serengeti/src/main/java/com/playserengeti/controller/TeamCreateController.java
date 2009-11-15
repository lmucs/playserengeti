package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Team;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

/**
 * The controller for creating a team.
 * @author Chris
 *
 */
public class TeamCreateController extends SimpleFormController {

    private TeamService teamService;
    private UserService userService;
    private UserSession session;

	/**
	 * Constructor.  Sets the service.
	 * @param service
	 */
    public TeamCreateController (TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }

	/**
	 * Sets the BackingObject of the .jsp page.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        TeamCommand teamCommand = new TeamCommand();
        teamCommand.setCandidates(userService.getFriendsMap(session.getUser().getId()));
        
		setSessionForm(true);
        return teamCommand;
	}
	
    /**
     * Handles the submit functionality of the controller.  
     */
	public ModelAndView onSubmit(Object _command) {
		TeamCommand command = (TeamCommand)_command;
		String name = command.getName();
		String color = command.getColor();

		Team team = new Team(null, name, color);
		team.setDescription(command.getDescription());
		team.setHomeBase(command.getHomeBase());
		team.setLeader(session.getUser());
		teamService.saveTeam(team);
 
		Integer teamId = team.getId();
		teamService.addToTeam(teamId, session.getUser().getId());
		Integer[] invitees = command.getInvitees();
		for(Integer id : invitees) {
			teamService.inviteToTeam(teamId, id);
		}
		
		ModelAndView mav = new ModelAndView("redirect:view");
		mav.addObject("teamId", team.getId());		
		
		return mav;
	}

	public UserSession getSession() {
		return session;
	}
	
	public void setSession(UserSession session) {
		this.session = session;
	}
}
