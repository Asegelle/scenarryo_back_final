package fr.ibformation.scenarryo_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.scenarryo_back.beans.Schedule;
import fr.ibformation.scenarryo_back.services.ScheduleService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;
	
    // ------------------------- get --------------------------

	@GetMapping("/admin/schedule")
	public List<Schedule> getAllSchedules() {
		return scheduleService.displayAllSchedules();
	}
	
	
	
	
	
}
