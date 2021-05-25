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

	@Override
	@Transactional
	public void addMovie(Movie movie) {
		movieDAO.save(movie);
	}

	@Override

	public List<Movie> getAllMovies() {

		// System.out.println(movieDAO.findAll());
		return (List<Movie>) movieDAO.findAll();
		
	}

}
