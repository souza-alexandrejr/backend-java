package com.backend.java.user.api.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.java.user.api.dto.UserDTO;
import com.backend.java.user.api.model.User;
import com.backend.java.user.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> getAll() {
		List<User> usuarios = userRepository.findAll();
		return usuarios
				.stream()
				.map(UserDTO::convert)
				.collect(Collectors.toList());
	}
	
	public UserDTO save(UserDTO userApiDTO) {
		User user = userRepository.save(User.convert(userApiDTO));
		
		return UserDTO.convert(user);
	}
	
	public UserDTO update(UserDTO userApiDTO) {
		User user = userRepository.findByCpf(userApiDTO.getCpf());

		if (user != null) {
			user.setName(userApiDTO.getName());
			user.setCpf(userApiDTO.getCpf());
			user.setAddress(userApiDTO.getAddress());
			user.setEmail(userApiDTO.getEmail());
			user.setTelephone(userApiDTO.getTelephone());
			user.setDateRegistration(new Date());
			
			userRepository.save(user);
		}
		
		return UserDTO.convert(user);
	}
	
	public void delete(UserDTO userApiDTO) {
		User user = userRepository.findByCpf(userApiDTO.getCpf());
		
		if (user != null) {
			userRepository.delete(user);
		}
	}
	
	public UserDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		
		if (user != null) {
			return UserDTO.convert(user);
		}

		return null;
	}
	
	public List<UserDTO> queryByName(String name) {
		List<User> users = userRepository.queryByNameLike(name);
		
		return users
				.stream()
				.map(UserDTO::convert)
				.collect(Collectors.toList());
	}
	
}
