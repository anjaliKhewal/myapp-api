package com.rest.api.controller;

public class AuthResponse {

	private int code;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AuthResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	
}
