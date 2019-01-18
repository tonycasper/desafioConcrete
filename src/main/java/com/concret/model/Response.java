package com.concret.model;

import java.util.ArrayList;

public class Response<Tr> {
	
	private Tr response;
	private ArrayList<String> errors;

	public Tr getResponse() {
		return response;
	}
	public void setResponse(Tr re) {
		this.response = re; 
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
