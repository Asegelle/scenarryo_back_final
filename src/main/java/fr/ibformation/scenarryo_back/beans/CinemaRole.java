package fr.ibformation.scenarryo_back.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.ibformation.scenarryo_back.enums.RoleEnum;
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
@Table(name = "cinema_roles")
public class CinemaRole {

	
	//Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private RoleEnum name;

	
	
	//Constructors (empty auto generated)
	public CinemaRole(Integer id, RoleEnum name) {
		this.id = id;
		this.name = name;
	}
	
	public CinemaRole(RoleEnum name) {
		this.name = name;
	}

	
	
	//ToString
	@Override
	public String toString() {
		return "CinemaRole [id=" + id + ", roleName=" + name + "]";
	}
		
}
