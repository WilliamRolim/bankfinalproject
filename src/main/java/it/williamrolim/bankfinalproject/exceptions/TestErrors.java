package it.williamrolim.bankfinalproject.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class TestErrors {
//	@ExceptionHandler(UsuarioException.class)
//    public ResponseEntity<ErroPadrao2> userError(UsuarioException ex, HttpServletRequest request) {
//		HttpStatus status = HttpStatus.BAD_REQUEST;
//		ErroPadrao2 err = new ErroPadrao2();
//		err.setStatus(status.value());
//		err.setError("Usuario Exception");
//		err.setMessage(ex.getMessage());
//		err.setPath(request.getRequestURI());
//		
//		return ResponseEntity.status(status).body(err);
//    }
//	
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public ResponseEntity<ErroPadrao> statusError(HttpMessageNotReadableException e, HttpServletRequest request){
//		HttpStatus status = HttpStatus.CONFLICT;
//		ErroPadrao err = new ErroPadrao();
//		err.setTimeStamp(Instant.now());
//		err.setStatus(status.value());
//		err.setError("Erro Status Invalido");
//		err.setMessage("Valores aceitos: [ATIVO, INATIVO]");
//		err.setPath(request.getRequestURI());
//		
//		return ResponseEntity.status(status).body(err);
//	}
//	
//	@ExceptionHandler(AccountException.class)
//	public ResponseEntity<ErroPadrao> accountError(AccountException e, HttpServletRequest request){
//		HttpStatus status = HttpStatus.NOT_FOUND;
//		ErroPadrao err = new ErroPadrao();
//		err.setTimeStamp(Instant.now());
//		err.setStatus(status.value());
//		err.setError("Account Exception");
//		err.setMessage(e.getMessage());
//		err.setPath(request.getRequestURI());
//		
//		return ResponseEntity.status(status).body(err);
//	}
//	
//	@ExceptionHandler(EnderecoException.class)
//	public ResponseEntity<ErroPadrao> enderecoError(EnderecoException e, HttpServletRequest request){
//		HttpStatus status = HttpStatus.NOT_FOUND;
//		ErroPadrao err = new ErroPadrao();
//		err.setTimeStamp(Instant.now());
//		err.setStatus(status.value());
//		err.setError("Endereco Exception");
//		err.setMessage(e.getMessage());
//		err.setPath(request.getRequestURI());
//		
//		return ResponseEntity.status(status).body(err);
//	}
//	
//	@ExceptionHandler(NegocioException.class)
//	public ResponseEntity<ErroPadrao> negocioError(NegocioException e, HttpServletRequest request){
//		HttpStatus status = HttpStatus.BAD_REQUEST;
//		ErroPadrao err = new ErroPadrao();
//		err.setTimeStamp(Instant.now());
//		err.setStatus(status.value());
//		err.setError("Negocio Exception");
//		err.setMessage(e.getMessage());
//		err.setPath(request.getRequestURI());
//		
//		return ResponseEntity.status(status).body(err);
//	}	
//	
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<ErrorConstraint> contraintError(ConstraintViolationException e, HttpServletRequest request){
//		HttpStatus status = HttpStatus.BAD_REQUEST;
//		List<DetailError> listError = new ArrayList<>();
//		ErrorConstraint err = new ErrorConstraint();
//		err.setTimeStamp(Instant.now());
//		err.setStatus(status.value());
//		err.setError("Constraint Exception");
//		err.setPath(request.getRequestURI());
//		
//		Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
//		
//		constraintViolations.forEach( x -> {
//			String field = x.getPropertyPath().toString();
//			String message = x.getMessage().toString();
//			DetailError detail = new DetailError(field, message);
//			listError.add(detail);
//		});
//		
//		err.setDetails(listError);
//		
		
//		err.setDetails(constraintViolations
//				.stream()
//				.map(c -> String.format("%s = %s", c.getPropertyPath(), c.getMessage()))
//				.collect(Collectors.toList()));
//		
//		return ResponseEntity.status(status).body(err);
////	}
	
}
