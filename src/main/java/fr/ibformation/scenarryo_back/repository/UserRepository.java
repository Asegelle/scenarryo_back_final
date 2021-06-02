package fr.ibformation.scenarryo_back.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ibformation.scenarryo_back.beans.CinemaUser;

@Repository
public interface UserRepository extends JpaRepository<CinemaUser, Long> {
	
	/**
	 * function findByUsername :
	 * @param username
	 * @return Optional CinemaUser
	 */
	Optional<CinemaUser> findByUsername(String username);

	/**
	 * function existsByUsername :
	 * @param username
	 * @return Boolean
	 */
	Boolean existsByUsername(String username);

	
	/**
	 * function existsByEmail :
	 * @param email
	 * @return Boolean
	 */
	Boolean existsByEmail(String email);
}
