package com.concret.model;

import java.util.ArrayList;

public class Response<Tr> {
	
	private Tr responseError;
	private ArrayList<String> errors;

	public Tr getResponseError() {
		return responseError;
	}
	public void setResponseError(Tr re) {
		this.responseError = re; 
	}
	public ArrayList<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}
	public void setResponseError(ArrayList<String> erros ) {
		this.errors = errors;
	}
	
}
