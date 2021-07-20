package com.backend.java.user.api.dto;

import java.util.Date;

import com.backend.java.user.api.model.User;

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

	public void setName(String name) {
		this.name = name;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public static UserDTO convert(User user) {
		UserDTO userApiDTO = new UserDTO();
		
		userApiDTO.setName(user.getName());
		userApiDTO.setAddress(user.getAddress());
		userApiDTO.setCpf(user.getCpf());
		userApiDTO.setEmail(user.getEmail());
		userApiDTO.setTelephone(user.getTelephone());
		userApiDTO.setDateRegistration(user.getDateRegistration());
		
		return userApiDTO;
	}
	
	private String address;
	private String cpf;
	private Date dateRegistration;
	private String email;
	private String name;
	private String telephone;
	
}
