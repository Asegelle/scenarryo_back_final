package fr.ibformation.scenarryo_back.beans;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Indique que c'est une table
@Getter
@Setter
@NoArgsConstructor // génération automatique d'un constructeur vide
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class, 
//        property = "id")
@Table
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto incrémentation de l'ID
	private int id;
	private String title;
	private String producer;
	// @DateTimeFormat(iso = ISO.DATE)
	private String releaseDate;
	private String ageLimited = "Tous public"; // "Tous public" par défaut si rien définie
	@Column(columnDefinition = "TEXT") // Pour typer en base de donnée en "TEXT"
	private String synopsis;
	private String duration;
	private String poster; // Strings car image en URL

	@OneToMany (mappedBy="showMovie")
	@JsonIgnoreProperties("showMovie")
	private List<FilmShow> filmShow =  new ArrayList<FilmShow>();
	
	@OneToMany  (mappedBy="commentMovie")
	@JsonIgnoreProperties("commentMovie")
	private List<MovieComments> filmComment = new ArrayList<>();
	
	
	
	/*public Movie(String title, String releaseDate, String ageLimited, String synopsis, String duration, String poster, String producer) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.ageLimited = ageLimited;
		this.synopsis = synopsis;
		this.duration = duration;
		this.poster = poster;
		this.producer=producer;
	}*/

	public Movie(int id,String title, String releaseDate, String ageLimited, String synopsis, String duration, String poster, String producer) {
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.ageLimited = ageLimited;
		this.synopsis = synopsis;
		this.duration = duration;
		this.poster = poster;
		this.producer=producer;
	}
	
	public Movie(String title, String producer, String ageLimited,  String synopsis,
			String duration, String poster) {
		this.title = title;
		this.producer = producer;
		this.ageLimited = ageLimited;
		this.synopsis = synopsis;
		this.duration = duration;
		this.poster = poster;
	}
	
	public Movie(String title, String producer, String ageLimited,  String synopsis,
			String releaseDate, String duration, String poster) {
		this.title = title;
		this.producer = producer;
		this.ageLimited = ageLimited;
		this.synopsis = synopsis;
		this.releaseDate=releaseDate;
		this.duration = duration;
		this.poster = poster;
	}
	
	public Movie(String title, String producer, String ageLimited, String synopsis, String duration,
			String poster, List<MovieComments> filmComment) {
		this.title = title;
		this.producer = producer;
		this.ageLimited = ageLimited;
		this.synopsis = synopsis;
		this.duration = duration;
		this.poster = poster;
		this.filmComment = filmComment;
	}
	
	public Movie(int id, String title, String producer, String ageLimited, String synopsis, String duration,
			String poster, List<MovieComments> filmComment) {
		this.id = id;
		this.title = title;
		this.producer = producer;
		this.ageLimited = ageLimited;
		this.synopsis = synopsis;
		this.duration = duration;
		this.poster = poster;
		this.filmComment = filmComment;
	}
	
	public Movie(int id, String title, String producer, String ageLimited, String synopsis, String duration,
			String poster) {
		this.id = id;
		this.title = title;
		this.producer = producer;
		this.ageLimited = ageLimited;
		this.synopsis = synopsis;
		this.duration = duration;
		this.poster = poster;
	}
	
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", ageLimited=" + ageLimited
				+ ", synopsis=" + synopsis + ", duration=" + duration + ", poster=" + poster + ", producer=" + producer + ", filmShow=" + filmShow
				+ "]";
	}



	public void addComment(MovieComments movieComments) {
		filmComment.add(movieComments);
		movieComments.setCommentMovie(this);
	}
	

	
}
