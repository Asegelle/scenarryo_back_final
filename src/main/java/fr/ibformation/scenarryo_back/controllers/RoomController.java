package fr.ibformation.scenarryo_back.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.beans.Room;
import fr.ibformation.scenarryo_back.services.RoomService;

@RestController
@RequestMapping("/admin/room")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	
	@GetMapping("/getAll")
	public List<Room> getAllRooms(){
		
		return roomService.getAllRooms();
	}
	@Transactional
	@DeleteMapping("/delete/{id}")
	public void deleteRoomById(@PathVariable int id) {
		// TODO gerer l'erreur de suppression lorsque la salle contien des showFilm planifiéed
		roomService.deleteRoom(id);
	}
	@PostMapping("/add")
	public void addRoom(@RequestBody Room room) {
		roomService.addRoom(room);
	}
}
