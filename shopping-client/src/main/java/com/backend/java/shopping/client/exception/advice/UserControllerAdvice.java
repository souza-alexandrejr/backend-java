package com.backend.java.shopping.client.exception.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.backend.java.shopping.client.dto.ErrorDTO;
import com.backend.java.shopping.client.exception.UserNotFoundException;

@ControllerAdvice(
	basePackages = {
		"com.backend.java.user.api.controller", 
		"com.backend.java.product.api.controller", 
		"com.backend.java.shopping.api.controller"
})
public class UserControllerAdvice {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException) {
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("User not found!");
		errorDTO.setTimestamp(new Date());
		return errorDTO;
	}

}
