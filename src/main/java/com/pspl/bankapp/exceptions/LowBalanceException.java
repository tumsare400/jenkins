package com.pspl.bankapp.exceptions;

public class LowBalanceException extends Exception {

	private static final long serialVersionUID = 1L;

	public LowBalanceException() {

	}

	public LowBalanceException(String message) {
		super(message);
	}

}
