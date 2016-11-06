package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TrackingController {

	
	@RequestMapping(value = { "/tracking" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		
		return "tracking";
	}

	
}
