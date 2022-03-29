package it.williamrolim.bankfinalproject.exceptions;

public enum Errors {
	MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
	RECORD_ALREDY_EXISTS("Record already exists"),
	INTERNATIONAL_SERVER_ERROR("Internal server error"),
	NO_RECORD_FOUND("Record with provided id is not found"),
	AUTHENTICATION_FAILED("Authentication failed"),
	COULD_NOT_UPDATE_RECORD("Could not update record"),
	COULD_NOT_DELETE_RECORD("Could not delete record"),
	EMAIL_ADDRESS_NOT_VERIFIED("Email address could not be verified");
	
	private String error;
	
	 Errors(String error) {
		this.error = error;
	}

	 public String getErrorMessage() {
		 return error;
	 }
	 

	 public void setErrorMessage(String error) {
		 this.error = error;
	 }
}
