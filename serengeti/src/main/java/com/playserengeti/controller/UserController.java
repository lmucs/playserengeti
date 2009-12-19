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
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.service.VisitService;
import com.playserengeti.session.UserSession;

/**
 * The controller for dealing with users aside from create/update/delete.
 * 
 * @author Chris
 * 
 */
public class UserController extends MultiActionController {

	Logger logger = Logger.getLogger(getClass());

	private UserService userService;
	private TeamService teamService;
	private VisitService visitService;
	private UserSession session;

	public UserController(UserService userService, TeamService teamService,
			VisitService visitService) {
		this.userService = userService;
		this.teamService = teamService;
		this.visitService = visitService;
	}

	/**
	 * Redirects to user central. Occurs on playserengeti.com/user
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView user(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("redirect:user/");
	}

	/**
	 * Displays the user central page. Displays interesting information
	 * regarding users. Output format is specified by the format parameter.
	 * Occurs on playserengeti.com/user/
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView central(HttpServletRequest request,
			HttpServletResponse response) {

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

	/**
	 * Displays a given user's profile page. Output format is specified by the
	 * format parameter. Occurs on playserengeti.com/user/#userId#
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) {
		UserCommand command = new UserCommand();
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		User user = userService.getUserById(userId);
		String fileSuffix = user.getAvatarFileSuffix();
		String fileName;

		command.setUserId(user.getId());
		command.setEmail(user.getEmail());
		command.setFirstName(user.getFirstName());
		command.setLastName(user.getLastName());
		
		fileName = "/avatar/user/";
		if (fileSuffix != null) {
			command.setAvatarFileName(fileName + userId + "." + fileSuffix);
		} else {
			command.setAvatarFileName(fileName + "default_user.png");
		}

		Collection<User> friends = userService.getFriends(userId);
		Collection<Team> teams = teamService.getUsersTeams(userId);
		Collection<User> friendInvites = userService.getFriendInvites(userId);
		Collection<Team> teamInvites = teamService.getTeamInvites(userId);
		Collection<Visit> activity = visitService.getUsersRecentActivity(userId);
        Collection<Visit> friendActivity = visitService.getFriendsRecentActivity(userId);
		
		Collection<Team> invitableTeams = new HashSet<Team>();
		boolean alreadyFriends = true;
		if (session.isLoggedIn()) {
			alreadyFriends = friends.contains(session.getUser())
					|| friendInvites.contains(session.getUser())
					|| userService.getFriendInvites(session.getUser().getId())
							.contains(user);

			invitableTeams = teamService.getInvitableTeams(session.getUser()
					.getId(), userId);
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
		mav.addObject("friendActivity", friendActivity);
		mav.addObject("invitableTeams", invitableTeams);
		mav.addObject("alreadyFriends", alreadyFriends);

		return mav;
	}

	/**
	 * Logs out the current user.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {
		session.setUser(null);
		return new ModelAndView("redirect:/");
	}

	/**
	 * Checks in the given user, as a member of the given team, to the given
	 * location. Writes out the visit as a JSON object to the response.
	 * 
	 * @param request
	 * @param response
	 */
	public void checkIn(HttpServletRequest request, HttpServletResponse response) {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer teamId = Integer.valueOf(request.getParameter("teamId"));
		Integer locationId = Integer.valueOf(request.getParameter("locationId"));

		if (session.isLoggedIn() && session.getUser().getId().equals(userId)) {
			try {
				PrintWriter out = response.getWriter();
				out.println(visitService.checkIn(userId, teamId, locationId));
			} catch (IOException e) {
			}
		}
	}

	/**
	 * Removes the friendship between the two given users.
	 * 
	 * @param request
	 * @param response
	 */
	public void removeFriend(HttpServletRequest request,
			HttpServletResponse response) {
		Integer firstId = Integer.valueOf(request.getParameter("firstId"));
		Integer secondId = Integer.valueOf(request.getParameter("secondId"));
		if (session.isLoggedIn() && session.getUser().getId().equals(firstId)) {
    		userService.removeFriend(firstId, secondId);	
		}
	}

