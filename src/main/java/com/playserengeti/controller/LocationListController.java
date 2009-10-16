package com.playserengeti.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.playserengeti.domain.Location;
import com.playserengeti.service.LocationService;

/**
 * Controls the listing of all locations.  Should be modified to take in constraints
 * to allow for searching locations.
 *
 */
public class LocationListController extends AbstractController {

    private LocationService service;

    /**
     * Constructor.  Sets the service.
     * @param service
     */
    public LocationListController(LocationService service) {
        this.service = service;
    }

    /**
     * Passes a collection of all locations to the model.
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Collection<Location> allLocations = service.getAllLocations();
        return new ModelAndView("locationList", "allLocations", allLocations);
    }

}
