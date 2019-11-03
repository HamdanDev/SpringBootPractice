package com.devroom.location.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devroom.location.entities.Location;
import com.devroom.location.repose.LocationRepository;
import com.devroom.location.service.LocationService;
import com.devroom.location.util.EmailUtil;
import com.devroom.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;
	
	@Autowired
	LocationRepository repository;

	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = service.saveLocation(location);
		String msg = "Location saved " + locationSaved.getId();
		modelMap.addAttribute("message", msg);

		emailUtil.sendEmail("email@gmail.com", "location saved", "body");

		return "createLocation";
	}

	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.deleteLocation(location);
		String msg = "Location is deleted ";
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		modelMap.addAttribute("message", msg);
		return "displayLocations";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Object location = service.getLocationById(id);

		if (((Optional<Location>) location).isPresent()) {
			modelMap.addAttribute("location", ((Optional<Location>) location).get());
			return "updateLocation";
		}

		return "error";
	}

	@RequestMapping("/updateLoc")
	public String udateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.updateLocation(location);
		String msg = "Location updated is :" + location.getId();
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		modelMap.addAttribute("message", msg);
		return "displayLocations";
	}

	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);		
		return "report";
	}

}
