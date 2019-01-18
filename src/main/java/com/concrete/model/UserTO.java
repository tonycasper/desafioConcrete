package com.concrete.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.concrete.model.Phone;

public class UserTO {

	private String name;

	private String email;

	private String password;

	private List<Phone> phones;

	@NotEmpty(message="O nome nao pode ser nulo")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotEmpty(message="O email nao pode ser nulo")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message="O password nao pode ser nulo")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
