package com.rest.webservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.webservices.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomisedResponceEntityExceptionHandler 
extends ResponseEntityExceptionHandler {
 
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException
	(UserNotFoundException ex, WebRequest request) {
	
		ExceptionResponse exceptionResponse=
				new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
	return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ExceptionResponse exceptionResponse=
				new ExceptionResponse(new Date(),"validation message",ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);

	}

}
