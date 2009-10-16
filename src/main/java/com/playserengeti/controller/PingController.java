/*
 * PingController. Calls PingService and provides the result to ping.jsp.
 * Probably there is no need for ping.jsp, but it can be corrected as needed.
 */

package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.service.PingService;

public class PingController extends AbstractCommandController {

    private PingService service;

    public PingController(PingService service) {
        this.service = service;
    }


    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

        if (errors.hasErrors()) {
            return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());
        }

        PingCommand command = (PingCommand)commandObject;

        String userID = command.getUserID();

        //these values should eventually be provided by querying the userID
        double lat = command.getLat();
        double lon = command.getLon();

        String viewName = "ping";

        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("lat", lat);
        mav.addObject("lon", lon);
        mav.addObject("userID", userID);
        return mav;
    }
}
