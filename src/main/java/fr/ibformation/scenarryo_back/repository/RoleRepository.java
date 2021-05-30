package fr.ibformation.scenarryo_back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.ibformation.scenarryo_back.beans.CinemaRole;
import fr.ibformation.scenarryo_back.enums.RoleEnum;

@Repository
public interface RoleRepository extends JpaRepository<CinemaRole, Long> {
	Optional<CinemaRole> findByName(RoleEnum name);
}
