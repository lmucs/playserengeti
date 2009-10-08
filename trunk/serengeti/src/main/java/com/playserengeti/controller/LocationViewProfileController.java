package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.playserengeti.domain.Location;
import com.playserengeti.service.LocationService;

/**
 * The controller for viewing a team's profile.
 *
 */
public class LocationViewProfileController extends AbstractCommandController {

	private LocationService service;

	/**
	 * Constructor.  Sets the service.
	 * @param service
	 */
	public LocationViewProfileController(LocationService service) {
		this.service = service;
	}

	/**
	 * Gets the locaiton from the command and pushes it to the model.
	 */
	@Override
	protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object commandObject,
            BindException errors)throws Exception {

    	if (errors.hasErrors()) {
    	    return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());
    	}

        LocationViewProfileCommand command = (LocationViewProfileCommand)commandObject;

        Integer locationId = command.getLocationId();
        Location location = null;
        if (locationId != null) {
        	location = service.getLocationById(locationId);
        }

        String viewName = "locationViewProfile.jsp";

        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("location", location);
        return mav;
	}
}
