/*
 * UserDeleteController. Calls UserDeleteService and provides the result to userDelete.jsp
 */

package com.playserengeti.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Friendship;
import com.playserengeti.domain.Membership;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

public class UserDeleteController extends SimpleFormController {

    private UserService userService;
    private TeamService teamService;
    private UserSession session;

    public UserDeleteController(UserService userService, TeamService teamService) {
        this.userService = userService;
        this.teamService = teamService;
    }

    /**
     * Method provides the list of all users to the form view.
     */
    protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
    	Integer userId = Integer.valueOf(request.getParameter("userId"));
    	UserCommand userCommand = new UserCommand();
    	
    	userCommand.setUserId(userId);
    	userCommand.setEmail(userService.getUserById(userId).getEmail());
    	
    	setSessionForm(true);
    	return userCommand;
    }

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object _command, BindException errors)
			throws Exception {
		UserCommand command = (UserCommand)_command;
		Integer userId = command.getUserId();

    	try {
    		//Deletes memberships from the database.
    		Collection<Membership> memberships = teamService.getMembershipsByUser(userId);
    		for(Membership m : memberships) {
    			teamService.deleteMembership(m.getMembershipId());
    		}
    		//Deletes friendships from the database.
    		Collection<Friendship> friendships = userService.getFriendshipsByUser(userId);
    		for(Friendship f : friendships) {
    			userService.deleteFriendship(f.getFriendshipId());
    		}
    		
    		session.setUser(null);
    		//Deletes the user from the database.
    		userService.deleteUser(userId);
    		
    		return new ModelAndView("redirect:/");
    	} 
    	
    	catch (Exception e) {
    		Map<String, Object> model = new HashMap<String, Object>();
    		model.put("command", command);
    		model.put("message", e.getMessage());
    		return showForm(request, response, errors, model);
    	}
	}
	
	public UserSession getSession() {
		return session;
	}
	
	public void setSession(UserSession session) {
		this.session = session;
	}
}
