package com.ppmtoolproject.exception;

public class PasswordMismatchException extends Exception{
	
	public PasswordMismatchException(String errorMessage) {
        super(errorMessage);        
    }
	
}
