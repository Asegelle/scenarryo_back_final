package fr.ibformation.scenarryo_back.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.enums.AgeEnum;
import fr.ibformation.scenarryo_back.services.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@PostConstruct
	@Transactional
	public void init() {
		//movieService.addMovie(new Movie("José", LocalDate.parse("2008-05-18"), AgeEnum.M_16, "test", 208, "url"));
		//movieService.addMovie(new Movie("Rosé", LocalDate.parse("2008-05-18"), AgeEnum.M_16, "test2", 208, "url"));
		
		movieService.getAllMovies();
	}
	
	@GetMapping("/rest")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	
	@GetMapping("/rest/{id}")
	public Movie getMovieById(@PathVariable("id") int id) {
		return movieService.getMovieById(id);
	}
	
	
	@PostMapping("/rest")
	public List<Movie> getAllMoviesAngular() {
		return movieService.getAllMovies();
	}
	
	
}
