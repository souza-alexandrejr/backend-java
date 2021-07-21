package com.backend.java.shopping.client.dto;

import java.util.Date;

public class UserDTO {
	
	public String getAddress() {
		return address;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public Date getDateRegistration() {
		return dateRegistration;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setKey(String key) {
		this.key = key;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	private String address;
	private String cpf;
	private Date dateRegistration;
	private String email;
	private String key;
	private String name;
	private String telephone;
	
}
