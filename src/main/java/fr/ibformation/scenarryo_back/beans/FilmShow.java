package fr.ibformation.scenarryo_back.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indique que c'est une table
@Data // Lombok
@NoArgsConstructor // génération automatique d'un constructeur vide
public class FilmShow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto incrémentation de l'ID
	private int id;
	private int priceTicket;
	private int bookedSeats;

	@ManyToOne
	private Room room;
	
	@ManyToOne
	private Movie movie;
	
	public FilmShow(int priceTicket, int bookedSeats) {
		this.priceTicket = priceTicket;
		this.bookedSeats = bookedSeats;
	}

}
