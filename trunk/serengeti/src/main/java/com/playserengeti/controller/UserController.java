package com.playserengeti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;
import com.playserengeti.domain.Visit;
import com.playserengeti.service.LocationService;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.service.VisitService;
import com.playserengeti.session.UserSession;

public class UserController extends MultiActionController {

    Logger logger = Logger.getLogger(getClass());

    private UserService userService;
    private TeamService teamService;
    private LocationService locationService;
    private VisitService visitService;
    private UserSession session;

    public UserController(UserService userService, TeamService teamService,
            LocationService locationService, VisitService visitService) {
        this.userService = userService;
        this.teamService = teamService;
        this.locationService = locationService;
        this.visitService = visitService;
    }

    public ModelAndView user(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("redirect:user/");
    }

    public ModelAndView central(HttpServletRequest request, HttpServletResponse response) {

        Collection<Visit> recentlyCheckedIn = visitService.getRecentCheckIns();
        Collection<User> mostActive = userService.getMostActiveUsers();
        Collection<User> newest = userService.getNewestUsers();

        String view = "userCentral";
        if ("xml".equals(request.getParameter("format"))) {
            view = "userCentralXML";
        }
        if ("json".equals(request.getParameter("format"))) {
            view = "userCentralJSON";
            response.setContentType("application/json");
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

        command.setUserId(user.getId());
        command.setEmail(user.getEmail());
        command.setFirstName(user.getFirstName());
        command.setLastName(user.getLastName());
        
        String profileData = generateProfileData(userId).replace("'", "&#39");
            	
    	Collection<User> friends = userService.getFriends(userId);
        Collection<Team> teams = teamService.getUsersTeams(userId);
        Collection<User> friendInvites = userService.getFriendInvites(userId);
        Collection<Team> teamInvites = teamService.getTeamInvites(userId);
        Collection<Visit> activity = visitService.getUsersRecentActivity(userId);
        
        Collection<Team> invitableTeams = new HashSet<Team>();
        boolean alreadyFriends = true;
        if (session.isLoggedIn()) {
            alreadyFriends = friends.contains(session.getUser())
            || friendInvites.contains(session.getUser())
            || userService.getFriendInvites(session.getUser().getId())
                    .contains(user);

            invitableTeams = teamService.getInvitableTeams(session.getUser().getId(), userId);
        }
        
        String view = "userViewProfile";
        if ("xml".equals(request.getParameter("format"))) {
            view = "userViewProfileXML";
        }
        if ("json".equals(request.getParameter("format"))) {
       		view = "userViewProfileJSON";
        }
        
        command.setFriends(friends);
        command.setTeams(teams);
        
        ModelAndView mav = new ModelAndView(view);
        mav.addObject("userCommand", command);
        mav.addObject("session", session);
        mav.addObject("friendInvites", friendInvites);
        mav.addObject("teamInvites", teamInvites);
        mav.addObject("activity", activity);
        mav.addObject("invitableTeams", invitableTeams);
        mav.addObject("alreadyFriends", alreadyFriends);
        mav.addObject("profileData", profileData);

        return mav;
    }

    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        session.setUser(null);
        return new ModelAndView("redirect:/");
    }

    public void checkIn(HttpServletRequest request, HttpServletResponse response) {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        Integer teamId = Integer.valueOf(request.getParameter("teamId"));
        Integer locationId = Integer.valueOf(request.getParameter("locationId"));

        if (!userId.equals(-1)) {
        	try {
    		    PrintWriter out = response.getWriter();
    		    out.println(visitService.checkIn(userId, teamId, locationId));	
            }
    	    catch(IOException e) {}
        }
    }

    public void removeFriend(HttpServletRequest request, HttpServletResponse response) {
        Integer firstId = Integer.valueOf(request.getParameter("firstId"));
        Integer secondId = Integer.valueOf(request.getParameter("secondId"));

        userService.removeFriend(firstId, secondId);
    }

    public void removeTeam(HttpServletRequest request, HttpServletResponse response) {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        Integer teamId = Integer.valueOf(request.getParameter("teamId"));

        teamService.removeFromTeam(teamId, userId);
    }

