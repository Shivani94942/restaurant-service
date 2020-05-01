package com.restaurant.error;

import java.time.LocalDateTime;

public class ErrorMessage {
	
	private String message;
	private int status;
	private LocalDateTime errorTime;
	public ErrorMessage(String message, int status, LocalDateTime errorTime) {
		super();
		this.message = message;
		this.status = status;
		this.errorTime = errorTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LocalDateTime getErrorTime() {
		return errorTime;
	}
	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}
	public ErrorMessage() {
		super();
	}
	
	
	

}
