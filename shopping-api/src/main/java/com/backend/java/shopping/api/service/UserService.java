package com.backend.java.shopping.api.service;

import com.backend.java.shopping.client.dto.UserDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	
	public UserDTO getUserByCpf(String cpf) {
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http//localhost:8080/users/" + cpf;
		
		ResponseEntity<UserDTO> response = restTemplate.getForEntity(url, UserDTO.class);
		
		return response.getBody();
		
	}

}
