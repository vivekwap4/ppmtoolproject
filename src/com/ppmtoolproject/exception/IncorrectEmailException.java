package com.ppmtoolproject.exception;

public class IncorrectEmailException extends RuntimeException{
	public IncorrectEmailException(String errorMessage) {
		super(errorMessage);
	}
}
