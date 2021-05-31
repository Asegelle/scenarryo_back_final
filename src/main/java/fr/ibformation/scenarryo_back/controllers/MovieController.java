package fr.ibformation.scenarryo_back.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	// fonction afficher les fims

	@GetMapping("/movie")
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
	// fonction ajouter un film

	@PostMapping("/addmovie")
	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
	public List<Movie> addMovie(@RequestBody Movie movie) {		
		movieService.addMovie(movie);
		return getAllMovies();

	}
	
	// fonction supprimer un film
	
	@PostMapping("/deletemovie")
	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
	public  void deleteMovie(@RequestBody Movie movie) {
		movieService.deleteMovie(movie);
		
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
