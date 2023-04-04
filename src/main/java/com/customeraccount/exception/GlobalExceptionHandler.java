package com.customeraccount.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFountException(ResourceNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(ResourceAlreadyExistException.class)
	public ResponseEntity<String> resourceAlreadyExistException(ResourceAlreadyExistException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
		
	}

}
