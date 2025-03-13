package com.sample.coinchange.exception;

public class InvalidBillAmountException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InvalidBillAmountException(String message) {
		super(message);
	}

}
