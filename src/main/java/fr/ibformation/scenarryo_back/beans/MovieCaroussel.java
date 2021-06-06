package fr.ibformation.scenarryo_back.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor // génération automatique d'un constructeur vide
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class, 
//        property = "id")
@Table
public class MovieCaroussel {
	
	// --------------------------------------------------------------------------------
		// Variables
	@Id
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

	
	
	



	public MovieCaroussel(int id,String title, String releaseDate, String ageLimited, String synopsis, String duration, String poster, String producer) {
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.ageLimited = ageLimited;
		this.synopsis = synopsis;
		this.duration = duration;
		this.poster = poster;
		this.producer=producer;
	}
	
	public MovieCaroussel(String title, String producer, String ageLimited,  String synopsis,
			String duration, String poster) {
		this.title = title;
		this.producer = producer;
		this.ageLimited = ageLimited;
		this.synopsis = synopsis;
		this.duration = duration;
		this.poster = poster;
	}
	
	public MovieCaroussel(String title, String producer, String ageLimited,  String synopsis,
			String releaseDate, String duration, String poster) {
		this.title = title;
		this.producer = producer;
		this.ageLimited = ageLimited;
		this.synopsis = synopsis;
		this.releaseDate=releaseDate;
		this.duration = duration;
		this.poster = poster;
	}
	
	
	
	public MovieCaroussel(int id, String title, String producer, String ageLimited, String synopsis, String duration,
			String poster) {
		this.id = id;
		this.title = title;
		this.producer = producer;
		this.ageLimited = ageLimited;
		this.synopsis = synopsis;
		this.duration = duration;
		this.poster = poster;
	}
	
	
	// --------------------------------------------------------------------------------
		// ToString
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", ageLimited=" + ageLimited
				+ ", synopsis=" + synopsis + ", duration=" + duration + ", poster=" + poster + ", producer=" + producer +
				"]";
	}





	
}
