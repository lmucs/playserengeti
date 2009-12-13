package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.service.LocationService;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

/**
 * The controller for searching serengeti.
 * 
 * @author Chris
 * 
 */
public class SearchController extends SimpleFormController {

	private UserService userService;
	private TeamService teamService;
	private LocationService locationService;
	private UserSession session;

	public SearchController(UserService userService, TeamService teamService,
			LocationService locationService) {
		this.userService = userService;
		this.teamService = teamService;
		this.locationService = locationService;
	}

	/**
	 * Runs the search based on the information entered in the search bar.
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object _command, BindException errors) {
		SearchCommand command = (SearchCommand) _command;
		String query = command.getQuery();
		ModelAndView mav = new ModelAndView("results");
		mav.addObject("session", session);
		mav.addObject("users", userService.searchUsers(query));
		mav.addObject("teams", teamService.searchTeams(query));
		mav.addObject("locations", locationService.searchLocations(query));
		return mav;
	}

	public UserSession getSession() {
		return session;
	}

	public void setSession(UserSession session) {
		this.session = session;
	}

}
