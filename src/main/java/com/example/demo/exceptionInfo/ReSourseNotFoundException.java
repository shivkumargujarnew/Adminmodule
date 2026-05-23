package com.example.demo.exceptionInfo;

public class ReSourseNotFoundException extends RuntimeException{

	
	   String msg;

	public ReSourseNotFoundException(String msg) {
		super(msg);
	}
	   
	   
}
