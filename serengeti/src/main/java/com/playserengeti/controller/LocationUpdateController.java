package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.dao.TeamDao;
import com.playserengeti.domain.Location;
import com.playserengeti.service.LocationService;

/*
 *The controller for managing a location
 */

public class LocationUpdateController extends SimpleFormController {

	private LocationService service;
	private TeamDao teamDao;

	public LocationUpdateController(LocationService service, TeamDao teamDao) {
		this.service = service;
		this.teamDao = teamDao;
	}

	/**
	 * Sets the BackingObject to the location specified by the given locationId.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        String locationId = request.getParameter("locationId");
        Location location;
        LocationUpdateCommand updateLocation = new LocationUpdateCommand();
		if (locationId != null) {
			location = service.getLocationById(Integer.valueOf(locationId));
		    updateLocation.setLocationId(location.getLocationId());
	    	updateLocation.setLocationName(location.getLocationName());
    		updateLocation.setLatitude(location.getLatitude());
    		updateLocation.setLongitude(location.getLongitude());
    		if (location.getTeamOwnerId() != null) updateLocation.setTeamOwnerId(location.getTeamOwnerId());
		}

		return updateLocation;
	}

	public ModelAndView onSubmit(Object _command) {
		LocationUpdateCommand command = (LocationUpdateCommand)_command;
		Integer locationId = command.getLocationId();

		//Modify the entry in the database
		Location location = service.getLocationById(locationId);
		location.setLocationName(command.getLocationName());
		location.setLatitude(command.getLatitude());
		location.setLongitude(command.getLongitude());
		location.setTeamOwnerId(command.getTeamOwnerId());

		// Insert the entry into the database.
		service.saveLocation(location);

		Map<String, String> model = new HashMap<String, String>();
		model.put("locationName", service.getLocationById(locationId).getLocationName());

		ModelAndView mav = new ModelAndView(getSuccessView(), model);
		mav.addObject(location);

		return mav;
	}

}
