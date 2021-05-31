package fr.ibformation.scenarryo_back.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@Transactional
	@PutMapping("/book-seat")
	public FilmShow bookASeat(@RequestBody FilmShow filmShow) {
		
		filmShowService.bookASeat(filmShow.getId(), filmShow.getBookedSeats()+1);
		filmShow.setBookedSeats(filmShow.getBookedSeats() + 1);
		return filmShow;
	}
	
}



