package fr.ibformation.scenarryo_back.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.ibformation.scenarryo_back.beans.FilmShow;


public interface FilmShowDAO extends CrudRepository<FilmShow, Integer>{
	
//	@Modifying
//	@Query("update Customer u set u.phone = :phone where u.id = :id")
//	void updatePhone(@Param(value = "id") long id, @Param(value = "phone") String phone);
//	
	@Modifying
	@Query("update FilmShow f set f.bookedSeats = :newBookedSeats where f.id = :id")
	void updateBookedSeats(@Param(value = "id") int id, @Param(value = "newBookedSeats") int newBookedSeats);
}
