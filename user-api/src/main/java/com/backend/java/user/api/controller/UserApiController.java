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
import com.backend.java.user.api.dto.UserApiDTO;
import com.backend.java.user.api.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getMessage() {
		return "User API Project";
	}

	@GetMapping("/users")
	public List<UserApiDTO> getUsers() {
		List<UserApiDTO> users = userService.getAll();
		return users;
	}

	@GetMapping("/users/{cpf}")
	public UserApiDTO getUserByCpf(@PathVariable String cpf) {
		return userService.findByCpf(cpf);
	}

	@GetMapping("/users/search")
	public List<UserApiDTO> queryByName(@RequestParam(name = "name", required = true) String name) {
		return userService.queryByName(name);
	}

	@PostMapping("/users")
	public UserApiDTO insertUser(@RequestBody UserApiDTO userApiDTO) {
		userApiDTO.setDateRegistration(new Date());
		return userService.save(userApiDTO);
	}

	@PutMapping("/users/{cpf}")
	public UserApiDTO updateUserByCpf(@PathVariable String cpf, @RequestBody UserApiDTO userApiDTO) {
		UserApiDTO user = userService.findByCpf(cpf);
		
		user.setName(userApiDTO.getName());
		user.setCpf(userApiDTO.getCpf());
		user.setAddress(userApiDTO.getAddress());
		user.setEmail(userApiDTO.getEmail());
		user.setTelephone(userApiDTO.getTelephone());
		user.setDateRegistration(new Date());

		userService.update(user);
		
		return user;
	}

	@DeleteMapping("/users/{cpf}")
	public UserApiDTO removeUserByCpf(@PathVariable String cpf) {
		UserApiDTO user = userService.findByCpf(cpf);
		
		return userService.delete(user);
	}

}
