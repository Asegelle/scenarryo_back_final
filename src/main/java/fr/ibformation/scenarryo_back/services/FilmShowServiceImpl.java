package fr.ibformation.scenarryo_back.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibformation.scenarryo_back.beans.BookedSeats;
import fr.ibformation.scenarryo_back.beans.FilmShow;
import fr.ibformation.scenarryo_back.dao.BookedSeatsDAO;
import fr.ibformation.scenarryo_back.dao.FilmShowDAO;

@Service
public class FilmShowServiceImpl implements FilmShowService {

	@Autowired
	FilmShowDAO filmShowDAO;
	
	@Autowired
	BookedSeatsDAO bookedDAO;
	
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


	@Override
	@Transactional
	public void bookASeat(BookedSeats bookedSeat) {
		filmShowDAO.updateBookedSeats(bookedSeat.getFilmShow().getId(), bookedSeat.getFilmShow().getBookedSeats()+1);
		bookedDAO.save(bookedSeat);
	}
	
	@Override
	public FilmShow getById(int id) {
		System.out.println("dans service ");
		System.out.println(filmShowDAO.findById(id).orElse(null));
		return filmShowDAO.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public List<BookedSeats> getBookedSeatsByShow(int id) {
		
//		return (List<BookedSeats>) bookedDAO.findByFilmShow(getById(id));
		return null;
	}
	
	


//	@Override
//	public void bookASeat(int id, int newBookedSeats, FilmShow filmShow) {
//		
//		
//		filmShowDAO.updateBookedSeats(id, newBookedSeats);
//		bookedDAO.save(new BookedSeats(1,1, filmShow));
//	}


	

}
