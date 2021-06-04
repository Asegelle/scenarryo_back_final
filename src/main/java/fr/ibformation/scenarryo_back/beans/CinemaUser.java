package fr.ibformation.scenarryo_back.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(	name = "cinema_users", 
		uniqueConstraints = { 
				//Specifies that a unique constraint is to be included in bdd for a primary or secondary table. 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
@NoArgsConstructor
public class CinemaUser {
	
	// --------------------------------------------------------------------------------
	// Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<CinemaRole> roles = new HashSet<>();

	
	// --------------------------------------------------------------------------------
	// Constructors
	public CinemaUser(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public CinemaUser(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, Set<CinemaRole> roles) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	
	/*public void addRole(CinemaRole cinemaRole) {
		roles.add(cinemaRole);
		cinemaRole.setName(this);
	}*/
	
	
	
	// --------------------------------------------------------------------------------
	// ToString
	@Override
	public String toString() {
		return "CinemaUser [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", roles=" + roles + "]";
	}
	
	
}
