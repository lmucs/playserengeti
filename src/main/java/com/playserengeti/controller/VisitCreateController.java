package com.playserengeti.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.playserengeti.domain.Visit;
import com.playserengeti.service.VisitService;


/**
 * Main controller for the calculator webapp.
 */
public class VisitCreateController extends SimpleFormController {

    private VisitService service;

    public VisitCreateController(VisitService service) {
        this.service = service;
    }

	public ModelAndView onSubmit(Object _command) {
		VisitCreateCommand command = (VisitCreateCommand)_command;
		Integer userId = command.getUserId();
		Integer locationId = command.getVisitId();

		// Insert the entry into the database.
		try {
			service.saveVisit(new Visit(null, userId, null, locationId));
		} catch (NoSuchFieldException e) {
			Map<String, String> model = new HashMap<String, String>();
			model.put("error", (e.getMessage()));
			e.printStackTrace();
			return new ModelAndView(getFormView(), model);
		}

		Map<String, Integer> model = new HashMap<String, Integer>();
		model.put("visitId", ((VisitCreateCommand)_command).getVisitId());
		model.put("userId", ((VisitCreateCommand)_command).getUserId());
		model.put("locationId", ((VisitCreateCommand)_command).getLocationId());
		return new ModelAndView(getSuccessView(), model);
	}
}
