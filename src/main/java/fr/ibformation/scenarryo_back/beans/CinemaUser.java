package fr.ibformation.scenarryo_back.beans;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
//@JsonIdentityInfo(
//generator = ObjectIdGenerators.PropertyGenerator.class, 
//property = "id")
@NoArgsConstructor
@Table (name = "cinema_users", 
//Specifies that a unique constraint is to be included in the generated BDD for a primary or secondary table
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "userName"),
		@UniqueConstraint(columnNames = "email") 
	})
public class CinemaUser {

	//Variables
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	//The annotated element must not be null and must contain at least onenon-whitespace character
	@NotBlank
	@Size(max = 20)
	private String username;
	@NotBlank
	@Email
	@Size(max = 50)
	private String email;
	@NotBlank
	@Size(max = 120)
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<CinemaRole> roles = new HashSet<>();

	
	// Constructors (empty constructor auto generated)
	public CinemaUser(long id, @NotBlank String username, @NotBlank String email, @NotBlank @Email String password,
			Set<CinemaRole> roles) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	
	public CinemaUser(@NotBlank String username, @NotBlank  @Email String email, @NotBlank String password,
			Set<CinemaRole> roles) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public CinemaUser(@NotBlank String username, @NotBlank  @Email String email, @NotBlank String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
	//ToString
	@Override
	public String toString() {
		return "CinemaUser [id=" + id + ", userName=" + username + ", email=" + email + ", password=" + password
				+ ", roles=" + roles + "]";
	}
	
	
	
	
	
}
