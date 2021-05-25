package fr.ibformation.scenarryo_back.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
@Table
public class PriceTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto incrémentation de l'ID
	private int id;
	private String rateName;
	private int price;
}
