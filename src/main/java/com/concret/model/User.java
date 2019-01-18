package com.concret.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {
	
	private int id;
	
	private String name;
	
	private String password;
	
	private LocalDateTime created;
	
	private LocalDateTime last_login;
	
	private String token;
	
	private ArrayList<Phone> phone;
	
	private TypeProfileEnum typeProfileEnum;
	
	public User() {			
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getLast_login() {
		return last_login;
	}

	public void setLast_login(LocalDateTime last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ArrayList<Phone> getPhone() {
		return phone;
	}

	public void setPhone(ArrayList<Phone> phone) {
		this.phone = phone;
	}

	public TypeProfileEnum getTypeProfileEnum() {
		return typeProfileEnum;
	}

	public void setTypeProfileEnum(TypeProfileEnum typeProfileEnum) {
		this.typeProfileEnum = typeProfileEnum;
	}

}
