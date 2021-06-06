package fr.ibformation.scenarryo_back.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibformation.scenarryo_back.beans.MovieCaroussel;
import fr.ibformation.scenarryo_back.dao.MovieCarousselDAO;

@Service
public class MovieCarousselServiceImpl implements MovieCarousselService {

	
	// -------------------------------------------------------------------------------
	// ------------------ autowired ----------------------
	@Autowired
	MovieCarousselDAO movieCarousselDAO;
	
	
	// -------------------------------------------------------------------------------
	// ------------------ Methods ----------------------
	
	@Override
	public List<MovieCaroussel> getAllMovies() {
		return (List<MovieCaroussel>) movieCarousselDAO.findAll();
	}


	@Override
	@Transactional
	public void addMovie(MovieCaroussel movieCaroussel) {
		movieCarousselDAO.save(movieCaroussel);
		
	}


	@Override
	@Transactional
	public void deleteMovie(MovieCaroussel movieCaroussel) {
		System.out.println("service impl" + movieCaroussel);
		movieCarousselDAO.delete(movieCaroussel);
		
	}
	
	
	

	
}
