package it.williamrolim.bankfinalproject.exceptions;

public class AccountException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AccountException(String message) {
		super(message);
	}

}
