package com.casestudy.exception;

public class CategoryNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public  CategoryNotFoundException(String message) {
		
		
		this.message=message;
	}
	
	public CategoryNotFoundException() {
		
	}
}
