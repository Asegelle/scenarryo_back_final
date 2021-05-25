package fr.ibformation.scenarryo_back.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indique que c'est une table
@Data // Lombok
@NoArgsConstructor // génération automatique d'un constructeur vide
public class PriceTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto incrémentation de l'ID
	private int id;
	private String rateName;
	private int price;
}
