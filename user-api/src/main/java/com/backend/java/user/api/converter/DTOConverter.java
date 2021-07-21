package com.backend.java.user.api.converter;

import com.backend.java.user.api.dto.UserDTO;
import com.backend.java.user.api.model.User;

public class DTOConverter {

	public static UserDTO convert(User user) {
		UserDTO userApiDTO = new UserDTO();
		
		userApiDTO.setName(user.getName());
		userApiDTO.setAddress(user.getAddress());
		userApiDTO.setCpf(user.getCpf());
		userApiDTO.setEmail(user.getEmail());
		userApiDTO.setTelephone(user.getTelephone());
		userApiDTO.setDateRegistration(user.getDateRegistration());
		
		return userApiDTO;
	}
	
}
