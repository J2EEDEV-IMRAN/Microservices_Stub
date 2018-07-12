package com.example.errormanagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerErrorHendler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> hendleError(Exception e)
	{
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setStatusMethod(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
