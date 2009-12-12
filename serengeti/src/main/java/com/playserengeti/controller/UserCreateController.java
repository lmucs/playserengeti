package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Avatar;
import com.playserengeti.domain.User;
import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

/**
 * Controller for creating a user.
 */
public class UserCreateController extends SimpleFormController {

    private UserService userService;
    private UserSession session;

    /**
     * Creates the controller, injecting a service.
     */
    public UserCreateController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object _command, BindException errors) {
        UserCommand command = (UserCommand) _command;
        Integer userId;
        String email = command.getEmail();
        String firstName = command.getFirstName();
        String lastName = command.getLastName();
        String password = command.getPassword();
        MultipartFile multipartFile = command.getImageFile();

        User user = new User(email, firstName, lastName);

        try {
            // Insert the entry into the database.
            userId = userService.insertUserWithPassword(user, password);
            session.setUser(userService.getUserById(userId));

            // Handle uploaded image.
            if (multipartFile != null) {
                // TODO Validate image time in validator.
                userService.setAvatarForUserId(
                        userId,
                        new Avatar(
                                multipartFile.getContentType(),
                                multipartFile.getBytes()));
            }

            ModelAndView mav = new ModelAndView("redirect:view");
            mav.addObject("userId", userId);

            return mav;

        } catch (Exception e) {
            e.printStackTrace();
            // On service error, try again
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("command", command);
            model.put("message", e.getMessage());
            return new ModelAndView(getFormView(), model);
        }
    }

    public UserSession getSession() {
        return session;
    }

    public void setSession(UserSession session) {
        this.session = session;
    }
}
