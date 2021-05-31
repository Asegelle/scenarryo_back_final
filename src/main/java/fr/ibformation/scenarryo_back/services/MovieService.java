package fr.ibformation.scenarryo_back.services;

import java.util.List;

import fr.ibformation.scenarryo_back.beans.Movie;


public interface MovieService {

	public void addMovie(Movie movie); 
	
	public List<Movie> getAllMovies();
	
	// public List<Movie> getMoviesByTitle(String title);
	
	public void deleteMovie(Movie movie);
}
