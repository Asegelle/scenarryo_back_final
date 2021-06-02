package fr.ibformation.scenarryo_back.payload.request;


import javax.validation.constraints.NotBlank;

// class associated to the form of login
public class LoginRequest {
	
	// --------------------------------------------------------------------------------
	// Variables
	@NotBlank
	private String username;

	@NotBlank
	private String password;

	
	// --------------------------------------------------------------------------------
	// Getter / Setter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

