package com.playserengeti.controller;

import java.awt.Color;
import java.awt.Image;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.service.TeamService;

public class TeamDeleteController extends AbstractCommandController {

    private TeamService service;

    public TeamDeleteController (TeamService service) {
        this.service = service;
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors) throws Exception {

        if (errors.hasErrors()) {
            return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());
        }

        TeamDeleteCommand command = (TeamDeleteCommand)commandObject;
        String name = command.getName();
        int teamID = command.getTeamID();
        int leaderID = command.getLeaderID();
        Color color = command.getColor();
        Image image = command.getImage();
        int homeLocation = command.getHomeLocation();


        String viewName = "teamDelete.jsp";

        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("name", name);
        mav.addObject("teamID", teamID);
        mav.addObject("leaderID", leaderID);
        mav.addObject("color", color);
        mav.addObject("image", image);
        mav.addObject("homeLocation", homeLocation);

        return mav;
    }

}
