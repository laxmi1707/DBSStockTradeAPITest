package com.hackerrank.stocktrade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.hackerrank.stocktrade.exception.BadRequestException;
import com.hackerrank.stocktrade.exception.NotFoundException;


@Controller
@RestControllerAdvice
public class StockExceptionHandler {

	@ExceptionHandler(value ={BadRequestException.class})
	public ResponseEntity<?> exceptionHandle(BadRequestException ex, WebRequest request){
		 return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);	 
	       
	}
	
	@ExceptionHandler(value ={ NotFoundException.class})
	public ResponseEntity<?> exceptionHandle(NotFoundException ex, WebRequest request){
		 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);	 
	       
	}
	
	
	public StockExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

}
