package fr.ibformation.scenarryo_back.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.scenarryo_back.beans.Schedule;
import fr.ibformation.scenarryo_back.services.ScheduleService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService scheduleService;
	
    // ------------------------- get --------------------------

	@GetMapping("/get")
	public List<Schedule> getAllSchedules() {
		return scheduleService.displayAllSchedules();
	}
	
	
    // ------------------------- delete --------------------------

	@DeleteMapping("/delete/{id}")
	public void deleteScheduleById (@PathVariable("id") int id) {
		scheduleService.deleteScheduleById(id);
	}
	
	
    // ------------------------- post --------------------------

	@PostMapping("/add")
	public Schedule addSchedule (@RequestBody Schedule schedule) {
		scheduleService.addSchedule(schedule);
		System.out.println(schedule);
		return schedule;
	}
	
	
    // ------------------------- put --------------------------

	@PutMapping("/update/{id}")
	public void updateSchedule (
			@PathVariable("id") int id,
			@RequestBody Schedule schedule) {
        Optional<Schedule> postSchedule = scheduleService.findScheduleById(id);
        if (postSchedule.isPresent()) {
        	scheduleService.updateSchedule(id, schedule);
        } else {
        	scheduleService.addSchedule(schedule);
        }

	}
	

	
}
