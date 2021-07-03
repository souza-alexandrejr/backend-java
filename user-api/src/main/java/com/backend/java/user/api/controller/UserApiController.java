package com.backend.java.user.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
	
	@GetMapping("/")
	public String getMessage() {
		return "Spring boot is working!";
	}

}