	/**
	 * Removes the membership between the given user and team.
	 * 
	 * @param request
	 * @param response
	 */
	public void removeTeam(HttpServletRequest request,
			HttpServletResponse response) {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer teamId = Integer.valueOf(request.getParameter("teamId"));
		if (session.isLoggedIn() && session.getUser().getId().equals(userId)) {
			Team team = teamService.getTeamById(teamId);
			if (userId.equals(team.getLeader().getId())) {
		    	try {
			    	PrintWriter out = response.getWriter();
				    out.println("leader");
	    		} catch (IOException e) {
		    	}
			}
			else {
		        teamService.removeFromTeam(teamId, userId);
			}
		}
	}

	/**
	 * Sends a friend invite from the user specified by firstId to the user
	 * specified by secondId.
	 * 
	 * @param request
	 * @param response
	 */
	public void sendFriendInvite(HttpServletRequest request,
			HttpServletResponse response) {
		Integer firstId = Integer.valueOf(request.getParameter("firstId"));
		Integer secondId = Integer.valueOf(request.getParameter("secondId"));
		if (session.isLoggedIn() && session.getUser().getId().equals(firstId)) {
  		    userService.sendFriendInvite(firstId, secondId);
		}
	}

	/**
	 * Accepts the friend invite from the user specified by firstId to the user
	 * specified by secondId. Writes the newly added friend as a JSON object to
	 * the response.
	 * 
	 * @param request
	 * @param response
	 */
	public void acceptFriendInvite(HttpServletRequest request,
			HttpServletResponse response) {
		Integer firstId = Integer.valueOf(request.getParameter("firstId"));
		Integer secondId = Integer.valueOf(request.getParameter("secondId"));

		if (session.isLoggedIn() && session.getUser().getId().equals(secondId)) {
    		userService.acceptFriendInvite(firstId, secondId);
	    	try {
		    	PrintWriter out = response.getWriter();
			    out.println(userService.getUserById(firstId).asMinimalJSON());
    		} catch (IOException e) {
	    	}
		}
	}

	/**
	 * Rejects the friend invitation from the user specified by firstId.
	 * 
	 * @param request
	 * @param response
	 */
	public void rejectFriendInvite(HttpServletRequest request,
			HttpServletResponse response) {
		Integer firstId = Integer.valueOf(request.getParameter("firstId"));
		Integer secondId = Integer.valueOf(request.getParameter("secondId"));
		if (session.isLoggedIn() && session.getUser().getId().equals(secondId)) {
		    userService.rejectFriendInvite(firstId, secondId);
		}
	}

	/**
	 * Sends an invitation for the given user to join the given team.
	 * 
	 * @param request
	 * @param response
	 */
	public void sendTeamInvite(HttpServletRequest request,
			HttpServletResponse response) {
		Integer teamId = Integer.valueOf(request.getParameter("teamId"));
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		if (session.isLoggedIn()) {
		    teamService.sendTeamInvite(teamId, userId);
		}
	}

	/**
	 * Accepts the team invitation for the given user to join the given team.
	 * 
	 * @param request
	 * @param response
	 */
	public void acceptTeamInvite(HttpServletRequest request,
			HttpServletResponse response) {
		Integer teamId = Integer.valueOf(request.getParameter("teamId"));
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		if (session.isLoggedIn() && session.getUser().getId().equals(userId)) {
		    teamService.acceptTeamInvite(teamId, userId);

		    try {
			    PrintWriter out = response.getWriter();
			    out.println(teamService.getTeamById(teamId).asMinimalJSON());
		    } catch (IOException e) {
		    }
		}
	}

	/**
	 * Rejects the team invitation for the given user to join the given team.
	 * 
	 * @param request
	 * @param response
	 */
	public void rejectTeamInvite(HttpServletRequest request,
			HttpServletResponse response) {
		Integer teamId = Integer.valueOf(request.getParameter("teamId"));
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		if (session.isLoggedIn() && session.getUser().getId().equals(userId)) {
		    teamService.rejectTeamInvite(teamId, userId);
		}
	}

	public UserSession getSession() {
		return session;
	}

	public void setSession(UserSession session) {
		this.session = session;
	}
}
