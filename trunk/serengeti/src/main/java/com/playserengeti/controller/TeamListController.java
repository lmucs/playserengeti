package com.playserengeti.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.playserengeti.domain.Team;
import com.playserengeti.service.TeamService;

public class TeamListController extends AbstractController {
   
	private TeamService service;

    public TeamListController(TeamService service) {
        this.service = service;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Collection<Team> allTeams = service.getAllTeams();
        return new ModelAndView("teamList.jsp", "allTeams", allTeams);
    }

}
