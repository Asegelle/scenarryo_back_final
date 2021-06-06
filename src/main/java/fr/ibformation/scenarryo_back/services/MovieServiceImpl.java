package fr.ibformation.scenarryo_back.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibformation.scenarryo_back.beans.Movie;
import fr.ibformation.scenarryo_back.beans.MovieComments;
import fr.ibformation.scenarryo_back.dao.MovieCommentsDAO;
import fr.ibformation.scenarryo_back.dao.MovieDAO;

@Service
public class MovieServiceImpl implements MovieService {

	// -------------------------------------------------------------------------------
	// ------------------ autowired ----------------------
	@Autowired
	MovieDAO movieDAO;
	
	@Autowired
	MovieCommentsDAO movieCommentsDAO;
	
	// -------------------------------------------------------------------------------
	// ------------------ Methods ----------------------
	
	@Override
	public List<Movie> getAllMovies() {
		return (List<Movie>) movieDAO.findAll();
	}

	@Override
	public Optional<Movie> getMovieById(int id) {
		return movieDAO.findById(id);	
	}

	@Override
	@Transactional
	public void addMovie(Movie movie) {
		movieDAO.save(movie);
	}
		
	@Override
	public void deleteMovie(Movie movie) {
		movieDAO.delete(movie);
	}

	
	
	// --------------------------------------------------------------------
	// methods associated to comments
	
	@Override
	public List<MovieComments> getAllComments() {
		return (List<MovieComments>) movieCommentsDAO.findAll();
	}
	
	/*
	@Override
	public List<MovieComments> getCommentsByMovieId(int movieId) {
		Movie movie;
		try {
			movie = movieDAO.findById(movieId).get();
		return movie.getFilmComment();
		} catch (Exception e) {
			return new ArrayList<MovieComments>();	
		}
	}*/
	
	
	@Override
	public List<MovieComments> getCommentsByMovieId(int movieId) {

		List<MovieComments> beforeFiltering = movieCommentsDAO.findfilmCommentById(movieId);
		
		for (MovieComments movieComment : beforeFiltering) {
			try {
				String test = badWordsFunction(movieComment.getComment());
				System.out.println(test);
				movieComment.setComment(test);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		List<MovieComments> AfterFiltering = movieCommentsDAO.findfilmCommentById(movieId);

		
		return AfterFiltering;

	}
	

	@Override
	public MovieComments getCommentsById(int id) {
		return movieCommentsDAO.findById(id).orElse(null);	
	}
	
	@Override
	public void postCommentsByMovie(int id, Movie movie) {
		Optional<Movie> postMovie = getMovieById(id);
		Movie forUpdate = postMovie.get();
		forUpdate.setFilmComment(movie.getFilmComment());
        movieDAO.save(forUpdate);
		
	}

	@Override
	public void addComment(MovieComments movieComment) {
		movieCommentsDAO.save(movieComment);
	}

	
	// --------------------------------------------------------------------
	// methods associated to bad words filtering
	
	public String badWordsFunction(String text) throws FileNotFoundException {
		// File import and conversion to an arrayList
		
		List<String> badWordsList = new ArrayList<String>();
		badWordsList.add("batard");
		badWordsList.add("connard");
		badWordsList.add("salope");
		badWordsList.add("pute");
		badWordsList.add("enculer");
		badWordsList.add("pleutre");

		
		/*
	    File txt = new File("file/bad_words.txt");
	    Scanner scan = new Scanner(txt);
	    int countWord = 0;
	    ArrayList<String> badWords = new ArrayList<String>() ;
	    while(scan.hasNextLine()){
	    	badWords.add(scan.nextLine());
			countWord++;
	    }
		System.out.println("nombre de mauvais mots : "+countWord);
	    System.out.println(badWords);
	    */
		// comparaison d'un text à la liste et remplacement des mauvais mots par ****
	    for (String word : badWordsList) {
	        String xxx = new String(new char[word.length()]).replace("\0", "*");        
	        text = text.toLowerCase().replace(word, xxx);
	    }
	    //scan.close();
	    
	    return text;
	}


}
