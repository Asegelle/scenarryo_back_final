package fr.ibformation.scenarryo_back.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id")
@NoArgsConstructor
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate showDate;
	private String startingHour;
	private String endingHour;

	@OneToMany (mappedBy="showSchedule")
	@JsonIgnoreProperties("showSchedule")
	private List<FilmShow> filmShow = new ArrayList<>();
	
	


	public Schedule(LocalDate showDate, String startingHour, String endingHour) {
		this.showDate = showDate;
		this.startingHour = startingHour;
		this.endingHour = endingHour;
	}
	
	public Schedule(int id, LocalDate showDate, String startingHour, String endingHour) {
		this.id = id;
		this.showDate = showDate;
		this.startingHour = startingHour;
		this.endingHour = endingHour;
	}

	
	
	
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", showDate=" + showDate + ", startingHour=" + startingHour + ", endingHour="
				+ endingHour + "]";
	}
	
}
