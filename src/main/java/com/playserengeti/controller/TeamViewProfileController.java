package com.playserengeti.controller;

import java.util.Collection;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;

/**
 * The controller for viewing a team's profile.
 * @author Chris
 *
 */
public class TeamViewProfileController extends AbstractCommandController {

    private TeamService teamService;
    private UserService userService;

    /**
     * Constructor.  Sets the service.
     * @param service
     */
    public TeamViewProfileController(TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }

    /**
     * Gets the team from the command and pushes it to the model.
     */
    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors)throws Exception {

        if (errors.hasErrors()) {
            return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());
        }

        TeamCommand command = (TeamCommand)commandObject;

        Integer teamId = command.getTeamId();
        Team team = null;
        if (teamId != null) {
            team = teamService.getTeamById(teamId);
        }
        
        command.setTeamId(teamId);
        command.setName(team.getName());
        command.setColor(team.getColor());
        command.setDescription(team.getDescription());
        command.setHomeBase(team.getHomeBase());
        command.setImage(team.getImage());
        if (team.getLeader() != null) command.setLeaderId(team.getLeader().getUserId());
        
		Collection<Integer> users = teamService.getTeamMembers(Integer.valueOf(teamId));
		Collection<User> members = new HashSet<User>();
		for (Integer id : users) {
			members.add(userService.getUserById(id));
		}

        ModelAndView mav = new ModelAndView("teamViewProfile");
        mav.addObject("teamCommand", command);
        mav.addObject("members", members);

        return mav;
    }
}
