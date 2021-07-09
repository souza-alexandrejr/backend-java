package com.backend.java.user.api.service;

import java.util.Date;
import java.util.List;
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
	
	public UserApiDTO save(UserApiDTO userApiDTO) {
		User user = userRepository.save(User.convert(userApiDTO));
		
		return UserApiDTO.convert(user);
	}
	
	public UserApiDTO update(UserApiDTO userApiDTO) {
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
		
		return UserApiDTO.convert(user);
	}
	
	public void delete(UserApiDTO userApiDTO) {
		User user = userRepository.findByCpf(userApiDTO.getCpf());
		
		if (user != null) {
			userRepository.delete(user);
		}
	}
	
	public UserApiDTO findByCpf(String cpf) {
		User user = userRepository.findByCpf(cpf);
		
		if (user != null) {
			return UserApiDTO.convert(user);
		}

		return null;
	}
	
	public List<UserApiDTO> queryByName(String name) {
		List<User> users = userRepository.queryByNameLike(name);
		
		return users
				.stream()
				.map(UserApiDTO::convert)
				.collect(Collectors.toList());
	}
	
}
