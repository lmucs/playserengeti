package com.playserengeti.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Team;
import com.playserengeti.domain.User;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

/**
 * Controller for updating/modifying teams.
 */
public class TeamUpdateController extends SimpleFormController {

    private TeamService teamService;
    private UserService userService;
    private UserSession session;

    /**
     * Creates the controller.
     */
    public TeamUpdateController(TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }

    /**
     * Sets the BackingObject to the team specified by the given teamId.
     */
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        Integer teamId = Integer.valueOf(request.getParameter("teamId"));

        TeamCommand teamCommand = new TeamCommand();
        Team team;

        if (teamId != null) {
            team = teamService.getTeamById(teamId);
            teamCommand.setTeamId(team.getId());
            teamCommand.setName(team.getName());
            teamCommand.setColor(team.getColor());
            teamCommand.setDescription(team.getDescription());
            teamCommand.setHomeBase(team.getHomeBase());
            if (team.getLeader() != null) {
                teamCommand.setLeader(team.getLeader());
            }
            Collection<Integer> members = teamService.getTeamMembers(teamId);
            Map<Integer, String> candidates = new HashMap<Integer, String>();
            User mem;
            for (Integer id : members) {
                mem = userService.getUserById(id);
                if (!id.equals(session.getUser().getId())) {
                    candidates.put(id, mem.getFirstName() + " " + mem.getLastName());
                }
            }
            teamCommand.setCandidates(candidates);
        }

        setSessionForm(true);
        return teamCommand;
    }

    /**
     * Modifies the database entry with the information from the command. Should
     * be modified to check what info has changed.
     */
    public ModelAndView onSubmit(Object _command) {
        TeamCommand command = (TeamCommand) _command;
        Integer teamId = command.getTeamId();

        // Modify the entry in the database.
        Team team = teamService.getTeamById(teamId);
        team.setName(command.getName());
        team.setColor(command.getColor());
        if (command.getLeader() != null) {
            team.setLeader(userService.getUserById(command.getLeader().getId()));
        }
        team.setDescription(command.getDescription());
        team.setHomeBase(command.getHomeBase());

        teamService.saveTeam(team);

        Integer[] removals = command.getRemovals();
        for (Integer id : removals) {
            teamService.removeFromTeam(teamId, id);
        }

        ModelAndView mav = new ModelAndView("redirect:/team/" + teamId);

        return mav;
    }

    public UserSession getSession() {
        return session;
    }

    public void setSession(UserSession session) {
        this.session = session;
    }
}
