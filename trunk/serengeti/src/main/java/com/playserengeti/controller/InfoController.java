package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.playserengeti.session.UserSession;

public class InfoController extends MultiActionController{

	private UserSession session;
	
	public ModelAndView about(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("about", "session", session);
	}
	
	public ModelAndView contact(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("contact", "session", session);
	}
	
	public ModelAndView privacy(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("privacy", "session", session);
	}
	
	public ModelAndView terms(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("terms", "session", session);
	}
	
	public ModelAndView help(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("help", "session", session);
	}

	public UserSession getSession() {
		return session;
	}

	public void setSession(UserSession session) {
		this.session = session;
	}
}
