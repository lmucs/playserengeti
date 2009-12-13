package com.playserengeti.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Team;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;
import com.playserengeti.session.UserSession;

/**
 * The controller for creating a team.
 */
public class TeamCreateController extends SimpleFormController {

	private TeamService teamService;
	private UserService userService;
	private UserSession session;

	/**
	 * Creates the controller.
	 */
	public TeamCreateController(TeamService teamService, UserService userService) {
		this.teamService = teamService;
		this.userService = userService;
	}

	/**
	 * Returns the backing object.
	 */
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		TeamCommand teamCommand = new TeamCommand();
		teamCommand.setCandidates(userService.getFriends(session.getUser()
				.getId()));
		setSessionForm(true);
		return teamCommand;
	}

	/**
	 * Handles the submit functionality of the controller.
	 */
	public ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object _command, BindException errors) {
		TeamCommand command = (TeamCommand) _command;
		String name = command.getName();
		String color = command.getColor();

		Team team = new Team(null, name, color);
		team.setDescription(command.getDescription());
		team.setHomeBase(command.getHomeBase());
		team.setLeader(session.getUser());
		MultipartFile multipartFile = command.getImageFile();

		try {
			teamService.saveTeam(team);

			if (multipartFile != null) {
				// TODO: THIS IS NOT SECURE
				// TODO: Veryfiy image type.
				// TODO: Save image with suffix, etc.
				// This is essentially a hack/beginning.
				// Consider saving image in DB.
				try {
					String path = request.getRealPath("/avatar")
							+ File.separator + team.getId() + "-"
							+ multipartFile.getOriginalFilename();
					FileOutputStream fileOut = new FileOutputStream(path);
					fileOut.write(multipartFile.getBytes());
					fileOut.close();

					logger.debug("Saved image " + path + ".");
				} catch (IOException e) {
					logger.warn("Unable to save image for team", e);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// On service error, try again
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("command", command);
			model.put("message", e.getMessage());
			return new ModelAndView(getFormView(), model);
		}

		Integer teamId = team.getId();
		Integer[] invitees = command.getInvitees();
		for (Integer id : invitees) {
			teamService.sendTeamInvite(teamId, id);
		}

		ModelAndView mav = new ModelAndView("redirect:view");
		mav.addObject("teamId", team.getId());

		return mav;
	}

	public UserSession getSession() {
		return session;
	}

	public void setSession(UserSession session) {
		this.session = session;
	}
}
