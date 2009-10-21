package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Location;
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
     * Don't think this is even needed.
     */
	protected Object formBackingObject(HttpServletRequest request)
    throws Exception {
	    LocationCommand locationCommand = new LocationCommand();
	    
	    setSessionForm(true);
		return locationCommand;
	}	

	public ModelAndView onSubmit(Object _command) {
		LocationCommand command = (LocationCommand)_command;

		Location location = new Location(null, command.getLocationName(), command.getLongitude(), command.getLatitude());
		location.setStreet(command.getStreet());
		location.setCity(command.getCity());
		location.setState(command.getState());
		location.setZipcode(command.getZipcode());
		location.setDescription(command.getDescription());
		location.setPhoneNumber(command.getPhoneNumber());
		location.setImage(command.getImage());
		
		locationService.saveLocation(location);
		
		ModelAndView mav = new ModelAndView("redirect:view");
		mav.addObject("locationId", location.getLocationId());		
		
		return mav;		
	}
}
