package com.backend.java.user.api.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.java.shopping.client.dto.UserDTO;
import com.backend.java.shopping.client.exception.UserNotFoundException;
import com.backend.java.user.api.converter.DTOConverter;
import com.backend.java.user.api.model.User;
import com.backend.java.user.api.repository.UserRepository;

@Service
public class UserService {
	
	public List<UserDTO> getAll() {
		List<User> usuarios = userRepository.findAll();
		return usuarios
				.stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	public UserDTO save(UserDTO userApiDTO) {
		userApiDTO.setKey(UUID.randomUUID().toString());
		
		User user = userRepository.save(User.convert(userApiDTO));
		
		return DTOConverter.convert(user);
	}
	
	public UserDTO update(UserDTO userApiDTO) {
		User user = userRepository.findByCpfAndKey(userApiDTO.getCpf(), userApiDTO.getKey());

		if (user != null) {
			user.setName(userApiDTO.getName());
			user.setCpf(userApiDTO.getCpf());
			user.setAddress(userApiDTO.getAddress());
			user.setEmail(userApiDTO.getEmail());
			user.setTelephone(userApiDTO.getTelephone());
			user.setDateRegistration(new Date());
			
			userRepository.save(user);
		}
		
		return DTOConverter.convert(user);
	}
	
	public void delete(UserDTO userApiDTO) {
		User user = userRepository.findByCpfAndKey(userApiDTO.getCpf(), userApiDTO.getKey());
		
		if (user != null) {
			userRepository.delete(user);
		}
	}
	
	public UserDTO findByCpfAndKey(String cpf, String key) {
		User user = userRepository.findByCpfAndKey(cpf, key);
		
		if (user != null) {
			return DTOConverter.convert(user);
		}
		throw new UserNotFoundException();
	}
	
	public List<UserDTO> queryByName(String name) {
		List<User> users = userRepository.queryByNameLike(name);
		
		return users
				.stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}
	
	@Autowired
	private UserRepository userRepository;
	
}
