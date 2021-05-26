package fr.ibformation.scenarryo_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.scenarryo_back.beans.FilmShow;
import fr.ibformation.scenarryo_back.services.FilmShowService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FilmShowController {

	@Autowired
	private FilmShowService filmShowService;
	
    // ------------------------- get --------------------------

	@GetMapping("/film-show")
	public List<FilmShow> getAllFilmShowes() {
		return filmShowService.displayAllFilmShowes();
	}
	
}
