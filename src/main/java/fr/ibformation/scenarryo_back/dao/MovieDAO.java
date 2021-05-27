package fr.ibformation.scenarryo_back.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.ibformation.scenarryo_back.beans.Movie;

public interface MovieDAO extends CrudRepository<Movie, Integer> {

	List<Movie> findAllByTitle(String title);

}
