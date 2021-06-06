package fr.ibformation.scenarryo_back.services;

import java.util.List;

import fr.ibformation.scenarryo_back.beans.MovieCaroussel;

public interface MovieCarousselService {
	
	public List<MovieCaroussel> getAllMovies();
	
	public void addMovie(MovieCaroussel movieCaroussel);

	public void deleteMovie(MovieCaroussel movieCaroussel); 
}