    public void sendFriendInvite(HttpServletRequest request, HttpServletResponse response) {
        Integer firstId = Integer.valueOf(request.getParameter("firstId"));
        Integer secondId = Integer.valueOf(request.getParameter("secondId"));

        if (!firstId.equals(-1)) userService.sendFriendInvite(firstId, secondId);
    }

    public void acceptFriendInvite(HttpServletRequest request, HttpServletResponse response) {
        Integer firstId = Integer.valueOf(request.getParameter("firstId"));
        Integer secondId = Integer.valueOf(request.getParameter("secondId"));

        if (!secondId.equals(-1)) {
        	userService.acceptFriendInvite(firstId, secondId);
        
            try {
    		    PrintWriter out = response.getWriter();
    		    out.println(userService.getUserById(firstId).asMinimalJSON());	
            }
    	    catch(IOException e) {}
        }
    }

    public void rejectFriendInvite(HttpServletRequest request, HttpServletResponse response) {
        Integer firstId = Integer.valueOf(request.getParameter("firstId"));
        Integer secondId = Integer.valueOf(request.getParameter("secondId"));

        if (!secondId.equals(-1)) userService.rejectFriendInvite(firstId, secondId);
    }

    public void sendTeamInvite(HttpServletRequest request, HttpServletResponse response) {
        Integer teamId = Integer.valueOf(request.getParameter("teamId"));
        Integer userId = Integer.valueOf(request.getParameter("userId"));

        teamService.sendTeamInvite(teamId, userId);
    }

    public void acceptTeamInvite(HttpServletRequest request, HttpServletResponse response) {
        Integer teamId = Integer.valueOf(request.getParameter("teamId"));
        Integer userId = Integer.valueOf(request.getParameter("userId"));

        if (!userId.equals(-1)) {
        	teamService.acceptTeamInvite(teamId, userId);
        
            try {
    		    PrintWriter out = response.getWriter();
    		    out.println(teamService.getTeamById(teamId).asMinimalJSON());	
            }
    	    catch(IOException e) {}
        }
    }

    public void rejectTeamInvite(HttpServletRequest request, HttpServletResponse response) {
        Integer teamId = Integer.valueOf(request.getParameter("teamId"));
        Integer userId = Integer.valueOf(request.getParameter("userId"));

        if (!userId.equals(-1)) teamService.rejectTeamInvite(teamId, userId);
    }	
    
    private String generateProfileData(Integer userId) {
    	User user = userService.getUserById(userId);
    	
    	Collection<User> friends = userService.getFriends(userId);
        Collection<Team> teams = teamService.getUsersTeams(userId);
        Collection<User> friendInvites = userService.getFriendInvites(userId);
        Collection<Team> teamInvites = teamService.getTeamInvites(userId);
        Collection<Visit> activity = visitService.getUsersRecentActivity(userId);
        
        Collection<Team> invitableTeams = new HashSet<Team>();
        boolean alreadyFriends = true;
        if (session.isLoggedIn()) {
            alreadyFriends = friends.contains(session.getUser())
            || friendInvites.contains(session.getUser())
            || userService.getFriendInvites(session.getUser().getId())
                    .contains(user);

            invitableTeams = teamService.getInvitableTeams(session.getUser().getId(), userId);
        }
        Integer sessionId;
        if (session.isLoggedIn()) sessionId = session.getUser().getId();
        else {
        	sessionId = -1;
        }
        
        String result = "{\"user\" : " + user.asJSON() + ", \"friends\" : " + userService.asJSON(friends) +
            ", \"teams\" : " + teamService.asJSON(teams) + ", \"invites\" : {\"friendInvites\" : " + 
            userService.asJSON(friendInvites) + ", \"teamInvites\" : " + 
            teamService.asJSON(teamInvites) + "}, \"invitableTeams\" : " + 
            teamService.asJSON(invitableTeams) + ", \"activity\" : " + 
            visitService.asJSON(activity) + ", \"alreadyFriends\" : \"" + 
            alreadyFriends + "\", \"sessionId\" : \"" + sessionId + "\"}";
        
    	return result;
    }
    
    public UserSession getSession() {
        return session;
    }

    public void setSession(UserSession session) {
        this.session = session;
    }
}
