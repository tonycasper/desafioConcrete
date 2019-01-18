package com.concrete.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginTO {
	private String email;

	private String password;

	@NotEmpty(message = "O email nao pode ser nulo")
	@Email(message = "Email Invalido")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "A senha nao pode ser nula")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
