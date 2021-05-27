package fr.ibformation.scenarryo_back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibformation.scenarryo_back.beans.Schedule;
import fr.ibformation.scenarryo_back.dao.ScheduleDAO;

@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	ScheduleDAO scheduleDAO;
	
	
	@Override
	public List<Schedule> displayAllSchedules() {
		System.out.println("display all Schedules");
		return (List<Schedule>) scheduleDAO.findAll();
	}


	@Override
	public void deleteScheduleById(int id) {
		scheduleDAO.deleteById(id);
		
	}


	@Override
	public Schedule addSchedule(Schedule schedule) {
		System.out.println("--------- service add schedule ---------");
		System.out.println(schedule);
		return scheduleDAO.save(schedule);
	}


	@Override
	public Schedule updateSchedule(int id) {
		Schedule schedule = new Schedule();
		return scheduleDAO.save(schedule);
	}

}
