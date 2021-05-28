package fr.ibformation.scenarryo_back.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Indique que c'est une table
@Getter
@Setter
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@NoArgsConstructor // génération automatique d'un constructeur vide
@Table
public class FilmShow {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto incrémentation de l'ID
	private int id;
	private int priceTicket;
	private int bookedSeats;

    @ManyToOne
    @JoinColumn(name="room_id")
    @JsonIgnoreProperties("filmShow")
    private Room showRoom;
    @ManyToOne
    @JoinColumn(name="schedule_id")
    @JsonIgnoreProperties("filmShow")
    private Schedule showSchedule;
    @ManyToOne
    @JoinColumn(name="movie_id")
    @JsonIgnoreProperties("filmShow")
    private Movie showMovie;
    
    
	
	public FilmShow(int priceTicket, int bookedSeats) {
		this.priceTicket = priceTicket;
		this.bookedSeats = bookedSeats;
	}

	public FilmShow(int priceTicket, int bookedSeats, Room showRoom, Schedule showSchedule, Movie showMovie) {
		this.priceTicket = priceTicket;
		this.bookedSeats = bookedSeats;
		this.showRoom = showRoom;
		this.showSchedule = showSchedule;
		this.showMovie = showMovie;
	}
	
	public FilmShow(int id, int priceTicket, int bookedSeats, Room showRoom, Schedule showSchedule, Movie showMovie) {
		this.id = id;
		this.priceTicket = priceTicket;
		this.bookedSeats = bookedSeats;
		this.showRoom = showRoom;
		this.showSchedule = showSchedule;
		this.showMovie = showMovie;
	}
	
	
	
	@Override
	public String toString() {
		return "Show [id=" + id + ", priceTicket=" + priceTicket + ", bookedSeats=" + bookedSeats + ", showRoom="
				+ showRoom + ", showSchedule=" + showSchedule + ", showMovie=" + showMovie + "]";
	}
	
}
