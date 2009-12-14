package com.playserengeti.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.playserengeti.domain.Location;
import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;
import com.playserengeti.domain.Visit;
import com.playserengeti.service.LocationService;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.VisitService;
import com.playserengeti.session.UserSession;

/**
 * A multi-action controller for most of the team-related operations.
 */
public class TeamController extends MultiActionController {
	private Logger logger = Logger.getLogger(getClass());

	private TeamService teamService;
	private LocationService locationService;
	private VisitService visitService;
	private UserSession session;

	public TeamController(TeamService teamService,
			LocationService locationService, VisitService visitService) {
		this.teamService = teamService;
		this.locationService = locationService;
		this.visitService = visitService;
	}

	/**
	 * Redirects to the team central page. Occurs on playserengeti.com/team
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView team(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("redirect:team/");
	}

	/**
	 * Shows interesting information regarding teams. Output format is specified
	 * by the format parameter. Occurs on playserengeti.com/team/
	 */
	public ModelAndView central(HttpServletRequest request,
			HttpServletResponse response) {
		logger.debug("Entering team central");

		Collection<Team> leaders = teamService.getLeadingTeams();
		Collection<Team> mostActive = teamService.getMostActiveTeams();
		Collection<Team> newest = teamService.getNewestTeams();

		String view = "teamCentral";
		if ("xml".equals(request.getParameter("format"))) {
			view = "teamCentralXML";
		}
		if ("json".equals(request.getParameter("format"))) {
			view = "teamCentralJSON";
		}

		ModelAndView mav = new ModelAndView(view);
		mav.addObject("session", session);
		mav.addObject("leaders", leaders);
		mav.addObject("mostActive", mostActive);
		mav.addObject("newest", newest);

		return mav;
	}

	/**
	 * Brings up the given team's profile page. Output format is specified by
	 * the format parameter. Occurs on playserengeti.com/team/#teamId#
	 */
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) {
		logger.debug("Entering team view");

		Integer teamId = Integer.valueOf(request.getParameter("teamId"));

		Team team = null;
		if (teamId != null) {
			team = teamService.getTeamById(teamId);
		}

		TeamCommand command = new TeamCommand();
		command.setTeamId(teamId);
		command.setName(team.getName());
		command.setColor(team.getColor());
		command.setDescription(team.getDescription());
		command.setHomeBase(team.getHomeBase());

		if (team.getLeader() != null) {
			command.setLeader(team.getLeader());
		}
		command.setMembers(teamService.getTeamMembers(teamId));

		Collection<Visit> activity = visitService
				.getTeamsRecentActivity(teamId);
		Collection<Location> territory = locationService
				.getControlledTerritory(teamId);
		List<List<Double[]>> hull = locationService.getRegions(territory);

		String view = "teamViewProfile";
		if ("xml".equals(request.getParameter("format"))) {
			view = "teamViewProfileXML";
		}
		if ("json".equals(request.getParameter("format"))) {
			view = "teamViewProfileJSON";
		}

		String jsonData = "{\"locations\" : "
				+ locationService.asJSON(territory) + ", \"regions\" : "
				+ locationService.regionsAsJSON(hull) + "}";

		ModelAndView mav = new ModelAndView(view);
		mav.addObject("session", session);
		mav.addObject("teamCommand", command);
		mav.addObject("activity", activity);
		mav.addObject("territory", territory);
		mav.addObject("jsonData", jsonData.replace("'", "&#39"));

		return mav;
	}
	
	/**
	 * Removes the membership between the given user and team.
	 * 
	 * @param request
	 * @param response
	 */
	public void removeMember(HttpServletRequest request,
			HttpServletResponse response) {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer teamId = Integer.valueOf(request.getParameter("teamId"));

		teamService.removeFromTeam(teamId, userId);
	}

	public UserSession getSession() {
		return session;
	}

	public void setSession(UserSession session) {
		this.session = session;
	}
}
