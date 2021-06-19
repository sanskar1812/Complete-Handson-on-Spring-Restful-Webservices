package com.cognizant.truyum.exception;

public class CartEmptyException extends Exception {

	private static final long serialVersionUID = 1L;

	public CartEmptyException(String status) {
		super(status);
	}

}