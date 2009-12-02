package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

/**
 * Controller for producing the welcome page for Serengeti.
 */
public class WelcomeController extends AbstractController {

    private UserSession session;
    private UserService userService;
    
    public WelcomeController(UserService userService) {
    	this.userService = userService;
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("session", session);
        mav.addObject("newest", userService.getNewestUsers());
        return mav;
    }

    public UserSession getSession() {
        return session;
    }

    public void setSession(UserSession session) {
        this.session = session;
    }
}
