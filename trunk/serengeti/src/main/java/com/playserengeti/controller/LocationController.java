package com.playserengeti.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.playserengeti.domain.Location;
import com.playserengeti.service.LocationService;
import com.playserengeti.service.TeamService;

public class LocationController extends MultiActionController {

	private LocationService locationService;
	private TeamService teamService;
	
	public LocationController(LocationService locationService, TeamService teamService) {
		this.locationService = locationService;
		this.teamService = teamService;
	}
	
	public ModelAndView location(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("redirect:location/");
	}
	
	public ModelAndView central(HttpServletRequest request, HttpServletResponse response) {
		Collection<Location> nearbyLocations = locationService.getAllLocations();
		
		ModelAndView mav = new ModelAndView("locationCentral");
		mav.addObject("nearbyLocations", nearbyLocations);
		
		return mav;
	}	
	
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
        Integer locationId = Integer.valueOf(request.getParameter("locationId"));
        LocationCommand locationCommand = new LocationCommand();
        
		if (locationId != null) {
			Location location = locationService.getLocationById(locationId);
		    locationCommand.setLocationId(location.getLocationId());
	    	locationCommand.setLocationName(location.getLocationName());
    		locationCommand.setLatitude(location.getLatitude());
    		locationCommand.setLongitude(location.getLongitude());
    		if (location.getTeamOwner() != null) locationCommand.setTeamOwner(location.getTeamOwner().getId());
            locationCommand.setStreet(location.getStreet());
            locationCommand.setCity(location.getCity());
            locationCommand.setState(location.getState());
            locationCommand.setZipcode(location.getZipcode());
    		locationCommand.setPhoneNumber(location.getPhoneNumber());
    		locationCommand.setDescription(location.getDescription());
    		locationCommand.setImage(location.getImage());
		}
		
		ModelAndView mav = new ModelAndView("locationViewProfile");
		mav.addObject("locationCommand", locationCommand);
		mav.addObject("teamList", teamService.getAllTeams());
		return mav;
	}
	
}
