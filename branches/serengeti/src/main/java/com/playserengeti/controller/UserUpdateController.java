/*
 * UserUpdateController. Calls UserManageService and provides the result to userManage.jsp
 */

package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.User;
import com.playserengeti.service.UserService;

public class UserUpdateController extends SimpleFormController {

    private UserService userService;

    public UserUpdateController(UserService userService) {
        this.userService = userService;
    }

	/**
	 * Sets the BackingObject to the user specified by the given userId.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String userId = request.getParameter("userId");
        User user;
        UserUpdateCommand updateUser = new UserUpdateCommand();
		if (userId != null) {
			user = userService.getUserById(Integer.valueOf(userId));
		    updateUser.setUserId(user.getUserId());
	    	updateUser.setUserName(user.getUserName());
    		updateUser.setPasswordHash(user.getPasswordHash());
    		if(user.getFirstName() != null) updateUser.setFirstName(user.getFirstName());
    		if(user.getLastName() != null) updateUser.setLastName(user.getLastName());
    		updateUser.setEmail(user.getEmail());
    		if(user.getDateOfBirth() != null) updateUser.setDateOfBirth(user.getDateOfBirth());

		}

		return updateUser;
	}

	public ModelAndView onSubmit(Object _command) {
		UserUpdateCommand command = (UserUpdateCommand)_command;
		Integer userId = command.getUserId();

		//Modify the entry in the database
		User user = userService.getUserById(userId);
		user.setUserName(command.getUserName());
		user.setPasswordHash(command.getPasswordHash());
		user.setFirstName(command.getFirstName());
		user.setLastName(command.getLastName());
		user.setEmail(command.getEmail());
		user.setDateOfBirth(command.getDateOfBirth());

		// Insert the entry into the database.
		userService.saveUser(user);

		Map<String, String> model = new HashMap<String, String>();
		model.put("userName", userService.getUserById(userId).getUserName());

		ModelAndView mav = new ModelAndView(getSuccessView(), model);
		mav.addObject(user);

		return mav;
	}
}
