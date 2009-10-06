package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Location;
import com.playserengeti.service.LocationService;



/*
 *LocationCreateController. The controller for creating a Location.
 */

public class LocationCreateController extends SimpleFormController {

    private LocationService service;

    public LocationCreateController (LocationService service) {
        this.service = service;
    }

    /**
     * Handles the submit functionality of the controller.  Currently only uses
     * name and color for development purposes.
     */
	public ModelAndView onSubmit(Object _command) {
		LocationCreateCommand command = (LocationCreateCommand)_command;
		String locationName = command.getLocationName();
		double locationLatitude = command.getLocationLatitude();
		double locationLongitude = command.getLocationLongitude();
		Integer teamOwnerId = command.getTeamOwnerId();


		// Insert the entry into the database.
		service.saveLocation(new Location(null, locationName, locationLatitude, locationLongitude, teamOwnerId));

		Map<String, String> model = new HashMap<String, String>();
		model.put("locationId", Integer.toString(((LocationCreateCommand)_command).getLocationId()));
		model.put("locationName", ((LocationCreateCommand)_command).getLocationName());
		model.put("latitude", Double.toString(((LocationCreateCommand)_command).getLocationLatitude()));
		model.put("longitude", Double.toString(((LocationCreateCommand)_command).getLocationLongitude()));
		return new ModelAndView(getSuccessView(), model);
	}
}
