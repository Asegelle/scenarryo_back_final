package fr.ibformation.scenarryo_back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.ibformation.scenarryo_back.beans.FilmShow;
import fr.ibformation.scenarryo_back.dao.FilmShowDAO;

public class FilmShowServiceImpl implements FilmShowService {

	@Autowired
	FilmShowDAO filmShowDAO;
	
	
	@Override
	public List<FilmShow> displayAllFilmShowes() {
		System.out.println("display all filmShow");
		return (List<FilmShow>) filmShowDAO.findAll();
	}

}
