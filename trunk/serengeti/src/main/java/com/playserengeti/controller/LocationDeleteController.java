package com.playserengeti.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Location;
import com.playserengeti.service.LocationService;

/*
 *The controller for deleting a location
*/

public class LocationDeleteController extends SimpleFormController {

	private LocationService service;

	public LocationDeleteController (LocationService service) {
		this.service = service;
	}

	/**
	 * Sets the BackingObject to the team specified by the given teamId.
	 */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
        Integer locationId = Integer.valueOf(request.getParameter("locationId"));
        Location location;
        LocationDeleteCommand deleteLocation = new LocationDeleteCommand();
		if (locationId != null) {
			location = service.getLocationById(locationId);
		    deleteLocation.setLocationId(location.getLocationId());
	    	deleteLocation.setLocationName(location.getLocationName());
		}

		return deleteLocation;
	}

    @Override
	protected ModelAndView onSubmit(Object _command) {

		LocationDeleteCommand command = (LocationDeleteCommand)_command;

		Integer locationId = command.getLocationId();

		Map<String, String> model = new HashMap<String, String>();
		model.put("locationName", service.getLocationById(locationId).getLocationName());
		model.put("deleted", "true");

		ModelAndView mav = new ModelAndView(getSuccessView(), model);

		//Deletes the team from the database.
		service.deleteLocation(locationId);

        Collection<Location> allLocations = service.getAllLocations();
        mav.addObject("allLocations", allLocations);

		return mav;
	}
}
