package fr.ibformation.scenarryo_back.services;

import java.util.List;

import fr.ibformation.scenarryo_back.beans.BookedSeats;
import fr.ibformation.scenarryo_back.beans.FilmShow;

public interface FilmShowService {

	public List<FilmShow> displayAllFilmShowes();
	
	public void deleteById(int id);

	public FilmShow createShow(FilmShow filmShow);

	public void bookASeat(BookedSeats bookedSeat);

	public List<BookedSeats> getBookedSeatsByShow(int id);

//	public FilmShow getById(int id);

	
}
