package fr.ibformation.scenarryo_back.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.beans.MovieComments;

public interface MovieDAO extends CrudRepository<Movie, Integer> {

	

	// List<Movie> findAllByTitle(String title);

}
