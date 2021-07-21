package com.backend.java.shopping.client.dto;

import java.util.Date;

public class ErrorDTO {
	
	public String getMessage() {
		return message;
	}
	
	public int getStatus() {
		return status;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	private String message;
	private int status;
	private Date timestamp;

}
