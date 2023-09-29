package com.booklog.review.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ReviewAdvice {

	@ExceptionHandler(Exception.class)
	public Object handleGeneralException(Exception e){
		log.info("occur general exception", e);
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullPointerException.class)
	public Object handleNullPointerException(Exception e){
		log.info("occur null point exception", e);
		return new ResponseEntity<>("null pointer exception", HttpStatus.BAD_REQUEST);
	}
}