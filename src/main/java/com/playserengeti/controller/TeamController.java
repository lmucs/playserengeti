package com.playserengeti.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.playserengeti.domain.Membership;
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
	 * The method called when a team is to be created.
	 * Creates a blank command object to be populated by the form.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView create(HttpServletRequest request, HttpServletResponse response) {
		TeamCommand command = new TeamCommand();
		
		Map<Integer, String> candidates = userService.getAllUsersMap();
		
		ModelAndView mav = new ModelAndView("teamCreate.jsp");
		mav.addObject("teamCommand", command);
		mav.addObject("candidates", candidates);
		
		return null;
	}
	
	/**
	 * Have to use a method to act as an onSubmit method for creating teams.
	 * Creates the team and memberships based on the form.  Goes to the team's 
	 * profile.
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 */
	public ModelAndView createSubmit(HttpServletRequest request, HttpServletResponse response, TeamCommand command) {
		Team team = new Team(null, command.getName(), command.getColor());
		team.setImage(command.getImage());
		team.setDescription(command.getDescription());
		team.setHomeBase(command.getHomeBase());
		//team.setLeader(currentUserId);
		
		teamService.saveTeam(team);
		
		Collection<Integer> invitees = command.getInvitees();
		for(Integer i : invitees) {
			teamService.saveMembership(new Membership(null, team.getId(), i));
		}
		
	    ModelAndView mav = new ModelAndView("redirect:team?method=view&teamid=" + team.getId().toString());
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
		command.setMembers(teamService.getTeamMembers(teamId));
		
		ModelAndView mav = new ModelAndView("teamProfile.jsp");
		mav.addObject("command", command);
		
		return mav;
	}
	
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, TeamCommand command) {
		ModelAndView mav = new ModelAndView("teamEdit.jsp");
		mav.addObject("command", command);
		return mav;
	}
	
	/**
	 * Have to use this method to act as an onSubmit for team edit.  Updates the 
	 * team with the results of the form and removes the selected memberships.  
	 * Goes to team's profile afterwards.
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 */
	public ModelAndView editSubmit(HttpServletRequest request, HttpServletResponse response, TeamCommand command) {
		Team team = teamService.getTeamById(command.getTeamId());
		team.setName(command.getName());
		team.setColor(command.getColor());
		team.setImage(command.getImage());
		team.setDescription(command.getDescription());
		team.setHomeBase(command.getHomeBase());
		
		//team.setLeader(currentUserId);
		
		teamService.saveTeam(team);
		
		Collection<Integer> removals = command.getRemovals();
		for(Integer id : removals) {
			Membership m = teamService.getMembershipByTeamAndUser(team.getId(), id);
			teamService.deleteMembership(m.getMembershipId());
		}
		
	    ModelAndView mav = new ModelAndView("redirect:team?method=view&teamid=" + team.getId().toString());
		return mav;		
	}

}
