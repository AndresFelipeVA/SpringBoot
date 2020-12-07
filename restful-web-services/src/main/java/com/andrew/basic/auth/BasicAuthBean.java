package com.andrew.basic.auth;

public class BasicAuthBean{
	
	private String message;

	public BasicAuthBean(String message) {
		this.setMessage(message);	
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BasicAuthBean [message=" + message + "]";
	}

}
