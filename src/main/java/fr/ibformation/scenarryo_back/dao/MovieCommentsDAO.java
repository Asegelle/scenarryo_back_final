package fr.ibformation.scenarryo_back.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.ibformation.scenarryo_back.beans.MovieComments;

public interface MovieCommentsDAO extends CrudRepository<MovieComments, Integer> {

	// specific query to get in bdd les commentaires d'un film specific
	/**
	 * function findfilmCommentById :
	 * @param id (id of the movie you are looking all comments)
	 * @return ListMovieComments
	 */
	@Query ("SELECT a.filmComment FROM Movie a WHERE a.id=:id")
	List<MovieComments> findfilmCommentById(@Param("id") int id);


}
