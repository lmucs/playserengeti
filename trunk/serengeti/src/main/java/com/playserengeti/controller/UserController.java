package com.playserengeti.controller;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.playserengeti.domain.Location;
import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;
import com.playserengeti.service.LocationService;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.service.VisitService;
import com.playserengeti.session.UserSession;

public class UserController extends MultiActionController {
	
	private UserService userService;
	private TeamService teamService;
	private LocationService locationService;
	private VisitService visitService;
	private UserSession session;
	
	public UserController(UserService userService, TeamService teamService, LocationService locationService, VisitService visitService) {
		this.userService = userService;
		this.teamService = teamService;
		this.locationService = locationService;
		this.visitService = visitService;
	}
	
	public ModelAndView user(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("redirect:user/");
	}
	
	public ModelAndView central(HttpServletRequest request, HttpServletResponse response) {
		
		//TODO
		Collection<User> recentlyCheckedIn = userService.getAllUsers();
		Collection<User> mostActive = userService.getAllUsers();
		Collection<User> newest = userService.getAllUsers();
		
		String view = "userCentral";
        if("xml".equals(request.getParameter("format"))) {
        	view = "userCentralXML";
        }
        if("json".equals(request.getParameter("format"))) {
        	view = "userCentralJSON";
        }
		
		ModelAndView mav = new ModelAndView(view);
		mav.addObject("session", session);
		mav.addObject("recent", recentlyCheckedIn);
		mav.addObject("mostActive", mostActive);
		mav.addObject("newest", newest);
		
		return mav;
	}
	
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
		UserCommand command = new UserCommand();
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        User user = userService.getUserById(userId);

        command.setUserId(user.getUserId());
        command.setEmail(user.getEmail());
        command.setDisplayName(user.getDisplayName());
        command.setImage(user.getImage());

        Collection<User> friends = userService.getFriends(userId);
        Collection<Team> teams = teamService.getTeams(user.getUserId());
		Collection<Location> nearbyLocations = locationService.getAllLocations();
        Map<Integer, User> friendInvites = userService.getFriendInvitesMap(userId);
        
        String view = "userViewProfile";
        if("xml".equals(request.getParameter("format"))) {
        	view = "userViewProfileXML";
        }
        if("json".equals(request.getParameter("format"))) {
        	view = "userViewProfileJSON";
        }
        
        ModelAndView mav = new ModelAndView(view);
        mav.addObject("userCommand", command);
        mav.addObject("teams", teams);
        mav.addObject("friends", friends);
        mav.addObject("friendInvites", friendInvites);
        //TODO check if a friend request was sent too
        mav.addObject("alreadyFriends", friends.contains(session.getUser()));
        mav.addObject("nearbyLocations", nearbyLocations);
        mav.addObject("session", session);
        

        return mav;
	}
	
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		session.setUser(null);
		return new ModelAndView("welcome");
	}
	
	public void checkIn(HttpServletRequest request, HttpServletResponse response) {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer teamId = Integer.valueOf(request.getParameter("teamId"));
		Integer locationId = Integer.valueOf(request.getParameter("locationId"));
      
		visitService.checkIn(userId, teamId, locationId);
	}
	
	public void removeFriend(HttpServletRequest request, HttpServletResponse response) {
		Integer primaryId = Integer.valueOf(request.getParameter("pUserId"));
		Integer secondaryId = Integer.valueOf(request.getParameter("sUserId"));

		userService.removeFriendship(primaryId, secondaryId);
	}
	
	public void removeTeam(HttpServletRequest request, HttpServletResponse response) {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer teamId = Integer.valueOf(request.getParameter("teamId"));
		
		teamService.removeFromTeam(teamId, userId);
	}
	
	public void sendFriendInvite(HttpServletRequest request, HttpServletResponse response) {
		Integer pUserId = Integer.valueOf(request.getParameter("pUserId"));
		Integer sUserId = Integer.valueOf(request.getParameter("sUserId"));
		
		userService.inviteFriend(pUserId, sUserId);
	}
	
	public void acceptFriendInvite(HttpServletRequest request, HttpServletResponse response) {
		Integer friendshipId = Integer.valueOf(request.getParameter("friendshipId"));
		
		userService.acceptFriend(friendshipId);
	}
	
	public UserSession getSession() {
		return session;
	}
	
	public void setSession(UserSession session) {
		this.session = session;
	}
}
