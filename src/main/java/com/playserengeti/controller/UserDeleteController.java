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

import com.playserengeti.domain.Membership;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;

public class UserDeleteController extends SimpleFormController {

    private UserService userService;
    private TeamService teamService;

    public UserDeleteController(UserService userService, TeamService teamService) {
        this.userService = userService;
        this.teamService = teamService;
    }

    /**
     * Method provides the list of all users to the form view.
     */
    @Override
    protected ModelAndView showForm(HttpServletRequest request,
    		HttpServletResponse response, BindException errors,
    		Map model) throws Exception {
    	if (model == null) {
    		model = new HashMap();
    	}

    	model.put("allUsers", userService.getAllUsers());
    	return super.showForm(request, response, errors, model);
    }

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object _command, BindException errors)
			throws Exception {
		UserDeleteCommand command = (UserDeleteCommand)_command;
		Integer userId = command.getUserId();

    	try {
    		//Deletes memberships from the database.
    		Collection<Membership> memberships = teamService.getMembershipsByUser(userId);
    		for(Membership m : memberships) {
    			teamService.deleteMembership(m.getMembershipId());
    		}
    		
    		userService.deleteUser(userId);
    		return new ModelAndView(getSuccessView(), "userId", userId);
    	} catch (Exception e) {
    		Map<String, Object> model = new HashMap<String, Object>();
    		model.put("command", command);
    		model.put("message", e.getMessage());
    		return showForm(request, response, errors, model);
    	}
	}
}
