package com.concrete.exception;

public class NotAuthorizedException extends RuntimeException{
	private static final long serialVersionUID = -1L;
	
	public NotAuthorizedException() {
		super("Não autorizado");
	}

	public NotAuthorizedException(String message) {
		super(message);
	}
}
