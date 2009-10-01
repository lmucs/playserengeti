package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.service.VisitService;


/**
 * Main controller for the calculator webapp.
 */
public class VisitCreateController extends AbstractCommandController {

    private VisitService service;

    public VisitCreateController(VisitService service) {
        this.service = service;
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

        if (errors.hasErrors()) {
            return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());
        }

        VisitCreateCommand command = (VisitCreateCommand)commandObject;
        Integer visitId = command.getVisitId();
        Integer userId = command.getUserId();
        Integer locationId = command.getlocationId();

        String viewName = "visitCreate.jsp";

        /*
        if ("xml".equals(command.getFormat())) {
            viewName = "visit.jspx";
        }
        */

        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("visitId", visitId);
        mav.addObject("userId", userId);
        mav.addObject("locationId", locationId);
        return mav;
    }
}
