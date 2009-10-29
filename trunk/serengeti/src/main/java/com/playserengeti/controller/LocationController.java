package com.playserengeti.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.playserengeti.domain.Location;
import com.playserengeti.service.LocationService;
import com.playserengeti.service.TeamService;
import com.playserengeti.service.VisitService;
import com.playserengeti.session.UserSession;

public class LocationController extends MultiActionController {

	private LocationService locationService;
	private TeamService teamService;
	private VisitService visitService;
	private UserSession session;
	
	public LocationController(LocationService locationService, TeamService teamService, VisitService visitService) {
		this.locationService = locationService;
		this.teamService = teamService;
		this.visitService = visitService;
	}
	
	public ModelAndView location(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("redirect:location/");
	}
	
	public ModelAndView central(HttpServletRequest request, HttpServletResponse response) {
		Collection<Location> nearbyLocations = locationService.getAllLocations();
		
		String view = "locationCentral";
        if("xml".equals(request.getParameter("format"))) {
        	view = "locationCentralXML";
        }
        
		ModelAndView mav = new ModelAndView(view);
		mav.addObject("session", session);
		mav.addObject("nearbyLocations", nearbyLocations);
		
		return mav;
	}	
	
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
        Integer locationId = Integer.valueOf(request.getParameter("locationId"));
        LocationCommand locationCommand = new LocationCommand();
        
        String[] address = new String[2];
		if (locationId != null) {
			Location location = locationService.getLocationById(locationId);
		    locationCommand.setLocationId(location.getLocationId());
	    	locationCommand.setLocationName(location.getLocationName());
    		locationCommand.setLatitude(location.getLatitude());
    		locationCommand.setLongitude(location.getLongitude());
    		if (location.getTeamOwner() != null) locationCommand.setTeamOwner(location.getTeamOwner().getId());
    		locationCommand.setPhoneNumber(location.getPhoneNumber());
    		locationCommand.setDescription(location.getDescription());
    		locationCommand.setImage(location.getImage());
    		address = location.getFormattedAddress();
		}
		
		String view = "locationViewProfile";
        if("xml".equals(request.getParameter("format"))) {
        	view = "locationViewProfileXML";
        }
		
		ModelAndView mav = new ModelAndView(view);
		mav.addObject("session", session);
		mav.addObject("locationCommand", locationCommand);
		mav.addObject("address", address);
		mav.addObject("competingTeams", visitService.getCompetingTeams(locationId));
		return mav;
	}
	
	public UserSession getSession() {
		return session;
	}
	
	public void setSession(UserSession session) {
		this.session = session;
	}
}
