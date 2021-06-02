package fr.ibformation.scenarryo_back.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class MovieComments {

	// --------------------------------------------------------------------------------
	// Variables
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto incrémentation de l'ID
	private int id;
	private String comment;
	
	@ManyToOne
    @JoinColumn(name="movie_id")
	@JsonIgnoreProperties("filmComment")
	private Movie commentMovie;
	
	// --------------------------------------------------------------------------------
	// Constructors
	public MovieComments(String comment) {
		this.comment = comment;
	}
	
	public MovieComments(int id, String comment) {
		this.id = id;
		this.comment = comment;
	}
	
	public MovieComments(String comment, Movie commentMovie) {
		this.comment = comment;
		this.commentMovie = commentMovie;
	}
	
	// --------------------------------------------------------------------------------
	// ToString
	@Override
	public String toString() {
		return "MovieComments [id=" + id + ", comment=" + comment + ", commentMovie=" + commentMovie + "]";
	}


	
	
	
	
	
}
