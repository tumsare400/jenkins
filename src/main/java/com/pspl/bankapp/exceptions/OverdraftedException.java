package com.pspl.bankapp.exceptions;

public class OverdraftedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OverdraftedException() {
	
	}

	public OverdraftedException(String message) {
		super(message);
	}
}
