package com.playserengeti.controller;

import java.util.Collection;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;
import com.playserengeti.service.LocationService;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.service.VisitService;

public class TeamController extends MultiActionController {
	
	private TeamService teamService;
	private UserService userService;
	private LocationService locationService;
	private VisitService visitService;
	
	public TeamController(TeamService teamService, UserService userService, LocationService locationService, VisitService visitService) {
		this.teamService = teamService;
		this.userService = userService;
		this.locationService = locationService;
		this.visitService = visitService;
	}
	
	public ModelAndView team (HttpServletRequest request, HttpServletResponse response) {
		return central(request, response);
	}
	
	/**
	 * The method to be used with going to /team.
	 * Shows interesting information regarding teams.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView central(HttpServletRequest request, HttpServletResponse response) {
		
		//TODO
		Collection<Team> leaders = teamService.getAllTeams();
		Collection<Team> mostActive = teamService.getAllTeams();
		Collection<Team> newest = teamService.getAllTeams();
		
		ModelAndView mav = new ModelAndView("teamCentral");
		mav.addObject("leaders", leaders);
		mav.addObject("mostActive", mostActive);
		mav.addObject("newest", newest);
		
		return mav;
	}	
	
	/**
	 * Brings up the given team's profile page.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
		TeamCommand command = new TeamCommand();
		Integer teamId = Integer.valueOf(request.getParameter("teamId"));
        Team team = null;
        if (teamId != null) {
            team = teamService.getTeamById(teamId);
        }
        
        command.setTeamId(teamId);
        command.setName(team.getName());
        command.setColor(team.getColor());
        command.setDescription(team.getDescription());
        command.setHomeBase(team.getHomeBase());
        command.setImage(team.getImage());
        if (team.getLeader() != null) command.setLeaderId(team.getLeader().getUserId());
        
		Collection<Integer> users = teamService.getTeamMembers(Integer.valueOf(teamId));
		Collection<User> members = new HashSet<User>();
		for (Integer id : users) {
			members.add(userService.getUserById(id));
		}

        ModelAndView mav = new ModelAndView("teamViewProfile");
        mav.addObject("teamCommand", command);
        mav.addObject("members", members);

        return mav;

	}
}
