package com.backend.java.user.api.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.java.shopping.client.dto.UserDTO;
import com.backend.java.user.api.service.UserService;

@RestController
public class UserController {

	@GetMapping("/")
	public String getMessage() {
		return "User API Project";
	}

	@GetMapping("/users")
	public List<UserDTO> getUsers() {
		List<UserDTO> users = userService.getAll();
		return users;
	}

	@GetMapping("/users/{cpf}")
//	@GetMapping("/users/{cpf}?key={key}")
	public UserDTO getUserByCpf(
			@RequestParam(name="key", required = true) String key,
			@PathVariable String cpf) {
		return userService.findByCpfAndKey(cpf, key);
	}

	@GetMapping("/users/search")
	public List<UserDTO> queryByName(@RequestParam(name = "name", required = true) String name) {
		return userService.queryByName(name);
	}

	@PostMapping("/users")
	public UserDTO insertUser(@RequestBody UserDTO userApiDTO) {
		userApiDTO.setDateRegistration(new Date());
		return userService.save(userApiDTO);
	}

	@PutMapping("/users/{cpf}")
	public UserDTO updateUserByCpf(
			@RequestParam(name="key", required = true) String key,
			@PathVariable String cpf, @RequestBody UserDTO userApiDTO) {
		UserDTO user = userService.findByCpfAndKey(cpf, key);
		
		if (user != null) {
			user.setName(userApiDTO.getName());
			user.setCpf(userApiDTO.getCpf());
			user.setAddress(userApiDTO.getAddress());
			user.setEmail(userApiDTO.getEmail());
			user.setTelephone(userApiDTO.getTelephone());
			user.setDateRegistration(new Date());
	
			userService.update(user);
		}
		
		return user;
	}

	@DeleteMapping("/users/{cpf}")
	public void removeUserByCpf(
			@RequestParam(name="key", required = true) String key,
			@PathVariable String cpf) {
		UserDTO user = userService.findByCpfAndKey(cpf, key);
		
		if (user != null) {
			userService.delete(user);
		}
	}
	
	@Autowired
	private UserService userService;

}
