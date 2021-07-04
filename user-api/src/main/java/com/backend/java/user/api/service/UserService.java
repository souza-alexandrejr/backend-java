package com.backend.java.user.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.java.user.api.dto.UserApiDTO;
import com.backend.java.user.api.model.User;
import com.backend.java.user.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserApiDTO> getAll() {
		List<User> usuarios = userRepository.findAll();
		return usuarios
				.stream()
				.map(UserApiDTO::convert)
				.collect(Collectors.toList());
	}
	
	public UserApiDTO findById(long userId) {
		Optional<User> user = userRepository.findById(userId);
		
		if (user.isPresent()) {
			return UserApiDTO.convert(user.get());
		}
		
		return null;
	}
	
	public UserApiDTO save(UserApiDTO userApiDTO) {
		User user = userRepository.save(User.convert(userApiDTO));
		
		return UserApiDTO.convert(user);
	}
	
	public UserApiDTO delete(long userId) {
		Optional<User> user = userRepository.findById(userId);
		
		if (user.isPresent()) {
			userRepository.delete(user.get());
		}
		
		return null;
	}
	
	private UserApiDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		
		if (user != null) {
			return UserApiDTO.convert(user);
		}

		return null;
	}
	
	private List<UserApiDTO> queryByName(String name) {
		List<User> users = userRepository.queryByNameLike(name);
		
		return users
				.stream()
				.map(UserApiDTO::convert)
				.collect(Collectors.toList());
	}
	
}
