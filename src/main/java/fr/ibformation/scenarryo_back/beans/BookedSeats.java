package fr.ibformation.scenarryo_back.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Indique que c'est une table
@Getter
@Setter
@NoArgsConstructor // génération automatique d'un constructeur vide
@Table
public class BookedSeats {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto incrémentation de l'ID
	private int id;
	private int placeBookedRow;
	private int placeBookedColumn;
	
	@ManyToOne
	@JoinColumn(name="showfilm_id")
	private FilmShow filmShow;

	public BookedSeats(int placeBooked_row, int placeBooked_column, FilmShow filmShow) {
		this.placeBookedRow = placeBooked_row;
		this.placeBookedColumn = placeBooked_column;
		this.filmShow = filmShow;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookedSeats [id=");
		builder.append(id);
		builder.append(", placeBookedRow=");
		builder.append(placeBookedRow);
		builder.append(", placeBookedColumn=");
		builder.append(placeBookedColumn);
		builder.append(", filmShow=");
		builder.append(filmShow);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
	
}
