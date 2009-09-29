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

public class UserListController extends AbstractController {

    private UserService service;

    public UserListController(UserService service) {
        this.service = service;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Collection<User> allUsers = service.getAllUsers();
        return new ModelAndView("userlist.jsp", "allUsers", allUsers);
    }
}
