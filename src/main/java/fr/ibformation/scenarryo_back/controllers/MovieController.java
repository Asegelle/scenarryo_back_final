package fr.ibformation.scenarryo_back.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.services.MovieService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostConstruct
	@Transactional
	public void init() {

		movieService.getAllMovies();
	}

	@GetMapping("/movie")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@PostMapping("/movie")
	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
	public void addMovie(@RequestBody Movie movie) {
		System.out.println("------------------------" + movie);
		movieService.addMovie(movie);

	}
	
//	//add movie by admin
//	@PostMapping("/addmovie")
//	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
//	public void addMovieAdmin(@RequestBody Movie movie) {
//		movieService.addMovie(movie);
//
//	}
// TODO
//	@GetMapping("/movie")
//	public Movie getMovieByTitle() {
//		return (Movie) movieService.getAllMovies();
//	}

}
