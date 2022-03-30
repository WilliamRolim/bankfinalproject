package it.williamrolim.bankfinalproject.exceptions;

import java.util.Date;

public class ErrorMessages {
	private Date currentDate;
	private String message;

	public ErrorMessages() {
		// TODO Auto-generated constructor stub
	}

	public ErrorMessages(Date currentDate, String message) {
		this.currentDate = currentDate;
		this.message = message;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
