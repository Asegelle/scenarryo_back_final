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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	//@Column (name="role")
	private RoleEnum roleName;

	
	
	//Constructors (empty auto generated)
	public CinemaRole(Integer id, RoleEnum roleName) {
		this.id = id;
		this.roleName = roleName;
	}
	
	public CinemaRole(RoleEnum roleName) {
		this.roleName = roleName;
	}

	
	
	//ToString
	@Override
	public String toString() {
		return "CinemaRole [id=" + id + ", roleName=" + roleName + "]";
	}
	
	
	
	
	
	
	
	
}
