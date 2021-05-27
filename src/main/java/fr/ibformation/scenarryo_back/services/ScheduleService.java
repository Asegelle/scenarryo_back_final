package fr.ibformation.scenarryo_back.services;

import java.util.List;

import fr.ibformation.scenarryo_back.beans.Schedule;

public interface ScheduleService {

	public List<Schedule> displayAllSchedules();

	public void deleteScheduleById(int id);

	public Schedule addSchedule(Schedule schedule);

	public Schedule updateSchedule(int id);

}
