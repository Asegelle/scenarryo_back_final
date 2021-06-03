package fr.ibformation.scenarryo_back.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.scenarryo_back.beans.BookedSeats;
import fr.ibformation.scenarryo_back.beans.FilmShow;
import fr.ibformation.scenarryo_back.services.FilmShowService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/film-show")
public class FilmShowController {

	@Autowired
	private FilmShowService filmShowService;
	
    // ------------------------- get --------------------------



	@GetMapping("/getAll")
	public List<FilmShow> getAllFilmShowes() {
		return filmShowService.displayAllFilmShowes();
	}
	
	
	@GetMapping("/book-seats-by-show/{id}")
	public List<BookedSeats> getBookedSeatsByShow(@PathVariable("id") int id ){
		
		return filmShowService.getBookedSeatsByShow(id);
	}
	
	@Transactional
	@PutMapping("/book-seat")
	public FilmShow bookASeat(@RequestBody BookedSeats bookedSeat) {
		filmShowService.bookASeat(bookedSeat);
		bookedSeat.getFilmShow().setBookedSeats(bookedSeat.getFilmShow().getBookedSeats() + 1);
		System.out.println(bookedSeat);
		return bookedSeat.getFilmShow();
	}
	
	@Transactional
	@PutMapping("/add-filmshow")
	public FilmShow addFilmShow(@RequestBody FilmShow show ) {
		return filmShowService.createShow(show);
		 
	}
	
	@Transactional
	@DeleteMapping("/delete-filmshow/{id}")
	public void deleteShowById(@PathVariable int id) {
		filmShowService.deleteById(id);
	}
	
}



