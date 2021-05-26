package fr.ibformation.scenarryo_back.dao;

import org.springframework.data.repository.CrudRepository;

import fr.ibformation.scenarryo_back.beans.Room;

public interface RoomDAO extends CrudRepository<Room, Integer> {

}
