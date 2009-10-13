package com.playserengeti.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;

public class TeamInviteController extends SimpleFormController {
	
	private TeamService teamService;
	private UserService userService;
	
	public TeamInviteController (TeamService teamService, UserService userService) {
		this.teamService = teamService;
		this.userService = userService;
	}
	
	/**
	 * Sets the BackingObject to the team specified by the given teamId.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {

        String teamId = request.getParameter("teamId");
        //String userId = request.getParameter("userId");
       
        TeamInviteCommand teamInvite = new TeamInviteCommand();
        Team team;
        
        if (teamId != null) {
        	team = teamService.getTeamById(Integer.valueOf(teamId));
        	teamInvite.setTeamId(team.getId());
        }
        
        /*
        User user;
        if (userId != null) {
            user = userService.getUserById(Integer.valueOf(userId));
            teamInvite.setUserId(user.getUserId());
            teamInvite.setUsers(the users friends);
        }
        */
        
        Map<Integer, String> users = new HashMap<Integer, String>();
        Collection<User> allUsers = userService.getAllUsers();
        
        for (User u : allUsers) {
        	users.put(u.getUserId(), u.getUserName());
        }
        teamInvite.setUsers(users);
        
		setSessionForm(true);
		return teamInvite;
	}
	
	/**
	 * Takes the selected users and puts them on the team.
	 */
	public ModelAndView onSubmit(Object _command) {
		TeamInviteCommand command = (TeamInviteCommand)_command;
		Integer teamId = command.getTeamId();
		//Integer userId = command.getUserId();
		
        Team team = teamService.getTeamById(teamId);
        Integer[] invitees = command.getInvitees();
        
        for (Integer i : invitees) {
        	team.addMember(userService.getUserById(i));
        }
        
        teamService.saveTeam(team);
        
        ModelAndView mav = new ModelAndView("redirect:view");
        mav.addObject("teamId", teamId);
        //mav.addAllObject("userId", userId);
        
		return mav;
    }


}
