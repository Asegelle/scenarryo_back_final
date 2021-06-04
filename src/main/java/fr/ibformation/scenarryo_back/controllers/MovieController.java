package fr.ibformation.scenarryo_back.controllers;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.beans.MovieComments;
import fr.ibformation.scenarryo_back.services.MovieService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class MovieController {

	@Autowired
	private MovieService movieService;

	
	// ------------------------ CRUD of movies -----------------------------
	
	/**
	 * Function @Get getAllMovies()
	 * @return movieService.getAllMovies()
	 */
	@GetMapping("/movie")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	
	/**
	 * Function @Post getAllMoviesAngular
	 * @return
	 */
	@PostMapping("/rest")
	public List<Movie> getAllMoviesAngular() {
		return movieService.getAllMovies();
	}
	
	
	/**
	 * Function getMovieById for page Detail Movie
	 * @param id
	 * @return movieService.getMovieById(id)
	 */
	@GetMapping("/rest/{id}")
	public Optional<Movie> getMovieById(@PathVariable("id") int id) {
		return movieService.getMovieById(id);
	}
		
	
	/**
	 * Function @Post addMovie in BDD from API
	 * @param movie
	 * @return getAllMovies()
	 */
	@PostMapping("/addmovie")
	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
	public List<Movie> addMovie(@RequestBody Movie movie) {		
		movieService.addMovie(movie);
		return getAllMovies();
	}
		
	/**
	 * Function @Post deleteMovie
	 * @param movie
	 */
	@PostMapping("/deletemovie")
	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
	public  void deleteMovie(@RequestBody Movie movie) {
		movieService.deleteMovie(movie);
	}
	
		
//	/**
//	 * Function addMovieAdmin() by form by admin
//	 */
//	@PostMapping("/addmoviebyform")
//	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
//	public List<Movie> addMovieByForm(@RequestBody Movie movie) {
//		movieService.addMovie(movie);
//		return getAllMovies();
//
//	}


	
	
	// ------------------------ comments of movies -----------------------------
	
	/**
	 * function getAllComments :
	 * @return movieService.getAllComments();
	 */
	@GetMapping("/rest/comments")
	public List<MovieComments> getAllComments() {
		return movieService.getAllComments();
	}
	
	/**
	 * function getCommentsByMovieId :
	 * @param movieId (id of the movie you want to get comments)
	 * @return movieService.getCommentsByMovieId(movieId);
	 */
	@GetMapping("/rest/comments/movie/{id}")
	public List<MovieComments> getCommentsByMovieId(@PathVariable("id") int movieId) {
		return movieService.getCommentsByMovieId(movieId);
	}
	
	/**
	 * function getCommentsById :
	 * @param id (id of the comment)
	 * @return movieService.getCommentsById(id);
	 */
	@GetMapping("/rest/comments/{id}")
	public MovieComments getCommentsById(@PathVariable("id") int id) {
		return movieService.getCommentsById(id);
	}
	
	/**
	 * function postCommentsByMovie :
	 * @param id (id of the movie you want to add a comment)
	 * @param movie (movie you update with a new comment)
	 */
	@PutMapping("/rest/comments/{movie_id}")
	public void postCommentsByMovie(
			@PathVariable("movie_id") int id,
			@RequestBody Movie movie
			) {
		movieService.postCommentsByMovie(id, movie);
	}
	
	//post comment not associated to a movie
	/**
	 * function postComments :
	 * @param movieComment (comment you want to save in bdd)
	 * @return movieComment
	 */
	@PostMapping("/rest/comments")
	public MovieComments postComments(@RequestBody MovieComments movieComment) {
		movieService.addComment(movieComment);
		System.out.println(movieComment);
		return movieComment;
	}
	
	// ------------------------ bad words filtering -----------------------------

	// method to filter bad word(registered in a list) in the comments		
	String text = "tu es un connard.";
	/**
	 * function badWordsFunction :
	 * @param text (text you want to identify badwords and replace them)
	 * @throws FileNotFoundException (if you on't find the file of badwords)
	 */
	// send back the comments with "****" to replace the bad words
	public void badWordsFunction(String text) throws FileNotFoundException {
		String returnedText;
		try {
			returnedText = movieService.badWordsFunction(text);
		    System.out.println(returnedText);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	
}
