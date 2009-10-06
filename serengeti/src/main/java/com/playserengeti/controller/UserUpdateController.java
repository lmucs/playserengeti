/*
 * UserUpdateController. Calls UserManageService and provides the result to userManage.jsp
 */

package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.service.UserService;

public class UserUpdateController extends AbstractCommandController {

    private UserService service;

    public UserUpdateController(UserService service) {
        this.service = service;
    }


    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

        if (errors.hasErrors()) {
            return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());
        }

        UserUpdateCommand command = (UserUpdateCommand)commandObject;
        String userID = command.getUserID();

        String viewName = "userManage.jsp";

        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("userID", userID);
        return mav;
    }
}
