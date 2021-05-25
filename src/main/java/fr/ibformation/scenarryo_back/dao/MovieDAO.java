package fr.ibformation.scenarryo_back.dao;

import org.springframework.data.repository.CrudRepository;

import fr.ibformation.scenarryo_back.beans.Movie;

public interface MovieDAO extends CrudRepository<Movie, Integer> {

}
