package com.app.education.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class EducationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> userNotFoundException(NotFoundException ex) {
		ErrorDetails errorModel = new ErrorDetails(404, ex.getMessage());
		return new ResponseEntity<ErrorDetails>(errorModel, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EducationException.class)
	public ResponseEntity<ErrorDetails> educationException(EducationException ex) {
		ErrorDetails errorModel = new ErrorDetails(500, ex.getMessage());
		return new ResponseEntity<ErrorDetails>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex) {
		ErrorDetails errorModel = new ErrorDetails(500, ex.getMessage());
		return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}