package fr.ibformation.scenarryo_back;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.ibformation.scenarryo_back.beans.Room;
import fr.ibformation.scenarryo_back.services.RoomService;

@SpringBootTest
public class RoomTests {
	
	@Autowired
	RoomService roomService;
	
	@Test
	void contextLoads() {
		
		roomService.getAllRooms().forEach(System.out::println);
		
		Room room = new Room(100, 670);
		roomService.addRoom(room);
		
		roomService.deleteRoom(room.getId());
	}

}
