package it.williamrolim.bankfinalproject.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionErrors extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request){
		String errorDescription = e.getLocalizedMessage();
		
		if (errorDescription == null) errorDescription = e.toString();
		
		ErrorMessages errorMessages = new ErrorMessages(new Date(),errorDescription);
		
		return new ResponseEntity<>(errorMessages, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
