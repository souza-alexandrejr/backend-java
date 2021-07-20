package com.backend.java.user.api.dto;

import java.util.Date;

import com.backend.java.user.api.model.User;

public class UserDTO {
	
	private String name;
	private String cpf;
	private String address;
	private String email;
	private String telephone;
	private Date dateRegistration;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Date getDateRegistration() {
		return dateRegistration;
	}
	
	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
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
}
