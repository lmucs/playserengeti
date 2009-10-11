package com.playserengeti.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.playserengeti.domain.Team;
import com.playserengeti.service.TeamService;

/**
 * Controls the listing of all teams.  Should be modified to take in constraints
 * to allow for searching teams.
 * @author Chris
 *
 */
public class TeamListController extends AbstractController {

    private TeamService service;

    /**
     * Constructor.  Sets the service.
     * @param service
     */
    public TeamListController(TeamService service) {
        this.service = service;
    }

    /**
     * Passes a collection of all teams to the model.
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Collection<Team> allTeams = service.getAllTeams();
        return new ModelAndView("teamList", "allTeams", allTeams);
    }

}
