package com.playserengeti.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Location;
import com.playserengeti.service.LocationService;
import com.playserengeti.session.UserSession;

/**
 * Controller for creating a Location.
 */
public class LocationCreateController extends SimpleFormController {

	private LocationService locationService;
	private UserSession session;

	public LocationCreateController(LocationService locationService) {
		this.locationService = locationService;
	}
	
	/**
	 * Returns the backing object.
	 */
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		LocationCommand locationCommand = new LocationCommand();
		if (session.isLoggedIn()) {
			locationCommand.setSessionId(session.getUser().getId());
		}
		setSessionForm(true);
		return locationCommand;
	}

	/**
	 * Creates a location based on the information on the form.
	 */
	public ModelAndView onSubmit(Object _command) {
		LocationCommand command = (LocationCommand) _command;

		if (session.isLoggedIn()) {
			Location location = new Location(null, command.getName(), 
					command.getLatitude(), command.getLongitude());
			location.setStreet(command.getStreet());
			location.setCity(command.getCity());
			location.setState(command.getState());
			location.setZipcode(command.getZipcode());
			location.setPhoneNumber(command.getPhoneNumber());

			locationService.saveLocation(location);

			ModelAndView mav = new ModelAndView("redirect:view", "locationId",
					location.getId());
			return mav;
		}
		return new ModelAndView("redirect:location/");
	}

	public UserSession getSession() {
		return session;
	}

	public void setSession(UserSession session) {
		this.session = session;
	}
}
