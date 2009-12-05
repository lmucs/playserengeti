/*
 * UserUpdateController. Calls UserManageService and provides the result to userManage.jsp
 */

package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.User;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

public class UserUpdateController extends SimpleFormController {

    private UserService userService;
    private TeamService teamService;
    private UserSession session;

    public UserUpdateController(UserService userService, TeamService teamService) {
        this.userService = userService;
        this.teamService = teamService;
        setSessionForm(true);
    }

    /**
     * Sets the BackingObject to the user specified by the given userId.
     */
    protected Object formBackingObject(HttpServletRequest request)
            throws Exception {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        User user;
        UserCommand userCommand = new UserCommand();
        if (userId != null) {
            user = userService.getUserById(userId);
            userCommand.setUserId(user.getId());
            userCommand.setEmail(user.getEmail());
            userCommand.setFirstName(user.getFirstName());
            userCommand.setLastName(user.getLastName());
            userCommand.setFriends(userService.getFriends(userId));
            userCommand.setTeams(teamService.getUsersTeams(userId));
        }

        return userCommand;
    }

    public ModelAndView onSubmit(Object _command) {
        UserCommand command = (UserCommand) _command;
        Integer userId = command.getUserId();

        // Modify the entry in the database
        User user = userService.getUserById(userId);
        user.setEmail(command.getEmail());
        user.setFirstName(command.getFirstName());
        user.setLastName(command.getLastName());

        // Update the entry in the database.
        userService.updateUser(user);
        userService.updateUserPassword(userId, command.getPassword());

        ModelAndView mav = new ModelAndView("redirect:/user/" + userId);

        return mav;
    }

    public UserSession getSession() {
        return session;
    }

    public void setSession(UserSession session) {
        this.session = session;
    }
}
