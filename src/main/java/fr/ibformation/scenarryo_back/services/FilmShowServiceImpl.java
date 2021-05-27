package fr.ibformation.scenarryo_back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibformation.scenarryo_back.beans.FilmShow;
import fr.ibformation.scenarryo_back.dao.FilmShowDAO;

@Service
public class FilmShowServiceImpl implements FilmShowService {

	@Autowired
	FilmShowDAO filmShowDAO;
	
	
	@Override
	public List<FilmShow> displayAllFilmShowes() {
		System.out.println("display all filmShow");
		return (List<FilmShow>) filmShowDAO.findAll();
	}


	@Override
	public void deleteById(int id) {
		filmShowDAO.deleteById(id);
		
	}


	@Override
	public FilmShow createShow(FilmShow filmShow) {
		System.out.println("--------- service create filmShow ---------");
		System.out.println(filmShow);
		return filmShowDAO.save(filmShow);
	}

}
