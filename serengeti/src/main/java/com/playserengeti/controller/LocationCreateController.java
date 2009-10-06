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

    /*
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
        HttpServletResponse response, Object commandObject,
        BindException errors) throws Exception {

    	if (errors.hasErrors()) {
    	    return new ModelAndView("errors.jspx", "errors", errors.getAllErrors());
    	}

        LocationCreateCommand command = (LocationCreateCommand)commandObject;
        String locationName = command.getLocationName();
        int locationId = command.getLocationID();
        String locationName = command.getLocationName();
        double locationLongitude = command.getLocationLongitude();
        double locationLatitude = command.getLocationLatitude();
//        int userOwnerId = command.getUserOwnerID();
        int teamOwnerId = command.getTeamOwnerID();

        String viewName = "locationCreate.jsp";

        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("locationName", locationName);
        mav.addObject("locationId", locationId);
        mav.addObject("locationLongitude", locationLongitude);
        mav.addObject("locationLatitude", locationLatitude);
//       mav.addObject("userOwnerId", userOwnerId);
        mav.addObject("teamOwnerId", teamOwnerId);

        return mav;
    }*/

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
		model.put("name", ((TeamCreateCommand)_command).getName());
		model.put("color", ((TeamCreateCommand)_command).getColor());
		return new ModelAndView(getSuccessView(), model);
	}
}
