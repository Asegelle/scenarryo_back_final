package fr.ibformation.scenarryo_back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibformation.scenarryo_back.beans.Room;
import fr.ibformation.scenarryo_back.dao.RoomDAO;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomDAO roomDAO;
	
	@Override
	public List<Room> getAllRooms() {
		
		return (List<Room>) roomDAO.findAll();
	}

	@Override
	public void deleteRoom(int i) {
		roomDAO.deleteById(i);
	}

	@Override
	public void addRoom(Room room) {
		roomDAO.save(room);
		
	}

}
