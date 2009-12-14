package com.playserengeti.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.playserengeti.domain.Location;
import com.playserengeti.service.LocationService;
import com.playserengeti.service.VisitService;
import com.playserengeti.session.UserSession;

/**
 * The controller for handling location requests other than create/update. Uses
 * the method that matches the the url.
 * 
 * @author Chris
 * 
 */
public class LocationController extends MultiActionController {

	private LocationService locationService;
	private VisitService visitService;
	private UserSession session;

	public LocationController(LocationService locationService,
			VisitService visitService) {
		this.locationService = locationService;
		this.visitService = visitService;
	}

	/**
	 * Redirects to the root of the location url tree. Occurs on
	 * playserengeti.com/location
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView location(HttpServletRequest request,
			HttpServletResponse response) {
		return new ModelAndView("redirect:location/");
	}

	/**
	 * Displays the location central page. Output format based on the format
	 * parameter. Occurs on playserengeti.com/location/
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView central(HttpServletRequest request,
			HttpServletResponse response) {

		String view = "locationCentral";

		ModelAndView mav = new ModelAndView(view);
		mav.addObject("session", session);

		return mav;
	}

	/**
	 * Displays a location's profile. Output format based on the format
	 * parameter. Occurs on playserengeti.com/location/#locaitonId#
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView view(HttpServletRequest request,
			HttpServletResponse response) {
		Integer locationId = Integer
				.valueOf(request.getParameter("locationId"));
		LocationCommand locationCommand = new LocationCommand();

		if (locationId != null) {
			Location location = locationService.getLocationById(locationId);
			locationCommand.setId(location.getId());
			locationCommand.setName(location.getName());
			locationCommand.setLatitude(location.getLatitude());
			locationCommand.setLongitude(location.getLongitude());
			if (location.getOwner() != null) {
				locationCommand.setOwner(location.getOwner());
			}
			locationCommand.setPhoneNumber(location.getPhoneNumber());
			locationCommand.setStreet(location.getStreet());
			locationCommand.setCity(location.getCity());
			locationCommand.setState(location.getState());
			locationCommand.setZipcode(location.getZipcode());
		}

		String view = "locationViewProfile";
		if ("xml".equals(request.getParameter("format"))) {
			view = "locationViewProfileXML";
		}
		if ("json".equals(request.getParameter("format"))) {
			view = "locationViewProfileJSON";
		}

		ModelAndView mav = new ModelAndView(view);
		mav.addObject("session", session);
		mav.addObject("locationCommand", locationCommand);
		mav.addObject("competingTeams", visitService
				.getCompetingTeams(locationId));
		return mav;
	}

	/**
	 * Gets a list of nearby locations based on the given latitude and
	 * longitude. Writes the result as a JSON object to the response.
	 * 
	 * @param request
	 * @param response
	 */
	public void getNearbyLocations(HttpServletRequest request,
			HttpServletResponse response) {
		Double latitude = Double.valueOf(request.getParameter("latitude"));
		Double longitude = Double.valueOf(request.getParameter("longitude"));

		try {
			PrintWriter out = response.getWriter();
			out.println("{\"locations\" : "
					+ locationService.asJSON(locationService
							.getNearbyLocations(latitude, longitude)) + "}");
		} catch (IOException e) {
		}
	}

	/**
	 * Takes in information about a location and enters it into the serengeti
	 * database. Writes the location as a JSON object to the response.
	 * 
	 * @param request
	 * @param response
	 */
	public void handleResult(HttpServletRequest request,
			HttpServletResponse response) {
		double bound = .03;

		String name = request.getParameter("name");
		Double lat = Double.valueOf(request.getParameter("lat"));
		Double lng = Double.valueOf(request.getParameter("lng"));
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String phone = request.getParameter("phone");

		Location l = new Location(null, name, lat, lng);
		l.setStreet(street);
		l.setCity(city);
		l.setState(state);
		l.setPhoneNumber(phone);

		try {
			locationService.saveLocation(l);
		} catch (DataIntegrityViolationException e) {
			l = locationService.getLocationByName(name);
		}
		try {
			if (Math.abs(l.getLatitude() - lat) < bound
					&& Math.abs((l.getLongitude() - lng)) < bound) {
				PrintWriter out = response.getWriter();
				out.println(l.asMinimalJSON());
			}
		} catch (IOException e) {
		}
	}

	public UserSession getSession() {
		return session;
	}

	public void setSession(UserSession session) {
		this.session = session;
	}
}
