package com.backend.java.user.api.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.backend.java.user.api.dto.UserDTO;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String cpf;
	private String address;
	private String email;
	private String telephone;
	private Date dateRegistration;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
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
	
	public static User convert(UserDTO userApiDTO) {
		
		User user = new User();
		
		user.setName(userApiDTO.getName());
		user.setAddress(userApiDTO.getAddress());
		user.setCpf(userApiDTO.getCpf());
		user.setEmail(userApiDTO.getEmail());
		user.setTelephone(userApiDTO.getTelephone());
		user.setDateRegistration(userApiDTO.getDateRegistration());
		
		return user;
		
	}

}
