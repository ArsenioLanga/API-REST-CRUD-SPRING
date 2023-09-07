package com.place.apirest.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.place.apirest.dto.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHlandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity throwDuplicateEntity(DataIntegrityViolationException dataIntegrityViolationException) {
		ExceptionDTO exceptionDTO = new ExceptionDTO("Usuario ja cadastrado", "400");
		return ResponseEntity.badRequest().body(exceptionDTO);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity throwNotFindEntity(EntityNotFoundException entityNotFoundException) {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity throwGeneralException(Exception exception) {
		ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "404");
		return ResponseEntity.internalServerError().body(exceptionDTO);
	}
}
