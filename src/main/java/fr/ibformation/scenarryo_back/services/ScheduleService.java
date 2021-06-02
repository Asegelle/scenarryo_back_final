package fr.ibformation.scenarryo_back.services;

import java.util.List;
import java.util.Optional;

import fr.ibformation.scenarryo_back.beans.Schedule;

public interface ScheduleService {

    // ------------------------- get --------------------------

	/**
	 * function displayAllSchedules :
	 * @return List Schedule
	 */
	public List<Schedule> displayAllSchedules();

	/**
	 * function findScheduleById :
	 * @param id (id of the schedule you want to get)
	 * @return Optional Schedule
	 */
	public Optional<Schedule> findScheduleById(int id);
	
	
    // ------------------------- delete --------------------------

	/**
	 * function deleteScheduleById :
	 * @param id (id of the schedule to delete)
	 */
	public void deleteScheduleById(int id);

	
    // ------------------------- post --------------------------

	/**
	 * function addSchedule (schedule you post from the form in angular)
	 * @param schedule
	 * @return Schedule
	 */
	public Schedule addSchedule(Schedule schedule);

	
    // ------------------------- put --------------------------
	
	/**
	 * function updateSchedule :
	 * @param id (id of the schedule to update)
	 * @return Schedule
	 */
	public Schedule updateSchedule(int id);
	
	/**
	 * function updateSchedule :
	 * @param id (id of the schedule to update)
	 * @param schedule (schedule you post from the form in angular)
	 */
	public void updateSchedule(int id, Schedule schedule);

}
