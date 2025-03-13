package com.sample.coinchange.exception;

public class InsufficientCoinsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InsufficientCoinsException(String message) {
        super(message);
    }
}
