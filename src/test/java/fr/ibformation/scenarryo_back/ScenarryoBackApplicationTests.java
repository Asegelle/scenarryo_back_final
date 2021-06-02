package fr.ibformation.scenarryo_back;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.beans.MovieComments;
import fr.ibformation.scenarryo_back.services.MovieService;
	

	
	
@SpringBootTest
class ScenarryoBackApplicationTests {

	@Autowired
	MovieService movieService;
	
	@Test
	void contextLoads() {
		// Test add a movie in BDD
		// Movie hp1 = new Movie ("Harry Potter à l'école des sorciers", "Chris Columbus", LocalDate.of(2001,12,05), AgeEnum.TOUS_PUBLIC, "Orphelin, Harry Potter ...","02:32:00", "https://img.over-blog-kiwi.com/1/88/59/62/20160508/ob_1a62f7_affiche.jpg");
		// Movie hp2 = new Movie ("Harry Potter et la chambre des secrets", "Chris Columbus", LocalDate.of(2002,12,04), AgeEnum.TOUS_PUBLIC, "Alors que l'oncle Vernon ...", "02:30:00", "https://static.fnac-static.com/multimedia/images_produits/ZoomPE/2/9/6/3322069866692/tsp20110629153819/Harry-Potter-et-la-chambre-des-secrets-Edition-Simple-DVD.jpg");
		// Movie hp3 = new Movie ("Harry Potter et le prisonnier d'Azkaban", "Alfonso Cuarón", LocalDate.of(2004,06,02), AgeEnum.TOUS_PUBLIC, "Sirius Black, un dangereux ...", "02:20:00", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT6Hqol6TnghN9xWTkXYuMu5GzHJQcSKwZ6ZWQuBD0FjKqMotM");

		
		// movieService.addMovie(hp1);
		// movieService.addMovie(hp2);
		//movieService.addMovie(hp3);
		
		
		
		// Test get all movies in a list
		System.out.println("début");
		// System.out.println(movieService.getAllMovies());
		System.out.println("fin");
		
	
		// test add comment
		Movie movieTest = new Movie ("JUNIT", "David Yates",  "", "Synopsis1", 
				"02:10:00", "https://www.legaliondesetoiles.com/photo/art/grande/3337709-4790710.jpg?v=1520758687");
		
		MovieComments test1 = new MovieComments("JUNIT test comment",movieTest);
		System.out.println("test1 : "+test1);
		movieService.addComment(test1);
		
		
		
		//movieService.postCommentsByMovie(0, movieTest);
		
	}

}
