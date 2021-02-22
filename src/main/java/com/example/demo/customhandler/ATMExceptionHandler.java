package com.example.demo.customhandler;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import com.example.demo.exception.NOATMFoundException;

/**
 * @author kkoti
 *
 */
@RestControllerAdvice
public class ATMExceptionHandler {
	
	/*
	 * A method that checks whether the Given URI is available or not
	 * @param takes Exception thrown in the method.
	 * @return ResponseEntity object with proper message 
	 */
	@ExceptionHandler(value = ResourceAccessException.class)
	public ResponseEntity<?> processResourceException(Exception e) {
		ErrorMessage errorMessage = new ErrorMessage("RESOURCE IS DOWN",e.getLocalizedMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	/*
	 * A Custom Exception handler that checks whether ATMS are available or not
	 * @param takes Exception thrown in the method.
	 * @return ResponseEntity object with NO ATMS FOUND message.
	 */
	@ExceptionHandler(value = NOATMFoundException.class)
	public ResponseEntity<?> processNOATMFoundException(Exception e) {
		ErrorMessage errorMessage = new ErrorMessage("NO ATMS FOUND",e.getLocalizedMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
	
	/*
	 * An Exception handler that checks for validations and violations.
	 * @param takes Exception thrown in the method.
	 * @return ResponseEntity object withCONSTRAINT FAILED message.
	 */
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> processConstraintViolationException(Exception e){
		ErrorMessage errorMessage = new ErrorMessage("CONSTRAINT FAILED", e.getMessage());
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
	}
	
	/*
	 * A Generic Exception handler that checks for un handled Exceptions
	 * @param takes Exception thrown in the method.
	 * @return ResponseEntity object withCONSTRAINT FAILED message.
	 */
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> processGenericException(Exception e){
		ErrorMessage errorMessage = new ErrorMessage("EXCEPTION RAISED", e.getMessage());
		return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
	}
}
