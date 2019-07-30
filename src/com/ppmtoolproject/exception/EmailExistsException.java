package com.ppmtoolproject.exception;

public class EmailExistsException extends RuntimeException{
	public EmailExistsException(String errorMessage) {
		super(errorMessage);
	}
}
