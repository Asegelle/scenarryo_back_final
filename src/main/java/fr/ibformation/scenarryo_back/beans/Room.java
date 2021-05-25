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
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto incrémentation de l'ID
	private int id;
    @Column(unique=true)
	private int roomNumber;
	private int seatsQuantity;	
	
	@OneToMany (mappedBy="showRoom")
	private List<FilmShow> filmShow =  new ArrayList<FilmShow>();
	
	
	
	public Room(int roomNumber, int seatsQuantity) {
		this.roomNumber = roomNumber;
		this.seatsQuantity = seatsQuantity;
	}

	public Room(int id, int roomNumber, int seatsQuantity) {
		this.id = id;
		this.roomNumber = roomNumber;
		this.seatsQuantity = seatsQuantity;
	}
	
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", seatsQuantity=" + seatsQuantity + "]";
	}
	
}
