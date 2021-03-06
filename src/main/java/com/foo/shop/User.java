package com.foo.shop;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String creditCardNo;
	
	
	
	public User(String username, String password, String creditCardNo) {
		super();
		this.username = username;
		this.password = password;
		this.creditCardNo = creditCardNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreditCardNo() {
		return creditCardNo;
	}
	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}
}
