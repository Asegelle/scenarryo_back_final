package fr.ibformation.scenarryo_back;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.ibformation.scenarryo_back.beans.FilmShow;
import fr.ibformation.scenarryo_back.services.FilmShowService;

@SpringBootTest
public class FilmShowTests {
	@Autowired
	FilmShowService showService;
	
//	@Test
//	@Transactional
//	void contextLoads() {
//		FilmShow show = showService.getById(33);
//		System.out.println("testttttttttttttttttttttttttttttttttttttttttttttttttttt");
//		System.out.println(show);
//		// showService.getBookedSeatsByShow(32).forEach(System.out::println);
//	}

}
