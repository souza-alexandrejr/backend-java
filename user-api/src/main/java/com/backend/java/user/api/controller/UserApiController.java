package com.backend.java.user.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.java.user.api.dto.UserApiDTO;

@RestController
public class UserApiController {
	
	public static List<UserApiDTO> users = new ArrayList<UserApiDTO>();
	
	@PostConstruct
	public void initiateList() {
		
		UserApiDTO user1 = new UserApiDTO();
		user1.setName("Eduardo");
		user1.setCpf("12345678900");
		user1.setAddress("Street A");
		user1.setEmail("eduardo@email.com");
		user1.setTelephone("99876-5432");
		user1.setDateRegistration(new Date());
		
		UserApiDTO user2 = new UserApiDTO();
		user2.setName("Luiz");
		user2.setCpf("45678900123");
		user2.setAddress("Street B");
		user2.setEmail("luiz@email.com");
		user2.setTelephone("99876-5432");
		user2.setDateRegistration(new Date());
		
		UserApiDTO user3 = new UserApiDTO();
		user3.setName("Bruna");
		user3.setCpf("78900123456");
		user3.setAddress("Street C");
		user3.setEmail("bruna@email.com");
		user3.setTelephone("99876-5432");
		user3.setDateRegistration(new Date());
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
	}
	
	@GetMapping("/")
	public String getMessage() {
		return "Spring boot is working!";
	}
	
	@GetMapping("/users")
	public List<UserApiDTO> getUsers() {
		return users;
	}
	
	@GetMapping("/users/{cpf}")
	public UserApiDTO getUserByCpf(@PathVariable String cpf) {
		
		for (UserApiDTO user : users) {
			if (user.getCpf().equals(cpf)) {
				return user;
			}
		}
		
		return null;
	}
	
	@PostMapping("/users")
	public UserApiDTO insertUser(@RequestBody UserApiDTO body) {
		
		body.setDateRegistration(new Date());
		users.add(body);
		
		return body;
		
	}
	
	@PutMapping("/users")
	public UserApiDTO updateUser(@RequestBody UserApiDTO body) {
		
		for (UserApiDTO user : users) {
			if (user.getCpf().equals(body.getCpf())) {
				user.setName(body.getName());
				user.setCpf(body.getCpf());
				user.setAddress(body.getAddress());
				user.setEmail(body.getEmail());
				user.setTelephone(body.getTelephone());
				user.setDateRegistration(new Date());
				
				return user;
			}
		}
		
		return null;
		
	}
	
	@DeleteMapping("/users/{cpf}")
	public boolean removeUserByCpf(@PathVariable String cpf) {
		
		for (UserApiDTO user : users) {
			if (user.getCpf().equals(cpf)) {
				users.remove(user);
				
				return true;
			}
		}
		
		return false;
	}
	
}
