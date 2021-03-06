package com.matheusf.birthday.resources.exceptions;

import java.time.OffsetDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matheusf.birthday.services.exceptions.DomainException;
import com.matheusf.birthday.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validationError(MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ValidationError ve = new ValidationError(status.value(), OffsetDateTime.now(), "Erro de validação" , request.getRequestURI());		
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			ve.addErros(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(status).body(ve);	
	}
	
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<StandardError> mainException(DomainException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError see = new StandardError(status.value(), OffsetDateTime.now(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(see);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError see = new StandardError(status.value(), OffsetDateTime.now(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(see);
	}
}
