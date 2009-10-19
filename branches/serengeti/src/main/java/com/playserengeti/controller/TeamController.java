package com.playserengeti.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.playserengeti.domain.Team;
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
	
	/**
	 * The method to be used with going to /team.
	 * Shows interesting information regarding teams.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView central(HttpServletRequest request, HttpServletResponse response) {
		
		Collection<Team> leaders = new HashSet<Team>();
		Collection<Team> mostActive = new HashSet<Team>();
		Collection<Team> newest = new HashSet<Team>();
		
		ModelAndView mav = new ModelAndView("teamCentral.jsp");
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
		Team team = teamService.getTeamById(teamId);
		
		command.setTeamId(teamId);
		command.setColor(team.getColor());
		command.setDescription(team.getDescription());
		command.setHomeBase(team.getHomeBase());
		command.setImage(team.getImage());
		//command.setLeaderId(team.getLeader().getUserId());
		
		Map<Integer, String> members = new HashMap<Integer, String>();
		Collection<Integer> users = teamService.getTeamMembers(teamId);
		for(Integer id : users) {
			members.put(id, userService.getUserById(id).getUserName());
		}
		command.setMembers(members);
		
		ModelAndView mav = new ModelAndView("teamProfile.jsp");
		mav.addObject("command", command);
		
		return mav;
	}
}
