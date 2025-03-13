package com.sample.coinchange.exception;

public class CoinNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public CoinNotFoundException(String message) {
		super(message);
	}

}
