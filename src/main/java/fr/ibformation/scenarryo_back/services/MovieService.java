package fr.ibformation.scenarryo_back.services;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.beans.MovieComments;


public interface MovieService {

	/**
	 * Function addMovie
	 * @param movie
	 */
	public void addMovie(Movie movie); 
	
	/**
	 * Function getAllMovies()
	 * @return List<Movie>
	 */
	public List<Movie> getAllMovies();

	/**
	 * Function getMovieById
	 * @param id
	 * @return List<Movie>
	 */
	public Optional<Movie> getMovieById(int id);

	
	/**
	 * Function deleteMovie()
	 * @Param movie
	 */
	public void deleteMovie(Movie movie);
	
	
	// ----------------------------------------------------------------------------------------------
	// methods associated to comments
	
	/**
	 * function getCommentsByMovieId :
	 * @param movieId
	 * @return List MovieComments
	 */
	public List<MovieComments> getCommentsByMovieId(int movieId);

	/**
	 * function postCommentsByMovie :
	 * @param id (id of the movie you want to add a comment)
	 * @param movie (movie you update with a new comment)
	 */
	public void postCommentsByMovie(int movieId, Movie movie);

	/**
	 * function getAllComments :
	 * @return List MovieComments
	 */
	public List<MovieComments> getAllComments();

	/**
	 * function getCommentsById :
	 * @param id
	 * @return MovieComments
	 */
	public MovieComments getCommentsById(int id);

	/**
	 * function addComment :
	 * @param movieComment (comment you want to save in bdd)
	 */
	public void addComment(MovieComments movieComment);

	// --------------------------------------------------------------------
	// methods associated to bad words filtering
	/**
	 * function badWordsFunction :
	 * @param text (text you want to identify badwords and replace them)
	 * @return String (same text but with bad words replaced by ***
	 * @throws FileNotFoundException (if you on't find the file of badwords)
	 */
	public String badWordsFunction(String text) throws FileNotFoundException;
	
}
