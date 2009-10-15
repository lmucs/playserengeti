package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Location;
import com.playserengeti.domain.Team;
import com.playserengeti.service.LocationService;



/*
 *LocationCreateController. The controller for creating a Location.
 */

public class LocationCreateController extends SimpleFormController {

    private LocationService locationService;

    public LocationCreateController (LocationService locationService) {
        this.locationService = locationService;
    }

    /**
     * Handles the submit functionality of the controller.  Currently only uses
     * name and color for development purposes.
     */
    /*
	public ModelAndView onSubmit(Object _command) {
		LocationCreateCommand command = (LocationCreateCommand)_command;
		Integer locationId;
		String locationName = command.getLocationName();
		double latitude = command.getLatitude();
		double longitude = command.getLongitude();
		Team teamOwnerId = command.getTeamOwnerId();
		Location location = new Location(null, locationName, latitude, longitude, teamOwnerId);


		// Insert the entry into the database.
		locationId = service.saveLocation(location);

		Map<String, String> model = new HashMap<String, String>();
		model.put("locationId", Integer.toString(locationId));
		model.put("locationName", locationName);
		model.put("latitude", Double.toString(latitude));
		model.put("longitude", Double.toString(longitude));
		if(teamOwnerId != null){
		     model.put("teamOwnerId", teamOwnerId.getName());
		}
		return new ModelAndView(getSuccessView(), model);
	}
	*/

	public ModelAndView onSubmit(Object _command) {
		LocationCreateCommand command = (LocationCreateCommand)_command;
		Integer locationId = command.getLocationId();

		//Modify the entry in the database
		Location location = locationService.getLocationById(locationId);
		location.setLocationName(command.getLocationName());
		location.setLatitude(Double.valueOf(command.getLatitude()));
		location.setLongitude(Double.valueOf(command.getLongitude()));
		location.setTeamOwnerId(command.getTeamOwnerId());

		try {
			// Insert the entry into the database.
			locationService.saveLocation(location);

			Map<String, String> model = new HashMap<String, String>();
			model.put("locationName", locationService.getLocationById(locationId).getLocationName());
			model.put("latitude", Double.toString(locationService.getLocationById(locationId).getLatitude()));
			model.put("longitude", Double.toString(locationService.getLocationById(locationId).getLongitude()));

			ModelAndView mav = new ModelAndView(getSuccessView(), model);
			mav.addObject(location);

			return mav;
		} catch (Exception e) {
			// On service error, try again
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("command", command);
			model.put("message", e.getMessage());
			return new ModelAndView(getFormView(), model);
		}
	}
}
