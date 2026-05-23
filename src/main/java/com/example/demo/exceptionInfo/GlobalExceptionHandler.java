package com.example.demo.exceptionInfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler(value=ReSourseNotFoundException.class)
	  public ProblemDetail handleCitizenNotFound(ReSourseNotFoundException ex) {
	 return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
	  }
	  
	  @ExceptionHandler(Exception.class)
	    public ProblemDetail handleGlobalException(Exception ex) {

	        ProblemDetail problemDetail =
	                ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

	        problemDetail.setTitle("Internal Server Error");
	        problemDetail.setDetail(ex.getMessage());

	        return problemDetail;
	    }
}
