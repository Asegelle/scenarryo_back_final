package fr.ibformation.scenarryo_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.beans.Room;
import fr.ibformation.scenarryo_back.services.RoomService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	
	@GetMapping("/room/get-all")
	public List<Room> getAllRooms(){
		
		return roomService.getAllRooms();
	}
}
