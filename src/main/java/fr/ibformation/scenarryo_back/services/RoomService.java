package fr.ibformation.scenarryo_back.services;

import java.util.List;

import fr.ibformation.scenarryo_back.beans.Room;

public interface RoomService {
	
	public List<Room> getAllRooms();
	public void deleteRoom(int i);
	public void addRoom(Room room);
}
