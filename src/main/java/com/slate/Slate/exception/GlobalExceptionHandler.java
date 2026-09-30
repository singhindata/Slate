package com.slate.Slate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handleNotFound(TaskNotFoundException ex) {

        String error = HttpStatus.NOT_FOUND.value()
                + " - "
                + ex.getMessage();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String>handleNotValid(MethodArgumentNotValidException ex){
    	String error = HttpStatus.BAD_REQUEST.value()
    			+ " - "
    			+ ex.getBindingResult().getFieldError().getDefaultMessage();
    	return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}