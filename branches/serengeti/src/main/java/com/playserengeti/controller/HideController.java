/*
 * HideController. Calls HideService and provides the result to hide.jsp.
 * Probably there is no need for hide.jsp, but it can be corrected as needed.
 */

package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.service.HideService;

public class HideController extends AbstractCommandController {

    private HideService service;

    public HideController(HideService service) {
        this.service = service;
    }


    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

        if (errors.hasErrors()) {
            return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());
        }

        HideCommand command = (HideCommand)commandObject;

        String userID = command.getUserID();
        String viewName = "hide";

        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("userID", userID);
        return mav;
    }
}
