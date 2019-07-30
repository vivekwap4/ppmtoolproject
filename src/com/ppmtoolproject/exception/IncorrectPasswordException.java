package com.ppmtoolproject.exception;

public class IncorrectPasswordException extends Exception {
	public IncorrectPasswordException(String errMsg) {
		super(errMsg);
	}
}
