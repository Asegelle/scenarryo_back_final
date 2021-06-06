package fr.ibformation.scenarryo_back.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.scenarryo_back.beans.MovieCaroussel;
import fr.ibformation.scenarryo_back.services.MovieCarousselService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class MovieCarousselController {

	@Autowired
	MovieCarousselService movieCarousselService;
	
	
	@GetMapping("/moviecaroussel")
	public List<MovieCaroussel> getAllMovies() {
		return (List<MovieCaroussel>) movieCarousselService.getAllMovies();
	}
	
	@PostMapping("/addmoviecaroussel")
	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
	public List<MovieCaroussel> addMovie(@RequestBody MovieCaroussel movieCaroussel) {		
		movieCarousselService.addMovie(movieCaroussel);
		return getAllMovies();
	}
	
	
	@PostMapping("/deletemoviecaroussel")
	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
	public void deleteMovie(@RequestBody MovieCaroussel movieCaroussel) {
		System.out.println("controller" + movieCaroussel);
		movieCarousselService.deleteMovie(movieCaroussel);
	}
}
