package fr.ibformation.scenarryo_back.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.ibformation.scenarryo_back.beans.BookedSeats;
import fr.ibformation.scenarryo_back.beans.FilmShow;

public interface BookedSeatsDAO extends CrudRepository<BookedSeats, Integer> {

	// List<BookedSeats> findByFilmShow(FilmShow show);
	@Modifying
	@Query("update FilmShow f set f.bookedSeats = :newBookedSeats where f.id = :id")
	void updateBookedSeats(@Param(value = "id") int id, @Param(value = "newBookedSeats") int newBookedSeats);

}
