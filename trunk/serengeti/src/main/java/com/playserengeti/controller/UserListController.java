/*
 * UserDeleteController. Calls UserDeleteService and provides the result to userDelete.jsp
 */

package com.playserengeti.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.playserengeti.domain.User;
import com.playserengeti.service.UserService;

/**
 * Trivial controller for showing the view of all users in the system.
 */
public class UserListController extends AbstractController {

    private UserService service;

    public UserListController(UserService service) {
        this.service = service;
    }

    /*
     * TODO: Eventually this list will have to be paginated and sortable.
     */
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Collection<User> allUsers = service.getAllUsers();
        return new ModelAndView("userlist.jsp", "allUsers", allUsers);
    }
}
