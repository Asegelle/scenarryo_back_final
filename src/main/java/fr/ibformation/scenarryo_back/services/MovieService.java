package fr.ibformation.scenarryo_back.services;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.beans.MovieComments;


public interface MovieService {

	public void addMovie(Movie movie); 
	
	public List<Movie> getAllMovies();


	public Optional<Movie> getMovieById(int id);

	
	// public List<Movie> getMoviesByTitle(String title);
	
	public void deleteMovie(Movie movie);
	

	public List<MovieComments> getCommentsByMovieId(int movieId);

	public void postCommentsByMovie(int movieId, Movie movie);

	public List<MovieComments> getAllComments();

	public MovieComments getCommentsById(int id);

	public void addComment(MovieComments movieComment);

	public String badWordsFunction(String text) throws FileNotFoundException;
	
}
