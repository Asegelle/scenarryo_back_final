package fr.ibformation.scenarryo_back;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.enums.AgeEnum;
import fr.ibformation.scenarryo_back.services.MovieService;
	

	
	
@SpringBootTest
class ScenarryoBackApplicationTests {

	@Autowired
	MovieService movieService;
	
	@Test
	void contextLoads() {
		// Test add a movie in BDD
		Movie hp1 = new Movie("Harry Potter 1", LocalDate.of(2019,05,28), AgeEnum.M_16 , "Un jeune puceau voit un gros porc avec une barbe débarqué pendant ses vacances dans un phare avec sa super famille pour lui dire qu'il a aucun avenir . Fin de l'histoire", 120, "C:\\Users\\ib\\Desktop\\Dossier de la honte\\Montages\\Pounaud.JPG"  );
		Movie hp2 = new Movie("Harry Potter 2", LocalDate.of(2019,05,28), AgeEnum.M_16 , "Normalement y'a plsu d'histoire", 120, "C:\\Users\\ib\\Desktop\\Dossier de la honte\\Montages\\Pounaud.JPG"  );
		Movie hp3 = new Movie("Harry Potter 3", LocalDate.of(2019,05,28), AgeEnum.M_16 , "es dans un phare avec sa super famille pour lui dire qu'il a aucun avenir . Fin de l'histoire", 120, "C:\\Users\\ib\\Desktop\\Dossier de la honte\\Montages\\Pounaud.JPG"  );
		
		movieService.addMovie(hp1);
		movieService.addMovie(hp2);
		movieService.addMovie(hp3);
		
		
		
		// Test get all movies in a list
		System.out.println("début");
		System.out.println(movieService.getAllMovies());
		System.out.println("fin");
		
		
		
		
		
		
	}

}
