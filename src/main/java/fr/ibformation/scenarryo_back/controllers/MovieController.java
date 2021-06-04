package fr.ibformation.scenarryo_back.controllers;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.beans.MovieComments;
import fr.ibformation.scenarryo_back.beans.Schedule;
import fr.ibformation.scenarryo_back.services.MovieService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class MovieController {

	@Autowired
	private MovieService movieService;

	
	/*
	@PostConstruct
	@Transactional
	public void init() {

		Movie m1 = new Movie ("Harry Potter à l'école des sorciers", "Chris Columbus",  "", "Orphelin, Harry Potter a été recueilli à contrecœur par son oncle Vernon et sa tante Pétunia, aussi cruels que mesquins, qui n'hésitent pas à le faire dormir dans le placard sous l'escalier. Constamment maltraité, il doit en outre supporter les jérémiades de son cousin Dudley, garçon cupide et archi-gâté par ses parents. De leur côté, Vernon et Pétunia détestent leur neveu dont la présence leur rappelle sans cesse le tempérament \"imprévisible\" des parents du garçon et leur mort mystérieuse.\r\n"
				+ "À l'approche de ses 11 ans, Harry ne s'attend à rien de particulier – ni carte, ni cadeau, ni même un goûter d'anniversaire. Et pourtant, c'est à cette occasion qu'il découvre qu'il est le fils de deux puissants magiciens et qu'il possède lui aussi d'extraordinaires pouvoirs. Quand on lui propose d'intégrer Poudlard, la prestigieuse école de sorcellerie, il trouve enfin le foyer et la famille qui lui ont toujours manqué… et s'engage dans l'aventure de sa vie.", 
				"02:32:00", "https://img.over-blog-kiwi.com/1/88/59/62/20160508/ob_1a62f7_affiche.jpg");
		Movie m2 = new Movie ("Harry Potter et la chambre des secrets", "Chris Columbus",  "", "Alors que l'oncle Vernon, la tante Pétunia et son cousin Dudley reçoivent d'importants invités à dîner, Harry Potter est contraint de passer la soirée dans sa chambre. Dobby, un elfe, fait alors son apparition. Il lui annonce que de terribles dangers menacent l'école de Poudlard et qu'il ne doit pas y retourner en septembre. Harry refuse de le croire.\r\n"
				+ "Mais sitôt la rentrée des classes effectuée, ce dernier entend une voix malveillante. Celle-ci lui dit que la redoutable et légendaire Chambre des secrets est à nouveau ouverte, permettant ainsi à l'héritier de Serpentard de semer le chaos à Poudlard. Les victimes, retrouvées pétrifiées par une force mystérieuse, se succèdent dans les couloirs de l'école, sans que les professeurs - pas même le populaire Gilderoy Lockhart - ne parviennent à endiguer la menace. Aidé de Ron et Hermione, Harry doit agir au plus vite pour sauver Poudlard.", 
				"02:30:00", "https://static.fnac-static.com/multimedia/images_produits/ZoomPE/2/9/6/3322069866692/tsp20110629153819/Harry-Potter-et-la-chambre-des-secrets-Edition-Simple-DVD.jpg");
		
		MovieComments c1 = new MovieComments("J'adore ce film tellement bien !!");
		MovieComments c2 = new MovieComments("pas super, les acteurs manquent de charisme, les effets spéciaux sont moyens, on sent le manque de budget, ... ca passe pour un nanar mais pas plus");
		MovieComments c3 = new MovieComments("spoiler : Voldemort meurt a la fin : Spoiler");
		m1.addComment(c1);
		m1.addComment(c2);
		m2.addComment(c3);

		movieService.addMovie(m1);
		movieService.addMovie(m2);
		movieService.addComment(c1);
		movieService.addComment(c2);
		movieService.addComment(c3);

		movieService.getAllMovies();
		
	}*/
	
	
	// fonction afficher les fims

	@GetMapping("/movie")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	
	@GetMapping("/rest/{id}")
	public Optional<Movie> getMovieById(@PathVariable("id") int id) {
		return movieService.getMovieById(id);
	}
	
	
	@PostMapping("/rest")
	public List<Movie> getAllMoviesAngular() {
		return movieService.getAllMovies();
	}
	// fonction ajouter un film

	@PostMapping("/addmovie")
	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
	public List<Movie> addMovie(@RequestBody Movie movie) {		
		movieService.addMovie(movie);
		return getAllMovies();

	}
	
	// fonction supprimer un film
	
	@PostMapping("/deletemovie")
	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
	public  void deleteMovie(@RequestBody Movie movie) {
		movieService.deleteMovie(movie);
		
	}
	
//	//add movie by admin
//	@PostMapping("/addmovie")
//	@Transactional // A ajouter lorsqu'on modifie qqc en BDD
//	public void addMovieAdmin(@RequestBody Movie movie) {
//		movieService.addMovie(movie);
//
//	}
// TODO
//	@GetMapping("/movie")
//	public Movie getMovieByTitle() {
//		return (Movie) movieService.getAllMovies();
//	}

	
	
	// ------------------------ comments of movies -----------------------------
	
	/**
	 * function getAllComments :
	 * @return movieService.getAllComments();
	 */
	@GetMapping("/rest/comments")
	public List<MovieComments> getAllComments() {
		return movieService.getAllComments();
	}
	
	/**
	 * function getCommentsByMovieId :
	 * @param movieId (id of the movie you want to get comments)
	 * @return movieService.getCommentsByMovieId(movieId);
	 */
	@GetMapping("/rest/comments/movie/{id}")
	public List<MovieComments> getCommentsByMovieId(@PathVariable("id") int movieId) {
		return movieService.getCommentsByMovieId(movieId);
	}
	
	/**
	 * function getCommentsById :
	 * @param id (id of the comment)
	 * @return movieService.getCommentsById(id);
	 */
	@GetMapping("/rest/comments/{id}")
	public MovieComments getCommentsById(@PathVariable("id") int id) {
		return movieService.getCommentsById(id);
	}
	
	/**
	 * function postCommentsByMovie :
	 * @param id (id of the movie you want to add a comment)
	 * @param movie (movie you update with a new comment)
	 */
	@PutMapping("/rest/comments/{movie_id}")
	public void postCommentsByMovie(
			@PathVariable("movie_id") int id,
			@RequestBody Movie movie
			) {
		movieService.postCommentsByMovie(id, movie);
	}
	
	//post comment not associated to a movie
	/**
	 * function postComments :
	 * @param movieComment (comment you want to save in bdd)
	 * @return movieComment
	 */
	@PostMapping("/rest/comments")
	public MovieComments postComments(@RequestBody MovieComments movieComment) {
		movieService.addComment(movieComment);
		System.out.println(movieComment);
		return movieComment;
	}
	
	// ------------------------ bad words filtering -----------------------------

	// methode pour filter les mauvais mots à partir d'une liste		
	String text = "tu es un connard.";
	/**
	 * function badWordsFunction :
	 * @param text (text you want to identify badwords and replace them)
	 * @throws FileNotFoundException (if you on't find the file of badwords)
	 */
	// renvoie le texte avec remplacement des bad_words
	public void badWordsFunction(String text) throws FileNotFoundException {
		String returnedText;
		try {
			returnedText = movieService.badWordsFunction(text);
		    System.out.println(returnedText);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

	
}
