package fr.ibformation.scenarryo_back.dao;

import org.springframework.data.repository.CrudRepository;

import fr.ibformation.scenarryo_back.beans.Schedule;


public interface ScheduleDAO extends CrudRepository<Schedule, Integer>{

}
