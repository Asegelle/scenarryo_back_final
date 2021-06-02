package fr.ibformation.scenarryo_back.payload.response;


//class associated to message displayed to the user
public class MessageResponse {
	
	// --------------------------------------------------------------------------------
	// Variables
	private String message;

	
	// --------------------------------------------------------------------------------
	// Constructor
	public MessageResponse(String message) {
	    this.message = message;
	  }

	
	// --------------------------------------------------------------------------------
	// Getter / Setter
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}