package fr.ibformation.scenarryo_back.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ibformation.scenarryo_back.beans.CinemaUser;

@Repository
public interface UserRepository extends JpaRepository<CinemaUser, Long> {
	Optional<CinemaUser> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
