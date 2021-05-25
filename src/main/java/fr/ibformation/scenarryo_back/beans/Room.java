package fr.ibformation.scenarryo_back.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indique que c'est une table
@Data // Lombok
@NoArgsConstructor // génération automatique d'un constructeur vide
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto incrémentation de l'ID
	private int id;
	private int roomNumber;
	private int seatsQuantity;	
	
	@OneToMany //(mappedBy = "room")
	private List<FilmShow> filmShow =  new ArrayList<FilmShow>();
	
	
	
	public Room(int roomNumber, int seatsQuantity) {
		this.roomNumber = roomNumber;
		this.seatsQuantity = seatsQuantity;
	}

}
