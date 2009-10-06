package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Location;
import com.playserengeti.service.LocationService;

/*
 *The controller for managing a location
 */

public class LocationUpdateController extends SimpleFormController {

	private LocationService service;

	public LocationUpdateController(LocationService service) {
		this.service = service;
	}

	public ModelAndView onSubmit(Object _command) {
		LocationUpdateCommand command = (LocationUpdateCommand)_command;
		Integer locationId = command.getLocationId();
		String locationName = command.getLocationName();
		double locationLatitude = command.getLocationLatitude();
		double locationLongitude = command.getLocationLongitude();
		Integer teamOwnerId = command.getTeamOwnerId();

		// Insert the entry into the database.
		service.saveLocation(new Location(locationId, locationName, locationLatitude, locationLongitude, teamOwnerId));

		Map<String, String> model = new HashMap<String, String>();
		model.put("locationId", Integer.toString(((LocationUpdateCommand)_command).getLocationId()));
		model.put("locationName", ((LocationUpdateCommand)_command).getLocationName());
		model.put("latitude", Double.toString(((LocationUpdateCommand)_command).getLocationLatitude()));
		model.put("longitude", Double.toString(((LocationUpdateCommand)_command).getLocationLongitude()));
		model.put("teamOwner", Integer.toString(((LocationUpdateCommand)_command).getTeamOwnerId()));
		return new ModelAndView(getSuccessView(), model);
	}
}
