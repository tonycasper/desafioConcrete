package com.concret.exception;

public class NotAuthorizedException extends RuntimeException{
	private static final long serialVersionUID = -1L;
	
	public NotAuthorizedException() {
		super("N�o autorizado");
	}

	public NotAuthorizedException(String message) {
		super(message);
	}
}
