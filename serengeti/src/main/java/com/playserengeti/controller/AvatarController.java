package com.playserengeti.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.domain.Avatar;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.UserService;

public class AvatarController extends AbstractCommandController {

	private UserService userService;
	private TeamService teamService;
	
	public AvatarController(UserService userService, TeamService teamService) {
		this.userService = userService;
		this.teamService = teamService;
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object _command,
			BindException exceptions)
			throws Exception {
		
		AvatarCommand command = (AvatarCommand)_command;
		String entityType = command.getEntity();
		Integer entityId = command.getId();
		Avatar avatar;
		
		if (entityType.equals("user")) {
			avatar = userService.getUserAvatarByUserId(entityId);
		} else if (entityType.equals("team")){
			// TODO avatar = teamService.getTeamAvatarByTeamId(entity);
			avatar = teamService.getTeamAvatarByTeamId(entityId); // XXX NPE
		} else {
			// TODO Critical.
			avatar = null; // XXX GONNA RESULT IN AN NPE! Should probably be prevented in validation.
		}
		
		response.setCharacterEncoding(avatar.getMimeType());
		
		OutputStream out = response.getOutputStream();
		out.write(avatar.getBytes());
		out.flush();
		out.close();
		
		return null; // Signifies we sent a direct response.
	}

}
