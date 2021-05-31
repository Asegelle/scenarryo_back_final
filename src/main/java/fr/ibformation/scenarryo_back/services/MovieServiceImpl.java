package fr.ibformation.scenarryo_back.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.dao.MovieDAO;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDAO movieDAO;

	

	// fonction d'affichage des films
	
	@Override
	public List<Movie> getAllMovies() {

		return (List<Movie>) movieDAO.findAll();
		
	}

	
//	// fonction pour accèder à un film dans la base de donnée
//	@Override
//	public List<Movie> getMoviesByTitle(String title) {
//		
//		return (List<Movie>) movieDAO.findAllByTitle(title);
//	}

	
	
	// fonction d'ajout de film dans la bdd
	
		@Override
		@Transactional
		public void addMovie(Movie movie) {
			movieDAO.save(movie);
		}
		
		
	// Fonction supprimer un film
		
	@Override
	public void deleteMovie(Movie movie) {
		movieDAO.delete(movie);
	}

	
}
