package com.backend.java.user.api.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.backend.java.user.api.dto.UserDTO;

@Entity
public class User {
	
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
	
	public long getId() {
		return id;
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

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	
	private String address;
	private String cpf;
	private Date dateRegistration;
	private String email;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String telephone;
	
}
